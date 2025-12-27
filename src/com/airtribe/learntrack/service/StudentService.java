
package com.airtribe.learntrack.service;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;

import com.airtribe.learntrack.util.DisplayManager.DisplayServices;
import static com.airtribe.learntrack.util.IdGenerator.getNextStudentId;
import static com.airtribe.learntrack.util.InputValidator.validateStudentDetails;

/**
 * Manages student operations such as add, remove, update, list, and view details.
 */
public class StudentService {

   private final DisplayServices displayServices;
   private final StudentRepository studentRepository = new StudentRepository();

   private StudentRepository getStudentRepository(){ return studentRepository; }
   private DisplayServices getDisplayManager(){ return displayServices; }


   /**
    * Initializes the StudentService with a DisplayServices instance.
    *
    * @param displayServices service used for display operations
    */
   public StudentService(DisplayServices displayServices){
      this.displayServices = displayServices;
   }

   /**
    * Adds a new student after validating details; email is optional.
    *
    * @param firstName student's first name
    * @param lastName  student's last name
    * @param email     student's email (optional)
    */
   public void addStudent(String firstName, String lastName, String email){
      if(!validateStudentDetails(firstName, lastName)){
         return;
      }
      Student newStudent = email.isEmpty() ?
              new Student(getNextStudentId(), firstName, lastName)
              : new Student(getNextStudentId(), firstName, lastName, email);

      getStudentRepository().getStudentsList().add(newStudent);
      getDisplayManager().printWithSurroundingBlankLines("Student added successfully!");
   }

   /**
    * Removes a student by ID if present.
    *
    * @param id student ID
    */
   public void removeStudent(int id){
      Student student = getStudentById(id);
      if(student == null){
         getDisplayManager().displayError(AppConstants.STUDENT_WITH_ID + id + AppConstants.NOT_FOUND);
         return;
      }
      getStudentRepository().getStudentsList().remove(student);
      getDisplayManager().printWithSurroundingBlankLines(AppConstants.STUDENT_WITH_ID + id + " removed successfully!");
   }

   /**
    * Updates a student's email by ID.
    *
    * @param id      student ID
    * @param emailId new email address
    */
   public void updateStudentEmailId(int id, String emailId){
      if(emailId.isEmpty()){
         getDisplayManager().displayError(AppConstants.EMPTY_EMAIL_ID);
         return;
      }
      Student student = getStudentById(id);
      if(student == null){
         getDisplayManager().displayError(AppConstants.STUDENT_WITH_ID + id + AppConstants.NOT_FOUND);
         return;
      }
      student.setEmail(emailId);
      getDisplayManager().printWithSurroundingBlankLines("Student's email id updated successfully!");
   }

   /**
    * Prints the list of all students.
    */
   public void listStudents(){
      getDisplayManager().println("List of students:");
      for(Student student : getStudentRepository().getStudentsList()){
         getDisplayManager().println(student.toString());
      }
   }

   /**
    * Prints details of a student by ID.
    *
    * @param id student ID
    */
   public void viewStudentDetails(int id){
      Student student = getStudentById(id);
      if(student == null){
         getDisplayManager().displayError(AppConstants.STUDENT_WITH_ID + id + AppConstants.NOT_FOUND);
         return;
      }
      getDisplayManager().println(student.toString());
   }

   Student getStudentById(int id){
      for(Student student : getStudentRepository().getStudentsList()){
         if(student.getId() == id){
            return student;
         }
      }
      return null;
   }

}
