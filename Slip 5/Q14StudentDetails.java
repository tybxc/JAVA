//Write a Java Program to create the hash table that will maintain the mobile number and student name. Display the details of student using Enumeration interface.

import java.util.Hashtable;
import java.util.Enumeration;

public class Q14StudentDetails {
    public static void main(String[] args) {
        // Create a hash table to store mobile numbers and student names
        Hashtable<String, String> studentTable = new Hashtable<>();

        // Add student details to the hash table
        studentTable.put("9876543210", "John");
        studentTable.put("1234567890", "Alice");
        studentTable.put("9998887770", "Bob");
        studentTable.put("5554443330", "Emily");

        // Display student details using Enumeration interface
        Enumeration<String> mobileNumbers = studentTable.keys();
        System.out.println("Student Details:");
        while (mobileNumbers.hasMoreElements()) {
            String mobileNumber = mobileNumbers.nextElement();
            String studentName = studentTable.get(mobileNumber);
            System.out.println("Mobile Number: " + mobileNumber + ", Student Name: " + studentName);
        }
    }
}


/*
 * Student Details:
Mobile Number: 9998887770, Student Name: Bob
Mobile Number: 5554443330, Student Name: Emily
Mobile Number: 1234567890, Student Name: Alice
Mobile Number: 9876543210, Student Name: John
*/