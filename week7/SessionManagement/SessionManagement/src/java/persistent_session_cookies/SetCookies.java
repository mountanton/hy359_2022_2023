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
public class SetCookies extends HttpServlet {

    public void doGet(HttpServletRequest req,
            HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            for (int i = 0; i < 3; i++) {
                Cookie cookie = new Cookie("Session-Cookie-" + i,
                        "Cookie-Value-S" + i);
                // No maxAge (ie maxAge = -1 by default)
                res.addCookie(cookie);
                cookie = new Cookie("Persistent-Cookie-" + i,
                        "Cookie-Value-P" + i);
                cookie.setMaxAge(300); // 5  minutes
                res.addCookie(cookie);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Servlet Cookies</title>");
            out.println("</head><body>");
            out.println("Cookies Created<br>");
            out.println("    <div><a href=\"SetCookies\">Set Cookies</a></div>\n"
                    + "         <div><a href=\"SeeCookies\">See Cookies</a></div>\n"
                    + "         <div><a href=\"RemoveAllCookies\">Remove All Cookies</a></div>");
            out.println("</body></html>");
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
