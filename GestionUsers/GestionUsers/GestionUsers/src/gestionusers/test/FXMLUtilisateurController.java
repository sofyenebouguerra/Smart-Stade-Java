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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.print.ServiceUI;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hajje
 */
public class FXMLUtilisateurController implements Initializable {

    @FXML
    private AnchorPane pane_login;
    @FXML
    private TextField txt_nom;
    @FXML
    private PasswordField txt_mot_de_passe;
    @FXML
    private Button btn_login;
    @FXML
    private AnchorPane pane_signup;
    @FXML
    private TextField txt_nom_up;
    @FXML
    private TextField txt_prenom_up;
    @FXML
    private TextField txt_mot_de_passe_up;
    @FXML
    private TextField txt_email_up;
    
    
    @FXML
    public void LoginpaneShow(){
        pane_login.setVisible(true);
        pane_signup.setVisible(false);
    }
    @FXML
    public void SignuppaneShow(){
        pane_login.setVisible(false);
        pane_signup.setVisible(true);
    }
    ServiceUser su =new ServiceUser();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnlogin(ActionEvent event) throws Exception{
        try {
            if(su.loginverif(txt_nom.getText(), txt_mot_de_passe.getText())){
                JOptionPane.showMessageDialog(null, "Nom et mot de passe sont corrects");
                //System.out.println("Account founded");
                btn_login.getScene().getWindow().hide();
                Parent root =FXMLLoader.load(getClass().getResource("CPanel.fxml"));
                Stage mainStage =new Stage();
                Scene scene =new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
            } 
                
            else{
                //System.out.println("Not Founded");
                JOptionPane.showMessageDialog(null, "Invalide nom et mot de passe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    

    @FXML
    private void btnsignup(ActionEvent event) {
        su.ajouter(new User(txt_nom_up.getText(),txt_prenom_up.getText(),txt_mot_de_passe_up.getText(),txt_email_up.getText()));
        JOptionPane.showMessageDialog(null, "Account Saved and Added");
        //System.out.println("Account added");
    }
    
}
