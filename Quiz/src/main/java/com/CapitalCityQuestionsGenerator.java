package main.java.com;

import main.java.com.TransformeCSV;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CapitalCityQuestionsGenerator {

    /**
     * Le nombre de question du quiz.
     */
    private int nombreDeQuestions ;


    /**
     * Lieu d'emplacement du fichier à parser.
     */
    private static final String EMPLACEMENT_DU_FICHIER = "liste_des_capitales_nationales-1012j.csv";
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



    public CapitalCityQuestionsGenerator(final int pNombreDeQuestion) {
        this.nombreDeQuestions = pNombreDeQuestion;
    }


    /**
     * Retourne une hashmap de {Pays,Capital}. Dont la taille est choisie par l'utilisateur.
     * @return paysCapital
     */
    public HashMap<String, String> initValue() {

        HashMap<String, String> paysCapital = new HashMap<>();
        int compteur = 0;
        for (Map.Entry<String, String> mapCapitaleVille : getCapitaleEtVille().entrySet()) {
            while (nombreDeQuestions >= compteur) {
                String capitale = mapCapitaleVille.getKey();
                String ville = mapCapitaleVille.getValue();
                paysCapital.put(ville, capitale);
                compteur++;
                break;
            }
            if (compteur >= nombreDeQuestions) {
                break;
            }
        }

        return paysCapital;
    }

    /**
     * Parcours un fichier en entrée, et retourne une map de capitale et ville.
     * @return mapCapitaleEtVille.
     */
    public HashMap<String, String> getCapitaleEtVille() {
        //recuperer emplacement du fichier
        try {
            InputStream flux = new FileInputStream(CapitalCityQuestionsGenerator.class.getResource(EMPLACEMENT_DU_FICHIER).getFile());
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            // lire chaque ligne du fichier
            while ((ligne = buff.readLine()) != null) {
                //extraire la capitale et le pays
                mapVilleEtCapitale =   TransformeCSV.extraireCapitaleEtPays(ligne);
            }
            buff.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return mapVilleEtCapitale;
    }

    public int getNombreDeQuestions() {
        return nombreDeQuestions;
    }

    public void setNombreDeQuestions(final int pNombreDeQuestions) {
        this.nombreDeQuestions = pNombreDeQuestions;
    }
}
