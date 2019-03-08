public class ModuleRecherche {
    public static final String MSG_DEBUT = "Cette application permet d'executer diverses requetes pour rechercher des livres\n" +
            "dans une bibliotheque donnee. Elle permet plus particulierement de faire des\n" +
            "recherches par categorie(s), par expression dans le titre, par auteur, et par\n" +
            "periode de publication.";
    public static final String ERR_CHOIX = "Erreur, choix invalide! Recommencez...";

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
        + "Entrez votre choix :");
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
}
