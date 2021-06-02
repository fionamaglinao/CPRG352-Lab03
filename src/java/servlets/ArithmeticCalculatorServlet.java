package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // set the default result when no calculation is performed
        request.setAttribute("output", "---");
        // this will display the requested JSP as a view
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // capture the parameters from the POST request (the form)
        String option = request.getParameter("operation");
        String firstValue = request.getParameter("first_value");
        String secondValue = request.getParameter("second_value");
        
        int output = 0;

        // set the attributes for the JSP
        request.setAttribute("firstValue", firstValue);
        request.setAttribute("secondValue", secondValue);

        if (firstValue == null || firstValue.equals("") || secondValue == null || secondValue.equals("")) {
                // result when the input box is empty
                request.setAttribute("output", "invalid");
                // forward the req and response objects to the JSP
                // display the form again
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
                return; // very important! stop the code call
            }
        try {
            int first = Integer.parseInt(firstValue);
            int second = Integer.parseInt(secondValue);
            switch (option) {
                case "+":
                    output = first + second;
                    request.setAttribute("output", output);
                    break;
                case "-":
                    output = first - second;
                    request.setAttribute("output", output);
                    break;
                case "*":
                    output = first * second;
                    request.setAttribute("output", output);
                    break;
                case "%":
                    output = first % second;
                    request.setAttribute("output", output);
                    break;
            }
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        } catch (NumberFormatException n) {
            // result when an input is invalid
            request.setAttribute("output", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        }
    }
}