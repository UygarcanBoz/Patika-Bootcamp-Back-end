import java.util.Scanner;
import java.util.TreeSet;

public class BrandMenu extends Menu {
    Scanner scanner = new Scanner(System.in);

    public BrandMenu() {
        super("Brand Menu");
    }

    @Override
    public boolean onMenu() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Our Brands");
            System.out.println("------------");
            TreeSet<String> brandList = Brand.generateBrands();
            Brand.showBrands(brandList);
            System.out.println("0- Back to the main menu");
            int select = scanner.nextInt();
            switch (select) {
                case 0:
                    showMenu = false;
                    break;
            }
        }
        return true;
    }
}
