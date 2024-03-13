package View;

import Helper.Config;
import Helper.Helper;
import Model.Admin;
import Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Admin arayüz sınıfı
public class AdminGUI extends JFrame {

    User user;
    private JPanel wrapper;
    private JButton btn_admin_logout;
    private JTable tbl_admin_user_list;
    private JTextField fld_admin_name;
    private JTextField fld_admin_uname;
    private JComboBox cmb_admin_user_type;
    private JButton btn_admin_add_user;
    private JTextField fld_admin_ID;
    private JButton btn_admin_delete;
    private JTextField fld_admin_search_uname;
    private JTextField fld_admin_search_name;
    private JComboBox cmb_admin_search_type;
    private JButton btn_admin_search;
    private JLabel lbl_admin_welcome;
    private JTextField fld_admin_pass;
    private JLabel lbl_admin_pass;
    private JButton btn_admin_update;
    Object [] row_user_list;

    private final Admin admin;
    DefaultTableModel mdl_user_list;

    // Admin GUI constructor
    public AdminGUI(Admin admin) {
        mdl_user_list = new DefaultTableModel(); // Tablo Oluşturma İşlemi
        this.admin = admin;
        add(wrapper);
        setSize(800,500);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        lbl_admin_welcome.setText("Hoşgeldiniz ");

        // Çıkış butonu
        btn_admin_logout.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI = new LoginGUI();
        });

        // Admin panelinde user tablosu oluşturma
        mdl_user_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };

        Object [] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Yetki Türü"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_user_list = new Object[col_user_list.length];
        loadUserModel();
        tbl_admin_user_list.setModel(mdl_user_list);
        tbl_admin_user_list.getTableHeader().setReorderingAllowed(false);
        tbl_admin_user_list.getColumnModel().getColumn(0).setMaxWidth(50);

        // Tablodan seçim yapma
        tbl_admin_user_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                int selected_row = tbl_admin_user_list.getSelectedRow();
                fld_admin_ID.setText(tbl_admin_user_list.getValueAt(selected_row, 0).toString());
            } catch (Exception exception) {

            }
        });

        // Kullanıcı ekleme
        btn_admin_add_user.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_admin_name) || Helper.isFieldEmpty(fld_admin_uname) ||
                    Helper.isFieldEmpty(fld_admin_pass)) {
                Helper.showMsg("fill");
            }
            else {
                String name = fld_admin_name.getText();
                String uname = fld_admin_uname.getText();
                String pass = fld_admin_pass.getText();
                String type = cmb_admin_user_type.getSelectedItem().toString();
                if (User.add(name, uname, pass, type)) { // User içerisine add metodu eklenmesi gerekiyor.
                    Helper.showMsg("done");
                    loadUserModel();
                    fld_admin_name.setText(null);
                    fld_admin_uname.setText(null);
                    fld_admin_pass.setText(null);
                    cmb_admin_user_type.setSelectedIndex(0);
                }
                else {
                    Helper.showMsg("error");
                }
            }

        });

        // Kullanıcı silme
        btn_admin_delete.addActionListener(e ->

        {
            if (Helper.isFieldEmpty(fld_admin_ID)) {
                Helper.showMsg("fill");

            } else {
                int user_id = Integer.parseInt(fld_admin_ID.getText());
                if (User.delete(user_id)) {
                    Helper.showMsg("done");
                    loadUserModel();
                    fld_admin_ID.setText(null);

                } else {
                    Helper.showMsg("error");
                }
            }
        });

        // Kullanıcı arama
        btn_admin_search.addActionListener(e ->

        {
            String name = fld_admin_search_name.getText();
            String username = fld_admin_search_uname.getText();
            String type = cmb_admin_search_type.getSelectedItem().toString();
            String query = User.searchQuery(name, username, type);

            loadUserModel(User.searchUserList(query));


        });

        // Kullanıcı güncelleme
        btn_admin_update.addActionListener(e -> {

            int id = Integer.parseInt(fld_admin_ID.getText());
            UpdateAdminGUI updateAdminGUI = new UpdateAdminGUI( User.getByID(id));

        });
    }

    // User tablosu oluşturma
    public void loadUserModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_admin_user_list.getModel();
        clearModel.setRowCount(0);

        for (User obj : User.getList()) {
            int i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUname();
            row_user_list[i++] = obj.getPass();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }

    // Kullanıcı arama işlemi sonrasında tabloyu güncelleme
    public void loadUserModel (ArrayList <User> list) {
        DefaultTableModel resetModel = (DefaultTableModel) tbl_admin_user_list.getModel();
        resetModel.setRowCount(0);

        for (User obj : list) {
            int i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUname();
            row_user_list[i++] = obj.getPass();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }

    }


}
