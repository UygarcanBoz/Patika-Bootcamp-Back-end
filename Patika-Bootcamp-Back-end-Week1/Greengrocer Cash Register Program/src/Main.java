import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Determining variables to store monetary values.
        double pearPrice = 2.14, applePrice = 3.67, tomatoPrice = 1.11, bananaPrice = 0.95, auberginePrice = 5.00;

        // Creating a Scanner object for user input.
        Scanner input = new Scanner(System.in);

        // Getting quantities from the user for pears, apples, tomatoes, bananas and aubergines.
        System.out.print("How many kilograms of pears? ");
        int pear = input.nextInt();
        System.out.print("How many kilograms of apples? ");
        int apple = input.nextInt();
        System.out.print("How many kilograms of tomatoes? ");
        int tomato = input.nextInt();
        System.out.print("How many kilograms of bananas? ");
        int banana = input.nextInt();
        System.out.print("How many kilograms of aubergines? ");
        int aubergine = input.nextInt();

        // Calculating total cost.
        double totalCost = (pear * pearPrice) + (apple * applePrice) + (tomato * tomatoPrice) +
                (banana * bananaPrice) + (aubergine * auberginePrice);

        // Printing total cost.
        System.out.print("Total cost is: " + totalCost + " TL");

        input.close();
    }
}

