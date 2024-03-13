/**
 * This program generates the pattern of the letter "B" using asterisks '*' and prints it on the console.
 * The pattern is designed in a 2D array to create the desired output for the letter "B".
 */
public class Main {
    public static void main(String[] args) {
        // Create a 2D array to represent the letter "B"
        String[][] letter = new String[7][4];

        // Fill the array with asterisks '*' based on the pattern
        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {
                if (i == 0 || i == 3 || i == 6) {
                    letter[i][j] = " * ";
                } else if (j == 0 || j == 3) {
                    letter[i][j] = " * ";
                } else {
                    letter[i][j] = "   ";
                }
            }
        }

        // Print the letter on the console
        for (String[] row : letter) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
