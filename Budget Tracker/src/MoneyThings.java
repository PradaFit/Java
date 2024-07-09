/**
 * 
 * Simple budget tracker in Java
 * @author PradaFit
 * 
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MoneyThings {

    private static final BudgetTracker budgetTracker = new BudgetTracker();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LOGO_PATH = "LOGO.txt"; // Prints my Logo

    public static void main(String[] args) {
        try (scanner) {
            boolean running = true;

            while (running) {
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Debug statement
                System.out.println("User selected option: " + choice);

                switch (choice) {
                    case 1 -> addExpense();
                    case 2 -> {
                        // Debug statement
                        System.out.println("Executing viewExpenses...");
                        viewExpenses();
                    }
                    case 3 -> removeExpense();
                    case 4 -> {
                        // Debug statement
                        System.out.println("Executing viewTotalExpenses...");
                        viewTotalExpenses();
                    }
                    case 5 -> running = false;
                    case 6 -> clearAllRestart();
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }

            System.out.println("Good bye!");
        }
    }

    private static void showMenu() {
        // clearConsole(); // This is temp
        printLogo();
        System.out.println("\nMoneyThings Budget Tracker Menu by PradaFit: ");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. Remove Expense");
        System.out.println("4. View Total Expenses");
        System.out.println("5. Exit");
        System.out.println("6. Clear All/Restart");
        System.out.print("Choose an option: ");
    }

    private static void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Expense expense = new Expense(category, description, amount);
        budgetTracker.addExpense(expense);
        System.out.println("Expense added.");
    }

    private static void viewExpenses() {
        System.out.println("Expenses: ");
        budgetTracker.viewExpenses();
    }

    private static void removeExpense() {
        System.out.print("Enter the index of the expense to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        budgetTracker.removeExpense(index - 1); // Adjusting for 0-based index
    }

    private static void viewTotalExpenses() {
        System.out.println("Total Expenses: $" + budgetTracker.getTotalExpenses());
    }

    private static void clearAllRestart() {
        budgetTracker.clearAllExpenses();
        // clearConsole(); // Temporarily comment this out for debugging
        System.out.println("All expenses cleared and screen refreshed.");
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error clearing the console: " + ex.getMessage());
        }
    }

    private static void printLogo() {
        try {
            Files.lines(Paths.get(LOGO_PATH)).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading logo file: " + e.getMessage());
        }
    }
}
