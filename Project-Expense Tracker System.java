import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private final ArrayList<Integer> ids = new ArrayList<>();
    private final ArrayList<String> categories = new ArrayList<>();
    private final ArrayList<Double> amounts = new ArrayList<>();

    public void addExpense(int id, String category, double amount) {
        ids.add(id);
        categories.add(category);
        amounts.add(amount);
        System.out.println("Expense added successfully.");
    }

    public void viewExpenses() {
        if (ids.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\nID\tCategory\tAmount");
        System.out.println("--------------------------------");

        for (int i = 0; i < ids.size(); i++) {
            System.out.printf("%d\t%s\t\t₹%.2f%n",
                    ids.get(i), categories.get(i), amounts.get(i));
        }
    }

    public void searchExpense(int id) {
        int index = ids.indexOf(id);

        if (index == -1) {
            System.out.println("Expense not found.");
            return;
        }

        System.out.println("ID: " + ids.get(index));
        System.out.println("Category: " + categories.get(index));
        System.out.printf("Amount: ₹%.2f%n", amounts.get(index));
    }

    public void updateExpense(int id, String category, double amount) {
        int index = ids.indexOf(id);

        if (index == -1) {
            System.out.println("Expense not found.");
            return;
        }

        categories.set(index, category);
        amounts.set(index, amount);
        System.out.println("Expense updated successfully.");
    }

    public void deleteExpense(int id) {
        int index = ids.indexOf(id);

        if (index == -1) {
            System.out.println("Expense not found.");
            return;
        }

        ids.remove(index);
        categories.remove(index);
        amounts.remove(index);
        System.out.println("Expense deleted successfully.");
    }

    public void totalExpense() {
        double total = 0;

        for (double amount : amounts) {
            total += amount;
        }

        System.out.printf("Total expense: ₹%.2f%n", total);
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    tracker.addExpense(id, category, amount);
                    break;

                case 2:
                    tracker.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    tracker.searchExpense(id);
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new category: ");
                    category = scanner.nextLine();

                    System.out.print("Enter new amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();

                    tracker.updateExpense(id, category, amount);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    tracker.deleteExpense(id);
                    break;

                case 6:
                    tracker.totalExpense();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        scanner.close();
    }
}
