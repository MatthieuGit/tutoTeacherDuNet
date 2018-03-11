package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Challenge {


    private static int userNumber = 0;
    private static StringBuffer resultat = new StringBuffer();
    private static ArrayList<Integer> firstNumber = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        displayQuestion();
        userNumber = lireLeNombre();
        int modulo = 2;
        while (userNumber > 1) {
            if (userNumber % modulo == 0) {
                while (userNumber % modulo == 0) {
                    firstNumber.add(modulo);
                    userNumber = userNumber / modulo;
                }
            }
            modulo++;
        }

        System.out.println(firstNumber);
    }



    private static int lireLeNombre() throws IOException {
        BufferedReader readerLine = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(readerLine.readLine());
    }

    private static void displayQuestion() {
            System.out.println("Entrez le nombre :");
    }
}
