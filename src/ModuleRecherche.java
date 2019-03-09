public class ModuleRecherche {
    public static final String MSG_DEBUT = "Cette application permet d'executer diverses requetes pour rechercher des livres\n" +
            "dans une bibliotheque donnee. Elle permet plus particulierement de faire des\n" +
            "recherches par categorie(s), par expression dans le titre, par auteur, et par\n" +
            "periode de publication.";
    public static final String ERR_CHOIX = "Erreur, choix invalide! Recommencez...";
    public static final String MSG_FIN = "FIN DU PROGRAMME. AU REVOIR!";
    public static final String ERR_PAS_TROUVE = "AUCUN LIVRE TROUVE.";
    public static final String MSG_ENTREE = "Tapez <ENTREE> pour revenir au menu de recherche... ";

    //affiche le menu principal
    public static void afficherMenu(){
        System.out.print("-----------------\n"
        + "MENU DE RECHERCHE\n"
        + "-----------------\n"
        + "1. Recherche par categorie(s)\n"
        + "2. Recherche par titre\n"
        + "3. Recherche par auteur\n"
        + "4. Recherche par periode\n"
        + "5. Quitter\n"
        + "\n"
        + "Entrez votre choix : ");
    }

    //prends et valide le choix de l'utilisateur
    public static String validerChoix(){
        boolean boolChoix;
        String choix;

        do{
            afficherMenu();
            choix = Clavier.lireString();
            boolChoix = choix.equals("1") || choix.equals("2") || choix.equals("3") || choix.equals("4") || choix.equals("5");
            if (!boolChoix) {
                System.out.println(ERR_CHOIX);
            }
        }while(!boolChoix);
        return choix;
    }

    public static boolean compareOption(String subString, String option){
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
            if(compareOption.contains(option) || compareOption.compareToIgnoreCase(option) == 0){
                compare = true;
            }
       }
        return compare;
    }

    public static String recherche(String biblio, String option){
        String resultatRecherche = "";
        String rechercheSub;
        int indexDebut;
        int indexFin;

        for(int i = 0; i < biblio.length(); i = indexFin){
            indexDebut = i;
            indexFin = biblio.indexOf('\n', indexDebut);
            if (indexFin >= 0) {
                rechercheSub = biblio.substring(indexDebut, indexFin);
                if (compareOption(rechercheSub, option)) {
                    resultatRecherche += rechercheSub + '\n';
                }
                indexFin++;
            }else{
                indexFin = biblio.length();
            }

        }
        if (resultatRecherche.isEmpty()){
            System.out.println(ERR_PAS_TROUVE);
        }

        return resultatRecherche;
    }
}
