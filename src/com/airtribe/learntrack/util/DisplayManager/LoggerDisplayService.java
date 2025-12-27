
package com.airtribe.learntrack.util.DisplayManager;

/**
 * A logger-based implementation of {@link DisplayServices}.
 *
 * <p>
 * Currently provides empty method bodies. Intended for future extension where
 * output may be directed to logging frameworks instead of the console.
 * </p>
 */
public class LoggerDisplayService implements DisplayServices {

   /**
    * {@inheritDoc}
    */
   @Override
   public void println(String string) {
      // TODO: Implement logging behavior
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void printWithLeadingBlankLine(String string) {
      // TODO: Implement logging behavior
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void printWithSurroundingBlankLines(String string) {
      // TODO: Implement logging behavior
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void printBlankLine() {
      // TODO: Implement logging behavior
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void displayError(String string) {
      // TODO: Implement logging behavior
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void print(String string) {
      // TODO: Implement logging behavior
   }
}
