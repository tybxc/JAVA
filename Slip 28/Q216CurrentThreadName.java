// Write a java program to display name of currently executing Thread in multithreading.

public class Q216CurrentThreadName {
    public static void main(String[] args) {
        // Create a new thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Display the name of the currently executing thread
                System.out.println("Currently executing thread: " + Thread.currentThread().getName());
            }
        });

        // Start the thread
        thread.start();
    }
}

// Currently executing thread: Thread-0