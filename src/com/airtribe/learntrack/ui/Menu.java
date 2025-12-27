package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.util.ServiceHandler;

/**
 * Entry point of the application. Initializes services and launches the menu-driven system.
 */
public class Menu {

   public static void main(String[] args) {
      ServiceHandler.initializeServices();
      ServiceHandler.startService();
   }

}
