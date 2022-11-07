/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent_session_cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author mountant
 */
public class RemoveAllCookies extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Servlet Cookies</title>");
            out.println("</head><body>");
            out.println("<table border=\"1\" >");
            Cookie[] cookies = request.getCookies();
            if (cookies == null) {
                out.println("<tr><th colspan=2>No cookies");
            } else {
                for (Cookie cookie : cookies) {
                    cookie.setMaxAge(0);
                   response.addCookie(cookie);
               
                }
                     out.print("Cookies Removed");
            }
            out.println("</table>");
            out.println("    <div><a href=\"SetCookies\">Set Cookies</a></div>\n"
                    + "         <div><a href=\"SeeCookies\">See Cookies</a></div>\n"
                    + "         <div><a href=\"RemoveAllCookies\">Remove All Cookies</a></div>");
            out.println("</body></html>");
                    
    }
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RemoveAllCookies</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveAllCookies at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
