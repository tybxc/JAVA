import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentDetailsServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving parameters from the request
        String seatNo = request.getParameter("seatNo");
        String studName = request.getParameter("studName");
        String className = request.getParameter("className");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

        // Calculating percentage
        double percentage = (totalMarks / 500.0) * 100;

        // Determining grade based on percentage
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }

        // Displaying student details and results
        out.println("<html><body>");
        out.println("<h2>Student Details</h2>");
        out.println("<p>Seat Number: " + seatNo + "</p>");
        out.println("<p>Student Name: " + studName + "</p>");
        out.println("<p>Class: " + className + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<h2>Results</h2>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body></html>");

        out.close();
    }
}
