package com.airtribe.learntrack.util;

import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.DisplayManager.ConsoleDisplayService;
import com.airtribe.learntrack.util.DisplayManager.DisplayServices;

/**
 * Coordinates initialization and execution of course, student, and enrollment services,
 * and routes user requests via menu-driven handlers.
 */
public abstract class ServiceHandler {

   private ServiceHandler(){}

   private static CourseService courseService;
   private static StudentService studentService;
   private static EnrollmentService enrollmentService;
   private static final ConsoleDisplayService consoleDisplayService = new ConsoleDisplayService();
   private static DisplayServices displayServices;

   private static DisplayServices getDisplayUtil(){ return displayServices; }

   /**
    * Initializes service instances for course, student, and enrollment operations.
    */
   public static void initializeServices() {
      displayServices = consoleDisplayService;
      courseService = new CourseService(displayServices);
      studentService = new StudentService(displayServices);
      enrollmentService = new EnrollmentService(displayServices, studentService, courseService);
   }

   /**
    * Displays the entry page and starts handling system service requests.
    */
   public static void startService(){
      getDisplayUtil().println(MenuOptions.ENTRY_PAGE);
      ServiceHandler.handleSystemServiceRequest();
   }

   private static CourseService getCourseService() { return courseService; }
   private static StudentService getStudentService() { return studentService; }
   private static EnrollmentService getEnrollmentService() { return enrollmentService; }

   private static void displaySystemMenu() {
      getDisplayUtil().println(MenuOptions.SYSTEM_MENU);
   }

   private static void displayStudentServiceMenu() {
      getDisplayUtil().println(MenuOptions.STUDENT_SERVICE_MENU);
   }

   private static void displayCourseServiceMenu() {
      getDisplayUtil().println(MenuOptions.COURSE_SERVICE_MENU);
   }

   private static void displayEnrollmentServiceMenu() {
      getDisplayUtil().println(MenuOptions.ENROLLMENT_SERVICE_MENU);
   }

   private static void handleSystemServiceRequest() {
      while (true) {
         displaySystemMenu();
         try {
            switch (InputCollector.getOption()) {
               case 1 -> handleCourseServiceRequest();

               case 2 -> handleStudentServiceRequest();

               case 3 -> handleEnrollmentServiceRequest();

               case 4 ->{
                  getDisplayUtil().println(MenuOptions.EXIT_PAGE);
                  return;
               }

               default -> getDisplayUtil().println(MenuOptions.INVALID_OPTION);
            }
         } catch (Exception e) {
            getDisplayUtil().println(e.getMessage());
         }
      }
   }

   private static void handleCourseServiceRequest() {
      while (true) {
         displayCourseServiceMenu();
         try {
            switch (InputCollector.getOption()) {
               case 1 -> getCourseService().addNewCourse(InputCollector.getCourseName(), InputCollector.getCourseDescription(), InputCollector.getDurationInWeeks());
               case 2 -> getCourseService().listAllCourses();
               case 3 -> getCourseService().listActiveCourses();
               case 4 -> getCourseService().listInactiveCourses();
               case 5 -> getCourseService().activateCourse(InputCollector.getCourseId());
               case 6 -> getCourseService().deactivateCourse(InputCollector.getCourseId());
               case 7 -> getCourseService().viewCourseDetails(InputCollector.getCourseId());
               case 8 -> getCourseService().deleteCourse(InputCollector.getCourseId());
               case 9 -> {
                  return;
               }
               default -> getDisplayUtil().println(MenuOptions.INVALID_OPTION);
            }
         } catch (Exception e) {
            getDisplayUtil().println(e.getMessage());
         }
      }
   }

   private static void handleEnrollmentServiceRequest() {
      while (true) {
         displayEnrollmentServiceMenu();

         try {
            switch (InputCollector.getOption()) {
               case 1 -> getEnrollmentService().enrollStudentToCourse(InputCollector.getStudentId(), InputCollector.getCourseId());

               case 2 -> getEnrollmentService().listEnrollmentsOfStudent(InputCollector.getStudentId());

               case 3 -> getEnrollmentService().markEnrollmentStatusOfStudent(InputCollector.getStudentId(), InputCollector.getCourseId(), InputCollector.getStatus());

               case 4 -> getStudentService().listStudents();

               case 5 -> getCourseService().listActiveCourses();

               case 6 -> getEnrollmentService().listAllEnrollments(null);

               case 7 -> getEnrollmentService().listAllEnrollments(EnrollmentStatus.ACTIVE);

               case 8 -> getEnrollmentService().listAllEnrollments(EnrollmentStatus.COMPLETED);

               case 9 -> getEnrollmentService().listAllEnrollments(EnrollmentStatus.CANCELED);

               case 10 -> {
                  return;
               }

               default -> getDisplayUtil().println(MenuOptions.INVALID_OPTION);
            }
         } catch (Exception e) {
            getDisplayUtil().println(e.getMessage());
         }
      }
   }

   private static void handleStudentServiceRequest() {
      while (true) {
         displayStudentServiceMenu();

         try {
            switch (InputCollector.getOption()) {
               case 1 -> getStudentService().addStudent(InputCollector.getFirstName(), InputCollector.getLastName(), InputCollector.getEmail());

               case 2 -> getStudentService().removeStudent(InputCollector.getStudentId());

               case 3 -> getStudentService().updateStudentEmailId(InputCollector.getStudentId(), InputCollector.getEmail());

               case 4 -> getStudentService().listStudents();

               case 5 -> getStudentService().viewStudentDetails(InputCollector.getStudentId());

               case 6 -> {
                  return;
               }

               default -> getDisplayUtil().println(MenuOptions.INVALID_OPTION);
            }
         } catch (Exception e) {
            getDisplayUtil().println(e.getMessage());
         }
      }
   }

}
