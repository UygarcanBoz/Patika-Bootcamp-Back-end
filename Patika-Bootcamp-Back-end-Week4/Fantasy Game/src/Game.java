import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.print("Please enter a name: ");
        String playerName = input.nextLine();
        player = new Player(playerName);
        System.out.println("Dear " + player.getName() + ", welcome to this dark and misty island! Everything happening here is real!");
        System.out.print("Please choose a character: ");
        System.out.println("-------------------------------------------------");

        player.selectChar();

        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("-----------Locations-----------");
            System.out.println();
            System.out.println("1- Safe House --> This is a safe place for you, no enemies here.");
            System.out.println("2- Tool Store --> You can buy weapons or armor here.");
            System.out.println("3- Cave --> Reward <Food>, be careful, a zombie may appear.");
            System.out.println("4- Forest --> Reward <Firewood>, be careful, a vampire may appear.");
            System.out.println("5- River --> Reward <Water>, be careful, a bear may appear.");
            System.out.println("6- Mine --> Reward <Money, weapon, or armor>, be careful, a snake may appear.");
            System.out.println("0- Exit");
            System.out.print("Please choose the area you want to go to: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Please enter a valid area: ");
            }

            if (location == null) {
                System.out.println("The game is over, see you!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
