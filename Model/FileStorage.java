package Model;

import java.io.*;
import java.time.LocalDate;

public class FileStorage {
    public  static void saveTransaction (){
        try {FileWriter myWriter = new FileWriter("transactions.txt");
            for (Transaction transaction : FinanceManager.transactions){
                if (transaction instanceof Income){
                    Income inc = (Income) transaction;
                    myWriter.write("INCOME," + inc.getAmount() + "," + inc.getDate() + "," + inc.getDescription() + "," + inc.getSource() + "\n");
                } else if (transaction instanceof Expense){
                    Expense exp = (Expense) transaction;
                    myWriter.write("EXPENSE," + exp.getAmount() + "," + exp.getDate() + "," + exp.getDescription() + "," + exp.getCategory() + "\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("File not created.");
        }
    }

    public  static void loadTransaction() {
        try {BufferedReader br = new BufferedReader( (new FileReader("transactions.txt")));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
                String[] myArray = line.split(",");
                double value = Double.parseDouble(myArray[1]);
                if (myArray[0].equals("EXPENSE")){
                    Category category = Category.valueOf(myArray[4]);
                    LocalDate date = LocalDate.parse(myArray[2]);
                    FinanceManager.addTransaction(new Expense(value, date, myArray[3], category));
                } else {
                    LocalDate date = LocalDate.parse(myArray[2]);
                    FinanceManager.addTransaction(new Income(value, date, myArray[3], myArray[4]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error whilst loading the file.");
        }
    }
}