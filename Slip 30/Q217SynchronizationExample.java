// Write a java program for the implementation of synchronization.

class SharedResource {
    // This shared variable will be accessed by multiple threads
    private int count = 0;

    // Method to increment the count (synchronized to ensure thread safety)
    public synchronized void increment() {
        count++;
    }

    // Method to decrement the count (synchronized to ensure thread safety)
    public synchronized void decrement() {
        count--;
    }

    // Method to get the current count (synchronized to ensure thread safety)
    public synchronized int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    private SharedResource sharedResource;

    public IncrementThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sharedResource.increment();
        }
    }
}

class DecrementThread extends Thread {
    private SharedResource sharedResource;

    public DecrementThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sharedResource.decrement();
        }
    }
}

public class Q217SynchronizationExample {
    public static void main(String[] args) throws InterruptedException {
        // Create an instance of the shared resource
        SharedResource sharedResource = new SharedResource();

        // Create multiple threads to increment and decrement the count
        IncrementThread incrementThread1 = new IncrementThread(sharedResource);
        IncrementThread incrementThread2 = new IncrementThread(sharedResource);
        DecrementThread decrementThread1 = new DecrementThread(sharedResource);
        DecrementThread decrementThread2 = new DecrementThread(sharedResource);

        // Start the threads
        incrementThread1.start();
        incrementThread2.start();
        decrementThread1.start();
        decrementThread2.start();

        // Wait for all threads to finish
        incrementThread1.join();
        incrementThread2.join();
        decrementThread1.join();
        decrementThread2.join();

        // Display the final count
        System.out.println("Final count: " + sharedResource.getCount());
    }
}
