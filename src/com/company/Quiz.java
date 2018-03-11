package com.company;

import java.io.IOException;

/**
 * Classe abstraire Quiz. Définit les methodes start et displayResults.
 */
public abstract class Quiz {


    /**
     * Constructeur par défaut.
     */
    public Quiz() {

    }

    /**
     * Permet de démarrer le jeu.
     * @exception IOException exception lros de la lecture du fichier texte.
     */
    abstract void start() throws IOException;

    /**
     * Permet d'afficher les resultats du quiz.
     */
    abstract void displayResults();

    /**
     * Affiche une question de manière aléatoire.
     * @param question le sujet de la question.
     */
    abstract void displayQuestion(String question);

    /**
     * Affiche un message informant l'utilisateur d'une bonne réponse.
     */
    abstract void displayGoodAnswer();

    /**
     * Affiche un message informant l'utilisateur d'une mauvaise réponse.
     * @param resultat le nombre de bonnes réponses.
     */
    abstract void displayWrongAnswer(int  resultat);
}
