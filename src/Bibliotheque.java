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

    public Bibliotheque() {
        Livre[] biblio = this.livres;
    }

    public boolean livreExiste(Livre[] biblio, Livre livre) {
        boolean livreExiste = false;
        int indexBiblio = 0;

        while (!livreExiste && indexBiblio <= biblio.length ) {
            if (biblio[indexBiblio].estEgal(livre)) {
                livreExiste = true;
            }
            indexBiblio++;
        }

        return livreExiste;
    }

    public boolean ajouterLivre(Livre livre) {
        boolean livreAjouter = false;

        return livreAjouter;
    }
}
