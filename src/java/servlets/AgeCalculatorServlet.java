package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // this will display the requested JSP as a view
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // capture the parameters from the POST request (the form)
        String currentAge = request.getParameter("current_age");

        // set the attributes for the JSP
        request.setAttribute("currentAge", currentAge);
        
        // validate if variable doesn't exist or empty, show the form again
        if (currentAge == null || currentAge.equals("")) {
            // create a helpful message to send to the user
            request.setAttribute("message", "You must give your current age.");
            // forward the req and response objects to the JSP
            // display the form again
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return; // very important! stop the code call
        }

        // display the helloWorld.JSP
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

}
