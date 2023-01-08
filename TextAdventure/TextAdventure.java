import java.util.Random;
import java.util.Scanner;

public class TextAdventure {
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the text adventure game!");
    System.out.println("You are a brave adventurer exploring a dangerous cave.");
    System.out.println("You are armed with a trusty sword and a magical shield.");
    System.out.println();

    int health = 100;
    int attack = 10;
    int defense = 20;
    int reputation = 0;
    int potions = 3;

    while (health > 0) {
      System.out.println("Health: " + health);
      System.out.println("Attack: " + attack);
      System.out.println("Defense: " + defense);
      System.out.println("Reputation: " + reputation);
      System.out.println("Potions: " + potions);
      System.out.println();

      System.out.println("What do you want to do?");
      System.out.println("1. Go deeper into the cave");
      System.out.println("2. Search for treasure");
      System.out.println("3. Drink a potion");
      System.out.println("4. Talk to an NPC");
      System.out.println("5. Quit the game");

      int choice = scanner.nextInt();

      if (choice == 1) {
        int monsterHealth = 50;
        int monsterAttack = 5;
        int monsterDefense = 10;

        System.out.println("You encountered a monster!");
        while (monsterHealth > 0 && health > 0) {
          System.out.println("You attack the monster with your sword for " + attack + " damage.");
          int damage = attack - monsterDefense;
          if (damage > 0) {
            monsterHealth -= damage;
          }
          if (monsterHealth <= 0) {
            System.out.println("You defeated the monster!");
            reputation += 10;
            break;
          }

          System.out.println("The monster attacks you for " + monsterAttack + " damage.");
          health -= monsterAttack;
          if (health <= 0) {
            System.out.println("You were defeated by the monster!");
            reputation -= 20;
            break;
          }
        }
      } else if (choice == 2) {
        int treasure = rand.nextInt(100);
        System.out.println("You found " + treasure + " gold coins!");
      } else if (choice == 3) {
        if (potions > 0) {
          health += 20;
          potions--;
          System.out.println("You drank a potion and recovered 20 health points.");
          
      } else if (choice == 4) {
            if (reputation < 0) {
              System.out.println("The NPC ignores you because of your poor reputation.");
            } else {
              int response = rand.nextInt(3);
              if (response == 0) {
                System.out.println("The NPC gives you a quest to complete.");
                reputation += 30;
              } else if (response == 1) {
                System.out.println("The NPC gives you a helpful tip.");
                reputation += 10;
              } else {
                System.out.println("The NPC asks for your help with a problem.");
                reputation += 20;
              }
            }
          } else if (choice == 5) {
            System.out.println("Thanks for playing!");
            System.exit(0);
            
          } else {
            System.out.println("Invalid choice. Please try again.");
          }
        }
      } 
    } 
  }