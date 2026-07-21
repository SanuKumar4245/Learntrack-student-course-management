
package com.airtribe.learntrack.entity;

/**
 * Represents a student with personal details and active status.
 */
public class Student extends Person {
   private boolean active;

   /**
    * Creates a student with full details.
    *
    * @param id        student ID
    * @param firstName first name
    * @param lastName  last name
    * @param email     email address
    */
   public Student(int id, String firstName, String lastName, String email) {
      super(id, firstName, lastName, email);
   }

   /**
    * Creates a student without an email.
    *
    * @param id        student ID
    * @param firstName first name
    * @param lastName  last name
    */
   public Student(int id, String firstName, String lastName) {
      super(id, firstName, lastName);
   }

   /**
    * @return formatted println name for the student
    */
   @Override
   public String getDisplayName() {
      return "Student Display Name: " + this.getFirstName() + " " + this.getLastName();
   }

   /**
    * Updates the active status of the student.
    *
    * @param active new active status
    */
   public void setActive(boolean active) {
      this.active = active;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString() {
      return  "────────────── STUDENT DETAILS ──────────────\n" +
              "ID                : " + this.getId() + "\n" +
              "Name              : " + this.getFirstName() + " " + this.getLastName() + "\n" +
              "Email             : " + (this.getEmail() != null ? this.getEmail() : "N/A") + "\n" +
              "Active            : " + this.active + "\n" +
              "────────────────────────────────────────────";
   }

}
