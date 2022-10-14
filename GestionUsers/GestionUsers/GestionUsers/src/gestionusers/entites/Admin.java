/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionusers.entites;

/**
 *
 * @author hajje
 */
public class Admin extends User{
     private String ref_admin;

    public Admin() {
    }

    public Admin(String ref_admin, String nom, String prenom, String mot_de_passe, String email) {
        super(nom, prenom, mot_de_passe, email);
        this.ref_admin = ref_admin;
        
    }

    public Admin(String ref_admin, int id_user, String nom, String prenom, String mot_de_passe, String email) {
        super(id_user, nom, prenom, mot_de_passe, email);
        this.ref_admin = ref_admin;
       
    }

    public String getRef_admin() {
        return ref_admin;
    }

    public void setRef_admin(String ref_admin) {
        this.ref_admin = ref_admin;
    }

    

  
     
}
