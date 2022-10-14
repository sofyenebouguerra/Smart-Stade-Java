/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MainController implements Initializable {
    
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Matrielle, String> colachat;

    @FXML
    private TableColumn<Matrielle, String> coldispo;

    @FXML
    private TableColumn<Matrielle, String> coletat;

    @FXML
    private TableColumn<Matrielle, Integer> colid;

    @FXML
    private TableColumn<Matrielle, String> colnom;

    @FXML
    private TableColumn<Matrielle, Integer> colprix;

    @FXML
    private TableColumn<Matrielle, String> colref;

    @FXML
    private TextField tfachat;

    @FXML
    private TextField tfdispo;

    @FXML
    private TextField tfetat;

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfprix;

    @FXML
    private TextField tfref;

    @FXML
    private TableView<Matrielle> tvmatrielle;
    
    

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsert){
            insertRecord();
        }else if (event.getSource() == btnUpdate){
            updateRecord();
        }else if(event.getSource() == btnDelete){
            deleteButton();
        }
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
    public ObservableList<Matrielle> getMatrielleList(){
        ObservableList<Matrielle> matrielleList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM matrielle";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Matrielle Matrielle;
            while(rs.next()){
                Matrielle = new Matrielle(rs.getInt("id_m"),rs.getString("nom_m"), rs.getString("ref_m"), rs.getString("achat_m"), rs.getString("etat_m"),rs.getString("disponibilite_m"),rs.getInt("prix_m"));
                matrielleList.add(Matrielle);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return matrielleList;
    }
    
    public void showDemande(){
        ObservableList<Matrielle> list = getMatrielleList();
        
        colid.setCellValueFactory(new PropertyValueFactory<Matrielle,Integer>("id_m"));
        colnom.setCellValueFactory(new PropertyValueFactory<Matrielle,String>("nom_m"));
        colref.setCellValueFactory(new PropertyValueFactory<Matrielle,String>("ref_m"));
        colachat.setCellValueFactory(new PropertyValueFactory<Matrielle,String>("achat_m"));
        coletat.setCellValueFactory(new PropertyValueFactory<Matrielle,String>("etat_m"));
        coldispo.setCellValueFactory(new PropertyValueFactory<Matrielle,String>("disponibilite_m"));
        colprix.setCellValueFactory(new PropertyValueFactory<Matrielle,Integer>("prix_m"));
        
        
        tvmatrielle.setItems(list);
    }
    private void insertRecord(){
        String query = "INSERT INTO matrielle VALUES (" + tfid.getText() +",'" + tfref.getText() + "','"
                + tfachat.getText() + "','" + tfetat.getText() + "','" + tfdispo.getText() + "','" + tfnom.getText() + "'," + tfprix.getText() + ")";
        executeQuery(query);
        showDemande();
    }
    private void updateRecord(){
        String query = "UPDATE  matrielle SET   ref_m= '" + tfref.getText() + "',achat_m= '"+ tfachat.getText() + "',disponibilite_m= '" + tfdispo.getText() + "',prix_m = " + tfprix.getText() + ",etat_m = '" + tfetat.getText() + "', nom_m = '" + tfnom.getText() + "'  WHERE id_m = " + tfid.getText() + " ";
        executeQuery(query);
        showDemande();
    }
    private void deleteButton(){
        String query = "DELETE FROM matrielle WHERE id_m =" + tfid.getText() + "";
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

//    private void showmatrielle() {
//    }
//        
    
}
