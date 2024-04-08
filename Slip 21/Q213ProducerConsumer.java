// Write a java program to solve producer consumer problem in which a producer produces a value and consumer consume the value before producer generate the next value. (Hint: use thread synchronization)

import java.util.LinkedList;

public class Q213ProducerConsumer {
    public static void main(String[] args) {
        // Create a shared buffer
        Buffer buffer = new Buffer(5);

        // Create producer and consumer threads
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        // Start the threads
        producerThread.start();
        consumerThread.start();
    }
}

// Buffer class representing the shared buffer
class Buffer {
    private LinkedList<Integer> buffer;
    private int capacity;

    public Buffer(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
    }

    // Method to add a value to the buffer (producer)
    public synchronized void produce(int value) {
        while (buffer.size() == capacity) {
            try {
                wait(); // Wait if the buffer is full
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer.add(value);
        System.out.println("Produced: " + value);
        notify(); // Notify the consumer thread that a value has been produced
    }

    // Method to remove a value from the buffer (consumer)
    public synchronized int consume() {
        while (buffer.size() == 0) {
            try {
                wait(); // Wait if the buffer is empty
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int value = buffer.remove();
        System.out.println("Consumed: " + value);
        notify(); // Notify the producer thread that a value has been consumed
        return value;
    }
}

// Producer class
class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i); // Produce values from 1 to 10
        }
    }
}

// Consumer class
class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.consume(); // Consume 10 values
        }
    }
}


// Produced: 1
// Produced: 2
// Produced: 3
// Produced: 4
// Produced: 5
// Consumed: 1
// Consumed: 2
// Consumed: 3
// Consumed: 4
// Consumed: 5
// Produced: 6
// Produced: 7
// Produced: 8
// Produced: 9
// Produced: 10
// Consumed: 6
// Consumed: 7
// Consumed: 8
// Consumed: 9
// Consumed: 10