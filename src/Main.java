public class Main {

    public static void main(String[] args) {
        String biblio = UtilitaireTP2.lireBibliotheque();
        String test = "policier";

        ModuleRecherche.valideEntreeString("Veuillez choisir entre 1 a 4: ", "Erreur! Choix invalide", "1", "4");

    }

}
