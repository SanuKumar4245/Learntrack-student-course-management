
package com.airtribe.learntrack.util;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.util.DisplayManager.ConsoleDisplayService;
import com.airtribe.learntrack.util.DisplayManager.DisplayServices;

/**
 * Provides validation utilities for course and student details.
 */
public abstract class InputValidator {

   private static final DisplayServices displayServices = new ConsoleDisplayService();
   private static DisplayServices getDisplayUtil(){ return displayServices; }

   private InputValidator(){}

   private static boolean validateCourseName(String courseName) {
      if(!courseName.isEmpty()){
         return true;
      }
      getDisplayUtil().displayError(AppConstants.INVALID_COURSE_NAME);
      return false;
   }

   private static boolean validateDurationInWeeks(int durationInWeeks) {
      if(durationInWeeks <= 0 || durationInWeeks > 7){
         getDisplayUtil().displayError("Duration in weeks - (" + durationInWeeks + ") is invalid");
         return false;
      }
      return true;
   }

   /**
    * Validates the provided course name and duration.
    *
    * @param courseName name of the course
    * @param durationInWeeks duration of the course in weeks
    * @return true if all course details are valid
    */
   public static boolean validateCourseDetails(String courseName, int durationInWeeks){
      return validateCourseName(courseName) && validateDurationInWeeks(durationInWeeks);
   }

   /**
    * Validates the provided student first and last name.
    *
    * @param firstName student's first name
    * @param lastName student's last name
    * @return true if both names are valid
    */
   public static boolean validateStudentDetails(String firstName, String lastName){
      if(firstName.isEmpty()){
         getDisplayUtil().displayError(AppConstants.EMPTY_FIRST_NAME);
         return false;
      }

      if(lastName.isEmpty()){
         getDisplayUtil().displayError(AppConstants.EMPTY_LAST_NAME);
         return false;
      }

      return true;
   }

}
