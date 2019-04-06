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
        this.livres = new Livre[NBR_CASES];
    }

    public Bibliotheque(Livre[] lesLivres) {
        this.livres = new Livre[NBR_CASES];
        nbrLivres = 0;
        Livre livre;

        for (int i = 0; i < lesLivres.length; i++) {
            livre = lesLivres[i];
            ajouterLivre(livre);

        }
    }


    //METHODES PUBLIQUES D'INSTANCE
    public boolean livreExiste(Livre livre) {
        boolean livreExiste = false;
        int indexBiblio = 0;

        while (!livreExiste && indexBiblio < this.livres.length ) {
            if (this.livres[indexBiblio] != null) {
                livreExiste = this.livres[indexBiblio].estEgal(livre);
            }
            indexBiblio++;
        }
        return livreExiste;
    }

    public boolean ajouterLivre(Livre livre) {
        boolean livreAjouter = true;

        if (livre == null || livreExiste(livre)) {
            livreAjouter = false;
        } else if (nbrLivres == this.livres.length) {
            this.livres = agrandirTab(this.livres);
            livres[nbrLivres] = livre;
            nbrLivres++;
        } else {
            livres[nbrLivres] = livre;
            nbrLivres++;
        }
        return livreAjouter;
    }

    public boolean ajouterLivre(String titre, String auteur, int anneePub,
                                int[] numCategories) {
        Livre livre;
        int categorie;
        boolean livreAjouter = false;

        livre = new Livre(titre, auteur, anneePub);
        for (int i = 0; i < numCategories.length; i++) {
            categorie = numCategories[i];
            livre.ajouterCategorie(categorie);
        }
        livreAjouter = ajouterLivre(livre);
        return livreAjouter;
    }

    public Livre obtenirLivre (int iemeLivre ) {
        Livre livre = null;

        if (iemeLivre < nbrLivres) {
            livre = this.livres[iemeLivre];
        }
        return livre;
    }

    public Livre supprimerLivre (int iemeLivre) {
        Livre livre = null;

        if (iemeLivre < nbrLivres) {
            livre = this.livres[iemeLivre];
            this.livres[iemeLivre] = null;
            nbrLivres--;
            replacerBiblio(iemeLivre);
        }
        return livre;
    }

    public Livre[] rechercherParConjonctionDeCategories (int [] numCategories) {
        Livre [] livresConjonc = {};
        Livre [] livres;

        livres = rechercherParDisjonctionDeCategories(numCategories);
        if (livres != null) {

        }
        return livresConjonc;
    }

    public Livre[] rechercherParDisjonctionDeCategories (int [] numCategories) {
        Livre [] livresDisjonc = {};
        int indiceLivresDisjonc = 0;

        for (int i = 0; i < numCategories.length; i++) {
            for (int j = 0; j < this.livres.length; j++) {
                if (this.livres[j].estClasseDans(numCategories[i])) {
                    livresDisjonc = agrandirTab(livresDisjonc);
                    livresDisjonc[indiceLivresDisjonc] = this.livres[j];
                    indiceLivresDisjonc++;
                }
            }
        }
        return livresDisjonc;
    }

    //METHODES PRIVEES

    private Livre[] agrandirTab (Livre [] tab) {
        Livre [] agrandirTab;

        agrandirTab = new Livre[tab.length + 1];
        for (int i = 0; i < tab.length; i++) {
            agrandirTab[i] = tab[i];
        }
        return agrandirTab;
    }

    private Livre[] replacerBiblio (int indiceLivre) {
        while (this.livres[indiceLivre + 1] != null) {
            this.livres[indiceLivre] = this.livres[indiceLivre + 1];
            indiceLivre++;
        }
        this.livres[indiceLivre] = null;
        return this.livres;
    }

}
