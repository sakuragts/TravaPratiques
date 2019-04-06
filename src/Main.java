public class Main {

    public static void main(String[] args) {
        Livre l1 = new Livre("Origine", "D. Brown ", 2017);
        Livre l2 = new Livre("Romance et de si belles fiancailles", "M. H. Clark", 2018);
        Livre l3 = new Livre("La fille du train", "P. Hawkins", 2015);
        Livre l4 = new Livre("Le tricycle rouge", "V. Hauuy", 2018);
        Livre l5;

        int [] categorie = new int[2];
        categorie[0] = 2;
        categorie[1] = 3;
        int [] cat1 = new int[2];
        cat1[0] = 0;
        cat1[1] = 2;
        int [] cat2 = new int[3];
        cat2[0] = 0;
        cat2[1] = 4;
        cat2[2] = 2;

        int [] findCat = new int[2];
        findCat[0] = 2;
        findCat[1] = 3;

        Livre [] livres = {l1, l2, l3, l4};

        Bibliotheque b1 = new Bibliotheque(livres);
        b1.ajouterLivre("Double piege", "H. Coben", 2018, categorie);
        b1.ajouterLivre("La mort n'existe pas", "D. Eleonori", 2018, cat1);
        b1.ajouterLivre("Le fils cache de la lune", "E. Nataf", 2018, cat2 );
        b1.rechercherParDisjonctionDeCategories(findCat);

    }


}