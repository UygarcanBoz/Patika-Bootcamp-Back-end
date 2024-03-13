import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Get text input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        scanner.close();

        // Split the text into words and convert to lowercase
        String[] words = text.toLowerCase().split("\\s+");

        // Use a HashMap to count the occurrences of each word
        Map<String, Integer> wordCounts = new HashMap<>();

        // Iterate through the words, count them, and add to the HashMap
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Find the most frequent word
        String mostFrequentWord = null;
        int mostFrequentWordCount = 0;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > mostFrequentWordCount) {
                mostFrequentWord = entry.getKey();
                mostFrequentWordCount = entry.getValue();
            }
        }

        // Print the result to the console
        if (mostFrequentWord != null) {
            System.out.println("Most frequent word: '" + mostFrequentWord + "', Total Count: " + mostFrequentWordCount);
        } else {
            System.out.println("No words found in the text.");
        }
    }
}
