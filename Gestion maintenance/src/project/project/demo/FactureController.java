/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author BAZINFO
 */
public class FactureController implements Initializable {
    @FXML
    private TextField TFcode;

    @FXML
    private TextField TFdate_facture;
    
    @FXML
    private TextField TFmontant_facture;

    @FXML
    private TextField TFvaleur_main_oeuvre;

    @FXML
    private TextField TFvaleur_piece_recharge;

    @FXML
    private Button idsavee;

    @FXML
    private Button idshow;

    @FXML
    private TableView<Facture> idtabl;

    @FXML
    private TableColumn<Facture, Integer> callcode;

    @FXML
    private TableColumn<Facture, String> calldate;

    @FXML
    private TableColumn<Facture, Integer> callmontant;

    @FXML
    private TableColumn<Facture, Integer> callmain;

    @FXML
    private TableColumn<Facture, Integer> callpiece;

    @FXML
    private Button iddel;
     @FXML
    private Button idreturn;

     @FXML
    void changeScreenButtonPushed(ActionEvent event) throws IOException {
        idreturn.getScene().getWindow().hide();
                Parent root =FXMLLoader.load(getClass().getResource("Main.fxml"));
                Stage mainStage1 =new Stage();
                Scene scene =new Scene(root);
                
                mainStage1.setScene(scene);
                mainStage1.show();

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {        
        
        if(event.getSource() == idsavee){
            insertRecord();
        }else if (event.getSource() == idshow){
            updateRecord();
        }else if(event.getSource() == iddel){
            deleteButton();
        }
            
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showFacture();
    }
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/freeways_smart_stadium_management", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<Facture> getFactureList(){
        ObservableList<Facture> FactureList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM facture_sous_traitance";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Facture facture;
            while(rs.next()){
                facture = new Facture(rs.getInt("code_facture"), rs.getInt("montant_facture"),rs.getInt("valeur_main_oeuvre"),rs.getInt("valeur_piece_recharge"),rs.getString("date_facture"));
                FactureList.add(facture);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return FactureList;
    }
    
    public void showFacture(){
        ObservableList<Facture> list = getFactureList();
        
        callcode.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("code_facture"));
        calldate.setCellValueFactory(new PropertyValueFactory<Facture, String>("date_facture"));
        callmontant.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("montant_facture"));
        callmain.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("valeur_main_oeuvre"));
        callpiece.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("valeur_piece_recharge"));
        
        idtabl.setItems(list);
    }
    private void insertRecord(){
        String query = "INSERT INTO facture_sous_traitance VALUES (" + TFcode.getText() + "," + TFmontant_facture.getText() + "," + TFvaleur_main_oeuvre.getText() + ","
                + TFvaleur_piece_recharge.getText() + ",'" + TFdate_facture.getText() + "')";
        executeQuery(query);
        showFacture();
    }
    private void updateRecord(){
        String query = "UPDATE  facture_sous_traitance SET montant_facture  = " + TFmontant_facture.getText() + ", valeur_main_oeuvre = " + TFvaleur_main_oeuvre.getText() + ", valeur_piece_recharge = " +
                TFvaleur_piece_recharge.getText() + ", date_facture = " + TFdate_facture.getText() + " WHERE code_facture = " + TFcode.getText() + "";
        executeQuery(query);
        showFacture();
    }
    private void deleteButton(){
        String query = "DELETE FROM facture_sous_traitance WHERE code_facture =" + TFcode.getText() + "";
        executeQuery(query);
        showFacture();
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


  
  
    
}


