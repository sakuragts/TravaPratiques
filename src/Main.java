public class Main {

    public static void main(String[] args) {
        String biblio = UtilitaireTP2.lireBibliotheque();

        String choix = "";
        String categorie = "";
        String resultat = "";
        String trouveCategorie;
        String trouveCategorieSub = "";
        int indexDebutLigne;
        int indexFinLigne = 0;



        System.out.print(ModuleRecherche.MENU_CATEGORIES);
        //faire methode choix categorie avec disjonction
        while(!choix.equals("0")) {
            choix = ModuleRecherche.validerChoix(ModuleRecherche.MSG_ENTREZ_CATEGORIE,ModuleRecherche.ERR_CATEGORIES, '0', '6');
            categorie = ModuleRecherche.selecteCategorie(choix);
            trouveCategorie = ModuleRecherche.rechercheBiblio(biblio, categorie, 3);
            for(int i = 0; i < trouveCategorie.length(); i = indexFinLigne) {
                indexDebutLigne = i;
                indexFinLigne = trouveCategorie.indexOf('\n', indexDebutLigne);
                if (indexFinLigne >= 0) {
                    trouveCategorieSub = biblio.substring(indexDebutLigne, indexFinLigne);
                    if(!resultat.contains(trouveCategorieSub)) {
                        resultat += trouveCategorie;
                    }
                    indexFinLigne++;
                }else {
                    indexFinLigne = biblio.length();
                }

            }
               // if(!ModuleRecherche.estContenu(resultat, trouveCategorieSub)) {
                 //   resultat += trouveCategorie;
                    //System.out.println(trouveCategorie);
                    //System.out.println(resultat + "\n") ;
                }

        System.out.println(resultat);
        }

        //System.out.println(categorie);
       // System.out.println(resultat);
        //categorie = ModuleRecherche.separeFiche("Romance et de si belles fiancailles\tM. H. Clark\t2018\tthriller\tpolicier\tRomance", 3);
        //System.out.println(ModuleRecherche.rechercheBiblio(biblio, "thriller"));
    }


