// Write a Java program for a simple search engine. Accept a string to be searched. Search the string in all text files in the current folder. Use a separate thread for each file. The result should display the filename and line number where the string is found.

import java.io.*;
import java.util.concurrent.*;

public class Q28SearchEngine {
    public static void main(String[] args) {
        // Accept a string to be searched
        String searchString = "example"; // Change this to the desired search string

        // Get the current directory
        File currentDir = new File(".");
        File[] files = currentDir.listFiles();

        // Create a thread pool with the same number of threads as files
        ExecutorService executor = Executors.newFixedThreadPool(files.length);

        // Iterate through each file and submit a search task to the thread pool
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                executor.submit(new SearchTask(file, searchString));
            }
        }

        // Shutdown the executor after all tasks are completed
        executor.shutdown();
    }
}

class SearchTask implements Runnable {
    private File file;
    private String searchString;

    public SearchTask(File file, String searchString) {
        this.file = file;
        this.searchString = searchString;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchString)) {
                    System.out.println("Found '" + searchString + "' in file: " + file.getName() + ", line: " + lineNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// Found 'example' in file: file1.txt, line: 1
// Found 'example' in file: file2.txt, line: 2
// Found 'example' in file: file2.txt, line: 3
