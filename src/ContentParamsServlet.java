import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xl on 15/4/22.
 */
@WebServlet(name = "ContentParamsServlet")
public class ContentParamsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("utf-8");
        PrintWriter printWriter = response.getWriter();

        printWriter.println(this.getServletConfig().getServletContext().getInitParameter("FileType"));
    }
}
