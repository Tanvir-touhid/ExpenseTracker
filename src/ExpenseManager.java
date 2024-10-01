import java.util.ArrayList;
public class ExpenseManager {
    ArrayList<Expense> expenses;

    ExpenseManager(){
        expenses = new ArrayList<>();
    }

    public void addExpense(String d, double a, String c){
        expenses.add(new Expense(d,a,c));
        System.out.println("Expense Added Successfully");
    }

    public void viewExpenses(){
        if(expenses.isEmpty()){
            System.out.println("No expense to display.");
            return;
        }
        for(Expense p: expenses){
            System.out.println(p);
        }
    }

    public void generateReport(){
        double total = 0;
        for(Expense p: expenses){
            total += p.getAmount();
        }
        System.out.println("Total Expenses: "+ total + "$.");
    }

    public ArrayList<Expense> getExpenses(){
        return expenses;
    }
}
