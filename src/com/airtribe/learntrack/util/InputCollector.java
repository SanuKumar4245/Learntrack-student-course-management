package com.airtribe.learntrack.util;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.DisplayManager.ConsoleDisplayService;
import com.airtribe.learntrack.util.DisplayManager.DisplayServices;

import java.util.Scanner;

/**
 * Collects and validates user input for menu selections
 */
public abstract class InputCollector{
   private static final Scanner scanner = new Scanner(System.in);
   private static final DisplayServices displayServices = new ConsoleDisplayService();

   private InputCollector() {}

   private static DisplayServices getDisplayUtil(){ return displayServices; }

   static int getOption() throws InvalidInputException {
      getDisplayUtil().print(MenuOptions.ENTER_OPTION);
      try {
         int option = Integer.parseInt(scanner.nextLine());
         getDisplayUtil().printBlankLine();
         return option;
      } catch (Exception e){
         getDisplayUtil().printBlankLine();
         throw new InvalidInputException(AppConstants.ERROR + MenuOptions.INVALID_OPTION);
      }
   }

   static int getCourseId() throws InvalidInputException {
      getDisplayUtil().print(MenuOptions.ENTER_COURSE_ID);
      try {
         return Integer.parseInt(scanner.nextLine());
      } catch (Exception e){
         getDisplayUtil().printBlankLine();
         throw new InvalidInputException(AppConstants.ERROR + MenuOptions.INVALID_COURSE_ID);
      }
   }

   static String getCourseName(){
      getDisplayUtil().print(MenuOptions.ENTER_COURSE_NAME);
      String courseName = scanner.nextLine();
      return courseName.trim();
   }

   static String getCourseDescription(){
      getDisplayUtil().print(MenuOptions.ENTER_COURSE_DESCRIPTION);
      String courseDescription = scanner.nextLine();
      return courseDescription.trim();
   }

   static int getDurationInWeeks() throws InvalidInputException {
      getDisplayUtil().print(MenuOptions.ENTER_COURSE_DURATION);
      try {
         return Integer.parseInt(scanner.nextLine());
      } catch (Exception e){
         getDisplayUtil().printBlankLine();
         throw new InvalidInputException(AppConstants.ERROR + MenuOptions.INVALID_COURSE_DURATION);
      }
   }

   static String getFirstName(){
      getDisplayUtil().print(MenuOptions.ENTER_STUDENT_FIRST_NAME);
      String firstName = scanner.nextLine();
      return firstName.trim();
   }

   static String getLastName(){
      getDisplayUtil().print(MenuOptions.ENTER_STUDENT_LAST_NAME);
      String lastName = scanner.nextLine();
      return lastName.trim();
   }

   static String getEmail(){
      getDisplayUtil().print(MenuOptions.ENTER_STUDENT_EMAIL);
      String email = scanner.nextLine();
      return email.trim();
   }

   static int getStudentId() throws InvalidInputException {
      getDisplayUtil().print(MenuOptions.ENTER_STUDENT_ID);
      try {
         return Integer.parseInt(scanner.nextLine());
      } catch (Exception e){
         getDisplayUtil().printBlankLine();
         throw new InvalidInputException(AppConstants.ERROR + MenuOptions.INVALID_STUDENT_ID);
      }
   }

   static EnrollmentStatus getStatus() throws InvalidInputException {
      getDisplayUtil().print(MenuOptions.ENTER_STUDENT_NEW_STATUS);
      try {
         String status = scanner.nextLine();
         switch (status) {
            case "1" -> {
               return EnrollmentStatus.COMPLETED;
            }
            case "2" -> {
               return EnrollmentStatus.CANCELED;
            }
            default -> getDisplayUtil().println(MenuOptions.INVALID_STUDENT_NEW_STATUS);
         }
         return null;
      } catch (Exception e){
         getDisplayUtil().printBlankLine();
         throw new InvalidInputException(AppConstants.ERROR + MenuOptions.INVALID_STUDENT_NEW_STATUS);
      }
   }
}
