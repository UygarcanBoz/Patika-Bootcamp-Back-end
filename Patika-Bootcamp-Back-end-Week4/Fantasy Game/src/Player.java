import java.util.Scanner;

public class Player {
    private int damage, health, money;
    private String name, charName;
    private Inventory inventory;
    private int originalHealth;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        while (true) { // döngü ekledik, 1-2-3 dışında bir rakam girildiğinde tekrar rakam girilmesi isteniyor
                       // şimdi biz buna harf girildiğinde hata verip rakam girilmesini nasıl sağlarız?
        System.out.println("Characters");
        System.out.println("-------------------------------------------------");

        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() +
                    "\t Character: " + gameChar.getName() +
                    "\t Damage: " + gameChar.getDamage() +
                    "\t Health: " + gameChar.getHealth() +
                    "\t Money: " + gameChar.getMoney());
        }
        System.out.println("-------------------------------------------------");
        System.out.print("Enter the character ID: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Invalid Input, Please Choose Again");
                continue;
        }
        break;
        }
        System.out.println("Character: " + this.getCharName() + " , " +
                "Damage: " + this.getDamage() + " , " +
                "Health: " + this.getHealth() + " ," +
                "Money: " + this.getMoney() + " , ");

    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println(
                "Weapon: " + this.getInventory().getWeapon().getName() +
                        ", Armour: " + this.getInventory().getArmour().getName() +
                        ", Block: " + this.getInventory().getArmour().getBlock() +
                        ", Total Damage: " + this.getTotalDamage() +
                        ", Health: " + this.getHealth() +
                        ", Money: " + this.getMoney());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
