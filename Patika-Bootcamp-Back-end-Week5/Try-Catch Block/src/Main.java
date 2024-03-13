import java.util.Scanner;

/*
    This program demonstrates the use of a custom exception in Java.
    It defines a CustomException class that extends the Exception class to handle specific situations.
    The Main class contains a method 'print' that prints the element at a given index in an array.
    If the provided index is out of bounds, a CustomException is thrown with an empty message.
    The main method takes user input for the index and attempts to call the 'print' method.
    If a CustomException is caught, an appropriate error message is displayed.
    The 'finally' block prints a message indicating the end of the program execution and closes the Scanner.
*/

public class Main{
    public static void print(int arr[], int index) throws CustomException {
        if (index >= arr.length) {
            throw new CustomException("Index is out of bounds");
        }
        System.out.println(arr[index]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index: ");
        int index = input.nextInt();
        int[] arr = new int[10];
        try{
            // Attempt to call the 'print' method
            print(arr, index);
        } catch (CustomException e) {
            // Catch the CustomException and display a relevant error message
            System.out.println(e.getMessage());
        } finally {
            // Close the Scanner to release resources
            input.close();
            // Display a message indicating the end of the program execution
            System.out.println("Program execution completed.");
        }
    }
}