import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangeInactiveIntervalServlet")
public class ChangeInactiveIntervalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Getting the session object
        HttpSession session = request.getSession();
        
        // Setting the inactive time interval to 300 seconds (5 minutes)
        session.setMaxInactiveInterval(300);
        
        response.getWriter().println("Inactive time interval changed to 5 minutes.");
    }
}


