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

        //System.out.print(ModuleRecherche.MENU_CATEGORIES);
        //categorie = ModuleRecherche.validerCategories();



        //resultat = ModuleRecherche.rechercheCategorieConjonc(biblio,
                //categorie);
        //resultat = ModuleRecherche.rechecheCategorieDisjonc(biblio, categorie);
        resultat = ModuleRecherche.rechercheTitre(biblio, 0);

        System.out.println(resultat);


    }


}