package soal9;

import java.util.Scanner;

public class Soal9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Alice initial money: ");
        Double alicaInitial = sc.nextDouble();

        System.out.print("Bob bonus money: ");
        Double bobInitial = sc.nextDouble();

        System.out.print("Alice rate per year: ");
        Double aliceRate = sc.nextDouble();

        System.out.print("Bob rate per year: ");
        Double bobRate = sc.nextDouble();
        sc.close();

        System.out.println(minYearsToSurpass(alicaInitial, bobInitial, aliceRate, bobRate));
    }

    private static Integer minYearsToSurpass(Double aInitial, Double bInitial, Double aRate, Double bRate) {
        if (aRate >= bRate)
            return -1; // Bob tidak akan bisa melebihi tabungan Alice

        // Bunga bank
        Double interestA = 0.0;
        Double interestB = 0.0;
        int years = 0;

        do {
            interestA = aInitial * aRate; // bunga bank
            aInitial = aInitial + interestA; // tabungan + bunga bank
            interestB = bInitial * bRate;
            bInitial = bInitial + interestB;

            years += 1;
        } while (aInitial > bInitial);

        return years;
    }
}
