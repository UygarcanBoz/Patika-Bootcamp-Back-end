import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("You are now in: " + this.getName());
        System.out.println("Be careful! There are " + obsNumber + " " + this.getObstacle().getName() + "(s) here! ");
        System.out.println("<F>ight or <R>un ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F") && combat(obsNumber)) {
            if (combat(obsNumber)) {
                System.out.println("You defeated all the enemies in " + this.getName());
                return true;
            }

        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You died!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
        for (int i = 1; i < obsNumber; i++) {
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<A>ttack or <R>un");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("A")) {

                    double condition = Math.random() * 100;
                    if (condition > 50) {
                        System.out.println("You attacked ");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Enemy attacked ");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmour().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }

                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        } else {
                            return false;
                        }
                    } else {
                        System.out.println("Enemy attacked ");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmour().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();

                        if (this.getPlayer().getHealth() > 0) {
                            System.out.println();
                            System.out.println("You attacked ");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                    if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                        System.out.println("You defeated the enemy!");
                        if (getObstacle().getName().equals("Snake")) {
                            earnItem();
                        } else {
                            System.out.println("You earned " + this.getObstacle().getAward() + " coins");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                            System.out.println("Your current money: " + this.getPlayer().getMoney());

                        }

                    }

                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void afterHit() {
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "'s health: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Player Stats");
        System.out.println("--------------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Armour: " + this.getPlayer().getInventory().getArmour().getName());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmour().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());
    }

    public void obstacleStats(int i) {
        System.out.println(i + "." + this.getObstacle().getName() + " Stats");
        System.out.println("--------------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Reward: " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public void earnItem() {
        Random random = new Random();
        int randomItem = random.nextInt(1, 101);
        if (randomItem <= 15) {
            Random r1 = new Random();
            int randomItem1 = random.nextInt(1, 101);
            if (randomItem1 <= 20) {
                System.out.println("You earned a Rifle!");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
            } else if (randomItem1 > 20 && randomItem1 <= 50) {
                System.out.println("You earned a Sword!");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));

            } else {
                System.out.println("You earned a Pistol!");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
            }


        } else if (randomItem > 15 && randomItem <= 30) {
            Random r2 = new Random();
            int randomItem2 = random.nextInt(1, 101);
            if (randomItem2 <= 20) {
                System.out.println("You earned Heavy Armour");
                getPlayer().getInventory().setArmour(Armour.getArmourObjByID(3));
            } else if (randomItem2 > 20 && randomItem2 <= 50) {
                System.out.println("You earned Medium Armour");
                getPlayer().getInventory().setArmour(Armour.getArmourObjByID(2));

            } else {
                System.out.println("You earned Light Armour");
                getPlayer().getInventory().setArmour(Armour.getArmourObjByID(1));

            }
        } else if (randomItem > 30 && randomItem <= 55) {
            Random r2 = new Random();
            int randomItem2 = random.nextInt(1, 101);
            if (randomItem2 <= 20) {
                System.out.println("You earned 10 coins");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
            } else if (randomItem2 > 20 && randomItem2 <= 50) {
                System.out.println("You earned 5 coins");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
            } else {
                System.out.println("You earned 1 coin");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
            }
            System.out.println("Your current money: " + this.getPlayer().getMoney());
        } else
            System.out.println("You didn't win anything.");


    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
