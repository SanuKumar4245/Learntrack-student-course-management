package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores and provides access to all enrollment records.
 */
public class EnrollmentRepository {

   private static final List<Enrollment> enrollmentsList = new ArrayList<>();

   /**
    * @return the list of all stored enrollments
    */
   public List<Enrollment> getEnrollments(){
      return enrollmentsList;
   }

}
