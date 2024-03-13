package Helper;

// Item sınıfı, bir anahtar (key) ve değer (value) çiftini temsil eder.

public class Item {

    private int key;
    private String value;

    // Parametreli kurucu metod, bir Item nesnesi oluşturur.
    public Item(int key, String value) {
        this.key = key;
        this.value = value;
    }

    // Anahtarın getter metodu
    public int getKey() {
        return key;
    }

    // Anahtarın setter metodu
    public void setKey(int key) {
        this.key = key;
    }

    // Değerin getter metodu
    public String getValue() {
        return value;
    }

    // Değerin setter metodu
    public void setValue(String value) {
        this.value = value;
    }

    // Nesneyi string olarak temsil eden metot (toString override)
    @Override
    public String toString() {
        return this.value;
    }
}
