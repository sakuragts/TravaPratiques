





public class ModuleRecherche {
    public static final String menuPrincipal = "-----------------\n"
            + "MENU DE RECHERCHE\n"
            + "-----------------\n"
            + "1. Recherche par categorie(s)\n"
            + "2. Recherche par titre\n"
            + "3. Recherche par auteur\n"
            + "4. Recherche par periode\n"
            + "5. Quitter\n"
            + "\n"
            + "Entrez votre choix : ";
    public static final String MSG_DEBUT = "Cette application permet d'executer diverses requetes pour rechercher des livres\n" +
            "dans une bibliotheque donnee. Elle permet plus particulierement de faire des\n" +
            "recherches par categorie(s), par expression dans le titre, par auteur, et par\n" +
            "periode de publication.";
    public static final String ERR_CHOIX = "Erreur, choix invalide! Recommencez...";
    public static final String MSG_FIN = "FIN DU PROGRAMME. AU REVOIR!";
    public static final String ERR_PAS_TROUVE = "AUCUN LIVRE TROUVE.";
    public static final String MSG_ENTREE = "Tapez <ENTREE> pour revenir au menu de rechercheEntree... ";




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
        int indiceTab = 0;
        int indexTab = 0;
        String formateSubString = "";

        indexTab = resultatSubString.indexOf('\t');

        for(int i = indexTab; i < resultatSubString.length(); i = indexTab) {
            indexTab = resultatSubString.indexOf('\t', i + 1);
            indiceTab++;
            if(indexTab < 0) {
                indexTab = resultatSubString.length();
            }

            if(indiceTab == 2) {
                formateSubString = resultatSubString.substring(0, i).toUpperCase() + " (";
            }else if(indiceTab == 3) {
                formateSubString += resultatSubString.substring(i - 4, i) + "), [ " +
                        resultatSubString.substring(i + 1).replace('\t', ',').toLowerCase();
            }

        }
        formateSubString = "- " +formateSubString + " ]";

        return formateSubString;
    }


    /*Prends en parametre une ligne du document de references et l'entree recherchee. L'entree
    recherchee est comparee a chaque bloc separe par un espace tab pour trouver s'il est
    contenu dans la ligne visee*/
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

    /*Prends en paramettre le document de reference bibliotheque et l'entree recherchee. L'entree est recherchee
    a travers le document de reference*/
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