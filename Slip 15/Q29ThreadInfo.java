// Write a java program to display name and priority of a Thread.

public class Q29ThreadInfo {
    public static void main(String[] args) {
        // Create a thread object
        Thread thread = new Thread();

        // Display the name of the thread
        System.out.println("Thread Name: " + thread.getName());

        // Display the priority of the thread
        System.out.println("Thread Priority: " + thread.getPriority());
    }
}

// Thread Name: Thread-0
// Thread Priority: 5