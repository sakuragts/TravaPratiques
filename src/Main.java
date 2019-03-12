public class Main {

    public static void main(String[] args) {
        String biblio = UtilitaireTP2.lireBibliotheque();
        String test = "policier";

        //ModuleRecherche.validerChoix("Veuillez choisir entre 1 a 4: ", "Erreur! Choix invalide",  '1', '4');
        System.out.println(ModuleRecherche.formatLivre("Romance et de si belles fiancailles	M. H. Clark	2018	thriller	policier	Romance"));
    }

}