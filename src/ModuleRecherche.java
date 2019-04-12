/**
 * I N F 1 1 2 0
 *
 *
 *
 * @author Ingrid Blemur
 * @version 26/03/2019
 *
 *
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
            "\t1. Science fiction\n"+
            "\t2. Romance\n" +
            "\t3. Thriller\n" +
            "\t4. Policier\n" +
            "\t5. Humour\n" +
            "\t6. Drame\n" +
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
            "\n";
    public static final String MSG_CATEGORIES2 = "Recherche par (C)onjonction ou " +
            "(D)isjonction : ";
    public static final String MSG_TITRE = "\n*** RECHERCHE PAR TITRE ***\n" +
            "\n";
    public static final String MSG_TITRE2 = "Entrez le titre ou une partie du " +
            "titre (<ENTREE> pour terminer) : ";
    public static final String MSG_ANNULEE = "\nRECHERCHE ANNULEE.\n";
    public static final String MSG_AUTEUR = "\n*** RECHERCHE PAR AUTEUR ***\n" +
            "\n";
    public static final String MSG_AUTEUR2 = "Entrez le nom de l'auteur (<ENTREE>" +
            " pour terminer) : ";
    public static final String MSG_PERIODE1 = "\n*** RECHERCHE PAR PERIODE " +
            "***\n" +
            "\n";
    public static final String MSG_PERIODE2 = "Entrez l'annee du debut de la " +
            "periode (0 pour terminer) : ";
    public static final String MSG_PERIODE3 = "Entrez l'annee de la fin de la " +
            "periode (0 pour terminer) : ";
    public static final String MSG_RESULTAT = "\nRESULTAT(S) DE RECHERCHE :\n"
            + "--------------------------";
    public static final String MSG_REQUETE_TITRE = "\nREQUETE : Le titre " +
            "contient l'expression ";
    public static final String MSG_REQUETE_AUTEUR = "\nREQUETE : Le nom de " +
            "l'auteur est ";
    public static final String MSG_REQUET_PERIODE = "\nREQUETE : L'annee est " +
            "entre ";

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

    /*Presente le menu principal, saisi et valide le choix de l'utilisateur*/
    public static final String menuPrincipal () {
        String choixMenu;
        int minLength = 1;

        choixMenu = validerChoixMin(MENU_PRINCIPAL, ERR_CHOIX, MENU_PRINC_MIN,
                MENU_PRINC_MAX, minLength);
        return choixMenu;
    }

    /*Valide que chaque charactere d'une entree donnee en parametre est bien
    entre le min et le max donne */
    public static final boolean validerChar (String choix, char min, char max) {
        boolean estValide = true;

        for (int i = 0; i < choix.length(); i++) {
            if (choix.charAt(i) < min || choix.charAt(i) > max) {
                estValide = false;
            }
        }
        return estValide;
    }

    /*prends et valide le choix de l'utilisateur et verifie si l'entree donnee
    n'est pas plus petit que le nombre maximum de charactere donne */
   public static String validerChoixMax(String msgMenu, String msgErr, char min,
                                     char max, int maxLength) {
        boolean boolChoix;
        String choix;
        do{
            boolChoix = true;
            System.out.print(msgMenu);
            choix = Clavier.lireString().toUpperCase();
            if (choix == null) {
                System.out.println(msgErr);
                boolChoix = false;
            }else if (choix.isEmpty()) {
                choix = "";
            } else if (!validerChar(choix, min, max) || choix
                    .length() <= maxLength) {
                System.out.println(msgErr);
                boolChoix = false;
            }
        }while(!boolChoix);
        return choix;
    }

    /*prends et valide le choix de l'utilisateur et verifie que l'entree est
    bien plus petit que la limite de characteres donne */
    public static String validerChoixMin(String msgMenu, String msgErr, char min,
                                          char max, int minLength) {
        boolean boolChoix;
        String choix;
        do{
            boolChoix = true;
            System.out.print(msgMenu);
            choix = Clavier.lireString().toUpperCase();
            if (choix == null || !validerChar(choix, min, max) || choix
                    .length() > minLength) {
                System.out.println(msgErr);
                boolChoix = false;
            } else if (choix.isEmpty()) {
                choix = "";
            }
        }while(!boolChoix);
        return choix;
    }

    /*demande a l'utilisateur de choisir entre 'C' ou 'D' et valide qu'aucun
    autre charactere que ceux-la soit entre*/
    public static String validerRechercheCat () {
        String conjOuDisj = "";
        int minLength = 1;
        boolean continuer = false;

        while (!continuer) {
            conjOuDisj = validerChoixMin(MSG_CATEGORIES2, ERR_CATEGORIES2,
                    OPTION_CONJ, OPTION_DISJ, minLength);
            if (conjOuDisj.equals("")) {
                System.out.println(ERR_CATEGORIES2);
            } else {
                continuer = true;
            }
        }
        return conjOuDisj;
    }

    /*demande et valide le choix de categorie de l'utilisateur et retourne le
    choix en mot et majuscule*/
    public static String validerCategories() {
        String choix = "";
        String categorie;
        String choixCategories = "";
        int minLength = 1;

        while(!choix.equals("0")) {
            choix = validerChoixMin(MSG_ENTREZ_CATEGORIE,
                    ERR_CATEGORIES, CAT_MIN, CAT_MAX,minLength);

            if (choix == null || choix.isEmpty()) {
                System.out.println(ERR_CATEGORIES);
            }  else if (!choix.equals("0")) {
                categorie = selecteCategorie(choix);
                choixCategories += categorie + '\t';
            } else if (choix.equals("0") && choixCategories.isEmpty()) {
                System.out.println(MSG_ANNULEE);
            }

        }
        return choixCategories;
    }

    /*demande et valide que l'annee entree soit entre une limite donnee. Peut
    etre utilise pour l'annee de debut et l'annee de fin*/
    public static String validerAnnee (int minLength, boolean anneeFin) {
        String entreeAnnee = "";
        int intAnnee;
        boolean continuer = false;

        while (!continuer) {
            if (!anneeFin) {
                entreeAnnee = validerChoixMin(MSG_PERIODE2, ERR_PERIODE,
                        RECH_ANNEE_MIN, RECH_ANNEE_MAX, minLength);
            } else {
                entreeAnnee = validerChoixMin(MSG_PERIODE3, ERR_PERIODE,
                        RECH_ANNEE_MIN, RECH_ANNEE_MAX, minLength);
            }
            if (entreeAnnee.equals("0")) {
                System.out.println(MSG_ANNULEE);
                continuer = true;
            } else if (entreeAnnee.isEmpty()) {
                System.out.println(ERR_PERIODE);
            } else {
                intAnnee = Integer.parseInt(entreeAnnee);
                 if (entreeAnnee.length() < 4) {
                    System.out.println(ERR_PERIODE);

                } else if ((intAnnee < 1900 || intAnnee > 2019)) {
                    System.out.println(ERR_PERIODE);

                } else {
                    continuer = true;
                }
            }

        }
        return entreeAnnee;
    }

    /*pause le programme*/
    public static void continuerRech () {
       System.out.println(MSG_ENTREE);
       Clavier.lireFinLigne();
    }

    /*prends le choix categorie valide de l'utilisateur et le paire a la
    categorie en forme de mot*/
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

    /*formatte la ligne donnee*/
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

    /*place l'annee dans la fiche a la bonne place*/
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

    /*formatte le groupe de resultat donne*/
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

    /*donne la requete categorie selon conjonction ou disjonction*/
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

    /*prend une ligne du document en parametre et isole la partie voulue*/
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

    /*isole chaque mot dans une ligne donnee*/
    public static String separeMots (String subString, int indexDebutMot) {
        int indexFinMotIsole;
        String motIsole;

        indexFinMotIsole = subString.indexOf('\t', indexDebutMot + 1);
        motIsole = subString.substring(indexDebutMot, indexFinMotIsole).trim();
        return motIsole;
    }

    /*separe chaque ligne d'un document donne*/
    public static String separeLignes (String subString, int indexFinLigne) {
        int indexDebutLigne;
        String ligneIsolee;

        indexDebutLigne = indexFinLigne;
        indexFinLigne = subString.indexOf('\n', indexDebutLigne + 1 );
        if (indexFinLigne == -1) {
            indexFinLigne = subString.length();
        }
        ligneIsolee = subString.substring(indexDebutLigne, indexFinLigne).trim();
        return ligneIsolee;
    }

    /*valide l'entree donne avec la partie obtenue par separeFiche*/
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
    public static String rechercheEntree(String biblio, String entree,
                                         int tabVoulu, boolean motsExact,
                                         boolean cachePasResultat) {
        String resultatRecherche = "";
        String rechercheSub;
        String smallRechercheSub;
        String nomAuteur;
        int indexFin = 0;
        int indexNom;


        while (indexFin < biblio.length() && indexFin != -1) {
            if (indexFin != -1) {
                rechercheSub = separeLignes(biblio, indexFin).toUpperCase();
                indexFin = biblio.indexOf('\n', indexFin + 1);
                smallRechercheSub = separeFiche(rechercheSub, tabVoulu);
                if (motsExact) {
                    indexNom = smallRechercheSub.lastIndexOf(' ');
                    nomAuteur = smallRechercheSub.substring(indexNom).trim();
                    if (nomAuteur.equals(entree)) {
                        resultatRecherche += rechercheSub + '\n';
                    }
                } else if (estContenu(smallRechercheSub, entree)) {
                    resultatRecherche += rechercheSub + '\n';
                }
            }
        }

        if(resultatRecherche.isEmpty() && cachePasResultat) {
            System.out.println(ERR_PAS_TROUVE);
            continuerRech();
        }

        return resultatRecherche;
    }

    /*recherche la catagorie choisie par l'utilisateur et trouve la ligne
    correspondante de facon disjonctive*/
    public static String rechecheCategorieDisjonc(String biblio,
                                                  String choixCategories,
                                                  int tabVoulu) {
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
            trouveCategorie = rechercheEntree(biblio, choix, tabVoulu, false,
                    true);
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


    /*demande a l'utilisateur d'entrer un choix de categorie, verifie l'entree
    et le cherche dans le document donne de facon disjonctive*/
    public static String mainRechercheDisjonc (String biblio, int tabVoulu) {
        String resultatRech = "";
        String choixCategories;

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
        return resultatRech;
    }

    /*recherche la catagorie choisie par l'utilisateur et trouve la ligne
    correspondante de facon conjonctive*/
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

    /*demande a l'utilisateur d'entrer un choix de categorie, verifie l'entree
    et le cherche dans le document donne de facon conjonctive*/
    public static String mainRechecheConjonc (String biblio, int tabVoulu) {
        String resultatRech = "";
        String choixCategories;

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
        return resultatRech;
    }

    /*demande a l'utilisateur d'entrer un titre er recherche l'entree dans le document donne*/
    public static String rechercheTitre (String biblio, int tabVoulu, int maxLength) {
        String entreeTitre;
        String rechercheTitre = "";
        String resultatRech;
        int indexFinLigne = 0;
        boolean continuer;

        do {
            entreeTitre = validerChoixMax(MSG_TITRE2, ERR_TITRE, RECH_MIN, RECH_MAX,
                    maxLength);
            if (entreeTitre.isEmpty()) {
                continuer = true;
                System.out.println(MSG_ANNULEE);

            } else {
                System.out.println(MSG_REQUETE_TITRE + entreeTitre);
                continuer = true;
                rechercheTitre = rechercheEntree(biblio, entreeTitre,
                        tabVoulu, false, true);
            }
        } while (!continuer);
        resultatRech = formateResultat(rechercheTitre, indexFinLigne);
        return resultatRech;
    }

    /*demande a l'utilisateur d'entrer un nom d'auteur qui sera ensuite
    chercher a travers le document donne avec le nom d'auteur exact*/
    public static String rechercheAuteur (String biblio, int tabVoulu, int maxLength) {
        String entreeAuteur;
        String rechercheAuteur = "";
        String resultatRech;
        int indexFinLigne = 0;
        boolean continuer;

        do {
            continuer = false;
            entreeAuteur = validerChoixMax(MSG_AUTEUR2, ERR_AUTEUR, RECH_MIN,
                    RECH_MAX, maxLength);
            System.out.println(MSG_REQUETE_AUTEUR + entreeAuteur);
            if (!entreeAuteur.isEmpty()) {
                continuer = true;
                rechercheAuteur = rechercheEntree(biblio, entreeAuteur,
                        tabVoulu, true, true);

            } else {
                continuer = true;
                System.out.println(MSG_ANNULEE);
            }
        } while (!continuer);
        resultatRech = formateResultat(rechercheAuteur, indexFinLigne);
        return resultatRech;
    }

    /*prends l'annee entree par l'utilisateur et la transforme en l'annee
    suivante*/
    public static String anneeInt (String annee) {
        int anneeInt;
        String anneeStr = "";

        anneeInt = Integer.parseInt(annee);
        anneeInt++;
        anneeStr += anneeInt;
        return anneeStr;
    }

    /*prends en parametre l'annee du debut et l'annee de la fin de la periode
     a chercher dans le document donnee*/
    public static String rechercheAnnee (String biblio, int tabVoulu,
                                         String anneeDebut, String anneeFin,
                                         int minLength) {
        String anneePeriode;
        String rechercheAnnee;
        String resultatRech = "";
        String resultatFormate = "";
        int intAnneeDebut;
        int intAnneFin;
        int indexFinLigne = 0;
        boolean continuer = false;

        while (!continuer) {
            intAnneeDebut = Integer.parseInt(anneeDebut);
            intAnneFin = Integer.parseInt(anneeFin);
            if (intAnneeDebut == intAnneFin) {
                System.out.println("\nREQUETE : L'annee est " + anneeDebut);
                resultatRech = rechercheEntree(biblio, anneeDebut, tabVoulu,
                        false, true);
                if (!resultatRech.isEmpty()) {
                    resultatFormate += formateResultat(resultatRech, indexFinLigne);
                }
                continuer = true;
            } else if (intAnneeDebut < intAnneFin) {
                System.out.println(MSG_REQUET_PERIODE + anneeDebut + " et " +
                        anneeFin);
                anneeFin = anneeInt(anneeFin);
                anneePeriode = anneeDebut;
                while (!anneePeriode.equals(anneeFin)) {
                    rechercheAnnee = rechercheEntree(biblio, anneePeriode, tabVoulu,
                            false, false);
                    resultatRech += rechercheAnnee;
                    anneePeriode = anneeInt(anneePeriode);
                }
                if (!resultatRech.isEmpty()) {
                    resultatFormate += formateResultat(resultatRech, indexFinLigne);
                } else {
                    System.out.println(ERR_PAS_TROUVE);
                    continuerRech();

                }
                continuer = true;
            } else {
                System.out.println("Erreur, l'annee doit etre un entier entre " +
                        anneeDebut + " et 2019 inclusivement! Recommencez...\n");
                    anneeFin = validerAnnee(minLength, true);
            }
        }
        return resultatFormate;
    }

    public static void main (String[] params) {
        String choixMenu;
        String conjOuDisj;
        String biblio;
        String resultatRech;
        String entreeAnneeDebut;
        String entreeAnneeFin;
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
                        System.out.println(MSG_CATEGORIES);
                        conjOuDisj = validerRechercheCat();
                        tabVoulu = 3;
                        if (conjOuDisj.equals("C")) {
                            mainRechecheConjonc(biblio, tabVoulu);
                        }  else if (conjOuDisj.equals("D")){
                            mainRechercheDisjonc(biblio, tabVoulu);
                        } else {
                            System.out.println(ERR_CATEGORIES);
                        }
                        break;

                    case "2":
                        maxLength = 4;
                        tabVoulu = 0;
                        System.out.println(MSG_TITRE);
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
                        System.out.println(MSG_AUTEUR);
                        resultatRech = rechercheAuteur(biblio, tabVoulu, maxLength);
                        if (!resultatRech.isEmpty()) {
                            System.out.println(MSG_RESULTAT + "\n" + resultatRech);
                            continuerRech();
                        }
                        break;

                    case "4":
                        minLength = 5;
                        tabVoulu = 2;
                        System.out.println(MSG_PERIODE1);
                        entreeAnneeDebut = validerAnnee(minLength, false);
                        if (!entreeAnneeDebut.equals("0")) {
                            entreeAnneeFin = validerAnnee(minLength, true);
                            if (!entreeAnneeFin.equals("0")) {
                                resultatRech = rechercheAnnee(biblio, tabVoulu,
                                        entreeAnneeDebut, entreeAnneeFin, minLength);
                                if (!resultatRech.equals("0") && !resultatRech.isEmpty()) {
                                    System.out.println(MSG_RESULTAT + "\n" + resultatRech);
                                    continuerRech();
                                }
                            }
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