import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ConsoleQuiz extends Quiz {

    /**
     * Quizz de type capitalCity
     */
    private CapitalCityQuestionsGenerator capitalCityQuestionsGenerator;
    /**
     * Permet de donner la main à l'utilisateur pour écrire une réponse.
     */
    private static BufferedReader readerLine =
            new BufferedReader(new InputStreamReader(System.in));

    /**
     * Constructeur avec paramètre.
     *
     * @param pCapitalCityQuestionsGenerator nombre de questions
     */
    public ConsoleQuiz(final CapitalCityQuestionsGenerator pCapitalCityQuestionsGenerator) {
        super(pCapitalCityQuestionsGenerator);
    }


    @Override
    protected void displayMessage(final String format) {
        System.out.println(format);
    }

    @Override
    protected String retrieveAnswer(final String prompt) throws IOException {
        displayMessage(prompt);
        return readerLine.readLine();

    }
}
