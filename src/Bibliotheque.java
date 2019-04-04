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

    public Livre[] livres = new Livre[NBR_CASES];
    public int nbrLivres = 0;

    //CONSTRUCTEURS
    public Bibliotheque() {

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
