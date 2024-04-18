// Write a Java program to create LinkedList of integer objects and perform the following:
// i. Add element at first position
// ii. Delete last element
// iii. Display the size of link list

import java.util.LinkedList;

public class LinkedListOperations {
    public static void main(String[] args) {
        // Create a LinkedList of integer objects
        LinkedList<Integer> linkedList = new LinkedList<>();

        // i. Add element at first position
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);

        // Display the elements of the linked list
        System.out.println("Linked List after adding elements at first position: " + linkedList);

        // ii. Delete last element
        if (!linkedList.isEmpty()) {
            linkedList.removeLast();
            System.out.println("Linked List after deleting last element: " + linkedList);
        } else {
            System.out.println("Linked List is empty. No element to delete.");
        }

        // iii. Display the size of the linked list
        System.out.println("Size of the Linked List: " + linkedList.size());
    }
}
