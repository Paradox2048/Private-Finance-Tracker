package Model;

import java.time.LocalDate;

public abstract class Transaction {
    private double amount;
    private LocalDate date;
    private String description;
    private Integer getTotalValue;

    public Transaction(double amount, LocalDate date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }

    public Integer getTotalValue(){
        if (getAmount() != 0);
        int totalValue = (int) (getAmount() + getAmount());


        return 0;
    }

    public abstract String getSummaryLine(); // each subclass formats itself differently
}
