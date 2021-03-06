public class Main {

    public static void main(String[] args) {
        Livre l1 = new Livre("Origine", "D. Brown ", 2017);
        Livre l2 = new Livre("Romance et de si belles fiancailles", "M. H. Clark", 2018);
        Livre l3 = new Livre("La fille du train", "P. Hawkins", 2015);
        Livre l4 = new Livre("Le tricycle rouge", "V. Hauuy", 2018);


        /*
           public final static int CAT_SCIENCE_FICTION = 0;
           public final static int CAT_ROMANCE = 1;
           public final static int CAT_THRILLER = 2;
           public final static int CAT_POLICIER = 3;
           public final static int CAT_HUMOUR = 4;
           public final static int CAT_DRAME = 5;
         */

        int [] categorie = {2, 3};
        int [] cat1 = {0, 2};
        int [] cat2 = {0, 4, 2};
        int [] cat3 = {1, 3, 4};
        int [] cat4 = {4, 1};
        int [] cat5 = {4};
        int [] cat6 = {4, 3};
        int [] cat7 = {4};
        int [] cat8 = {3, 1, 4};

        int [] findCat = {};

        l1.ajouterCategorie(2);
        l1.ajouterCategorie(3);
        l2.ajouterCategorie(2);
        l2.ajouterCategorie(3);
        l2.ajouterCategorie(1);
        l3.ajouterCategorie(3);
        l4.ajouterCategorie(5);
        l4.ajouterCategorie(3);
        Livre [] livres = {l1, l2, l3, l4};

        Bibliotheque b1 = new Bibliotheque(livres);
        b1.ajouterLivre("Double piege", "H. Coben", 2018, categorie);
        b1.ajouterLivre("Double piege", "H. Coben", 2018, categorie);
        b1.ajouterLivre("La mort n'existe pas", "D. Eleonori", 2018, cat1);
        b1.ajouterLivre("Le fils cache de la lune", "E. Nataf", 2018, cat2 );
        b1.ajouterLivre("Les neuf vies de Stephanie Plum", "J. Evanovich", 2016, cat3);
        b1.ajouterLivre("L'inoubliable ete des jeux de seduction","V. Auclair", 2016, cat4);
        b1.ajouterLivre("La petulante ascension de Benjamin Fabre", "F. Lehman", 2014, cat5);
        b1.ajouterLivre("Rien ne va plus chez les Spellman!", "L. Lutz", 2018, cat6);
        b1.ajouterLivre("Une vie inutile", "S. Paquet", 2012, cat7);
        b1.ajouterLivre("Dix-sept ans de malheur", "J. Evanovich", 2017, cat8);
        Livre [] recherche = b1.rechercherParConjonctionDeCategories(findCat);

        for (int i = 0; i < recherche.length; i++) {
            System.out.println(recherche[i]);
        }

        System.out.println("------------------------------\n"+
                "\n\n");

        l4.setTitre("La bicyclette jaune");

        Livre livre = b1.obtenirLivre(3);
        System.out.println(livre);


        System.out.println(b1.getNbrLivres());
    }


}