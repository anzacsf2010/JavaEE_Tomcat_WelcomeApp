package com.example.javaeehelloworld;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "countServlet", value = "/count-servlet")
public class CounterServlet extends HttpServlet {
    private int counter = 0; // Counter variable

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Increment the counter
        counter++;

        // If counter reaches 101, start over from 0
        if (counter > 100) {
            counter = 0;
        }

        // Set the response content type
        response.setContentType("text/html");

        // Write the counter value to the response
        response.getWriter().println("<h1>Counter: " + counter + "</h1>");
    }
}