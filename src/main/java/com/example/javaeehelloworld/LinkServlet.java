package com.example.javaeehelloworld;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "linkServlet", value = "/link-servlet")
public class LinkServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the link parameter from the request
        String link = request.getParameter("link");

        // Create the message to display
        String message = "You clicked on: " + link;

        // Set the response content type
        response.setContentType("text/html");

        // Write the message to the response
        response.getWriter().println("<h1>" + message + "</h1>");
    }
}

