package Model;

import Helper.DBConnector;
import Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Room {


    private int room_id;
    private int room_hotel_id;
    private String room_name;
    private int room_stock;
    private int room_capacity;
    private int room_area;
    private boolean room_tv;
    private boolean room_bar;
    private boolean room_projector;
    private boolean room_gaming;
    private boolean room_bank;
    private Hotel hotel;
    private Season season;

    /*
    Her bir constructor farklı durumları kapsamaktadır.
    1. constructor tüm özellikleri alırken, 2. constructor sadece otel ID'sini alır ve diğer temel özelliklere default değerler atar.
    3. constructor otel nesnesini alırken, 4. constructor ise sezon nesnesini alarak daha spesifik durumları ele alır.
    Bu sayede çeşitli durumları kapsayacak şekilde esnek bir yapı sağlanmış olur.
     */

    // 1. Constructor
    public Room(int room_id, int room_hotel_id, String room_name, int room_stock, int room_capacity,
                int room_area, boolean room_tv, boolean room_bar, boolean room_projector,
                boolean room_gaming, boolean room_bank) {
        this.room_id = room_id;
        this.room_hotel_id = room_hotel_id;
        this.room_name = room_name;
        this.room_stock = room_stock;
        this.room_capacity = room_capacity;
        this.room_area = room_area;
        this.room_tv = room_tv;
        this.room_bar = room_bar;
        this.room_projector = room_projector;
        this.room_gaming = room_gaming;
        this.room_bank = room_bank;
    }

    // 2. Constructor
    public Room( int room_hotel_id, String room_name, int room_stock, int room_capacity,
                 int room_area, boolean room_tv, boolean room_bar, boolean room_projector,
                 boolean room_gaming, boolean room_bank) {
        this.room_hotel_id = room_hotel_id;
        this.room_name = room_name;
        this.room_stock = room_stock;
        this.room_capacity = room_capacity;
        this.room_area = room_area;
        this.room_tv = room_tv;
        this.room_bar = room_bar;
        this.room_projector = room_projector;
        this.room_gaming = room_gaming;
        this.room_bank = room_bank;
    }

    // 3. Constructor
    public Room(int room_id, int room_hotel_id, String room_name, int room_stock, int room_capacity,
                int room_area, boolean room_tv, boolean room_bar, boolean room_projector,
                boolean room_gaming, boolean room_bank, Hotel hotel) {
        this.room_id = room_id;
        this.room_hotel_id = room_hotel_id;
        this.room_name = room_name;
        this.room_stock = room_stock;
        this.room_capacity = room_capacity;
        this.room_area = room_area;
        this.room_tv = room_tv;
        this.room_bar = room_bar;
        this.room_projector = room_projector;
        this.room_gaming = room_gaming;
        this.room_bank = room_bank;
        this.hotel = hotel;
    }

    // 4. Constructor
    public Room(int room_id, int room_hotel_id, String room_name, int room_stock, int room_capacity,
                int room_area, boolean room_tv, boolean room_bar, boolean room_projector,
                boolean room_gaming, boolean room_bank, Season season) {
        this.room_id = room_id;
        this.room_hotel_id = room_hotel_id;
        this.room_name = room_name;
        this.room_stock = room_stock;
        this.room_capacity = room_capacity;
        this.room_area = room_area;
        this.room_tv = room_tv;
        this.room_bar = room_bar;
        this.room_projector = room_projector;
        this.room_gaming = room_gaming;
        this.room_bank = room_bank;
        this.season = season;
    }

    // Parametresiz constructor
    public Room() {

    }

    // Getter ve Setter metotları
    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getRoom_hotel_id() {
        return room_hotel_id;
    }

    public void setRoom_hotel_id(int room_hotel_id) {
        this.room_hotel_id = room_hotel_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getRoom_stock() {
        return room_stock;
    }

    public void setRoom_stock(int room_stock) {
        this.room_stock = room_stock;
    }

    public int getRoom_capacity() {
        return room_capacity;
    }

    public void setRoom_capacity(int room_capacity) {
        this.room_capacity = room_capacity;
    }

    public int getRoom_area() {
        return room_area;
    }

    public void setRoom_area(int room_area) {
        this.room_area = room_area;
    }

    public boolean isRoom_tv() {
        return room_tv;
    }

    public void setRoom_tv(boolean room_tv) {
        this.room_tv = room_tv;
    }

    public boolean isRoom_bar() {
        return room_bar;
    }

    public void setRoom_bar(boolean room_bar) {
        this.room_bar = room_bar;
    }

    public boolean isRoom_projector() {
        return room_projector;
    }

    public void setRoom_projector(boolean room_projector) {
        this.room_projector = room_projector;
    }

    public boolean isRoom_gaming() {
        return room_gaming;
    }

    public void setRoom_gaming(boolean room_gaming) {
        this.room_gaming = room_gaming;
    }

    public boolean isRoom_bank() {
        return room_bank;
    }

    public void setRoom_bank(boolean room_bank) {
        this.room_bank = room_bank;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    // Tüm odaları getiren metot
    public static ArrayList<Room> getList() {
        ArrayList<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM public.room";
        Room obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Room();
                obj.setRoom_id(rs.getInt("room_id"));
                obj.setRoom_hotel_id(rs.getInt("room_hotel_id"));
                obj.setRoom_name(rs.getString("room_name"));
                obj.setRoom_stock(rs.getInt("room_stock"));
                obj.setRoom_capacity(rs.getInt("room_capacity"));
                obj.setRoom_area(rs.getInt("room_area"));
                obj.setRoom_tv(rs.getBoolean("room_tv"));
                obj.setRoom_bar(rs.getBoolean("room_bar"));
                obj.setRoom_projector(rs.getBoolean("room_projector"));
                obj.setRoom_gaming(rs.getBoolean("room_gaming"));
                obj.setRoom_bank(rs.getBoolean("room_bank"));

                rooms.add(obj);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;

    }

    // Oda ekleme metodu
    public static boolean add(Room room) {

        String query = "INSERT INTO public.room (room_hotel_id,room_name,room_stock,room_capacity," +
                "room_area,room_tv,room_bar,room_projector,room_gaming,room_bank) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, String.valueOf(room.getRoom_hotel_id()));
            pr.setString(2, room.getRoom_name());
            pr.setString(3, String.valueOf(room.getRoom_stock()));
            pr.setString(4, String.valueOf(room.getRoom_capacity()));
            pr.setString(5, String.valueOf(room.getRoom_area()));
            pr.setBoolean(6, room.isRoom_tv());
            pr.setBoolean(7, room.isRoom_bar());
            pr.setBoolean(8, room.isRoom_projector());
            pr.setBoolean(9, room.isRoom_gaming());
            pr.setBoolean(10, room.isRoom_bank());

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

    // Belirli bir oda ID'sine sahip odanın bilgilerini getiren metot
    public static Room getByID(int id) {

        Room obj = null;
        String query = "SELECT * FROM public.room WHERE room_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Room();
                obj.setRoom_id(rs.getInt("room_id"));
                obj.setRoom_hotel_id(rs.getInt("room_hotel_id"));
                obj.setRoom_name(rs.getString("room_name"));
                obj.setRoom_stock(rs.getInt("room_stock"));
                obj.setRoom_capacity(rs.getInt("room_capacity"));
                obj.setRoom_area(rs.getInt("room_area"));
                obj.setRoom_tv(rs.getBoolean("room_tv"));
                obj.setRoom_bar(rs.getBoolean("room_bar"));
                obj.setRoom_projector(rs.getBoolean("room_projector"));
                obj.setRoom_gaming(rs.getBoolean("room_gaming"));
                obj.setRoom_bank(rs.getBoolean("room_bank"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;

    }

    // Oda Güncelleme
    // Oda bilgilerini güncelleyen metot
    public static boolean update(Room room) {
        String query = "UPDATE public.room SET room_hotel_id = ?,room_name = ?,room_stock = ?,room_capacity = ?," +
                "room_area = ?,room_tv = ?,room_bar = ?,room_projector = ?,room_gaming = ?, room_bank = ? WHERE room_id = ?";


        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, room.getRoom_hotel_id());
            pr.setString(2, room.getRoom_name());
            pr.setInt(3, room.getRoom_stock());
            pr.setInt(4, room.getRoom_capacity());
            pr.setInt(5, room.getRoom_area());
            pr.setBoolean(6, room.isRoom_tv());
            pr.setBoolean(7, room.isRoom_bar());
            pr.setBoolean(8, room.isRoom_projector());
            pr.setBoolean(9, room.isRoom_gaming());
            pr.setBoolean(10, room.isRoom_bank());
            pr.setInt(11, room.getRoom_id());

            return pr.executeUpdate() != -1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


    // Oda silme
    // Belirli bir oda ID'sine sahip olan odayı silen metot
    public static boolean delete(int id) {
        String query = "DELETE FROM public.room WHERE room_id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }


    // Belirli bir sorguya göre odaları arayan metot
    public static ArrayList<Room> searchRooms (String query) {
        ArrayList<Room> rooms = new ArrayList<>();
        Room obj;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                obj = new Room();
                obj.setRoom_id(result.getInt("room_id"));
                obj.setRoom_hotel_id(result.getInt("room_hotel_id"));
                obj.setRoom_name(result.getString("room_name"));
                obj.setRoom_stock(result.getInt("room_stock"));
                obj.setRoom_capacity(result.getInt("room_capacity"));
                obj.setRoom_area(result.getInt("room_area"));
                obj.setRoom_tv(result.getBoolean("room_tv"));
                obj.setRoom_bar(result.getBoolean("room_bar"));
                obj.setRoom_projector(result.getBoolean("room_projector"));
                obj.setRoom_gaming(result.getBoolean("room_gaming"));
                obj.setRoom_bank(result.getBoolean("room_bank"));
                obj.setHotel(Hotel.getByID(obj.getRoom_hotel_id()));

                rooms.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
