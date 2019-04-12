import java.util.Arrays;

/**
 * I N F 1 1 2 0
 *
 *
 *
 * @author Ingrid Blemur
 * @version 12/04/2019
 *
 * BLEI08547903
 * blemur.ingrid@courrier.uqam.ca
 */

public class Bibliotheque {

    //CONSTANTES DE CLASSE
    public final static int NBR_CASES = 4; //nombre de cases du tableau a creer

    //ATTRIBUTS D'INSTANCE
    private Livre[] livres; //tableau de la bibliotheque
    private int nbrLivres; //compteur pour savoir le nombre de livres dans la
                          // bibliotheque

    //CONSTRUCTEURS

    /**
     * Construit une bibliotheque vide et ne prends aucun parametres.
     */
    public Bibliotheque() {
        this.livres = new Livre[NBR_CASES];
    }

    /**
     *Construit une bibliotheque et la rempli avec une collection de livres donnne
     * en parametre.
     *
     * @param lesLivres tableau de livres crees et valides par la classe d'objet
     *                  Livre
     */
    public Bibliotheque(Livre[] lesLivres) {
        this.livres = new Livre[NBR_CASES];
        nbrLivres = 0;
        Livre livre;

        for (int i = 0; i < lesLivres.length; i++) {
            livre = lesLivres[i];
            ajouterLivre(livre);

        }
    }

    //GETTER

    /**
     * Permet d'obtenir le nombre de livres se retrouvant dans la bibliotheque
     *
     * @return le nombre de livres
     */
    public int getNbrLivres () {
        return nbrLivres;
    }


    //METHODES PUBLIQUES D'INSTANCE

    /**
     * Teste si le livre ajoute en parametre existe deja dans la
     * bibliotheque. Cette methode utilise la methode de la classe Livre estEgal
     * pour verifier par le titre, l'auteur et l'annee de publication.
     *
     * @param livre Un objet de type Livre valide
     * @return true si le livre existe dans la bibliotheque
     */
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

    /**
     * Teste si le livre donne en parametre existe deja dans la bibliotheque.
     * Le livre est ajoute seulement si le livre n'existe pas dans la
     * bibliotheque.
     *
     * @param livre Un objet de type Livre valide
     * @return true si le livre a bien ete ajoute
     */
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

    /**
     * Construit un nouveau livre avec les parametres donne en utilisant la
     * classe Livre pour valider les parametres. Ensuite, ajoute les
     * categories ajoutes en parametre a l'objet livre. Par la suite, ajoute
     * le livre dans la bibliotheque.
     *
     * @param titre qui sera  valide par la classe Livre
     * @param auteur qui sera valide par la classe Livre
     * @param anneePub qui sera valide par la classe Livre
     * @param numCategories qui sera valide par la classe Livre
     * @return true si le livre est ajoute a la bibliotheque
     */
    public boolean ajouterLivre(String titre, String auteur, int anneePub,
                                int[] numCategories) {
        Livre livre;
        int categorie;
        boolean livreAjouter;

        livre = new Livre(titre, auteur, anneePub);
        for (int i = 0; i < numCategories.length; i++) {
            categorie = numCategories[i];
            livre.ajouterCategorie(categorie);
        }
        livreAjouter = ajouterLivre(livre);
        return livreAjouter;
    }

    /**
     * Donne le livre a la position donne en parametre
     *
     * @param iemeLivre position du livre voulu dans la bibliotheque
     * @return le livre a la position donne en parametre, retourne null si la
     * position n'est pas valide
     */
    public Livre obtenirLivre (int iemeLivre ) {
        Livre livre = null;

        if (iemeLivre >= 0 && iemeLivre < nbrLivres) {
            livre = this.livres[iemeLivre];
        }
        return livre;
    }

    /**
     * Prends et donne le livre a la position prise en parametre et ecrase
     * celui-ci et deplacant les livres a partir de la position du livre
     * jusqu'a la fin.
     *
     * @param iemeLivre position du livre a suprimer
     * @return le livre qui a ete suprimer. Retourne null si la position
     * n'est pas valide
     */
    public Livre supprimerLivre (int iemeLivre) {
        Livre livre = null;

        if (iemeLivre > 0 && iemeLivre < nbrLivres) {
            livre = this.livres[iemeLivre];
            nbrLivres--;
            replacerBiblio(iemeLivre);
        }
        return livre;
    }

    /**
     * Recherche dans la bibliotheque par conjonction et donne les livres
     * correspondant aux categories donnees en parametre
     *
     * @param numCategories tableau de categories a chercher
     * @return tableau des resultat de la recherche par conjonction. Retourne
     * la bibliotheque au complet si le parametre est null ou est vide
     */
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

    /**
     * Recherche dans la bibliotheque par disjonction et donne le resultat
     * correspondant aux livres avec les categories donnees en parametre
     *
     * @param numCategories tableau de categories a chercher
     * @return tableau des resultats de la recherche. Ne retourne aucun livre
     * si le parametre est null ou vide.
     */
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

    /**
     * Agrandit le tableau donne en parametre de 1.
     *
     * @param tab tableau a agrandir
     * @return tableau agrandi
     */
    private Livre[] agrandirTab (Livre [] tab) {
        Livre [] agrandirTab;

        agrandirTab = new Livre[tab.length + 1];
        for (int i = 0; i < tab.length; i++) {
            agrandirTab[i] = tab[i];
        }
        return agrandirTab;
    }

    /**
     * Replace les livres dans la bibliotheque a partir de l'indice donne en
     * parametre.
     *
     * @param indiceLivre indice a partir duquel l'on replace les livres
     * @return la bibliotheque avec les livres replace
     */
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

    /**
     * Cherche si un livre donne en parametre se retrouve dans le tableau
     * donne en parametre
     *
     * @param livres tableau de livres a verifier
     * @param livre que l'on veut verifier s'il se retrouve dans le tableau
     * @return true si le livre se retrouve dans le tableau a verifier
     */
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