import db.DatabaseConnection;
import db.DatabaseOperations;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection == null) {
                System.out.println("Failed to connect to the database.");
                return;
            }

            DatabaseOperations operations = new DatabaseOperations();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. List all employees");
                System.out.println("2. List all tasks");
                System.out.println("3. List employees by department");
                System.out.println("4. Add task to employee");
                System.out.println("5. List tasks by employee");
                System.out.println("6. Delete employee");
                System.out.println("0. Exit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> operations.listEmployees(connection);
                    case 2 -> operations.listTasks(connection);
                    case 3 -> {
                        System.out.print("Enter department ID: ");
                        int deptId = scanner.nextInt();
                        operations.listEmployeesByDepartment(connection, deptId);
                    }
                    case 4 -> {
                        System.out.print("Enter task description: ");
                        scanner.nextLine(); // Consume newline
                        String description = scanner.nextLine();
                        System.out.print("Enter employee ID: ");
                        int empId = scanner.nextInt();
                        operations.addTask(connection, description, empId);
                    }
                    case 5 -> {
                        System.out.print("Enter employee ID: ");
                        int empId = scanner.nextInt();
                        operations.listTasksByEmployee(connection, empId);
                    }
                    case 6 -> {
                        System.out.print("Enter employee ID: ");
                        int empId = scanner.nextInt();
                        operations.deleteEmployee(connection, empId);
                    }
                    case 0 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice, try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}