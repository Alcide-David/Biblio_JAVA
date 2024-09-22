//= new JMenu("File");
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_Final;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alcide
 */
public class Bibliotheque_URH {

    /*                      NOTE
     Afin de trouver certains resultats lors de nos requetes ex :
     --Trouver un adherent inserer dans l'ancienne classe Gestion_des_Adherents,
     et modifier certains de ces attributs lorqu'il effectue un pret dans l'ancienne 
     classe Gestion_des_livres. trouver l'adherent en question s'est averer etre un casse tete.
    
    
    
     */
    // Declaration des variables qui seront utilises pour :
    // ---> les Livres
    String titre, auteur, categorie, date_sortie, code_livre, code_livre_up;
    int exemplaire;
    // ---> les Adherents
    String nom, prenom, sexe, faculte, code, code_up;
    //--> Les prets
    String pcode_ad, pnom, pprenom, psexe, pfaculte, pcode_liv, ptit_liv, pnom_auteur;
    //--> um administrateur
    String nom_admin, prenom_admin, code_admin;

    // Instanciation des classes :
    // ---> Scanner
    Scanner cv = new Scanner(System.in);
    // ---> Livres
    Livre bouquin = new Livre(code_livre, titre, auteur, categorie, date_sortie, exemplaire);
    // ---> Adherents
    Adherent personnes = new Adherent(code, nom, prenom, sexe, faculte);
    // ---> Prets
    Pret emprunt_livre = new Pret(pcode_ad, pnom, pprenom, psexe, pfaculte, pcode_liv, pnom_auteur);

    // Creation d'ArrayList pour :
    // ---> stocker les livres
    ArrayList<Livre> ensemble_livre = new ArrayList<>();
    // ---> Pour stocker les adherents
    ArrayList<Adherent> ensemble_adherent = new ArrayList<>();
    // ---> pour stocker les prets
    ArrayList<Pret> ensemble_pret = new ArrayList<>();
    // Pour stocker les administrateurs
    ArrayList<Administrateur> ensemble_administrateur = new ArrayList<>();

    //Insertion Automatique de Livre
    public void Ajout_auto_livre() {
        Livre bouquin1 = new Livre("L-01", "Les oiseaux", "Alcide David", "Roman", "10 juin 1765", 5);
        ensemble_livre.add(bouquin1);
        Livre bouquin2 = new Livre("L-02", "L'ile bleu", "Bruno Cavey", "Magasine", "2 Octobre 1876", 4);
        ensemble_livre.add(bouquin2);
        Livre bouquin3 = new Livre("L-03", "Allo le Foulard", "Marie Labelle", "Drame", "10 Mai 1432", 3);
        ensemble_livre.add(bouquin3);
    }
    //Insertion Automatique d;Adherent
    public void Ajout_auto_ad() {
        Adherent personnes1 = new Adherent("A-01", "Massey", "Rothschild", "Masculin", "FSI");
        ensemble_adherent.add(personnes1);
        Adherent personnes2 = new Adherent("A-02", "Cerisier", "Rosemana", "Feminin", "FSI");
        ensemble_adherent.add(personnes2);
        Adherent personnes3 = new Adherent("A-03", "Clervoyant", "Potensky", "Masculin", "FSI");
        ensemble_adherent.add(personnes3);
    }

    // Insertion automatique d'un administrateur
    public void Ajout_auto_Administrateur() {
        nom_admin = "Etienne";
        prenom_admin = "Roberson";
        code_admin = "Admin-001";
    }

    //Methode consrvant le menu principal
    public void Menu() {

        System.out.println("                *===============================================================*");
        System.out.println("                |             -- Menu principal de la bibliotheque --           |");
        System.out.println("                |       --------------------------------------------------      |");
        System.out.println("                |       -> Veuillez choisir une des options suivantes:          |");
        System.out.println("                |                                                               |");
        System.out.println("                |  --> Appuyer sur :                                            |");
        System.out.println("                |           0 -- Pour passer a la Gestion des adherents         |");
        System.out.println("                |           1 -- Pour passer a la gestion des livres            |");
        System.out.println("                |                                                               |");
        System.out.println("                | -->  Presser 2 pour :                                         |");
        System.out.println("                |          |-> Modifier le statut d'un livre                    |");
        System.out.println("                |          |-> Afficher la listes des prets                     |");
        System.out.println("                |                                                               |");
        System.out.println("                |  --> Pour quittter l'application :                            |");
        System.out.println("                |           Appuyer sur la touche 3                             |");
        System.out.println("                |                                                               |");
        System.out.println("                *===============================================================*\n");
        String option_pret;
        do {
            System.out.print("Inserer le chiffre correspondant a votre choix :\n--->  ");
            option_pret = cv.nextLine();

            switch (option_pret) {
                case "0": {
                    Menu_Adherent();
                    System.out.println("\n");
                }
                break;
                case "1": {
                    Menu_livre();
                    Menu();
                    System.out.println("\n");
                }
                break;
                case "2": {
                    Menu_statut();

                    System.out.println("\n");
                }
                break;
            }
        } while (!option_pret.equals("3"));
    }

    //               LIGNES DE CODE POUR LA GESTION DES ADHERENTS
    //Methode de sous-menu pour gerer les adherents
    public void Menu_Adherent() {
        System.out.println("\n                                - Affichage du menu d'adherent -            ");
        System.out.println("                *===============================================================*");
        System.out.println("                |     --Acces aux differentes adherents de la bibliotheque--    |");
        System.out.println("                |       --------------------------------------------------      |");
        System.out.println("                |       -> Veuillez choisir une des options suivantes:          |");
        System.out.println("                | 0 - Pour retourner au Menu Principal                          |");
        System.out.println("                | 1 - Pour ajouter des Adherents a la bibliotheque              |");
        System.out.println("                | 2 - Pour afficher l'ensemble des Adherents de la bibliotheque |");
        System.out.println("                | 3 - Pour rechercher un adherent specifique de la biblioteque  |");
        System.out.println("                | 4 - Pour modifier un adherent                                 |");
        System.out.println("                | 5 - Pour efacer un Adherent                                   |");
        System.out.println("                *===============================================================*");
        String option_adherent;

        do {
            System.out.print("Insertion du choix : \n---> ");
            option_adherent = cv.nextLine();

            System.out.println("\n");

            switch (option_adherent) {
                case "0": {
                    Menu_principal grand_menu = new Menu_principal();
                    Menu();
                }
                break;
                case "1": {
                    Ajout_Adherent();
                }
                break;
                case "2": {
                    Afficher_ensemble_adherant();
                }
                break;
                case "3": {
                    Rechercher_Adherent();
                }
                break;
                case "4": {
                    Modifier_Adherent();
                }
                case "5": {
                    Supprimer_un_Adherent();
                }

                break;
                default:
                    System.out.println("|Ce choix ne relate aucune des options de ceux presenter.|");
                    System.out.println(" |---> Veuiller reessayer ");
                    Menu_Adherent();
            }
        } while (!option_adherent.equals("0"));
    }

    //Methode pour ajouter un Adherent a la bibliotheque
    public void Ajout_Adherent() {
        //Insertion des differentes informations sur l'adherent

        System.out.println("*========Ajout d'adherant dans la bibliotheque========*");
        System.out.println("--> Veuiller remplir les champs suivants :            |");
        System.out.println("| -> Inserer le code du nouveau adherent :            |");
        System.out.println("|Prenez sa carte comme reference : code-format --> A-XX|");
        System.out.print("---> ");
        code_up = cv.nextLine();
        code = code_up.toUpperCase();
        cv = new Scanner(System.in);
        do {
            System.out.println("|  -> Entrer son Nom : ");
            System.out.print("---> ");
            nom = cv.nextLine();
        } while (nom.isEmpty());
        do {
            System.out.println("|  -> Entrer son Prenom : ");
            System.out.print("---> ");
            prenom = cv.nextLine();
        } while (prenom.isEmpty());
        do {
            System.out.println("|  -> Entrer son Sexe : ");
            System.out.print("---> ");
            sexe = cv.nextLine();
        } while (sexe.isEmpty());
        do {
            System.out.println("|  -> Entrer la Faculte : ");
            System.out.print("---> ");
            faculte = cv.nextLine();
        } while (faculte.isEmpty());
        //Insertion des insformations dans l'instance de la classe Adherent
        personnes = new Adherent(code, nom, prenom, sexe, faculte);

        //Insertion des informations receuilllies dans le tableau ensemble_adherent 
        ensemble_adherent.add(personnes);

        //Affichage du nouveau adherent
        // System.out.println(personnes.Afficher_Adherent());
        System.out.println("\n| --> Adherent ajouter avec succes.      |\n");

        System.out.println("Faites un choix : ");
        System.out.println(" 2 - Afficher le nouvel adherent");
        System.out.println(" 3 - Retour au menu d'adherent");
        System.out.print("---> ");
        String ch = cv.nextLine();
        do {
            switch (ch) {
                case "2":
                    System.out.println("\nAffichage de l'adherents : ");
                    System.out.println(personnes.Afficher_Adherent() + "\n");

                    System.out.println("   Presser 4 pour retourner en arriere");
                    System.out.print("---> ");
                    String retour = cv.nextLine();
                    do {
                        if (retour.equals("4")) {
                            Menu_Adherent();
                        }
                    } while (!retour.equals("4"));
                    break;
                case "3":
                    Menu_Adherent();
                    break;
                default:
                    System.out.println("Choix invalide veuiller reessayer");
            }

        } while (!ch.equals("2") || !ch.equals("3"));

    }

    //Methode pour afficher l'ensemble des adherents de la bibliotheque
    public void Afficher_ensemble_adherant() {

        System.out.println("------Affichage de la liste des Adherents de la bibliotheque------\n");
        //Compteur servant a stocker le nombre total d'adherant a chaque pas de 1
        int compt = 0;

        //Verification si le tableau est vide
        if (ensemble_adherent.isEmpty()) {
            System.out.println("Liste vide.\n Il n'y a pas d'adherents inserer dans la bibliotheque");
        } else {
            //Boucle pour afficher les Adherents dans le tableau
            for (Adherent un_adherent : ensemble_adherent) {
                System.out.println(un_adherent.Afficher_Adherent() + "\n");
                compt++;
            }
        }
        System.out.println("TOTAL  ||  [" + compt + "] Adherents trouves.\n");

        String retour;
        do {
            System.out.println("   Presser 4 pour retourner en arriere");
            System.out.print("---> ");
            retour = cv.nextLine();

            if (retour.equals("4")) {
                Menu_Adherent();
            }
        } while (!retour.equals("4"));

    }

    //Methode pour rechercher un Adherent
    public void Rechercher_Adherent() {

        System.out.println("*--------- Rechercher un Adherent dans la bibliotheque ----------*");
        do {
            System.out.println("| -> Veuillez inserer le code : (A-XX) de l'Adherent en question |");
            System.out.print("---> ");
            code_up = cv.nextLine();
            code = code_up.toUpperCase();

        } while (code.isEmpty());

        int i = 0;
        for (Adherent un_adherent : ensemble_adherent) {
            if (un_adherent.getCode_ad().equals(code)) {
                System.out.println(un_adherent.Afficher_Adherent());

                i++;
            }
        }
        //Pour que la personne continue a entre le code tout autannt qu'il est eronne
        do {
            //Si le code inserer est eronne
            if (i == 0) {
                System.out.println("\n Le code : ' " + code + " ' insere ne correspond a aucun adherent.\n Veuiller reessayer.\n");
                do {
                    System.out.println("*---------------------------------------------------*");
                    System.out.println("| -> Inserer le code de formst : (A-XX) de nouveau  |");
                    System.out.print("---> ");
                    code_up = cv.nextLine();
                    code = code_up.toUpperCase();

                } while (code.isEmpty());

                for (Adherent un_adherent : ensemble_adherent) {
                    if (un_adherent.getCode_ad().equals(code)) {
                        System.out.println(un_adherent.Afficher_Adherent());
                        i++;
                    }
                }
            }
        } while (i == 0);

        String retour;
        do {
            System.out.println("\n   Presser 4 pour retourner en arriere");
            System.out.print("---> ");
            retour = cv.nextLine();

            if (retour.equals("4")) {

                Menu_Adherent();
            }
        } while (!retour.equals("4"));

    }

    // Methode pour Modifier un Adherent de la bibliotheque
    public void Modifier_Adherent() {

        String new_nom, new_prenom, new_sexe, new_faculte, new_code;
        int i = 0;
        do {
            System.out.println("|*-----Recherche de l'aherent a modifier-----*|\n");
            System.out.println("|->  Veuiller inserer le code du dit Adherent |");
            System.out.println("| NB :  Referez-vous au code sur la carte     |\n");
            System.out.println("        Format : A-XX");
            System.out.print("---> ");
            code_up = cv.nextLine();
            code = code_up.toUpperCase();

        } while (code.isEmpty());
        do {
            if (i == 0) {

                for (Adherent un_adherent : ensemble_adherent) {
                    if (un_adherent.getCode_ad().equals(code)) {
                        System.out.println(un_adherent.Afficher_Adherent());
                        i++;

                        cv = new Scanner(System.in);

                        System.out.println("                *===============================================*");
                        System.out.println("                 Modification de l'aherent : [" + un_adherent.getNom_ad() + " " + un_adherent.getPrenom_ad() + "]   ");
                        System.out.println("                --> Pressez");
                        System.out.println("                |  0 - Pour retourner en arriere                |");
                        System.out.println("                |  1 - Pour modifier son code                   |");
                        System.out.println("                |  2 - Pour modifier son nom                    |");
                        System.out.println("                |  3 - Pour modifier son prenom                 |");
                        System.out.println("                |  4 - Pour modifier son sexe                   |");
                        System.out.println("                |  5 - Pour modifier sa faculte                 |");
                        System.out.println("                *===============================================*");
                        String mod_ad, confirm;

                        System.out.print("\nInserttion du choix : \n ---> ");
                        mod_ad = cv.nextLine();
                        switch (mod_ad) {
                            case "0":

                                break;
                            case "1":

                                cv = new Scanner(System.in);
                                System.out.println("------Modification du code--------");
                                System.out.println(" Adherent : [" + un_adherent.getNom_ad().toUpperCase() + " " + un_adherent.getPrenom_ad() + "]");
                                System.out.println(" Code :" + un_adherent.getCode_ad());

                                System.out.println("\n Veuiller inserer le nouveau code : ");
                                System.out.println("NB : Format du code - A-XX ");
                                System.out.print("---> ");
                                new_code = cv.nextLine();
                                do {
                                    cv = new Scanner(System.in);
                                    System.out.println("\n Confirmez-vous cette modification :");
                                    System.out.println(" 1 - Je confirme");
                                    System.out.println(" 2 - Annuler");

                                    System.out.print("---> ");
                                    confirm = cv.nextLine();
                                } while (confirm.isEmpty());
                                switch (confirm) {
                                    case "1":
                                        System.out.println("\n Modification du code [" + un_adherent.getCode_ad() + "] par [" + new_code + "]");
                                        un_adherent.setCode_ad(new_code);
                                        System.out.println("Operation effectue avec succes\n");
                                        String retour;
                                        do {
                                            System.out.println("\n   Presser 4 pour retourner en arriere");
                                            System.out.print("---> ");

                                            retour = cv.nextLine();

                                            if (retour.equals("4")) {
                                                Menu_Adherent();
                                            }
                                        } while (!retour.equals("4"));
                                        break;
                                    case "2":
                                        System.out.println("\n --> Operation annuler .");
                                        System.out.println("| ---> Retour au menu de gestion des adherents .|");
                                        Menu_Adherent();
                                        break;
                                    default:
                                        System.out.println("\n --> Choix eronne");
                                        System.out.println("Operation annuler, veuller reessayer");
                                        Menu_Adherent();
                                }

                                break;
                            case "2":
                                cv = new Scanner(System.in);
                                System.out.println("------Modification du nom--------");
                                System.out.println(" Adherent : [" + un_adherent.getNom_ad().toUpperCase() + " " + un_adherent.getPrenom_ad() + "]");
                                System.out.println(". Veuiller inserer le nouveau nom");
                                System.out.print("---> ");
                                new_nom = cv.nextLine();
                                cv = new Scanner(System.in);
                                do {
                                    cv = new Scanner(System.in);
                                    System.out.println("\n Confirmez-vous cette modification :");
                                    System.out.println(" 1 - Je confirme");
                                    System.out.println(" 2 - Annuler");

                                    System.out.print("---> ");

                                    confirm = cv.nextLine();
                                } while (confirm.isEmpty());
                                switch (confirm) {
                                    case "1":
                                        System.out.println(" Modification du nom [" + un_adherent.getNom_ad() + "] par [" + new_nom + "]");
                                        un_adherent.setNom_ad(new_nom);
                                        System.out.println("Operation effectue avec succes");
                                        System.out.println(" Nouveau nom : [" + un_adherent.getNom_ad() + " " + un_adherent.getPrenom_ad() + "]");
                                        String retour;
                                        do {
                                            System.out.println("\n   Presser 4 pour retourner en arriere");
                                            System.out.print("---> ");

                                            retour = cv.nextLine();

                                            if (retour.equals("4")) {
                                                Menu_Adherent();
                                            }
                                        } while (!retour.equals("4"));
                                        break;
                                    case "2":
                                        System.out.println("\n --> Operation annuler .");
                                        System.out.println("| ---> Retour au menu de gestion des adherents .|");
                                        Menu_Adherent();
                                        break;
                                    default:
                                        System.out.println("Choix eronne");
                                        System.out.println("Operation annuler, veuller reessayer");
                                        Menu_Adherent();
                                }

                                break;
                            case "3":
                                cv = new Scanner(System.in);
                                System.out.println("------Modification du prenom--------");
                                System.out.println(" Adherent : [" + un_adherent.getNom_ad().toUpperCase() + " " + un_adherent.getPrenom_ad() + "]");
                                System.out.println(". Veuiller inserer le nouveau prenom");
                                System.out.print("---> ");
                                new_prenom = cv.nextLine();
                                cv = new Scanner(System.in);
                                do {
                                    cv = new Scanner(System.in);
                                    System.out.println("\n Confirmez-vous cette modification :");
                                    System.out.println(" 1 - Je confirme");
                                    System.out.println(" 2 - Annuler");
                                    System.out.print("---> ");

                                    confirm = cv.nextLine();
                                } while (confirm.isEmpty());
                                switch (confirm) {
                                    case "1":
                                        System.out.println(" Modification du prenom [" + un_adherent.getPrenom_ad() + " par " + new_prenom);
                                        un_adherent.setPrenom_ad(new_prenom);

                                        System.out.println("Operation effectue avec succes");
                                        System.out.println(" Nouveau prenom : [" + un_adherent.getNom_ad() + " " + un_adherent.getPrenom_ad() + "]");
                                        String retour;
                                        do {
                                            System.out.println("\n   Presser 4 pour retourner en arriere");
                                            System.out.print("---> ");

                                            retour = cv.nextLine();

                                            if (retour.equals("4")) {
                                                Menu_Adherent();
                                            }
                                        } while (!retour.equals("4"));
                                        return;
                                    case "2":
                                        System.out.println("\n --> Operation annuler .");
                                        System.out.println("| ---> Retour au menu de gestion des adherents .|");
                                        Menu_Adherent();
                                        break;
                                    default:
                                        System.out.println("\n --> Choix eronne");
                                        System.out.println("Operation annuler, veuller reessayer");
                                        Menu_Adherent();
                                }
                                break;
                            case "4":
                                cv = new Scanner(System.in);
                                System.out.println("------Modification du sexe--------");
                                System.out.println(" Adherent : [" + un_adherent.getNom_ad().toUpperCase() + " " + un_adherent.getPrenom_ad() + "]");
                                System.out.println("Sexe :" + un_adherent.getSexe_ad());
                                System.out.println(". Veuiller inserer le nouveau sexe");
                                System.out.print("---> ");
                                new_sexe = cv.nextLine();

                                cv = new Scanner(System.in);
                                do {
                                    cv = new Scanner(System.in);
                                    System.out.println("\n Confirmez-vous cette modification :");
                                    System.out.println(" 1 - Je confirme");
                                    System.out.println(" 2 - Annuler");
                                    System.out.print("---> ");

                                    confirm = cv.nextLine();
                                } while (confirm.isEmpty());
                                switch (confirm) {
                                    case "1":
                                        System.out.println(" Modification du sexe [" + un_adherent.getSexe_ad() + " par " + new_sexe);
                                        un_adherent.setSexe_ad(new_sexe);

                                        System.out.println("Operation effectue avec succes");
                                        String retour;
                                        do {
                                            System.out.println("\n   Presser 4 pour retourner en arriere");
                                            System.out.print("---> ");

                                            retour = cv.nextLine();

                                            if (retour.equals("4")) {
                                                Menu_Adherent();
                                            }
                                        } while (!retour.equals("4"));
                                        return;
                                    case "2":
                                        System.out.println("\n --> Operation annuler .");
                                        System.out.println("| ---> Retour au menu de gestion des adherents .|");
                                        Menu_Adherent();
                                        break;
                                    default:
                                        System.out.println("\n --> Choix eronne");
                                        System.out.println("Operation annuler, veuller reessayer");
                                        Menu_Adherent();
                                }
                                break;
                            case "5":
                                cv = new Scanner(System.in);
                                System.out.println("------Modification de la Faculte--------");
                                System.out.println(" Adherent : [" + un_adherent.getNom_ad().toUpperCase() + " " + un_adherent.getPrenom_ad() + "]");
                                System.out.println("Faculte :" + un_adherent.getFaculte());
                                System.out.println(". Veuiller inserer le nouveau Faculte");
                                System.out.print("---> ");
                                new_faculte = cv.nextLine();

                                cv = new Scanner(System.in);
                                do {
                                    cv = new Scanner(System.in);
                                    System.out.println("\n Confirmez-vous cette modification :");
                                    System.out.println(" 1 - Je confirme");
                                    System.out.println(" 2 - Annuler");

                                    System.out.println("---> ");
                                    confirm = cv.nextLine();
                                } while (confirm.isEmpty());
                                switch (confirm) {
                                    case "1":
                                        System.out.println(" Modification du sexe [" + un_adherent.getFaculte() + " par " + new_faculte);
                                        un_adherent.setFaculte(new_faculte);

                                        System.out.println("Operation effectue avec succes");
                                        String retour;
                                        do {
                                            System.out.println("\n   Presser 4 pour retourner en arriere");
                                            System.out.print("---> ");
                                            retour = cv.nextLine();

                                            if (retour.equals("4")) {
                                                Menu_Adherent();
                                            }
                                        } while (!retour.equals("4"));

                                    case "2":
                                        System.out.println("\n --> Operation annuler .");
                                        System.out.println("| ---> Retour au menu de gestion des adherents .|");
                                        Menu_Adherent();
                                }
                                break;
                            default:
                                System.out.println("\n --> Choix eronne");
                                System.out.println("Operation annuler, veuller reessayer");
                                Menu_Adherent();
                        }

                    }

                }
            }
        } while (i == 0);
    }

    //Methode pour Supprimer un adherent de la bibliotheque
    public void Supprimer_un_Adherent() {

        System.out.println("-----------Recherche de l'adherent a supprimer-----------");

        System.out.println("| --> Identification de l'adherent en question                      |");

        do {
            System.out.println("| -> Veuillez inserer le code : (A-XX) de l'Adherent en question |");
            System.out.print("---> ");
            code_up = cv.nextLine();
            code = code_up.toUpperCase();

        } while (code.isEmpty());

        int i = 0;
        for (Adherent un_adherent : ensemble_adherent) {
            if (un_adherent.getCode_ad().equals(code)) {
                System.out.println(un_adherent.Afficher_Adherent());

                i++;

            }
        }
        //Pour que la personne continue a entre le code tout autannt qu'il est eronne
        do {
            //Si le code inserer est eronne
            if (i == 0) {
                System.out.println("\n Le code : ' " + code + " ' insere ne correspond a aucun adherent.\n Veuiller reessayer.");
                do {
                    System.out.println("*---------------------------------------------------*");
                    System.out.println("| -> Inserer le code de formst : (A-XX) de nouveau  |");
                    System.out.print("---> ");
                    code_up = cv.nextLine();
                    code = code_up.toUpperCase();

                } while (code.isEmpty());

                System.out.println("\n --> Adherent retouve !\n");
                for (Adherent un_adherent : ensemble_adherent) {
                    if (un_adherent.getCode_ad().equals(code)) {
                        System.out.println(un_adherent.Afficher_Adherent());
                        i++;
                    }
                }
            }
        } while (i == 0);

        //Supression de l'adherent en quetion
        Adherent moun = null;
        for (Adherent un_adherent : ensemble_adherent) {
            if (un_adherent.getCode_ad().equals(code)) {
                if (un_adherent.getLivre_emprunter().equals("Aucun")) {
                    if (un_adherent.getNbre_pret() == 0) {
                        moun = un_adherent;
                    } else {
                        System.out.println("supression impossible\n");
                        System.out.println("Cet adherent fait l'oeuvre d'emprunt");
                        System.out.println("Reessayer apres retour du livre");
                    }
                } else {
                    System.out.println("supression impossible\n");
                    System.out.println("Cet adherent fait l'oeuvre d'emprunt");
                    System.out.println("Reessayer apres retour du livre");
                }
            }
        }

        System.out.println("Etes-vous sur de vouloir supprimer cet adherent ?");
        String choix;
        do {
            System.out.println(" 1 Pour confirmer ");
            System.out.println(" 2 Pour annuler");
            System.out.print("---> ");
            choix = cv.nextLine();
        } while (choix.isEmpty());
        switch (choix) {
            case "1":
                ensemble_adherent.remove(moun);
                System.out.println(" Supression reussi !!");
                String retour;
                do {
                    System.out.println("\n   Presser 4 pour retourner en arriere");
                    System.out.print("---> ");
                    retour = cv.nextLine();

                    if (retour.equals("4")) {
                        Menu_Adherent();
                    }
                } while (!retour.equals("4"));

                break;
            case "2":
                System.out.println("\nOperation Annuler");
                System.out.println("---> Retour au menu de gestion es Adherents\n");
                Menu_Adherent();

                break;
            default:
                System.out.println("\nVotre choix est erroner. \n ---> Operation annuler.");
                Menu_Adherent();
                break;
        }

    }

    //       LIGNES DE CODE POUR LA GESTION DES LIVRES
    //Methode de sous-menu pour gerer les livres
    public void Menu_livre() {
        System.out.println("                *==============================================================*");
        System.out.println("                |     --Acces aux differentes livres de la bibliotheque--      |");
        System.out.println("                |       --------------------------------------------------     |");
        System.out.println("                |       -> Veuillez choisir une des options suivantes:         |");
        System.out.println("                | 0 - Pour retourner au Menu Principal                         |");
        System.out.println("                | 1 - Pour ajouter des livres a la bibliotheque                |");
        System.out.println("                | 2 - Pour afficher l'ensemble des livres de la bibliotheque   |");
        System.out.println("                | 3 - Pour rechercher un livre specifique de la biblioteque    |");
        System.out.println("                | 4 - Pour modifier un livre                                   |");
        System.out.println("                | 5 - Pour Supprimer un livre                                  |");
        System.out.println("                *===============================================================*");
        System.out.println("\n");

        String option_livre;

        do {
            System.out.print("Insertion du choix : \n --->  ");
            option_livre = cv.nextLine();

            switch (option_livre) {
                case "0":
                    Menu_principal grand_menu = new Menu_principal();
                    Menu();
                    break;
                case "1":
                    Ajouter_un_livre();

                    break;
                case "2":
                    Afficher_liste_livres();
                    break;
                case "3":
                    Chercher_un_Livre();
                    break;
                case "4":
                    Modifier_Livre();
                    break;
                case "5":
                    Supprimer_livre();
                    break;
                default:
                    System.out.println("\n          -- ERREUR --");
                    System.out.println("Votre choix est eronne.");
                    System.out.println("Veuillez bien vouloir choisir un chiffre entre 0 a 5.\n");
                    Menu_livre();

            }

        } while (option_livre.equals("0"));
    }

    //Methode pour Ajouter un livre
    public void Ajouter_un_livre() {

        System.out.println("*-----------Ajout de livres dans la bibliotheque-----------*");

        System.out.println("| --> Veuillez bien vouloir remplir les champs ci-dessus   |\n");

        cv = new Scanner(System.in);
        System.out.println(". Inseerer le code du nouveau livre a ajouter :");
        System.out.print("---> ");
        code_livre_up = cv.nextLine();
        code_livre = code_livre_up.toUpperCase();
        cv = new Scanner(System.in);
        do {
            System.out.println(". Entrer le titre du livre :");
            System.out.print("---> ");
            titre = cv.nextLine();
        } while (titre.isEmpty());
        do {
            System.out.println(". Entrer le nom de l'auteur");
            System.out.print("---> ");
            auteur = cv.nextLine();
        } while (auteur.isEmpty());
        do {
            System.out.println(". Entrer la categorie du livre :");
            System.out.print("---> ");
            categorie = cv.nextLine();
        } while (categorie.isEmpty());
        do {
            System.out.println(". Quel est la date de sortie du livre :");
            System.out.print("---> ");
            date_sortie = cv.nextLine();
        } while (date_sortie.isEmpty());

        System.out.println(". Presizer le nombre d'exemplaire du livre : ");
        System.out.println(" -> NB:");
        System.out.print("---> ");
        exemplaire = cv.nextInt();

        // Insertion des infos du livre dans l'instance de la classe livre
        bouquin = new Livre(code_livre, titre, auteur, categorie, date_sortie, exemplaire);

        //Insertion du livre dans le tableau ensemble_livre
        ensemble_livre.add(bouquin);

        // Affichage du livre inserer
        System.out.println("| --> Livre ajouter avec succes.      |\n");

        System.out.println("Affichage du livre : ");
        System.out.println(bouquin.Afficher_livre());
        String retour;
        do {
            System.out.println("   Presser 4 pour retourner en arriere");
            System.out.print("---> ");
            retour = cv.nextLine();

            if (retour.equals("4")) {
                Menu_livre();
            }
        } while (!retour.equals("4"));

    }

// Methode pour afficher la liste des livres
    public void Afficher_liste_livres() {
        System.out.println("*-------Affichage de la liste des livres de la bibliotheque-------*");
        //Compteur servant a stocker le nombre total d'adherant a chaque pas de 1
        int compt = 0;

        //Verification si le tableau est vide
        if (ensemble_livre.isEmpty()) {
            System.out.println("Liste vide.\n Il n'y a aucun livre inserer dans la bibliotheque");
        } else {
            //Boucle pour afficher les livres dans le tableau
            for (Livre un_livre : ensemble_livre) {
                System.out.println(un_livre.Afficher_livre() + "\n");
                compt++;
            }
        }
        System.out.println("TOTAL  ||  [" + compt + "] Livres trouves.\n");

        String retour;
        do {
            System.out.println("   Presser 4 pour retourner en arriere");
            System.out.print("---> ");
            retour = cv.nextLine();

            if (retour.equals("4")) {
                Menu_livre();
            }
        } while (!retour.equals("4"));
    }

    // Methode pour Chercher un livre 
    public void Chercher_un_Livre() {
        int i=0;
        System.out.println("*---------- Rechercher un livre dans la bibliotheque -----------*");
        do {
            System.out.println("| -> Veuillez inserer le code : (L-XX) du livre en question |");
            code_livre_up = cv.nextLine();
            code_livre = code_livre_up.toUpperCase();

        } while (code_livre.isEmpty());

       
        for (Livre un_livre : ensemble_livre) {
            if (un_livre.getCode_livre().equals(code_livre)) {
                System.out.println(un_livre.Afficher_livre());
              i++;
            }
        }

        //Pour que la personne continue a entre le code tout autannt qu'il est eronne
        do {
            //Si le code inserer est eronne
            if (i == 0) {
                System.out.println("\n Le code : ' " + code_livre + " ' insere ne correspond a aucun livre.\n Veuiller reessayer.");
                do {
                    System.out.println("*-----------------------------------------*");
                    System.out.println("| -> Inserer le code : (L-XX) de nouveau  |");
                    code_livre_up = cv.nextLine();
                    code_livre = code_livre_up.toUpperCase();

                } while (code_livre.isEmpty());

                for (Livre un_livre : ensemble_livre) {
                    if (un_livre.getCode_livre().equals(code_livre)) {
                        System.out.println(un_livre.Afficher_livre());
                        i++;
                    }
                }

            }
        } while (i == 0);

        String chwa;
        do {
            

                System.out.println("\n*-----------------------------------------------*");
                System.out.println("|              Faites un choix                    |");
                System.out.println("               -----------------                  |");
                System.out.println("|   -> Presser :                                  |");
                System.out.println("| 0 -  Pour rechercher a nouveau un livre         |");
                System.out.println("| 1 - Pour retourner au menu gestion des livres   |");
                System.out.print("---> ");
                chwa = cv.nextLine();
                System.out.println("\n");
                switch (chwa) {
                    case "1":
                        Menu_livre();
                        break;
                    case "0":
                        Chercher_un_Livre();
                        break;
                    default:
                        System.out.println("Votre choix est erone.\nOperation annuler");
                        Menu_livre();
                }
            
        } while (!chwa.equals("0") || !chwa.equals("1"));

        
    }

    // Methode pour modifier un livre
    public void Modifier_Livre() {
        String new_titre, new_auteur, new_categorie, new_date_sortie, new_code_livre, new_code_livre_up;
        int new_exemplaire;

        int i = 0;

        System.out.println("|*-----Recherche du livre a modifier-----*|\n");
        System.out.println("|->  Veuiller inserer le code du livre |");
        do {
            if (i == 0) {

                do {

                    System.out.println("*-------------------------------------------*");
                    System.out.println("| -> Inserer le code sous la forme : (L-XX) |");
                    System.out.print("---> ");
                    code_livre_up = cv.nextLine();
                    code_livre = code_livre_up.toUpperCase();

                } while (code_livre.isEmpty());

                for (Livre un_livre : ensemble_livre) {
                    if (un_livre.getCode_livre().equals(code_livre)) {
                        System.out.println(un_livre.Afficher_livre());
                        i++;

                        cv = new Scanner(System.in);

                        System.out.println("    *===============================================*");
                        System.out.println("    |  Modification du livre :                      |");
                        System.out.println(un_livre.getTitre() + ", identife par le codee : [" + un_livre.getCode_livre() + "]");
                        System.out.println("    --> Pressez");
                        System.out.println("    |  0 - Pour retourner en arriere                |");
                        System.out.println("    |  1 - Pour modifier son code                   |");
                        System.out.println("    |  2 - Pour modifier son titre                  |");
                        System.out.println("    |  3 - Pour modifier son auteur                 |");
                        System.out.println("    |  4 - Pour modifier sa categorie               |");
                        System.out.println("    |  5 - Pour modifier sa date de sortie          |");
                        System.out.println("    |  6 - Pour modifier son nombre d'exemplaires   |");
                        System.out.println("    *===============================================*");
                        String mod_ad, confirm;
                        System.out.print("Insertion du choix. \n --->  ");
                        mod_ad = cv.nextLine();
                        switch (mod_ad) {
                            case "0":
                                Menu_livre();
                                break;
                            case "1":

                                cv = new Scanner(System.in);
                                System.out.println("------Modification du code--------");
                                System.out.println(" Livre : [" + un_livre.getTitre());
                                System.out.println(" Code :" + un_livre.getCode_livre());

                                System.out.println(". Veuiller inserer le nouveau code");
                                System.out.print("---> ");
                                new_code_livre_up = cv.nextLine();
                                new_code_livre = new_code_livre_up.toUpperCase();

                                cv = new Scanner(System.in);
                                System.out.println(" Confirmez-vous cette modification :");
                                System.out.println(" 1 - Je confirme");
                                System.out.println(" 2 - Annuler");
                                System.out.print("---> ");
                                confirm = cv.nextLine();
                                if (confirm.equals("1")) {

                                    System.out.println(" Modification du code [" + un_livre.getCode_livre() + " par " + new_code_livre);
                                    un_livre.setCode_livre(new_code_livre);

                                    System.out.println("Operation effectue avec succes");
                                    String retour;
                                    do {
                                        System.out.println("   Presser 4 pour retourner en arriere");
                                        System.out.print("---> ");
                                        retour = cv.nextLine();

                                        if (retour.equals("4")) {
                                            Menu_livre();
                                        }
                                    } while (!retour.equals("4"));

                                } else {
                                    System.out.println("Retour au menu de gestion des livres. \n");
                                    Menu_livre();
                                }

                                break;
                            case "2":
                                cv = new Scanner(System.in);
                                System.out.println("------Modification du titre du livre--------");
                                System.out.println(" Titre du livre : [" + un_livre.getTitre());
                                System.out.println(". Veuiller inserer le nouveau titre");
                                System.out.print("---> ");
                                new_titre = cv.nextLine();
                                cv = new Scanner(System.in);
                                System.out.println(" Confirmez-vous cette modification :");
                                System.out.println(" 1 - Je confirme");
                                System.out.println(" 2 - Annuler");

                                confirm = cv.nextLine();
                                if (confirm.equals("1")) {

                                    System.out.println(" Modification du titre [" + un_livre.getTitre() + " par " + new_titre);
                                    un_livre.setTitre(new_titre);

                                    System.out.println("Operation effectue avec succes");
                                    System.out.println(" Nouveau titre : [" + un_livre.getTitre());

                                    String retour;
                                    do {
                                        System.out.println("   Presser 4 pour retourner en arriere");
                                        System.out.print("---> ");
                                        retour = cv.nextLine();

                                        if (retour.equals("4")) {
                                            Menu_livre();
                                        }
                                    } while (!retour.equals("4"));

                                } else {
                                    System.out.println("Retour au menu de gestion des livres");
                                    Menu_livre();
                                }

                                break;
                            case "3":
                                cv = new Scanner(System.in);
                                System.out.println("------Modification du Nom de l'auteur-------");
                                System.out.println(" Nom de l'auteur : [" + un_livre.getNom_auteur());
                                System.out.println(". Veuiller inserer le nouveau prenom");
                                System.out.print("---> ");
                                new_auteur = cv.nextLine();
                                cv = new Scanner(System.in);
                                System.out.println(" Confirmez-vous cette modification :");
                                System.out.println(" 1 - Je confirme");
                                System.out.println(" 2 - Annuler");
                                System.out.print("---> ");
                                confirm = cv.nextLine();
                                if (confirm.equals("1")) {

                                    System.out.println(" Modification du Nom d'auteur [" + un_livre.getNom_auteur() + " par " + new_auteur);
                                    un_livre.setNom_auteur(new_auteur);

                                    System.out.println("Operation effectue avec succes");
                                    System.out.println(" Nouveau nom d'auteur: [" + un_livre.getNom_auteur() + " " + un_livre.getNom_auteur() + "]");
                                    String retour;
                                    do {
                                        System.out.println("   Presser 4 pour retourner en arriere");
                                        System.out.print("---> ");
                                        retour = cv.nextLine();

                                        if (retour.equals("4")) {
                                            Menu_livre();
                                        }
                                    } while (!retour.equals("4"));
                                    return;
                                } else {
                                    System.out.println("Retour au menu de gestion des auteurs");
                                    Menu_livre();
                                }
                                break;
                            case "4":
                                cv = new Scanner(System.in);
                                System.out.println("------Modification de la categorie du livre--------");
                                System.out.println("Categorie du livre : " + un_livre.getCategorie());
                                System.out.println(". Veuiller inserer le nouveau sexe");
                                System.out.print("---> ");
                                new_categorie = cv.nextLine();

                                cv = new Scanner(System.in);
                                System.out.println(" Confirmez-vous cette modification :");
                                System.out.println(" 1 - Je confirme");
                                System.out.println(" 2 - Annuler");
                                System.out.print("---> ");
                                confirm = cv.nextLine();
                                if (confirm.equals("1")) {

                                    System.out.println(" Modification de la categorie [" + un_livre.getCategorie() + " par " + new_categorie);
                                    un_livre.setCategorie(new_categorie);
                                    /// pret.setCategorie(new_categorie);

                                    System.out.println("Operation effectue avec succes");
                                    String retour;
                                    do {
                                        System.out.println("   Presser 4 pour retourner en arriere");
                                        System.out.print("---> ");
                                        retour = cv.nextLine();

                                        if (retour.equals("4")) {
                                            Menu_livre();
                                        }
                                    } while (!retour.equals("4"));
                                } else {
                                    System.out.println("Retour au menu de gestion des livres");
                                    Menu_livre();
                                }
                                break;
                            case "5":
                                cv = new Scanner(System.in);
                                System.out.println("------Modification de la date de sortie--------");
                                System.out.println(" Date de sortie : [" + un_livre.getDate_sortie());
                                System.out.println(". Veuiller inserer la nouvelle date de sortie");
                                System.out.print("---> ");
                                new_date_sortie = cv.nextLine();

                                cv = new Scanner(System.in);
                                System.out.println(" Confirmez-vous cette modification :");
                                System.out.println(" 1 - Je confirme");
                                System.out.println(" 2 - Annuler");
                                System.out.print("---> ");
                                confirm = cv.nextLine();
                                if (confirm.equals("1")) {

                                    System.out.println(" Modification de la date de sortie : [" + un_livre.getDate_sortie() + " par " + new_date_sortie);
                                    un_livre.setDate_sortie(new_date_sortie);

                                    System.out.println("Operation effectue avec succes");
                                    String retour;
                                    do {
                                        System.out.println("   Presser 4 pour retourner en arriere");
                                        System.out.print("---> ");
                                        retour = cv.nextLine();

                                        if (retour.equals("4")) {
                                            Menu_livre();
                                        }
                                    } while (!retour.equals("4"));
                                } else {
                                    System.out.println("Retour au menu de gestion des adherents");
                                    Menu_livre();
                                }
                                break;
                            case "6":
                                cv = new Scanner(System.in);
                                System.out.println("------Modification du nombre d'exemplaire du livre--------");
                                System.out.println("Nombre d'exemplaire : " + un_livre.getExemplaires());
                                System.out.println(". Veuiller inserer la nouvelle quantite d'exemplaire");
                                System.out.print("---> ");
                                new_exemplaire = cv.nextInt();

                                cv = new Scanner(System.in);
                                System.out.println(" Confirmez-vous cette modification :");
                                System.out.println(" 1 - Je confirme");
                                System.out.println(" 2 - Annuler");
                                System.out.print("---> ");
                                confirm = cv.nextLine();
                                if (confirm.equals("1")) {

                                    System.out.println(" Modification du nombre d'exemplaire [" + un_livre.getExemplaires() + " par " + new_exemplaire);
                                    un_livre.setExemplaires(new_exemplaire);

                                    System.out.println("Operation effectue avec succes");
                                    String retour;
                                    do {
                                        System.out.println("   Presser 4 pour retourner en arriere");
                                        System.out.print("---> ");
                                        retour = cv.nextLine();

                                        if (retour.equals("4")) {
                                            Menu_livre();
                                        }
                                    } while (!retour.equals("4"));
                                } else {
                                    System.out.println("Retour au menu de gestion des livres");
                                    Menu_livre();
                                }
                                break;
                            default:
                                System.out.println("Veuiller reiterer votre choix");
                                Modifier_Livre();
                        }

                    }

                }
            }
        } while (i == 0);
    }

    // Methode pour supprimer un livre
    public void Supprimer_livre() {

        System.out.println("----Recherche du livre a supprimer----");
        System.out.println("*---------- Rechercher un livre dans la bibliotheque -----------*");
        do {
            System.out.println("| -> Veuillez inserer le code : (L-XX) du livre en question |");
            System.out.print("---> ");
            code_livre_up = cv.nextLine();
            code_livre = code_livre_up.toUpperCase();

        } while (code_livre.isEmpty());

        int j = 0;
        for (Livre un_livre : ensemble_livre) {
            if (un_livre.getCode_livre().equals(code_livre)) {
                System.out.println(un_livre.Afficher_livre());
                j++;

            }
        }

        //Pour que la personne continue a entre le code tout autannt qu'il est eronne
        do {
            //Si le code inserer est eronne
            if (j == 0) {
                System.out.println("\n Le code : ' " + code_livre + " ' insere ne correspond a aucun livre.\n Veuiller reessayer.");
                do {
                    System.out.println("*-----------------------------------------*");
                    System.out.println("| -> Inserer le code : (L-XX) de nouveau  |");
                    System.out.print("---> ");
                    code_livre_up = cv.nextLine();
                    code_livre = code_livre_up.toUpperCase();

                } while (code_livre.isEmpty());

                for (Livre un_livre : ensemble_livre) {
                    if (un_livre.getCode_livre().equals(code_livre)) {
                        System.out.println(un_livre.Afficher_livre());
                        j++;
                    }
                }

            }
        } while (j == 0);

        System.out.println("\n--------------------------------------------\n");

        //Attribut servant a stocker le livre trouve
        Livre liv = null;

        for (Livre un_livre : ensemble_livre) {
            if (un_livre.getCode_livre().equals(code_livre)) {
                if (un_livre.getExemplaires() > 0) {
                    if (!un_livre.getStatut().equals("Allouer")) {
                        liv = un_livre;
                        //  ensemble_livre.remove(un_livre);
                        System.out.println(" Operation de suppression resussi");

                    } else {
                        System.out.println("Le livre que vous tenter de supprimer,est actuellement en pret. ");
                        System.out.println("Supression impossible");
                    }
                    System.out.println(un_livre.Afficher_livre());

                } else {
                    System.out.println("\nStock epuise, aucun exemplaire trouve");
                    System.out.println("Ce qui implique que ce livre peut faire l'oeuvre d'un pret");
                    System.out.println(" Supression impossible .");
                }
            }
        }

        System.out.println("Etes-vous sur de vouloir supprimer ce livre ?");
        String choix;
        do {
            System.out.println(" 1 Pour confirmer ");
            System.out.println(" 2 Pour annuler");
            System.out.print("---> ");
            choix = cv.nextLine();
        } while (choix.isEmpty());
        switch (choix) {
            case "1":
                ensemble_livre.remove(liv);
                System.out.println(" Supression reussi !!");
                String retour;
                do {
                    System.out.println("\n   Presser 4 pour retourner en arriere");
                    System.out.print("---> ");
                    retour = cv.nextLine();

                    if (retour.equals("4")) {
                        Menu_livre();
                    }
                } while (!retour.equals("4"));

                break;
            case "2":
                System.out.println("\\nOperation Annuler");
                System.out.println("---> Retour au menu de gestion des Livres\n");
                Menu_livre();

                break;
            default:
                System.out.println("\nVotre choix est erroner. \n ---> Operation annuler.");
                Menu_livre();
                break;
        }

        /*
         String retour;
         do {
         System.out.println("   Presser 4 pour retourner en arriere");
         System.out.print("---> ");
         retour = cv.nextLine();

         if (retour.equals("4")) {
         Menu_livre();
         }
         } while (!retour.equals("4"));*/
    }

    // LIGNE DE CODE POUR GERER LES PRETS DE FACON A MODIFIER LE STATUT DES LIVRES
    // Methode de sous menu pour gerer le satut des livres
    public void Menu_statut() {
        System.out.println("                *===============================================================*");
        System.out.println("                |              --Modification du statut d'un livre--            |");
        System.out.println("                |       --------------------------------------------------      |");
        System.out.println("                |       -> Veuillez choisir une des options suivantes:          |");
        System.out.println("                |                                                               |");
        System.out.println("                | 0 - Pour retourner au Menu Principal                          |");
        System.out.println("                |                                                               |");
        System.out.println("                | -->  Appuyez sur : 1                                          |");
        System.out.println("                |        Pour emprunter un livre                                |");
        System.out.println("                | -->  Appuyer sur : 2                                          |");
        System.out.println("                |        Pour remettre un livre                                 |");
        System.out.println("                | -->  Appuyez sur : 3                                          |");
        System.out.println("                |        Pour afficher la liste des adherents ainsi que         |");
        System.out.println("                |        ayant effectuer des prets.                             |");
        System.out.println("                | -->  Appuyer sur : 4                                          |");
        System.out.println("                |        Pour changer manuellement le statut d'un livre         |");
        System.out.println("                *===============================================================*");
        String option_pret;
        do {
            System.out.print("Insertion du choix : \n ---> ");
            option_pret = cv.nextLine();

            System.out.println("\n");

            switch (option_pret) {
                case "0": {
                    Menu();
                }
                break;
                case "1": {
                    Emprunter_livre();
                }
                break;
                case "2": {
                    Retour_Livre();
                }
                break;
                case "3": {
                    Affichage_ensemble_pret();
                }
                break;
                case "4":
                    Modification_mannuel_statut();
                    break;
                default:
                    System.out.println("Votre choix est eroner veuiller reessayer");
                    Menu_statut();
            }
        } while (!option_pret.equals("0"));
    }

    // Methode pour Emprunter un livre
    public void Emprunter_livre() {

        String nom_livre_preter = "Aucun", nom_de_auteur = null;
        int nbre_pret = 0;

        System.out.println("*===================================================================*");
        System.out.println("|                  -- Enregistrement d'un Pret --                   |");

        System.out.println("\n|                         -- Partie 1 --                            |");
        System.out.println("| --> Identification de l'adherent en question                      |");

        do {
            System.out.println("| -> Veuillez inserer le code : (A-XX) de l'Adherent en question |");
            System.out.print("---> ");
            code_up = cv.nextLine();
            code = code_up.toUpperCase();

        } while (code.isEmpty());

        int i = 0;
        for (Adherent un_adherent : ensemble_adherent) {
            if (un_adherent.getCode_ad().equals(code)) {
                System.out.println(un_adherent.Afficher_Adherent());

                i++;

            }
        }
        //Pour que la personne continue a entre le code tout autannt qu'il est eronne
        do {
            //Si le code inserer est eronne
            if (i == 0) {
                System.out.println("\n Le code : ' " + code + " ' insere ne correspond a aucun adherent.\n Veuiller reessayer.");
                do {
                    System.out.println("*---------------------------------------------------*");
                    System.out.println("| -> Inserer le code de formst : (A-XX) de nouveau  |");
                    System.out.print("---> ");
                    code_up = cv.nextLine();
                    code = code_up.toUpperCase();

                } while (code.isEmpty());

                for (Adherent un_adherent : ensemble_adherent) {
                    if (un_adherent.getCode_ad().equals(code)) {
                        System.out.println(un_adherent.Afficher_Adherent());
                        i++;
                    }
                }
            }
        } while (i == 0);
        
     

        System.out.println("\n|                         -- Partie 2 --                            |");

        System.out.println("*---------- Rechercher un livre dans la bibliotheque -----------*");
        do {
            System.out.println("| -> Veuillez inserer le code : (L-XX) du livre en question |");
            System.out.print("---> ");
            code_livre_up = cv.nextLine();
            code_livre = code_livre_up.toUpperCase();

        } while (code_livre.isEmpty());

        int j = 0;
        for (Livre un_livre : ensemble_livre) {
            if (un_livre.getCode_livre().equals(code_livre)) {
                System.out.println(un_livre.Afficher_livre());
                j++;

            }
        }

        //Pour que la personne continue a entre le code tout autannt qu'il est eronne
        do {
            //Si le code inserer est eronne
            if (j == 0) {
                System.out.println("\n Le code : ' " + code_livre + " ' insere ne correspond a aucun livre.\n Veuiller reessayer.");
                do {
                    System.out.println("*-----------------------------------------*");
                    System.out.println("| -> Inserer le code : (L-XX) de nouveau  |");
                    System.out.print("---> ");
                    code_livre_up = cv.nextLine();
                    code_livre = code_livre_up.toUpperCase();

                } while (code_livre.isEmpty());

                for (Livre un_livre : ensemble_livre) {
                    if (un_livre.getCode_livre().equals(code_livre)) {
                        System.out.println(un_livre.Afficher_livre() + "\n");
                        j++;
                    }
                }

            }
        } while (j == 0);

        

        for (Adherent un_adherent : ensemble_adherent) {
            if (un_adherent.getCode_ad().equals(code)) {
                if (un_adherent.getNbre_pret() == 0) {
                    un_adherent.setNbre_pret(un_adherent.getNbre_pret() + 1);
                    un_adherent.setLivre_emprunter(nom_livre_preter);
                    un_adherent.setCode_liv(code_livre);
                    un_adherent.setNom_auteur(nom_de_auteur);
                    //   System.out.println(un_adherent.Afficher_Pret());
                    nbre_pret = un_adherent.getNbre_pret();
                    nom = un_adherent.getNom_ad();
                    prenom = un_adherent.getPrenom_ad();
                    faculte = un_adherent.getFaculte();
                    sexe = un_adherent.getSexe_ad();
                
               }
            }
        }
if (nbre_pret == 1) {
        for (Livre un_livre : ensemble_livre) {
            if (un_livre.getCode_livre().equals(code_livre)) {
                if (un_livre.getExemplaires() > 0) {
                    switch (un_livre.getStatut()) {
                        case "Disponible":
                            un_livre.setExemplaires(un_livre.getExemplaires() - 1);
                            un_livre.setExemp_prete(un_livre.getExemp_prete() + 1);
                            nom_livre_preter = un_livre.getTitre();
                            nom_de_auteur = un_livre.getNom_auteur();
                            break;
                        case "Alouer":
                            System.out.println("Ce livre et tout ses exemplaires ont deja ete allouer");
                            break;
                        default:
                            break;
                    }

                } else if (un_livre.getExemplaires() == 0) {
                    un_livre.setStatut("Allouer");

                } else {
                    System.out.println("  Il n'y a plus d'exemplaires de ce livre");
                }
            }
        }

        //Affecter des valeurs de certaines proprietes a ceux de la classe emprunt
        pcode_ad = code;
        pnom = nom;
        pprenom = prenom;
        psexe = sexe;
        pfaculte = faculte;
        pcode_liv = code_livre;
        emprunt_livre.setLivre_emprunter(nom_livre_preter);
        pnom_auteur = nom_de_auteur;

        
            emprunt_livre = new Pret(pcode_ad, pnom, pprenom, psexe, pfaculte, pcode_liv, pnom_auteur);

            ensemble_pret.add(emprunt_livre);

            System.out.println("--> Emprunt du livre : [" + nom_livre_preter + "] par l'adherent : [" + pnom + " " + pprenom + "] effectuer avec succes.");

            System.out.println("-----------------------------------------------------------------");
            System.out.println("   --> Appuyer sur :                                                  ");
            System.out.println("         1 - pour afficher ce pret");
            System.out.println("         2 - pour retourner en arriere");
            System.out.print("---> ");
            String retour = cv.nextLine();

            switch (retour) {
                case "1":
                    System.out.println("\n         -- Affichage de ce pret --");
                    for (Adherent un_adherent : ensemble_adherent) {
                        if (un_adherent.getCode_ad().equals(code)) {
                            un_adherent.setNbre_pret(un_adherent.getNbre_pret() + 1);
                            un_adherent.setLivre_emprunter(nom_livre_preter);
                            un_adherent.setCode_liv(code_livre);
                            un_adherent.setNom_auteur(nom_de_auteur);
                            System.out.println(un_adherent.Afficher_Pret());

                        }
                    }
                    do {
                        System.out.println("\n   Presser 4 pour retourner en arriere");
                        retour = cv.nextLine();

                        if (retour.equals("4")) {
                            Menu_statut();
                        }
                    } while (!retour.equals("4"));

                    break;
                case "2":
                    Menu_statut();
                    break;
                default:
                    System.out.println(" --> Ce choix est erronne.");
                    System.out.println("Retour automatique au menu de gesion de statut");
                    Menu_statut();

            }
        } else {
            System.out.println("          -- NOTIFICATION --");
            System.out.println("Cet adherent a deja un pret en cours.");
            System.out.println("Emprunt impossible  realiser, veuiller retourner le livre");
            String retour;
            do {
                System.out.println("\n   Presser 4 pour retourner en arriere");
                retour = cv.nextLine();

                if (retour.equals("4")) {
                    Menu_statut();
                }
            } while (!retour.equals("4"));
        }

    }

    public void Affichage_ensemble_pret() {

        System.out.println("------Affichage de la liste des Adherents de la bibliotheque------\n");
        //Compteur servant a stocker le nombre total de pret trouve
        int compt = 0;

        //Verification si le tableau est vide
        if (ensemble_pret.isEmpty()) {
            System.out.println("Liste vide.\n Il n'y a aucun pret de livres recenser dans la bibliotheque");
        } else {
            //Boucle pour afficher les  Prets dans le tableau
            for (compt = 0; compt < ensemble_pret.size(); compt++) {
                System.out.println(ensemble_pret.get(compt).Afficher_Pret() + "\n");
            }
        }
        System.out.println("TOTALE  ||  [" + compt + "] Prets trouves.\n");

        String retour;
        do {
            System.out.println("   Presser 4 pour retourner en arriere");
            System.out.print("---> ");
            retour = cv.nextLine();

            if (retour.equals("4")) {
                Menu_statut();
            }
        } while (!retour.equals("4"));
    }

    public void Retour_Livre() {

        String nom_livre_preter = "Aucun";

        System.out.println("*=================================================================*");
        System.out.println("|                   --  Retour d'un livre --                      |");

        System.out.println("\n|                         -- Partie 1 --                            |\n");

        System.out.println("|. Inserer le code du livre en question          |");

        do {
            System.out.println("| -> Veuillez inserer le code : (L-XX) du livre en question |");
            System.out.print("---> ");
            code_livre_up = cv.nextLine();
            code_livre = code_livre_up.toUpperCase();

        } while (code_livre.isEmpty());

        int j = 0;
        for (Livre un_livre : ensemble_livre) {
            if (un_livre.getCode_livre().equals(code_livre)) {
                System.out.println(un_livre.Afficher_livre());
                j++;

            }
        }

        //Pour que la personne continue a entre le code tout autannt qu'il est eronne
        do {
            //Si le code inserer est eronne
            if (j == 0) {
                System.out.println("\n Le code : ' " + code_livre + " ' insere ne correspond a aucun livre.\n Veuiller reessayer.");
                do {
                    System.out.println("*-----------------------------------------*");
                    System.out.println("| -> Inserer le code : (L-XX) de nouveau  |");
                    System.out.print("---> ");
                    code_livre_up = cv.nextLine();
                    code_livre = code_livre_up.toUpperCase();

                } while (code_livre.isEmpty());

                for (Livre un_livre : ensemble_livre) {
                    if (un_livre.getCode_livre().equals(code_livre)) {
                        System.out.println(un_livre.Afficher_livre());
                        j++;
                    }
                }

            }
        } while (j == 0);

        System.out.println("\n|                         -- Partie 2 --                            |\n");
        System.out.println("| --> Identification de l'adherent en question                      |");

        do {
            System.out.println("| -> Veuillez inserer le code : (A-XX) de l'Adherent en question |");
            System.out.print("---> ");
            code_up = cv.nextLine();
            code = code_up.toUpperCase();

        } while (code.isEmpty());

        int i = 0;
        for (Adherent un_adherent : ensemble_adherent) {
            if (un_adherent.getCode_ad().equals(code)) {
                System.out.println(un_adherent.Afficher_Adherent());

                i++;

            }
        }
        //Pour que la personne continue a entre le code tout autannt qu'il est eronne
        do {
            //Si le code inserer est eronne
            if (i == 0) {
                System.out.println("\n Le code : ' " + code + " ' insere ne correspond a aucun adherent.\n Veuiller reessayer.");
                do {
                    System.out.println("*---------------------------------------------------*");
                    System.out.println("| -> Inserer le code de formst : (A-XX) de nouveau  |");
                    System.out.print("---> ");
                    code_up = cv.nextLine();
                    code = code_up.toUpperCase();

                } while (code.isEmpty());

                for (Adherent un_adherent : ensemble_adherent) {
                    if (un_adherent.getCode_ad().equals(code)) {
                        System.out.println(un_adherent.Afficher_Adherent());
                        i++;
                    }
                }
            }
        } while (i == 0);

        //Retour du Livre changement
        for (Livre un_livre : ensemble_livre) {
            if (un_livre.getCode_livre().equals(code_livre)) {
                if (un_livre.getExemplaires() > 0 || un_livre.getExemplaires() == 0) {

                    un_livre.setExemplaires(un_livre.getExemplaires() + 1);
                    un_livre.setExemp_prete(un_livre.getExemp_prete() - 1);
                    un_livre.setStatut("Disponible");
                    nom_livre_preter = un_livre.getTitre();

                } else {
                    System.out.println("Ce livre a deja ete allouer");
                }
            }
        }

        //Retour Adherent changement
        for (Livre un_livre : ensemble_livre) {
            if (un_livre.getCode_livre().equals(code_livre)) {
                if (un_livre.getExemplaires() > 0) {
                    switch (un_livre.getStatut()) {
                        case "Disponible":
                            un_livre.setExemplaires(un_livre.getExemplaires() + 1);
                            un_livre.setExemp_prete(un_livre.getExemp_prete() - 1);
                            //nom_livre_preter = un_livre.getTitre();
                            break;
                        case "Alouer":
                            un_livre.setStatut("Disponible");
                            System.out.println("Ce livre est a nouveau disponible pour un pret");
                            un_livre.setExemplaires(un_livre.getExemplaires() + 1);
                            un_livre.setExemp_prete(un_livre.getExemp_prete() - 1);
                            break;
                        default:
                            break;
                    }

                } else if (un_livre.getExemplaires() == 0) {
                    un_livre.setStatut("Allouer");

                } else {
                    System.out.println("  Il n'y a plus d'exemplaires de ce livre");
                }
            }
        }

        for (Adherent un_adherent : ensemble_adherent) {
            if (un_adherent.getCode_ad().equals(code)) {
                un_adherent.setNbre_pret(un_adherent.getNbre_pret() - 1);
                un_adherent.setLivre_emprunter("Aucun");

                System.out.println("Operation effectue avec succes !");

            }
        }
        
        String retour;
        do {
            System.out.println("   Presser 4 pour retourner en arriere");
            System.out.print("---> ");
            retour = cv.nextLine();

            if (retour.equals("4")) {
                Menu_statut();
            }
        } while (!retour.equals("4"));

    }

    public void Modification_mannuel_statut() {
        System.out.println("|       -- Modification du statut sans Pret --      |");
        System.out.println("*---------- Rechercher un livre dans la bibliotheque -----------*");
        do {
            System.out.println("| -> Veuillez inserer le code : (L-XX) du livre en question |");
            System.out.print("---> ");
            code_livre_up = cv.nextLine();
            code_livre = code_livre_up.toUpperCase();

        } while (code_livre.isEmpty());

        int j = 0;
        for (Livre un_livre : ensemble_livre) {
            if (un_livre.getCode_livre().equals(code_livre)) {
                System.out.println(un_livre.Afficher_livre());
                j++;

            }
        }

        //Pour que la personne continue a entre le code tout autannt qu'il est eronne
        do {
            //Si le code inserer est eronne
            if (j == 0) {
                System.out.println("\n Le code : ' " + code_livre + " ' insere ne correspond a aucun livre.\n Veuiller reessayer.");
                do {
                    System.out.println("*-----------------------------------------*");
                    System.out.println("| -> Inserer le code : (L-XX) de nouveau  |");
                    System.out.print("---> ");
                    code_livre_up = cv.nextLine();
                    code_livre = code_livre_up.toUpperCase();

                } while (code_livre.isEmpty());

                for (Livre un_livre : ensemble_livre) {
                    if (un_livre.getCode_livre().equals(code_livre)) {
                        System.out.println(un_livre.Afficher_livre() + "\n");
                        j++;
                    }
                }

            }
        } while (j == 0);

        System.out.println("|   --> Pour changer le statut de :    |");
        System.out.println("|             ---------                |");
        System.out.println("|    Disponible a Allouer              | ");
        System.out.println("|         -- Apuyer sur 1              | ");
        System.out.println("|                                      |");
        System.out.println("|    Allouer a Disponible              |");
        System.out.println("|         -- Apuyer sur 2              |");
        System.out.println("|             ---------               |");
        String choix = cv.nextLine();
        switch (choix) {
            case "1":
                for (Livre un_livre : ensemble_livre) {
                    if (un_livre.getCode_livre().equals(code_livre)) {
                        if (un_livre.getStatut().equals("Disponible")) {
                            un_livre.setStatut("Allouer");
                            System.out.println("\nLe livre apres modification");
                            System.out.println(un_livre.Afficher_livre());
                        }

                    }
                }
                System.out.println("Operation effectuer avec succes");
                String retour;
                do {
                    System.out.println("   Presser 4 pour retourner en arriere");
                    System.out.print("---> ");
                    retour = cv.nextLine();

                    if (retour.equals("4")) {
                        Menu_statut();
                    }
                } while (!retour.equals("4"));
                break;
            case "2":
                for (Livre un_livre : ensemble_livre) {
                    if (un_livre.getCode_livre().equals(code_livre)) {
                        if (un_livre.getStatut().equals("Allouer")) {
                            un_livre.setStatut("Disponible");
                            System.out.println("\nLe livre apres modification");
                            System.out.println(un_livre.Afficher_livre());
                        }

                    }
                }
                System.out.println("Operation effectuer avec succes");

                do {
                    System.out.println("   Presser 4 pour retourner en arriere");
                    System.out.print("---> ");
                    retour = cv.nextLine();

                    if (retour.equals("4")) {
                        Menu_statut();
                    }
                } while (!retour.equals("4"));
                break;
            default:
                System.out.println("Choix erronne. \n Operation annuler");
                System.out.println("\nRetour au menu de gestion de statut");
                Menu_statut();
                break;
        }

    }

    //               LIGNES DE CODE POUR SECURISER LA BIBLIOTHEQUE
    public void connexion() {

        Ajout_auto_Administrateur();

        String nom_ad, prenom_ad, code_ad;
        do {
            System.out.println("\nVeuiller inserer votre nom :");
            System.out.print(" ---> ");
            nom_ad = cv.nextLine();
            if (nom_ad.equals(nom_admin)) {
                do {
                    System.out.println("\nVeuiller inserer votre prenom :");
                    System.out.print(" ---> ");
                    prenom_ad = cv.nextLine();
                    if (prenom_ad.equals(prenom_admin)) {
                        do {
                            System.out.println("\nVeuiller inserer le code de connexion :");
                            System.out.print(" ---> ");
                            code_ad = cv.nextLine();
                            if (code_ad.equals(code_admin)) {
                                System.out.println("\nBienvenue a vous : [" + nom_ad.toUpperCase() + " " + prenom_ad + "]\n");
                                Menu();
                            } else {
                                System.out.println("Le code inserer est incorrect. \n --> Veuiller reessayer");
                            }
                        } while (!code_ad.equals(code_admin));

                    } else {
                        System.out.println("Le prenom inserer est incorrect.\n --> Veuiler reessayer");
                    }
                } while (!prenom_ad.equals(prenom_admin));

            } else {
                System.out.println("Le nom inserer est incorrect.\n --> Veuiler reessayer");
            }
        } while (!nom_ad.equals(nom_admin));

    }

    public void Portail_connexion() {
        System.out.println("                *===============================================================*");
        System.out.println("                |          -- Universite de la Rennaissance d'Haiti --          |");
        System.out.println("                |                          URH / ISAG                           |");
        System.out.println("                |      --------------------------------------------------       |");
        System.out.println("                |                                                               |");
        System.out.println("                |                                                               |");
        System.out.println("                |  --> Application de gestion de bibliotheque                   |");
        System.out.println("                |                                                               |");
        System.out.println("                |                                                               |");
        System.out.println("                |                     -- Projet Final --                        |");
        System.out.println("                |                                                               |");
        System.out.println("                |                       Interface d'entre                       |");
        System.out.println("                |                      -------------------                      |");
        System.out.println("                |                                                               |");
        System.out.println("                |                          BIENVENNUE                           |");
        System.out.println("                |                                                               |");
        System.out.println("                |        ------------------------------------------------       |");
        System.out.println("                |                                                               |");
        System.out.println("                |                 --  Portail de connexion --                   |");
        System.out.println("                |    NB : Pour avoir acces a la bibliotheque, veuiller bien     |");
        System.out.println("                |         vouloir vous connecter etant qu'administrateur.       |");
        System.out.println("                |                                                               |");
        System.out.println("                |        ------------------------------------------------       |");
        System.out.println("                |                                                               |");
        System.out.println("                |  --> Appuyez sur :                                            |");
        System.out.println("                |                5 - Pour vous connecter:                       |");
        System.out.println("                |                                                               |");
        System.out.println("                |                                                               |");
        System.out.println("                |    --------------------------------------------------------   |");
        System.out.println("                |  NB : Pour quitter le programme, pressez 0.                   |");
        System.out.println("                *===============================================================*\n");
        System.out.print("---> ");
        String choix = cv.nextLine();
        do {
            switch (choix) {
                case "0":
                    System.out.println("Au revoir !!!");

                    break;
                case "5":
                    connexion();
                    break;
                default:
                    System.out.println("Votre choix est invalide ");
                    System.out.println(" --> Choisissez  5 ou 1");
                    Portail_connexion();
                    break;
            }
        } while (!choix.equals("0"));
    }

}
