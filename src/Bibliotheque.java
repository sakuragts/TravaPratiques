import java.util.Arrays;

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

    //CONSTANTES DE CLASSE
    public final static int NBR_CASES = 4;

    //ATTRIBUTS D'INSTANCE
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

        if (iemeLivre >= 0 && iemeLivre < nbrLivres) {
            livre = this.livres[iemeLivre];
        }
        return livre;
    }

    public Livre supprimerLivre (int iemeLivre) {
        Livre livre = null;

        if (iemeLivre > 0 && iemeLivre < nbrLivres) {
            livre = this.livres[iemeLivre];
            nbrLivres--;
            replacerBiblio(iemeLivre);
        }
        return livre;
    }

    public Livre[] rechercherParConjonctionDeCategories (int [] numCategories) {
        Livre [] livresConjonc = {};
        int indiceLivreConjonc = 0;
        int tempCategorie;
        int [] comptCat;
        Livre tempLivre = null;

        if (numCategories != null && numCategories.length != 0) {
            comptCat = new int[numCategories.length];
            for (int i = 0; i < this.livres.length; i++) {
                for (int j = 0; j < numCategories.length; j++) {
                    tempLivre = this.livres[i];
                    tempCategorie = numCategories[j];
                    if (tempLivre.estClasseDans(tempCategorie)) {
                        comptCat[j] = tempCategorie;
                    }
                }
                if (Arrays.equals(comptCat, numCategories)) {
                    livresConjonc = agrandirTab(livresConjonc);
                    livresConjonc[indiceLivreConjonc] = tempLivre;
                    indiceLivreConjonc++;
                }
                comptCat = new int[numCategories.length];
            }
        } else {
            livresConjonc = this.livres;
        }
        return livresConjonc;
    }

    public Livre[] rechercherParDisjonctionDeCategories (int [] numCategories) {
        Livre [] livresDisjonc = {};
        int indiceLivresDisjonc = 0;
        int tempCategorie;
        Livre tempLivre;

        if (numCategories != null) {
            for (int j = 0; j < this.livres.length; j++) {
                for (int i = 0; i < numCategories.length; i++) {
                    tempCategorie = numCategories[i];
                    tempLivre = this.livres[j];
                    if (tempLivre.estClasseDans(tempCategorie) && !seRetrouveDans
                            (livresDisjonc, tempLivre)) {
                        livresDisjonc = agrandirTab(livresDisjonc);
                        livresDisjonc[indiceLivresDisjonc] = tempLivre;
                        indiceLivresDisjonc++;
                    }
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
        for (int i = indiceLivre; i < nbrLivres; i++) {
            this.livres[i] = this.livres[i + 1];
            indiceLivre = i;
        }
        if (indiceLivre < this.livres.length - 1) {
            this.livres[indiceLivre] = this.livres[indiceLivre + 1];
            this.livres[indiceLivre + 1] = null;
        } else {
            this.livres[indiceLivre] = null;
        }
        return this.livres;
    }

    private boolean seRetrouveDans (Livre [] livres, Livre livre) {
        boolean estDans = false;
        int indexLivre = 0;

        while (!estDans && indexLivre < livres.length) {
            if (livres[indexLivre] != null) {
                estDans = livres[indexLivre].estEgal(livre);
            }
            indexLivre++;
        }
        return  estDans;
    }

}
