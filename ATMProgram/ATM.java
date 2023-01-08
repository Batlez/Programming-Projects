import java.util.Scanner;

public class ATM {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int chequingBalance = 1000;
    int savingsBalance = 5000;
    int input;
    int amount;
    int account;
    int pin;
    
    System.out.println("Welcome to the ATM Machine!");
    System.out.println("1. Check balance");
    System.out.println("2. Withdraw money");
    System.out.println("3. Deposit money");
    System.out.println("4. Exit");
    System.out.println("Enter your choice: ");
    
    input = scan.nextInt();
    
    while (input != 4) {
      System.out.println("Enter your account (1 for chequing, 2 for savings): ");
      account = scan.nextInt();
      
      if (account == 1) {
        System.out.println("Enter your PIN: ");
        pin = scan.nextInt();
        
        if (pin == 1234) {
          if (input == 1) {
            System.out.println("Your chequing account balance is: " + chequingBalance);
          } else if (input == 2) {
            System.out.println("Enter the amount you want to withdraw from your chequing account: ");
            amount = scan.nextInt();
            
            if (amount > chequingBalance) {
              System.out.println("Insufficient balance. Please try again.");
            } else {
              chequingBalance -= amount;
              System.out.println("Please take your cash.");
            }
          } else if (input == 3) {
            System.out.println("Enter the amount you want to deposit into your chequing account: ");
            amount = scan.nextInt();
            chequingBalance += amount;
            System.out.println("Your updated chequing account balance is: " + chequingBalance);
          } else {
            System.out.println("Invalid input. Please try again.");
          }
        } else {
          System.out.println("Invalid PIN. Please try again.");
        }
      } else if (account == 2) {
        System.out.println("Enter your PIN: ");
        pin = scan.nextInt();
        
        if (pin == 5678) {
          if (input == 1) {
            System.out.println("Your savings account balance is: " + savingsBalance);
          } else if (input == 2) {
            System.out.println("Enter the amount you want to withdraw from your savings account: ");
            amount = scan.nextInt();
            
            if (amount > savingsBalance) {
              System.out.println("Insufficient balance. Please try again.");
            } else {
              savingsBalance -= amount;
              System.out.println("Please take your cash.");
            }
          } else if (input == 3) {
              System.out.println("Enter the amount you want to deposit into your savings account: ");
              amount = scan.nextInt();
              savingsBalance += amount;
              System.out.println("Your updated savings account balance is: " + savingsBalance);
            } else {
              System.out.println("Invalid input. Please try again.");
            }
          } else {
            System.out.println("Invalid PIN. Please try again.");
          }
        } else {
          System.out.println("Invalid account. Please try again.");
        }
        
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        
        input = scan.nextInt();
      }
      
      System.out.println("Thank you for using the ATM machine. Goodbye!");
      
      scan.close();
    }
  }