<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <title>JSP - Demo app for New Relic</title>
    </head>
    <body>
        <div class="text-center py-5 my-5 mx-4">
            <h1 class="text-uppercase text-muted text-bold"><%= "New Relic Java agent instrumentation" %></h1>
            <br/>
            <a href="hello-servlet" type="button" class="btn btn-primary my-4">Welcome message</a>
            <br/>
            <a href="link-servlet?link=www.newrelic.com" type="button" class="btn btn-primary my-4">Click me!</a>
            <br/>
            <a href="count-servlet" type="button" class="btn btn-primary my-4">Let's count!</a>
        </div>
    </body>
</html>