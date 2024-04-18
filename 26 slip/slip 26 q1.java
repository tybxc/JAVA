import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployeeDetails {
    static final String URL = "jdbc:postgresql://localhost:5432/mydatabase";
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
            handleSQLException(e);
        }
    }

    private static void handleSQLException(SQLException e) {
        System.err.println("SQL Exception:");
        while (e != null) {
            System.err.println("Message: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            e = e.getNextException();
        }
    }
}
