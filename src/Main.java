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


       boolean test = ModuleRecherche.estContenu("thriller\tpolicier\tRomance", "DRAME\tROMANCE\tTHRILLER");


        //resultat = ModuleRecherche.rechercheCategorieConjonc(biblio);

        System.out.println(test);


    }


}