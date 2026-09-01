package Model;

import java.time.LocalDate;

public class Income extends Transaction {
    private String source;

    public Income(double amount, LocalDate date, String description, String source) {
        super(amount, date, description);
        this.source = source;
    }

    public String getSource() { return source; }

    @Override
    public String getSummaryLine() {
        return "+£" + getAmount() + " | " + source + " | " + getDescription();
    }
}