package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class FinanceManager {

    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void addTransaction (Transaction t){
        transactions.add(t);
    }

    public static double getTotalIncome() {
        double total = 0;
        for (Transaction transaction : transactions) {
            if (transaction instanceof Income) {
                total = total + transaction.getAmount();
            }
        }
        return total;
    }

    public static double getTotalExpenses() {
        double total = 0;
        for (Transaction transaction : transactions) {
            if (transaction instanceof Expense) {
                total = total + transaction.getAmount();
            }
        }
        return total;
    }

    public static double getBalance() {
        double balance;
        balance = getTotalIncome() - getTotalExpenses();
        return balance;
    }

    public static HashMap<Category,Double> getExpensesByCategory() {
        HashMap<Category, Double> expensesByCategory = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (transaction instanceof Expense) {
                Expense exp = (Expense) transaction;
                Category cat = exp.getCategory();
                double currentTotal = expensesByCategory.getOrDefault(cat, 0.0);
                double newTotal = currentTotal + exp.getAmount();
                expensesByCategory.put(cat, newTotal);
            }
        }
        return expensesByCategory;
    }

    public static void printSummary() {
        HashMap<Category, Double> expensesCategory = getExpensesByCategory();
        System.out.println("Your total income is " + getTotalIncome() + ", your total expenses are " + getTotalExpenses() + ", your balance is " + getBalance() + " and these your expenses" +
                " by category " + expensesCategory);
        for (Category i : expensesCategory.keySet()) {
            System.out.println("Category: " + i + " Value: " + expensesCategory.get(i));
        }
    }
}




