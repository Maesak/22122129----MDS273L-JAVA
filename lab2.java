import java.util.ArrayList;
import java.util.Scanner;

public class lab2{
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int choice;
    do {
      System.out.println("\n -----Menu-----");
      System.out.println("1. Enter a name");
      System.out.println("2. Search for a name");
      System.out.println("3. Remove a name");
      System.out.println("4. Show all names");
      System.out.println("5. Quit");
      System.out.println("---------------------");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter a name: ");
          String name = scanner.nextLine();
          if (names.contains(name)) {
            System.out.println(name + " already exists. Please enter a unique name.");
          } else {
            names.add(name);
            System.out.println("Name added successfully.");
          }
          break;
        case 2:
          System.out.print("Enter a name to search: ");
          String s_name = scanner.nextLine();
          if (names.contains(s_name)) {
            System.out.println(s_name + " Name found.");
          } else {
            System.out.println(s_name + " Name not found.");
          }
          break;
        case 3:
          System.out.print("Enter a name to remove: ");
          String r_name = scanner.nextLine();
          if (names.remove(r_name)) {
            System.out.println(r_name + "this name is removed successfully.");
          } else {
            System.out.println(r_name + " this Name not found.");
          }
          break;
        case 4:
          System.out.println("All names:");
          for (String n : names) {
            System.out.println(n);
          }
          break;
        case 5:
          System.out.println("Exiting the program...");
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
      }
    } while (choice != 5);
    scanner.close();
  }
}

