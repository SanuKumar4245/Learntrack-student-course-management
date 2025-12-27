
package com.airtribe.learntrack.util.DisplayManager;

/**
 * Provides display-related utility methods for printing messages,
 * errors, and formatted output to the user interface.
 */
public interface DisplayServices {

   /**
    * Prints the given string followed by a newline.
    *
    * @param string the text to print
    */
   void println(String string);

   /**
    * Prints a blank line before printing the given string.
    *
    * @param string the text to print
    */
   void printWithLeadingBlankLine(String string);

   /**
    * Prints a blank line before and after the given string.
    *
    * @param string the text to print
    */
   void printWithSurroundingBlankLines(String string);

   /**
    * Prints a blank line.
    */
   void printBlankLine();

   /**
    * Displays an error message.
    *
    * @param errorMessage the error message to display
    */
   void displayError(String errorMessage);

   /**
    * Prints the given string without a trailing newline.
    *
    * @param text the text to print
    */
   void print(String text);
}
