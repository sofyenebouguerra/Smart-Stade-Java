/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

/**
 *
 * @author BAZINFO
 */
public class Facture {
    
     private int code_facture,montant_facture,valeur_main_oeuvre,valeur_piece_recharge;
    private String date_facture;
    
    public Facture(){
    }
    public Facture(int code_facture,int montant_facture,int valeur_main_oeuvre,int valeur_piece_recharge,String date_facture){
        this.code_facture=code_facture;
        this.montant_facture=montant_facture;
        this.valeur_main_oeuvre=valeur_main_oeuvre;
        this.valeur_piece_recharge=valeur_piece_recharge;
        this.date_facture= date_facture;
    }

    public int getCode_facture() {
        return code_facture;
    }

    public void setCode_facture(int code_facture) {
        this.code_facture = code_facture;
    }

    public int getMontant_facture() {
        return montant_facture;
    }

    public void setMontant_facture(int montant_facture) {
        this.montant_facture = montant_facture;
    }

    public int getValeur_main_oeuvre() {
        return valeur_main_oeuvre;
    }

    public void setValeur_main_oeuvre(int valeur_main_oeuvre) {
        this.valeur_main_oeuvre = valeur_main_oeuvre;
    }

    public int getValeur_piece_recharge() {
        return valeur_piece_recharge;
    }

    public void setValeur_piece_recharge(int valeur_piece_recharge) {
        this.valeur_piece_recharge = valeur_piece_recharge;
    }

    public String getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(String date_facture) {
        this.date_facture = date_facture;
    }

  
    @Override
    public String toString() {
        return "FactureSousTraitance{" + "code_facture=" + code_facture + ", montant_facture=" + montant_facture + ", valeur_main_oeuvre=" + valeur_main_oeuvre + ", valeur_piece_recharge=" + valeur_piece_recharge + ", date_facture=" + date_facture + '}' +"\n";
    }

   
    
}
