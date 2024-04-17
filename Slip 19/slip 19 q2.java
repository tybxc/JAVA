import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String dbUsername = "your_username";
        String dbPassword = "your_password";

        // Database query to check if username and password exist
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish database connection
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Create prepared statement
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Check if username and password match
            if (rs.next()) {
                out.println("<html><body>");
                out.println("<h2>Login Successful</h2>");
                out.println("<p>Welcome, " + username + "!</p>");
                out.println("</body></html>");
            } else {
                out.println("<html><body>");
                out.println("<h2>Login Failed</h2>");
                out.println("<p>Invalid username or password.</p>");
                out.println("</body></html>");
            }

            // Close database resources
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            out.println("Exception: " + e);
        }

        out.close();
    }
}
