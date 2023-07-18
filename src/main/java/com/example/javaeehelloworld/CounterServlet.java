package com.example.javaeehelloworld;

import java.io.*;

import com.newrelic.api.agent.NewRelic;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "countServlet", value = "/count-servlet")
public class CounterServlet extends HttpServlet {
    private int counter = 0; // Counter variable

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("userId", "sample user ID to be changed later");
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("productID", "sample product ID to be changed later");

        // Increment the counter
        counter++;

        // If counter reaches 101, start over from 0
        if (counter > 100) {
            counter = 0;
        }

        // Set the response content type
        response.setContentType("text/html");

        // Write the counter value to the response
        response.getWriter().println("<head>\n" +
                "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n" +
                "              rel=\"stylesheet\"\n" +
                "              integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n" +
                "              crossorigin=\"anonymous\">\n" +
                "        <title>JSP - Demo app for New Relic</title>\n" +
                "    </head>" +
                "<div class='text-center py-5 my-5 mx-4'>" +
                "<h1>Counter: " + counter + "</h1>" +
                "<br/>" +
                "<a class='btn btn-primary my-4' href=\"index.jsp\">Stop</a>" +
                "</div>" +
                "<script>" +
                "setTimeout(function() { location.reload(); }, 1000);" +
                "var counter = 0;" +
                "function updateCounter() {" +
                "    document.getElementById('counter').textContent = counter;" +
                "    counter = (counter + 1) % 101;" +
                "}" +
                "updateCounter();" +
                "</script>");
    }
}
