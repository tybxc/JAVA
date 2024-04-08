// Write a Java program to store city names and their STD codes using an appropriate collection and perform following operations: i. Add a new city and its code (No duplicates) ii. Remove a city from the collection iii. Search for a city name and display the code

import java.util.*;

public class Q13CitySTD {
    public static void main(String[] args) {
        // Create a HashMap to store city names and their STD codes
        Map<String, Integer> citySTDMap = new HashMap<>();

        // Add initial city names and codes
        citySTDMap.put("New York", 212);
        citySTDMap.put("London", 20);
        citySTDMap.put("Tokyo", 81);

        Scanner scanner = new Scanner(System.in);

        // Perform operations
        while (true) {
            System.out.println("\nOperations:");
            System.out.println("1. Add a new city and its code");
            System.out.println("2. Remove a city");
            System.out.println("3. Search for a city name and display the code");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCity(citySTDMap, scanner);
                    break;
                case 2:
                    removeCity(citySTDMap, scanner);
                    break;
                case 3:
                    searchCity(citySTDMap, scanner);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    // Method to add a new city and its code
    public static void addCity(Map<String, Integer> citySTDMap, Scanner scanner) {
        System.out.print("Enter the city name: ");
        String city = scanner.nextLine();
        System.out.print("Enter the STD code: ");
        int stdCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (citySTDMap.containsKey(city)) {
            System.out.println("City already exists in the collection. Cannot add duplicates.");
        } else {
            citySTDMap.put(city, stdCode);
            System.out.println("City added successfully.");
        }
    }

    // Method to remove a city from the collection
    public static void removeCity(Map<String, Integer> citySTDMap, Scanner scanner) {
        System.out.print("Enter the city name to remove: ");
        String city = scanner.nextLine();

        if (citySTDMap.containsKey(city)) {
            citySTDMap.remove(city);
            System.out.println("City removed successfully.");
        } else {
            System.out.println("City not found in the collection.");
        }
    }

    // Method to search for a city name and display the code
    public static void searchCity(Map<String, Integer> citySTDMap, Scanner scanner) {
        System.out.print("Enter the city name to search: ");
        String city = scanner.nextLine();

        if (citySTDMap.containsKey(city)) {
            int stdCode = citySTDMap.get(city);
            System.out.println("STD Code for " + city + " is: " + stdCode);
        } else {
            System.out.println("City not found in the collection.");
        }
    }
}


/*
 Operations:
1. Add a new city and its code
2. Remove a city
3. Search for a city name and display the code
4. Exit
Enter your choice: 1
Enter the city name: Paris
Enter the STD code: 33
City added successfully.

Operations:
1. Add a new city and its code
2. Remove a city
3. Search for a city name and display the code
4. Exit
Enter your choice: 2
Enter the city name to remove: London
City removed successfully.

Operations:
1. Add a new city and its code
2. Remove a city
3. Search for a city name and display the code
4. Exit
Enter your choice: 3
Enter the city name to search: Tokyo
STD Code for Tokyo is: 81

Operations:
1. Add a new city and its code
2. Remove a city
3. Search for a city name and display the code
4. Exit
Enter your choice: 4
Exiting program...

*/