
package com.airtribe.learntrack.service;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.DisplayManager.DisplayServices;
import com.airtribe.learntrack.util.InputValidator;

/**
 * Handles operations related to course creation, updates, activation, deactivation,
 * deletion, and retrieval.
 */
public class CourseService {
   private static final CourseRepository courseRepository = new CourseRepository();
   private final DisplayServices displayServices;

   private CourseRepository getCourseRepository() { return courseRepository; }
   private DisplayServices getDisplayManager() { return displayServices; }


   /**
    * Initializes the CourseService with a DisplayServices instance.
    *
    * @param displayServices service for handling display operations
    */
   public CourseService(DisplayServices displayServices) {
      this.displayServices = displayServices;
   }

   /**
    * Adds a new course after validating its details.
    *
    * @param courseName        name of the course
    * @param courseDescription description of the course (optional)
    * @param durationInWeeks   duration of the course in weeks
    */
   public void addNewCourse(String courseName, String courseDescription, int durationInWeeks){
      if(!InputValidator.validateCourseDetails(courseName, durationInWeeks)){
         getDisplayManager().displayError("Addition of course failed!");
         return;
      }
      if(courseDescription.isEmpty()){
         courseDescription = AppConstants.EMPTY_COURSE_DESCRIPTION;
      }
      Course newCourse = new Course(courseName, courseDescription, durationInWeeks);
      getCourseRepository().getCourses().add(newCourse);
      getDisplayManager().printWithSurroundingBlankLines("Course " + courseName + " added successfully");
   }

   /**
    * Lists all active courses.
    */
   public void listActiveCourses(){
      getDisplayManager().println("List of Active Courses: ");
      for(Course course : getCourseRepository().getCourses()){
         if(course.isActive()){
            getDisplayManager().println(course.toString());
         }
      }
      getDisplayManager().printBlankLine();
   }

   /**
    * Lists all inactive courses.
    */
   public void listInactiveCourses(){
      getDisplayManager().println("List of Inactive Courses: ");
      for(Course course : getCourseRepository().getCourses()){
         if(!course.isActive()){
            getDisplayManager().println(course.toString());
         }
      }
      getDisplayManager().printBlankLine();
   }

   private String courseNotFound(int courseID){
      return AppConstants.COURSE_WITH_ID + courseID + AppConstants.NOT_FOUND;
   }

   /**
    * Deactivates a course by its ID if it exists and is active.
    *
    * @param courseId ID of the course
    */
   public void deactivateCourse(int courseId){
      Course course = findCourseById(courseId);
      if(course == null){
         getDisplayManager().displayError(courseNotFound(courseId));
         return;
      }
      if(!course.isActive()){
         getDisplayManager().displayError(AppConstants.COURSE_WITH_ID + courseId + " is not active!");
         return;
      }
      course.setActive(CourseStatus.INACTIVE);
      getDisplayManager().printWithSurroundingBlankLines(AppConstants.COURSE_WITH_ID + courseId + " is now deactivated.");
   }

   /**
    * Activates a course by its ID if it exists and is inactive.
    *
    * @param courseId ID of the course
    */
   public void activateCourse(int courseId){
      Course course = findCourseById(courseId);
      if(course == null){
         getDisplayManager().displayError(courseNotFound(courseId));
         return;
      }
      if(course.isActive()){
         getDisplayManager().displayError(AppConstants.COURSE_WITH_ID + courseId + " is already active.");
         return;
      }
      course.setActive(CourseStatus.ACTIVE);
      getDisplayManager().printWithSurroundingBlankLines(AppConstants.COURSE_WITH_ID + courseId + " is now active.");
   }

   /**
    * Lists all courses by showing active and inactive courses.
    */
   public void listAllCourses(){
      listActiveCourses();
      getDisplayManager().printBlankLine();
      listInactiveCourses();
      getDisplayManager().printBlankLine();
   }

   /**
    * Displays detailed information about a specific course.
    *
    * @param courseID ID of the course
    */
   public void viewCourseDetails(int courseID){
      Course course = findCourseById(courseID);
      if(course == null){
         getDisplayManager().displayError(courseNotFound(courseID));
         return;
      }
      getDisplayManager().printWithSurroundingBlankLines(course.toString());
   }

   /**
    * Deletes a course by its ID if it exists.
    *
    * @param courseID ID of the course
    */
   public void deleteCourse(int courseID){
      Course course = findCourseById(courseID);
      if(course == null){
         getDisplayManager().displayError(courseNotFound(courseID));
         return;
      }
      getCourseRepository().getCourses().remove(course);
      getDisplayManager().printWithSurroundingBlankLines(AppConstants.COURSE_WITH_ID + courseID + " is deleted successfully.");
   }

   Course findCourseById(int courseId){
      for(Course course : getCourseRepository().getCourses()){
         if(course.getId() == courseId){
            return course;
         }
      }
      return null;
   }
}
