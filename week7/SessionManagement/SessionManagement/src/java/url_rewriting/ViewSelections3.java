/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url_rewriting;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
/**
 *
 * @author mountant
 */
public class ViewSelections3 extends HttpServlet {

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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

         String sessionID = request.getRequestURI().replace("/SessionManagement/ViewSelections3;","");
       
             out.println("<html><head></head><body>");
             out.println("<h1>URL Rewriting</h1>");
            for (int i = 0; i < snacks.length; i++) {
                out.println("<form action=VendingMachine3"+";"+ sessionID +" >");
                out.println("<input type=submit name=selection "
                        + "value=\"" + snacks[i] + "\">");
                out.println("</form>");
            }
            out.println("<form action=ViewSelections3"+";"+ sessionID +" >");
            out.println("<input type=submit name='show'"
                    + "value=\"Show Selections\">");
            out.println("</form>");
        

        
        out.println("Print Selections<br>");
        HashMap<String, Integer> snacksMap = VendingMachine3.sessionMap.get(sessionID);
        for (String key : snacksMap.keySet()) {
            out.println(key + ":" + snacksMap.get(key) + "<br>");
        }
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
