/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entites;

/**
 *
 * @author ismail
 */
public class Ticket {
    
    private String num_ticket;
    private String ref_match;
    private String num_place;
    private String disp;
    

    public Ticket() {
    }

    public Ticket(String num_ticket, String ref_match, String num_place, String disp) {
        this.num_ticket = num_ticket;
        this.ref_match = ref_match;
        this.num_place = num_place;
        this.disp = disp;
    }

    public String getNum_ticket() {
        return num_ticket;
    }

    public void setNum_ticket(String num_ticket) {
        this.num_ticket = num_ticket;
    }

    public String getRef_match() {
        return ref_match;
    }

    public void setRef_match(String ref_match) {
        this.ref_match = ref_match;
    }

    public String getNum_place() {
        return num_place;
    }

    public void setNum_place(String num_place) {
        this.num_place = num_place;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

    @Override
    public String toString() {
        return "Ticket{" + "num_ticket=" + num_ticket + ", ref_match=" + ref_match + ", num_place=" + num_place + ", disp=" + disp + '}';
    }
    

    
}