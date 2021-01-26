
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 840018
 */
public class AgeCalculatorServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the entered age from the user
        String userAge = request.getParameter("Age");
        //Set that age as an attribute
        request.setAttribute("userage", userAge);
        
        //check for proper input
        if (!(userAge.isEmpty())){
            try {
                int ageAsInt = Integer.parseInt(userAge);
                request.setAttribute("newAge", "Your age next birthday will be " + (ageAsInt + 1));
                getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response); 
            }
            //reference for Integer wrapper class exceptions:https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
            catch(NumberFormatException nfe){
                request.setAttribute("errorMessage1", "You must enter a number.");
                getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
            }
        }
        else{
            request.setAttribute("errorMessage2", "You must give your current age");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
        }
        
        
        
    }

}
