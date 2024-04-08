<!-- Write a JSP program to check whether given number is Perfect or not. (Use Include directive). -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    class PerfectNumberChecker {
        public static boolean isPerfectNumber(int number) {
            if (number <= 0) {
                return false;
            }
            int sum = 0;
            for (int i = 1; i <= number / 2; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }
            return sum == number;
        }
    }
%>
