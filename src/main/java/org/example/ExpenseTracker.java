package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {
    private List<Expense> expenses;
    private double budgetLimit;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        budgetLimit = 0;
    }

    public void logExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();

        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter expense category: ");
        String category = scanner.next();

        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);

        System.out.println("Expense logged successfully.");
    }

    public void setBudgetLimit(double limit) {
        budgetLimit = limit;
        System.out.println("Budget limit set to: " + limit);
    }

    public void visualizeExpenses() {
        System.out.println("\nExpense Visualization:");
        for (Expense expense : expenses) {
            System.out.println(expense);

        }
    }
    public void setReminder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter reminder description: ");
        String description = scanner.nextLine();

        System.out.print("Enter due date (yyyy-mm-dd): ");
        String dueDateString = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.parse(dueDateString, formatter);

        Reminder reminder = new Reminder(description, dueDate);
        reminder.add(reminder);

        System.out.println("Reminder set successfully.");
    }

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n1. Log Expense\n2. Set Budget Limit\n3. Visualize Expenses\n4. Set Reminder\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    expenseTracker.logExpense();
                    break;
                case 2:
                    System.out.print("Enter budget limit: ");
                    double limit = scanner.nextDouble();
                    expenseTracker.setBudgetLimit(limit);
                    break;
                case 3:
                    expenseTracker.visualizeExpenses();
                    break;
                case 4:
                    expenseTracker.setReminder();
                    break;
                case 5:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    break;
                case 6:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}