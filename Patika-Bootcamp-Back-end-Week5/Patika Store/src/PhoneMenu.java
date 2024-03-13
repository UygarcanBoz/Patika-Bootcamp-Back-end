
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneMenu extends Menu {

    private static Scanner scanner = new Scanner(System.in);

    public PhoneMenu() {
        super("Phone Menu");

    }

    @Override
    public boolean onMenu() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Phone Menu");
            System.out.println("1- List Phones");
            System.out.println("2- Add Phone");
            System.out.println("3- Delete Phone");
            System.out.println("0- Main Menu");

            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    showPhones();
                    break;
                case 2:
                    addPhone(phones);
                    break;
                case 3:
                    deletePhone(phones);
                    break;
                case 0:
                    System.out.println("Returning to the main menu.");
                    return false;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

        }

        return true;
    }

    public static void deletePhone(ArrayList<MobilePhone> phone) {
        showPhones();
        System.out.println("Please enter the ID of the product you want to delete:");
        int deletionSelection = scanner.nextInt();

        int indexToRemove = -1;
        for (int i = 0; i < phone.size(); i++) {
            if (phone.get(i).getId() == deletionSelection) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            phone.remove(indexToRemove);
            System.out.println("Product deleted.");
            showPhones();
        } else {
            System.out.println("ID not found.");
        }
    }

    public static void addPhone(ArrayList<MobilePhone> phone) {
        ArrayList<Integer> phoneIDList = new ArrayList<>();
        for (MobilePhone phones : phone) {
            phoneIDList.add(phones.getId());
        }
        System.out.println("Please enter a new ID:");
        int newPhoneID = scanner.nextInt();
        scanner.nextLine();
        if (!phoneIDList.contains(newPhoneID)) {

            System.out.println("Please enter the price:");
            int newPhonePrice = scanner.nextInt();

            System.out.println("Please enter the discount rate:");
            Double newPhoneDiscount = scanner.nextDouble();

            System.out.println("Please enter the stock information:");
            int newPhoneStock = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter the name:");
            String newPhoneName = scanner.next();
            scanner.nextLine();
            System.out.println("Please enter the brand:");
            String newPhoneBrand = scanner.next();

            System.out.println("Please enter the storage:");
            int newPhoneStorage = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Please enter the screen size:");
            Double newPhoneScreenSize = scanner.nextDouble();

            System.out.println("Please enter the RAM (in GB):");
            int newPhoneRam = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Please enter the color:");
            String newPhoneColor = scanner.nextLine();

            System.out.println("Please enter the battery size:");
            int newPhoneBatterySize = scanner.nextInt();

            phone.add(new MobilePhone(newPhoneID, newPhonePrice, newPhoneDiscount, newPhoneStock, newPhoneName,
                    newPhoneBrand, newPhoneStorage, newPhoneScreenSize, newPhoneRam, newPhoneColor, newPhoneBatterySize));

            System.out.println("New phone added.");
            System.out.println("----------------------");
            showPhones();
        } else {
            System.out.println("ID already exists. Please try again.");

        }

    }

    static ArrayList<MobilePhone> phones = new ArrayList<>();

    static {
        phones.add(new MobilePhone(101, 1000, 0.20, 100, "Iphone 10", "Apple", 64, 6.1, 8, "White", 4000));
        phones.add(new MobilePhone(102, 2000, 0.10, 50, "Iphone 13", "Apple", 128, 6.4, 16, "Gray", 5000));

    }


    public static void showPhones() {
        System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM", "Battery", "Color", "Stock", "Discount");

        for (MobilePhone phone : phones) {
            System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    phone.getId(), phone.getName(), phone.getPrice(), phone.getBrand(), phone.getStorage(),
                    phone.getScreenSize(), phone.getRam(), phone.getBatteryPower(), phone.getColor(),
                    phone.getStockNum(), phone.getDiscountRate());
        }
    }
}
