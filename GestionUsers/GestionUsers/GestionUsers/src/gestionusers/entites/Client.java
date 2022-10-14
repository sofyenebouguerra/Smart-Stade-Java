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
public class Client extends User{
     private int ref_client,age_client;
     private String abonnement;

    public Client() {
    }

    public Client(int ref_client, int age_client,String abonnement, String nom, String prenom, String mot_de_passe, String email) {
        super(nom, prenom, mot_de_passe, email);
        this.ref_client = ref_client;
        this.age_client = age_client;
        this.abonnement=abonnement;
    }

    public Client(int ref_client, int age_client,String abonnement, int id_user, String nom, String prenom, String mot_de_passe, String email) {
        super(id_user, nom, prenom, mot_de_passe, email);
        this.ref_client = ref_client;
        this.age_client = age_client;
        this.abonnement=abonnement;
    }

    public int getRef_client() {
        return ref_client;
    }

    public void setRef_client(int ref_client) {
        this.ref_client = ref_client;
    }

    public int getAge_client() {
        return age_client;
    }

    public void setAge_client(int age_client) {
        this.age_client = age_client;
    }
     public String getAbonnement() {
        return abonnement;
    }
     
     public void setAbonnement(String abonnement) {
        this.abonnement = abonnement;
    }
}
