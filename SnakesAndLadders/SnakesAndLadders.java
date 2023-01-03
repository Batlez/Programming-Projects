import java.util.Random;
import java.util.Scanner;

public class SnakesAndLadders {
  public static void main(String[] args) {
    int position = 0;
    int dice;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Snakes and Ladders!");

    while(position < 100) {
      dice = random.nextInt(6) + 1;
      System.out.println("You rolled a " + dice + ".");
      position += dice;

      if(position > 100) {
        position = 200 - position;
      }

      System.out.println("You are now on square " + position + ".");

      if(position == 3) {
        position = 22;
        System.out.println("You landed on a ladder! You are now on square " + position + ".");
      } else if(position == 5) {
        position = 8;
        System.out.println("You landed on a ladder! You are now on square " + position + ".");
      } else if(position == 11) {
        position = 2;
        System.out.println("You landed on a snake! You are now on square " + position + ".");
      } else if(position == 20) {
        position = 10;
        System.out.println("You landed on a snake! You are now on square " + position + ".");
      }

      if(position == 100) {
        System.out.println("Congratulations! You won the game!");
      } else {
        System.out.println("Press enter to roll the dice again.");
        scanner.nextLine();
      }
    }
  }
}