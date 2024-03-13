package View;

import Helper.Config;
import Helper.Helper;
import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EmployeeGUI extends JFrame {

    private JPanel wrapper;
    private JTabbedPane tabbedPane_HotelAgency;
    private JButton btn_log_out;
    private JTable tbl_book_room_list;
    private JButton btn_book_search;
    private JTextField fld_book_hotel_name;
    private JTextField fld_book_hotel_city;
    private JTextField fld_bookl_checkin;
    private JTextField fld_book_checkout;
    private JTextField fld_book_price_id;
    private JButton btn_book_add;
    private JTable tbl_hotel_list;
    private JTextField fld_hotel_star;
    private JTextField fld_hotel_name;
    private JTextField fld_hotel_properties;
    private JTextField fld_hotel_email;
    private JTextField fld_hotel_address;
    private JTextField fld_hotel_tel;
    private JButton btn_hotel_season_add;
    private JTextField fld_hotel_id_number;
    private JTable tbl_room_hotel_list;
    private JTextField fld_room_hotel_star;
    private JTextField fld_room_hotel_name;
    private JTextField fld_room_hotel_city;
    private JButton btn_room_hotel_search;
    private JTable tbl_room_room_list;
    private JButton btn_room_add;
    private JTextField fld_room_hotel_id;
    private JTextField fld_room_id;
    private JButton btn_room_delete;
    private JButton btn_room_details;
    private JButton fld_hotel_delete;
    private JButton fld_hotel_update;
    private JButton fld_hotel_details;
    private JButton btn_room_update;
    private JButton fld_hotel_table_refresh;
    private JButton btn_room_table_refresh;
    private JButton btn_hotel_add;
    private JTextField fld_hotel_city;
    private JTextField fld_hotel_region;
    private JButton btn_room_add_price;
    private JTable tbl_book_list;
    private JButton btn_book_details;
    private JTextField fld_book_id;
    private JButton btn_book_delete;
    private JButton btn_book_update;
    private JButton btn_book_refresh;
    private JTextField fld_book_room_id;
    private JButton pansiyonTürüTablosuButton;
    private JButton sezonTablosuButton;

    Object[] row_book_room_list;

    Object[] row_hotel_list;

    DefaultTableModel mdl_book_room_list;

    DefaultTableModel mdl_hotel_list;

    Object[] row_room_hotel_list;

    DefaultTableModel mdl_room_hotel_list;

    DefaultTableModel mdl_room_list;

    Object[] row_room_list;
    User user;
    Hotel hotel;
    DefaultTableModel mdl_reservation_list;
    Object[] row_reservation_list;

    DateTimeFormatter format;

    public EmployeeGUI() {


    }

    public EmployeeGUI(User user) {
        add(wrapper);
        this.user = user;
        this.hotel = hotel;
        mdl_hotel_list = new DefaultTableModel();
        mdl_book_room_list = new DefaultTableModel();
        mdl_room_hotel_list = new DefaultTableModel();
        mdl_room_list = new DefaultTableModel();
        mdl_reservation_list = new DefaultTableModel();
        format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        setSize(1000, 700);
        setLocation(Helper.center("x", getSize()), Helper.center("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(true);
        setVisible(true);

        // Çıkış butonu
        btn_log_out.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI = new LoginGUI();
        });


        // Otel sekmesinde otel tablosu oluşturma
        mdl_hotel_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_hotel_list = {"ID", "Otel İsmi", "Şehir", "Yıldız"};
        mdl_hotel_list.setColumnIdentifiers(col_hotel_list);
        row_hotel_list = new Object[col_hotel_list.length];
        loadHotelModel();
        tbl_hotel_list.setModel(mdl_hotel_list);
        tbl_hotel_list.getTableHeader().setReorderingAllowed(false);
        tbl_hotel_list.getColumnModel().getColumn(0).setMaxWidth(50);


        // Oda yönetiminde otel tablosu oluşturma
        mdl_room_hotel_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_room_hotel_list = {"ID", "Otel İsmi", "Şehir", "Bölge", "Telefon", "Yıldız"};
        mdl_room_hotel_list.setColumnIdentifiers(col_room_hotel_list);
        row_room_hotel_list = new Object[col_room_hotel_list.length];
        loadRoomHotelTable();
        tbl_room_hotel_list.setModel(mdl_room_hotel_list);
        tbl_room_hotel_list.getTableHeader().setReorderingAllowed(false);
        tbl_room_hotel_list.getColumnModel().getColumn(0).setMaxWidth(50);


        // Oda yönetiminde oda tablosu oluşturma
        mdl_room_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_room_list = {"ID", "Otel ID", "Oda İsmi", "Stok", "Kapasite"};
        mdl_room_list.setColumnIdentifiers(col_room_list);
        row_room_list = new Object[col_room_list.length];
        loadRoomModel();
        tbl_room_room_list.setModel(mdl_room_list);
        tbl_room_room_list.getTableHeader().setReorderingAllowed(false);
        tbl_room_room_list.getColumnModel().getColumn(0).setMaxWidth(50);


        // Rezervasyon sekmesinde oda tablosu oluşturma
        mdl_book_room_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_book_room_list = {"Fiyat ID", "Oda ID", "Otel İsmi", "Şehir", "Oda Adı",
                "Oda Stoğu", "Oda Kapasitesi", "Sezon", "Başlangıç", "Bitiş", "Pansiyon Türü"};
        mdl_book_room_list.setColumnIdentifiers(col_book_room_list);
        row_book_room_list = new Object[col_book_room_list.length];
        loadReservationRoomModel();
        tbl_book_room_list.setModel(mdl_book_room_list);
        tbl_book_room_list.getTableHeader().setReorderingAllowed(false);
        tbl_book_room_list.getColumnModel().getColumn(0).setMaxWidth(50);


        // Rezervasyon sekmesinde rezervasyon tablosu oluşturma
        mdl_reservation_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_book_list = {"Rezervasyon ID", "Otel İsmi", "Müşteri İsmi", "Check-in Tarihi",
                "Check-out Tarihi", "Oda İsmi"};
        mdl_reservation_list.setColumnIdentifiers(col_book_list);
        row_reservation_list = new Object[col_book_list.length];
        loadReservationTable();
        tbl_book_list.setModel(mdl_reservation_list);
        tbl_book_list.getTableHeader().setReorderingAllowed(false);
        tbl_book_list.getColumnModel().getColumn(0).setMaxWidth(50);


        // Otel sekmesindeki tablodan seçim yapma
        tbl_hotel_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                int selected_row = tbl_hotel_list.getSelectedRow();
                fld_hotel_id_number.setText(tbl_hotel_list.getValueAt(selected_row, 0).toString());
            } catch (Exception exception) {

            }
        });


        // Rezervasyon sekmesindeki oda tablosundan seçim yapma
        tbl_book_room_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                int selected_row = tbl_book_room_list.getSelectedRow();
                fld_book_price_id.setText(tbl_book_room_list.getValueAt(selected_row, 0).toString());
                String selected_room = tbl_book_room_list.getValueAt(selected_row, 1).toString();
                fld_book_room_id.setText(String.valueOf(selected_room));

            } catch (Exception exception) {

            }
        });

        // Otel sekmesindeki yeni otel ekleme
        btn_hotel_add.addActionListener(e -> {

            if (Helper.isFieldEmpty(fld_hotel_name) || Helper.isFieldEmpty(fld_hotel_address) ||
                    Helper.isFieldEmpty(fld_hotel_city) || Helper.isFieldEmpty(fld_hotel_tel) ||
                    Helper.isFieldEmpty(fld_hotel_region) ||
                    Helper.isFieldEmpty(fld_hotel_email) || Helper.isFieldEmpty(fld_hotel_properties) ||
                    Helper.isFieldEmpty(fld_hotel_star)) {
                Helper.showMsg("fill");
            } else {
                boolean result = true;
                if (this.hotel == null) {
                    Hotel obj = new Hotel();
                    obj.setName(fld_hotel_name.getText());
                    obj.setAddress(fld_hotel_address.getText());
                    obj.setCity(fld_hotel_city.getText());
                    obj.setRegion(fld_hotel_region.getText());
                    obj.setPhone(fld_hotel_tel.getText());
                    obj.setEmail(fld_hotel_email.getText());
                    obj.setProperty(fld_hotel_properties.getText());
                    obj.setStar(fld_hotel_star.getText());
                    result = Hotel.add(obj);
                }
                if (result) {
                    Helper.showMsg("done");
                    loadHotelModel();
                    fld_hotel_name.setText(null);
                    fld_hotel_address.setText(null);
                    fld_hotel_city.setText(null);
                    fld_hotel_region.setText(null);
                    fld_hotel_tel.setText(null);
                    fld_hotel_email.setText(null);
                    fld_hotel_properties.setText(null);
                    fld_hotel_star.setText(null);
                    loadRoomHotelTable();
                } else {
                    Helper.showMsg("error");
                }
            }

        });


        // Otel sekmesindeki otel silme
        fld_hotel_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_hotel_id_number)) {
                Helper.showMsg("Lütfen silmek istediğiniz oteli tablodan seçiniz.");
            } else {
                int hotel_id = Integer.parseInt(fld_hotel_id_number.getText());
                if (Hotel.delete(hotel_id)) {
                    Helper.showMsg("done");
                    loadHotelModel();
                    fld_hotel_id_number.setText(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });


        // Otel sekmesindeki otel silme
        fld_hotel_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_hotel_id_number)) {
                Helper.showMsg("Lütfen silmek istediğiniz oteli tablodan seçiniz.");
            } else {
                int hotel_id = Integer.parseInt(fld_hotel_id_number.getText());
                if (Hotel.delete(hotel_id)) {
                    Helper.showMsg("done");
                    loadHotelModel();
                    fld_hotel_id_number.setText(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });


        // Oda sekmesindeki otel arama
        btn_room_hotel_search.addActionListener(e -> {

            String name = fld_room_hotel_name.getText();
            String city = fld_room_hotel_city.getText();
            String star = fld_room_hotel_star.getText();
            String query = Hotel.searchQuery(name, city, star);

            loadRoomHotelTable(Hotel.searchHotels(query));

        });


        btn_room_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_room_id)) {
                Helper.showMsg("Lütfen silmek istediğiniz odayı tablodan seçiniz.");
            } else {
                int room_id = Integer.parseInt(fld_room_id.getText());
                if (Room.delete(room_id)) {
                    Helper.showMsg("done");
                    loadRoomModel();
                    fld_room_id.setText(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });

        // Rezervasyon sekmesindeki oda arama
        btn_book_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fld_book_hotel_name.getText();
                String city = fld_book_hotel_city.getText();
                String query = Pricing.searchQuery(name, city);

                loadReservationRoomModel_(Pricing.searchRooms(query));

            }
        });


        // Oda yönetimi sekmesindeki otel tablosundan seçim yapma
        tbl_room_hotel_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                int selected_row = tbl_room_hotel_list.getSelectedRow();
                fld_room_hotel_id.setText(tbl_room_hotel_list.getValueAt(selected_row, 0).toString());
            } catch (Exception exception) {

            }
        });


        // Oda yönetimi sekmesindeki oda tablosundan seçim yapma
        tbl_room_room_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                int selected_row = tbl_room_room_list.getSelectedRow();
                fld_room_id.setText(tbl_room_room_list.getValueAt(selected_row, 0).toString());
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        });


        // Otel sekmesindeki otel ekleme
        btn_hotel_season_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_hotel_id_number)) {
                Helper.showMsg("Lütfen sezon eklemek istediğiniz oteli tablodan seçiniz.");
            } else {
                int hotel_id = Integer.parseInt(fld_hotel_id_number.getText());
                Hotel hotel = Hotel.getByID(hotel_id);
                if (hotel != null) {
                    HotelPropertiesGUI hotelPropertiesGUI = new HotelPropertiesGUI(hotel);
                } else {
                    Helper.showMsg("error");
                }
            }
        });


        // Otel sekmesindeki otel güncelleme
        fld_hotel_update.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_hotel_id_number)) {
                Helper.showMsg("Lütfen güncellemek istediğiniz oteli tablodan seçiniz.");
            } else {
                int hotel_id = Integer.parseInt(fld_hotel_id_number.getText());
                Hotel hotel = Hotel.getByID(hotel_id);
                if (hotel != null) {
                    UpdateHotelGUI hotelUpdate = new UpdateHotelGUI(hotel, true);
                } else {
                    Helper.showMsg("error");
                }
            }
        });


        // Otel sekmesindeki otel bilgilerini görüntüleme
        fld_hotel_details.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_hotel_id_number)) {
                Helper.showMsg("Lütfen detaylarını görmek istediğiniz oteli tablodan seçiniz.");
            } else {
                int hotel_id = Integer.parseInt(fld_hotel_id_number.getText());
                Hotel hotel = Hotel.getByID(hotel_id);
                if (hotel != null) {
                    UpdateHotelGUI display = new UpdateHotelGUI(hotel, false);
                } else {
                    Helper.showMsg("error");
                }
            }
        });


        // Oda yönetimi sekmesindeki oda güncelleme
        btn_room_update.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_room_id)) {
                Helper.showMsg("Lütfen güncellemek istediğiniz odayı tablodan seçiniz.");
            } else {
                int room_id = Integer.parseInt(fld_room_id.getText());
                Room room = Room.getByID(room_id);
                if (room != null) {
                    UpdateRoomGUI updateRoomGUI = new UpdateRoomGUI(room, true, false);
                } else {
                    Helper.showMsg("error");
                }
            }
        });



        // Oda yönetimi sekmesindeki oda görüntüleme
        btn_room_details.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_room_id)) {
                Helper.showMsg("Lütfen odayı tablodan seçiniz.");
            } else {
                int room_id = Integer.parseInt(fld_room_id.getText());
                Room room = Room.getByID(room_id);
                if (room != null) {
                    UpdateRoomGUI updateRoomGUI = new UpdateRoomGUI(room, false, true);
                } else {
                    Helper.showMsg("error");
                }
            }
        });




        btn_room_table_refresh.addActionListener(e -> {
            loadRoomHotelTable();
            loadRoomModel();
            loadReservationRoomModel();
            fld_room_id.setText(null);
            fld_room_hotel_id.setText(null);
            fld_book_price_id.setText(null);
            fld_book_room_id.setText(null);

        });

        btn_book_refresh.addActionListener(e -> {
            loadRoomModel();
            loadReservationRoomModel();
            loadReservationTable();

        });

        btn_room_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_room_hotel_id)) {
                Helper.showMsg("Lütfen oda eklemek istediğiniz oteli tablodan seçiniz.");
            } else {
                int hotel_id = Integer.parseInt(fld_room_hotel_id.getText());
                Hotel hotel = Hotel.getByID(hotel_id);
                Room room = null;
                Hotel hotelObject = Hotel.getByID(Integer.parseInt(fld_room_hotel_id.getText()));
                UpdateRoomGUI updateRoomGUI = new UpdateRoomGUI(hotelObject, false, false);
            }
        });

        // Rezervasyon ekleme
        btn_book_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_book_price_id)) {
                Helper.showMsg("Lütfen rezervasyon eklemek istediğiniz odayı tablodan seçiniz.");
            } else {
                int price_id = Integer.parseInt(fld_book_price_id.getText());
                Pricing pricing = Pricing.getByID(price_id);
                Reservation reservation = null;

                ReservationGUI reservationGUI = new ReservationGUI(pricing, reservation,
                        false, false);
            }
        });

        // Konaklama ücreti ekleme
        btn_room_add_price.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_room_id)) {
                Helper.showMsg("Lütfen fiyat eklemek istediğiniz odayı tablodan seçiniz.");
            } else {
                int room_id = Integer.parseInt(fld_room_id.getText());
                Room room = Room.getByID(room_id);
                if (room != null) {
                    RoomPricingGUI pricingGUI = new RoomPricingGUI(room);
                } else {
                    Helper.showMsg("error");
                }
            }
        });
    }

    // Rezervasyon tablosu
    public void loadReservationTable() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_book_list.getModel();
        clearModel.setRowCount(0);

        for (Reservation obj : Reservation.getList()) {
            int i = 0;

            row_reservation_list[i++] = obj.getRes_id();
            Room reservationRoom = Room.getByID(obj.getRes_room_id());
            Hotel reservationHotel = Hotel.getByID(reservationRoom.getRoom_hotel_id());
            row_reservation_list[i++] = reservationHotel.getName();
            row_reservation_list[i++] = obj.getRes_customer_name();
            row_reservation_list[i++] = obj.getRes_checkin();
            row_reservation_list[i++] = obj.getRes_checkout();
            row_reservation_list[i++] = reservationRoom.getRoom_name();
            mdl_reservation_list.addRow(row_reservation_list);

        }
    }

    // Otel sekmesi otel listeleme
    public void loadHotelModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_hotel_list.getModel();
        clearModel.setRowCount(0);

        for (Hotel obj : Hotel.getList()) {
            int i = 0;
            row_hotel_list[i++] = obj.getHotel_id();
            row_hotel_list[i++] = obj.getName();
            row_hotel_list[i++] = obj.getCity();
            row_hotel_list[i++] = obj.getStar();
            mdl_hotel_list.addRow(row_hotel_list);
        }
    }

    // Otel sekmesi otel arama işlemi sonrasında yüklenecek olan tablo
    public void loadHotelModel(ArrayList<Hotel> list) {
        DefaultTableModel resetModel = (DefaultTableModel) tbl_hotel_list.getModel();
        resetModel.setRowCount(0);

        for (Hotel obj : list) {
            int i = 0;
            row_hotel_list[i++] = obj.getHotel_id();
            row_hotel_list[i++] = obj.getName();
            row_hotel_list[i++] = obj.getCity();
            row_hotel_list[i++] = obj.getStar();
            mdl_hotel_list.addRow(row_hotel_list);
        }
    }

    // Oda yönetimi sekmesi otel listesi
    public void loadRoomHotelTable() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_room_hotel_list.getModel();
        clearModel.setRowCount(0);
        for (Hotel obj : Hotel.getList()) {
            int i = 0;
            row_room_hotel_list[i++] = obj.getHotel_id();
            row_room_hotel_list[i++] = obj.getName();
            row_room_hotel_list[i++] = obj.getCity();
            row_room_hotel_list[i++] = obj.getRegion();
            row_room_hotel_list[i++] = obj.getPhone();
            row_room_hotel_list[i++] = obj.getStar();
            mdl_room_hotel_list.addRow(row_room_hotel_list);
        }
    }

    // Oda yönetimi sekmesi otel arama işlemi sonrasında yüklenecek olan tablo
    public void loadRoomHotelTable(ArrayList<Hotel> list) {
        DefaultTableModel resetModel = (DefaultTableModel) tbl_room_hotel_list.getModel();
        resetModel.setRowCount(0);
        for (Hotel obj : list) {
            int i = 0;
            row_room_hotel_list[i++] = obj.getHotel_id();
            row_room_hotel_list[i++] = obj.getName();
            row_room_hotel_list[i++] = obj.getCity();
            row_room_hotel_list[i++] = obj.getRegion();
            row_room_hotel_list[i++] = obj.getPhone();
            row_room_hotel_list[i++] = obj.getStar();
            mdl_room_hotel_list.addRow(row_room_hotel_list);
        }
    }

    // Oda sekmesindeki oda tablolarının oluşturulması
    public void loadRoomModel(ArrayList <Room> list) {
        DefaultTableModel resetModel = (DefaultTableModel) tbl_room_room_list.getModel();
        resetModel.setRowCount(0);

        for (Room obj : list) {
            int i = 0;

            row_room_list[i++] = obj.getRoom_id();
            row_room_list[i++] = obj.getRoom_hotel_id();
            row_room_list[i++] = obj.getRoom_name();
            row_room_list[i++] = obj.getRoom_stock();
            row_room_list[i++] = obj.getRoom_capacity();
            mdl_room_list.addRow(row_room_list);
        }
    }

    public void loadRoomModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_room_room_list.getModel();
        clearModel.setRowCount(0);
        for (Room obj : Room.getList()) {
            int i = 0;
            row_room_list[i++] = obj.getRoom_id();
            row_room_list[i++] = obj.getRoom_hotel_id();
            row_room_list[i++] = obj.getRoom_name();
            row_room_list[i++] = obj.getRoom_stock();
            row_room_list[i++] = obj.getRoom_capacity();
            mdl_room_list.addRow(row_room_list);
        }

    }

    // Rezervasyon sekmesi oda tablosu
    public void loadReservationRoomModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_book_room_list.getModel();
        clearModel.setRowCount(0);
        for (Pricing obj : Pricing.getList()) {
            int i = 0;

            row_book_room_list[i++] = obj.getPricing_id();
            row_book_room_list[i++] = obj.getPricing_room_id();
            Room roomForList = Room.getByID(obj.getPricing_room_id());
            int hotelID = roomForList.getRoom_hotel_id();
            Hotel hotelForList = Hotel.getByID(hotelID);
            row_book_room_list[i++] = hotelForList.getName();
            row_book_room_list[i++] = hotelForList.getCity();
            row_book_room_list[i++] = roomForList.getRoom_name();
            row_book_room_list[i++] = roomForList.getRoom_stock();
            row_book_room_list[i++] = obj.getRoom().getRoom_capacity();
            row_book_room_list[i++] = obj.getPricing_season_name();
            String seasonName = obj.getPricing_season_name();
            if (seasonName.equals("Yaz Dönemi")) {
                row_book_room_list[i++] = "01/06/2024";
                row_book_room_list[i++] = "31/08/2024";
            } else if (seasonName.equals("Kış Dönemi")) {
                row_book_room_list[i++] = "01/12/2023";
                row_book_room_list[i++] = "28/02/2024";
            } else if (seasonName.equals("İlkbahar Dönemi")) {
                row_book_room_list[i++] = "01/03/2024";
                row_book_room_list[i++] = "31/05/2024";
            } else if (seasonName.equals("Sonbahar Dönemi")) {
                row_book_room_list[i++] = "01/09/2024";
                row_book_room_list[i++] = "30/11/2024";
            }
            row_book_room_list[i++] = obj.getHostel_type();

            mdl_book_room_list.addRow(row_book_room_list);
        }
    }

    // Rezervasyon sekmesi oda tablosu arama işlemi onrasında yüklenecek olan tablo
    public void loadReservationRoomModel(ArrayList <Pricing> list) {

        DefaultTableModel clearModel = (DefaultTableModel) tbl_book_room_list.getModel();
        clearModel.setRowCount(0);
        for (Pricing obj : list) {
            int i = 0;

            row_book_room_list[i++] = obj.getPricing_id();
            row_book_room_list[i++] = obj.getPricing_room_id();
            Room roomForList = Room.getByID(obj.getPricing_room_id());
            int hotelID = roomForList.getRoom_hotel_id();
            Hotel hotelForList = Hotel.getByID(hotelID);
            row_book_room_list[i++] = hotelForList.getName();
            row_book_room_list[i++] = hotelForList.getCity();
            row_book_room_list[i++] = roomForList.getRoom_name();
            row_book_room_list[i++] = roomForList.getRoom_stock();
            row_book_room_list[i++] = obj.getRoom().getRoom_capacity();
            row_book_room_list[i++] = obj.getPricing_season_name();
            String seasonName = obj.getPricing_season_name();
            if (seasonName.equals("Yaz Dönemi")) {
                row_book_room_list[i++] = "01/06/2024";
                row_book_room_list[i++] = "31/08/2024";
            } else if (seasonName.equals("Kış Dönemi")) {
                row_book_room_list[i++] = "01/12/2023";
                row_book_room_list[i++] = "28/02/2024";
            } else if (seasonName.equals("İlkbahar Dönemi")) {
                row_book_room_list[i++] = "01/03/2024";
                row_book_room_list[i++] = "31/05/2024";
            } else if (seasonName.equals("Sonbahar Dönemi")) {
                row_book_room_list[i++] = "01/09/2024";
                row_book_room_list[i++] = "30/11/2024";
            }
            row_book_room_list[i++] = obj.getHostel_type();
            mdl_book_room_list.addRow(row_book_room_list);
        }
    }

    public void loadReservationRoomModel_(ArrayList<Pricing> list) {

        format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate winterStart = LocalDate.parse("01/12/2023", format);
        LocalDate winterEnd = LocalDate.parse("29/02/2024", format);

        LocalDate springStart = LocalDate.parse("01/03/2024", format);
        LocalDate springEnd = LocalDate.parse("31/05/2024", format);

        LocalDate summerStart = LocalDate.parse("01/06/2024", format);
        LocalDate summerEnd = LocalDate.parse("31/08/2024", format);

        LocalDate fallStart = LocalDate.parse("01/09/2024", format);
        LocalDate fallEnd = LocalDate.parse("30/11/2024", format);
        DefaultTableModel clearModel = (DefaultTableModel) tbl_book_room_list.getModel();
        clearModel.setRowCount(0);
        String season_Name = "";

        String checkinDate = fld_bookl_checkin.getText();
        String checkoutDate = fld_book_checkout.getText();
        try {
            LocalDate dateCheckin = LocalDate.parse(checkinDate, format);
            LocalDate dateCheckout = LocalDate.parse(checkoutDate, format);

            if (dateCheckin.isAfter(springStart) &&
                    dateCheckout.isBefore(springEnd)) {
                season_Name = "İlkbahar Dönemi";
                System.out.println(season_Name);
            } else if (dateCheckin.isAfter(summerStart) &&
                    dateCheckout.isBefore(summerEnd)) {
                season_Name = "Yaz Dönemi";
                System.out.println(season_Name);
            } else if (dateCheckin.isAfter(fallStart) &&
                    (dateCheckout.isBefore(fallEnd))) {
                season_Name = "Sonbahar Dönemi";
                System.out.println(season_Name);
            } else if (dateCheckin.isAfter(winterStart) &&
                    (dateCheckout).isBefore(winterEnd)) {
                season_Name = "Kış Dönemi";
                System.out.println(season_Name);
            } else {
                System.out.println("Hata");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Helper.showMsg("Lütfen tarihleri doğru formatta arayınız. " +
                    "Sezon tarih aralığı dışında bir tarih yazdınız." +
                    "Sezon tarih aralıkları Kış: 01/12/2023 - 28/02/2024");

        }
        for (Pricing obj : list) {
            if (season_Name.equals(obj.getPricing_season_name())) {
                int i = 0;
                row_book_room_list[i++] = obj.getPricing_id();
                row_book_room_list[i++] = obj.getPricing_room_id();
                Room roomForList = Room.getByID(obj.getPricing_room_id());
                int hotelID = roomForList.getRoom_hotel_id();
                Hotel hotelForList = Hotel.getByID(hotelID);
                row_book_room_list[i++] = hotelForList.getName();
                row_book_room_list[i++] = hotelForList.getCity();
                row_book_room_list[i++] = roomForList.getRoom_name();
                row_book_room_list[i++] = roomForList.getRoom_stock();
                row_book_room_list[i++] = obj.getRoom().getRoom_capacity();
                row_book_room_list[i++] = obj.getPricing_season_name();
                String seasonName = obj.getPricing_season_name();
                switch (seasonName) {
                    case "Yaz Dönemi" -> {
                        row_book_room_list[i++] = "01/06/2024";
                        row_book_room_list[i++] = "31/08/2024";
                    }
                    case "Kış Dönemi" -> {
                        row_book_room_list[i++] = "01/12/2023";
                        row_book_room_list[i++] = "28/02/2024";
                    }
                    case "İlkbahar Dönemi" -> {
                        row_book_room_list[i++] = "01/03/2024";
                        row_book_room_list[i++] = "31/05/2024";
                    }
                    case "Sonbahar Dönemi" -> {
                        row_book_room_list[i++] = "01/09/2024";
                        row_book_room_list[i++] = "30/11/2024";
                    }
                }
                row_book_room_list[i++] = obj.getHostel_type();
                mdl_book_room_list.addRow(row_book_room_list);

            }
        }
    }
}