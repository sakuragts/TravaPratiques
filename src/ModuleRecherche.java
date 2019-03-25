/**
 * I N F 1 1 2 0
 *
 *
 *
 * @author Ingrid Blemur
 * @version 25/03/2019
 *
 * BLEI08547903
 * blemur.ingrid@courrier.uqam.ca
 */

public class ModuleRecherche {
    public static final String MENU_PRINCIPAL = "\n-----------------\n" +
            "MENU DE RECHERCHE\n" +
            "-----------------\n" +
            "1. Recherche par categorie(s)\n" +
            "2. Recherche par titre\n" +
            "3. Recherche par auteur\n" +
            "4. Recherche par periode\n" +
            "5. Quitter\n" +
            "\n" +
            "Entrez votre choix : ";
    public static final String MENU_CATEGORIES = "\nLISTE DES CATEGORIES : \n" +
            "1. Science fiction\n"+
            "2. Romance\n" +
            "3. Thriller\n" +
            "4. Policier\n" +
            "5. Humour\n" +
            "6. Drame\n" +
            "\n";
    public static final String MSG_ENTREZ_CATEGORIE = "Entrez un numero de categories (0 pour terminer) : ";
    public static final String MSG_DEBUT = "Cette application permet d'executer diverses requetes pour rechercher des livres\n" +
            "dans une bibliotheque donnee. Elle permet plus particulierement de faire des\n" +
            "recherches par categorie(s), par expression dans le titre, par auteur, et par\n" +
            "periode de publication.\n";
    public static final String MSG_FIN = "\n\nFIN DU PROGRAMME. AU REVOIR!";
    public static final String MSG_ENTREE = "\nTapez <ENTREE> pour revenir au" +
            " menu de recherche... \n";
    public static final String MSG_CATEGORIES = "\n*** RECHERCHE PAR " +
            "CATEGORIE(S) ***\n" +
            "\n" +
            "Recherche par (C)onjonction ou (D)isjonction : ";
    public static final String MSG_TITRE = "\n*** RECHERCHE PAR TITRE ***\n" +
            "\n" +
            "Entrez le titre ou une partie du titre (<ENTREE> pour terminer) : ";
    public static final String MSG_ANNULEE = "\nRECHERCHE ANNULEE.\n";
    public static final String MSG_AUTEUR = "\n*** RECHERCHE PAR AUTEUR ***\n" +
            "\n" +
            "Entrez le nom de l'auteur (<ENTREE> pour terminer) : ";
    public static final String MSG_PERIODE = "\n*** RECHERCHE PAR PERIODE " +
            "***\n" +
            "\n" +
            "Entrez l'annee du debut de la periode (0 pour terminer) : ";
    public static final String MSG_RESULTAT = "\nRESULTAT(S) DE RECHERCHE :\n"
            + "--------------------------";
    public static final String ERR_CHOIX = "Erreur, choix invalide! " +
            "Recommencez...\n";
    public static final String ERR_CATEGORIES = "Erreur, numero de categorie " +
            "invalide! Recommencez...\n";
    public static final String ERR_CATEGORIES2 = "Erreur, veuillez choisir " +
            "entre C ou D! Recommencez...\n";
    public static final String ERR_PAS_TROUVE = "\nAUCUN LIVRE TROUVE.\n";
    public static final String ERR_TITRE = "Erreur, le titre doit contenir au" +
            " moins 5 caracteres valide! Recommencez...\n";
    public static final String ERR_AUTEUR = "Erreur, le nom de l'auteur doit " +
            "contenir au moins 3 caracteres valide! Recommencez...\n";
    public static final String ERR_PERIODE = "Erreur, l'annee doit etre un " +
            "entier entre 1900 et 2019 inclusivement! Recommencez...\n";
    public static final char OPTION_CONJ = 'C';
    public static final char OPTION_DISJ = 'D';
    public static final char CAT_MIN = '0';
    public static final char CAT_MAX = '6';
    public static final char MENU_PRINC_MIN = '1';
    public static final char MENU_PRINC_MAX = '5';
    public static final char RECH_MIN = ' ';
    public static final char RECH_MAX = 'z';
    public static final char RECH_ANNEE_MIN = '0';
    public static final char RECH_ANNEE_MAX = '9';

    public static final String menuPrincipal () {
        String choixMenu;
        int minLength = 1;

        choixMenu = validerChoixMin(MENU_PRINCIPAL, ERR_CHOIX, MENU_PRINC_MIN, MENU_PRINC_MAX, minLength);
        return choixMenu;
    }

    public static final boolean validerChar (String choix, char min, char max) {
        boolean estValide = true;

        for (int i = 0; i < choix.length(); i++) {
            int test = choix.charAt(i);
            if (choix.charAt(i) < min || choix.charAt(i) > max) {
                estValide = false;
            }
        }
        return estValide;
    }

    //prends et valide le choix de l'utilisateur
   public static String validerChoixMax(String msgMenu, String msgErr, char min,
                                     char max, int maxLength) {
        boolean boolChoix;
        String choix;
        do{
            boolChoix = true;
            System.out.print(msgMenu);
            choix = Clavier.lireString().toUpperCase();
            if (choix.isEmpty()) {
                choix = "";
            } else if (choix.length() <= maxLength){
                System.out.println(msgErr);
                boolChoix = false;
            }else if (choix == null || !validerChar(choix, min, max)) {
                System.out.println(msgErr);
                boolChoix = false;
            }
        }while(!boolChoix);
        return choix;
    }

    public static String validerChoixMin(String msgMenu, String msgErr, char min,
                                          char max, int minLength) {
        boolean boolChoix;
        String choix;
        do{
            boolChoix = true;
            System.out.print(msgMenu);
            choix = Clavier.lireString().toUpperCase();
            if (choix.isEmpty()) {
                choix = "";
            } else if (choix.length() > minLength){
                System.out.println(msgErr);
                boolChoix = false;
            }else if (choix == null || !validerChar(choix, min, max)) {
                System.out.println(msgErr);
                boolChoix = false;
            }
        }while(!boolChoix);
        return choix;
    }

    public static String validerRechercheCat () {
        String conjOuDisj;
        int minLength = 1;

        conjOuDisj = validerChoixMin(MSG_CATEGORIES,ERR_CATEGORIES2,
                OPTION_CONJ, OPTION_DISJ, minLength);
        return conjOuDisj;
    }

    public static String validerCategories() {
        String choix = "";
        String categorie;
        String choixCategories = "";
        int minLength = 1;

        while(!choix.equals("0")) {
            choix = validerChoixMin(MSG_ENTREZ_CATEGORIE,
                    ERR_CATEGORIES, CAT_MIN, CAT_MAX,minLength);
            categorie = selecteCategorie(choix);
            if (!choix.equals("0")) {
                choixCategories += categorie + '\t';
            }  else if (choixCategories.isEmpty()) {
                System.out.println(MSG_ANNULEE);
            }

        }
        return choixCategories;
    }

    public static void continuerRech () {
       System.out.println(MSG_ENTREE);
       Clavier.lireFinLigne();
    }

    /*Prends en parametre une ligne du resultat de la recherche et le
    formatte selon la convention donnee*/

    public static String selecteCategorie(String choix) {
        String categorie = "";

        switch(choix) {
            case "1":
                categorie = "SCIENCE FICTION";
                break;
            case "2":
                categorie = "ROMANCE";
                break;
            case "3":
                categorie = "THRILLER";
                break;
            case "4":
                categorie = "POLICIER";
                break;
            case "5":
                categorie = "HUMOUR";
                break;
            case "6":
                categorie = "DRAME";
                break;
        }
        return categorie;
    }
    public static String formatLivre(String resultatSubString) {
        int indexTab;
        String formateSubString = "";

        if (!resultatSubString.isEmpty()) {
            indexTab = resultatSubString.indexOf('\t');
            indexTab = resultatSubString.indexOf('\t', indexTab + 1);
            formateSubString = "- "
                    + resultatSubString.substring(0, indexTab).toUpperCase()
                    + " (";
            indexTab = resultatSubString.indexOf('\t', indexTab + 1);
            formateSubString += resultatSubString.substring(indexTab - 4, indexTab)
                    + "), [ " +
                    resultatSubString.substring(indexTab + 1).replace('\t', ',').toLowerCase() + " ]";
            formateSubString = formatePlaceAnnee(formateSubString);
        }

        return formateSubString;
    }

    public static String formatePlaceAnnee(String formateSubString) {
        String subStringAnnee;
        String formateSubStringPlaceAnnee;
        int indexParenthese;
        int indexTab;

        indexTab = formateSubString.indexOf('\t');
        indexParenthese = formateSubString.indexOf('(');
        subStringAnnee = formateSubString.substring(indexParenthese,
                indexParenthese + 7);
        formateSubStringPlaceAnnee = formateSubString.substring(0, indexTab)
                + " " + subStringAnnee + " " +
                formateSubString.substring(indexTab + 1,
                        formateSubString.indexOf('('))
                + formateSubString.substring(formateSubString.indexOf('['));
        return formateSubStringPlaceAnnee;
    }

    public static String formateResultat (String resultat, int indexFinLigne) {
        String formateResultat = "";
        String formateLigne;

        while (indexFinLigne < resultat.length() - 1) {
            formateLigne = separeLignes(resultat, indexFinLigne);
            formateResultat += formatLivre(formateLigne) + "\n";
            indexFinLigne = resultat.indexOf('\n', indexFinLigne + 1);

        }
        return formateResultat;
    }

    public static void requete (String entree) {

        System.out.println("REQUETE : " + entree);
    }

    public static String requeteCat (char optionCat, String choixCategories) {
        String requete = "";
        String etOu;
        if (!choixCategories.isEmpty()) {
            if (optionCat == 'C') {
                etOu = " et ";
            } else {
                etOu = " ou ";
            }
            requete = "\nREQUETE : " + choixCategories.substring(0, choixCategories
                    .lastIndexOf('\t')).replace
                    ("\t",
                            etOu);
        }
        return requete;
    }

    /*Prends en parametre une ligne du document de references et l'entree recherchee. L'entree
    recherchee est comparee a chaque bloc separe par un espace tab pour trouver s'il est
    contenu dans la ligne visee*/

    //recherche partiel. p-e utiliser un while?
    public static String separeFiche(String subString, int tabVoulu) {
        String compareEntree;
        int indexTab = 0;
        int compteurTab = 0;
        int indexFinFiche;

        while (compteurTab < tabVoulu) {
            indexTab = subString.indexOf('\t', indexTab + 1);
            compteurTab++;
        }

        if (compteurTab >= 3) {
            indexFinFiche = subString.length();
        } else {
            indexFinFiche = subString.indexOf('\t', indexTab + 1);
        }

        compareEntree = subString.substring(indexTab, indexFinFiche);
        compareEntree = compareEntree.trim();
        return compareEntree;
    }

    public static String separeMots (String subString, int indexDebutMot) {
        int indexFinMotIsole;
        String motIsole;

        indexFinMotIsole = subString.indexOf('\t', indexDebutMot + 1);
        motIsole = subString.substring(indexDebutMot, indexFinMotIsole).trim();
        return motIsole;
    }

    public static String separeLignes (String subString, int indexFinLigne) {
        int indexDebutLigne;
        String ligneIsolee;

        indexDebutLigne = indexFinLigne;
        indexFinLigne = subString.indexOf('\n', indexDebutLigne + 1);
        if (indexFinLigne == -1) {
            indexFinLigne = subString.length();
        }
        ligneIsolee = subString.substring(indexDebutLigne, indexFinLigne).trim();
        return ligneIsolee;
    }

    public static boolean estContenu(String compareEntree, String entree) {
        boolean estContenu = false;
        int indexTabCompare = 0;
        String subCompareEntree;


        for (int j = 0; j < compareEntree.length(); j = indexTabCompare) {
            indexTabCompare = compareEntree.indexOf('\t', indexTabCompare + 1);
            if (indexTabCompare < 0) {
                indexTabCompare = compareEntree.length();
            }
            subCompareEntree = compareEntree.substring(j, indexTabCompare);
            subCompareEntree = subCompareEntree.trim();
            if (subCompareEntree.contains(entree) ||
                    subCompareEntree.equalsIgnoreCase(entree)) {
                estContenu = true;
            }
        }
        return estContenu;
    }



        /*Prends en parametre le document de reference bibliotheque et l'entree
    recherchee. L'entree est recherchee a travers le document de reference*/

    //p-e utiliser cette methode pour separer le texte par ligne?
    public static String rechercheEntree(String biblio, String entree, int tabVoulu) {
        String resultatRecherche = "";
        String rechercheSub;
        String smallRechercheSub;
        int indexDebut = 0;
        int indexFin = 0;
        int length = biblio.lastIndexOf('\n');

        while (indexDebut < biblio.lastIndexOf('\n')) {
            indexFin = biblio.indexOf('\n', indexFin + 1 );
            if (indexFin == -1) {
                indexFin = biblio.length();
            }
            rechercheSub = separeLignes(biblio, indexFin).toUpperCase();
            indexDebut = indexFin++;
            smallRechercheSub = separeFiche(rechercheSub, tabVoulu);
            if (estContenu(smallRechercheSub, entree)) {
                resultatRecherche += rechercheSub + '\n';
            }
        }

        /*
        for(int i = 0; i < biblio.length(); i = indexFin) {
            indexDebut = i;
            indexFin = biblio.indexOf('\n', indexDebut);
            if (indexFin >= 0) {

                rechercheSub = biblio.substring(indexDebut, indexFin).toUpperCase();
                smallRechercheSub = separeFiche(rechercheSub, tabVoulu);
                if (estContenu(smallRechercheSub, entree)) {
                    resultatRecherche += rechercheSub + '\n';
                }
                indexFin++;
            }else {
                indexFin = biblio.length() - 1;
            }

        }*/
        if(resultatRecherche.isEmpty()) {
            System.out.println(ERR_PAS_TROUVE);
        }

        return resultatRecherche;
    }

    public static String rechecheCategorieDisjonc(String biblio, String choixCategories, int tabVoulu) {
        String choix;
        String resultat = "";
        String trouveCategorie;
        String trouveCategorieSub;
        String formateResultat = "";
        int indexFinMot;
        int indexDebutMot = 0;
        int indexFinLigne;

        while (indexDebutMot < choixCategories.length() - 1) {
            choix = separeMots(choixCategories, indexDebutMot);
            trouveCategorie = rechercheEntree(biblio, choix, tabVoulu);
            indexFinMot = choixCategories.indexOf('\t', indexDebutMot + 1);
            indexDebutMot = indexFinMot;
            indexFinLigne = 0;
            while (indexFinLigne != -1) {
                trouveCategorieSub = separeLignes(trouveCategorie, indexFinLigne).trim();
                indexFinLigne = trouveCategorie.indexOf('\n', indexFinLigne + 1);
                if (!resultat.contains(trouveCategorieSub)) {
                    resultat += trouveCategorieSub;
                    formateResultat += formatLivre(trouveCategorieSub) + "\n";
                }
            }

        }
        return formateResultat;
    }

    public static String rechercheCategorieConjonc(String biblio,
                                                   String choixCategories,
                                                   int tabVoulu) {
        String choix;
        String resultat = "";
        String ficheRecherche;
        String trouveCategorieSub;
        int indexFinLigne = 0;
        int indexDebutMot;
        boolean estConjonc;

        while (indexFinLigne != -1 && indexFinLigne < biblio.length()) {
            ficheRecherche = separeLignes(biblio, indexFinLigne).trim().toUpperCase();
            indexFinLigne = biblio.indexOf('\n', indexFinLigne
                    + 1);
            indexDebutMot = 0;
            estConjonc = true;
            while (indexDebutMot < choixCategories.length() - 1) {
                choix = separeMots(choixCategories, indexDebutMot);
                trouveCategorieSub = separeFiche(ficheRecherche,tabVoulu);
                indexDebutMot = choixCategories.indexOf('\t', indexDebutMot + 1);
                if (!trouveCategorieSub.contains(choix)) {
                    estConjonc = false;
                }
            }
            if (estConjonc) {
                resultat += formatLivre(ficheRecherche) + "\n";
            }
        }

        return resultat;
    }

    public static String rechercheTitre (String biblio, int tabVoulu, int maxLength) {
        String entreeTitre;
        String rechercheTitre = "";
        String resultatRech;
        int indexFinLigne = 0;
        boolean continuer;

        do {
            entreeTitre = validerChoixMax(MSG_TITRE, ERR_TITRE, RECH_MIN, RECH_MAX,
                    maxLength);
            if (entreeTitre.isEmpty()) {
                continuer = true;
                System.out.println(MSG_ANNULEE);

            } else {
                System.out.println("Le titre contient l'expression " +
                        entreeTitre);
                continuer = true;
                rechercheTitre = rechercheEntree(biblio, entreeTitre,
                        tabVoulu);
            }
        } while (!continuer);
        resultatRech = formateResultat(rechercheTitre, indexFinLigne);
        return resultatRech;
    }

    public static String rechercheAuteur (String biblio, int tabVoulu, int maxLength) {
        String entreeAuteur;
        String rechercheAuteur = "";
        String resultatRech;
        int indexFinLigne = 0;
        boolean continuer;

        do {
            continuer = false;
            entreeAuteur = validerChoixMax(MSG_AUTEUR, ERR_AUTEUR, RECH_MIN,
                    RECH_MAX, maxLength);
            requete(entreeAuteur);
            if (!entreeAuteur.isEmpty()) {
                continuer = true;
                rechercheAuteur = rechercheEntree(biblio, entreeAuteur, tabVoulu);

            } else {
                continuer = true;
                System.out.println(MSG_ANNULEE);
            }
        } while (!continuer);
        resultatRech = formateResultat(rechercheAuteur, indexFinLigne);
        return resultatRech;
    }

    public static String rechercheAnnee (String biblio, int tabVoulu, int minLength) {
        String entreeAnnee;
        String rechercheAnnee = "";
        String resultatRech = "";
        int indexFinLigne = 0;
        boolean continuer = false;

        do {
            entreeAnnee = validerChoixMin(MSG_PERIODE, ERR_PERIODE,
                    RECH_ANNEE_MIN, RECH_ANNEE_MAX, minLength );
            requete(entreeAnnee);
            if (entreeAnnee.equals("0")) {
                continuer = true;
                System.out.println(MSG_ANNULEE);
            } else {
                if (entreeAnnee.charAt(0) == '1' && entreeAnnee.charAt(1) == '9' ||
                        (entreeAnnee.charAt(0) == '2' && entreeAnnee.charAt(1) == '0' &&
                                entreeAnnee.charAt(2) == '1')) {
                    continuer = true;
                    rechercheAnnee = rechercheEntree(biblio, entreeAnnee, tabVoulu);
                }
                resultatRech = formateResultat(rechercheAnnee, indexFinLigne);

            }

        } while (!continuer);

        return resultatRech;
    }

    public static void main (String[] params) {
        String choixMenu;
        String conjOuDisj;
        String biblio;
        String choixCategories;
        String resultatRech;
        int maxLength;
        int tabVoulu;
        int minLength;
        boolean finProgramme = false;

        System.out.println(MSG_DEBUT);
        biblio = UtilitaireTP2.lireBibliotheque();

        while (!finProgramme) {
            choixMenu = menuPrincipal();
            if (!choixMenu.isEmpty()) {
                switch (choixMenu) {
                    case "1":
                        conjOuDisj = validerRechercheCat();
                        tabVoulu = 3;
                        if (conjOuDisj.equals("C")) {
                            System.out.println(MENU_CATEGORIES);
                            choixCategories = validerCategories();

                            if (!choixCategories.isEmpty()) {
                                System.out.println(requeteCat(OPTION_CONJ,
                                        choixCategories));
                                resultatRech = rechercheCategorieConjonc(biblio,
                                        choixCategories, tabVoulu);
                                if (resultatRech.isEmpty()) {
                                    System.out.println(ERR_PAS_TROUVE);
                                    continuerRech();
                                } else {
                                    System.out.println(MSG_RESULTAT + "\n" + resultatRech);
                                    continuerRech();
                                }

                            }

                        } else {
                            System.out.println(MENU_CATEGORIES);
                            choixCategories = validerCategories();

                            if (!choixCategories.isEmpty()) {
                                System.out.println(requeteCat(OPTION_DISJ,
                                        choixCategories));
                                resultatRech = rechecheCategorieDisjonc(biblio,
                                        choixCategories, tabVoulu);
                                if (resultatRech.isEmpty()) {
                                    System.out.println(ERR_PAS_TROUVE);
                                    continuerRech();
                                } else {
                                    System.out.println(MSG_RESULTAT + "\n" + resultatRech);
                                    continuerRech();
                                }

                            }
                        }

                        break;

                    case "2":
                        maxLength = 4;
                        tabVoulu = 0;
                        resultatRech = rechercheTitre(biblio, tabVoulu, maxLength);
                        if (!resultatRech.isEmpty()) {
                            System.out.println();
                            System.out.println(MSG_RESULTAT + "\n" + resultatRech);
                            continuerRech();
                        }
                        break;

                    case "3":
                        maxLength = 2;
                        tabVoulu = 1;
                        resultatRech = rechercheAuteur(biblio, tabVoulu, maxLength);
                        if (!resultatRech.isEmpty()) {
                            System.out.println(MSG_RESULTAT + "\n" + resultatRech);
                            continuerRech();
                        }
                        break;

                    case "4":
                        minLength = 5;
                        tabVoulu = 2;
                        resultatRech = rechercheAnnee(biblio, tabVoulu, minLength);
                        if (!resultatRech.equals("0") && !resultatRech.isEmpty()) {
                            System.out.println(MSG_RESULTAT + "\n" + resultatRech);
                            continuerRech();
                        }
                        break;

                    case "5":
                        finProgramme = true;
                        break;

                }
            } else {
                System.out.println(ERR_CHOIX);
            }
        }
        System.out.println(MSG_FIN);
    }


}