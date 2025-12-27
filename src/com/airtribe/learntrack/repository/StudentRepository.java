
package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores and provides access to the list of all students.
 */
public class StudentRepository {

   private static final List<Student> students = new ArrayList<>();

   /**
    * @return the list of all stored students
    */
   public List<Student> getStudentsList(){
      return students;
   }

}
