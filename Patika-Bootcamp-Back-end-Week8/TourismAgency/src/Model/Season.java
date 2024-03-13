package Model;

import Helper.DBConnector;

import java.sql.*;
import java.util.ArrayList;

// Bu sınıf, sezon bilgilerini temsil eder ve veritabanı işlemlerini gerçekleştirir
public class Season {


    private int season_id;
    private int season_hotel_id;
    private String season_name;
    private String season_start;
    private String season_end;

    // Boş parametresiz constructor. Nesne oluşturulduğunda varsayılan değerlerle initial edilir
    public Season() {
    }

    /*
    Bu üç farklı constructor, Season sınıfının farklı şekillerde başlatılmasını sağlar:
    - Tüm Alanları Kullanarak Oluşturma: İlk constructor, tüm özelliklere sahip bir Season nesnesi oluşturmak için kullanılır.
    Bu, sezon ID'si, otel ID'si, sezon adı, başlangıç tarihi ve bitiş tarihi gibi tüm özelliklerin belirtilmesini gerektirir.
    - Otel ID'si ve Sezon Adını Kullanarak Oluşturma: İkinci constructor, otel ID'si ve sezon adı gibi temel özelliklerle sınırlı
    bir Season nesnesi oluşturur. Bu constructor'ın kullanılması, sezonun tüm ayrıntılarına gerek olmadığında yararlı olabilir.
    - ID, Otel ID'si ve Sezon Adını Kullanarak Oluşturma: Üçüncü constructor, sezonun tüm ayrıntılarına ek olarak sezonu bağlı
    olduğu otel nesnesi ile ilişkilendirmek için kullanılır. Otel nesnesi, sezonun bağlı olduğu otelin tüm bilgilerini içerir.
     */
    public Season(int season_id, int season_hotel_id, String season_name, String season_start, String season_end) {
        this.season_id = season_id;
        this.season_hotel_id = season_hotel_id;
        this.season_name = season_name;
        this.season_start = season_start;
        this.season_end = season_end;
    }

    public Season(int season_hotel_id, String season_name, String season_start, String season_end) {
        this.season_hotel_id = season_hotel_id;
        this.season_name = season_name;
        this.season_start = season_start;
        this.season_end = season_end;
    }

    // Getter and Setter metotları
    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public int getSeason_hotel_id() {
        return season_hotel_id;
    }

    public void setSeason_hotel_id(int season_hotel_id) {
        this.season_hotel_id = season_hotel_id;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public String getSeason_start() {
        return season_start;
    }

    public void setSeason_start(String season_start) {
        this.season_start = season_start;
    }

    public String getSeason_end() {
        return season_end;
    }

    public void setSeason_end(String season_end) {
        this.season_end = season_end;
    }

    // Veritabanına yeni bir sezon kaydı ekler
    public boolean save(Season season) {
        String query = "INSERT INTO public.season (season_hotel_id, season_name, season_start, season_end) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(query);

            statement.setInt(1, season.getSeason_hotel_id());
            statement.setString(2, season.getSeason_name());
            statement.setString(3, season.getSeason_start());
            statement.setString(4, season.getSeason_end());

            return statement.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }

    // Veritabanından belirtilen ID'ye sahip sezonu getirir
    public static Season getByID(int id) {

        Season obj = null;
        String query = "SELECT * FROM public.season WHERE season_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Season();
                obj.setSeason_id(rs.getInt("season_id"));
                obj.setSeason_hotel_id(rs.getInt("season_hotel_id"));
                obj.setSeason_name(rs.getString("season_name"));
                obj.setSeason_start(rs.getString("season_start"));
                obj.setSeason_end(rs.getString("season_end"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;

    }

    // Veritabanından belirtilen otel ID'si ve sezon adına sahip sezonu getirir
    public static Season getBySeasonAndHotel_ID(String name, int id) {

        Season obj = null;
        String query = "SELECT * FROM public.season WHERE season_hotel_id = ? AND season_name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            pr.setString(2,name);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Season();
                obj.setSeason_id(rs.getInt("season_id"));
                obj.setSeason_hotel_id(rs.getInt("season_hotel_id"));
                obj.setSeason_name(rs.getString("season_name"));
                obj.setSeason_start(rs.getString("season_start"));
                obj.setSeason_end(rs.getString("season_end"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;

    }

    // Veritabanındaki tüm sezonları otellere ait bilgileri ile birlikte getirir
    public static ArrayList<Season> getSeasonList () {
        ArrayList<Season> seasonList = new ArrayList<>();
        String query = "SELECT * FROM public.season INNER JOIN public.hotel ON public.season.season_hotel_id = public.hotel.hotel_id";
        Season obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new Season();
                obj.setSeason_id(rs.getInt("season_id"));
                obj.setSeason_hotel_id(rs.getInt("season_hotel_id"));
                obj.setSeason_name(rs.getString("season_name"));
                obj.setSeason_start(rs.getString("season_start"));
                obj.setSeason_end(rs.getString("season_end"));

                seasonList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seasonList;

    }

}
