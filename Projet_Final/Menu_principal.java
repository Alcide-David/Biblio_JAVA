/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_Final;

/*
 * 
 *
 * @author Alcide
 */
// Instanciation des classes :
public class Menu_principal {
    
    
    public static void main(String[] args) {
        

        Bibliotheque_URH biblio = new Bibliotheque_URH();
        //Appel de la methode qui ajoute l'administrateur
        biblio.Ajout_auto_Administrateur();
        //Appel de la methode qui ajoute le livre
        biblio.Ajout_auto_livre();
        //Appel de la methode qui ajoute l'adherent
        biblio.Ajout_auto_ad();
        
        // Appel du portail de connexion
        biblio.Portail_connexion();
        // Appel de la methode pour se connecter
        biblio.connexion();
        
    }
}
