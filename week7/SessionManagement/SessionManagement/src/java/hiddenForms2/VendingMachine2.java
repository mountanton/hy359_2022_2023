/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiddenForms2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author mountant
 */
public class VendingMachine2 extends HttpServlet {

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

    static HashMap<String, HashMap<String,Integer>> sessionMap = new HashMap();
    Random rand = new Random(); // Seeded by current date/time

    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        // session functionality .
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String sessionID = request.getParameter("sessionID");
           String lastSelection = request.getParameter("selection");
        if (sessionID ==null) { // First invocation in this session
            sessionID = "" + rand.nextInt(); // new Session ID
            HashMap<String,Integer> selections = new HashMap<String,Integer>();
            

            selections.put(lastSelection,1);
            sessionMap.put(sessionID, selections);
           
        } else { // Subsequent invocation
            if(sessionMap.get(sessionID).containsKey(lastSelection)){
                sessionMap.get(sessionID).put(lastSelection,sessionMap.get(sessionID).get(lastSelection)+1);
            }
            else{
                sessionMap.get(sessionID).put(lastSelection,1);
            }
        }
        //print each form and add the single hidden sessionID in all forms
        

        String[] selections = request.getParameterValues("selection");
        out.println("<html><head></head><body>");
        out.println("<h1>Better Hidden Forms</h1>");
        for (int i = 0; i < snacks.length; i++) {
            out.println("<form action=VendingMachine2>");
            out.println("<input type=submit name=selection "
                    + "value=\"" + snacks[i] + "\">");
            out.println("<input type=\"hidden\" name=\"sessionID\""
                + "value=" + sessionID + ">");
            out.println("</form>");
        }
        out.println("<form action=ViewSelections2>");
        out.println("<input type=submit name='show'"
                + "value=\"Show Selections\">");
       out.println("<input type=\"hidden\" name=\"sessionID\""
                + "value=" + sessionID + ">");
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
