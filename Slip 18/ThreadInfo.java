public class VowelDisplay extends Thread {
    private String text;

    public VowelDisplay(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (isVowel(ch)) {
                System.out.println(ch);
                try {
                    Thread.sleep(3000); // Sleep for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        String input = "This is a sample string with vowels.";
        VowelDisplay vowelDisplay = new VowelDisplay(input);
        vowelDisplay.start();
    }
}
