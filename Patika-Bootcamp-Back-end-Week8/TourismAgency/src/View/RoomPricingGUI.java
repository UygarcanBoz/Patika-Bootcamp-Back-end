package View;

import Helper.Config;
import Helper.Helper;
import Model.Hotel;
import Model.Pricing;
import Model.Room;
import Model.Season;

import javax.swing.*;

public class RoomPricingGUI extends JFrame {
    private JTextField fld_pricing_hotel_name;
    private JTextField fld_pricing_room_name;
    private JTextField fld_pricing_hotel_id;
    private JTextField fld_pricing_room_id;
    private JComboBox cmb_pricing_hostel;
    private JTextField fld_room_price_for_adult;
    private JTextField fld_room_price_for_child;
    private JComboBox cmb_pricing_season;
    private JButton btn_room_price_exit;
    private JButton btn_room_price_save;
    private JPanel wrapper;

    // Model nesneleri
    Room room;
    Hotel hotel;

    public RoomPricingGUI(Room room) {
        // GUI penceresini oluştur
        add(wrapper);
        setSize(700,500);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        // GUI elemanlarına başlangıç değerlerini set et
        this.room = room;
        hotel = Hotel.getByID(room.getRoom_hotel_id());
        fld_pricing_hotel_name.setText(hotel.getName());
        fld_pricing_room_name.setText(room.getRoom_name());
        fld_pricing_hotel_id.setText(String.valueOf(room.getRoom_hotel_id()));
        fld_pricing_room_id.setText(String.valueOf(room.getRoom_id()));

        if (hotel.isAll_inclusive()) {
            cmb_pricing_hostel.addItem("Her Şey Dahil");
        }
        if (hotel.isNon_alcohol()) {
            cmb_pricing_hostel.addItem("Alkolsüz Her Şey Dahil");
        }
        if (hotel.isUltra_all_inclusive()) {
            cmb_pricing_hostel.addItem("Ultra Her Şey Dahil");
        }
        if (hotel.isFull_board()) {
            cmb_pricing_hostel.addItem("Tam Pansiyon");
        }
        if (hotel.isHalf_board()) {
            cmb_pricing_hostel.addItem("Yarım Pansiyon");
        }
        if (hotel.isBed_and_breakfast()) {
            cmb_pricing_hostel.addItem("Kahvaltı Dahil");
        }
        if (hotel.isRoom_only()) {
            cmb_pricing_hostel.addItem("Sadece Konaklama");
        }

        for (Season season : Season.getSeasonList()) {
            if (season.getSeason_hotel_id() == room.getRoom_hotel_id()) {
                cmb_pricing_season.addItem(season.getSeason_name());
            }
        }

        // Exit butonu
        btn_room_price_exit.addActionListener(e -> {
            dispose();
        });

        // Kaydet butonu
        btn_room_price_save.addActionListener(e -> {
            boolean result = false;
            if (Helper.isFieldEmpty(fld_room_price_for_adult) || Helper.isFieldEmpty(fld_room_price_for_child)) {
                // Gerekli alanlar boşsa uyarı göster
                Helper.showMsg("fill");
            } else {
                // Gerekli alanlar doluysa yeni bir Pricing nesnesi oluştur ve eklemeyi dene
                Pricing obj = new Pricing();
                obj.setPricing_room_id(room.getRoom_id());
                obj.setRoom_price_for_adult(Integer.parseInt(fld_room_price_for_adult.getText()));
                obj.setRoom_price_for_child(Integer.parseInt(fld_room_price_for_child.getText()));
                obj.setPricing_season_name(cmb_pricing_season.getSelectedItem().toString());
                obj.setHostel_type(cmb_pricing_hostel.getSelectedItem().toString());
                result = Pricing.add(obj);
            }

            // Ekleme sonucuna göre mesaj göster
            if (result) {
                Helper.showMsg("done");
                dispose();
            } else {
                Helper.showMsg("error");
            }

        });


        /*
        // Hostel tipi ComboBox'ına seçenekleri ekle
        addHostelOptions();

        // Mevsim ComboBox'ına seçenekleri ekle
        addSeasonOptions();

        // Hostel tipi ComboBox'ına seçenekleri ekleyen metot
    private void addHostelOptions() {
        if (hotel.isAll_inclusive()) {
            cmb_pricing_hostel.addItem("Her Şey Dahil");
        }
        if (hotel.isNon_alcohol()) {
            cmb_pricing_hostel.addItem("Alkolsüz Her Şey Dahil");
        }
        if (hotel.isUltra_all_inclusive()) {
            cmb_pricing_hostel.addItem("Ultra Her Şey Dahil");
        }
        if (hotel.isFull_board()) {
            cmb_pricing_hostel.addItem("Tam Pansiyon");
        }
        if (hotel.isHalf_board()) {
            cmb_pricing_hostel.addItem("Yarım Pansiyon");
        }
        if (hotel.isBed_and_breakfast()) {
            cmb_pricing_hostel.addItem("Kahvaltı Dahil");
        }
        if (hotel.isRoom_only()) {
            cmb_pricing_hostel.addItem("Sadece Konaklama");
        }
    }

    // Mevsim ComboBox'ına seçenekleri ekleyen metot
    private void addSeasonOptions() {
        for (Season season : Season.getSeasonList()) {
            if (season.getSeason_hotel_id() == room.getRoom_hotel_id()) {
                cmb_pricing_season.addItem(season.getSeason_name());
            }
        }
    }
        */

    }
}
