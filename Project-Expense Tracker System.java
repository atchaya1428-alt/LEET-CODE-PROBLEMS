import java.util.ArrayList;
import java.util.Scanner;

class Expense {

    private ArrayList<Integer> ids;
    private ArrayList<String> categories;
    private ArrayList<Double> amounts;

    public Expense() {
        ids = new ArrayList<>();
        categories = new ArrayList<>();
        amounts = new ArrayList<>();
    }

    public void addExpense(int id, String category, double amount) {
        ids.add(id);
        categories.add(category);
        amounts.add(amount);
        System.out.println("Expense Added Successfully.");
    }

    public void viewExpenses() {
        if (ids.isEmpty()) {
            System.out.println("No Expenses Found.");
            return;
        }

        System.out.println("\nID\tCategory\tAmount");
        for (int i = 0; i < ids.size(); i++) {
            System.out.println(ids.get(i) + "\t" + categories.get(i) + "\t\t₹" + amounts.get(i));
        }
    }

    public void searchExpense(int id) {
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                System.out.println("Category : " + categories.get(i));
                System.out.println("Amount : ₹" + amounts.get(i));
                return;
            }
        }
        System.out.println("Expense Not Found.");
    }

    public void updateExpense(int id, String category, double amount) {
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                categories.set(i, category);
                amounts.set(i, amount);
                System.out.println("Expense Updated Successfully.");
                return;
            }
        }
        System.out.println("Expense Not Found.");
    }

    public void deleteExpense(int id) {
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                ids.remove(i);
                categories.remove(i);
                amounts.remove(i);
                System.out.println("Expense Deleted Successfully.");
                return;
            }
        }
        System.out.println("Expense Not Found.");
    }

    public void totalExpense() {
        double total = 0;
        for (double amt : amounts) {
            total += amt;
        }
        System.out.println("Total Expense = ₹" + total);
    }
}

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Expense tracker = new Expense();

        int choice;

        do {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Total Expense");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    tracker.addExpense(id, category, amount);
                    break;

                case 2:
                    tracker.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter ID to Search: ");
                    id = sc.nextInt();
                    tracker.searchExpense(id);
                    break;

                case 4:
                    System.
out.print("Enter ID to Update: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Category: ");
                    category = sc.nextLine();

                    System.out.print("Enter New Amount: ");
                    amount = sc.nextDouble();

                    tracker.updateExpense(id, category, amount);
                    break;

                case 5:
                    System.out.print("Enter ID to Delete: ");
                    id = sc.nextInt();
                    tracker.deleteExpense(id);
                    break;

                case 6:
                    tracker.totalExpense();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
