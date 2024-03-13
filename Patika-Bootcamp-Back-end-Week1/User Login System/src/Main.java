import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        // Declaring variables for username and password.
        String userName, password;

        // Creating a Scanner object for user input.
        Scanner input = new Scanner(System.in);

        // Getting the username from the user.
        System.out.print("Username: ");
        userName = input.nextLine();

        // Checking if the entered username is "patika".
        if(userName.equals("patika")) {
            // If the username is correct, we will get the password aswell.
            System.out.print("Password: ");
            password = input.nextLine();

            // Checking if the entered password is "java123".
            if(password.equals("java123")) {
                System.out.print("Welcome!");  // If it's correct, displays a welcome message.
            } else {
                // If the password is incorrect, we ask the user if they want to reset it.
                System.out.print("Wrong password. Would you like to reset your password? (Yes / No) ");
                String reset = input.nextLine();

                // Checking if the user wants to reset the password.
                if (reset.equals("Yes") || reset.equals("yes")){

                    // Prompting the user to enter a new password
                    System.out.print("Enter your new password: ");
                    String newPassword = input.nextLine();

                    // Checking if the new password is the same as the old one.
                    if (newPassword.equals("java123")){
                        System.out.println("Couldn't create new password. Please enter another password.");
                    }
                    else {  // If the new password is different from the old one.
                        System.out.println("New password created.");  // Displaying a success message.
                    }
                }
                else if (reset.equals("No") || reset.equals("no")) {
                    // If the user doesn't want to reset the password, this line displays a message.
                    System.out.println("Goodbye");
                }
                else {
                    // If the user enters something other than "yes" or "no".
                    System.out.println("Wrong entry.");
                }
            }
        }
        else {
            // If the entered username is incorrect, this line displays an error message.
            System.out.print("Wrong username.");
        }

        // Closing the Scanner object to prevent resource leaks.
        input.close();
    }
}