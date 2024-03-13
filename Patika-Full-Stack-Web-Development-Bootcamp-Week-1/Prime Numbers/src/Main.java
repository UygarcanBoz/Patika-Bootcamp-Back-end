public class Main {
    public static void main(String[] args) {
        System.out.println("Prime numbers between 1 and 100:");

        // Loop through numbers from 2 to 100
        for (int i = 2; i <= 100; i++) {
            // Check if the current number is prime
            boolean isPrime = true;

            if (i > 1) {
                // Check for factors from 2 to the square root of the number
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false; // If divisible by any number, it's not prime
                        break;
                    }
                }
            } else {
                isPrime = false; // 1 is not a prime number
            }

            // Print the prime number
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
}