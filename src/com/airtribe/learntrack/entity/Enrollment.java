
package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;
import static com.airtribe.learntrack.util.IdGenerator.getNextEnrollmentId;

import java.util.Date;

/**
 * Represents a student's enrollment in a course, including status and date details.
 */
public class Enrollment {
   private final int id;
   private final Student student;
   private final Course course;
   private final Date enrollmentDate;
   private EnrollmentStatus status;

   /**
    * Creates a new enrollment for a student in a course,
    * assigning an ID, setting the date, and marking it active.
    *
    * @param student the enrolled student
    * @param course  the course the student is enrolled in
    */
   public Enrollment(Student student, Course course) {
      this.id = getNextEnrollmentId();
      this.student = student;
      this.course = course;
      this.enrollmentDate = new Date();
      this.status = EnrollmentStatus.ACTIVE;
      student.setActive(true);
   }

   private int getId() {
      return id;
   }

   /**
    * @return the student associated with this enrollment
    */
   public Student getStudent() {
      return student;
   }

   /**
    * @return the course associated with this enrollment
    */
   public Course getCourse() {
      return course;
   }

   /**
    * @return the date when the enrollment was created
    */
   public Date getEnrollmentDate() {
      return enrollmentDate;
   }

   /**
    * @return the current enrollment status
    */
   public EnrollmentStatus getStatus() {
      return status;
   }

   /**
    * Updates the enrollment status.
    *
    * @param status new status to set
    */
   public void setStatus(EnrollmentStatus status) {
      this.status = status;
   }

   /**
    * @return formatted enrollment details
    */
   @Override
   public String toString() {
      java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("dd-MMM-yyyy HH:mm z");
      fmt.setTimeZone(java.util.TimeZone.getTimeZone("Asia/Kolkata"));

      return  "──────────── ENROLLMENT DETAILS ────────────\n" +
              "Enrollment ID      : " + this.getId() + "\n" +
              "Student            : " + this.getStudent().getFirstName() + " " + this.getStudent().getLastName() + "\n" +
              "Course             : " + this.getCourse().getCourseName() + "\n" +
              "Enrollment Date    : " + fmt.format(this.getEnrollmentDate()) + "\n" +
              "Status             : " + this.getStatus() + "\n" +
              "────────────────────────────────────────────";
   }

}
