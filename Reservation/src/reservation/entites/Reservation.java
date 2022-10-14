/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entites;

import java.sql.Date;

/**
 *
 * @author ismail
 */
public class Reservation {
    private int id_reservation;
    private int cin_client;
    private String ref_match;
    private String num_ticket;
    private Date date_reservation;

    public Reservation() {
    }

    public Reservation(int cin_client, String ref_match, String num_ticket) {
        this.cin_client = cin_client;
        this.ref_match = ref_match;
        this.num_ticket = num_ticket;
        
    }

    public Reservation(int id_reservation, int cin_client, String ref_match, String num_ticket) {
        this.id_reservation = id_reservation;
        this.cin_client = cin_client;
        this.ref_match = ref_match;
        this.num_ticket = num_ticket;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getCin_client() {
        return cin_client;
    }

    public void setCin_client(int cin_client) {
        this.cin_client = cin_client;
    }

    public String getRef_match() {
        return ref_match;
    }

    public void setRef_match(String ref_match) {
        this.ref_match = ref_match;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public String getNum_ticket() {
        return num_ticket;
    }

    public void setNum_place(String num_ticket) {
        this.num_ticket = num_ticket;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", cin_client=" + cin_client + ", ref_match=" + ref_match + ", num_ticket=" + num_ticket + ", date_reservation=" + date_reservation + '}';
    }

    

    

   
    }

   
    
