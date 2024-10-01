public class Expense {
    private String description;
    private double amount;
    private String category;

    Expense(String d, double a, String c){
        description = d;
        amount = a;
        category = c;
    }

    public String getDescription(){
        return description;
    }

    public double getAmount() {
        return amount;
    }
    public String getCategory(){
        return category;
    }

    @Override
    public String toString(){
        return "Description: " + description + ", Amount: $" + amount + ", Category: " + category;
    }
}
