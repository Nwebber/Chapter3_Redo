package com.webber;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nathaniel Webber
 */

@WebServlet(
            name = "BasicAdditon",
            urlPatterns = "/addition",
            loadOnStartup = 1
    )

public class BasicAddition extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String contextPath = request.getContextPath();
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BasicAddition</title>");
            out.println("<link href=\"" + contextPath + "/styles/main.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Basic Addition Servlet Assignment</h1><br>");
            out.println("<form action=\"addition\" method=\"POST\">");
            out.println("<p>Please enter two numbers and click the submit button</p>");
            out.println("<label for=\"firstNumber\">First Number:</label>");
            out.println("<input type=\"text\" name=\"firstNumber\" id=\"firstNumber\"><br><br>");
            out.println("<label for=\"secondNumber\">Second Number:</label>");
            out.println("<input type=\"text\" name=\"secondNumber\" id=\"secondNumber\"><br><br>");
            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String contextPath = request.getContextPath();
        String fn = request.getParameter("firstNumber");
        BigDecimal firstNumber = new BigDecimal(fn);
        String sn = request.getParameter("secondNumber");
        BigDecimal secondNumber = new BigDecimal(sn);
        BigDecimal answer = firstNumber.add(secondNumber);
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BasicAddition</title>");
            out.println("<link href=\"" + contextPath + "/styles/main.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Basic Addition Servlet Assignment</h1><br>");
            out.println("<form action=\"addition\" method=\"POST\">");
            out.println("<p>Please enter two numbers and click the submit button</p>");
            out.println("<label for=\"firstNumber\">First Number:</label>");
            out.println("<input type=\"text\" name=\"firstNumber\" id=\"firstNumber\"><br><br>");
            out.println("<label for=\"secondNumber\">Second Number:</label>");
            out.println("<input type=\"text\" name=\"secondNumber\" id=\"secondNumber\"><br><br>");
            out.println("<input type=\"submit\" value=\"Submit\"><br><br>");
            if (fn == null || sn == null || fn.equals("") || sn.equals("") || sn.contains("[a-zA-Z]+") || fn.contains("[a-zA-Z]+")) {
                out.println("<label>There is no current sum</label><br>");
                // For whatever reason, I am unable to get this to work. This if
                // statement is checking to see if the first or second field was
                // left blank, or contained a character instead of a number. But
                // when I try to run it, it crashes on me. Otherwise the rest of
                // my code works fine. I'm just not sure how to do the validation
                // properly
            }
            else {
                out.println("<label for=\"answer\">RESULT: " + firstNumber + " + " + secondNumber + " = " + answer + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
