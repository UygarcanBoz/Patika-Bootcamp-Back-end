// Fighter class represents a fighter with attributes such as name, damage, health, weight, and dodge probability.
public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    double dodge;

    // Constructor to initialize the Fighter object with provided attributes.
    public Fighter(String name, int damage, int health, int weight, double dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
    }

    // Method to simulate a hit from this fighter to the opponent fighter.
    public int hit(Fighter opponent) {
        System.out.println("------------");
        System.out.println(this.name + " => " + opponent.name + " dealt " + this.damage + " damage.");

        // Check if opponent dodges the attack based on dodge probability.
        if (opponent.dodge()) {
            System.out.println(opponent.name + " dodged the incoming damage.");
            return opponent.health;
        }

        // Calculate the remaining health of the opponent after the attack.
        if (opponent.health - this.damage < 0)
            return 0;

        return opponent.health - this.damage;
    }

    // Method to simulate the dodge action of the fighter.
    public boolean dodge() {
        double randomValue = Math.random() * 100;  // Random value between 0.0 to 99.9
        return randomValue <= this.dodge;
    }
}