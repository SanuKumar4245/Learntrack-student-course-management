
package com.airtribe.learntrack.util.DisplayManager;

import com.airtribe.learntrack.constants.AppConstants;

/**
 * Console-based implementation of {@link DisplayServices} that prints
 * messages, blank lines, and formatted output to the system console.
 */
public class ConsoleDisplayService implements DisplayServices {

   /**
    * {@inheritDoc}
    */
   @Override
   public void println(String s) {
      System.out.println(s);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void printWithLeadingBlankLine(String s) {
      printBlankLine();
      println(s);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void printWithSurroundingBlankLines(String s) {
      printWithLeadingBlankLine(s);
      printBlankLine();
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void printBlankLine() {
      println("");
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void displayError(String s) {
      printWithSurroundingBlankLines(AppConstants.ERROR + s);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void print(String s) {
      System.out.print(s);
   }
}
