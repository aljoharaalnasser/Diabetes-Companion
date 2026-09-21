package com.diabetescompanion.auth;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.io.File;
import java.io.FileOutputStream;

/** Dependency-free on-device smoke checks. Run via connectedDebugAndroidTest or adb am instrument. */
public final class AuthSmokeTest extends Instrumentation {
    private Activity activity;
    private int assertions;

    @Override public void onCreate(Bundle arguments) { super.onCreate(arguments); start(); }

    @Override public void onStart() {
        Bundle result = new Bundle();
        try {
            Intent intent = new Intent(getTargetContext(), AuthActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity = startActivitySync(intent);
            waitForIdleSync();
            int[] ids = {R.id.role_patient, R.id.role_doctor, R.id.role_caregiver, R.id.role_admin};
            String[] names = {"patient", "doctor", "caregiver", "admin"};
            for (int screen = 0; screen < 2; screen++) {
                final boolean signup = screen == 0;
                for (int i = 0; i < ids.length; i++) {
                    final int role = ids[i];
                    if (signup && role == R.id.role_admin) {
                        runOnMainSync(() -> {
                            check(activity.findViewById(R.id.role_admin).getVisibility() == View.GONE, "Admin hidden on signup");
                        });
                        continue;
                    }
                    runOnMainSync(() -> {
                        ((RadioGroup) activity.findViewById(R.id.roles)).check(role);
                        check(((RadioGroup) activity.findViewById(R.id.roles)).getCheckedRadioButtonId() == role, "Role selection");
                        check(activity.findViewById(R.id.name_row).getVisibility() == (signup ? View.VISIBLE : View.GONE), "Name visibility");
                        check(activity.findViewById(R.id.confirm_row).getVisibility() == (signup ? View.VISIBLE : View.GONE), "Confirmation visibility");
                        check(((TextView) activity.findViewById(R.id.submit)).getText().toString().equals(signup ? "Create account" : "Sign in"), "Submit label");
                    });
                    waitForIdleSync();
                    screenshot((signup ? "signup-" : "login-") + names[i]);
                }
                if (signup) {
                    runOnMainSync(() -> activity.findViewById(R.id.switch_mode).performClick());
                    waitForIdleSync();
                }
            }
            runOnMainSync(() -> {
                activity.findViewById(R.id.submit).performClick();
                check(activity.findViewById(R.id.email_error).getVisibility() == View.VISIBLE, "Empty email feedback");
                check(activity.findViewById(R.id.password_error).getVisibility() == View.VISIBLE, "Empty password feedback");
                EditText pw = activity.findViewById(R.id.password_input);
                pw.setText("Demo12345");
                check(activity.findViewById(R.id.password_error).getVisibility() == View.GONE, "Editing clears feedback");
                activity.findViewById(R.id.password_toggle).performClick();
                check(!(pw.getTransformationMethod() instanceof PasswordTransformationMethod), "Reveal password");
                activity.findViewById(R.id.password_toggle).performClick();
                check(pw.getTransformationMethod() instanceof PasswordTransformationMethod, "Hide password");
                activity.findViewById(R.id.switch_mode).performClick();
                check(pw.length() == 0, "Screen switch clears password");
                ((EditText) activity.findViewById(R.id.name_input)).setText("Demo Patient");
                ((EditText) activity.findViewById(R.id.email_input)).setText("demo@example.com");
                pw.setText("Demo12345");
                ((EditText) activity.findViewById(R.id.confirm_input)).setText("different");
                activity.findViewById(R.id.submit).performClick();
                check(activity.findViewById(R.id.confirm_error).getVisibility() == View.VISIBLE, "Mismatch feedback");
                ((EditText) activity.findViewById(R.id.confirm_input)).setText("Demo12345");
                activity.findViewById(R.id.submit).performClick();
                check(activity.findViewById(R.id.confirm_error).getVisibility() == View.GONE, "Valid confirmation");
                check(pw.length() == 0, "Submit clears password");
            });
            waitForIdleSync();
            screenshot("valid-form-preview");
            result.putString("stream", "\nPASS: " + assertions + " Android UI assertions; 8 role/screen screenshots and submit preview.\n");
            finish(Activity.RESULT_OK, result);
        } catch (Throwable error) {
            result.putString("stream", "FAIL: " + error.toString());
            finish(Activity.RESULT_CANCELED, result);
        }
    }

    private void check(boolean condition, String description) {
        assertions++;
        if (!condition) throw new AssertionError(description);
    }

    private void screenshot(String name) throws Exception {
        File folder = new File(getTargetContext().getExternalFilesDir(null), "screenshots");
        if (!folder.exists() && !folder.mkdirs()) throw new IllegalStateException("Screenshot folder unavailable");
        Bitmap bitmap = getUiAutomation().takeScreenshot();
        if (bitmap == null) throw new IllegalStateException("Screenshot unavailable");
        try (FileOutputStream output = new FileOutputStream(new File(folder, name + ".png"))) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
        }
        bitmap.recycle();
    }
}
