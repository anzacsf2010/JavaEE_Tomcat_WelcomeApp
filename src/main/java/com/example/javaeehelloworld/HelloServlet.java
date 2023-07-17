package com.example.javaeehelloworld;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.newrelic.api.agent.NewRelic;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "New Relic Java agent instrumentation";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NewRelic.addCustomParameter("cust_att", "sample text");
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();

        out.println("<head>\n" +
                "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n" +
                "              rel=\"stylesheet\"\n" +
                "              integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n" +
                "              crossorigin=\"anonymous\">\n" +
                "        <title>JSP - Demo app for New Relic</title>\n" +
                "    </head>");

        out.println("<body>");

        out.println("<div class='text-center py-5 my-5 mx-4'>");

        out.println("<h1 class='my-4'>" + message + "</h1>");
        out.println("<p class='my-4'>I am just a demo app in order to get a few attributes running in the Java agent.</p>");

        String WelcomeMessage = "Welcome!";

        out.println("<p class='my-4'>" + WelcomeMessage + "</p>");

        out.println("<br/><a class='btn btn-primary my-4' href='index.jsp'>Back</a>");

        out.println("<br/></div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}