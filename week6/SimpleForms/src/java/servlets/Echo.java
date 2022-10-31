/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


/**
 *
 * @author mountant
 */
@WebServlet(name = "Echo", urlPatterns = {"/Echo"})
public class Echo extends HttpServlet {
    int cnt=0;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String firstName=req.getParameter("firstName");
        System.out.println(firstName);
        String htmlHeader = "<html><head><title>Echo Request</title > </head> <body>";
        String htmlFooter = "</body></html>";
        res.setContentType("text/html");
        PrintWriter o = res.getWriter();
        if(req.getParameter("firstName").equals("Stefanos")){
               o.println("<p style=\"color:red\"> To username uparxei</p>");
               return;
        }
            o.println(htmlHeader);
            o.println("HTTP Method:" + req.getMethod());
            o.println("<br>URL:" + req.getRequestURL().toString());
            o.println("<br>Query Part:" + req.getQueryString());
            o.println("<table border=1><tr><th> Header </th><th> Value </th>");
            Enumeration e = req.getHeaderNames();
            while (e.hasMoreElements()) {
                String headers = (String) e.nextElement();
                if (headers != null) {
                    o.println("<tr><td align=center><b>"
                            + headers + "</td>");
                    o.println("<td align=center>"
                            + req.getHeader(headers) + "</td></tr>");
                }
            }
            o.println("<tr><td>counter</td><td>"+(cnt++)+"</td></tr>");
            o.println("</table><br>");
            o.println(req.getReader().lines()
                    .reduce("", (accumulator, actual)
                            -> accumulator + actual));
           
            o.println(htmlFooter);
        
        

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
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String htmlHeader = "<html><head><title>Echo Request</title > </head> <body>";
        String htmlFooter = "</body></html>";
        res.setContentType("text/html");
        PrintWriter o = res.getWriter();
            o.println(htmlHeader);
            o.println("HTTP Method:" + req.getMethod());
            o.println("<br>URL:" + req.getRequestURL().toString());
            o.println("<br>Query Part:" + req.getQueryString());
            o.println("<table border=1><tr><th> Header </th><th> Value </th>");
            Enumeration e = req.getHeaderNames();
            while (e.hasMoreElements()) {
                String headers = (String) e.nextElement();
                if (headers != null) {
                    o.println("<tr><td align=center><b>"
                            + headers + "</td>");
                    o.println("<td align=center>"
                            + req.getHeader(headers) + "</td></tr>");
                }
            }
            o.println("<tr><td>counter</td><td>"+(cnt++)+"</td></tr>");
            o.println("</table><br>");
            o.println(req.getReader().lines()
                    .reduce("", (accumulator, actual)
                            -> accumulator + actual));
            o.println(htmlFooter);
        
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
