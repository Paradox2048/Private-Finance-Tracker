
import Model.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Check Balance");
            System.out.println("4. Summary");
            System.out.println("5. Exit");
            int answer = -1;
            try {
                answer = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }

            if (answer == 5) {
                exit = true;
                FileStorage.saveTransaction();
            } else if (answer == 1) {
                double amount;
                String description;
                String source;
                System.out.print("How much would you like to add: ");
                amount = scanner.nextDouble();
                if (amount == 0 || amount < 0){
                    try {
                        throw new InvalidAmountException("Amount cannot be 0 or a negative number");
                    } catch (InvalidAmountException e) {
                        System.out.println("Amount cannot be a negative or 0.");
                    }
                } else {
                    scanner.nextLine();
                    System.out.println("Description: ");
                    description = scanner.nextLine();
                    System.out.print("What is the source: ");
                    source = scanner.nextLine();
                    FinanceManager.addTransaction(new Income(amount, LocalDate.now(), description, source));
                    System.out.println("Income added.");
                }
            }
            else if (answer == 2) {
                double amount;
                String description;
                String categoryInput;
                System.out.println("How much does the expense cost? ");
                amount = scanner.nextDouble();
                if (amount == 0 || amount < 0) {
                    try {
                        throw new InvalidAmountException("Amount cannot be 0 or a negative number");
                    } catch (InvalidAmountException e) {
                        System.out.println("Amount cannot be a negative or 0.");
                    }
                } else {
                    scanner.nextLine();
                    System.out.println("Description: ");
                    description = scanner.nextLine();
                    System.out.println("Type what category does it go in? ");
                    System.out.println("Rent, Food, Transport, Subscriptions, Entertainment, Bills, Other");
                    categoryInput = scanner.nextLine();
                    boolean isMatch = false;
                    Category selectedCategory = null;
                    for (Category c : Category.values()) {
                        if (c.name().equalsIgnoreCase(categoryInput)) {
                            isMatch = true;
                            selectedCategory = c;
                            break;
                        }
                    }
                    if (isMatch) {
                        FinanceManager.addTransaction(new Expense(amount, LocalDate.now(), description, selectedCategory));
                        System.out.println("Expenses added.");
                    } else {
                        System.out.println("Invalid category. Expenses not added.");
                    }
                }
                } else if (answer == 3) {
                    System.out.println("Your balance is " + FinanceManager.getBalance());
                } else if (answer == 4) {
                    FinanceManager.printSummary();
                } else {
                    System.out.println("Invalid Option.");
            }
        }
        scanner.close();
    }
}
