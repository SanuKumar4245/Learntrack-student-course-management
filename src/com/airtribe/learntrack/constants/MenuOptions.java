package com.airtribe.learntrack.constants;

public abstract class MenuOptions {

   private MenuOptions() {}

   public static final String ENTER_OPTION = "Enter your option: ";
   public static final String ENTER_COURSE_ID = "Enter course id: ";
   public static final String ENTER_COURSE_NAME = "Enter course name: ";
   public static final String ENTER_COURSE_DESCRIPTION = "Enter course description: ";
   public static final String ENTER_COURSE_DURATION = "Enter course duration in week: ";
   public static final String ENTER_STUDENT_FIRST_NAME = "Enter student first name: ";
   public static final String ENTER_STUDENT_LAST_NAME = "Enter student last name: ";
   public static final String ENTER_STUDENT_EMAIL = "Enter student email: ";
   public static final String ENTER_STUDENT_ID = "Enter student id: ";
   public static final String ENTER_STUDENT_NEW_STATUS = "Enter student new status - (1 for COMPLETED, 2 for CANCELLED): ";


   public static final String INVALID_OPTION = "Invalid option selected";
   public static final String INVALID_COURSE_DURATION = "Course Duration in a week is invalid";
   public static final String INVALID_COURSE_ID = "Course Id is invalid";
   public static final String INVALID_STUDENT_ID = "Student Id is invalid";
   public static final String INVALID_STUDENT_NEW_STATUS = "Student New Status is invalid";


   public static final String ENTRY_PAGE = """
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            ┃                Welcome to LearnTrack System!               ┃
            ┠────────────────────────────────────────────────────────────┨
            ┃ This is a console-based Student & Course Management System ┃
            ┃     to manage Students, Courses and Enrollments            ┃
            ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
            """;

   public static final String EXIT_PAGE = """
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            ┃                      Exit Successful!                      ┃
            ┠────────────────────────────────────────────────────────────┨
            ┃   Please re-run the program to start the service again.    ┃
            ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
            """;

   public static final String SYSTEM_MENU = """
            ===========================================================================================
            ╭──────────────────────────────────╮
            │           SYSTEM MENU            │
            ├══════════════════════════════════┤
            │ 1. Course Service                │
            │ 2. Student Service               │
            │ 3. Enrollment Service            │
            │ 4. Exit                          │
            ╰──────────────────────────────────╯
            """;

   public static final String STUDENT_SERVICE_MENU = """
            ===========================================================================================
            ╭──────────────────────────────────╮
            │       STUDENT SERVICE MENU       │
            ├══════════════════════════════════┤
            │ 1. Add a Student                 │
            │ 2. Remove a Student              │
            │ 3. Update Student Email-ID       │
            │ 4. List all Students             │
            │ 5. View Details of a Student     │
            │ 6. Go Back to Main Menu          │
            ╰──────────────────────────────────╯
            """;

   public static final String COURSE_SERVICE_MENU = """
            ===========================================================================================
            ╭──────────────────────────────────╮
            │       COURSE SERVICE MENU        │
            ├══════════════════════════════════┤
            │ 1. Add a New Course              │
            │ 2. List All Courses              │
            │ 3. List Active Courses           │
            │ 4. List Deactivated Courses      │
            │ 5. Activate a Course             │
            │ 6. Deactivate a Course           │
            │ 7. View a Course Details         │
            │ 8. Delete a Course               │
            │ 9. Go Back to Main Menu          │
            ╰──────────────────────────────────╯
            """;

   public static final String ENROLLMENT_SERVICE_MENU = """
            ===========================================================================================
            ╭────────────────────────────────────────╮
            │       ENROLLMENT SERVICE MENU          │
            ├════════════════════════════════════════┤
            │ 1. Enroll Student To Course            │
            │ 2. List Enrollments of a Student       │
            │ 3. Mark Enrollment Status of a Student │
            │ 4. List all Students                   │
            │ 5. List all Active Courses             │
            │ 6. List all Enrollments                │
            │ 7. List all Active Enrollments         │
            │ 8. List all Completed Enrollments      │
            │ 9. List all Cancelled Enrollments      │
            │ 10. Go Back to Main Menu               │
            ╰────────────────────────────────────────╯
            """;
}


