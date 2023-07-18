package com.example.javaeehelloworld;

import java.io.*;

import com.newrelic.api.agent.NewRelic;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "linkServlet", value = "/link-servlet")
public class LinkServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("userId", "sample user ID to be changed later");
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("productID", "sample product ID to be changed later");

        // Get the link parameter from the request
        String link = request.getParameter("link");

        // Create the message to display
        String message = "You clicked on: " + link;

        // Set the response content type
        response.setContentType("text/html");

        // Write the message to the response
        response.getWriter().println("<head>\n" +
                "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n" +
                "              rel=\"stylesheet\"\n" +
                "              integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n" +
                "              crossorigin=\"anonymous\">\n" +
                "        <title>JSP - Demo app for New Relic</title>\n" +
                "    </head>" +
                "<div class='text-center py-5 my-5 mx-4'>" +
                "<h1>" + message + "</h1>" +
                "<br/>" +
                "<a class='btn btn-primary my-4' href=\"index.jsp\">Back</a>" +
                "</div>");
    }
}

