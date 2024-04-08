// Write a java program to simulate traffic signal using threads

public class Q23TrafficSignal {
    public static void main(String[] args) {
        // Create and start the threads for red, yellow, and green signals
        Thread redThread = new Thread(new TrafficLight("RED", 5000)); // Red signal for 5 seconds
        Thread yellowThread = new Thread(new TrafficLight("YELLOW", 2000)); // Yellow signal for 2 seconds
        Thread greenThread = new Thread(new TrafficLight("GREEN", 7000)); // Green signal for 7 seconds

        redThread.start();
        yellowThread.start();
        greenThread.start();
    }
}

class TrafficLight implements Runnable {
    private String color;
    private long duration; // Duration for which the signal remains in this state (in milliseconds)

    public TrafficLight(String color, long duration) {
        this.color = color;
        this.duration = duration;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(color + " signal is on.");
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toggleSignal();
        }
    }

    private void toggleSignal() {
        switch (color) {
            case "RED":
                color = "GREEN";
                duration = 7000; // Green signal for 7 seconds
                break;
            case "YELLOW":
                color = "RED";
                duration = 5000; // Red signal for 5 seconds
                break;
            case "GREEN":
                color = "YELLOW";
                duration = 2000; // Yellow signal for 2 seconds
                break;
        }
    }
}


// RED signal is on.
// YELLOW signal is on.
// GREEN signal is on.
// YELLOW signal is on.
// RED signal is on.
// YELLOW signal is on.
// GREEN signal is on.
