package Model;

import Helper.DBConnector;
import Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// Bu sınıf rezervasyon bilgilerini temsil eder
public class Reservation {

    private int res_id;
    private int res_room_id;
    private String res_note;
    private int res_price;
    private String res_checkin;
    private String res_checkout;
    private int res_visitors;
    private String res_customer_name;
    private String res_customer_idno;
    private int res_age;
    private String res_customer_tel;
    private String res_customer_email;

    // Parametreli constructor ( kurucu metod ) - Tüm alanları kapsar
    public Reservation(int res_id, int res_room_id, String res_note, int res_price, String res_checkin,
                       String res_checkout, int res_visitors, String res_customer_name,
                       String res_customer_idno, int res_age, String res_customer_tel,
                       String res_customer_email) {
        this.res_id = res_id;
        this.res_room_id = res_room_id;
        this.res_note = res_note;
        this.res_price = res_price;
        this.res_checkin = res_checkin;
        this.res_checkout = res_checkout;
        this.res_visitors = res_visitors;
        this.res_customer_name = res_customer_name;
        this.res_customer_idno = res_customer_idno;
        this.res_age = res_age;
        this.res_customer_tel = res_customer_tel;
        this.res_customer_email = res_customer_email;
    }

    // Parametreli constructor - Zorunlu alanları kapsar
    public Reservation(int res_room_id, String res_note, int res_price, String res_checkin,
                       String res_checkout, int res_visitors, String res_customer_name,
                       String res_customer_idno, int res_age, String res_customer_tel,
                       String res_customer_email) {
        this.res_room_id = res_room_id;
        this.res_note = res_note;
        this.res_price = res_price;
        this.res_checkin = res_checkin;
        this.res_checkout = res_checkout;
        this.res_visitors = res_visitors;
        this.res_customer_name = res_customer_name;
        this.res_customer_idno = res_customer_idno;
        this.res_age = res_age;
        this.res_customer_tel = res_customer_tel;
        this.res_customer_email = res_customer_email;
    }

    // Parametresiz constructor
    public Reservation() {
    }

    // Getter ve Setter metotları

    // Rezervasyon ID'sini getirir
    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    // Rezervasyon oda ID'sini getirir
    public int getRes_room_id() {
        return res_room_id;
    }

    public void setRes_room_id(int res_room_id) {
        this.res_room_id = res_room_id;
    }

    // Rezervasyon notunu getirir
    public String getRes_note() {
        return res_note;
    }

    public void setRes_note(String res_note) {
        this.res_note = res_note;
    }

    // Rezervasyon fiyatını getirir
    public int getRes_price() {
        return res_price;
    }

    public void setRes_price(int res_price) {
        this.res_price = res_price;
    }

    // Rezervasyon giriş tarihini getirir
    public String getRes_checkin() {
        return res_checkin;
    }

    public void setRes_checkin(String res_checkin) {
        this.res_checkin = res_checkin;
    }

    // Rezervasyon çıkış tarihini getirir
    public String getRes_checkout() {
        return res_checkout;
    }

    public void setRes_checkout(String res_checkout) {
        this.res_checkout = res_checkout;
    }

    // Rezervasyon ziyaretçi sayısını getirir
    public int getRes_visitors() {
        return res_visitors;
    }

    public void setRes_visitors(int res_visitors) {
        this.res_visitors = res_visitors;
    }

    // Rezervasyon müşteri adını getirir
    public String getRes_customer_name() {
        return res_customer_name;
    }

    public void setRes_customer_name(String res_customer_name) {
        this.res_customer_name = res_customer_name;
    }

    // Rezervasyon müşteri TC kimlik numarasını getirir
    public String getRes_customer_idno() {
        return res_customer_idno;
    }

    public void setRes_customer_idno(String res_customer_idno) {
        this.res_customer_idno = res_customer_idno;
    }

    // Rezervasyon müşteri yaşını getirir
    public int getRes_age() {
        return res_age;
    }

    public void setRes_age(int res_age) {
        this.res_age = res_age;
    }

    // Rezervasyon müşteri telefon numarasını getirir
    public String getRes_customer_tel() {
        return res_customer_tel;
    }

    public void setRes_customer_tel(String res_customer_tel) {
        this.res_customer_tel = res_customer_tel;
    }

    // Rezervasyon müşteri e-posta adresini getirir
    public String getRes_customer_email() {
        return res_customer_email;
    }

    public void setRes_customer_email(String res_customer_email) {
        this.res_customer_email = res_customer_email;
    }

    // Rezervasyon bilgilerini string olarak temsil eder
    public String toString() {
        return "Reservation{" + "res_id=" + res_id +
                ", res_room_id=" + res_room_id + ", res_note=" + res_note +
                ", res_price=" + res_price + ", res_checkin=" + res_checkin +
                ", res_checkout=" + res_checkout + ", res_visitors=" + res_visitors +
                ", res_customer_name=" + res_customer_name + ", res_customer_idno=" + res_customer_idno +
                ", res_age=" + res_age + ", res_customer_tel=" + res_customer_tel +
                ", res_customer_email=" + res_customer_email + '}';
    }

    // Verilen rezervasyon bilgilerini veritabanına ekler - İşlem başarılıysa true, değilse false
    public static boolean add(Reservation reservation) {

        String query = "INSERT INTO public.reservation (reservation_room_id, reservation_note, reservation_price, " +
                "reservation_checkin, reservation_checkout, reservation_visitors, reservation_name, " +
                "reservation_idno, reservation_age, reservation_tel, reservation_email) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, reservation.getRes_room_id());
            pr.setString(2, reservation.getRes_note());
            pr.setInt(3, reservation.getRes_price());
            pr.setString(4, reservation.getRes_checkin());
            pr.setString(5, reservation.getRes_checkout());
            pr.setInt(6, reservation.getRes_visitors());
            pr.setString(7, reservation.getRes_customer_name());
            pr.setString(8, reservation.getRes_customer_idno());
            pr.setInt(9, reservation.getRes_age());
            pr.setString(10, reservation.getRes_customer_tel());
            pr.setString(11, reservation.getRes_customer_email());

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

    // Verilen rezervasyon ID'sine sahip rezervasyonu veritabanından siler - İşlem başarılıysa true, değilse false
    public static boolean delete(int id) {
        String query = "DELETE FROM public.reservation WHERE reservation_id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }

    // Veritabanındaki rezervasyonları liste olarak getirir
    public static ArrayList<Reservation> getList () {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        String query = "SELECT * FROM public.reservation";
        Reservation obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                obj = new Reservation();
                obj.setRes_id(rs.getInt("reservation_id"));
                obj.setRes_room_id(rs.getInt("reservation_room_id"));
                obj.setRes_note(rs.getString("reservation_note"));
                obj.setRes_price(rs.getInt("reservation_price"));
                obj.setRes_checkin(rs.getString("reservation_checkin"));
                obj.setRes_checkout(rs.getString("reservation_checkout"));
                obj.setRes_visitors(rs.getInt("reservation_visitors"));
                obj.setRes_customer_name(rs.getString("reservation_name"));
                obj.setRes_customer_idno(rs.getString("reservation_idno"));
                obj.setRes_age(rs.getInt("reservation_age"));
                obj.setRes_customer_tel(rs.getString("reservation_tel"));
                obj.setRes_customer_email(rs.getString("reservation_email"));

                reservationList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservationList;

    }


}
