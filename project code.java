import java.util.HashMap;
import java.util.Scanner;

public class PasswordManagementSystem {

    private static HashMap<String, String> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nPassword Management System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Verify Password");
            System.out.println("4. Recover Password");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    verifyPassword();
                    break;
                case 4:
                    recoverPassword();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try another one.");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Registration successful!");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void verifyPassword() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password to verify: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Password verification successful!");
        } else {
            System.out.println("Password verification failed.");
        }
    }

    private static void recoverPassword() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Password recovery successful! Your password is: " + users.get(username));
        } else {
            System.out.println("Username not found.");
        }
    }
}