//Write a java program to accept ‘N’ integers from a user. Store and display integers in sorted order having proper collection class. The collection should not accept duplicate elements.

import java.util.*;

public class Q17SortedIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept 'N' integers from the user
        System.out.print("Enter the number of integers (N): ");
        int N = scanner.nextInt();

        // Create a TreeSet to store integers (automatically sorted and removes duplicates)
        TreeSet<Integer> integerSet = new TreeSet<>();

        System.out.println("Enter " + N + " integers:");
        for (int i = 0; i < N; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            int num = scanner.nextInt();
            integerSet.add(num);
        }

        // Display integers in sorted order
        System.out.println("\nIntegers in sorted order:");
        for (int num : integerSet) {
            System.out.println(num);
        }

        scanner.close();
    }
}

// Enter the number of integers (N): 5
// Enter 5 integers:
// Enter integer 1: 5
// Enter integer 2: 2
// Enter integer 3: 8
// Enter integer 4: 2
// Enter integer 5: 9

// Integers in sorted order:
// 2
// 5
// 8
// 9
