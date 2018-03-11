package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.TransformeCSV.getCapitaleEtVille;

/**
 * Classe permettant de lancer le Quiz en version console.
 */
public class ConsoleQuiz extends Quiz {


    /**
     * Message informant l'utilisateur d'entrer une donnée valide.
     */
    public static final String
            REPONSE_INVALIDE_CHAINE_DE_CARACTERE_ATTENDU =
            "Ce n'est pas une réponse valide, "
                    + "il faut une chaîne de caractère";
    /**
     * 1 seconde reprensente 1000 millisecondes.
     */
    private static final int TEMPS_SECONDE_DANS_MILLE_MILLISECONDE = 1000;

    /**
     * nombre aléatoire.
     */
    public static final int MULTIPLICATEUR_POUR_NOMBRE_ALEATOIRE = 1000;

    /**
     * Temps permettant d'afficher le nombre de
     * seconde qu'a mis l'utilisateur pour réaliser le quiz.
     */
    private static long tempsEcoulerEntreDebutEtFin = 0L;
    /**
     * attribut nombre de question quiz.
     */
    private static int nombreDeQuestionQuiz;

    /**
     * Total de bonne réponse de l'utilisateur.
     */
    private static int totalBonneReponse = 0;

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
     * Constructeur avec classe interne CapitalCityQuestionsGenerator.
     * @param pCapitalCityQuestionsGenerator Question.
     */
    public ConsoleQuiz(final CapitalCityQuestionsGenerator pCapitalCityQuestionsGenerator) {
        new CapitalCityQuestionsGenerator(nombreDeQuestionQuiz);
    }

//    /**
//     * Constructeur avec classe interne MathematiqueQuestionsGenerator.
//     * @param pMathQuestionsGenerator Question.
//     */
//    public ConsoleQuiz(final MathematiqueQuestionsGenerator pMathQuestionsGenerator) {
//        new MathematiqueQuestionsGenerator(nombreDeQuestionQuiz);
//    }

    public void displayResults() {
        System.out.printf("C'est terminé ! <<Score: %s/%s>>",
                totalBonneReponse, nombreDeQuestionQuiz);
        System.out.println();
        System.out.printf("Il vous a fallu %s", tempsEcoulerEntreDebutEtFin + " secondes pour réaliser le quizz");

    }

    @Override
    void displayQuestion(final String pays) {
        System.out.printf("Quelle est la capitale de ce pays : %s ? \n", pays);
    }

    @Override
    void displayGoodAnswer() {
        System.out.println("Bonne réponse ! ");
    }

    @Override
    void displayWrongAnswer(final int resultat) {
        System.out.printf("Mauvaise reponse. Il fallait répondre %s \n", resultat);
    }


    /**
     * Constructeur par défaut.
     */
    public ConsoleQuiz() {
        super();
    }

    @Override
    void start() throws IOException {

        HashMap<String, String> listeDeCapitaleEtDePays = CapitalCityQuestionsGenerator.initCountry(nombreDeQuestionQuiz);
        for (Map.Entry<String, String> mapCapitaleVille : listeDeCapitaleEtDePays.entrySet()) {
            String pays = mapCapitaleVille.getKey();
            displayQuestion(pays);
            long startTime = System.currentTimeMillis();
            String bonneReponse = mapCapitaleVille.getValue();
            userReponse = readerLine.readLine();
            long endTime = System.currentTimeMillis();
            tempsEcoulerEntreDebutEtFin = tempsEcoulerEntreDebutEtFin
                    + ((endTime - startTime)/ TEMPS_SECONDE_DANS_MILLE_MILLISECONDE);
            if (userReponse.equalsIgnoreCase(bonneReponse)) {
                displayGoodAnswer();
                totalBonneReponse++;
            } else {
                displayWrongAnswer(totalBonneReponse);
            }
        }
    }

    /**
     * @return le nombre de question pour le Quiz.
     */
    public int getNombreDeQuestionQuiz() {
        return nombreDeQuestionQuiz;
    }

    /**
     * Définit le nombre de question pour le Quiz.
     * @param nombreDeQuestionJoueur le nombre de question pour le quiz.
     */
    public void setNombreDeQuestionQuiz(final int nombreDeQuestionJoueur) {
        this.nombreDeQuestionQuiz = nombreDeQuestionJoueur;
    }



//    /**
//     * Classe Interne pour le quizz mathématique de la version console du Quizz.
//     */
//    static class MathematiqueQuestionsGenerator extends ConsoleQuiz{
//
//
//        /**
//         * Constructeur de la classe interne.
//         * @param nombreDeQuestionJoueur le nombre de question pour le quiz.
//         */
//        MathematiqueQuestionsGenerator(final int nombreDeQuestionJoueur) {
//            nombreDeQuestionQuiz = nombreDeQuestionJoueur;
//        }
//
//
//        @Override
//        void start() throws IOException {
//            afficherQuestion();
//        }
//
//        /**
//         * Permet d'afficher une question
//         * @throws IOException
//         */
//        private void afficherQuestion() throws IOException {
//            int bonneReponse = 0;
//            for (int i = 0; i < nombreDeQuestionQuiz; i++){
//                int premierNombre = genererChiffreAleatoire();
//                String operande = genererOperationAleatoire();
//                int secondNombre = genererChiffreAleatoire();
//                System.out.println(premierNombre + operande +
//                        secondNombre +" = ");
//                long startTime = System.currentTimeMillis();
//                if (operande.equalsIgnoreCase("+")){
//                     bonneReponse = premierNombre + secondNombre;
//                } else if (operande.equalsIgnoreCase("-")){
//                     bonneReponse = premierNombre - secondNombre;
//                } else if (operande.equalsIgnoreCase("*")){
//                     bonneReponse = premierNombre * secondNombre;
//                }
//                userReponse = readerLine.readLine();
//                long endTime = System.currentTimeMillis();
//                tempsEcoulerEntreDebutEtFin = tempsEcoulerEntreDebutEtFin +
//                        ((endTime - startTime)/ TEMPS_SECONDE_DANS_MILLE_MILLISECONDE);
//                if (userReponse.equalsIgnoreCase(String.valueOf((bonneReponse)))){
//                    displayGoodAnswer();
//                    totalBonneReponse++;
//                } else{
//                    displayWrongAnswer(bonneReponse);
//                }
//            }
//        }
//
//        /**
//         * genere un chiffre aléatoire
//         * @return
//         */
//        private int genererChiffreAleatoire() {
//           int chiffreAleatoire = ThreadLocalRandom.current().nextInt(1, 20 + 1);
//           return chiffreAleatoire;
//        }
//
//        /**
//         * genere un signe aléatoire
//         * @return
//         */
//        private String genererOperationAleatoire(){
//            HashMap<Integer, String> mapSigneOperation = new HashMap<>();
//            mapSigneOperation.put(1,"+");
//            mapSigneOperation.put(2,"-");
//            //mapSigneOperation.put(3,"/");
//            mapSigneOperation.put(3,"*");
//            //genere un chiffre entre 1 et 4
//            int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
//            return mapSigneOperation.get(randomNum);
//
//        }
//
//
//    }



}
