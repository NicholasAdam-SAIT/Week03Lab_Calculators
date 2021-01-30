/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicholas Adam    SID#:000840018
 * January 29, 2021
 */
public class ArithmeticCalculatorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Assign a default value to the "result" attribute
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
            .forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get parameters for both of the text boxes
        String first = request.getParameter("firstnum");
        String second = request.getParameter("secondnum");
        
        //set parameters as attributes so they can be manipulated
        request.setAttribute("firstNum", first);
        request.setAttribute("secondNum", second);
        
        //Check to see if either text box is empty, inform the user of invalid input if so
        if (first.isEmpty() || second.isEmpty())
        {
           request.setAttribute("result", "invalid");
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                        .forward(request, response); 
        }
        else
        {
            try {
                //convert the number string so arithmetic can be performed
                int firstNumber = Integer.parseInt(first);
                int secondNumber = Integer.parseInt(second);
                
                //get the value of the submit button used
                String opUsed = request.getParameter("operation");
                
                //branch based on the value of the submit button
                
                switch(opUsed)
                {
                    //If "+" is entered, add the two numbers together
                    case "+":
                        request.setAttribute("result", firstNumber + secondNumber);
                        break;
                        
                    //If "-" is entered, subtract the two numbers
                    case "-":
                        request.setAttribute("result", firstNumber - secondNumber);
                        break;
                        
                    //If "*" is entered, multiply the two numbers together
                    case "*":
                        request.setAttribute("result", firstNumber * secondNumber);
                        break;
                        
                    //If "%" is entered, perform modulus arithmetic on the two numbers.
                    case "%":
                        request.setAttribute("result", firstNumber % secondNumber);
                        break;
                }
                //Return the result to the webpage so it can be displayed
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                        .forward(request, response);
                
            }
            
            //Inform the user of invalid input if they enter non-number values
            catch (NumberFormatException nfe)
            {
                request.setAttribute("result", "invalid");
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                        .forward(request, response);
                
            }
        }
        
        
    }

    

}
