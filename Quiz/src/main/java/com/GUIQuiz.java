package main.java.com;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GUIQuiz extends Quiz {

    private CapitalCityQuestionsGenerator capitalCityQuestionsGenerator;

    /**
     * Constructeur avec paramètre.
     *
     * @param pCapitalCityQuestionsGenerator nombre de questions
     */
    public GUIQuiz(final CapitalCityQuestionsGenerator pCapitalCityQuestionsGenerator) {
        super(pCapitalCityQuestionsGenerator);
    }

    /**
     * Constructeur avec paramètre.
     *
     * @param pNombreDeQuestions
     */



    @Override
    protected void displayMessage(final String format) {
        JOptionPane.showMessageDialog(null, format);
    }

    @Override
    protected String retrieveAnswer(final String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    public CapitalCityQuestionsGenerator getCapitalCityQuestionsGenerator() {
        return capitalCityQuestionsGenerator;
    }

    public void setCapitalCityQuestionsGenerator(final CapitalCityQuestionsGenerator pCapitalCityQuestionsGenerator) {
        this.capitalCityQuestionsGenerator = pCapitalCityQuestionsGenerator;
    }
}
