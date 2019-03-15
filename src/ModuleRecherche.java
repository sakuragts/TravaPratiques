/**
 * I N F 1 1 2 0
 *
 * Decrivez votre classe LaboBoucles2B ici.
 *
 * @author Ingrid Blemur
 * @version 13/03/2019
 *
 * BLEI08547903
 * blemur.ingrid@courrier.uqam.ca
 */

public class ModuleRecherche {
    public static final String MENU_PRINCIPAL = "-----------------\n" +
            "MENU DE RECHERCHE\n" +
            "-----------------\n" +
            "1. Recherche par categorie(s)\n" +
            "2. Recherche par titre\n" +
            "3. Recherche par auteur\n" +
            "4. Recherche par periode\n" +
            "5. Quitter\n" +
            "\n" +
            "Entrez votre choix : ";
    public static final String MENU_CATEGORIES = "LISTE DES CATEGORIES : \n" +
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
            "periode de publication.";
    public static final String MSG_FIN = "FIN DU PROGRAMME. AU REVOIR!";
    public static final String MSG_ENTREE = "Tapez <ENTREE> pour revenir au menu de recherche... ";
    public static final String MSG_CATEGORIES = "*** RECHERCHE PAR CATEGORIE(S) ***"
            + "Recherche par (C)onjonction ou (D)isjonction : ";
    public static final String MSG_TITRE = "*** RECHERCHE PAR TITRE ***\n" +
            "\n" +
            "Entrez le titre ou une partie du titre (<ENTREE> pour terminer) : ";
    public static final String MSG_ANNULEE = "RECHERCHE ANNULEE.";
    public static final String MSG_AUTEUR = "*** RECHERCHE PAR AUTEUR ***\n" +
            "\n" +
            "Entrez le nom de l'auteur (<ENTREE> pour terminer) : ";
    public static final String MSG_PERIODE = "*** RECHERCHE PAR PERIODE ***\n" +
            "\n" +
            "Entrez l'annee du debut de la periode (0 pour terminer) : ";
    public static final String MSG_RESULTAT = "RESULTAT(S) DE RECHERCHE :\n"
            + "--------------------------";
    public static final String ERR_CHOIX = "Erreur, choix invalide! Recommencez...";
    public static final String ERR_CATEGORIES = "Erreur, numero de categorie invalide! Recommencez...";
    public static final String ERR_PAS_TROUVE = "AUCUN LIVRE TROUVE.";

    //prends et valide le choix de l'utilisateur
   public static String validerChoix(String msgMenu, String msgErr, char min, char max) {
        boolean boolChoix;
        String choix;
        do{
            boolChoix = true;
            System.out.print(msgMenu);
            choix = Clavier.lireString();
            if(choix.length() != 1){
                System.out.println(msgErr);
                boolChoix = false;
            }else if(choix == null ||
                    choix.charAt(0) < min || choix.charAt(0) > max) {
                System.out.println(msgErr);
                boolChoix = false;
            }
        }while(!boolChoix);
        return choix;
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
        String formateSubString;

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



    /*Prends en parametre une ligne du document de references et l'entree recherchee. L'entree
    recherchee est comparee a chaque bloc separe par un espace tab pour trouver s'il est
    contenu dans la ligne visee*/

    //recherche partiel. p-e utiliser un while?
    public static String separeFiche(String subString, int tabVoulu) {
        String compareEntree;
        int indexTab = 0;
        int compteurTab = 0;

        while (compteurTab < tabVoulu) {
            indexTab = subString.indexOf('\t', indexTab + 1);
            compteurTab++;
        }
        compareEntree = subString.substring(indexTab);
        compareEntree = compareEntree.trim();
        return compareEntree;
    }

    public static boolean estContenu(String compareEntree, String entree) {
        boolean estContenu = false;
        int indexTabCompare = 0;
        int indexTabEntree = 0;
        int indexTabEntree2 = 0;
        String subCompareEntree;
        String subEntree = "";

        do {
            if (entree.indexOf('\t')!= -1) {
                indexTabEntree2 = indexTabEntree;
                indexTabEntree = entree.indexOf('\t', indexTabEntree);
                subEntree = entree.substring(indexTabEntree2, indexTabEntree);
                indexTabEntree++;
            }

            for (int j = 0; j < compareEntree.length(); j = indexTabCompare) {
                indexTabCompare = compareEntree.indexOf('\t', indexTabCompare + 1);
                if (indexTabCompare < 0) {
                    indexTabCompare = compareEntree.length();
                }
                subCompareEntree = compareEntree.substring(j, indexTabCompare);
                subCompareEntree = subCompareEntree.trim();
                if (subCompareEntree.contains(subEntree) ||
                        subCompareEntree.compareToIgnoreCase(subEntree) == 0) {
                    estContenu = true;
                }
            }
        } while(indexTabEntree != -1);
        return estContenu;
    }


    /*Prends en paramettre le document de reference bibliotheque et l'entree
    recherchee. L'entree est recherchee a travers le document de reference*/

    //p-e utiliser cette methode pour separer le texte par ligne?
    public static String rechercheEntree(String biblio, String entree) {
        String resultatRecherche = "";
        String rechercheSub;
        String smallRechercheSub;
        int indexDebut;
        int indexFin;

        for(int i = 0; i < biblio.length(); i = indexFin) {
            indexDebut = i;
            indexFin = biblio.indexOf('\n', indexDebut);
            if (indexFin >= 0) {
                rechercheSub = biblio.substring(indexDebut, indexFin);
                smallRechercheSub = separeFiche(rechercheSub, 3);
                if (estContenu(smallRechercheSub, entree)) {
                    resultatRecherche += rechercheSub + '\n';
                }
                indexFin++;
            }else {
                indexFin = biblio.length();
            }

        }
        if(resultatRecherche.isEmpty()) {
            System.out.println(ERR_PAS_TROUVE);
        }

        return resultatRecherche;
    }

    public static String validerCategories() {
        String choix = "";
        String categories = "";

        while(!choix.equals("0")) {
            choix = validerChoix(MSG_ENTREZ_CATEGORIE, ERR_CATEGORIES, '0', '6');
            categories += selecteCategorie(choix) + '\t';
        }
        return categories;
    }

    public static String rechecheCategorieDisjonc(String biblio) {
        String choix = "";
        String resultat = "";
        String categorie;
        String trouveCategorie;
        String trouveCategorieSub;
        int indexFinLigne;
        int indexDebutLigne;


        while(!choix.equals("0")) {
            choix = validerChoix(MSG_ENTREZ_CATEGORIE,
                    ERR_CATEGORIES, '0', '6');
            categorie = selecteCategorie(choix);
            trouveCategorie = rechercheEntree(biblio, categorie);
            indexFinLigne = 0;
            if (!choix.equals("0")) {
                while (indexFinLigne != -1 || indexFinLigne > trouveCategorie.length()) {
                indexDebutLigne = indexFinLigne;
                indexFinLigne = trouveCategorie.indexOf('\n', indexDebutLigne + 1);
                if (indexFinLigne != -1) {
                    trouveCategorieSub = trouveCategorie.substring(indexDebutLigne, indexFinLigne);
                    indexFinLigne++;
                    if (!resultat.contains(trouveCategorieSub)) {
                        resultat += formatLivre(trouveCategorieSub) + "\n";
                    }
                }
            }
        }
        }
        return resultat;
    }

    public static String rechercheCategorieConjonc(String biblio) {
        String choix = "";
        String categorie = "";
        String rechecheCategorie = "";
        String resultat = "";
        String trouveCategorie;
        String trouveCategorieSub;
        int indexFinLigne = 0;
        int indexDebutLigne;

        while(!choix.equals("0")) {
            choix = ModuleRecherche.validerChoix(ModuleRecherche.MSG_ENTREZ_CATEGORIE,
                    ModuleRecherche.ERR_CATEGORIES, '0', '6');
            categorie = selecteCategorie(choix);
            rechecheCategorie += choix;
        }
        trouveCategorie = rechercheEntree(biblio, categorie);
        if (!choix.equals("0")) {
            while (indexFinLigne != -1 || indexFinLigne > trouveCategorie.length()) {
                indexDebutLigne = indexFinLigne;
                indexFinLigne = trouveCategorie.indexOf('\n', indexDebutLigne + 1);
                if (indexFinLigne != -1) {
                    trouveCategorieSub = trouveCategorie.substring(indexDebutLigne, indexFinLigne);
                    indexFinLigne++;
                    if (!resultat.contains(trouveCategorieSub)) {
                        resultat += ModuleRecherche.formatLivre(trouveCategorieSub) + "\n";
                    }
                }
            }
        }
        return resultat;
    }

}