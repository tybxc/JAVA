// Write a java program to create a TreeSet, add some colors (String) and print out the content of TreeSet in ascending order.

import java.util.*;

public class Q16ColorTreeSet {
    public static void main(String[] args) {
        // Create a TreeSet to store colors
        TreeSet<String> colorSet = new TreeSet<>();

        // Add some colors to the TreeSet
        colorSet.add("Red");
        colorSet.add("Green");
        colorSet.add("Blue");
        colorSet.add("Yellow");
        colorSet.add("Orange");

        // Print out the content of TreeSet in ascending order
        System.out.println("Colors in ascending order:");
        for (String color : colorSet) {
            System.out.println(color);
        }
    }
}

// Colors in ascending order:
// Blue
// Green
// Orange
// Red
// Yellow
