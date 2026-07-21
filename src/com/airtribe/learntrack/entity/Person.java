
package com.airtribe.learntrack.entity;

/**
 * Base class representing a person with basic identity details.
 */
public abstract class Person {
   private int id;
   private String firstName;
   private String lastName;
   private String email;

   /**
    * Default protected constructor.
    */
   protected Person() {}

   /**
    * Creates a person with full details.
    *
    * @param id        unique identifier
    * @param firstName first name
    * @param lastName  last name
    * @param email     email address
    */
   protected Person(int id, String firstName, String lastName, String email) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   /**
    * Creates a person without an email.
    *
    * @param id        unique identifier
    * @param firstName first name
    * @param lastName  last name
    */
   protected Person(int id, String firstName, String lastName) {
      this(id, firstName, lastName, "");
   }

   /**
    * @return person ID
    */
   public int getId() {
      return id;
   }

   /**
    * @return first name
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * @return last name
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * @return email address
    */
   public String getEmail() {
      return email;
   }

   /**
    * Updates the email address.
    *
    * @param email new email
    */
   public void setEmail(String email) {
      this.email = email;
   }

   /**
    * @return formatted println name of the person
    */
   protected abstract String getDisplayName();

}
