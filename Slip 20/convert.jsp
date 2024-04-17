<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Number to Words Converter</title>
    <style>
        .red {
            color: red;
        }
    </style>
</head>
<body>
    <h2>Number to Words Converter</h2>
    <%-- Retrieving the number from the form --%>
    <% String numberStr = request.getParameter("number");
       int number = Integer.parseInt(numberStr); %>

    <%-- Converting the number to words --%>
    <% String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"}; %>
    <% String numberInWords = ""; %>
    <% String numberStrWithoutLeadingZeros = numberStr.replaceFirst("^0+(?!$)", ""); %>
    <% for (int i = 0; i < numberStrWithoutLeadingZeros.length(); i++) { %>
        <% char digit = numberStrWithoutLeadingZeros.charAt(i);
           int digitValue = Character.getNumericValue(digit);
           numberInWords += words[digitValue] + " "; %>
    <% } %>

    <%-- Displaying the number in words in red color --%>
    <h3>Your number in words: <span class="red"><%= numberInWords.trim() %></span></h3>
</body>
</html>
