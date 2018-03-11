import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe abstraite Quiz.
 */
public abstract class Quiz {

    public static final String MAUVAISE_REPONSE = "Mauvaise reponse. Il fallait répondre %s \n";
    public static final String BONNE_REPONSE = "Bonne réponse ! ";
    public static final String QUESTION = "Quelle est la capitale de ce pays : %s ? \n";

    private CapitalCityQuestionsGenerator capitalCityQuestionsGenerator;

    /**
     * Lieu d'emplacement du fichier à parser.
     */
    private static final String EMPLACEMENT_DU_FICHIER =
            "C:\\Users\\matth\\Downloads\\"
                    + "liste_des_capitales_nationales-1012j.csv";
    /**
     * HashMap contenant les capitales et les villes.
     */
    private static HashMap<String, String> mapVilleEtCapitale = new HashMap<>();

    /**
     * Total de bonne réponse de l'utilisateur.
     */
    private static int totalBonneReponse = 0;

    /**
     * Temps permettant d'afficher le nombre de
     * seconde qu'a mis l'utilisateur pour réaliser le quiz.
     */
    private static long tempsEcoulerEntreDebutEtFin = 0L;

    /**
     * 1 seconde reprensente 1000 millisecondes.
     */
    private static final int TEMPS_SECONDE_DANS_MILLE_MILLISECONDE = 1000;

    /**
     * Constructeur avec paramètre.
     * @param pCapitalCityQuestionsGenerator nombre de questions
     */
    public Quiz(final CapitalCityQuestionsGenerator pCapitalCityQuestionsGenerator) {
        this.capitalCityQuestionsGenerator = pCapitalCityQuestionsGenerator;

    }

    public void start() throws IOException {
        String userReponse = null;
        HashMap<String, String> listeDeCapitaleEtDePays = capitalCityQuestionsGenerator.initValue();
        for (Map.Entry<String, String> mapCapitaleVille : listeDeCapitaleEtDePays.entrySet()) {
            String pays = mapCapitaleVille.getKey();
            long startTime = System.currentTimeMillis();
            userReponse = retrieveAnswer(String.format(QUESTION, pays));
            long endTime = System.currentTimeMillis();
            String bonneReponse = mapCapitaleVille.getValue();
            tempsEcoulerEntreDebutEtFin = tempsEcoulerEntreDebutEtFin
                    + ((endTime - startTime) / TEMPS_SECONDE_DANS_MILLE_MILLISECONDE);
            if (userReponse.equalsIgnoreCase(bonneReponse)) {
                displayMessage(BONNE_REPONSE);
                totalBonneReponse++;

            } else {
                displayMessage(String.format(MAUVAISE_REPONSE, bonneReponse));
            }
        }
    }

    /**
     * affiche un message.
     * @param format
     */
    protected abstract void displayMessage(String format);

    /**
     * recupere une réponse.
     * @param s
     * @return
     * @throws IOException
     */
    protected abstract String retrieveAnswer(String s) throws IOException;




    /**
     * Affiche un message de resultat.     */
    public void displayResult() {
        displayMessage(String.format("C'est terminé ! <<Score: %s/%s>>",
                totalBonneReponse, capitalCityQuestionsGenerator.getNombreDeQuestions()));
        displayMessage(String.format("Il vous a fallu %s", tempsEcoulerEntreDebutEtFin + " secondes pour réaliser le quizz"));
    }
}
