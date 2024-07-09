import java.io.Serializable;

public class Expense implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String category;
    private final String description;
    private final double amount;

    public Expense(String category, String description, double amount) {
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Expense{category='" + category + "', description='" + description + "', amount=" + amount + "}";
    }
}
