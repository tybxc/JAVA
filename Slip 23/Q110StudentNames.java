// Write a java program to accept ‘N’ student names through command line, store them into the appropriate Collection and display them by using Iterator and ListIterator interface.

import java.util.*;

public class Q110StudentNames {
    public static void main(String[] args) {
        // Check if command line arguments are provided
        if (args.length == 0) {
            System.out.println("Please provide at least one student name as command line arguments.");
            return;
        }

        // Create an ArrayList to store student names
        ArrayList<String> studentList = new ArrayList<>();

        // Store command line arguments (student names) into the ArrayList
        for (String name : args) {
            studentList.add(name);
        }

        // Display student names using Iterator interface
        System.out.println("Student Names (using Iterator):");
        displayUsingIterator(studentList);

        // Display student names using ListIterator interface
        System.out.println("\nStudent Names (using ListIterator):");
        displayUsingListIterator(studentList);
    }

    // Method to display student names using Iterator interface
    public static void displayUsingIterator(ArrayList<String> studentList) {
        Iterator<String> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // Method to display student names using ListIterator interface
    public static void displayUsingListIterator(ArrayList<String> studentList) {
        ListIterator<String> listIterator = studentList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}


// Student Names (using Iterator):
// Alice
// Bob
// Charlie

// Student Names (using ListIterator):
// Alice
// Bob
// Charlie
