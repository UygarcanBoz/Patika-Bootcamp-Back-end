import java.util.ArrayList;
import java.util.Scanner;

public class NotebookMenu extends Menu {
    static Scanner scanner = new Scanner(System.in);

    public NotebookMenu() {
        super("Notebook Menu");
    }

    @Override
    public boolean onMenu() {

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Notebook Menu");
            System.out.println("1- List Notebooks");
            System.out.println("2- Add Notebook");
            System.out.println("3- Delete Notebook");
            System.out.println("0- Main Menu");

            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    showNotebooks();
                    break;
                case 2:
                    addNotebook(notebooks);
                    break;
                case 3:
                    deleteNotebook(notebooks);
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

    static ArrayList<Notebook> notebooks = new ArrayList<>();

    static {
        notebooks.add(new Notebook(201, 5000, 0.20, 100, "M1", "Apple", 500, 13.0, 8));
        notebooks.add(new Notebook(202, 6000, 0.10, 50, "M2", "Apple", 1024, 15.6, 16));

    }

    private static void showNotebooks() {
        System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM", "Battery", "Color", "Stock", "Discount");

        for (Notebook notebook : notebooks) {
            System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s%n",
                    notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand(), notebook.getStorage(),
                    notebook.getScreenSize(), notebook.getRam(), notebook.getStockNum(), notebook.getDiscountRate());
        }
    }

    public void deleteNotebook(ArrayList<Notebook> notebook) {
        showNotebooks();
        System.out.println("Please enter the ID of the product you want to delete:");
        int deletionSelection = scanner.nextInt();

        int indexToRemove = -1;
        for (int i = 0; i < notebook.size(); i++) {
            if (notebook.get(i).getId() == deletionSelection) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            notebook.remove(indexToRemove);
            System.out.println("Product deleted.");
            showNotebooks();
        } else {
            System.out.println("ID not found.");
        }
    }

    public static void addNotebook(ArrayList<Notebook> notebooks) {
        ArrayList<Integer> notebookIDList = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            notebookIDList.add(notebook.getId());
        }
        System.out.println("Please enter a new ID:");
        int newNotebookID = scanner.nextInt();
        scanner.nextLine();
        if (!notebookIDList.contains(newNotebookID)) {

            System.out.println("Please enter the price:");
            int newNotebookPrice = scanner.nextInt();

            System.out.println("Please enter the discount rate:");
            Double newNotebookDiscount = scanner.nextDouble();

            System.out.println("Please enter the stock information:");
            int newNotebookStockNum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter the name:");
            String newNotebookName = scanner.next();
            scanner.nextLine();

            System.out.println("Please enter the brand:");
            String newNotebookBrand = scanner.next();

            System.out.println("Please enter the storage:");
            int newNotebookStorage = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Please enter the screen size:");
            Double newNotebookScreenSize = scanner.nextDouble();

            System.out.println("Please enter the RAM (in GB):");
            int newNotebookRam = scanner.nextInt();

            notebooks.add(new Notebook(newNotebookID, newNotebookPrice, newNotebookDiscount, newNotebookStockNum, newNotebookName,
                    newNotebookBrand, newNotebookStorage, newNotebookScreenSize, newNotebookRam));

            System.out.println("New notebook added.");
            System.out.println("----------------------");
            showNotebooks();
        } else {
            System.out.println("ID already exists. Please try again.");
        }
    }
}

