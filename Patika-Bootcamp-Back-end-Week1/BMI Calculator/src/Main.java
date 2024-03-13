import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float weight, height;
        Scanner input = new Scanner(System.in);

        // Getting weight and height values from the user.
        System.out.print("Enter your weight in kilograms: ");
        weight = input.nextFloat();
        System.out.print("Enter your height in meters: ");
        height = input.nextFloat();

        // Calculating BMI.
        float bmi = weight / (height * height);

        // Determining and printing BMI category.
        if (bmi < 18.5) {
            System.out.print("Your BMI is: " + bmi + ". Category: Underweight");
        }
        else if (bmi >= 18.5 && bmi < 25.0){
            System.out.print("Your BMI is: " + bmi + ". Category: Healthy weight");
        }
        else if (bmi >= 25.0 && bmi < 30) {
            System.out.print("Your BMI is: " + bmi + ". Category: Overweight");
        }
        else {
            System.out.print("Your BMI is: " + bmi + ". Category: Obesity" );
        }
        input.close();
    }
}