package View;

import Model.Admin;
import Model.Employee;
import Model.User;
import Helper.Config;
import Helper.Helper;

import javax.swing.*;

public class UpdateAdminGUI extends JFrame {

    private JPanel wrapper;
    private JButton btn_update;
    private JTextField fld_update_uname;
    private JTextField fld_update_pass;
    private JComboBox cmb_update_type;
    private JLabel lbl_update_information;
    private JTextField fld_update_name;
    private JLabel lbl_update_name;
    private JLabel lbl_update_uname;
    private JLabel lbl_update_pass;
    private JLabel lbl_update_type;
    private JButton btn_updateAdminGUI_exit;
    private JTextField fld_update_id_no;
    private JTextField fld_user_password;
    private JButton btn_update_user;
    private User user;
    private JPanel wrapper_top;
    private JPanel wrapper_bottom;

    // Model nesneleri
    private Admin admin;
    private Employee employee;

    public UpdateAdminGUI(User user) {
        // Kullanıcı bilgilerini GUI elemanlarına yerleştir
        this.user = user;
        fld_update_id_no.setText(String.valueOf(user.getId()));
        fld_update_name.setText(user.getName());
        fld_update_uname.setText(user.getUname());
        fld_update_pass.setText(user.getPass());
        cmb_update_type.setSelectedItem(user.getType());

        // GUI penceresini oluştur
        add(wrapper);
        setSize(500, 300);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        // Çıkış butonu
        btn_updateAdminGUI_exit.addActionListener(e -> {
            dispose();
        });

        // Güncelle butonu
        btn_update.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_update_name) || Helper.isFieldEmpty(fld_update_uname) || Helper.isFieldEmpty(fld_update_pass)) {
                // Gerekli alanlar boş ise uyarı göster
                Helper.showMsg("fill");
            } else {
                int user_id = user.getId();
                String name = fld_update_name.getText();
                String uname = fld_update_uname.getText();
                String pass = fld_update_pass.getText();
                String type = cmb_update_type.getSelectedItem().toString();

                try {
                    // Kullanıcıyı güncelle ve sonucuna göre mesaj göster
                    if (User.update(user_id, name, uname, pass, type)) {
                        Helper.showMsg("done");
                        dispose();
                    } else {
                        Helper.showMsg("error");
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

    }

    // GUI düzenini ayarla ve UpdateAdminGUI'yi başlat
    public static void main(String[] args) {
        Helper.setLayout();
        UpdateAdminGUI updateAdminGUI = new UpdateAdminGUI(new Admin());

    }

}
