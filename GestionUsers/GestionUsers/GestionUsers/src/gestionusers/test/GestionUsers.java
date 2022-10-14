/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionusers.test;

import ApiMail.Mail;
import gestionusers.entites.Admin;
import gestionusers.entites.Client;
import gestionusers.entites.Employer;
import gestionusers.entites.User;
import gestionusers.services.ServiceUser;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hajje
 */
public class GestionUsers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        ServiceUser su = new ServiceUser();
//        User u = new User ("Ismail" ,"Bouchahoua", "12345" ,"farouk.hajjej@esprit.tn");
//        User a=new Admin("1x0f", "fff", "vv", "ee", "rrrr");
//        User c=new Client(123, 50,"A","ben foulen","Foulen", "0000","foulen.foulen@yahoo.com");
//        User e=new Employer("emp1oyer1", "F", "store1", "bbb", "aaa", "test", "testtt");
//        su.ajouter(u);
        //su.supprimer(8);
        try{
            //su.modifier(1,u);
            //System.out.println(su.afficher());
            Mail m =new Mail();

          m.sendMail("hajjej.farouk6@gmail.com", "97213990", 1);
        } catch (Exception ex) {
            Logger.getLogger(GestionUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
