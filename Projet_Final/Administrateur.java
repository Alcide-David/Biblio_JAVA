/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_Final;

/**
 *
 * @author Alcide
 */
public class Administrateur {
    String nom_adm, prenom_adm, code_adm;

    public Administrateur() {
    }

    public Administrateur(String nom_adm, String prenom_adm, String code_adm) {
        this.nom_adm = nom_adm;
        this.prenom_adm = prenom_adm;
        this.code_adm = code_adm;
    }

    public String getNom_adm() {
        return nom_adm;
    }

    public void setNom_adm(String nom_adm) {
        this.nom_adm = nom_adm;
    }

    public String getPrenom_adm() {
        return prenom_adm;
    }

    public void setPrenom_adm(String prenom_adm) {
        this.prenom_adm = prenom_adm;
    }

    public String getCode_adm() {
        return code_adm;
    }

    public void setCode_adm(String code_adm) {
        this.code_adm = code_adm;
    }
    
    
}
