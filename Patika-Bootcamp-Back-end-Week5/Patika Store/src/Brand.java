import java.util.Iterator;
import java.util.TreeSet;

public class Brand {
    public static TreeSet<String> generateBrands() {
        TreeSet<String> brandSet = new TreeSet<>();
        brandSet.add("Samsung");
        brandSet.add("Lenovo");
        brandSet.add("Apple");
        brandSet.add("Huawei");
        brandSet.add("Casper");
        brandSet.add("Asus");
        brandSet.add("HP");
        brandSet.add("Monster");

        return brandSet;
    }

    public static void showBrands(TreeSet<String> listOfBrands) {

        Iterator<String> iterator = listOfBrands.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

