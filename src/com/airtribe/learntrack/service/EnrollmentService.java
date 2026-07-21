
package com.airtribe.learntrack.service;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.DisplayManager.DisplayServices;

import java.util.List;

/**
 * Handles enrollment operations between students and courses.
 */
public class EnrollmentService {
   private final DisplayServices displayServices;
   private final StudentService studentService;
   private final CourseService courseService;
   private final EnrollmentRepository enrollmentRepository = new EnrollmentRepository();


   private StudentService getStudentService(){ return studentService; }
   private CourseService getCourseService(){ return courseService; }
   private EnrollmentRepository getEnrollmentRepository(){ return enrollmentRepository; }
   private DisplayServices getDisplayManager(){ return displayServices; }


   /**
    * Initializes the EnrollmentService with display, student, and course services.
    *
    * @param displayServices service for handling display operations
    * @param studentService  service for managing student-related operations
    * @param courseService   service for managing course-related operations
    */
   public EnrollmentService(DisplayServices displayServices, StudentService studentService, CourseService courseService)
   {
      this.displayServices = displayServices;
      this.studentService = studentService;
      this.courseService = courseService;
   }

   private void addNewEnrollment(Enrollment enrollment){
      getEnrollments().add(enrollment);
   }

   private List<Enrollment> getEnrollments(){
      return getEnrollmentRepository().getEnrollments();
   }

   /**
    * Enrolls a student in a course if both exist and the course is active.
    *
    * @param studentId ID of the student
    * @param courseId  ID of the course
    */
   public void enrollStudentToCourse(int studentId, int courseId) {
      if(!validateStudentAndCourse(studentId, courseId)){
         return;
      }
      Student student = getStudentService().getStudentById(studentId);
      Course course = getCourseService().findCourseById(courseId);
      if(!course.isActive()){
         getDisplayManager().displayError("Course with id " + courseId + " is not active.");
         return;
      }
      Enrollment enrollment = new Enrollment(student, course);
      addNewEnrollment(enrollment);
      getDisplayManager().printWithSurroundingBlankLines(AppConstants.STUDENT_WITH_ID + studentId + " is enrolled in course with id " + courseId + " successfully.");
   }

   /**
    * Lists all enrollments, optionally filtered by status.
    *
    * @param status enrollment status to filter by; pass {@code null} for all
    */
   public void listAllEnrollments(EnrollmentStatus status){
      getDisplayManager().println("List of " + (status == null ? "All " : status.toString()) + " Enrollments are: ");
      for(Enrollment enrollment : getEnrollments()){
         if(status == null || enrollment.getStatus().equals(status)){
            getDisplayManager().println(enrollment.toString());
         }
      }
      getDisplayManager().printBlankLine();
   }

   /**
    * Lists all enrollments for a given student ID.
    *
    * @param studentId ID of the student
    */
   public void listEnrollmentsOfStudent(int studentId){
      Student student = getStudentService().getStudentById(studentId);
      if(student == null){
         getDisplayManager().displayError("Student with id " + studentId + " is not found.");
         return;
      }
      getDisplayManager().println("List of Enrollments for student with id " + studentId + " are : ");
      for(Enrollment enrollment : getEnrollments()){
         if(enrollment.getStudent().getId() == studentId){
            getDisplayManager().println(enrollment.toString());
         }
      }
      getDisplayManager().printBlankLine();
   }

   /**
    * Updates the enrollment status for a student's course enrollment.
    *
    * @param studentId ID of the student
    * @param courseId  ID of the course
    * @param newStatus new status to set
    */
   public void markEnrollmentStatusOfStudent(int studentId, int courseId, EnrollmentStatus newStatus) {
      if(!validateStudentAndCourse(studentId, courseId)){
         return;
      }
      if(newStatus == null){
         getDisplayManager().displayError(MenuOptions.INVALID_STUDENT_NEW_STATUS);
         return;
      }
      for (Enrollment enrollment : getEnrollments()) {
         if(enrollment.getStudent().getId() == studentId && enrollment.getCourse().getId() == courseId){
            enrollment.setStatus(newStatus);
            if(!newStatus.equals(EnrollmentStatus.ACTIVE)){
               enrollment.getStudent().setActive(false);
            }
            getDisplayManager().printWithSurroundingBlankLines("Enrollment status changed to "
                    + newStatus
                    + " for "
                    + enrollment.getStudent().getDisplayName()
                    + " Course Name: "
                    + enrollment.getCourse().getCourseName());
            return;
         }
      }
      getDisplayManager().displayError("Student with id " + studentId + " is not enrolled in course " + courseId);
   }

   private boolean validateStudentAndCourse(int studentId, int courseId) {
      Student student = getStudentService().getStudentById(studentId);
      Course course = getCourseService().findCourseById(courseId);
      if(student == null){
         getDisplayManager().displayError(AppConstants.STUDENT_WITH_ID + studentId + " not found");
         return false;
      }
      if(course == null){
         getDisplayManager().displayError(AppConstants.COURSE_WITH_ID + courseId + " not found");
         return false;
      }
      return true;
   }

}
