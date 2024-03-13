package Model;

import Helper.DBConnector;
import Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// Otel sınıfı
public class Hotel {
    // Otel özellikleri
    private int hotel_id;
    private String name;
    private String star;
    private String property;
    private String address;
    private String city;
    private String region;
    private String phone;
    private String email;
    private boolean full_board;
    private boolean half_board;
    private boolean all_inclusive;
    private boolean ultra_all_inclusive;
    private boolean non_alcohol;
    private boolean bed_and_breakfast;
    private boolean room_only;

    // Parametre alan constructor
    public Hotel(int hotel_id, String name, String star, String property, String address, String city,
                 String phone, String region, String email, boolean full_board, boolean half_board, boolean all_inclusive,
                 boolean ultra_all_inclusive, boolean non_alcohol, boolean bed_and_breakfast, boolean room_only) {
        this.hotel_id = hotel_id;
        this.name = name;
        this.star = star;
        this.property = property;
        this.address = address;
        this.city = city;
        this.region = region;
        this.phone = phone;
        this.email = email;
        this.full_board = full_board;
        this.half_board = half_board;
        this.all_inclusive = all_inclusive;
        this.ultra_all_inclusive = ultra_all_inclusive;
        this.non_alcohol = non_alcohol;
        this.bed_and_breakfast = bed_and_breakfast;
        this.room_only = room_only;
    }


    public Hotel(String name, String star, String property, String address, String city, String region,
                 String phone, String email, boolean full_board, boolean half_board, boolean all_inclusive,
                 boolean ultra_all_inclusive, boolean non_alcohol, boolean bed_and_breakfast, boolean room_only) {
        this.name = name;
        this.star = star;
        this.property = property;
        this.address = address;
        this.city = city;
        this.region = region;
        this.phone = phone;
        this.email = email;
        this.full_board = full_board;
        this.half_board = half_board;
        this.all_inclusive = all_inclusive;
        this.ultra_all_inclusive = ultra_all_inclusive;
        this.non_alcohol = non_alcohol;
        this.bed_and_breakfast = bed_and_breakfast;
        this.room_only = room_only;
    }

    // Getter ve Setter metotları

    // Otelin bulunduğu şehri getirir
    public String getCity() {
        return city;
    }
    // Otelin bulunduğu şehri belirler
    public void setCity(String city) {
        this.city = city;
    }

    // Otelin bulunduğu bölgeyi getirir
    public String getRegion() {
        return region;
    }
    // Otelin bulunduğu bölgeyi belirler
    public void setRegion(String region) {
        this.region = region;
    }

    // Parametresiz constructor
    public Hotel() {

    }

    // Getter ve Setter metotları

    // Otelin ID'sini getirir
    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    // Otelin adını getirir
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Otelin yıldızını getirir
    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    // Otelin özelliğini getirir
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    // Otelin adresini getirir
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Otelin telefon numarasını getirir
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Otelin e-posta adresini getirir
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFull_board() {
        return full_board;
    }

    public void setFull_board(boolean full_board) {
        this.full_board = full_board;
    }

    public boolean isHalf_board() {
        return half_board;
    }

    public void setHalf_board(boolean half_board) {
        this.half_board = half_board;
    }

    public boolean isAll_inclusive() {
        return all_inclusive;
    }

    public void setAll_inclusive(boolean all_inclusive) {
        this.all_inclusive = all_inclusive;
    }

    public boolean isUltra_all_inclusive() {
        return ultra_all_inclusive;
    }

    public void setUltra_all_inclusive(boolean ultra_all_inclusive) {
        this.ultra_all_inclusive = ultra_all_inclusive;
    }

    public boolean isNon_alcohol() {
        return non_alcohol;
    }

    public void setNon_alcohol(boolean non_alcohol) {
        this.non_alcohol = non_alcohol;
    }

    public boolean isBed_and_breakfast() {
        return bed_and_breakfast;
    }

    public void setBed_and_breakfast(boolean bed_and_breakfast) {
        this.bed_and_breakfast = bed_and_breakfast;
    }

    public boolean isRoom_only() {
        return room_only;
    }

    public void setRoom_only(boolean room_only) {
        this.room_only = room_only;
    }

    // Tabloyu listeleme metodu
    public static ArrayList<Hotel> getList () {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        String query = "SELECT * FROM public.hotel";
        Hotel obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                obj = new Hotel();
                obj.setHotel_id(rs.getInt("hotel_id"));
                obj.setName(rs.getString("name"));
                obj.setStar(rs.getString("star"));
                obj.setProperty(rs.getString("property"));
                obj.setAddress(rs.getString("address"));
                obj.setCity(rs.getString("city"));
                obj.setRegion(rs.getString("region"));
                obj.setPhone(rs.getString("phone"));
                obj.setEmail(rs.getString("email"));
                obj.setFull_board(rs.getBoolean("full_board"));
                obj.setHalf_board(rs.getBoolean("half_board"));
                obj.setAll_inclusive(rs.getBoolean("all_inclusive"));
                obj.setUltra_all_inclusive(rs.getBoolean("ultra_all_inclusive"));
                obj.setNon_alcohol(rs.getBoolean("non_alcohol"));
                obj.setBed_and_breakfast(rs.getBoolean("bed_and_breakfast"));
                obj.setRoom_only(rs.getBoolean("room_only"));

                hotelList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelList;

    }

    // Otel ekleme metodu
    public static boolean add (Hotel hotel) {

        String query = "INSERT INTO public.hotel (name, star, property, address, city, region, phone, email," +
                " full_board, half_board, all_inclusive, ultra_all_inclusive, non_alcohol, bed_and_breakfast, room_only) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, hotel.getName());
            pr.setString(2, hotel.getStar());
            pr.setString(3, hotel.getProperty());
            pr.setString(4, hotel.getAddress());
            pr.setString(5, hotel.getCity());
            pr.setString(6, hotel.getRegion());
            pr.setString(7, hotel.getPhone());
            pr.setString(8, hotel.getEmail());
            pr.setBoolean(9, hotel.isFull_board());
            pr.setBoolean(10, hotel.isHalf_board());
            pr.setBoolean(11, hotel.isAll_inclusive());
            pr.setBoolean(12, hotel.isUltra_all_inclusive());
            pr.setBoolean(13, hotel.isNon_alcohol());
            pr.setBoolean(14, hotel.isBed_and_breakfast());
            pr.setBoolean(15, hotel.isRoom_only());

            int response =pr.executeUpdate();

            if (response==-1) {
                Helper.showMsg("error");
            }
            return response != -1;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }

    // ID'ye göre otel getirme metodu
    public static Hotel getByID ( int id) {

        Hotel obj =null;
        String query = "SELECT * FROM public.hotel WHERE hotel_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Hotel ();
                obj.setHotel_id(rs.getInt("hotel_id"));
                obj.setName(rs.getString("name"));
                obj.setStar(rs.getString("star"));
                obj.setProperty(rs.getString("property"));
                obj.setAddress(rs.getString("address"));
                obj.setCity(rs.getString("city"));
                obj.setRegion(rs.getString("region"));
                obj.setPhone(rs.getString("phone"));
                obj.setEmail(rs.getString("email"));
                obj.setFull_board(rs.getBoolean("full_board"));
                obj.setHalf_board(rs.getBoolean("half_board"));
                obj.setAll_inclusive(rs.getBoolean("all_inclusive"));
                obj.setUltra_all_inclusive(rs.getBoolean("ultra_all_inclusive"));
                obj.setNon_alcohol(rs.getBoolean("non_alcohol"));
                obj.setBed_and_breakfast(rs.getBoolean("bed_and_breakfast"));
                obj.setRoom_only(rs.getBoolean("room_only"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    // Otel güncelleme metodu
    public static boolean update (Hotel hotel) {
        String query = "UPDATE public.hotel SET name = ? , star = ? , property = ? , address = ? , city = ? , region = ? ," +
                "phone = ? , email = ? , full_board = ? , half_board = ? , all_inclusive = ? , ultra_all_inclusive = ? ," +
                " non_alcohol = ? , bed_and_breakfast = ? , room_only = ? " +
                "WHERE hotel_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, hotel.getName());
            pr.setString(2, hotel.getStar());
            pr.setString(3, hotel.getProperty());
            pr.setString(4, hotel.getAddress());
            pr.setString(5, hotel.getCity());
            pr.setString(6, hotel.getRegion());
            pr.setString(7, hotel.getPhone());
            pr.setString(8, hotel.getEmail());
            pr.setBoolean(9, hotel.isFull_board());
            pr.setBoolean(10, hotel.isHalf_board());
            pr.setBoolean(11, hotel.isAll_inclusive());
            pr.setBoolean(12, hotel.isUltra_all_inclusive());
            pr.setBoolean(13, hotel.isNon_alcohol());
            pr.setBoolean(14, hotel.isBed_and_breakfast());
            pr.setBoolean(15, hotel.isRoom_only());
            pr.setInt(16, hotel.getHotel_id());

            return pr.executeUpdate() != -1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


    // Otel silme metodu
    public static boolean delete (int id) {
        String query = "DELETE FROM public.hotel WHERE hotel_id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }

    // Otel arama metodu
    public static ArrayList<Hotel> searchHotels (String query) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        Hotel obj;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                obj = new Hotel();
                obj.setHotel_id(result.getInt("hotel_id"));
                obj.setName(result.getString("name"));
                obj.setStar(result.getString("star"));
                obj.setProperty(result.getString("property"));
                obj.setAddress(result.getString("address"));
                obj.setCity(result.getString("city"));
                obj.setRegion(result.getString("region"));
                obj.setPhone(result.getString("phone"));
                obj.setEmail(result.getString("email"));
                obj.setFull_board(result.getBoolean("full_board"));
                obj.setHalf_board(result.getBoolean("half_board"));
                obj.setAll_inclusive(result.getBoolean("all_inclusive"));
                obj.setUltra_all_inclusive(result.getBoolean("ultra_all_inclusive"));
                obj.setNon_alcohol(result.getBoolean("non_alcohol"));
                obj.setBed_and_breakfast(result.getBoolean("bed_and_breakfast"));
                obj.setRoom_only(result.getBoolean("room_only"));

                hotels.add(obj);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    // Otel arama için sorgu oluşturma metodu
    public static String searchQuery (String name, String city, String star ) {
        String query = "SELECT * FROM public.hotel WHERE name LIKE '%{{name}}%' AND " +
                "city LIKE '%{{city}}%' AND star LIKE '%{{star}}%' ";

        query = query.replace("{{name}}",name);
        query = query.replace("{{city}}",city);
        query = query.replace("{{star}}",star);

        return query;
    }

}