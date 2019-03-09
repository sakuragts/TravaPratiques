public class Main {

    public static void main(String[] args) {
        String biblio = UtilitaireTP2.lireBibliotheque();
        String test = "policier";

        System.out.println(ModuleRecherche.recherche(biblio, "policier"));

    }

}
