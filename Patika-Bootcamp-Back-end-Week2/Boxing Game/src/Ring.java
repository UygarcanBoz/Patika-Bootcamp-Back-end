// Ring class represents a ring where two fighters engage in a match.
public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    // Constructor to initialize the Ring object with two fighters and weight limits.
    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    // Method to run the fight simulation in the ring.
    public void run() {
        // Check if the weights of the fighters match the weight limits.
        if (checkWeight()) {
            determineFirstAttacker();  // Determine the first attacker with a 50% probability.
            // Continue the fight until one of the fighters' health becomes zero.
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("======== NEW ROUND ===========");
                f1.health = f1.hit(f2);
                if (isWin()) {
                    break;
                }
                f2.health = f2.hit(f1);
                if (isWin()) {
                    break;
                }
                printScore();
            }
        } else {
            System.out.println("Fighters' weights do not match.");
        }
    }

    // Method to check if the weights of both fighters match the weight limits.
    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    // Method to determine the first attacker with a 50% probability.
    public void determineFirstAttacker() {
        double randomValue = Math.random();  // Random value between 0.0 to 0.999999...
        if (randomValue < 0.5) {
            System.out.println(f1.name + " will attack first!");
            // Swap the fighters if f1 is not the first attacker.
            Fighter temp = f1;
            f1 = f2;
            f2 = temp;
        } else {
            System.out.println(f2.name + " will attack first!");
        }
    }

    // Method to check if one of the fighters has won the match.
    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("The winner is: " + f2.name);
            return true;
        } else if (f2.health == 0) {
            System.out.println("The winner is: " + f1.name);
            return true;
        }
        return false;
    }

    // Method to print the current scores of both fighters.
    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Remaining Health \t:" + f1.health);
        System.out.println(f2.name + " Remaining Health \t:" + f2.health);
    }
}