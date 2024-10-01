import java.util.Scanner;
public class ExpenseTrackerApp {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        ExpenseFileManager.loadExpenses(manager);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nExpense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Generate Report");
            System.out.println("4. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    manager.addExpense(description, amount, category);
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    manager.generateReport();
                    break;

                case 4:
                    ExpenseFileManager.saveExpenses(manager.getExpenses());
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
