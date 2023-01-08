import java.util.Random;
import java.util.Scanner;

public class DiceGam {
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    int computerRoll = rand.nextInt(6) + 1;

    System.out.print("Enter your dice roll (1-6): ");
    int userRoll = scanner.nextInt();

    if (userRoll > computerRoll) {
      System.out.println("You win!");
    } else if (computerRoll > userRoll) {
      System.out.println("Computer wins!");
    } else {
      System.out.println("It's a tie!");
    }
  }
}