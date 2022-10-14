/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.ImageView;
//import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class StadeController implements Initializable {

   // @FXML
   // private ImageView img;
    
    @FXML
    private Button update;
    @FXML
    private Button insert;
    @FXML
    private Button delete;
    @FXML
    private TextField l_id;
    @FXML
    private TextField l_nom;
    @FXML
    private TextField l_capacite;
    @FXML
    private TableColumn<stade, Integer> colids;
    @FXML
    private TableColumn<stade, String> colnoms;
    @FXML
    private TableColumn<stade, Integer> colcaps;
    @FXML
    private TableView<stade> table;
    
    

        @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == insert){
            insertRecord();
        }else if (event.getSource() == update){
            updateRecord();
        }else if(event.getSource() == delete){
            deleteButton();
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showDemande();
    }    
    
        public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/freeways_stade-2", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
     }
        
        public ObservableList<stade> getStadeList(){
        ObservableList<stade> stadeList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM stade";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            stade stade;
            while(rs.next()){
                stade = new stade(rs.getInt("id_stade"),rs.getString("nom_stade"), rs.getInt("capacite"));
                stadeList.add(stade);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return stadeList;
    }
        
        public void showDemande(){
        ObservableList<stade> list = getStadeList();
        
        colids.setCellValueFactory(new PropertyValueFactory<stade,Integer>("id_stade"));
        colnoms.setCellValueFactory(new PropertyValueFactory<stade,String>("nom_stade"));
        colcaps.setCellValueFactory(new PropertyValueFactory<stade,Integer>("capacite"));

        
        
        table.setItems(list);
    }  
        
            private void insertRecord(){
        String query = "INSERT INTO stade VALUES (" + l_id.getText() +",'" + l_nom.getText() + "','"
                + l_capacite.getText() + ")";
        executeQuery(query);
        showDemande();
    }
                private void updateRecord(){
        String query = "UPDATE  stade SET   nom_stade= '" + l_id.getText() + "',capacite= '"+ l_nom.getText() +  "'  WHERE id_stade = " + l_id.getText() + " ";
        executeQuery(query);
        showDemande();
    }
                    private void deleteButton(){
        String query = "DELETE FROM stade WHERE id_stade =" + l_id.getText() + "";
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
