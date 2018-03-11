package com.tuto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CapitalesGame {

    private static BufferedReader readerLine = new BufferedReader(new InputStreamReader(System.in));
    private static String userReponse = null;

    public static void main(String[] args) throws IOException {


        HashMap<String, String> listeDePays = initCountry();
        int nombreDeCapitale = listeDePays.size();
        int totalBonneReponse = 0;
        for (String pays : listeDePays.keySet()) {
            displayQuestion(pays);
            userReponse = readerLine.readLine();
            if (!userReponse.matches("[a-zA-Z]+$")) {
                System.out.println("Ce n'est pas une réponse valide, il faut une chaîne de caractère");
            } else if (userReponse.equalsIgnoreCase(listeDePays.get(pays))) {
                displayGoodAnswer();
                totalBonneReponse++;
            } else {
                displayWrongAnswer(listeDePays.get(pays));
            }
        }
        displayScore(totalBonneReponse, nombreDeCapitale);
    }

    private static void displayScore (int totalBonneReponse, int nombreDeCapitale) {
        System.out.printf("C'est terminé ! <<Score: %s/%s>>",totalBonneReponse,nombreDeCapitale);
    }


    private static void displayWrongAnswer (String capitale) {
        System.out.printf("Mauvaise reponse. Il fallait répondre %s \n" , capitale);
    }

    private static void displayGoodAnswer() {
        System.out.println("Bonne réponse ! ");
    }


    private static void displayQuestion(String pays) {
        System.out.printf("Quelle est la capitale de ce pays : %s ? \n", pays);
    }


    private static HashMap<String, String> initCountry() {
        HashMap<String, String> paysCapital = new HashMap<>();
        paysCapital.put("Allemagne", "Berlin");
        paysCapital.put("Libéria", "Monrovia");
        paysCapital.put("Perou", "Lima");
        paysCapital.put("Monaco", "Monaco");
        paysCapital.put("France", "Paris");
        paysCapital.put("Nigéria", "Abuja");
        paysCapital.put("Senegal", "Dakar");
        return paysCapital;
    }
}
