package View;

import Helper.Config;
import Helper.Helper;
import Model.Hotel;
import Model.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateRoomGUI extends JFrame {

    private JTextField fld_updateRoom_room_id;
    private JTextField fld_updateRoom_hotel_id;
    private JTextField fld_updateRoom_name;
    private JTextField fld_updateRoom_stock;
    private JTextField fld_updateRoom_hotel_name;
    private JTextField fld_updateRoom_capacity;
    private JTextField fld_updateRoom_area;
    private JCheckBox chb_updateRoom_tv;
    private JCheckBox chb_updateRoom_gaming;
    private JCheckBox chb_updateRoom_bank;
    private JCheckBox chb_updateRoom_bar;
    private JCheckBox chb_updateRoom_projector;
    private JButton btn_updateRoom_exit;
    private JButton btn_updateRoom_update;
    private JButton btn_updateRoom_add;
    private JPanel wrapper;
    boolean isUpdateMode;
    boolean isDisplayMode;
    Room room;
    Hotel hotel;

    // Oda güncelleme ve ekleme işlemi
    public UpdateRoomGUI(Room room, boolean isUpdateMode, boolean isDisplayMode) {
        add(wrapper);
        this.room = room;
        this.hotel = new Hotel();
        this.isUpdateMode = isUpdateMode;
        this.isDisplayMode = isDisplayMode;
        setSize(700, 500);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        // Çıkış butonu
        btn_updateRoom_exit.addActionListener(e -> {
            dispose();
        });

        // Güncelleme modunda ise
        if (room != null && isUpdateMode && !isDisplayMode) {

            // GUI elemanlarını set et
            fld_updateRoom_room_id.setText(String.valueOf(room.getRoom_id()));
            fld_updateRoom_hotel_id.setText(String.valueOf(room.getRoom_hotel_id()));
            fld_updateRoom_name.setText(room.getRoom_name());
            fld_updateRoom_stock.setText(String.valueOf(room.getRoom_stock()));
            int i = room.getRoom_hotel_id();
            hotel = Hotel.getByID(i);
            fld_updateRoom_hotel_name.setText(hotel.getName());
            fld_updateRoom_capacity.setText(String.valueOf(room.getRoom_capacity()));
            fld_updateRoom_area.setText(String.valueOf(room.getRoom_area()));
            chb_updateRoom_tv.setSelected(room.isRoom_tv());
            chb_updateRoom_gaming.setSelected(room.isRoom_gaming());
            chb_updateRoom_bank.setSelected(room.isRoom_bank());
            chb_updateRoom_bar.setSelected(room.isRoom_bar());
            chb_updateRoom_projector.setSelected(room.isRoom_projector());

            // Ekleme butonunu gizle
            btn_updateRoom_add.setVisible(false);
            // Güncelleme butonu görünür yap
            btn_updateRoom_update.setVisible(true);

            // Güncelleme butonu işlevselliği
            btn_updateRoom_update.addActionListener(e -> {

                boolean updateResult = false;

                // Güncellenecek oda bilgilerini set et
                room.setRoom_id(Integer.parseInt(fld_updateRoom_room_id.getText()));
                room.setRoom_hotel_id(Integer.parseInt(fld_updateRoom_hotel_id.getText()));
                room.setRoom_name(fld_updateRoom_name.getText());
                room.setRoom_stock(Integer.parseInt(fld_updateRoom_stock.getText()));
                room.setRoom_capacity(Integer.parseInt(fld_updateRoom_capacity.getText()));
                room.setRoom_area(Integer.parseInt(fld_updateRoom_area.getText()));
                room.setRoom_tv(chb_updateRoom_tv.isSelected());
                room.setRoom_gaming(chb_updateRoom_gaming.isSelected());
                room.setRoom_bank(chb_updateRoom_bank.isSelected());
                room.setRoom_bar(chb_updateRoom_bar.isSelected());
                room.setRoom_projector(chb_updateRoom_projector.isSelected());
                updateResult = Room.update(room);

                // Güncelleme sonucuna göre mesaj göster
                if (updateResult) {
                    Helper.showMsg("done");
                    dispose();
                } else {
                    Helper.showMsg("error");
                }

            });


        } else if (room != null && isDisplayMode && !isUpdateMode) {

            // GUI elemanlarını devre dışı bırak
            fld_updateRoom_room_id.setEnabled(false);
            fld_updateRoom_hotel_id.setEnabled(false);
            fld_updateRoom_name.setEnabled(false);
            fld_updateRoom_stock.setEnabled(false);
            fld_updateRoom_hotel_name.setEnabled(false);
            fld_updateRoom_capacity.setEnabled(false);
            fld_updateRoom_area.setEnabled(false);
            chb_updateRoom_tv.setEnabled(false);
            chb_updateRoom_gaming.setEnabled(false);
            chb_updateRoom_bank.setEnabled(false);
            chb_updateRoom_bar.setEnabled(false);
            chb_updateRoom_projector.setEnabled(false);

            // GUI elemanlarını set et
            fld_updateRoom_room_id.setText(String.valueOf(room.getRoom_id()));
            fld_updateRoom_hotel_id.setText(String.valueOf(room.getRoom_hotel_id()));
            fld_updateRoom_name.setText(room.getRoom_name());
            fld_updateRoom_stock.setText(String.valueOf(room.getRoom_stock()));
            int j = room.getRoom_hotel_id();
            hotel = Hotel.getByID(j);
            fld_updateRoom_hotel_name.setText(hotel.getName());
            fld_updateRoom_capacity.setText(String.valueOf(room.getRoom_capacity()));
            fld_updateRoom_area.setText(String.valueOf(room.getRoom_area()));
            chb_updateRoom_tv.setSelected(room.isRoom_tv());
            chb_updateRoom_gaming.setSelected(room.isRoom_gaming());
            chb_updateRoom_bank.setSelected(room.isRoom_bank());
            chb_updateRoom_bar.setSelected(room.isRoom_bar());
            chb_updateRoom_projector.setSelected(room.isRoom_projector());

            // Ekleme ve güncelleme butonlarını gizle
            btn_updateRoom_add.setVisible(false);
            btn_updateRoom_update.setVisible(false);

        }

    }

    // Yeni oda ekleme işlemi
    public UpdateRoomGUI(Hotel hotel, boolean isUpdateMode, boolean isDisplayMode) {
        add(wrapper);
        this.hotel = hotel;
        this.isDisplayMode = isDisplayMode;
        this.isUpdateMode = isUpdateMode;
        this.room = room;
        this.isUpdateMode = isUpdateMode;
        this.isDisplayMode = isDisplayMode;
        setSize(700, 500);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        if (room == null && !isUpdateMode && !isDisplayMode) {

            // Otel bilgilerini set et
            fld_updateRoom_hotel_id.setText(String.valueOf(hotel.getHotel_id()));
            fld_updateRoom_hotel_name.setText(hotel.getName());

            // Ekleme butonunu görünür yap
            btn_updateRoom_add.setVisible(true);
            // Güncelleme butonunu gizle
            btn_updateRoom_update.setVisible(false);

            // Ekleme butonu işlevselliği
            btn_updateRoom_add.addActionListener(e -> {

                Room room = new Room();
                room.setRoom_hotel_id(Integer.parseInt(fld_updateRoom_hotel_id.getText()));
                room.setRoom_name(fld_updateRoom_name.getText());
                room.setRoom_stock(Integer.parseInt(fld_updateRoom_stock.getText()));
                room.setRoom_capacity(Integer.parseInt(fld_updateRoom_capacity.getText()));
                room.setRoom_area(Integer.parseInt(fld_updateRoom_area.getText()));
                room.setRoom_tv(chb_updateRoom_tv.isSelected());
                room.setRoom_gaming(chb_updateRoom_gaming.isSelected());
                room.setRoom_bank(chb_updateRoom_bank.isSelected());
                room.setRoom_bar(chb_updateRoom_bar.isSelected());
                room.setRoom_projector(chb_updateRoom_projector.isSelected());
                boolean result = Room.add(room);

                // Ekleme sonucuna göre mesaj göster
                if (result) {
                    Helper.showMsg("done");

                    dispose();
                } else {
                    Helper.showMsg("error");
                }
            });
        }
    }
}