import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BudgetTracker {

    private List<Expense> expenses;
    private static final String FILE_NAME = "expenses.txt";

    public BudgetTracker() {
        this.expenses = new ArrayList<>();
        loadExpenses();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }

    public void viewExpenses() {
        // Debug statement
        System.out.println("Current expenses list: " + expenses);
        
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    public void removeExpense(int index) {
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            saveExpenses();
            System.out.println("Expense removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void clearAllExpenses() {
        expenses.clear();
        saveExpenses();
    }

    public double getTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    private void saveExpenses() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense expense : expenses) {
                writer.write(expense.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    private void loadExpenses() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String category = parts[0].split("=")[1];
                String description = parts[1].split("=")[1];
                double amount = Double.parseDouble(parts[2].split("=")[1].replace('}', ' ').trim());
                expenses.add(new Expense(category, description, amount));
            }
        } catch (FileNotFoundException e) {
            // File not found, which is fine the first time the program runs
            expenses = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
            expenses = new ArrayList<>();
        }
    }
}
