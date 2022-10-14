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
public class DemandeIntervention {
     private int ID_demande_intervention,Degre_urgence;
    private String Type_intervention,Intervention_demandee,Service_demandeur,Date_debut_intervention,Date_fin_intervention;
    
    

public DemandeIntervention() {
}

public DemandeIntervention(int ID_demande_intervention, int Degre_urgence,String Type_intervention,String Intervention_demandee,String Service_demandeur,String Date_debut_intervention,String Date_fin_intervention)
{
this.ID_demande_intervention=ID_demande_intervention;
this.Degre_urgence=Degre_urgence;
this.Type_intervention=Type_intervention;
this.Intervention_demandee=Intervention_demandee;
this.Service_demandeur=Service_demandeur;
this.Date_debut_intervention=Date_debut_intervention;
this.Date_fin_intervention=Date_fin_intervention;
}

  


     
    public int getID_demande_intervention() {
         return ID_demande_intervention;
    }

    /**
     *
     * @return
     */
    public int  getDegre_urgence() {
       
       return Degre_urgence;
    }

    public String getType_intervention() {
       return Type_intervention;
    }

    public String getIntervention_demandee() {
    return Intervention_demandee;
    }

    public String getService_demandeur() {
        return Service_demandeur;
    }

    public String getDate_debut_intervention() {
        return Date_debut_intervention;
    }

    public String getDate_fin_intervention() {
        return Date_fin_intervention;
    }
    public void setID_demande_intervention(int ID_demande_intervention){
        this.ID_demande_intervention=ID_demande_intervention;
    }
    public void setDegre_urgence(int Degre_urgence){
        this.Degre_urgence=Degre_urgence;
    }

    public void setIntervention_demandee(String Intervention_demandee) {
        this.Intervention_demandee = Intervention_demandee;
    }

    public void setService_demandeur(String Service_demandeur) {
        this.Service_demandeur = Service_demandeur;
    }

    public void setDate_debut_intervention(String Date_debut_intervention) {
        this.Date_debut_intervention = Date_debut_intervention;
    }

    public void setDate_fin_intervention(String Date_fin_intervention) {
        this.Date_fin_intervention = Date_fin_intervention;
    }

    public void setType_intervention(String Type_intervention) {
        this.Type_intervention = Type_intervention;
    }

    @Override
    public String toString() {
        return "DemandeIntervention{" + "ID_demande_intervention=" + ID_demande_intervention + ", Degre_urgence=" + Degre_urgence + ", Type_intervention=" + Type_intervention + ", Intervention_demandee=" + Intervention_demandee + ", Service_demandeur=" + Service_demandeur + ", Date_debut_intervention=" + Date_debut_intervention + ", Date_fin_intervention=" + Date_fin_intervention + '}'+"\n";
    }
    
    
    
}
