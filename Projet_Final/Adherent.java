/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_Final;

/**
 *
 * @author Alcide David d
 */
public class Adherent {
    

    //Creation des attributs de la classe Adherent
    private String code_ad;
    private String nom_ad;
    private String prenom_ad;
    private String sexe_ad;
    private String faculte;
    private int nbre_pret=0;
    
    //Propriete pour les pret
    
    private String livre_emprunter= "Aucun";
    private String code_liv;
     private String nom_auteur;
    
    
    //Creation de constructeurs pour la classe Adherent
    public Adherent(String code_ad, String nom_ad, String prenom_ad, String sexe_ad, String faculte, int nbre_pret) {
        this.code_ad = code_ad;
        this.nom_ad = nom_ad;
        this.prenom_ad = prenom_ad;
        this.sexe_ad = sexe_ad;
        this.faculte = faculte;
        this.nbre_pret = nbre_pret;
       
    }
     public Adherent(String code_ad, String nom_ad, String prenom_ad, String sexe_ad, String faculte) {
        this.code_ad = code_ad;
        this.nom_ad = nom_ad;
        this.prenom_ad = prenom_ad;
        this.sexe_ad = sexe_ad;
        this.faculte = faculte;
    }
    
    
    
    public Adherent(){
        
    }

    //Creation des getters et des setters pour la classe Adherent
    public String getCode_ad() {
        return code_ad;
    }

    public void setCode_ad(String code_ad) {
        this.code_ad = code_ad;
    }

    public String getNom_ad() {
        return nom_ad;
    }

    public void setNom_ad(String nom_ad) {
        this.nom_ad = nom_ad;
    }

    public String getPrenom_ad() {
        return prenom_ad;
    }

    public void setPrenom_ad(String prenom_ad) {
        this.prenom_ad = prenom_ad;
    }

    public String getSexe_ad() {
        return sexe_ad;
    }

    public void setSexe_ad(String sexe_ad) {
        this.sexe_ad = sexe_ad;
    }

    public String getFaculte() {
        return faculte;
    }

    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }

    public int getNbre_pret() {
        return nbre_pret;
    }

    public void setNbre_pret(int nbre_pret) {
        this.nbre_pret = nbre_pret;
    }

    public String getLivre_emprunter() {
        return livre_emprunter;
    }

    public void setLivre_emprunter(String livre_emprunter) {
        this.livre_emprunter = livre_emprunter;
    }

    public String getCode_liv() {
        return code_liv;
    }

    public void setCode_liv(String code_liv) {
        this.code_liv = code_liv;
    }

    public String getNom_auteur() {
        return nom_auteur;
    }

    public void setNom_auteur(String nom_auteur) {
        this.nom_auteur = nom_auteur;
    }
    
    

    
    
    //Methode pour Afficher les Adherents
    public String Afficher_Adherent() {
        return "============================\n"
                + "         -Adherent-         \n"
                + "      ----------------      \n"
                + "Code      - [" + code_ad + "]\n"
                + "Nom      || [" + nom_ad + "]\n"
                + "Prenom   || [" + prenom_ad + "]\n"
                + "Sexe     || [" + sexe_ad + "]\n"
                + "Faculte  || [" + faculte + "]\n"
                + "Pret     || [" + nbre_pret + "]\n"
                +"Livre emprunter  || [" + livre_emprunter + "]\n"
                +"        ----------------          \n";
        
    }
    
    
     public String Afficher_Pret() {
        return "============================\n"
                + "         -Adherent-         \n"
                + "      ----------------      \n"
                + "Code de l'adherent      - [" + code_ad + "]\n"
                + "Nom & Prenom      || [" + nom_ad.toUpperCase() + " "+prenom_ad + "]\n"
                + "Sexe     || [" + sexe_ad + "]\n"
                + "Faculte  || [" + faculte + "]\n"
                +"                                \n"
                +"    Pret de cet Adherent     \n"
                +"    ---------------------    \n"
                +" Code du Livre || [" +code_liv + "] \n"
                +" Titre du livre || ["+livre_emprunter+"]\n"
                +" Auteur          || ["+nom_auteur+"]\n";
        
    }
    

    public String Pas_exister(String code) {
        return "Il n'existe aucumn adherent referent au code (" + code + ") inserer.\n" + "Veuiller reessayer.";
    }

}
