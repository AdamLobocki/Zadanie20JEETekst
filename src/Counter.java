import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

@WebServlet("/counter")
public class Counter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String tekst = request.getParameter("tekst");
        int character = 0;

        for (int i = 0; i < tekst.length(); i++) {
            character++;
        }
        String[] words = tekst.split(" ");

        byte[] byteText = tekst.getBytes();
        byte[] rewerstext = new byte[byteText.length];
        for (int i = 0; i < byteText.length; i++) {
            rewerstext[i] = byteText[byteText.length - i - 1];
        }
        boolean palindrom = Arrays.equals(byteText, rewerstext);



        writer.println("Ilość słów: " + words.length);
        writer.println("Ilość znaków: " + character);
        writer.println("Ilość znaków bez spacji: " + (character - (words.length - 1)));
        writer.println("Palindrom: " + palindrom);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
