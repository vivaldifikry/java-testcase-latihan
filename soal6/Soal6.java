package soal6;

import java.util.Scanner;

public class Soal6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input Size Array Quantity: ");
        int size = sc.nextInt();

        int[] arrays = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Input Array Value " + (i + 1) + " : ");
            arrays[i] = sc.nextInt();
        }

        System.out.print("\nInput Target Sold: ");
        int target = sc.nextInt();

        System.out.print("\nTotal Minimum Penalty: " + getMinimumPenalty(arrays, target));

        sc.close();
    }

    public static Integer getMinimumPenalty(int[] arrays, int target) {
        int totalPenalty = 0;

        // looping sebanyak terget penjualan
        for (int j = 0; j < target; j++) {

            // cek value terkecil array
            int min = arrays[0];
            int minIndex = 0;

            for (int i = 1; i < arrays.length; i++) {
                if ((arrays[i] > 0) && (arrays[i] < min)) {
                    min = arrays[i]; // update jika ditemukan nilai lebih kecil
                    minIndex = i;
                }
            }

            // Tambahkan nilai terkecil ke totalPenalty
            totalPenalty += min;
            // System.out.println("current penalty: " + totalPenalty);

            // Kurangi nilai terkecil sebanyak 1 (tapi tidak boleh negatif)
            if (arrays[minIndex] > 0) {
                arrays[minIndex] -= 1;
            }
        }

        return totalPenalty;
    }
}
