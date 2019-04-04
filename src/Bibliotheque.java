/**
 * I N F 1 1 2 0
 *
 *
 *
 * @author Ingrid Blemur
 * @version 01/04/2019
 *
 * BLEI08547903
 * blemur.ingrid@courrier.uqam.ca
 */

public class Bibliotheque {

    public final static int NBR_CASES = 4;

    private Livre[] livres;
    private int nbrLivres;

    //CONSTRUCTEURS
    public Bibliotheque() {
        livres = new Livre[NBR_CASES];
    }

    public Bibliotheque(Livre[] lesLivres) {
        livres = new Livre[NBR_CASES];
        nbrLivres = 0;
        Livre livre;

        for (int i = 0; i < lesLivres.length; i++) {
            livre = lesLivres[i];
            ajouterLivre(livre);

        }
    }


    //METHODES d'INSTANCE
    public boolean livreExiste(Livre livre) {
        boolean livreExiste = false;
        int indexBiblio = 0;

        while (!livreExiste && indexBiblio < this.livres.length ) {
            livreExiste = this.livres[indexBiblio].estEgal(livre);
            indexBiblio++;
        }
        return livreExiste;
    }

    public boolean ajouterLivre(Livre livre) {
        boolean livreAjouter = true;

        if (livre == null || livreExiste(livre)) {
            livreAjouter = false;
        } else if (!livreExiste(livre) && nbrLivres == this.livres.length - 1) {
            agrandirTab();
            livres[nbrLivres] = livre;
            nbrLivres++;
        } else {
            livres[nbrLivres] = livre;
            nbrLivres++;
        }
        return livreAjouter;
    }

    //public boolean ajouterLivres(String titre, String auteur, int anneePub, int[] numCategories) {

    //}

    //AUTRES METHODES

    private Livre[] agrandirTab () {
        this.livres = new Livre[2 * this.livres.length];
        return livres;
    }

}
