import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your birth year: ");
        int birthYear = input.nextInt();

        // Special formula is used to calculate the Chinese Zodiac.
        // We can determine the animal by using the remainder when dividing the birth year by 12.
        int zodiacIndex = (birthYear % 12);

        // Determining the Chinese Zodiac animal using switch-case.
        String zodiacSign;
        switch (zodiacIndex) {
            case 0: zodiacSign = "Monkey"; break;
            case 1: zodiacSign = "Rooster"; break;
            case 2: zodiacSign = "Dog"; break;
            case 3: zodiacSign = "Pig"; break;
            case 4: zodiacSign = "Rat"; break;
            case 5: zodiacSign = "Ox"; break;
            case 6: zodiacSign = "Tiger"; break;
            case 7: zodiacSign = "Rabbit"; break;
            case 8: zodiacSign = "Dragon"; break;
            case 9: zodiacSign = "Snake"; break;
            case 10: zodiacSign = "Horse"; break;
            case 11: zodiacSign = "Goat"; break;
            default: zodiacSign = "Invalid"; break;
        }

        System.out.println("Your Chinese Zodiac Sign: " + zodiacSign);

        input.close();
    }
}