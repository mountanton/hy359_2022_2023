package coreservlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;


/**
 * Servlet that reads a code snippet from the request and displays it inside a
 * PRE tag. Filters the special HTML characters.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and
 * Java</a>.
 */
@WebServlet("/GoodCodeServlet")
public class GoodCodeServlet extends BadCodeServlet {

    protected String getCode(HttpServletRequest request) {
        return (ServletUtilities.filter(super.getCode(request)));
    }
}
