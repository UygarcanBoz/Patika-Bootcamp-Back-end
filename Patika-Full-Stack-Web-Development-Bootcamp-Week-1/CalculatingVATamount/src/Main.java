import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaring variables to store monetary values.
        double money, VAT, priceWithVAT, priceWithoutVAT;

        // Creating a Scanner object for user input.
        Scanner input = new Scanner(System.in);

        // Getting the monetary value from the user.
        System.out.print("Please Enter the Monetary Value: ");
        money = input.nextDouble();

        // Checking if the entered value is negative.
        if (money < 0) {

            System.out.println("Invalid input. Please enter a non-negative value.");

        }

        // If the value is greater than 1000, apply the low VAT rate
        else if (money > 1000) {

            priceWithoutVAT = money;
            VAT = (money / 100) * 8;
            priceWithVAT = money + VAT;

            // Displaying results for low VAT rate.
            System.out.println("Price Without VAT: " + priceWithoutVAT);
            System.out.println("Price With VAT: " + priceWithVAT);
            System.out.println("VAT Amount: " + VAT);

        }

        // If the value is less than or equal to 1000, apply the high VAT rate.
        else {

            priceWithoutVAT = money;
            VAT = (money / 100) * 18;
            priceWithVAT = money + VAT;

            // Displaying results for high VAT rate.
            System.out.println("Price Without VAT: " + priceWithoutVAT);
            System.out.println("Price With VAT: " + priceWithVAT);
            System.out.println("VAT Amount: " + VAT);

        }
    }
}