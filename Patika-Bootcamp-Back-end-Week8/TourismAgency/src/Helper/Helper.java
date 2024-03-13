package Helper;

import javax.swing.*;
import java.awt.*;

// Helper sınıfı, genel yardımcı metodları içerir.

public class Helper {

    // Uygulama için görünüm (look and feel) ayarını yapar
    public static void setLayout() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    // OptionPane üzerindeki düğme metinlerini Türkçe'ye çevirir
    public static void optionPaneTR() {
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }

    // JTextField'ın dolu olup olmadığını kontrol eder
    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    // JTextArea'nın dolu olup olmadığını kontrol eder
    public static boolean isAreaEmpty(JTextArea area) {
        return area.getText().trim().isEmpty();
    }

    // Genel bir bilgilendirme mesajı gösterir
    public static void showMsg(String text) {
        optionPaneTR();
        String message;
        String title = "Mesaj";

        switch (text) {
            case "fill":
                message = "Lütfen tüm alanları doldurunuz.";
                title = "Hata!";
                break;

            case "done":
                message = "İşlem başarılı.";
                title = "Sonuç";
                break;

            case "error":
                message = "Bir hata oluştu";
                title = "Hata!";
                break;

            default:
                message = text;
                title = "Mesaj";
                break;
        }
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Verilen boyutu ekranın ortasına yerleştirir
    public static int center(String axis, Dimension size) {
        int point = 0;
        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
                break;
        }
        return point;
    }

    // Onay mesajı gösterir ve kullanıcının onay verip vermediğini döndürür
    public static boolean confirm(String text) {
        optionPaneTR();
        String message;
        switch (text) {
            case "sure":
                message = "Bu işlemi gerçekleştirmek istediğinizden emin misiniz?";
                break;
            default:
                message = text;
                break;
        }
        int result = JOptionPane.showConfirmDialog(null, message, "Onay", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }
}
