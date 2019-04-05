public class Main {

    public static void main(String[] args) {
        Livre l1 = new Livre("Origine", "D. Brown ", 2017);
        Livre l2 = new Livre("Romance et de si belles fiancailles", "M. H. Clark", 2018);
        Livre l3 = new Livre("La fille du train", "P. Hawkins", 2015);
        Livre l4 = new Livre("Le tricycle rouge", "V. Hauuy", 2018);

        Livre [] livres = {l1, l2, l3, l4};

        Bibliotheque b1 = new Bibliotheque(livres);

    }


}