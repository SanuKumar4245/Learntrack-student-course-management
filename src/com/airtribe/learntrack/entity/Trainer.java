
package com.airtribe.learntrack.entity;

/**
 * Represents a trainer, extending base person details.
 */
public abstract class Trainer extends Person {

   /**
    * {@inheritDoc}
    */
   @Override
   protected String getDisplayName() {
      return "Trainer Display Name: " + this.getFirstName() + " " + this.getLastName();
   }
}
