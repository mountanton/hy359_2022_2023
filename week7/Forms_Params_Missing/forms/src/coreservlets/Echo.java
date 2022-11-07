/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

/**
 *
 * @author Panagiotis Papadakos <papadako at ics.forth.gr>
 */
@WebServlet(name = "Echo", urlPatterns = {"/Echo"})
public class Echo extends HttpServlet {

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
            printHeaderAndParameters(request, response);

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

    public void printHeaderAndParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        String headers = null;
        String htmlHeader = "<HTML><HEAD><TITLE> Request Headers</TITLE></HEAD><BODY>";
        String htmlFooter = "</BODY></HTML>";

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        Enumeration e = request.getHeaderNames();

        out.println(htmlHeader);
        Date date = new Date();
        out.println(date.toGMTString());
        out.println("<TABLE ALIGN=CENTER BORDER=1>");
        out.println("<tr><th> Header </th><th> Value </th>");

        while (e.hasMoreElements()) {
            headers = (String) e.nextElement();
            if (headers != null) {
                out.println("<tr><td align=center><b>" + headers + "</td>");
                out.println("<td align=center>" + request.getHeader(headers)
                        + "</td></tr>");
            }
        }
        out.println("</TABLE><BR>");

        out.println("<TABLE ALIGN=CENTER BORDER=1>");
        out.println("<tr><th> Parameter </th><th> Value </th>");
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            out.print("<TR><TD>" + paramName + "\n<TD>");
            String[] paramValues
                    = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) {
                    out.println("<I>No Value</I>");
                } else {
                    out.println(paramValue);
                }
            } else {
                out.println("<UL>");
                for (String paramValue : paramValues) {
                    out.println("<LI>" + paramValue);
                }
                out.println("</UL>");
            }
        }
        out.println(htmlFooter);
        out.println("</TABLE><BR>");

    }
}
