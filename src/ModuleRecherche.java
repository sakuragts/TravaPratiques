/**
 * I N F 1 1 2 0
 *
 * Decrivez votre classe LaboBoucles2B ici.
 *
 * @author Ingrid Blemur
 * @version 13/03/2019
 *
 * BLEI08547903
 * blemur.ingrid@courrier.uqam.ca
 */

public class ModuleRecherche {
    public static final String MENU_PRINCIPAL = "-----------------\n" +
            "MENU DE RECHERCHE\n" +
            "-----------------\n" +
            "1. Recherche par categorie(s)\n" +
            "2. Recherche par titre\n" +
            "3. Recherche par auteur\n" +
            "4. Recherche par periode\n" +
            "5. Quitter\n" +
            "\n" +
            "Entrez votre choix : ";
    public static final String MENU_CATEGORIES = "LISTE DES CATEGORIES : \n" +
            "1. Science fiction\n"+
            "2. Romance\n" +
            "3. Thriller\n" +
            "4. Policier\n" +
            "5. Humour\n" +
            "6. Drame" +
            "\n" +
            "Entrez un numero de categories (0 pour terminer) : ";
    public static final String MSG_DEBUT = "Cette application permet d'executer diverses requetes pour rechercher des livres\n" +
            "dans une bibliotheque donnee. Elle permet plus particulierement de faire des\n" +
            "recherches par categorie(s), par expression dans le titre, par auteur, et par\n" +
            "periode de publication.";
    public static final String MSG_FIN = "FIN DU PROGRAMME. AU REVOIR!";
    public static final String MSG_ENTREE = "Tapez <ENTREE> pour revenir au menu de recherche... ";
    public static final String MSG_CATEGORIES = "*** RECHERCHE PAR CATEGORIE(S) ***"
            + "Recherche par (C)onjonction ou (D)isjonction : ";
    public static final String MSG_TITRE = "*** RECHERCHE PAR TITRE ***\n" +
            "\n" +
            "Entrez le titre ou une partie du titre (<ENTREE> pour terminer) : ";
    public static final String MSG_ANNULEE = "RECHERCHE ANNULEE.";
    public static final String MSG_AUTEUR = "*** RECHERCHE PAR AUTEUR ***\n" +
            "\n" +
            "Entrez le nom de l'auteur (<ENTREE> pour terminer) : ";
    public static final String MSG_PERIODE = "*** RECHERCHE PAR PERIODE ***\n" +
            "\n" +
            "Entrez l'annee du debut de la periode (0 pour terminer) : ";
    public static final String MSG_RESULTAT = "RESULTAT(S) DE RECHERCHE :\n"
            + "--------------------------";
    public static final String ERR_CHOIX = "Erreur, choix invalide! Recommencez...";
    public static final String ERR_CATEGORIES = "Erreur, numero de categorie invalide! Recommencez...";
    public static final String ERR_PAS_TROUVE = "AUCUN LIVRE TROUVE.";

    //prends et valide le choix de l'utilisateur
   public static String validerChoix(String msgMenu, String msgErr, char min, char max) {
        boolean boolChoix;
        String choix;
        do{
            boolChoix = true;
            System.out.print(msgMenu);
            choix = Clavier.lireString();
            if(choix.length() != 1){
                System.out.println(msgErr);
                boolChoix = false;
            }else if (choix == null ||
                    choix.charAt(0) < min || choix.charAt(0) > max) {
                System.out.println(msgErr);
                boolChoix = false;
            }
        }while(!boolChoix);
        return choix;
    }

    /*Prends en parametre une ligne du resultat de la recherche et le
    formatte selon la convention donnee*/
    public static String formatLivre(String resultatSubString) {
        int indexTab;
        String formateSubString;

        indexTab = resultatSubString.indexOf('\t');
        indexTab = resultatSubString.indexOf('\t', indexTab + 1);
        formateSubString = "- "
                + resultatSubString.substring(0, indexTab).toUpperCase()
                + " (";
        indexTab = resultatSubString.indexOf('\t', indexTab + 1);
        formateSubString += resultatSubString.substring(indexTab - 4, indexTab)
                + "), [ " +
            resultatSubString.substring(indexTab + 1).replace('\t', ',').toLowerCase() + " ]";
        formateSubString = formatePlaceAnnee(formateSubString);

        return formateSubString;
    }

    public static String formatePlaceAnnee(String formateSubString) {
        String subStringAnnee;
        String formateSubStringPlaceAnnee;
        int indexParenthese;
        int indexTab;

        indexTab = formateSubString.indexOf('\t');
        indexParenthese = formateSubString.indexOf('(');
        subStringAnnee = formateSubString.substring(indexParenthese,
                indexParenthese + 7);
        formateSubStringPlaceAnnee = formateSubString.substring(0, indexTab)
                + " " + subStringAnnee + " " +
                formateSubString.substring(indexTab + 1,
                        formateSubString.indexOf('('))
                + formateSubString.substring(formateSubString.indexOf('['));
        return formateSubStringPlaceAnnee;
    }



    /*Prends en parametre une ligne du document de references et l'entree recherchee. L'entree
    recherchee est comparee a chaque bloc separe par un espace tab pour trouver s'il est
    contenu dans la ligne visee*/

    //recherche partiel. p-e utiliser un while?
    public static boolean compareOption(String subString, String entree) {
        String compareOption;
        boolean compare = false;
        int index;
        for(int i = 0; i < subString.length(); i = index) {
            index = subString.indexOf('\t', i + 1);
            if(index < 0){
                index = subString.length();
            }
            compareOption = subString.substring(i, index);
            compareOption = compareOption.trim();
            if(compareOption.contains(entree) || compareOption.compareToIgnoreCase(entree) == 0) {
                compare = true;
            }
        }
        return compare;
    }

    /*Prends en paramettre le document de reference bibliotheque et l'entree
    recherchee. L'entree est recherchee a travers le document de reference*/

    //p-e utiliser cette methode pour separer le texte par ligne?
    public static String rechercheEntree(String biblio, String entree) {
        String resultatRecherche = "";
        String rechercheSub;
        int indexDebut;
        int indexFin;

        for(int i = 0; i < biblio.length(); i = indexFin) {
            indexDebut = i;
            indexFin = biblio.indexOf('\n', indexDebut);
            if (indexFin >= 0) {
                rechercheSub = biblio.substring(indexDebut, indexFin);
                if (compareOption(rechercheSub, entree)) {
                    resultatRecherche += rechercheSub + '\n';
                }
                indexFin++;
            }else {
                indexFin = biblio.length();
            }

        }
        if(resultatRecherche.isEmpty()) {
            System.out.println(ERR_PAS_TROUVE);
        }

        return resultatRecherche;
    }
}