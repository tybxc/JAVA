// Write a java program to define a thread for printing text on output screen for ‘n’ number of times. Create 3 threads and run them. Pass the text ‘n’ parameters to the thread constructor. Example: i. First thread prints “COVID19” 10 times. ii. Second thread prints “LOCKDOWN2020” 20 times iii. Third thread prints “VACCINATED2021” 30 times

public class Q25TextPrinter implements Runnable {
    private String text;
    private int count;

    public Q25TextPrinter(String text, int count) {
        this.text = text;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Q25TextPrinter("COVID19", 10));
        Thread thread2 = new Thread(new Q25TextPrinter("LOCKDOWN2020", 20));
        Thread thread3 = new Thread(new Q25TextPrinter("VACCINATED2021", 30));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
