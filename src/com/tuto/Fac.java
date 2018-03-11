package com.tuto;

import java.util.ArrayList;
import java.util.Scanner;

public class Fac {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("entrez val");
        int n = clavier.nextInt();
        int i = 2;
        ArrayList<Integer> tab = new ArrayList<>();
        while (n > 1) {
            if (n % i == 0 && i <= n) {
                while (n % i == 0) {
                    tab.add(i);
                    n = n / i;
                }
            }
            i++;
        }
        System.out.println(tab);
    }



}