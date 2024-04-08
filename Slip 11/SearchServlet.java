import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the customer number from the request
        String customerNumber = request.getParameter("customerNumber");

        // Perform database query to search for customer details

        // For this example, let's assume we have a method
        // getCustomerDetailsFromDatabase()
        // that takes the customer number and returns customer details if found,
        // otherwise null
        String customerDetails = getCustomerDetailsFromDatabase(customerNumber);

        // Prepare response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        if (customerDetails != null) {
            out.println("<h2>Customer Details:</h2>");
            out.println("<p>" + customerDetails + "</p>");
        } else {
            out.println("<h2>Error:</h2>");
            out.println("<p>Customer not found</p>");
        }

        out.println("</body></html>");
    }

    // Method to simulate database query
    private String getCustomerDetailsFromDatabase(String customerNumber) {
        // Here you would implement actual database query to fetch customer details
        // For this example, we're just returning a hardcoded string
        if ("123456".equals(customerNumber)) {
            return "Customer Name: John Doe<br>Customer Email: john@example.com<br>Customer Phone: 123-456-7890";
        } else {
            return null; // Customer not found
        }
    }
}
