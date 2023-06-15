package com.example.javaeehelloworld;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "New Relic Java agent instrumentation";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>I am just a demo app in order to get a few attributes running in the Java agent.</p>");
        out.println("<p>What's your name?</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}