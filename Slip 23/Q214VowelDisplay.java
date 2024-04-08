// Write a java program to accept a String from a user and display each vowel from a String after every 3 seconds.

import java.util.Scanner;

public class Q214VowelDisplay {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept a string from the user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create a thread to display vowels
        Thread vowelThread = new Thread(new VowelPrinter(input));
        vowelThread.start();
    }
}

class VowelPrinter implements Runnable {
    private String input;

    public VowelPrinter(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (isVowel(ch)) {
                System.out.println(ch);
                try {
                    Thread.sleep(3000); // Display each vowel after every 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}

// Enter a string: i am smile
// i
// a
// i
// e