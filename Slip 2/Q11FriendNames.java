// Write a java program to read ‘N’ names of your friends, store it into HashSet and display them in ascending order

import java.util.*;

public class Q11FriendNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of friends (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Set<String> friendSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter friend name " + (i + 1) + ": ");
            String name = scanner.nextLine();
            friendSet.add(name);
        }

        // Convert HashSet to TreeSet for sorting
        Set<String> sortedNames = new TreeSet<>(friendSet);

        System.out.println("\nList of friends in ascending order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}


// Enter the number of friends (N): 5
// Enter friend name 1: Alice
// Enter friend name 2: Bob
// Enter friend name 3: Charlie
// Enter friend name 4: David
// Enter friend name 5: Alice

// List of friends in ascending order:
// Alice
// Bob
// Charlie
// David
