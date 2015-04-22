import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by xl on 15/4/21.
 */
public class SayHello extends javax.servlet.http.HttpServlet {
    /*
    *   doget
    * */

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        this.log("Get 执行");
        this.execute(request, response);
    }

    /*
    *   dopost
    * */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.log("Post 执行");

        this.execute(req , resp);
    }

    protected void execute(HttpServletRequest request , HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String url = request.getRequestURI();
        String method = request.getMethod();
//        Map<String, String[]> param = request.getParameterMap();
        String param = request.getParameter("params");

        PrintWriter writer = response.getWriter();

        response.setContentType("text/html");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<title>Hello!This is from Servlet!</title>");
        writer.println("<h1>This is from Servlet</h1>");
        writer.println("<h2>The method is "+method+",the req's uri is "+url+", the req's params is "+param);
        writer.println("<p>Now make a form</p>");
        writer.println("<form method='post' action='"+url+"'>" +
                "<input name='params' type='text' value='Post'>" +
                "<input type='submit' value='query by post'>" +
                "</form>");
        writer.println("<form method='get' action='"+url+"'>" +
                "<input name='params' type='text' value='Get'>" +
                "<input type='submit' value='query by get'>" +
                "</form>");
        writer.println("</body>");
        writer.println("</html>");

        writer.flush();
        writer.close();
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        this.log("getLastModified method has been execute!");
        return -1;
    }
}
