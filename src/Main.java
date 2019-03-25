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
        categorie = ModuleRecherche.validerCategories();



        resultat = ModuleRecherche.rechercheCategorieConjonc("Origine\tD. Brown\t2017\tThriller\tPolicier\n" +
                "Romance et de si belles fiancailles\tM. H. Clark\t2018\tthriller\tpolicier\tRomance\n" +
                "La fille du train\tP. Hawkins\t2015\tPolicier\n" +
                "Le tricycle rouge\tV. Hauuy\t2018\tDrame\tPolicier", categorie, 3);
        //resultat = ModuleRecherche.rechecheCategorieDisjonc(biblio, categorie);
        //resultat = ModuleRecherche.rechercheTitre(biblio, 0);
        //resultat = ModuleRecherche.rechercheAuteur(biblio, 1);
        //resultat = ModuleRecherche.rechercheAnnee(biblio, 2);
        //resultat = ModuleRecherche.menuPrincipal();
        System.out.println(resultat);


    }


}