import java.util.*;

public class Store {

    Scanner scanner = new Scanner(System.in);

    private boolean isMenu = false;
    private int select;

    public void showMenu() {
        Menu menu = null;

        while (!isMenu) {
            System.out.println();
            System.out.println("***Patika Management Panel***");
            System.out.println();
            System.out.println("1- Notebook Operations");
            System.out.println("2- Mobile Phone Operations");
            System.out.println("3- List Brands");
            System.out.println("0- Exit");
            select = scanner.nextInt();
            System.out.println("Your choice: " + select);
            switch (select) {
                case 1:
                    System.out.println();
                    menu = new NotebookMenu();
                    break;
                case 2:
                    System.out.println();
                    menu = new PhoneMenu();
                    break;
                case 3:
                    System.out.println();
                    menu = new BrandMenu();
                    break;
                case 0:
                    menu = null;
                    System.out.println("Thank you for choosing us");
                    isMenu = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    isMenu = true;
                    break;
            }
            try {
                if (!menu.onMenu()) {
                }
            } catch (NullPointerException e) {
                System.out.println("Have a nice day.");
                break;
            }
        }
    }
}
