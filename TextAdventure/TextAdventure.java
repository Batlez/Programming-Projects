import java.util.Scanner;

public class TextAdventure {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input;
    int location = 1;
    int health = 100;
    int gold = 0;
    boolean hasKey = false;
    
    System.out.println("Welcome to the text adventure game!");
    
    while (true) {
      if (location == 1) {
        System.out.println("You are in a forest. There is a path to the north and a path to the east.");
        System.out.println("Which direction do you want to go? (north/east)");
        input = scan.nextLine();
        
        if (input.equals("north")) {
          location = 2;
        } else if (input.equals("east")) {
          location = 3;
        } else {
          System.out.println("Invalid input. Please try again.");
        }
      } else if (location == 2) {
        System.out.println("You are at the edge of a cliff. There is a path to the south.");
        System.out.println("Which direction do you want to go? (south)");
        input = scan.nextLine();
        
        if (input.equals("south")) {
          location = 1;
        } else {
          System.out.println("Invalid input. Please try again.");
        }
      } else if (location == 3) {
        if (!hasKey) {
          System.out.println("You are in a clearing. There is a path to the west and a path to the east.");
          System.out.println("You see a small chest on the ground. Do you want to open it? (y/n)");
          input = scan.nextLine();
          
          if (input.equals("y")) {
            System.out.println("You found a key!");
            hasKey = true;
          } else if (input.equals("n")) {
            System.out.println("You leave the chest untouched.");
          } else {
            System.out.println("Invalid input. Please try again.");
          }
        } else {
          System.out.println("You are in a clearing. There is a path to the west and a path to the east.");
          System.out.println("Which direction do you want to go? (west/east)");
          input = scan.nextLine();
          
          if (input.equals("west")) {
            location = 1;
          } else if (input.equals("east")) {
            location = 4;
          } else {
            System.out.println("Invalid input. Please try again.");
          }
        }
      } else if (location == 4) {
    	System.out.println("You are in a cave. There is a path to the west.");
        System.out.println("You see a dragon sleeping in the cave. Do you want to try to steal its treasure? (y/n)");
        input = scan.nextLine();
        
        if (input.equals("n")) {
        System.out.println("You ran away north!");
          location = 2;
        } else {
          System.out.println("You have died. Please try again!");
         System.exit(0);
        }
      }
    }
  }
}