package br.gov.pi.detran.ouvidoria.servlet;

/**
 *
 * @author jonny
 */
import com.xpert.utils.Encryption;
import java.awt.image.BufferedImage;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Captcha", loadOnStartup = 1,
        initParams = {
    @WebInitParam(name = "height", value = "65"),
    @WebInitParam(name = "width", value = "140")},
        urlPatterns = {"/Captcha.jpg"})
public class CaptchaServlet extends HttpServlet {

    private int height = 0;
    private int width = 0;
    public static final String CAPTCHA_KEY = "6LdQoPMSAAAAAGv0wsfERV84_KatnPPrhQNJVYPC";
    private static final java.util.List<String> letrasDoBem = Arrays.asList("a", "b", "c", "d", "e", "f",
            "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z",
            "2", "3", "4", "5", "6", "7", "8", "9");

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        height = Integer.parseInt(getServletConfig().getInitParameter("height"));
        width = Integer.parseInt(getServletConfig().getInitParameter("width"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        //Expire response
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Max-Age", 0);
        ServletContext sc = getServletContext();
        Image img = ImageIO.read(new File(sc.getRealPath("/images/bg4.jpg")));
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        Random r = new Random();
        String token = Long.toString(Math.abs(r.nextLong()), 36);
        String ch = getCaptchaWithGoodLetter(token.substring(0, 5));
        GradientPaint gp = new GradientPaint(30, 30, Color.black, 15, 25, Color.GRAY, true);
        graphics2D.setPaint(gp);
        Font font = new Font("Verdana", Font.CENTER_BASELINE, 30);
        graphics2D.setFont(font);
        graphics2D.drawImage(img.getScaledInstance(width, height, 0), 0, 0, null);
        graphics2D.drawString(ch, 10, 48);
        graphics2D.dispose();

        HttpSession session = req.getSession(true);
        try {
            session.setAttribute(CAPTCHA_KEY, Encryption.getSHA256(ch));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CaptchaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        outputStream.close();
    }

    public String getCaptchaWithGoodLetter(String ch) {
        Random random = new Random();
        String aux = ch.replace("i", letrasDoBem.get(random.nextInt(letrasDoBem.size())))
                .replace("I", letrasDoBem.get(random.nextInt(letrasDoBem.size())))
                .replace("l", letrasDoBem.get(random.nextInt(letrasDoBem.size())))
                .replace("L", letrasDoBem.get(random.nextInt(letrasDoBem.size())))
                .replace("o", letrasDoBem.get(random.nextInt(letrasDoBem.size())))
                .replace("O", letrasDoBem.get(random.nextInt(letrasDoBem.size())))
                .replace("0", letrasDoBem.get(random.nextInt(letrasDoBem.size())))
                .replace("1", letrasDoBem.get(random.nextInt(letrasDoBem.size())));
        return aux;
    }
}
