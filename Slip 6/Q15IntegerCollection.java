import java.util.*;

public class Q15IntegerCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept 'n' integers from the user
        System.out.print("Enter the number of integers (n): ");
        int n = scanner.nextInt();
        Set<Integer> integerSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            int num = scanner.nextInt();
            integerSet.add(num);
        }

        // Display integers in sorted order
        List<Integer> sortedList = new ArrayList<>(integerSet);
        Collections.sort(sortedList);
        System.out.println("\nIntegers in sorted order:");
        for (int num : sortedList) {
            System.out.println(num);
        }

        // Search for a particular element
        System.out.print("\nEnter an integer to search: ");
        int searchNum = scanner.nextInt();
        if (integerSet.contains(searchNum)) {
            System.out.println("Element " + searchNum + " found in the collection.");
        } else {
            System.out.println("Element " + searchNum + " not found in the collection.");
        }

        scanner.close();
    }
}


/*
 Enter the number of integers (n): 6
Enter integer 1: 5
Enter integer 2: 8
Enter integer 3: 3
Enter integer 4: 8
Enter integer 5: 2
Enter integer 6: 5

Integers in sorted order:
2
3
5
8

Enter an integer to search: 8
Element 8 found in the collection.

*/