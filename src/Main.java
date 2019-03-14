public class Main {

    public static void main(String[] args) {
        String biblio = UtilitaireTP2.lireBibliotheque();

        String choix = "";
        String categorie = "";
        String resultat = "";
        String trouveCategorie;



        System.out.print(ModuleRecherche.MENU_CATEGORIES);
        //faire methode choix categorie avec disjonction
        while(!choix.equals("0")) {
            choix = ModuleRecherche.validerChoix(ModuleRecherche.MSG_ENTREZ_CATEGORIE,ModuleRecherche.ERR_CATEGORIES, '0', '6');
            categorie = ModuleRecherche.selecteCategorie(choix);
            trouveCategorie = ModuleRecherche.rechercheEntree(biblio, categorie);

            if(!ModuleRecherche.estContenu(resultat, choix)) {
                resultat += trouveCategorie;
            System.out.println(trouveCategorie + "\n" + "\n");
            System.out.println(resultat + "\n") ;
            }
        }

        System.out.println(categorie);
        System.out.println(resultat);
        //categorie = ModuleRecherche.separeFiche("Romance et de si belles fiancailles\tM. H. Clark\t2018\tthriller\tpolicier\tRomance", 3);
        //System.out.println(ModuleRecherche.rechercheEntree(biblio, "thriller"));
    }


}