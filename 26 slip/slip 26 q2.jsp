<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Sum of First and Last Digit</h2>
    <form action="" method="post">
        Enter a number: <input type="number" name="number">
        <input type="submit" value="Calculate">
    </form>
    
    <%-- Retrieving the number from the form --%>
    <% String numberStr = request.getParameter("number");
       if (numberStr != null && !numberStr.isEmpty()) {
           int number = Integer.parseInt(numberStr);
           
           // Calculating the sum of the first and last digits
           int firstDigit = number;
           while (firstDigit >= 10) {
               firstDigit /= 10;
           }
           int lastDigit = number % 10;
           int sum = firstDigit + lastDigit;
    %>
    
    <%-- Displaying the sum in red color with font size 18 --%>
    <h3 style="color: red; font-size: 18px;">Sum of First and Last Digit: <%= sum %></h3>
    
    <% } %>
</body>
</html>
