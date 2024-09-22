/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_Final;

import java.util.ArrayList;

/*import java.util.Date;
 //Importation de classes permettant la saisie de la forme de la date
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;*/
/**
 *
 * @author Alcide
 */
public class Livre {

    //Declaration des variables
    private String code_livre, titre, nom_auteur, categorie, date_sortie;
    private String emprunt = null;
   
    private int exemplaires, exemp_prete=0;
    private String statut =  "Disponible";
    //private Adherent adherent;

      ArrayList<Pret> ensemble_emprunt = new ArrayList<>();

    Adherent personnes = new Adherent();
    
    public Livre() {

    }

    public Livre(String code_livre, String titre, String nom_auteur, String categorie, String date_sortie, int exemplaires) {
        this.code_livre = code_livre;
        this.titre = titre;
        this.nom_auteur = nom_auteur;
        this.categorie = categorie;
        this.date_sortie = date_sortie;
        this.exemplaires = exemplaires;

    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCode_livre() {
        return code_livre;
    }

    public void setCode_livre(String code_livre) {
        this.code_livre = code_livre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom_auteur() {
        return nom_auteur;
    }

    public void setNom_auteur(String nom_auteur) {
        this.nom_auteur = nom_auteur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    public int getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(int exemplaires) {
        this.exemplaires = exemplaires;
    }

    public int getExemp_prete() {
        return exemp_prete;
    }

    public void setExemp_prete(int exemp_prete) {
        this.exemp_prete = exemp_prete;
    }
    
    

    public String getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(String emprunt) {
        this.emprunt = emprunt;
    }

    public ArrayList<Pret> getEnsemble_emprunt() {
        return ensemble_emprunt;
    }

   

    //Methode servant a afficher un livre
    public String Afficher_livre() {

        return "============================\n"
                + "         -Livre-         \n"
                + "      ----------------      \n"
                + "Code du livre          - [" + code_livre + "]\n"
                + "Titre du livre        || [" + titre + "]\n"
                + "Nom de l'auteur       || [" + nom_auteur + "]\n"
                + "Categorie             || [" + categorie + "]\n"
                + "Date de sortie        || [" + date_sortie + "]\n"
                + "Nombre d'exemplaitre  || [" + exemplaires + "]\n"
                + "                              \n"
                + "*----------------------------*\n"
                + "      Statut du livre       \n"
                + "       --------------       \n"
                + "Ce livre est : " + getStatut()+"\n "
                +"Nombre d'exemplaires pretes  || ["+ exemp_prete + "]\n\n";

    }
}
