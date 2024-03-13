package View;

import Helper.Config;
import Helper.Helper;
import Model.Admin;
import Model.Employee;
import Model.User;

import javax.swing.*;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPasswordField fld_login_pass;
    private JTextField fld_login_user_name;
    private JButton btn_login;
    private JLabel lbl_login_user_name;
    private JLabel lbl_login_pass;
    private JLabel lbl_info;
    private JLabel lbl_login_info;

    public LoginGUI() {
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        // Giriş butonuna tıklama işlemi
        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_login_pass) || Helper.isFieldEmpty(fld_login_user_name)) {
                Helper.showMsg("fill");
            } else {
                User user = User.getUnameAndPass(fld_login_user_name.getText(),fld_login_pass.getText());
                if(user == null) {
                    Helper.showMsg("Kullanıcı adı veya şifre hatalı!");
                } else {
                    switch (user.getType()) {
                        case "admin":
                            AdminGUI adminGUI= new AdminGUI((Admin) user);
                            break;
                        case "employee":
                            EmployeeGUI employeeGUI = new EmployeeGUI((Employee) user);
                            break;
                        default:
                            Helper.showMsg("Bir hata oluştu!");
                            break;
                    }
                    Helper.showMsg("Hoşgeldiniz " + user.getName());
                }
                dispose();
            }
        });
    }
}