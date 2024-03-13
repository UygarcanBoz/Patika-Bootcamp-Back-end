public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------ Welcome to the Store! ------");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Weapons");
            System.out.println("2- Armours");
            System.out.println("3- Exit");
            System.out.print("Your choice: ");

            int selectCase = input.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Invalid value. Please enter again: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmour();
                    buyArmour();
                    break;
                case 3:
                    System.out.println("See you again!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("------ Weapons ------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + " <Price: " + w.getPrice() + ", Damage: " + w.getDamage() + ">");
        }
        System.out.println("0 - Exit");
    }

    public void buyWeapon() {
        System.out.println("Choose a weapon: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid value. Please enter again: ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("You purchased the " + selectedWeapon.getName() + " weapon.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your remaining money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmour() {
        System.out.println("------ Armours ------");
        for (Armour a : Armour.armours()) {
            System.out.println(a.getId() + "-" + a.getName() + " <Price: " + a.getPrice() + ", Armour: " + a.getBlock() + ">");
        }
        System.out.println("0 - Exit");
    }

    public void buyArmour() {
        System.out.println("Choose an armour: ");

        int selectArmourID = input.nextInt();
        while (selectArmourID < 0 || selectArmourID > Armour.armours().length) {
            System.out.println("Invalid value. Please enter again: ");
            selectArmourID = input.nextInt();
        }

        if (selectArmourID != 0) {
            Armour selectedArmour = Armour.getArmourObjByID(selectArmourID);

            if (selectedArmour != null) {
                if (selectedArmour.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("You purchased the " + selectedArmour.getName() + " armour.");
                    int balance = this.getPlayer().getMoney() - selectedArmour.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your remaining money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmour(selectedArmour);
                }
            }
        }
    }
}
