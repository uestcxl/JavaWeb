import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by xl on 15/4/22.
 */
@WebServlet(name = "IdentifyServlet")
public class IdentifyServlet extends HttpServlet {

    public static final char[] CHARS = {'2','3','4','5','6','7','8','9','a','s','d','f','g','h','j','k','l','z','x','c',
                                        'v','b','n','m','q','w','e','r','t','y','u','i','p'
                                        };

    public static Random random = new Random();     //随机数生成器


    //从CHAR中生成随机字符串
    public static String getRandomString(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6 ; i++){
            stringBuffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return stringBuffer.toString();
    }

    //生成随机的颜色
    public static Color getRandomColor(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    //获取某种颜色的反色
    public static Color getReverseColor(Color color){
        return new Color((255-color.getRed()), (255-color.getGreen()), (255-color.getBlue()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置响应类型
        response.setContentType("images/jpeg");
        String randomString = getRandomString();

//        将随机字符串保存在session中
        request.getSession(true).setAttribute("randomString", randomString);

//        设置验证码图片的一些信息
        int width = 100;
        int height = 30;
        Color color = getRandomColor();
        Color reverseColor = getReverseColor(color);

//        创建彩色图片
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        创建绘图对象
        Graphics2D graphics2D = bufferedImage.createGraphics();
//        设置图片字体
        graphics2D.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
//        设置图片颜色
        graphics2D.setColor(color);
//        绘制背景
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setColor(reverseColor);
//        把随机字符串画上
        graphics2D.drawString(randomString, 18, 20);
//        画噪音点
        for (int i = 0, n = random.nextInt(100); i < n; i++) {
            graphics2D.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }

        ServletOutputStream output = response.getOutputStream();
//        创建jpeg编码器
        JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(output);
        jpegEncoder.encode(bufferedImage);

        output.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
