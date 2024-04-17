<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Reverse String</title>
</head>
<body>
    <h2>Reverse String</h2>
    <form action="" method="post">
        Enter a string: <input type="text" name="inputString">
        <input type="submit" value="Submit">
    </form>
    
    <%-- Retrieving the input string from the request --%>
    <% String inputString = request.getParameter("inputString"); %>
    
    <%-- Checking if the input string is not null --%>
    <% if (inputString != null && !inputString.isEmpty()) { %>
        <%-- Reversing the input string --%>
        <% String reversedString = new StringBuilder(inputString).reverse().toString(); %>
        
        <h3>Input String: <%= inputString %></h3>
        <h3>Reversed String: <%= reversedString %></h3>
    <% } %>
</body>
</html>
