package View;

import Helper.Config;
import Helper.Helper;
import Model.Pricing;
import Model.Reservation;
import Model.Room;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ReservationGUI extends JFrame {

    private JTextField fld_reservation_room_id;
    private JTextField fld_child_visitors;
    private JTextField fld_customer_name;
    private JFormattedTextField fld_checkin;
    private JFormattedTextField fld_checkout;
    private JTextField fld_customer_tel;
    private JTextField fld_customer_email;
    private JTextField fld_reservation_note;
    private JTextField fld_customer_age;
    private JTextField fld_customer_idno;
    private JButton btn_reservation_exit;
    private JButton btn_reservation_update;
    private JButton btn_reservation_add;
    private JTextField fld_adult_visitors;
    private JTextField fld_reservation_room_name;
    private JButton btn_calculate;
    private JTextField fld_total_price;
    private JTextField fld_reservation_season;
    private JPanel wrapper;
    private JTextField fld_res_id;
    private JTextField fld_days;
    private JTextField fld_reservation_hostel_type;

    // Model nesneleri
    Room room;
    Reservation reservation;
    Pricing pricing;

    DateTimeFormatter format;

    public ReservationGUI(Pricing pricing, Reservation reservation, boolean isUpdateMode, boolean isDisplayMode) {
        // GUI penceresini oluştur
        add(wrapper);
        this.room = Room.getByID(pricing.getPricing_room_id());
        this.pricing = pricing;
        this.reservation = reservation;
        format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        setSize(700, 500);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        // Exit butonu işlevselliği
        btn_reservation_exit.addActionListener(e -> {
            dispose();
        });

        // Rezervasyon ekleme

        if (pricing != null && reservation == null && !isUpdateMode && !isDisplayMode) {

            // Güncelleme modu değilse ve rezervasyon boşsa ve görüntüleme modu değilse
            btn_reservation_update.setVisible(false);

            // GUI elemanlarına başlangıç değerlerini set et
            fld_reservation_room_id.setText(String.valueOf(room.getRoom_id()));
            fld_reservation_room_name.setText(room.getRoom_name());
            fld_reservation_season.setText(pricing.getPricing_season_name());
            fld_reservation_hostel_type.setText(pricing.getHostel_type());

            // Rezervasyon ekleme butonu işlevselliği
            btn_reservation_add.addActionListener(e -> {

                // Yeni bir rezervasyon nesnesi oluştur
                Reservation obj = new Reservation();
                obj.setRes_room_id(Integer.parseInt(fld_reservation_room_id.getText()));
                obj.setRes_note(fld_reservation_note.getText());
                obj.setRes_price(Integer.parseInt(fld_total_price.getText()));
                obj.setRes_checkin(fld_checkin.getText());
                obj.setRes_checkout(fld_checkout.getText());
                obj.setRes_visitors(Integer.parseInt(fld_adult_visitors.getText()) +
                        Integer.parseInt(fld_child_visitors.getText()));
                obj.setRes_customer_name(fld_customer_name.getText());
                obj.setRes_customer_idno(fld_customer_idno.getText());
                obj.setRes_age(Integer.parseInt(fld_customer_age.getText()));
                obj.setRes_customer_tel(fld_customer_tel.getText());
                obj.setRes_customer_email(fld_customer_email.getText());

                // Rezervasyonu ekleyip sonucu kontrol et
                boolean result = Reservation.add(obj);
                if (result) {
                    // Başarılı bir şekilde eklenirse
                    Helper.showMsg("done");
                    room.setRoom_stock(room.getRoom_stock() - 1);

                    // Oda stoğunu güncelle
                    if (Room.update(room)) {
                        Helper.showMsg("Oda stoğu güncellendi");
                    } else {
                        Helper.showMsg("Oda stoğu güncellenemedi");
                    }
                    // Pencereyi kapat
                    dispose();
                } else {
                    // Eklenirken hata olursa
                    Helper.showMsg("error");
                }
            });
        }

        // Hesaplama butonu işlevselliği
        btn_calculate.addActionListener(e -> {
            int adultVisitors = Integer.parseInt(fld_adult_visitors.getText());
            int childVisitors = Integer.parseInt(fld_child_visitors.getText());


            String checkin = fld_checkin.getText();
            String checkout = fld_checkout.getText();


            LocalDate checkinDate = LocalDate.parse(checkin, format);
            LocalDate checkoutDate = LocalDate.parse(checkout, format);

            long daysBetween = ChronoUnit.DAYS.between(checkinDate, checkoutDate);

            int days = (int) daysBetween;

            int total = (adultVisitors * pricing.getRoom_price_for_adult()) +
                    (childVisitors * pricing.getRoom_price_for_child());

            fld_total_price.setText(String.valueOf(total * days));
            fld_days.setText(String.valueOf(days));
        });

    }

    // JFormattedTextField öğelerini oluştururken hata ayıklamak için kullanılır
    private void createUIComponents() throws ParseException {

        this.fld_checkin = new JFormattedTextField(new MaskFormatter("##/##/####"));
        fld_checkin.setText("00/00/0000");

        this.fld_checkout = new JFormattedTextField(new MaskFormatter("##/##/####"));
        fld_checkout.setText("00/00/0000");
    }

}