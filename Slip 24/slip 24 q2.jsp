<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>

<%
    // Retrieving username and password from the request
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Check if username and password are the same
    if (username.equals(password)) {
        response.sendRedirect("Login.html"); // Redirect to Login.html if login is successful
    } else {
        response.sendRedirect("Error.html"); // Redirect to Error.html if login fails
    }
%>
