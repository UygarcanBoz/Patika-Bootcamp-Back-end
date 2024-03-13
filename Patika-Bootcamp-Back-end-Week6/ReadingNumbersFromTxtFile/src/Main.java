import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Replace the file path with your own file path
        String filePath = "numbers.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                try {
                    // Convert the number in the line to an integer and add it to the sum
                    int number = Integer.parseInt(line);
                    sum += number;
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing a number: " + e.getMessage());
                    // You may choose to handle this differently, like skipping the invalid line
                }
            }

            // Print the total sum to the console
            System.out.println("Total: " + sum);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            // Handle IOException (file reading error)
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
