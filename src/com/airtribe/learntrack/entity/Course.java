
package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;
import static com.airtribe.learntrack.util.IdGenerator.getNextCourseId;

/**
 * Represents a course with name, description, duration, and active status.
 */
public class Course {
   private final int id;
   private final String courseName;
   private final String description;
   private final int durationInWeeks;
   private CourseStatus status;

   /**
    * Creates a new course with the given details.
    *
    * @param courseName       name of the course
    * @param description      description of the course
    * @param durationInWeeks  course duration in weeks
    */
   public Course(String courseName, String description, int durationInWeeks) {
      this.id = getNextCourseId();
      this.courseName = courseName;
      this.description = description;
      this.durationInWeeks = durationInWeeks;
      this.status = CourseStatus.INACTIVE;
   }

   /**
    * @return course ID
    */
   public int getId() {
      return id;
   }

   /**
    * @return course name
    */
   public String getCourseName() {
      return courseName;
   }

   /**
    * @return course description
    */
   public String getDescription() {
      return description;
   }

   /**
    * @return duration of the course in weeks
    */
   public int getDurationInWeeks() {
      return durationInWeeks;
   }

   /**
    * @return true if the course is active
    */
   public boolean isActive() {
      return this.status.equals(CourseStatus.ACTIVE);
   }

   /**
    * Updates the course's active status.
    *
    * @param status new status to assign
    */
   public void setActive(CourseStatus status) {
      this.status = status;
   }

   /**
    * @return formatted course details
    */
   @Override
   public String toString() {
      return  "────────────── COURSE DETAILS ──────────────\n" +
              "ID                : " + this.getId() + "\n" +
              "Name              : " + this.getCourseName() + "\n" +
              "Description       : " + this.getDescription() + "\n" +
              "Duration (weeks)  : " + this.getDurationInWeeks() + "\n" +
              "Active            : " + this.isActive() + "\n" +
              "────────────────────────────────────────────";
   }
}
