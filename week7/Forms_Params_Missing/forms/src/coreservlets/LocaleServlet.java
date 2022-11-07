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
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

public class LocaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // Locale locale = (Locale) supportedLanguages.get("DEFAULT");
        Enumeration locales = request.getLocales();
        PrintWriter out = response.getWriter();
        while (locales.hasMoreElements()) {
            Locale currentLocale = (Locale) locales.nextElement();
            out.println("<br>Display Language:"+currentLocale.getDisplayLanguage());
            out.println("<br>Display Country:"+currentLocale.getDisplayCountry());
            out.println("<br>Language:"+currentLocale.getLanguage());
            out.println("<br>Country:"+currentLocale.getCountry());
            
        }

        // Update things using the locale, e.g. for language
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        //Locale locale = (Locale) supportedLanguages.get("DEFAULT");
        //  detectLocale(request);
        // Update things using the locale… e.g. for language
    }

}
