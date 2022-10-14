/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.sql.SQLException;
import javaapplication7.service.Serviceequipe;
import javaapplication7.service.Servicetournoi;
import javaapplication7.tournoifooot.equipe;
import javaapplication7.tournoifooot.tournoi;

/**
 *
 * @author RafedDz
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        {
        //tournoi p = new tournoi("mohamed ", 15 , "15/02/2002" ,"15/03/2002" ,6,4);
        //equipe l = new equipe("dzayer");
        //Servicetournoi sp = new Servicetournoi();
        Serviceequipe sl = new Serviceequipe();
        Servicetournoi sto=new Servicetournoi();
       // sp.ajouter(p);
//        sl.ajouter(l);
//        //tournoi p1 = new tournoi("ali", 10 , "12/02/2002" ,"10/03/2002" ,6,4);
//        equipe l1 = new equipe("maroc");
//        //sp.modifier(1,p1);
//        sl.modifier(4,l1);
//        //sp.supprimer(10);
//        sl.supprimer(4);
//        //sp.recherche(12);
//        sl.recherche(4);
        try {
            System.out.println(sto.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
}
