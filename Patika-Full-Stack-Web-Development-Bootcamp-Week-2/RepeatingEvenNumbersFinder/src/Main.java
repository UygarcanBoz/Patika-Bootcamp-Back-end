import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan sayı dizisi uzunluğunu al
        System.out.print("Dizi uzunluğunu girin: ");
        int length = scanner.nextInt();

        // Kullanıcıdan sayıları içeren diziyi oluştur
        int[] numbers = new int[length];
        System.out.println("Sayıları girin:");

        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Tekrar eden çift sayıları bul
        System.out.println("Tekrar eden çift sayılar:");

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] == numbers[j] && numbers[i] % 2 == 0) {
                    System.out.println(numbers[i]);
                    break;
                }
            }
        }
    }
}
