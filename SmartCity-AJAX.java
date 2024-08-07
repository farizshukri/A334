import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getHotels")
public class GetHotelsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            // Fetch hotels from the database and write them to the response
            // Example output:
            out.println("<ul>");
            out.println("<li>Hotel ABC - Address, Rating</li>");
            out.println("<li>Hotel XYZ - Address, Rating</li>");
            out.println("</ul>");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
