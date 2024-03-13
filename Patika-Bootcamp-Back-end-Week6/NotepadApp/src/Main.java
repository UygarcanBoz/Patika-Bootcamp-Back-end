import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // If there is any text in the notes.txt, display it on the screen.
            FileReader fileReaderOld = new FileReader("notes.txt");
            readText(fileReaderOld);

            // Get text input from the user.
            System.out.print("Enter a text: ");
            String text = scanner.nextLine();

            // Append the new text to the existing text in the file.
            FileWriter fileWriter = new FileWriter("notes.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            // Add a newline character to separate the new text from the existing text in the file.
            printWriter.println(text);
            printWriter.close();

            // Display the last text on the screen.
            FileReader fileReader = new FileReader("notes.txt");
            readText(fileReader);

        } catch (IOException e) {
            // Handle IOException
            throw new RuntimeException(e);
        }
    }

    // A method to read and display text from a FileReader.
    public static void readText(FileReader fileReader) {
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readText;

            // Read and display each line of text.
            while ((readText = bufferedReader.readLine()) != null) {
                System.out.println(readText);
            }

            bufferedReader.close();
        } catch (IOException e) {
            // Handle IOException
            throw new RuntimeException(e);
        }
    }
}
