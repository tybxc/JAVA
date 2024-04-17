<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting Page</title>
</head>
<body>
    <h2>Greeting Page</h2>
    <form action="" method="post">
        Enter your name: <input type="text" name="username">
        <input type="submit" value="Submit">
    </form>
    
    <%-- Retrieving the username from the form --%>
    <% String username = request.getParameter("username");
       if (username != null && !username.isEmpty()) { %>
        <%-- Getting the current hour on the server --%>
        <% java.util.Date currentDate = new java.util.Date();
           java.util.Calendar calendar = java.util.Calendar.getInstance();
           calendar.setTime(currentDate);
           int hourOfDay = calendar.get(java.util.Calendar.HOUR_OF_DAY); %>
        
        <%-- Greeting the user based on the time of day --%>
        <% String greeting;
           if (hourOfDay >= 0 && hourOfDay < 12) {
               greeting = "Good morning";
           } else if (hourOfDay >= 12 && hourOfDay < 18) {
               greeting = "Good afternoon";
           } else {
               greeting = "Good evening";
           } %>
        
        <h3><%= greeting %>, <%= username %>!</h3>
    <% } %>
</body>
</html>
