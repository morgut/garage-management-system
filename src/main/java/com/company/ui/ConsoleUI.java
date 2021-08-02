package com.company.ui;

import com.company.ui.entities.UILogic;
import com.company.ui.enums.MenuOption;
import com.company.ui.exceptions.InputValidatorException;
import com.company.ui.validators.InputValidator;
import java.util.Scanner;

public class ConsoleUI {
  private UILogic logic;
  
  public ConsoleUI(UILogic logic) {
    this.logic = logic;
  }
  
  public void run() {
    int option;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hello and welcome to the Garage Management System");
    do {
      printMenu();
      option = scanner.nextInt();
      try {
        String menuOption = InputValidator.validateMenuOption(option);
        MenuOption.valueOf(menuOption).execute(logic);
      } catch (InputValidatorException e) {
        e.getExtraMessage();
      }
    } while(MenuOption.EXIT.getOption() != option);
  }
  
  private void printMenu() {
    System.out.println("What would you like to do?");
    System.out.println("1. Add new vehicle to the garage");
    System.out.println("2. Display all garage vehicles' license numbers");
    System.out.println("3. Update a specific garage vehicle's status");
    System.out.println("4. Inflate a specific wheel's air pressure");
    System.out.println("5. Fuel a specific garage fueled vehicle");
    System.out.println("6. Charge a specific garage electric vehicle");
    System.out.println("7. Display all garage vehicles' details");
    System.out.println("8. Exit program");
    System.out.println("Please press the number of one of the options presented above");
  }
}
