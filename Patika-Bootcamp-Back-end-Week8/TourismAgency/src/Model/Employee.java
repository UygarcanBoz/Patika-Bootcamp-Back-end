package Model;

// Employee sınıfı, User sınıfından türetilen bir sınıftır.

public class Employee extends User {

    // Parametreli kurucu metod, Employee nesnesi oluşturur.
    public Employee(int id, String name, String uname, String email, String pass, String type) {
        super(id, name, uname, email, pass, type);
    }

    // Parametresiz kurucu metod
    public Employee() {
        // Bu kurucu metod şu anda herhangi bir şey yapmıyor, ama ileride eklenebilecek özel işlemler için bırakılmış.
    }
}
