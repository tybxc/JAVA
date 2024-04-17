<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Voter Eligibility Checker</title>
</head>
<body>
    <h2>Voter Eligibility Checker</h2>
    <form action="" method="post">
        Enter your name: <input type="text" name="name"><br>
        Enter your age: <input type="number" name="age"><br>
        <input type="submit" value="Check Eligibility">
    </form>
    
    <%-- Retrieving the name and age from the form --%>
    <% String name = request.getParameter("name");
       int age = Integer.parseInt(request.getParameter("age"));
       
       // Checking eligibility based on age
       String message;
       if (age >= 18) {
           message = "Congratulations, you are eligible to vote!";
       } else {
           message = "Sorry, you are not eligible to vote. You must be at least 18 years old.";
       }
    %>
    
    <%-- Displaying the eligibility message --%>
    <h3><%= message %></h3>
</body>
</html>
