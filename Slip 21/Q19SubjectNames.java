// Write a java program to accept ‘N’ Subject Names from a user store them into LinkedList Collection and Display them by using Iterator interface.

import java.util.*;

public class Q19SubjectNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept 'N' subject names from the user
        System.out.print("Enter the number of subjects (N): ");
        int N = scanner.nextInt();

        // Create a LinkedList to store subject names
        LinkedList<String> subjectList = new LinkedList<>();

        System.out.println("Enter " + N + " subject names:");
        for (int i = 0; i < N; i++) {
            System.out.print("Enter subject name " + (i + 1) + ": ");
            String subject = scanner.next();
            subjectList.add(subject);
        }

        // Display subject names using Iterator interface
        System.out.println("\nSubject Names:");
        Iterator<String> iterator = subjectList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        scanner.close();
    }
}


// Enter the number of subjects (N): 4
// Enter 4 subject names:
// Enter subject name 1: Mathematics
// Enter subject name 2: Physics
// Enter subject name 3: Chemistry
// Enter subject name 4: Biology

// Subject Names:
// Mathematics
// Physics
// Chemistry
// Biology
