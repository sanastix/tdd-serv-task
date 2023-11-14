package com.example.tddservtask;

import java.io.*;

import com.example.tddservtask.beans.Calculator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/hello"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double x = Double.parseDouble(request.getParameter("x"));
        Calculator calculator = new Calculator(x);
        request.setAttribute("calc", calculator);
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    public void destroy() {
    }
}