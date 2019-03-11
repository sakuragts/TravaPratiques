





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


    //affiche un menu et valide le choix de l'utilisateur
    /*public static String valideEntreeString(String msgMenu, String msgErr, String min, String max) {
        String entree;
        int intEntree;
        int intMin;
        int intMax;
        boolean estInvalide = true;

        do {
            System.out.print(msgMenu);
            entree = Clavier.lireString();
            if (entree != null && !entree.isEmpty()) {
                if(entree.length() < 1 && entree.charAt(0) > '1' && entree.charAt(0) < '9') {
                    intEntree = Integer.parseInt(entree);
                    intMin = Integer.parseInt(min);
                    intMax = Integer.parseInt(max);
                    if (intEntree < intMin && intEntree > intMax) {
                        System.out.println(msgErr);
                    } else {
                        estInvalide = false;
                    }
                }
            }else{
                System.out.println(msgErr);
            }
        }while(estInvalide);
        return entree;
    }*/

    //prends et valide le choix de l'utilisateur
   public static String validerChoix(String msgMenu, String msgErr, char min, char max){
        boolean boolChoix;
        String choix;
        do{
            boolChoix = true;
            System.out.print(msgMenu);
            choix = Clavier.lireString();
            if(choix.length() != 1){
                System.out.println(msgErr);
                boolChoix = false;
            }else if (choix == null || choix.isEmpty() ||
                    choix.charAt(0) < min || choix.charAt(0) > max){
                System.out.println(msgErr);
                boolChoix = false;
            }
        }while(!boolChoix);
        return choix;
    }


    /*Prends en parametre une ligne du document de references et l'entree recherchee. L'entree recherchee est comparee
    a chaque bloc separe par un espace tab pour trouver s'il est contenu dans la ligne visee*/
    public static boolean compareOption(String subString, String entree) {
        String compareOption;
        boolean compare = false;
        int index;
        for(int i = 0; i < subString.length(); i = index){
            index = subString.indexOf('\t', i + 1);
            if(index < 0){
                index = subString.length();
            }
            compareOption = subString.substring(i, index);
            compareOption = compareOption.trim();
            if(compareOption.contains(entree) || compareOption.compareToIgnoreCase(entree) == 0){
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
            }else{
                indexFin = biblio.length();
            }

        }
        if(resultatRecherche.isEmpty()) {
            System.out.println(ERR_PAS_TROUVE);
        }

        return resultatRecherche;
    }
}