package com.tuto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		int tab1[] = new int[3];
		int tab2[] = new int[3];

		tab1[0] = 1;
		tab1[1] = 2;
		tab1[2] = 3;

		for (int i = 0; i < tab1.length; i++) {

			tab2[i] = tab1[i];
		}
		System.out.println(tab1[0]);
		System.out.println(tab1[1]);
		System.out.println(tab1[2]);
		System.out.println(tab2[0]);
		System.out.println(tab2[1]);
		System.out.println(tab2[2]);
	}
	}
