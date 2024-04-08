// Write a Java program to show lifecycle (creation, sleep, and dead) of a thread. Program should print randomly the name of thread and value of sleep time. The name of the thread should be hard coded through constructor. The sleep time of a thread will be a random integer in the range 0 to 4999.

public class Q27ThreadLifecycleDemo {
    public static void main(String[] args) {
        Thread thread1 = new CustomThread("Thread 1");
        Thread thread2 = new CustomThread("Thread 2");

        thread1.start();
        thread2.start();
    }
}

class CustomThread extends Thread {
    public CustomThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int sleepTime = (int) (Math.random() * 5000); // Random sleep time between 0 and 4999 milliseconds
            System.out.println(getName() + " is created with sleep time: " + sleepTime + " milliseconds");
            Thread.sleep(sleepTime); // Sleep for the random sleep time
            System.out.println(getName() + " is dead");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Thread 1 is created with sleep time: 1036 milliseconds
// Thread 2 is created with sleep time: 1151 milliseconds
// Thread 1 is dead
// Thread 2 is dead