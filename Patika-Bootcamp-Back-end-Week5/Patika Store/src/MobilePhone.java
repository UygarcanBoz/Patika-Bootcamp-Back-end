public class MobilePhone extends Product {
    private String color;
    private int batteryPower;

    public MobilePhone(int id, int price, double discountRate, int stockNum, String name,
                       String brand, int storage, double screenSize, int ram, String color, int batteryPower) {
        super(id, price, discountRate, stockNum, name, brand, storage, screenSize, ram);
        this.color = color;
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }
}
