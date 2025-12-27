
package com.airtribe.learntrack.exception;

/**
 * Exception thrown when user input is invalid.
 */
public class InvalidInputException extends Exception {

   /**
    * Creates a new InvalidInputException with the specified message.
    *
    * @param message description of the invalid input error
    */
   public InvalidInputException(String message) {
      super(message);
   }

}
