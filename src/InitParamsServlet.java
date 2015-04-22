import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by xl on 15/4/22.
 */
@WebServlet(name = "InitParamsServlet")
public class InitParamsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Enumeration params = this.getInitParameterNames();

        while (params.hasMoreElements()){
            String user = (String)params.nextElement();
            String pwd = this.getInitParameter(user);

            if (user.equalsIgnoreCase(username) && pwd.equals(password)){
                request.getRequestDispatcher("/WEB-INF/notice.html").forward(request, response);
                return;
            }
        }
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("/login.html").forward(request ,response);
    }
}
