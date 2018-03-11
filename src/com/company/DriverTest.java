package com.company;

import java.io.IOException;

/**
 * Classe permettant d'executer le quiz.
 */
public class DriverTest {

    /**
     * methode main.
     * @param args dargs.
     */
    public static void main(final String[] args) throws IOException {

        Quiz quiz = new ConsoleQuiz(new CapitalCityQuestionsGenerator(10));
        quiz.start();
        quiz.displayResults();


    }
}
