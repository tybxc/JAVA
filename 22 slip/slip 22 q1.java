import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagementSystem {
    static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nEmployee Management System Menu:");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        insertEmployee();
                        break;
                    case 2:
                        updateEmployee();
                        break;
                    case 3:
                        displayEmployees();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    static void insertEmployee() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Employee (ENo, EName, Salary) VALUES (?, ?, ?)")) {
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Employee Number: ");
            int eno = scanner.nextInt();
            System.out.print("Enter Employee Name: ");
            String ename = scanner.next();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            
            statement.setInt(1, eno);
            statement.setString(2, ename);
            statement.setDouble(3, salary);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("Failed to insert employee.");
            }
        }
    }
    
    static void updateEmployee() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE Employee SET EName = ?, Salary = ? WHERE ENo = ?")) {
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Employee Number: ");
            int eno = scanner.nextInt();
            System.out.print("Enter new Employee Name: ");
            String ename = scanner.next();
            System.out.print("Enter new Salary: ");
            double salary = scanner.nextDouble();
            
            statement.setString(1, ename);
            statement.setDouble(2, salary);
            statement.setInt(3, eno);
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("No employee found with the provided Employee Number.");
            }
        }
    }
    
    static void displayEmployees() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employee");
             ResultSet resultSet = statement.executeQuery()) {
            
            System.out.println("\nEmployee Details:");
            System.out.println("ENo\tEName\tSalary");
            while (resultSet.next()) {
                int eno = resultSet.getInt("ENo");
                String ename = resultSet.getString("EName");
                double salary = resultSet.getDouble("Salary");
                
                System.out.println(eno + "\t" + ename + "\t" + salary);
            }
        }
    }
}
