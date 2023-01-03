import java.util.Scanner;

public class ATM {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int balance = 1000;
    int withdraw;
    int deposit;
    int choice;
    int pin = 1234;
    
    System.out.println("Welcome to the ATM!");
    System.out.println("Enter your PIN: ");
    int enteredPin = scan.nextInt();
    
    if (enteredPin != pin) {
      System.out.println("Invalid PIN. Exiting...");
      return;
    }
    
    while (true) {
      System.out.println("Please choose one of the following options: ");
      System.out.println("1. Check balance");
      System.out.println("2. Withdraw funds");
      System.out.println("3. Deposit funds");
      System.out.println("4. Exit");
      choice = scan.nextInt();
      
      if (choice == 1) {
        System.out.println("Your current balance is: " + balance);
      } else if (choice == 2) {
        System.out.println("Enter the amount you would like to withdraw: ");
        withdraw = scan.nextInt();
        if (withdraw > balance) {
          System.out.println("Insufficient funds. Please try again.");
          continue;
        }
        balance = balance - withdraw;
        System.out.println("Please take your cash.");
      } else if (choice == 3) {
        System.out.println("Enter the amount you would like to deposit: ");
        deposit = scan.nextInt();
        balance = balance + deposit;
        System.out.println("Your updated balance is: " + balance);
      } else if (choice == 4) {
        System.out.println("Exiting ATM. Thank you for using our services.");
        break;
      } else {
        System.out.println("Invalid choice. Please try again.");
      }
    }
    
    scan.close();
  }
}