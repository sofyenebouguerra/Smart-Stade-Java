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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MainController implements Initializable {
    
    @FXML
    private TextField tfId;

    @FXML
    private TextField tfdeg;

    @FXML
    private TextField tftype;

    @FXML
    private TextField tfinter;

    @FXML
    private TextField tfser;

    @FXML
    private TextField tfdeb;

    @FXML
    private TextField tffin;

    @FXML
    private TableView<DemandeIntervention> tvdemande;

    @FXML
    private TableColumn<DemandeIntervention, Integer> colId;

    @FXML
    private TableColumn<DemandeIntervention, Integer> coldegre;

    @FXML
    private TableColumn<DemandeIntervention, String> coltype;

    @FXML
    private TableColumn<DemandeIntervention, String> colinter;

    @FXML
    private TableColumn<DemandeIntervention, String> colser;

    @FXML
    private TableColumn<DemandeIntervention, String> coldeb;

    @FXML
    private TableColumn<DemandeIntervention, String> colfin;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
     @FXML
    private Button idsh;

   
   

   
    
    @FXML
    private void handleButtonAction(ActionEvent event) {        
        
        if(event.getSource() == btnInsert){
            insertRecordd();
        }else if (event.getSource() == btnUpdate){
            updateRecordd();
        }else if(event.getSource() == btnDelete){
            deleteButtonn();
        }
            
    }
     @FXML
    void changeScreenButtonPushed(ActionEvent event) throws IOException {
        idsh.getScene().getWindow().hide();
                Parent root =FXMLLoader.load(getClass().getResource("FXMLFacture.fxml"));
                Stage mainStage1 =new Stage();
                Scene scene =new Scene(root);
                mainStage1.setTitle("Facture sous traitance");
                mainStage1.setScene(scene);
                mainStage1.show();

    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       showDemande();
    }
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/freeways_smart_stadium_management", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<DemandeIntervention> getDemandeInterventionList(){
        ObservableList<DemandeIntervention> DemandeInterventionList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM demande_intervention";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            DemandeIntervention demandeintervention;
            while(rs.next()){
                demandeintervention = new DemandeIntervention(rs.getInt("ID_demande_intervention"),rs.getInt("Degre_urgence"), rs.getString("Type_intervention"), rs.getString("Intervention_demandee"), rs.getString("Service_demandeur"),rs.getString("Date_debut_intervention"),rs.getString("Date_fin_intervention"));
                DemandeInterventionList.add(demandeintervention);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return DemandeInterventionList;
    }
    
    public void showDemande(){
        ObservableList<DemandeIntervention> list = getDemandeInterventionList();
        
        colId.setCellValueFactory(new PropertyValueFactory<DemandeIntervention, Integer>("ID_demande_intervention"));
        coldegre.setCellValueFactory(new PropertyValueFactory<DemandeIntervention, Integer>("Degre_urgence"));
        coltype.setCellValueFactory(new PropertyValueFactory<DemandeIntervention, String>("Type_intervention"));
        colinter.setCellValueFactory(new PropertyValueFactory<DemandeIntervention, String>("Intervention_demandee"));
        colser.setCellValueFactory(new PropertyValueFactory<DemandeIntervention, String>("Service_demandeur"));
        coldeb.setCellValueFactory(new PropertyValueFactory<DemandeIntervention, String>("Date_debut_intervention"));
        colfin.setCellValueFactory(new PropertyValueFactory<DemandeIntervention, String>("Date_debut_intervention"));
        
        
        tvdemande.setItems(list);
    }
    private void insertRecordd(){
        String query = "INSERT INTO demande_intervention VALUES (" + tfId.getText() +",'" + tftype.getText() + "','"
                + tfinter.getText() + "','" + tfdeb.getText() + "','" + tffin.getText() + "','" + tfser.getText() + "'," + tfdeg.getText() + ")";
        executeQuery(query);
        showDemande();
    }
    private void updateRecordd(){
        String query = "UPDATE  demande_intervention SET   Type_intervention= '" + tftype.getText() + "',Intervention_demandee= '"+ tfinter.getText() + "',Date_debut_intervention= '" + tfdeb.getText() + "',Date_fin_intervention = '" + tffin.getText() + "',Service_demandeur = '" + tfser.getText() + "', Degre_urgence = " + tfdeg.getText() + "  WHERE ID_demande_intervention = " + tfId.getText() + " ";
        executeQuery(query);
        showDemande();
    }
    private void deleteButtonn(){
        String query = "DELETE FROM demande_intervention WHERE ID_demande_intervention =" + tfId.getText() + "";
        executeQuery(query);
        showDemande();
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
