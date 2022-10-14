/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionusers.test;

import gestionusers.entites.User;
import gestionusers.services.ServiceUser;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author hajje
 */
public class CPanelController implements Initializable {

    @FXML
    private TableView<User> table_users;
    @FXML
    private TableColumn<User, Integer> col_id_user;
    @FXML
    private TableColumn<User, String> col_nom;
    @FXML
    private TableColumn<User, String> col_prenom;
    @FXML
    private TableColumn<User, String> col_mot_de_passe;
    @FXML
    private TableColumn<User, String> col_email;
     @FXML
    private TextField txt_Email;


    @FXML
    private TextField txt_Mot_De_Passe;

    @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_prenom;

    ObservableList<User> data=FXCollections.observableArrayList();
    
    ServiceUser su=new ServiceUser();
    int id_user_modifier;
    //ObservableList<User> ListM;
    //int index= -1;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    refreshlist();
    }   
    public void refreshlist(){
          data.clear();
        try {
            data=FXCollections.observableArrayList(su.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(CPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        col_id_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_mot_de_passe.setCellValueFactory(new PropertyValueFactory<>("mot_de_passe"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        
        table_users.setItems(data);
    }

    @FXML
    private void ajouter_user(ActionEvent event) {
        User u = new User(txt_nom.getText(),txt_prenom.getText(),txt_Mot_De_Passe.getText(),txt_Email.getText());
        su.ajouter(u);
        refreshlist();
    }

    @FXML
    private void modifier_user(ActionEvent event) {
        try {
            User u = new User(txt_nom.getText(),txt_prenom.getText(),txt_Mot_De_Passe.getText(),txt_Email.getText());
            su.modifier(id_user_modifier, u);
        } catch (SQLException ex) {
            Logger.getLogger(CPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshlist();
    }

    @FXML
    private void supprimer_user(ActionEvent event) {
        int id_user;
        id_user=table_users.getSelectionModel().getSelectedItem().getId_user();
        su.supprimer(id_user);
        refreshlist();
    }

    @FXML
    private void fill(MouseEvent event) {
        User u=table_users.getSelectionModel().getSelectedItem();
        id_user_modifier=u.getId_user();
        txt_nom.setText(u.getNom());
        txt_prenom.setText(u.getPrenom());
        txt_Email.setText(u.getEmail());
        txt_Mot_De_Passe.setText(u.getMotdepasse());
    }
    
}
