package com.example.javaeehelloworld;

import java.io.IOException;

import com.newrelic.api.agent.NewRelic;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loopServlet", value = "/loop-servlet")
public class LoopServlet extends HttpServlet {
    private static final int LOOP_COUNT = 10; // Number of loop iterations

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("userId", "sample user ID to be changed later");
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("productID", "sample product ID to be changed later");

        // Check if the button was clicked
        String buttonClicked = request.getParameter("buttonClicked");

        if (buttonClicked != null && buttonClicked.equals("true")) {
            // Run the loop if the button was clicked
            for (int i = 0; i < LOOP_COUNT; i++) {
                // Perform loop operations here

                // Add a delay to simulate processing time
                try {
                    Thread.sleep(1000); // 1 second delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Set the response content type
        response.setContentType("text/html");

        // Write the HTML form with the button to trigger the loop
        response.getWriter().println("<head>\n" +
                        "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n" +
                        "              rel=\"stylesheet\"\n" +
                        "              integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n" +
                        "              crossorigin=\"anonymous\">\n" +
                        "        <title>JSP - Demo app for New Relic</title>\n" +
                        "    </head>" +
                        "<div class='text-center py-5 my-5 mx-4'>");

        response.getWriter().println("<form action=\"loop-servlet\" method=\"GET\">");
        response.getWriter().println("<input type=\"hidden\" name=\"buttonClicked\" value=\"true\">");
        response.getWriter().println("<button type=\"submit\">Run Loop</button>");
        response.getWriter().println("</form>");

        response.getWriter().println("<br/>" +
                "<a class='btn btn-primary my-4' href=\"index.jsp\">Stop</a>" +
                "</div>");
    }
}

