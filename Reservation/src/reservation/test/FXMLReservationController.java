/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.test;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import reservation.entites.Reservation;
import reservation.services.ServiceReservation;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import reservation.entites.Match_foot;
import reservation.services.ServiceMatch_foot;
import reservation.entites.Ticket;
import reservation.services.ServiceTicket;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;
import javafx.scene.control.cell.PropertyValueFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.imageio.ImageIO;



import javafx.scene.input.MouseEvent;


import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.sql.Date;

import java.util.ArrayList;

import java.util.List;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import reservation.services.Service_generer_Qr_code;



/**
 * FXML Controller class
 *
 * @author ismail
 */
public class FXMLReservationController implements Initializable {
    
 @FXML
    private HBox Hbutt;

    @FXML
    private TextField TFcin;

    @FXML
    private TextField TFdate;

    @FXML
    private TextField TFdisp;
    
    @FXML
    private TextField TFnsp;

    @FXML
    private TextField TFnumero;

    @FXML
    private TextField TFnumplace;

    @FXML
    private TextField TFnumt;

    @FXML
    private TextField TFrefT;

    @FXML
    private TextField TFreference;

    @FXML
    private TextField TFreference1;

    @FXML
    private TextField TFstade;

    @FXML
    private AnchorPane match;
    @FXML
    private CategoryAxis x;

    @FXML
    private BarChart<?, ?> xyz;

    @FXML
    private NumberAxis y;



      @FXML
    private TableColumn<Reservation,Integer> colcin;

    @FXML
    private TableColumn<Reservation,String> coldate;
    @FXML
    private TableColumn<Reservation,String> colnum;

    @FXML
    private TableColumn<Reservation,String> colref;
    @FXML
    private TableView<Reservation> tablereservation;

    @FXML
    private AnchorPane reservation;
    @FXML
    private AnchorPane ticket;
    @FXML
    private AnchorPane cd;
    
    @FXML
    private TableColumn<Match_foot,String>colr;
    @FXML
    private TableColumn <Match_foot,String>cold;
    @FXML
    private TableColumn<Match_foot,String> coln;
@FXML
    private TableColumn<Match_foot,Integer> colns;

    
    @FXML
    private TableView<Match_foot> tabelmatch;
    @FXML
  
    private TableColumn<Ticket,String> colnum1;
    @FXML
  
    private TableColumn<Ticket,String> colnum2;
    @FXML
    private TableColumn<Ticket,String> coldisp;

    @FXML
    private TableColumn<Ticket,String> colref1;
   
    @FXML
    private TableView <Ticket> tableticket;
    
   
    
    private ServiceReservation sr;
    private ServiceMatch_foot sm;
    private ServiceTicket st;
   
    
    public void reservation(){
        reservation.setVisible(true);
        match.setVisible(false);
        ticket.setVisible(false);
    }
     public void match(){
        reservation.setVisible(false);
        match.setVisible(true);
        
        ticket.setVisible(false);
    }
      public void ticket(){
           reservation.setVisible(false);
           match.setVisible(false);
        ticket.setVisible(true);
       
    }
      public void dd(){
           reservation.setVisible(false);
           match.setVisible(false);
        ticket.setVisible(false);
        cd.setVisible(true);
      }
    
    PreparedStatement preparedStatement;
    Connection connection;
    ObservableList<Reservation> list  =FXCollections.observableArrayList();
    ObservableList<Match_foot> listm  =FXCollections.observableArrayList();
    ObservableList<Ticket> listt  = FXCollections.observableArrayList();
    
Service_generer_Qr_code qr =new Service_generer_Qr_code();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            sr = new  ServiceReservation();
            sm = new ServiceMatch_foot();
            st = new ServiceTicket();
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        showreservation();
        
    }    
    
    
    @FXML
    private void ajouter(ActionEvent event) {
        Reservation r = new Reservation();
        
        r.setCin_client(Integer.parseInt(TFcin.getText()));
        r.setRef_match(TFreference.getText());
        r.setNum_place(TFnumero.getText());
        
        sr.ajouter(r);
        showreservation();
        qr.create(TFreference.getText(),TFnumero.getText());
        
        
    }
    
    
    @FXML
    private void chr(ActionEvent event) throws SQLException {
        Reservation r =new Reservation();
         
        r.setCin_client(Integer.parseInt(TFcin.getText()));
     
        sr.recherche(Integer.parseInt(TFcin.getText()));
        showreservation();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
  public void showreservation() {
        list.clear();
        try {
            list=FXCollections.observableArrayList(sr.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colcin.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("cin_client"));
        colref.setCellValueFactory(new PropertyValueFactory<Reservation,String>("ref_match"));
        colnum.setCellValueFactory(new PropertyValueFactory<Reservation,String>("num_ticket"));
        coldate.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_reservation"));
        
     
        tablereservation.setItems(list);
        }
        
    
    @FXML
    private void supprimer(ActionEvent event) {
        Reservation r =new Reservation();
         
        r.setCin_client(Integer.parseInt(TFcin.getText()));
     
        sr.supprimer(Integer.parseInt(TFcin.getText()));
        showreservation();
    }
    
 @FXML
    private void update(ActionEvent event) {
        Reservation r =new Reservation();
        r.setCin_client(Integer.parseInt(TFcin.getText()));
        r.setRef_match(TFreference.getText());
        r.setNum_place(TFnumero.getText());
        sr.modifier(Integer.parseInt(TFcin.getText()), r);
        showreservation();
         showmatch(); 
    }
   
    
    @FXML
    private void ajoutermatch(ActionEvent event) {
        Match_foot m = new Match_foot();
        m.setRef_match(TFreference1.getText());
        m.setDate_match(TFdate.getText());
        m.setNom_stade(TFstade.getText());
         m.setNbr_spectateur(Integer.parseInt(TFnsp.getText()));
        sm.ajouter(m);
        showmatch();
         XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data(m.getRef_match(),m.getNbr_spectateur()));
        xyz.getData().addAll(set1);
        
    } 
    
    @FXML
    private void supprimermatch(ActionEvent event) {
        Match_foot m =new Match_foot();
         
        m.setRef_match(TFreference1.getText());
        sm.supprimer(TFreference1.getText());
        showmatch();
    }
    
    @FXML
  public void showmatch() {
        listm.clear();
        try {
            listm=FXCollections.observableArrayList(sm.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colr.setCellValueFactory(new PropertyValueFactory<Match_foot,String>("ref_match"));
        cold.setCellValueFactory(new PropertyValueFactory<Match_foot,String>("date_match"));
        coln.setCellValueFactory(new PropertyValueFactory<Match_foot,String>("nom_stade"));
        colns.setCellValueFactory(new PropertyValueFactory<Match_foot,Integer>("nbr_spectateur"));
        tabelmatch.setItems(listm);
        }
         @FXML
    private void modifiermatch(ActionEvent event) {
        Match_foot m =new Match_foot();
        m.setRef_match(TFreference1.getText());
        m.setDate_match(TFdate.getText());
        m.setNom_stade(TFstade.getText());
        m.setNbr_spectateur(Integer.parseInt(TFnsp.getText()));
        sm.modifier((TFreference1.getText()), m);
       
         showmatch(); 
    }
   
    
     @FXML
    private void ajouterticket(ActionEvent event) {
        Ticket t = new Ticket();
        t.setNum_ticket(TFnumt.getText());
        t.setRef_match(TFrefT.getText());
        t.setNum_place(TFnumplace.getText());
         t.setDisp(TFdisp.getText());
        
        st.ajouter(t);
     showticket();
    } 
    @FXML
    private void supprimerticket(ActionEvent event) {
        Ticket t =new Ticket();
         
        t.setNum_ticket(TFnumt.getText());
        st.supprimer(TFnumt.getText());
         showticket();
    }
    
     @FXML
  public void showticket() {
        listt.clear();
        try {
            listt=FXCollections.observableArrayList(st.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colnum1.setCellValueFactory(new PropertyValueFactory<Ticket,String>("num_ticket"));
        colref1.setCellValueFactory(new PropertyValueFactory<Ticket,String>("ref_match"));
        colnum2.setCellValueFactory(new PropertyValueFactory<Ticket,String>("num_place"));
        coldisp.setCellValueFactory(new PropertyValueFactory<Ticket,String>("disp"));
        
     
      tableticket.setItems(listt);
        }
    
    @FXML
    private void rechercher (ActionEvent event) throws SQLException {
        Ticket t =new Ticket();
         
        t.setNum_ticket(TFnumt.getText());
        st. Search(TFnumt.getText());
         
    }
    @FXML
    private void Modifert(ActionEvent event) {
        Ticket t =new Ticket();
        t.setNum_ticket((TFnumt.getText()));
        t.setRef_match(TFrefT.getText());
        t.setNum_place(TFnumplace.getText());
        st.modifier((TFnumt.getText()), t);
        showreservation();
         showticket(); 
    }
    
    
    
    
}
