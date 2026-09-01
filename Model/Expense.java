package Model;

import java.time.LocalDate;

public class Expense extends Transaction {
    private final Category category;

    public Expense(double amount, LocalDate date, String description, Category category) {
        super(amount, date, description);
        this.category = category;
    }

    public Category getCategory() { return category; }

    @Override
    public String getSummaryLine() {
        return "-£" + getAmount() + " | " + category + " | " + getDescription();
    }
}
