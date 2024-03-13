import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Welcome message and user input for the dimensions of the minefield
        // 7th step -> Matrix dimensions of the array are obtained from the user here.
        System.out.println("Welcome to the Minesweeper Game!\nEnter the Dimensions of the Board:");
        System.out.print("Number of Rows: ");
        int line = input.nextInt();
        System.out.print("Number of Columns: ");
        int pillar = input.nextInt();
        System.out.println("NOTE: If the chosen position still looks like '0', there is no mine around it!");

        // Creating an instance of the MineSweeper class and starting the game
        MineSweeper mine = new MineSweeper(line, pillar);
        mine.startGame();
    }
}