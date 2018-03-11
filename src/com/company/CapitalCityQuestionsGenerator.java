package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static com.company.TransformeCSV.getCapitaleEtVille;

/**
 * Implémentation de l'interface QuestionsGenerator concernant les villes et capitales.
 */
public class CapitalCityQuestionsGenerator extends ConsoleQuiz implements QuestionsGenerator {

    /**
     * Le nombre de questions souhaitées pour le quiz.
     */
    private final int nombreDeQuestionQuiz;

    /**
     * Récupére la réponse de l'utilisateur.
     */
    private static String userReponse = null;

    /**
     * Permet de donner la main à l'utilisateur pour écrire une réponse.
     */
    private static BufferedReader readerLine =
            new BufferedReader(new InputStreamReader(System.in));
    /**
     * Constructeur de la classe interne.
     * @param nombreDeQuestionJoueur le nombre de question pour le quiz.
     */
    CapitalCityQuestionsGenerator(final int nombreDeQuestionJoueur) {
        nombreDeQuestionQuiz = nombreDeQuestionJoueur;
    }

    @Override
    public static void displayQuestion(final String pays) {
        System.out.printf("Quelle est la capitale de ce pays : %s ? \n", pays);
    }

    @Override
    public void displayGoodAnswer() {

    }

    @Override
    public void readUserAnswer() throws IOException {
        userReponse = readerLine.readLine();
    }

    @Override
    public void displayWrongAnswer() {

    }

    @Override
    public void timeElasped() {

    }

    @Override
    void start() throws IOException {

        HashMap<String, String> listeDeCapitaleEtDePays = initCountry(nombreDeQuestionQuiz);
        for (Map.Entry<String, String> mapCapitaleVille : listeDeCapitaleEtDePays.entrySet()) {
            String pays = mapCapitaleVille.getKey();
            displayQuestion(pays);
            long startTime = System.currentTimeMillis();
            String bonneReponse = mapCapitaleVille.getValue();

            long endTime = System.currentTimeMillis();
            tempsEcoulerEntreDebutEtFin = tempsEcoulerEntreDebutEtFin +
                    ((endTime - startTime)/ TEMPS_SECONDE_DANS_MILLE_MILLISECONDE);
            if (userReponse.equalsIgnoreCase(bonneReponse)) {
                displayGoodAnswer();
                totalBonneReponse++;
            } else {
                displayWrongAnswer(bonneReponse);
            }
        }

    }

    /**
     * Retourne une hashmap de {Pays,Capital}. Dont la taille est choisie par l'utilisateur.
     * @param nombreDeQuestionChoisitParUtilisateur entier .
     * @return paysCapital
     */
    private static HashMap<String, String> initCountry(final int nombreDeQuestionChoisitParUtilisateur) {

        HashMap<String, String> paysCapital = new HashMap<>();
        getCapitaleEtVille();
        int compteur = 0;
        for (Map.Entry<String, String> mapCapitaleVille : getCapitaleEtVille().entrySet()) {
            while (nombreDeQuestionChoisitParUtilisateur >= compteur) {
                String capitale = mapCapitaleVille.getKey();
                String ville = mapCapitaleVille.getValue();
                paysCapital.put(ville, capitale);
                compteur++;
                break;
            }
            if (compteur >= nombreDeQuestionChoisitParUtilisateur) {
                break;
            }
        }

        return paysCapital;
    }
}
