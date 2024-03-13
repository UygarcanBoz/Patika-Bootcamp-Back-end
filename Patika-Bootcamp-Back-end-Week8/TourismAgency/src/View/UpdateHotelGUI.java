package View;

import Helper.Config;
import Helper.Helper;
import Model.Hotel;

import javax.swing.*;

public class UpdateHotelGUI extends JFrame {
    private JTextField fld_hotelUpdate_name;
    private JTextField fld_hotelUpdate_address;
    private JTextField fld_hotelUpdate_star;
    private JTextField fld_hotelUpdate_id;
    private JTextField fld_hotelUpdate_properties;
    private JTextField fld_hotelUpdate_city;
    private JTextField fld_hotelUpdate_region;
    private JTextField fld_hotelUpdate_tel;
    private JTextField fld_hotelUpdate_email;
    private JCheckBox chb_fld_hotelUpdate_all_incl;
    private JCheckBox chb_hotelUpdate_ultra_all_incl;
    private JCheckBox chb_hotelUpdate_full;
    private JCheckBox chb_hotelUpdate_only_room;
    private JCheckBox chb_hotelUpdate_breakfast;
    private JCheckBox chb_hotelUpdate_non_alcohol;
    private JCheckBox chb_hotelUpdate_half_board;
    private JButton btn_hotelUpdate_update;
    private JButton btn_hotelUpdate_exit;
    private JCheckBox chb_hotelUpdate_winter;
    private JCheckBox chb_hotelUpdate_spring;
    private JCheckBox chb_hotelUpdate_summer;
    private JCheckBox chb_hotelUpdate_fall;
    private JPanel wrapper;
    private JLabel lbl_season_info;
    Hotel hotel;
    private boolean updateMode;


    public UpdateHotelGUI() {
        add(wrapper);
        setSize(700, 500);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        btn_hotelUpdate_exit.addActionListener(e -> {
            dispose();
        });


    }

    // Otel güncelleme işlemi
    public UpdateHotelGUI(Hotel hotel, boolean updateMode) {
        this.add(wrapper);
        this.updateMode = updateMode;
        this.hotel = hotel;
        setSize(700, 500);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        // Otel bilgilerini güncelleme moduna göre ayarla
        if (hotel != null && updateMode == true) {

            // Mevsim seçimini gizle
            chb_hotelUpdate_winter.setVisible(false);
            chb_hotelUpdate_spring.setVisible(false);
            chb_hotelUpdate_summer.setVisible(false);
            chb_hotelUpdate_fall.setVisible(false);
            lbl_season_info.setVisible(false);

            // ID alanını devre dışı bırak
            fld_hotelUpdate_id.setEnabled(false);
            fld_hotelUpdate_id.setText(String.valueOf(hotel.getHotel_id()));
            fld_hotelUpdate_name.setText(hotel.getName());
            fld_hotelUpdate_star.setText(hotel.getStar());
            fld_hotelUpdate_properties.setText(hotel.getProperty());
            fld_hotelUpdate_address.setText(hotel.getAddress());
            fld_hotelUpdate_city.setText(hotel.getCity());
            fld_hotelUpdate_tel.setText(hotel.getPhone());
            fld_hotelUpdate_region.setText(hotel.getRegion());
            fld_hotelUpdate_email.setText(hotel.getEmail());
            chb_hotelUpdate_full.setSelected(hotel.isFull_board());
            chb_hotelUpdate_half_board.setSelected(hotel.isHalf_board());
            chb_fld_hotelUpdate_all_incl.setSelected(hotel.isAll_inclusive());
            chb_hotelUpdate_ultra_all_incl.setSelected(hotel.isUltra_all_inclusive());
            chb_hotelUpdate_non_alcohol.setSelected(hotel.isNon_alcohol());
            chb_hotelUpdate_breakfast.setSelected(hotel.isBed_and_breakfast());
            chb_hotelUpdate_only_room.setSelected(hotel.isRoom_only());

            // Güncelleme butonu işlevselliği
            btn_hotelUpdate_update.addActionListener(e -> {
                boolean updateResult = false;
                // Otel bilgilerini güncelle
                hotel.setName(fld_hotelUpdate_name.getText());
                hotel.setStar(fld_hotelUpdate_star.getText());
                hotel.setProperty(fld_hotelUpdate_properties.getText());
                hotel.setAddress(fld_hotelUpdate_address.getText());
                hotel.setCity(fld_hotelUpdate_city.getText());
                hotel.setPhone(fld_hotelUpdate_tel.getText());
                hotel.setRegion(fld_hotelUpdate_region.getText());
                hotel.setEmail(fld_hotelUpdate_email.getText());
                hotel.setFull_board(chb_hotelUpdate_full.isSelected());
                hotel.setHalf_board(chb_hotelUpdate_half_board.isSelected());
                hotel.setAll_inclusive(chb_fld_hotelUpdate_all_incl.isSelected());
                hotel.setUltra_all_inclusive(chb_hotelUpdate_ultra_all_incl.isSelected());
                hotel.setNon_alcohol(chb_hotelUpdate_non_alcohol.isSelected());
                hotel.setBed_and_breakfast(chb_hotelUpdate_breakfast.isSelected());
                hotel.setRoom_only(chb_hotelUpdate_only_room.isSelected());
                updateResult = Hotel.update(hotel);

                // Sonuca göre mesaj göster
                if (updateResult) {
                    Helper.showMsg("done");
                    dispose();
                } else {
                    Helper.showMsg("error");
                }

            });

            // Çıkış butonu
            btn_hotelUpdate_exit.addActionListener(e -> {
                dispose();
            });
        } else if (hotel != null && updateMode == false) {

            // Mevsim seçimini gizle
            chb_hotelUpdate_winter.setVisible(false);
            chb_hotelUpdate_spring.setVisible(false);
            chb_hotelUpdate_summer.setVisible(false);
            chb_hotelUpdate_fall.setVisible(false);
            lbl_season_info.setVisible(false);

            // Güncelleme moduna geç butonu işlevselliği
            btn_hotelUpdate_update.setText("Güncelle Moduna Geç");
            btn_hotelUpdate_exit.addActionListener(e -> {
                dispose();
            });

            // Güncelleme moduna geç butonu işlevselliği
            btn_hotelUpdate_update.addActionListener(e -> {

                UpdateHotelGUI update = new UpdateHotelGUI(hotel, true);
                dispose();
            });

            // Devre dışı bırakma işlevselliği
            fld_hotelUpdate_id.setEnabled(false);
            fld_hotelUpdate_name.setEnabled(false);
            fld_hotelUpdate_star.setEnabled(false);
            fld_hotelUpdate_properties.setEnabled(false);
            fld_hotelUpdate_address.setEnabled(false);
            fld_hotelUpdate_city.setEnabled(false);
            fld_hotelUpdate_tel.setEnabled(false);
            fld_hotelUpdate_region.setEnabled(false);
            fld_hotelUpdate_email.setEnabled(false);
            chb_hotelUpdate_full.setEnabled(false);
            chb_hotelUpdate_half_board.setEnabled(false);
            chb_fld_hotelUpdate_all_incl.setEnabled(false);
            chb_hotelUpdate_ultra_all_incl.setEnabled(false);
            chb_hotelUpdate_non_alcohol.setEnabled(false);
            chb_hotelUpdate_breakfast.setEnabled(false);
            chb_hotelUpdate_only_room.setEnabled(false);
            chb_hotelUpdate_winter.setEnabled(false);
            chb_hotelUpdate_spring.setEnabled(false);
            chb_hotelUpdate_summer.setEnabled(false);
            chb_hotelUpdate_fall.setEnabled(false);

            // Otel bilgilerini set et
            fld_hotelUpdate_id.setText(String.valueOf(hotel.getHotel_id()));
            fld_hotelUpdate_name.setText(hotel.getName());
            fld_hotelUpdate_star.setText(hotel.getStar());
            fld_hotelUpdate_properties.setText(hotel.getProperty());
            fld_hotelUpdate_address.setText(hotel.getAddress());
            fld_hotelUpdate_city.setText(hotel.getCity());
            fld_hotelUpdate_tel.setText(hotel.getPhone());
            fld_hotelUpdate_region.setText(hotel.getRegion());
            fld_hotelUpdate_email.setText(hotel.getEmail());
            chb_hotelUpdate_full.setSelected(hotel.isFull_board());
            chb_hotelUpdate_half_board.setSelected(hotel.isHalf_board());
            chb_fld_hotelUpdate_all_incl.setSelected(hotel.isAll_inclusive());
            chb_hotelUpdate_ultra_all_incl.setSelected(hotel.isUltra_all_inclusive());
            chb_hotelUpdate_non_alcohol.setSelected(hotel.isNon_alcohol());
            chb_hotelUpdate_breakfast.setSelected(hotel.isBed_and_breakfast());
            chb_hotelUpdate_only_room.setSelected(hotel.isRoom_only());

        }
    }
}