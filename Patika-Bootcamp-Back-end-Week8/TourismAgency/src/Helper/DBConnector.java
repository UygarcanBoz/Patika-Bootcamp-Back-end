package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DBConnector sınıfı, PostgreSQL veritabanına bağlantı sağlayan bir yardımcı sınıftır.

public class DBConnector {

    // Bağlantı nesnesi
    private Connection connect = null;

    // Veritabanına bağlantı sağlayan metot
    public Connection connectDB() {
        try {
            this.connect = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connect;
    }

    // Singleton tasarım deseni kullanarak tek bir bağlantı nesnesi döndüren metot
    public static Connection getInstance() {
        DBConnector db = new DBConnector();
        return db.connectDB();
    }

}
