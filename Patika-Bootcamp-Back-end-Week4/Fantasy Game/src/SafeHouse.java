public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {

        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in a safe house!");
        System.out.println("Your health has been restored!");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
