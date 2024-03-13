package View;

import Helper.Config;
import Helper.Helper;
import Model.Hotel;
import Model.Season;

import javax.swing.*;
import java.time.LocalDate;

public class HotelPropertiesGUI extends JFrame {
    private JPanel wrapper;
    private JButton btn_add_season;
    private JCheckBox chb_spring;
    private JCheckBox chb_summer;
    private JCheckBox chb_winter;
    private JCheckBox chb_fall;
    private JTextField fld_spring_end;
    private JTextField fld_spring_start;
    private JTextField fld_summer_start;
    private JTextField fld_summer_end;
    private JTextField fld_winter_start;
    private JTextField fld_winter_end;
    private JTextField fld_fall_start;
    private JTextField fld_fall_end;
    private JTextField fld_add_season_hotel_id;
    private JCheckBox chb_full_board;
    private JCheckBox chb_breakfast;
    private JCheckBox chb_all_inclusive;
    private JCheckBox chb_only_room;
    private JCheckBox chb_non_alcohol;
    private JCheckBox chb_ultra_all_inclusive;
    private JButton btn_add_hostel_type;
    private JButton btn_season_exit;
    private JCheckBox chb_half_board;

    Season season;
    Hotel hotel;

    public HotelPropertiesGUI(Hotel hotel) {
        add(wrapper);
        this.hotel = hotel;
        this.season = new Season();
        setSize(700, 500);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        fld_add_season_hotel_id.setText(String.valueOf(hotel.getHotel_id()));

        btn_season_exit.addActionListener(e -> {
            dispose();
        });

        // Yeni sezon ekleme işlemi
        btn_add_season.addActionListener(e -> {
            boolean result = false;
            if (!chb_fall.isSelected() && !chb_spring.isSelected()
                    && !chb_summer.isSelected() && !chb_winter.isSelected()) {
                Helper.showMsg("Lütfen bir seçim yapınız.");
            } else {

                Season seasonControl = Season.getBySeasonAndHotel_ID(chb_fall.getText(),
                        Integer.parseInt(fld_add_season_hotel_id.getText()));

                if (chb_fall.isSelected() && seasonControl == null) {
                    Season object = new Season();
                    object.setSeason_hotel_id(Integer.parseInt(fld_add_season_hotel_id.getText()));
                    object.setSeason_name(chb_fall.getText());
                    object.setSeason_start(fld_fall_start.getText());
                    object.setSeason_end(fld_fall_end.getText());
                    this.season.save(object);
                    result = true;
                }
                seasonControl = Season.getBySeasonAndHotel_ID(chb_winter.getText(),
                        Integer.parseInt(fld_add_season_hotel_id.getText()));
                if (chb_spring.isSelected() && seasonControl == null) {
                    Season object = new Season();
                    object.setSeason_hotel_id(Integer.parseInt(fld_add_season_hotel_id.getText()));
                    object.setSeason_name(chb_spring.getText());
                    object.setSeason_start(fld_spring_start.getText());
                    object.setSeason_end(fld_spring_end.getText());
                    this.season.save(object);
                    result = true;

                }
                seasonControl = Season.getBySeasonAndHotel_ID(chb_winter.getText(),
                        Integer.parseInt(fld_add_season_hotel_id.getText()));

                if (chb_summer.isSelected() && seasonControl == null) {
                    Season object = new Season();
                    object.setSeason_hotel_id(Integer.parseInt(fld_add_season_hotel_id.getText()));
                    object.setSeason_name(chb_summer.getText());
                    object.setSeason_start(fld_summer_start.getText());
                    object.setSeason_end(fld_summer_end.getText());
                    this.season.save(object);
                    result = true;

                }
                seasonControl = Season.getBySeasonAndHotel_ID(chb_winter.getText(),
                        Integer.parseInt(fld_add_season_hotel_id.getText()));

                if (chb_winter.isSelected() && seasonControl == null) {

                    Season object = new Season();
                    object.setSeason_hotel_id(Integer.parseInt(fld_add_season_hotel_id.getText()));
                    object.setSeason_name(chb_winter.getText());
                    object.setSeason_start(fld_winter_start.getText());
                    object.setSeason_end(fld_winter_end.getText());
                    this.season.save(object);
                    result = true;

                }
                if (result) {
                    Helper.showMsg("done");
                } else {
                    Helper.showMsg("error");
                }

            }

        });

        // Otel tipi ekleme işlemi
        btn_add_hostel_type.addActionListener(e -> {
            boolean updateResult = false;


            if (!chb_all_inclusive.isSelected() && !chb_breakfast.isSelected()
                    && !chb_full_board.isSelected() && !chb_half_board.isSelected()
                    && !chb_non_alcohol.isSelected() && !chb_only_room.isSelected()
                    && !chb_ultra_all_inclusive.isSelected()) {
                Helper.showMsg("Lütfen bir seçim yapınız.");
            } else {

                if (chb_all_inclusive.isSelected()) {

                    this.hotel.setAll_inclusive(chb_all_inclusive.isSelected());
                    Hotel.update(this.hotel);
                    updateResult = true;

                }
                if (chb_breakfast.isSelected()) {

                    this.hotel.setBed_and_breakfast(chb_breakfast.isSelected());
                    Hotel.update(this.hotel);
                    updateResult = true;

                }
                if (chb_full_board.isSelected()) {

                    this.hotel.setFull_board(chb_full_board.isSelected());
                    Hotel.update(this.hotel);
                    updateResult = true;

                }
                if (chb_half_board.isSelected()) {

                    this.hotel.setHalf_board(chb_half_board.isSelected());
                    Hotel.update(this.hotel);
                    updateResult = true;

                }
                if (chb_non_alcohol.isSelected()) {

                    this.hotel.setNon_alcohol(chb_non_alcohol.isSelected());
                    Hotel.update(this.hotel);
                    updateResult = true;

                }
                if (chb_only_room.isSelected()) {

                    this.hotel.setRoom_only(chb_only_room.isSelected());
                    Hotel.update(this.hotel);
                    updateResult = true;

                }
                if (chb_ultra_all_inclusive.isSelected()) {

                    this.hotel.setUltra_all_inclusive(chb_ultra_all_inclusive.isSelected());
                    Hotel.update(this.hotel);
                    updateResult = true;
                }

                if (updateResult) {
                    Helper.showMsg("done");
                } else {
                    Helper.showMsg("error");
                }
            }
        });

    }

    public static void main(String[] args) {
        Helper.setLayout();
        new HotelPropertiesGUI(new Hotel());
    }

}
