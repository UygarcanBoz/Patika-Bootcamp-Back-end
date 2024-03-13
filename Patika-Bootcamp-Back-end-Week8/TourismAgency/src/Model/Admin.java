package Model;

// Admin sınıfı, User sınıfından türetilen bir sınıftır.

public class Admin extends User {

    // Parametreli kurucu metod, Admin nesnesi oluşturur.
    public Admin(int id, String name, String uname, String email, String pass, String type) {
        super(id, name, uname, email, pass, type);
    }

    // Parametresiz kurucu metod
    public Admin() {
        // Bu kurucu metod şu anda herhangi bir şey yapmıyor, ama ileride eklenebilecek özel işlemler için bırakılmış.
    }
}
