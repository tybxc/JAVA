// Write a java program to accept ‘N’ Integers from a user store them into LinkedList Collection and display only negative integers.


import java.util.*;

public class Q18NegativeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept 'N' integers from the user
        System.out.print("Enter the number of integers (N): ");
        int N = scanner.nextInt();

        // Create a LinkedList to store integers
        LinkedList<Integer> integerList = new LinkedList<>();

        System.out.println("Enter " + N + " integers:");
        for (int i = 0; i < N; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            int num = scanner.nextInt();
            integerList.add(num);
        }

        // Display only negative integers
        System.out.println("\nNegative integers:");
        for (int num : integerList) {
            if (num < 0) {
                System.out.println(num);
            }
        }

        scanner.close();
    }
}


// Enter the number of integers (N): 5
// Enter 5 integers:
// Enter integer 1: 5
// Enter integer 2: -2
// Enter integer 3: 8
// Enter integer 4: -7
// Enter integer 5: 0

// Negative integers:
// -2
// -7
