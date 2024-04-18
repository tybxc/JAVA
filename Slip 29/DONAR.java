import java.sql.*;

public class ColumnInfo {
    // JDBC URL, username, and password of PostgreSQL server
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Register PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute query to get metadata
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DONAR");

            // Get metadata
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Get number of columns
            int columnCount = metaData.getColumnCount();
            System.out.println("Column Information for DONAR table:");

            // Loop through each column
            for (int i = 1; i <= columnCount; i++) {
                // Get column name
                String columnName = metaData.getColumnName(i);

                // Get column type
                String columnType = metaData.getColumnTypeName(i);

                // Get column size
                int columnSize = metaData.getColumnDisplaySize(i);

                // Get whether the column can contain NULL values
                boolean nullable = metaData.isNullable(i) == ResultSetMetaData.columnNullable;

                // Print column information
                System.out.println("Column Name: " + columnName);
                System.out.println("Column Type: " + columnType);
                System.out.println("Column Size: " + columnSize);
                System.out.println("Nullable: " + (nullable ? "Yes" : "No"));
                System.out.println();
            }

            // Close all resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
