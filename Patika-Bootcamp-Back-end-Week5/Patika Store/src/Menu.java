public abstract class Menu {

    private String name;

    public Menu(String name) {
        this.name = name;
    }
    public abstract boolean onMenu();
}
