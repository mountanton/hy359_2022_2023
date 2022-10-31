/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletInformation/*", urlPatterns = {"/ServletInformation/*"})
public class ServletInformation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.print("Url: " + request.getRequestURL().toString() + "<br/>");
        pw.print("Uri: " + request.getRequestURI() + "<br/>");
        pw.print("Scheme: " + request.getScheme() + "<br/>");
        pw.print("Server Name: " + request.getServerName() + "<br/>");
        pw.print("Port: " + request.getServerPort() + "<br/>");
        pw.print("Context Path: " + request.getContextPath() + "<br/>");
        pw.print("Servlet Path: " + request.getServletPath() + "<br/>");
        pw.print("Path Info: " + request.getPathInfo() + "<br/>");
        pw.print("Query: " + request.getQueryString());
    }
}