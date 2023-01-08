import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    double num1;
    double num2;
    String operation;
    
    System.out.println("Welcome to the expert calculator!");
    System.out.println("Enter the first number: ");
    num1 = scan.nextDouble();
    System.out.println("Enter the second number: ");
    num2 = scan.nextDouble();
    System.out.println("Enter the operation (+, -, *, /): ");
    operation = scan.next();
    
    if (operation.equals("+")) {
      System.out.println(num1 + num2);
    } else if (operation.equals("-")) {
      System.out.println(num1 - num2);
    } else if (operation.equals("*")) {
      System.out.println(num1 * num2);
    } else if (operation.equals("/")) {
      System.out.println(num1 / num2);
    } else {
      System.out.println("Invalid operator. Please try again.");
    }
    
    scan.close();
  }
}