# Diabetes Companion Authentication Screens

Standalone Android Studio project for the first UI evaluation. It recreates the supplied sign-up design and adds a matching login screen. Patient, Doctor, Caregiver, and Admin are available on both screens.

## Open and run

1. Extract the ZIP completely. Do not open the project inside the ZIP.
2. In Android Studio, choose **Open** and select the **DiabetesCompanionAuth** folder containing `settings.gradle`.
3. Let Gradle sync finish. The first sync needs internet to download build tools. Accept Android Studio's prompts to install Android SDK Platform 35 and Build Tools 36.0.0 if needed.
4. Select Android Studio's **Embedded JDK** in Settings → Build, Execution, Deployment → Build Tools → Gradle. JDK 17 or 21 works with this pinned build.
5. Choose an Android emulator or phone running Android 8.0/API 26 or newer, then click **Run app**.

The application opens on **Create your account**, matching the screenshot. Use **Sign in** at the bottom to display the login form. The top-left arrow also switches between the two screens. The system Back button leaves the activity normally.

## What to show in the evaluation

- Select Patient, Doctor, Caregiver, and Admin on the sign-up screen.
- Show the same four role choices on the login screen.
- Tap the eye icons to show/hide passwords.
- Submit an empty form to demonstrate inline feedback.
- Use `Demo Patient`, `demo@example.com`, and `Demo12345` as sample sign-up details. Repeat the password in Confirm password.
- Submit valid details to show a clearly labeled preview dialog. The selected role appears in the dialog.
- On the login screen, use `demo@example.com` and any nonempty sample password. This only validates the form, not credentials.
- Tap Forgot password to show its unconnected preview.
- Tap the small terms/privacy paragraph for the prototype explanation.

## Scope and limits

This is **UI only**. No Firebase, Gemini, network access, authentication service, backend, storage, glucose data, dashboards, or other project features are included. The app has no INTERNET permission and does not store or send submitted details. Login does not require a previous sign-up because neither screen creates or checks an account.

All four roles share the same basic fields. Role-specific onboarding and verification are outside this evaluation. Admin sign-up is explicitly a demonstration: production administrators would not self-register into privileged access.

Role and screen choice survive rotation; entered details intentionally do not. Passwords are cleared after successful form validation and when switching screens. Use fictional details during the demonstration.

## Design

Pale mint/cream background, teal droplet logo, rounded light form card, outlined inputs, leading field icons, password visibility controls, a role selector, and a teal primary button follow the supplied screenshot. The extra Admin role makes the selector four segments rather than three. A scrollable layout supports smaller screens and the keyboard. The layout is capped to a comfortable width on larger screens.

## Project map

- `app/src/main/res/layout/activity_auth.xml` — both editable form layouts.
- `app/src/main/java/com/diabetescompanion/auth/AuthActivity.java` — screen switching, role selection, local feedback and preview dialogs.
- `app/src/main/java/com/diabetescompanion/auth/FormValidator.java` — local input validation.
- `app/src/main/res/values/` — text, colors and styles.
- `app/src/main/res/drawable/` — vector icons and rounded backgrounds.
- `tests/` — dependency-free Java validation checks.

The UI uses native Android views and Java, not a website or WebView. XML can be inspected directly in Android Studio's Layout Editor. There are no application library dependencies.

## Build configuration

- Android Gradle Plugin 8.9.2 / Gradle 8.11.1
- Compile/target API 35 / minimum API 26
- Android Build Tools 36.0.0
- Java source compatibility 17

On Windows, use `gradlew.bat assembleDebug`. On macOS/Linux, use `./gradlew assembleDebug`. The debug APK is generated at `app/build/outputs/apk/debug/app-debug.apk`.

Build-tool compatibility reference: https://developer.android.com/build/releases/agp-8-9-0-release-notes

## Troubleshooting

- **SDK location not found:** select your local Android SDK in Android Studio. Do not copy another computer's `local.properties`.
- **Java version error:** select Embedded JDK 17/21, not an older Java installation.
- **Download or sync failure:** allow access to Google Maven, Maven Central and Gradle's distribution servers, then retry Sync.
- **Screen too small:** scroll down to the submit/navigation links; hide the keyboard when comparing the full layout to the reference.
