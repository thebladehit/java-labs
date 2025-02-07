package db;

import java.sql.*;

public class DatabaseOperations {
    public void listEmployees(Connection connection) throws SQLException {
        String query = "SELECT * FROM employees";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            printALlData(rs);
        }
    }

    public void listTasks(Connection connection) throws SQLException {
        String query = "SELECT * FROM tasks";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            printALlData(rs);
        }
    }

    public void listEmployeesByDepartment(Connection connection, int departmentId) throws SQLException {
        String query = "SELECT * FROM employees WHERE department_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, departmentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                printALlData(rs);
            }
        }
    }

    public void addTask(Connection connection, String description, int employeeId) throws SQLException {
        String query = "INSERT INTO tasks (description, employee_id) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, description);
            pstmt.setInt(2, employeeId);
            pstmt.executeUpdate();
            System.out.println("Task added successfully.");
        }
    }

    public void listTasksByEmployee(Connection connection, int employeeId) throws SQLException {
        String query = "SELECT * FROM tasks WHERE employee_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            try (ResultSet rs = pstmt.executeQuery()) {
                printALlData(rs);
            }
        }
    }

    public void deleteEmployee(Connection connection, int employeeId) throws SQLException {
        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();
            System.out.println("Employee deleted successfully.");
        }
    }

    private void printALlData(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnValue = rs.getString(i);
                System.out.print(columnName + ": " + columnValue + " | ");
            }
            System.out.println();
        }
    }
}
