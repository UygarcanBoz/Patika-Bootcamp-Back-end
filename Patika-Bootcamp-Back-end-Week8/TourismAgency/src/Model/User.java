package Model;

import Helper.DBConnector;
import Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

// Kullanıcı sınıfı, kullanıcı verilerini temsil eder
public class User {

    private int id;
    private String name;
    private String uname;
    private String email;
    private String pass;
    private String type;

    public User(int id, String name, String uname, String email,
                String pass, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.email = email;
        this.pass = pass;
        this.type = type;
    }

    public User() {

    }

    public User(String name, String uname, String email,
                String pass, String type) {
        this.name = name;
        this.uname = uname;
        this.email = email;
        this.pass = pass;
        this.type = type;
    }

    // Getter ve Setter metotları
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    // Giriş ekranındaki kullanıcı kontrol işlemleri
    public static User getUnameAndPass(String username, String password) {

        User obj = null;
        String query = "SELECT * FROM public.user WHERE uname = ? AND pass = ? ";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);

            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                switch (rs.getString("type")) {
                    case "admin":
                        obj = new Admin();
                        break;
                    case "employee":
                        obj = new Employee();
                        break;
                    default:
                        obj = new User();
                }

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;

    }

    // Kullanıcı listesi oluşturma
    public static ArrayList<User> getList () {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        User obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);


            while (rs.next()){
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    // Kullanıcı ekleme
    public static boolean add (String name, String uname, String pass, String type) {

        String query = "INSERT INTO public.user (name,uname,pass,type) VALUES(? , ? , ? , ?)";
        User findUser = getUname(uname);
        if (findUser != null) {
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiştir.");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,uname);
            pr.setString(3,pass);
            pr.setString(4,type);

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

    // Kullanıcı adına göre kullanıcı getirme
    public static User getUname (String uname) {

        User obj = null;
        String query = "SELECT * FROM public.user WHERE uname = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);

            pr.setString(1, uname);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {

                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;

    }

    // ID'ye göre kullanıcı getirme
    public static User getByID ( int id) {

        User obj =null ;
        String query = "SELECT * FROM public.user WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new User ();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;

    }

    // Kullanıcı güncelleme
    public static boolean update (int id, String name, String username, String password, String type) {
        String query = "UPDATE public.user SET name = ? , uname = ? , pass = ? , type = ? WHERE id = ?";
        User findUser = getUname(username);
        if (findUser != null && findUser.getId() != id) {
            Helper.showMsg("Bu kullanıcı adı zaten alınmış.");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,username);
            pr.setString(3,password);
            pr.setString(4,type);
            pr.setInt(5,id);
            return pr.executeUpdate() != -1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    // Kullanıcı silme
    public static boolean delete (int id) {
        String query = "DELETE FROM public.user WHERE id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }

    // Kullanıcı arama
    public static ArrayList<User> searchUserList (String query) {
        ArrayList<User> userList = new ArrayList<>();
        User obj;

        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                obj = new User();
                obj.setId(result.getInt("id"));
                obj.setName(result.getString("name"));
                obj.setUname(result.getString("uname"));
                obj.setPass(result.getString("pass"));
                obj.setType(result.getString("type"));
                userList.add(obj);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    // Kullanıcı arama için sorgu oluşturma
    public static String searchQuery (String name, String uname, String type) {
        String query = "SELECT * FROM public.user WHERE uname LIKE '%{{uname}}%' AND name LIKE '%{{name}}%'";
        query = query.replace("{{uname}}",uname);
        query = query.replace("{{name}}",name);

        if(!type.isEmpty()) {
            query += "AND type='{{type}}'";
            query = query.replace("{{type}}",type);

        }
        return query;
    }

}
