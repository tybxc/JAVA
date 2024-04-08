import java.sql.*;

public class Slip16B 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Establishing connection
			Connection conn=DriverManager.getConnection("jdbc:postgresql://192.168.100.10:5432/tybcs5","tybcs5","");

            // Inserting records into 
            String insertQuery = "INSERT INTO Teacher VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setInt(1, 101);
            insertStatement.setString(2, "Alisha");
            insertStatement.setString(3, "JAVA");
            insertStatement.executeUpdate();

            insertStatement.setInt(1, 102);
            insertStatement.setString(2, "Chandan");
            insertStatement.setString(3, "PYTHON");
            insertStatement.executeUpdate();

            insertStatement.setInt(1, 103);
            insertStatement.setString(2, "Dilip");
            insertStatement.setString(3, "JAVA");
            insertStatement.executeUpdate();

            insertStatement.setInt(1, 104);
            insertStatement.setString(2, "Ishika");
            insertStatement.setString(3, "C++");
            insertStatement.executeUpdate();

            insertStatement.setInt(1, 105);
            insertStatement.setString(2, "Manali");
            insertStatement.setString(3, "JAVA");
            insertStatement.executeUpdate();
            insertStatement.close();

            // Displaying details of teachers teaching "JAVA" subject
            String selectQuery = "SELECT * FROM Teacher WHERE Subject = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setString(1, "JAVA");
            ResultSet resultSet = selectStatement.executeQuery();

            System.out.println("Details of teachers teaching JAVA:");
            while (resultSet.next()) 
            {
                int tno = resultSet.getInt("TNo");
                String tname = resultSet.getString("TName");
                String subject = resultSet.getString("Subject");
                System.out.println("TNo: " + tno + ", TName: " + tname + ", Subject: " + subject);
            }

            // Closing the resources
            resultSet.close();
            selectStatement.close();
            conn.close();
        } 
        catch (SQLException ex) {}
    }
}
