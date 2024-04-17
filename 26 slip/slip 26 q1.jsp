import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployeeDetails {
    static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DeleteEmployeeDetails <employee_id>");
            return;
        }
        
        int employeeId = Integer.parseInt(args[0]);
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Employee WHERE ENo = ?")) {
            
            statement.setInt(1, employeeId);
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee details deleted successfully.");
            } else {
                System.out.println("No employee found with the provided Employee ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
