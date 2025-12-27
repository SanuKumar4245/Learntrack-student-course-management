package com.airtribe.learntrack.util;

/**
 * Generates incremental IDs for students, courses, and enrollments.
 */
public abstract class IdGenerator {

   private IdGenerator() {}

   private static int studentIdCounter = 0;
   private static int courseIdCounter = 0;
   private static int enrollmentIdCounter = 0;

   /**
    * @return next student ID
    */
   public static int getNextStudentId() {
      return ++studentIdCounter;
   }

   /**
    * @return next course ID
    */
   public static int getNextCourseId() {
      return ++courseIdCounter;
   }

   /**
    * @return next enrollment ID
    */
   public static int getNextEnrollmentId() {
      return ++enrollmentIdCounter;
   }
}
