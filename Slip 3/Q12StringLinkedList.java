// Write a Java program to create LinkedList of String objects and perform the following: i. Add element at the end of the list ii. Delete first element of the list iii. Display the contents of list in reverse order


import java.util.LinkedList;

public class Q12StringLinkedList {
    public static void main(String[] args) {
        // Create a LinkedList of String objects
        LinkedList<String> stringList = new LinkedList<>();

        // Add elements at the end of the list
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");
        stringList.add("Mango");

        // Display the original contents of the list
        System.out.println("Original List:");
        displayList(stringList);

        // Delete the first element of the list
        if (!stringList.isEmpty()) {
            stringList.removeFirst();
            System.out.println("\nAfter deleting the first element:");
            displayList(stringList);
        } else {
            System.out.println("\nThe list is empty. Cannot delete the first element.");
        }

        // Display the contents of the list in reverse order
        System.out.println("\nList in reverse order:");
        displayListInReverse(stringList);
    }

    // Method to display the contents of the list
    public static void displayList(LinkedList<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }

    // Method to display the contents of the list in reverse order
    public static void displayListInReverse(LinkedList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}

// Original List:
// Apple
// Banana
// Orange
// Mango

// After deleting the first element:
// Banana
// Orange
// Mango

// List in reverse order:
// Mango
// Orange
// Banana
