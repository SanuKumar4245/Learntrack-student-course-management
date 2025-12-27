package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores and provides access to the list of all courses.
 */
public class CourseRepository {

   private static final List<Course> coursesList = new ArrayList<>();

   /**
    * @return the list of all stored courses
    */
   public List<Course> getCourses(){
      return coursesList;
   }
}
