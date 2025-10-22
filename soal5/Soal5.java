package soal5;

import java.util.*;

public class Soal5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input array
        System.out.print("Enter array (comma-separated): ");
        String input = sc.nextLine();

        // konversi ke array int
        String[] parts = input.split(",");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i].trim());
        }

        // input total moves
        System.out.print("Enter total moves: ");
        int moves = sc.nextInt();

        getDemolitionScore(numbers, moves);
        sc.close();
    }

    public static void getDemolitionScore(int[] array, int moves) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        // looping sebanyak moves
        for (int move = 1; move <= moves; move++) {
            // print current array
            System.out.println("\nCurrent array: " + Arrays.toString(array));

            // input index untuk dihancurkan
            System.out.print("Choose index to demolish (0 - " + (array.length - 1) + "): ");
            int idx = sc.nextInt();

            // inisialisasi value yang dihancurkan dan score sementara
            int val = array[idx];
            score += val;

            int leftSize = idx;
            int rightSize = array.length - idx - 1;

            int[] newArray;

            // tentukan part yang lebih besar (jika sama -> ambil kanan)
            if (rightSize > leftSize) {
                newArray = Arrays.copyOfRange(array, idx + 1, array.length);
            } else {
                newArray = Arrays.copyOfRange(array, 0, idx);
            }

            // weakening step
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = Math.max(0, newArray[i] - val);
            }

            array = newArray; // update array untuk ronde selanjutnya

            System.out.println("After demolish -> new array: " + Arrays.toString(array));
            System.out.println("Current score: " + score);

            if (array.length == 0) {
                System.out.println("\nAll buildings gone!");
                break;
            }
        }

        System.out.println("\nFinal score: " + score);
        sc.close();
    }
}
