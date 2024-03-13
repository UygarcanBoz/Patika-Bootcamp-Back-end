import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class MineSweeper {
    // 5th step -> The project is designed here within the MineSweeper Class.
    int lineNumber, pillarNumber, size;
    int[][] map;
    int[][] board;
    boolean[][] openBoard;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    boolean isGame = true;

    MineSweeper(int lineNumber, int pillarNumber) {
        this.lineNumber = lineNumber;
        this.pillarNumber = pillarNumber;
        this.size = lineNumber * pillarNumber;
        this.map = new int[lineNumber][pillarNumber];
        this.board = new int[lineNumber][pillarNumber];
        this.openBoard = new boolean[lineNumber][pillarNumber];
    }

    public void startGame() {

        int lineChoice, pillarChoice, rightChoice = 0;

        // Placing mines and creating the initial board
        setMines();
        createBoard(map);

        System.out.println("Your game has started.");
        // 6th step -> The start of the game and the controls for winning or losing are found here.
        while (isGame) {

            createBoard(board); // 11th step -> Updating the board each time the user makes a move.
            // User input for selecting a position
            // 9th step -> The row and column the user wants to mark are taken here.
            System.out.print("Choose a Row: ");
            lineChoice = input.nextInt();
            System.out.print("Choose a Column: ");
            pillarChoice = input.nextInt();

            // Checking if the chosen position is within the boundaries
            /* 10th step -> It is checked whether the point selected by the user is within the boundaries of the field.
               A warning message is given.
               The loop returns to the input section with the 'continue' command and the input part is prompted again.
            */
            if (lineChoice < 0 || lineChoice > lineNumber - 1) {
                System.out.println("You entered a position outside of the game area.");
                continue;
            }
            if (pillarChoice < 0 || pillarChoice > pillarNumber - 1) {
                System.out.println("You entered a position outside of the game area.");
                continue;
            }

            // Checking if the selected position has been opened before
            if (!openBoard[lineChoice][pillarChoice]) {
                // Handling the case where the chosen position is not a mine
                // 12th step -> The area around the entered point is checked, and the number of mines is written instead of 0.
                if (map[lineChoice][pillarChoice] != -1) {
                    checkMine(lineChoice, pillarChoice);
                    rightChoice++;

                    // Checking if the user has won the game by opening all non-mine positions
                    // 14th step -> If all points without mines are selected, the winning control is here.
                    if (rightChoice == (size - (size / 4))) {
                        System.out.println("Congratulations! You found all non-mine positions.");
                        createBoard(board);
                        break;
                    }
                }
                // Handling the case where the chosen position is a mine (Game Over)
                // 13th step -> The part that ends the game if the user steps on a mine.
                // 15th step -> Appropriate message in case of losing is here.
                else {
                    System.out.println("You hit a mine!\nThe game is over.");
                    createBoard(map);
                    isGame = false;
                }
                openBoard[lineChoice][pillarChoice] = true;
            } else {
                System.out.println("You made this choice before.");
            }
        }
    }

    public void setMines() {
        // Placing the appropriate number of mines randomly in the array
        // 8th step -> The appropriate number of mines is placed in the array in this section.
        int randLine, randPillar, mine = 0;

        while (mine != (size / 4)) {
            randLine = rand.nextInt(lineNumber);
            randPillar = rand.nextInt(pillarNumber);
            if (map[randLine][randPillar] != -1) {
                map[randLine][randPillar] = -1;
                mine++;
            }
        }
    }

    public void createBoard(int[][] arr) {
        // Displaying the current state of the board
        for (int i = 0; i < lineNumber; i++) {
            for (int j = 0; j < pillarNumber; j++) {
                if (arr[i][j] >= 0)
                    System.out.print(" ");
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkMine(int i, int j) {
        // Checking the surrounding of the chosen position and updating the board accordingly
        if (map[i][j] == 0) {
            if ((i > 0) && (j > 0) && (map[i - 1][j - 1] == -1)) {
                board[i][j]++;
            }
            if ((i > 0) && (map[i - 1][j] == -1)) {
                board[i][j]++;
            }
            if ((j < pillarNumber - 1) && (i > 0) && (map[i - 1][j + 1] == -1)) {
                board[i][j]++;
            }
            if ((j > 0) && (map[i][j - 1] == -1)) {
                board[i][j]++;
            }
            if ((j < pillarNumber - 1) && (map[i][j + 1] == -1)) {
                board[i][j]++;
            }
            if ((i < lineNumber - 1) && (j > 0) && (map[i + 1][j - 1] == -1)) {
                board[i][j]++;
            }
            if ((i < lineNumber - 1) && (map[i + 1][j] == -1)) {
                board[i][j]++;
            }
            if ((j < pillarNumber - 1) && (i < lineNumber - 1) && (map[i + 1][j + 1] == -1)) {
                board[i][j]++;
            }
        }
    }
}