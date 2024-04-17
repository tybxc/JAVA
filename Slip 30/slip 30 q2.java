import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "your_username";
        String password = "your_password";
        
        try {
            // Establishing database connection
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // Creating a statement with a scrollable ResultSet
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            // Executing query to select all columns from the Teacher table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Teacher");
            
            // Moving to the last row
            resultSet.last();
            
            // Getting the row count
            int rowCount = resultSet.getRow();
            
            System.out.println("Total rows in Teacher table: " + rowCount);
            
            // Moving back to the first row
            resultSet.beforeFirst();
            
            // Iterating over the ResultSet
            while (resultSet.next()) {
                int tid = resultSet.getInt("TID");
                String tname = resultSet.getString("TName");
                double salary = resultSet.getDouble("Salary");
                
                System.out.println("TID: " + tid + ", TName: " + tname + ", Salary: " + salary);
            }
            
            // Closing resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
