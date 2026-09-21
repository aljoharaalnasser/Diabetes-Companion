package com.diabetescompanion.auth;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Insets;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowInsets;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/** Standalone evaluation UI. No accounts, network requests, storage, or integration. */
public class AuthActivity extends Activity {
    private boolean signingUp = true;
    private int selectedRole = R.id.role_patient;
    private EditText name, email, password, confirmation;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        if (state != null) {
            signingUp = state.getBoolean("signup", true);
            selectedRole = state.getInt("role", R.id.role_patient);
        }
        setContentView(R.layout.activity_auth);
        configureInsets();
        name = findViewById(R.id.name_input);
        email = findViewById(R.id.email_input);
        password = findViewById(R.id.password_input);
        confirmation = findViewById(R.id.confirm_input);

        bindField(name, R.id.name_row, R.id.name_error);
        bindField(email, R.id.email_row, R.id.email_error);
        bindField(password, R.id.password_row, R.id.password_error);
        bindField(confirmation, R.id.confirm_row, R.id.confirm_error);
        bindPasswordToggle(password, R.id.password_toggle, false);
        bindPasswordToggle(confirmation, R.id.confirm_toggle, true);

        RadioGroup roles = findViewById(R.id.roles);
        roles.check(selectedRole);
        roles.setOnCheckedChangeListener((group, checkedId) -> {
            selectedRole = checkedId;
        });
        findViewById(R.id.switch_mode).setOnClickListener(v -> changeScreen());
        findViewById(R.id.back).setOnClickListener(v -> changeScreen());
        findViewById(R.id.submit).setOnClickListener(v -> submitForm());
        findViewById(R.id.forgot).setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle("Password reset preview")
                .setMessage("Password reset is not connected in this evaluation build. No email will be sent.")
                .setPositiveButton("Got it", null).show());
        password.setOnEditorActionListener((v, action, event) -> {
            if (!signingUp && action == EditorInfo.IME_ACTION_DONE) { submitForm(); return true; }
            return false;
        });
        confirmation.setOnEditorActionListener((v, action, event) -> {
            if (action == EditorInfo.IME_ACTION_DONE) { submitForm(); return true; }
            return false;
        });
        showScreen();
    }

    private void configureInsets() {
        View root = findViewById(R.id.root);
        // Android 15+ enforces edge-to-edge. Keep form controls outside system bars/keyboard.
        if (Build.VERSION.SDK_INT >= 30) {
            getWindow().setDecorFitsSystemWindows(false);
            root.setOnApplyWindowInsetsListener((view, insets) -> {
                Insets bars = insets.getInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
                Insets keyboard = insets.getInsets(WindowInsets.Type.ime());
                view.setPadding(bars.left, bars.top, bars.right, Math.max(bars.bottom, keyboard.bottom));
                return insets;
            });
        } else {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        }
        // Keep the phone composition comfortably narrow on tablets or landscape screens.
        root.addOnLayoutChangeListener((v, l, t, r, b, ol, ot, or, ob) -> {
            View content = findViewById(R.id.content);
            int extra = Math.max(0, (r - l - dp(480)) / 2);
            content.setPadding(dp(20) + extra, 0, dp(20) + extra, dp(20));
        });
    }

    private int dp(int value) { return Math.round(value * getResources().getDisplayMetrics().density); }

    private void bindField(EditText field, int rowId, int errorId) {
        field.setOnFocusChangeListener((v, focused) -> findViewById(rowId).setSelected(focused));
        field.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                displayError(rowId, errorId, null);
            }
            @Override public void afterTextChanged(Editable value) {}
        });
    }

    private void bindPasswordToggle(EditText field, int buttonId, boolean confirm) {
        ImageButton toggle = findViewById(buttonId);
        toggle.setOnClickListener(v -> {
            boolean reveal = field.getTransformationMethod() instanceof PasswordTransformationMethod;
            int position = Math.max(0, field.getSelectionStart());
            field.setTransformationMethod(reveal ? HideReturnsTransformationMethod.getInstance()
                    : PasswordTransformationMethod.getInstance());
            field.setSelection(Math.min(position, field.length()));
            toggle.setImageResource(reveal ? R.drawable.ic_eye_off : R.drawable.ic_eye);
            toggle.setContentDescription(getString(confirm
                    ? (reveal ? R.string.hide_confirmation : R.string.show_confirmation)
                    : (reveal ? R.string.hide_password : R.string.show_password)));
        });
    }

    private void changeScreen() {
        hideKeyboard();
        signingUp = !signingUp;
        name.setText(""); email.setText(""); password.setText(""); confirmation.setText("");
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        confirmation.setTransformationMethod(PasswordTransformationMethod.getInstance());
        ((ImageButton) findViewById(R.id.password_toggle)).setImageResource(R.drawable.ic_eye);
        ((ImageButton) findViewById(R.id.confirm_toggle)).setImageResource(R.drawable.ic_eye);
        findViewById(R.id.password_toggle).setContentDescription(getString(R.string.show_password));
        findViewById(R.id.confirm_toggle).setContentDescription(getString(R.string.show_confirmation));
        showScreen();
        findViewById(R.id.content).requestFocus();
        ((android.widget.ScrollView) findViewById(R.id.scroll)).smoothScrollTo(0, 0);
    }

    private void showScreen() {
        ((TextView) findViewById(R.id.title)).setText(signingUp ? R.string.signup_title : R.string.login_title);
        ((TextView) findViewById(R.id.subtitle)).setText(signingUp ? R.string.signup_subtitle : R.string.login_subtitle);
        findViewById(R.id.name_row).setVisibility(signingUp ? View.VISIBLE : View.GONE);
        findViewById(R.id.confirm_row).setVisibility(signingUp ? View.VISIBLE : View.GONE);
        findViewById(R.id.role_admin).setVisibility(signingUp ? View.GONE : View.VISIBLE);
        if (signingUp && selectedRole == R.id.role_admin) {
            selectedRole = R.id.role_patient;
            ((RadioGroup) findViewById(R.id.roles)).check(selectedRole);
        }
        findViewById(R.id.forgot).setVisibility(signingUp ? View.GONE : View.VISIBLE);
        ((TextView) findViewById(R.id.submit)).setText(signingUp ? R.string.create_account : R.string.sign_in);
        ((TextView) findViewById(R.id.notice)).setText(signingUp ? R.string.terms : R.string.login_note);
        ((TextView) findViewById(R.id.switch_prompt)).setText(signingUp ? R.string.already_account : R.string.no_account);
        ((TextView) findViewById(R.id.switch_mode)).setText(signingUp ? R.string.sign_in : R.string.sign_up);
        findViewById(R.id.back).setContentDescription(getString(signingUp ? R.string.back : R.string.back_signup));
        password.setImeOptions(signingUp ? EditorInfo.IME_ACTION_NEXT : EditorInfo.IME_ACTION_DONE);
        clearErrors();
    }


    private void clearErrors() {
        displayError(R.id.name_row, R.id.name_error, null);
        displayError(R.id.email_row, R.id.email_error, null);
        displayError(R.id.password_row, R.id.password_error, null);
        displayError(R.id.confirm_row, R.id.confirm_error, null);
    }

    private void displayError(int rowId, int errorId, String message) {
        TextView label = findViewById(errorId);
        label.setText(message == null ? "" : message);
        label.setVisibility(message == null ? View.GONE : View.VISIBLE);
        findViewById(rowId).setActivated(message != null);
    }

    private void submitForm() {
        String n = signingUp ? FormValidator.nameError(name.getText().toString()) : null;
        String e = FormValidator.emailError(email.getText().toString());
        String p = FormValidator.passwordError(password.getText().toString(), signingUp);
        String c = signingUp ? FormValidator.confirmationError(password.getText().toString(), confirmation.getText().toString()) : null;
        displayError(R.id.name_row, R.id.name_error, n);
        displayError(R.id.email_row, R.id.email_error, e);
        displayError(R.id.password_row, R.id.password_error, p);
        displayError(R.id.confirm_row, R.id.confirm_error, c);
        if (n != null || e != null || p != null || c != null) {
            EditText first = n != null ? name : e != null ? email : p != null ? password : confirmation;
            first.requestFocus();
            first.announceForAccessibility(n != null ? n : e != null ? e : p != null ? p : c);
            return;
        }
        hideKeyboard();
        String role = ((RadioButton) findViewById(selectedRole)).getText().toString();
        new AlertDialog.Builder(this)
                .setTitle(role + (signingUp ? " sign-up" : " sign-in"))
                .setMessage("Success! You have logged in as a " + role.toLowerCase(java.util.Locale.ROOT) + ".")
                .setPositiveButton("OK", null).show();
        // Credentials need not remain in memory after demonstrating the submit action.
        password.setText(""); confirmation.setText("");
    }

    private void hideKeyboard() {
        InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(findViewById(R.id.root).getWindowToken(), 0);
    }

    @Override protected void onSaveInstanceState(Bundle state) {
        state.putBoolean("signup", signingUp);
        state.putInt("role", selectedRole);
        super.onSaveInstanceState(state);
    }
}
