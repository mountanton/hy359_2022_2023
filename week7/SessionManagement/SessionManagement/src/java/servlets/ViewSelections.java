/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
public class ViewSelections extends HttpServlet {

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

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String[] selections = req.getParameterValues("selection");
        out.println("<html><head></head><body>");
        out.println("<h1>Simple Hidden Forms</h1>");

        for (int i = 0; i < snacks.length; i++) {
            out.println("<form action=VendingMachine1>");
            out.println("<input type=submit name=selection "
                    + "value=\"" + snacks[i] + "\">");
            printHidden(out, selections); // print hidden fields
            out.println("</form>");
        }

        out.println("<form action=ViewSelections>");
        out.println("<input type=submit name="
                + "'show'"
                + "value=\"Show Selections\">");
        printHidden(out, selections); // print hidden fields
        out.println("</form>");

        out.println("Print Selections<br>");
        HashMap<String, Integer> snacksMap = new HashMap<>();
        for (int j = 0; j < selections.length; j++) {
            if (snacksMap.containsKey(selections[j])) {
                snacksMap.put(selections[j], snacksMap.get(selections[j]) + 1);
            } else {
                snacksMap.put(selections[j], 1);
            }
            //out.println(selections[j]+ "<br>");
        }
        for (String key : snacksMap.keySet()) {
            out.println(key + ":" + snacksMap.get(key) + "<br>");
        }
        out.println("</body></html>");
    }

    void printHidden(PrintWriter out, String[] selections) {
        if (selections != null) {
            for (int j = 0; j < selections.length; j++) {
                out.println("<input type=\"hidden\""
                        + "name=\"selection\" "
                        + "value=\"" + selections[j]
                        + "\">");
            }
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
