package com.diabetescompanion.auth;

public final class FormValidatorTest {
    private static int count;
    private static void check(boolean condition, String description) {
        count++;
        if (!condition) throw new AssertionError(description);
    }
    public static void main(String[] args) {
        check(FormValidator.nameError("") != null, "Empty name rejected");
        check(FormValidator.nameError("   ") != null, "Whitespace name rejected");
        check(FormValidator.nameError("Norah") == null, "Single name supported");
        check(FormValidator.nameError("نورة الشيخ") == null, "Arabic name supported");
        check(FormValidator.emailError("") != null, "Empty email rejected");
        check(FormValidator.emailError("name") != null, "Missing at sign rejected");
        check(FormValidator.emailError("a@b") != null, "Missing domain suffix rejected");
        check(FormValidator.emailError("a b@example.com") != null, "Embedded space rejected");
        check(FormValidator.emailError("a@@example.com") != null, "Duplicate at rejected");
        check(FormValidator.emailError(" demo@example.com ") == null, "Edge spaces trimmed");
        check(FormValidator.emailError("name+demo@example.co.uk") == null, "Plus address supported");
        check(FormValidator.passwordError("", false) != null, "Empty login password rejected");
        check(FormValidator.passwordError("short", false) == null, "Login does not impose sign-up policy");
        check(FormValidator.passwordError("1234567", true) != null, "Short signup rejected");
        check(FormValidator.passwordError("Demo12345", true) == null, "Valid signup password");
        check(FormValidator.passwordError("        ", true) != null, "Whitespace-only password rejected");
        check(FormValidator.confirmationError("Demo12345", "") != null, "Empty confirmation rejected");
        check(FormValidator.confirmationError("Demo12345", "demo12345") != null, "Case-sensitive confirmation");
        check(FormValidator.confirmationError("Demo12345", "Demo12345") == null, "Matching confirmation");
        System.out.println("PASS: " + count + " validation checks");
    }
}
