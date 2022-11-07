/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpsession;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 *
 * @author mountant
 */
public class VendingMachineHTTPsession extends HttpServlet {

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
    
     String[] snacks = {"Chips", "Popcorn", "Peanuts", "KitKat"};

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
        
        HttpSession session = request.getSession(true);
        HashMap<String,Integer> selections=(HashMap<String,Integer>) session.getAttribute("selections");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
          String lastSelection = request.getParameter("selection");
        if (selections==null) { // First invocation in this session
            selections = new HashMap<String, Integer>();
            selections.put(lastSelection, 1);
            session.setAttribute("selections", selections);
        } else { // Subsequent invocation
            if (selections.containsKey(lastSelection)) {
                selections.put(lastSelection, selections.get(lastSelection) + 1);
            } else {
                selections.put(lastSelection, 1);
            }
        }
        out.println("<html><head></head><body>");
        out.println("<h1>HTTP session API</h1>");
        for (int i = 0; i < snacks.length; i++) {
            out.println("<form action=VendingMachineHTTPsession>");
            out.println("<input type=submit name=selection "
                    + "value=\"" + snacks[i] + "\">");
            out.println("</form>");
        }
        out.println("<form action=ViewSelectionsHTTPsession>");
        out.println("<input type=submit name='show'"
                + "value=\"Show Selections\">");
        out.println("</form>");
        
         out.println("Last Selection: "+lastSelection);
        out.println("</body></html>");

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
