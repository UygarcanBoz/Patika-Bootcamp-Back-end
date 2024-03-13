import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3;
        int balance = 1500;
        int select;

        // Allow the user three login attempts
        while (right > 0) {
            System.out.print("Username: ");
            userName = input.nextLine();
            System.out.print("Password: ");
            password = input.nextLine();

            // Check if the username and password are correct
            if (userName.equals("patika") && password.equals("dev123")) {
                System.out.println("Welcome to Kodluyoruz Bank!");

                do {
                    // Display the menu options to the user
                    System.out.println("1-Deposit Money\n" +
                            "2-Withdraw Money\n" +
                            "3-Check Balance\n" +
                            "4-Exit");
                    System.out.print("Please select an option: ");
                    select = input.nextInt();

                    // Perform the selected operation using switch-case
                    switch (select) {
                        case 1:
                            System.out.print("Enter the amount to deposit: ");
                            int depositAmount = input.nextInt();
                            balance += depositAmount;
                            break;
                        case 2:
                            System.out.print("Enter the amount to withdraw: ");
                            int withdrawAmount = input.nextInt();
                            if (withdrawAmount > balance) {
                                System.out.println("Insufficient balance.");
                            } else {
                                balance -= withdrawAmount;
                            }
                            break;
                        case 3:
                            System.out.println("Your balance: " + balance);
                            break;
                        case 4:
                            System.out.println("Exiting. Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid option. Please choose a valid option (1-4).");
                    }
                } while (select != 4);

                break;
            } else {
                right--;
                System.out.println("Incorrect username or password. Please try again.");
                if (right == 0) {
                    System.out.println("Your account has been blocked. Please contact the bank.");
                } else {
                    System.out.println("Remaining attempts: " + right);
                }
            }
        }

        input.close();
    }
}