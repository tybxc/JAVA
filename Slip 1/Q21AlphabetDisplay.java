// Write a Java program to display all the alphabets between ‘A’ to ‘Z’ after every 2 seconds

public class Q21AlphabetDisplay {
    public static void main(String[] args) {
        // Loop to iterate over alphabets from 'A' to 'Z'
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            // Print the current alphabet
            System.out.print(ch + " ");
            
            try {
                // Pause execution for 2 seconds (2000 milliseconds)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
