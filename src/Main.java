public class Main {

    public static void main(String[] args) {
        String biblio = UtilitaireTP2.lireBibliotheque();

        String choix = "";
        String categorie = "";
        String resultat = "";
        String trouveCategorie;
        String trouveCategorieSub;
        int indexFinLigne;
        int indexDebutLigne;



        System.out.print(ModuleRecherche.MENU_CATEGORIES);

        resultat = ModuleRecherche.rechercheCategorieConjonc(biblio);


        System.out.println(resultat);

    }


}