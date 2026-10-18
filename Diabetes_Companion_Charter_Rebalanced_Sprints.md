# DIABETES COMPANION

## Project Charter

### An Android Application for Diabetes Management and Connected Care

Prepared by

Aljohara Alnasser<br>223410291 | SE-CYS

Shahad bin sainid<br>221410586 | SE-CYS

Norah Alsheikh<br>222511404 | SE-AI

Norah Aldeeb<br>221410128 | SE-CYS

Reema Alhammad<br>223410817 | SE-CYS

Supervised by<br>Dr. Asma Sattar

Prince Sultan University<br>SE 499 Senior Project—Semester 261<br>College of Computer and Information System

Academic Year: Fall 2026<br>Submission Date: September 13, 2026

## Contents

- [1. Project Title and Description](#1-project-title-and-description)
- [2. Project Objectives](#2-project-objectives)
- [3. Project Scope](#3-project-scope)
- [3.1 In Scope](#31-in-scope)
- [3.2 Out of Scope](#32-out-of-scope)
- [4. Stakeholders](#4-stakeholders)
- [5. Constraints and Assumptions](#5-constraints-and-assumptions)
- [6. Project Risks and Mitigation](#6-project-risks-and-mitigation)
- [7. System Requirements](#7-system-requirements)
- [7.1 Functional Requirements](#71-functional-requirements)
- [7.2 Non-Functional Requirements](#72-non-functional-requirements)
- [8. Key Performance Indicators](#8-key-performance-indicators)
- [9. Delivery Plan and Governance](#9-delivery-plan-and-governance)
- [10. User Stories](#10-user-stories)
- [10.1 Sprint 1 Core Records and Secure Foundation](#101-sprint-1-core-records-and-secure-foundation)
- [10.2 Sprint 2 Connected Care and AI Workflows](#102-sprint-2-connected-care-and-ai-workflows)
- [10.3 Sprint 3 Administration and Final Refinement](#103-sprint-3-administration-and-final-refinement)
- [11. System Architecture](#11-system-architecture)

# 1. Project Title and Description

**Project title:** Diabetes Companion

**Project type:** Android mobile application and academic software engineering project

Diabetes Companion supports daily diabetes management by bringing glucose records, medication tracking, alerts, and care-team communication into one application. It connects patients with their assigned doctors and designated caregivers, while providing administrators with tools to manage accounts and monitor system activity.

Patients can record glucose readings, review trends, track medication, and receive reminders. Readings outside doctor-configured thresholds trigger alerts and a defined escalation process. A general-guidance chatbot supports diabetes education, while a separate insulin-advice request allows the doctor to review an AI-prepared draft and send a considered response.

The project will deliver a working academic prototype, supported by requirements documentation, testing evidence, user evaluation, and a final demonstration.

# 2. Project Objectives

The project aims to:

- **Improve understanding of daily records** by presenting glucose readings, trends, and medication history in a clear, accessible format.

- **Support consistent self-management** through straightforward logging, customizable reminders, and weekly summaries.

- **Improve care-team coordination** by connecting alerts, follow-up actions, and communication to the relevant patient.

- **Support doctor-led advice** by organizing patient requests and relevant information within an AI-assisted review workflow.

- **Protect sensitive information** through controlled sharing, secure storage, and clear data-handling rules.

- **Demonstrate a usable, integrated solution** through incremental delivery and evaluation with relevant participants.

# 3. Project Scope

## 3.1 In Scope

The baseline deliverable includes:

- An Android application with Patient, Doctor, Caregiver, and Admin interfaces.

- Manual glucose entry and a button-triggered data-generation pipeline for monitoring demonstrations.

- Glucose history, trend indicators, and patient-specific thresholds.

- Medication and insulin logging, reminders, and recorded history.

- Warning alerts, acknowledgment actions, and caregiver-to-doctor escalation.

- A patient-facing general-guidance chatbot and a separate doctor-reviewed insulin-request workflow.

- Weekly summaries and patient–doctor and caregiver–doctor text messaging.

- Consent management, role-based access, encryption, and defined retention procedures.

- English-language screens with large-text support, high contrast, and clear navigation.

- Testing, user evaluation, technical documentation, and an integrated demonstration build.

## 3.2 Out of Scope

The following are outside the baseline commitment:

- iOS and web applications.

- Production hospital connections, HIS/EHR integration, and FHIR services.

- Direct Bluetooth device pairing, Libre integration, and support for multiple live CGM providers.

- Automatic contact with or dispatch of emergency services.

- Patient-facing AI insulin-dose recommendations and automatic approval of AI drafts.

- Clinical certification, clinical trials, and a dedicated known-answer evaluation suite for AI-generated medical suggestions.

- Voice messaging, video calls, and full offline operation with automatic synchronization.

Real Dexcom access is conditional on approval and available implementation time. Predictive AI, Arabic/RTL support, dashboard color customization, and PDF/CSV exports are optional enhancements considered after the baseline requirements are complete.

# 4. Stakeholders

## Patients

Patients record and review their health information, manage reminders, respond to alerts, and control care-team sharing. They expect understandable screens, reliable records, appropriate privacy, and clear communication about pending requests.

## Doctors and Healthcare Providers

Doctors review assigned patients, configure glucose thresholds, follow up on escalated alerts, and respond to insulin-advice requests. They expect relevant patient context, manageable review workflows, and clear separation between AI drafts and their submitted responses.

## Caregivers

Designated caregivers receive escalated alerts, view consented information, and coordinate follow-up with the doctor. They expect clear actions, understandable alert status, and access limited to their approved patient relationship.

## Administrators

Administrators manage user accounts and review operational information, including alert counts and resolution status. They expect appropriate administrative controls and useful aggregate reporting.

## Academic Supervisor and Clinical Advisor

The academic supervisor reviews scope, deliverables, and evaluation evidence. The clinical advisor provides feedback on terminology, threshold configuration, and care-related workflows. Their input supports realistic requirements and appropriate boundaries for the prototype.

## Project Team

The team is responsible for requirements, design, implementation, integration, testing, documentation, and demonstration:

- **Aljohara Alnasser** **-** **223410291** **-** **SE-CYS**

- **Shahad bin** **sainid** **-** **221410586** **-** **SE-CYS**

- **Norah Alsheikh** **-** **222511404** **-** **SE-AI**

- **Norah** **Aldeeb** **-** **221410128** **-** **SE-CYS**

- **Reema Alhammad** **-** **223410817** **-** **SE-CYS**

Implementation tasks will be assigned through the sprint backlog. Each task will have an owner and a reviewer, with integration and final quality remaining shared responsibilities.

## Evaluation Participants

Relevant patients, caregivers, and healthcare providers will provide requirements feedback and complete representative usability tasks. Participation should be voluntary, with clear information about the purpose of the evaluation and the data collected.

# 5. Constraints and Assumptions

## Schedule and Resources

Development will take place across three sprints within the academic timetable. The five-member team must balance implementation with coursework, documentation, and access to suitable test devices.

## Budget

The proposed prototype budget is **SAR 250**, allocated as follows:

- **Gemini API usage:** SAR 150.

- **Firebase services:** SAR 50.

- **Contingency:** SAR 50.

Free or educational tiers will be used where suitable. These amounts are spending allowances rather than confirmed charges; usage will be monitored throughout development.

## Technical Environment

The planned tools are Android Studio, Firebase, Gemini, and Python for the data-generation pipeline. The application will follow a three-tier architecture separating presentation, business logic, and persistence.

The design will apply Observer to alert events, Builder to structured requests or summaries, and Factory Method to glucose-input sources where these patterns provide a practical benefit.

## External Dependencies

Messaging, shared records, notifications, and AI processing depend on network connectivity and third-party service availability. Doctor and caregiver response times depend on their availability, even when the application processes an escalation correctly.

## Evaluation and Data

Access to representative participants and clinical feedback may be limited. Evaluation will primarily use fictional or generated health records. Any collection of real participant health information requires an agreed consent and data-handling process.

# 6. Project Risks and Mitigation

| **ID** | **Risk** | **Likelihood** | **Impact** | **Mitigation Strategy** | **Risk Owner** |
| --- | --- | --- | --- | --- | --- |
| **R1** | Scope growth may delay core features and testing. | High | High | Prioritize the backlog and review the schedule impact before accepting additional features. | Project Team |
| **R2** | Integration issues may cause inconsistent behavior between modules. | Medium | High | Agree on shared interfaces and data structures early, integrate regularly, and test complete workflows. | Project Team |
| **R3** | Notification delays or failures may interrupt alert escalation. | Medium | High | Maintain server-side alert state, log notification attempts, and display active alerts within the application. | Project Team |
| **R4** | AI output may be inaccurate, incomplete, or unsuitable for the patient’s context. | High | High | Display supporting records and missing information, require doctor review of insulin drafts, and support manual responses. | Project Team |
| **R5** | Incorrect permissions may expose sensitive patient information. | Medium | High | Enforce server-side access controls and test role permissions, consent, and caregiver revocation. | Project Team |
| **R6** | Invalid or duplicate records may affect glucose displays and alerts. | Medium | High | Validate inputs, standardize units and timestamps, and verify record consistency across dashboards. | Project Team |
| **R7** | Limited stakeholder availability may delay feedback and evaluation. | Medium | Medium | Arrange reviews early and prepare short, focused evaluation tasks. | Project Team |
| **R8** | External service costs or interruptions may affect development and demonstration. | Medium | Medium | Monitor usage, control unnecessary requests, and prepare demonstration data and service-error handling. | Project Team |
| **R9** | Users may misunderstand the prototype’s capabilities and place excessive trust in its outputs. | Medium | High | Provide clear prototype notices and explain alert status, pending requests, and the purpose of AI-supported responses. | Project Team |

# 7. System Requirements

The Sprint column identifies when each requirement is introduced or completed. Dashboard functions expand as their dependent features are delivered. Essential notices and readable controls are available from Sprint 1; Sprint 3 refines their settings. Quality requirements apply to every increment and are checked again during final evaluation.

## 7.1 Functional Requirements

| **Requirement** | **Sprint** |
| --- | --- |
| **FR-01 - Accounts and roles:** The system shall support account registration, sign-in, sign-out, and access appropriate to the four user roles. | 1 |
| **FR-02 - Patient profile:** Patients shall maintain the profile information required for their care context, including age, relevant history, and existing care-plan information. | 1 |
| **FR-03 - Glucose input:** Patients shall enter glucose readings manually or generate a demonstration reading, with input validation, timestamps, source labels, and save confirmation. | 1 |
| **FR-04 - Glucose history:** The system shall display recorded readings, historical charts, and rising, falling, or stable trend indicators when sufficient data exists. | 1 |
| **FR-05 - Threshold configuration:** Assigned doctors shall configure each patient’s target range and separate critical-low and critical-high thresholds. | 1 |
| **FR-06 - Medication records:** Patients shall log medications and insulin doses, including amount and time taken, and review their recorded history. | 1 |
| **FR-07 - Reminders:** Patients shall create and update medication and insulin reminder schedules. | 1 |
| **FR-08 - Warning alerts:** The system shall detect out-of-range readings and provide “I’m OK,” “Treating,” “Need Help,” and “Contact Doctor” actions. | 2 |
| **FR-09 - Escalation:** An unanswered Warning shall notify the caregiver after five minutes. An alert unresolved five minutes after caregiver escalation shall notify the doctor. Critical readings shall notify the caregiver immediately, while “Need Help” shall immediately notify both caregiver and doctor. | 2 |
| **FR-10 - Alert lifecycle:** The system shall record alert creation, acknowledgment, escalation, and resolution. Caregivers and doctors shall record resolution with a follow-up note; acknowledgment shall remain distinct from resolution. | 2 |
| **FR-11 - Patient dashboard:** Patients shall access their latest reading, reminders, active alerts, logging controls, chatbot, summaries, and doctor-request workflow from their dashboard and navigation. | 1 core; 2 integration |
| **FR-12 - Doctor dashboard:** Doctors shall search assigned patients and review their readings, medication history, alerts, summaries, and pending requests. | 1 core; 2 integration |
| **FR-13 - Caregiver dashboard:** Caregivers shall view consented patient information, respond to escalated alerts, record follow-up, and contact the assigned doctor. | 2 |
| **FR-14 - Admin dashboard:** Administrators shall manage accounts and review patient counts, active cases, operational alert status, and aggregate analytics. | 3 interface; foundations in 1–2 |
| **FR-15 - Messaging:** The system shall support patient–doctor and caregiver–doctor text conversations with message history linked to the relevant patient. | 2 |
| **FR-16 - General-guidance chatbot:** Patients shall access conversational diabetes education, meal carbohydrate estimates, and general guidance consistent with their existing care plan. | 2 |
| **FR-17 - Insulin-advice requests:** Patients shall submit an “Ask the doctor about your insulin dose” request and view its pending status and final response. | 2 |
| **FR-18 - Doctor-only AI drafts:** The system shall prepare a draft for the doctor using available patient context, current glucose information, and recent insulin records, with supporting information and missing-data indicators. | 2 |
| **FR-19 - Doctor review:** Doctors shall edit, discard, annotate, or replace a draft and explicitly submit the final response. The system shall record the responding doctor and submission time. | 2 |
| **FR-20 - Weekly summaries:** The system shall provide patients and authorized doctors with weekly glucose and medication summaries based on available records. | 2 |
| **FR-21 - Consent and data controls:** Patients shall manage sharing with doctors and caregivers, revoke caregiver access, and request deletion of their information. | 1 |
| **FR-22 - Preferences and notices:** Users shall access notification and text-size settings, privacy information, and academic-prototype notices on relevant screens. | 1 essentials; 3 refinement |

## 7.2 Non-Functional Requirements

| **Requirement** | **Sprint** |
| --- | --- |
| **NFR-01 - Usability:** Core tasks shall use clear labels, consistent navigation, and understandable feedback suited to the intended users. | 1 baseline; 3 usability review |
| **NFR-02 - Accessibility:** Screens shall support large text, adequate contrast, readable layouts, and touch targets suitable for elderly users. Status shall be communicated through text or icons alongside color. | 1 baseline; 3 accessibility review |
| **NFR-03 - Responsiveness:** Common interactions shall provide visible feedback promptly. Longer operations shall show a loading or pending state. | 1 baseline; 2 AI and network states |
| **NFR-04 - Reliability:** Confirmed saves shall remain available after reopening the application, and repeated submissions shall be handled to reduce accidental duplication. | 1; regression checks in 2–3 |
| **NFR-05 - Data quality:** Values, units, timestamps, and required fields shall be validated before storage or use in dependent workflows. | 1; applied to new inputs in 2–3 |
| **NFR-06 - Consistency:** Patient and care-team views shall use the same underlying records and threshold settings. | 1 patient/doctor; 2 caregiver |
| **NFR-07 - Access security:** Authorization shall be enforced on the server according to the user’s role, assigned relationship, and current consent. | 1; verify every new endpoint |
| **NFR-08 - Encryption:** Sensitive information shall be encrypted during transfer and storage. | 1; maintained throughout |
| **NFR-09 - Data minimization:** The application shall process only information needed for its features and limit information sent to external AI services. Lock-screen notifications shall avoid sensitive detail. | 1 records; 2 AI and messaging |
| **NFR-10 - Retention:** Identifiable project records shall be deleted within 90 days after final evaluation. Earlier deletion requests shall target completion within 30 days, with backups, if used, expiring within a further 30 days. | 1 implementation; 3 verification |
| **NFR-11 - Revocation enforcement:** Revoking caregiver consent shall block subsequent server access and future sharing. App-held cached information shall be cleared when the caregiver device next connects. | 1 sharing rules; 2 caregiver integration |
| **NFR-12 - Maintainability:** The codebase shall separate interface, business rules, and persistence responsibilities, with consistent naming and documented shared interfaces. | 1; maintained throughout |
| **NFR-13 - Testability:** Core workflows shall be reproducible using controlled accounts and test records, with sufficient event information to investigate failures. | 1; extended each sprint |
| **NFR-14 - Compatibility:** The application shall be tested on the Android versions and screen sizes selected and documented by the team. | 1 device baseline; 3 final checks |
| **NFR-15 - Transparency and recovery:** Users shall receive clear explanations of errors, missing information, pending requests, and AI-generated content, with suitable retry or manual-completion options. | 1 baseline; 2 connected and AI workflows |

# 8. Key Performance Indicators

The project will be evaluated against the following targets:

- **Baseline completion:** All Must-priority stories satisfy their acceptance criteria before final delivery.

- **Record integrity:** All readings in at least 20 valid entry trials are saved accurately under the correct patient account.

- **Escalation correctness:** Every agreed alert scenario follows the configured five-minute stages or immediate-escalation rules, as demonstrated by recorded events.

- **Access protection:** All agreed unauthorized-access checks are blocked, including a revoked caregiver’s subsequent server requests.

- **Review-workflow integrity:** Every patient-visible insulin response is linked to an explicit doctor submission, with the correct request, identity, and timestamp.

- **Usability:** At least 80% of relevant participants complete each assigned core task without assistance; results include participant counts and task-level completion rates.

- **Data-handling verification:** Retention, deletion, and revocation procedures operate correctly on the agreed test records.

These indicators assess implementation and usability. Evaluation results will state the test conditions and distinguish application behavior from human response times.

# 9. Delivery Plan and Governance

The project will be delivered through three tested increments. Sprints 1 and 2 carry the main implementation work, with nine user stories each. Sprint 3 has three smaller stories and concentrates on administrative presentation, settings refinement, and final evaluation. Testing, documentation, and integration take place throughout the project.

## Sprint 1 Core Records and Secure Foundation

**Development:** Confirm the backlog, interface prototype, architecture, and data model. Implement accounts, patient profiles, consent and deletion controls, manual and generated glucose input, history and trends, doctor-defined thresholds, medication logs, and reminders. Build the patient and doctor dashboard foundations, basic accessibility, and essential notices.

**Integration and testing:** Connect all features to shared patient records and server-side permissions. Verify input validation, patient/doctor record consistency, secure storage, consent revocation, retention procedures, and reminder scheduling. Establish the interfaces and test setup needed for notifications and AI services.

**Requirement coverage:** FR-01–FR-07 and FR-21; the core of FR-11 and FR-12; essential controls from FR-22. Establish the NFR foundations identified in Section 7.2, including access security, encryption, data quality, maintainability, and testability.

**Sprint outcome:** A tested patient-and-doctor application supporting protected health records, trends, thresholds, medication logging, and reminders.

## Sprint 2 Connected Care and AI Workflows

**Development:** Implement warning alerts, acknowledgment and resolution, timed escalation, the caregiver dashboard, and care-team messaging. Deliver the general-guidance chatbot, insulin-advice requests, doctor-only AI drafts, doctor review, and weekly summaries. Prepare the protected account-management operations and aggregate queries for the admin interface.

**Integration and testing:** Connect these services to Sprint 1 records, consent rules, thresholds, and dashboards. Verify the five-minute escalation stages, immediate routes, caregiver revocation, message permissions, doctor-only drafts, explicit submission, and manual replies when AI is unavailable. Extend data minimization and error handling to the new services.

**Requirement coverage:** FR-08–FR-10, FR-13, and FR-15–FR-20; complete the connected features of FR-11 and FR-12 and prepare FR-14 backend operations. Extend NFR-03, NFR-06, NFR-09, NFR-11, and NFR-15, and repeat the applicable security and reliability checks.

**Sprint outcome:** A tested, integrated warning-to-follow-up and request-to-doctor-response workflow, with messaging and weekly summaries available to authorized users.

## Sprint 3 Administration and Final Refinement

**Development:** Assemble the admin dashboard using the existing account operations and aggregate queries. Complete the notification and text-size settings interface and make small usability improvements identified during reviews.

**Integration and evaluation:** Connect the remaining screens to tested services, check all role journeys, and run the final accessibility, compatibility, and regression checks. Evaluate core tasks with relevant participants, confirm data-handling evidence, and finalize the report and demonstration build.

**Requirement coverage:** Complete FR-14 and the settings refinement in FR-22. Consolidate NFR-01, NFR-02, and NFR-14, verify NFR-10, and confirm the continuing quality requirements across the final application.

**Sprint outcome:** The final demonstration build, completed acceptance evidence, user-evaluation results, and project documentation.

Each sprint includes planning, implementation, integration, testing, a working demonstration, and a short review. Changes affecting baseline scope, budget, or delivery commitments will be discussed with the supervisor and recorded in the backlog. New high-complexity workflows should be completed by the end of Sprint 2 so the shorter final sprint remains manageable.

# 10. User Stories

Priority definitions: Must stories are essential to the baseline. Should stories are important and may use simpler presentation if agreed during sprint review. Requirement references connect each story to Section 7. Non-functional requirements also apply to other relevant stories; NFR-12 and NFR-13 govern development and testing throughout.

The revised backlog contains nine stories in Sprint 1, nine in Sprint 2, and three in Sprint 3. Story identifiers refer to this sprint allocation.

## 10.1 Sprint 1 Core Records and Secure Foundation

| **ID and title** | **User story and requirements** | **Acceptance criteria** | **Priority** |
| --- | --- | --- | --- |
| S1-01<br>Accounts and profiles | As a user, I want an account and an appropriate profile so that I can access the application in my assigned role.<br><br>FR: 01, 02<br>NFR: 04, 07 | Registration and sign-in work; patient profile changes persist; invalid credentials are rejected; sign-out ends the session. | Must |
| S1-02<br>Consent and data controls | As a patient, I want to control sharing and request deletion so that access to my records follows my choices.<br><br>FR: 21<br>NFR: 07, 09, 10, 11 | Doctor/caregiver relationships require consent; revocation blocks the next server request; deletion requests are recorded; retention and deletion procedures work on dated test records. | Must |
| S1-03<br>Glucose input | As a patient, I want to enter a reading or generate a demo reading so that I can use the monitoring workflow.<br><br>FR: 03<br>NFR: 04, 05 | Both methods save the correct value, unit, timestamp, and source; invalid input is rejected; saving shows confirmation and avoids duplicate submissions. | Must |
| S1-04<br>Glucose history and trends | As a patient, I want to review readings over time so that I can understand changes in my recorded glucose.<br><br>FR: 04<br>NFR: 03, 05, 06 | Charts and lists use saved readings; date filters work; trend indicators use valid consecutive records; insufficient data is clearly identified. | Must |
| S1-05<br>Doctor review and thresholds | As a doctor, I want to review assigned patients and set thresholds so that monitoring uses the agreed patient-specific settings.<br><br>FR: 05, 12 (core)<br>NFR: 05, 06, 07 | Patient search respects assignment and consent; histories match patient records; target and critical thresholds use valid ordering and units. | Must |
| S1-06<br>Medication history | As a patient, I want to record medication and insulin doses so that I can review what I have taken.<br><br>FR: 06<br>NFR: 04, 05, 07 | Entries capture medication, amount, unit, and time; required fields are validated; saved entries remain available to permitted users. | Must |
| S1-07<br>Medication reminders | As a patient, I want adjustable reminders so that I can follow my recorded medication schedule.<br><br>FR: 07<br>NFR: 03, 09, 15 | Reminders can be created, changed, and disabled; enabled reminders follow the saved schedule; notification-permission problems are explained. | Must |
| S1-08<br>Patient dashboard | As a patient, I want a clear home screen so that I can find my latest reading, history, and medication actions.<br><br>FR: 11 (core)<br>NFR: 01, 03, 06 | The dashboard shows value, unit, time, status text, and reminders; logging actions work; empty states are provided; later feature entry points are integrated in Sprint 2. | Must |
| S1-09<br>Accessible and protected use | As a patient, I want readable screens and protected records so that I can use the prototype confidently.<br><br>FR: 22 (essentials)<br>NFR: 01, 02, 04, 07, 08, 14, 15 | Large text preserves essential controls; notices are visible; records persist after reopening; unrelated accounts are denied access; transfer and storage protection are checked. | Must |

## 10.2 Sprint 2 Connected Care and AI Workflows

| **ID and title** | **User story and requirements** | **Acceptance criteria** | **Priority** |
| --- | --- | --- | --- |
| S2-01<br>Warning response | As a patient, I want to respond to an out-of-range alert so that my response is visible to my care team.<br><br>FR: 08, 10<br>NFR: 03, 05, 15 | Threshold breaches create labeled alerts; the three response actions are recorded; Contact Doctor opens the assigned conversation; acknowledgment does not mark resolution. | Must |
| S2-02<br>Caregiver dashboard | As a caregiver, I want to view approved patient information so that I can support follow-up.<br><br>FR: 13, 21 (integration)<br>NFR: 06, 07, 11 | The dashboard shows permitted records and alert status; revoked access blocks further reads and future updates; cached records clear on reconnection. | Must |
| S2-03<br>Timed escalation and resolution | As a caregiver, I want unresolved alerts to progress to the doctor so that follow-up has a clear next step.<br><br>FR: 09, 10<br>NFR: 04, 07, 13, 15 | An unanswered Warning reaches the caregiver after five minutes; unresolved caregiver-stage alerts reach the doctor five minutes later; critical readings and Need Help follow immediate routes; resolution requires a note. | Must |
| S2-04<br>Care-team messaging | As a patient or caregiver, I want to message the assigned doctor so that discussions remain linked to the right patient.<br><br>FR: 15<br>NFR: 06, 07, 09 | Authorized conversations deliver and retain text messages with timestamps; patient context is clear; access follows the current care-team relationship. | Must |
| S2-05<br>General-guidance chatbot | As a patient, I want understandable diabetes guidance so that I can learn about daily self-management.<br><br>FR: 16<br>NFR: 03, 09, 15 | Agreed educational topics and carbohydrate estimates are supported; insulin-dose questions redirect to the doctor request; AI loading and error states are clear. | Must |
| S2-06<br>Insulin-advice request | As a patient, I want to ask my doctor about insulin advice so that I can receive a reviewed response.<br><br>FR: 17<br>NFR: 05, 07, 09, 15 | Submitting creates a patient-linked request with relevant context; pending status is visible; only the assigned authorized doctor can review it. | Must |
| S2-07<br>Doctor-only AI draft | As a doctor, I want a draft with supporting patient records so that I can review the request with its context.<br><br>FR: 18<br>NFR: 05, 07, 09, 15 | The draft uses available profile, glucose, and recent dose records; timestamps and missing data are visible; the draft is hidden from patients; generation failure allows a manual reply. | Must |
| S2-08<br>Reviewed response | As a doctor, I want to edit or replace a draft before sending it so that the final advice reflects my review.<br><br>FR: 19, 11–12 (integration)<br>NFR: 04, 06, 07, 15 | Editing, notes, discard, and manual response work; sending requires an explicit action; the patient receives the submitted response with doctor identity and time. | Must |
| S2-09<br>Weekly summaries | As a patient, I want a weekly overview that my authorized doctor can also view so that we can discuss recent records.<br><br>FR: 20<br>NFR: 05, 06, 07, 09 | Summaries identify their date range, use relevant glucose and medication records, explain insufficient data, and follow sharing permissions; underlying aggregate queries are reusable for admin reporting. | Should |

## 10.3 Sprint 3 Administration and Final Refinement

| **ID and title** | **User story and requirements** | **Acceptance criteria** | **Priority** |
| --- | --- | --- | --- |
| S3-01<br>Admin interface | As an administrator, I want an overview and account controls so that I can support application use.<br><br>FR: 14<br>NFR: 01, 06, 07 | Screens use the prepared account operations and aggregate queries; counts match records; alert status and resolution are visible; actions respect admin permissions. | Must |
| S3-02<br>Settings refinement | As a user, I want clear preference controls so that I can adjust notifications and text size.<br><br>FR: 22 (completion)<br>NFR: 01, 02, 03, 14 | Settings changes persist and affect the relevant screens or reminders; privacy information and prototype notices remain accessible. | Must |
| S3-03<br>Usability and final checks | As a user, I want a consistent application across supported devices so that I can complete core tasks without assistance.<br><br>FR: Delivered workflows<br>NFR: 01, 02, 13, 14, 15 | At least 80% of relevant participants complete each assigned core task unassisted; selected Android layouts pass review; agreed usability issues are addressed and core journeys pass regression checks. | Must |

# 11. System Architecture

Diabetes Companion uses a three-tier architecture: a presentation layer for the four user interfaces, a business logic layer for monitoring, alerts, communication, and doctor-reviewed AI workflows, and a data persistence layer for storing application records.

Firebase supports authentication, notifications, and storage; Gemini provides AI text generation; and the Python pipeline supplies demonstration readings. Access controls and patient consent govern information sharing.

![Diabetes Companion system architecture](/Users/abdulahad/Documents/Codex/2026-09-04/diabetes-companion-is-a-mobile-and/outputs/Diabetes_Companion_Charter_Figure_1.png)

Figure 1: Diabetes Companion’s three-tier system architecture, showing application components, data flows, and external service connections.
