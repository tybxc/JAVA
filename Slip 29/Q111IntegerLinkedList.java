// Write a Java program to create LinkedList of integer objects and perform the following:
// i. Add element at first position
// ii. Delete last element
// iii. Display the size of link list

import java.util.LinkedList;

public class Q111IntegerLinkedList {
    public static void main(String[] args) {
        // Create a LinkedList of Integer objects
        LinkedList<Integer> integerList = new LinkedList<>();

        // Add elements at the first position
        integerList.addFirst(5);
        integerList.addFirst(10);
        integerList.addFirst(15);

        // Delete the last element
        if (!integerList.isEmpty()) {
            integerList.removeLast();
        }

        // Display the size of the linked list
        int size = integerList.size();
        System.out.println("Size of the linked list: " + size);
    }
}


// Size of the linked list: 2