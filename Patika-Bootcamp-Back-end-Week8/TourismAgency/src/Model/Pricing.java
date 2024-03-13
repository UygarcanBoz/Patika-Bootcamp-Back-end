package Model;

import Helper.DBConnector;
import Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// Fiyatlandırma sınıfı
public class Pricing {
    // Fiyatlandırma özellikleri
    private int pricing_id;
    private int pricing_room_id;
    private int room_price_for_adult;
    private int room_price_for_child;
    private String pricing_season_name;
    private String hostel_type;
    private Room room;
    private Hotel hotel;

    // Parametresiz constructor
    public Pricing() {
    }

    /*Pricing sınıfı için üç farklı constructor bulunmaktadır.
      Bu çeşitlilik, nesne oluşturma işlemlerini esnek hale getirmek ve
      kullanıcılara çeşitli seçenekler sunmak amacını taşımaktadır.

      1. Tam Bilgilerle Constructor:
         - Tüm bilgileri alır, bu sayede oda ve otel bilgilerini içerir.
         - En geniş kullanım için kullanılır.

      2. Oda Bilgisiyle Constructor:
         - Oda bilgisini alır, ancak otel bilgisini ayrı bir şekilde almalıdır.
         - Oda nesnesi ile kullanımı sağlar.

      3. Temel Bilgilerle Constructor:
         - Temel bilgileri alır, ancak oda ve otel bilgilerini ayrı ayrı almalıdır.
         - Otel ve oda bilgileri daha sonra ayrı ayrı atanabilir.
     */
    public Pricing(int pricing_id, int pricing_room_id, int room_price_for_adult, int room_price_for_child,
                   String pricing_season_name, String hostel_type, Room room, Hotel hotel) {
        this.pricing_id = pricing_id;
        this.pricing_room_id = pricing_room_id;
        this.room_price_for_adult = room_price_for_adult;
        this.room_price_for_child = room_price_for_child;
        this.pricing_season_name = pricing_season_name;
        this.hostel_type = hostel_type;
        this.room = room;
        this.hotel = hotel;
    }

    public Pricing( int pricing_room_id, int room_price_for_adult, int room_price_for_child,
                    String pricing_season_name, String hostel_type, Room room) {
        this.pricing_room_id = pricing_room_id;
        this.room_price_for_adult = room_price_for_adult;
        this.room_price_for_child = room_price_for_child;
        this.pricing_season_name = pricing_season_name;
        this.hostel_type = hostel_type;
        this.room = room;
    }

    public Pricing(int pricing_room_id, int room_price_for_adult, int room_price_for_child,
                   String pricing_season_name, String hostel_type) {
        this.pricing_room_id = pricing_room_id;
        this.room_price_for_adult = room_price_for_adult;
        this.room_price_for_child = room_price_for_child;
        this.pricing_season_name = pricing_season_name;
        this.hostel_type = hostel_type;
    }

    // Getter ve Setter metotları
    // Otel getirme
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    // ID Getirme
    public int getPricing_id() {
        return pricing_id;
    }

    public void setPricing_id(int pricing_id) {
        this.pricing_id = pricing_id;
    }

    // Fiyatlandırma odası ID getirme
    public int getPricing_room_id() {
        return pricing_room_id;
    }

    public void setPricing_room_id(int pricing_room_id) {
        this.pricing_room_id = pricing_room_id;
    }

    // Yetişkin fiyatı getirme metodu
    public int getRoom_price_for_adult() {
        return room_price_for_adult;
    }

    public void setRoom_price_for_adult(int room_price_for_adult) {
        this.room_price_for_adult = room_price_for_adult;
    }

    // Çocuk fiyatı getirme metodu
    public int getRoom_price_for_child() {
        return room_price_for_child;
    }

    public void setRoom_price_for_child(int room_price_for_child) {
        this.room_price_for_child = room_price_for_child;
    }

    // Fiyatlandırma mevsim adı getirme metodu
    public String getPricing_season_name() {
        return pricing_season_name;
    }

    public void setPricing_season_name(String pricing_season_name) {
        this.pricing_season_name = pricing_season_name;
    }

    // Konaklama tipi getirme metodu
    public String getHostel_type() {
        return hostel_type;
    }

    public void setHostel_type(String hostel_type) {
        this.hostel_type = hostel_type;
    }

    // Oda getirme metodu
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    // Fiyatlandırma listesini getirme metodu
    public static ArrayList<Pricing> getList() {
        ArrayList<Pricing> priceList = new ArrayList<>();
        String query = "SELECT * FROM public.pricing INNER JOIN public.room ON pricing_room_id = room_id";
        Pricing obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Pricing();
                obj.setPricing_id(rs.getInt("pricing_id"));
                obj.setPricing_room_id(rs.getInt("pricing_room_id"));
                obj.setRoom_price_for_adult(rs.getInt("room_price_for_adult"));
                obj.setRoom_price_for_child(rs.getInt("room_price_for_child"));
                obj.setPricing_season_name(rs.getString("pricing_season_name"));
                obj.setHostel_type(rs.getString("hostel_type"));
                obj.setRoom(Room.getByID(rs.getInt("room_id")));

                priceList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return priceList;
    }

    // ID'ye göre fiyatlandırma getirme metodu
    public static Pricing getByID(int id) {

        Pricing obj = null;
        String query = "SELECT * FROM public.pricing WHERE pricing_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Pricing();
                obj.setPricing_id(rs.getInt("pricing_id"));
                obj.setPricing_room_id(rs.getInt("pricing_room_id"));
                obj.setRoom_price_for_adult(rs.getInt("room_price_for_adult"));
                obj.setRoom_price_for_child(rs.getInt("room_price_for_child"));
                obj.setPricing_season_name(rs.getString("pricing_season_name"));
                obj.setHostel_type(rs.getString("hostel_type"));
                obj.setRoom(Room.getByID(rs.getInt("pricing_room_id")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // Fiyatlandırma ekleme metodu
    public static boolean add (Pricing pricing) {

        String query = "INSERT INTO public.pricing (pricing_room_id, room_price_for_adult, room_price_for_child, " +
                "pricing_season_name, hostel_type) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, pricing.getPricing_room_id());
            pr.setInt(2, pricing.getRoom_price_for_adult());
            pr.setInt(3, pricing.getRoom_price_for_child());
            pr.setString(4, pricing.getPricing_season_name());
            pr.setString(5, pricing.getHostel_type());

            int response = pr.executeUpdate();

            if (response == -1) {
                Helper.showMsg("error");
            }
            return response != -1;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }

    // Oda arama metodu
    public static ArrayList<Pricing> searchRooms (String query) {
        ArrayList<Pricing> roomList = new ArrayList<>();
        Pricing obj;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                obj = new Pricing();

                obj.setPricing_id(result.getInt("pricing_id"));
                obj.setPricing_room_id(result.getInt("pricing_room_id"));
                obj.setRoom_price_for_adult(result.getInt("room_price_for_adult"));
                obj.setRoom_price_for_child(result.getInt("room_price_for_child"));
                obj.setPricing_season_name(result.getString("pricing_season_name"));
                obj.setHostel_type(result.getString("hostel_type"));
                obj.setRoom(Room.getByID(result.getInt("room.room_id")));
                obj.setHotel(Hotel.getByID(result.getInt("hotel.hotel_id")));

                roomList.add(obj);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomList;
    }

    // Oda arama sorgusunu oluşturma metodu
    public static String searchQuery (String name, String city) {
        String query = "SELECT * FROM (public.room INNER JOIN public.hotel ON public.room.room_hotel_id = public.hotel.hotel_id ) " +
                "INNER JOIN public.pricing ON public.room.room_id = public.pricing.pricing_room_id WHERE name LIKE '%{{name}}%' " +
                "AND city LIKE '%{{city}}%' ";

        query = query.replace("{{name}}",name);
        query = query.replace("{{city}}",city);
        System.out.println(query);

        return query;
    }
}
