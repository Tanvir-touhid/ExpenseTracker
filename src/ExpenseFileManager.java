import java.io.*;
import java.util.ArrayList;

public class ExpenseFileManager {
    private static final String File_Name = "expenses.txt";

    public static void saveExpenses(ArrayList<Expense> expenses){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(File_Name))){
            for(Expense e: expenses){
                bw.write(e.getDescription() + "," + e.getAmount() + "," + e.getCategory());
                bw.newLine();
            }
            System.out.println("Expenses saved successfully.");
        }
        catch (IOException x){
            System.out.println("Error saving expenses: " + x.getMessage());
        }
    }

    public static void loadExpenses(ExpenseManager em){
        File file = new File(File_Name);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(File_Name))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String description = parts[0];
                    double amount = Double.parseDouble(parts[1]);
                    String category = parts[2];
                    em.addExpense(description, amount, category);
                }
                System.out.println("Expenses loaded successfully.");
            } catch (IOException e) {
                System.out.println("Error loading expenses: " + e.getMessage());
            }
        } else {
            System.out.println("No previous expenses found.");
        }
    }
}
