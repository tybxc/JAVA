//Write a java program that implements a multi-thread application that has three threads. First thread generates random integer number after every one second, if the number is even; second thread computes the square of that number and print it. If the number is odd, the third thread computes the of cube of that number and print it.

import java.util.Random;

public class Q24NumberProcessor {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        SquareCalculator squareCalculator = new SquareCalculator();
        CubeCalculator cubeCalculator = new CubeCalculator();

        Thread generatorThread = new Thread(generator);
        Thread squareThread = new Thread(squareCalculator);
        Thread cubeThread = new Thread(cubeCalculator);

        generatorThread.start();
        squareThread.start();
        cubeThread.start();
    }
}

class NumberGenerator implements Runnable {
    private Random random = new Random();

    @Override
    public void run() {
        try {
            while (true) {
                int number = random.nextInt(100);
                System.out.println("Generated number: " + number);

                if (number % 2 == 0) {
                    synchronized (SquareCalculator.lock) {
                        SquareCalculator.number = number;
                        SquareCalculator.lock.notify();
                    }
                } else {
                    synchronized (CubeCalculator.lock) {
                        CubeCalculator.number = number;
                        CubeCalculator.lock.notify();
                    }
                }

                Thread.sleep(1000); // Generate number after every one second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SquareCalculator implements Runnable {
    public static final Object lock = new Object();
    public static int number;

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    lock.wait();
                    int square = number * number;
                    System.out.println("Square of " + number + ": " + square);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CubeCalculator implements Runnable {
    public static final Object lock = new Object();
    public static int number;

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    lock.wait();
                    int cube = number * number * number;
                    System.out.println("Cube of " + number + ": " + cube);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
