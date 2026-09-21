package com.diabetescompanion.auth;

/** Local form feedback only. This class does not authenticate or save anything. */
public final class FormValidator {
    private FormValidator() {}

    public static String nameError(String value) {
        return value.trim().isEmpty() ? "Enter your full name." : null;
    }

    public static String emailError(String value) {
        String email = value.trim();
        if (email.isEmpty()) return "Enter your email address.";
        // Deliberately lightweight format validation, not proof the address exists.
        if (!email.matches("^[^\\s@]+@[^\\s@.]+(?:\\.[^\\s@.]+)+$")) {
            return "Enter a valid email address.";
        }
        return null;
    }

    public static String passwordError(String value, boolean signingUp) {
        if (value.isEmpty()) return "Enter your password.";
        if (signingUp && value.length() < 8) return "Use at least 8 characters.";
        if (signingUp && value.trim().isEmpty()) return "Password cannot contain only spaces.";
        return null;
    }

    public static String confirmationError(String password, String confirmation) {
        if (confirmation.isEmpty()) return "Confirm your password.";
        return password.equals(confirmation) ? null : "Passwords do not match.";
    }
}
