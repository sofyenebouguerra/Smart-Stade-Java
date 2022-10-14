/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication7.tournoifooot.equipe;
import javaapplication7.tournoifooot.tournoi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javaapplication7.service.Servicetournoi;
import javaapplication7.service.Serviceequipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author RafedDz
 */
public class FXMLapkpidevController implements Initializable {

    @FXML
    private AnchorPane paneltournoi;
    @FXML
    private TextField ftidtournoi;
    @FXML
    private TextField ftnomtournoi;
    @FXML
    private TextField ftnbrequipes;
    @FXML
    private TextField ftdebuttournoi;
    @FXML
    private TextField ftfintournoi;
    @FXML
    private TextField ftheurematch;
    @FXML
    private TextField ftnbrgroupes;
    @FXML
    private TableView<tournoi> tbtournoi;
    @FXML
    private TableColumn<tournoi, Integer> colidtournoi;
    @FXML
    private TableColumn<tournoi, String> colnomtournoi;
    @FXML
    private TableColumn<tournoi, Integer> colnbrequipes;
    @FXML
    private TableColumn<tournoi, String> coldebuttournoi;
    @FXML
    private TableColumn<tournoi, String> colfintournoi;
    @FXML
    private TableColumn<tournoi, Integer> colheuretournoi;
    @FXML
    private TableColumn<tournoi, Integer> colnbrgroupes;
    @FXML
    private Button butajoutertournoi;
    @FXML
    private Button butmodifiertournoi;
    @FXML
    private Button butsupprimertournoi;
    @FXML
    private AnchorPane panelequipe;
    @FXML
    private TextField ftidequipe;
    @FXML
    private TextField ftnomequipe;
    @FXML
    private TableView<equipe> tableequipe;
    @FXML
    private TableColumn<equipe, Integer> colidequipe;
    @FXML
    private TableColumn<equipe, String> colnomequipe;
    @FXML
    private Button butajouterequipe;
    @FXML
    private Button butmodifierequipe;
    @FXML
    private Button butsupprimerequipe;
    
    Serviceequipe se=new Serviceequipe();
    Servicetournoi sto=new Servicetournoi();
    @FXML
    private TableColumn<equipe, String> colabbrequipe;
    @FXML
    private TableColumn<equipe, Integer> colnbreffectif;
    @FXML
    private TableColumn<equipe, Integer> colnbrstaff;
    @FXML
    private TableColumn<equipe, String> colnompres;
    @FXML
    private TableColumn<equipe, String> colnomentr;
    @FXML
    private TableColumn<equipe, String> colnomcapit;
    @FXML
    private TextField ftabbrequipe;
    @FXML
    private TextField ftnbreffectif;
    @FXML
    private TextField ftnbrstaff;
    @FXML
    private TextField ftnompresident;
    @FXML
    private TextField ftnomentraineur;
    @FXML
    private TextField ftnomcapitaine;
    @FXML
    private AnchorPane panelstat;
    @FXML
    private BarChart<?, ?> statnbreqtourn;
    @FXML
    private NumberAxis nbrequipesy;
    @FXML
    private CategoryAxis tournoisx;
    @FXML
    private BarChart<?, ?> statequipe;
    @FXML
    private NumberAxis nbreffectif;
    @FXML
    private CategoryAxis equipee;
    
    @FXML
    public void pabeletournoishow(){
        paneltournoi.setVisible(true);
        panelequipe.setVisible(false);
        panelstat.setVisible(false);
    }
    
    @FXML
    public void pabelequipeshow(){
        paneltournoi.setVisible(false);
        panelequipe.setVisible(true);
        panelstat.setVisible(false);
    }
    
    @FXML
    public void pabelstatshow(){
        paneltournoi.setVisible(false);
        panelequipe.setVisible(false);
        panelstat.setVisible(true);
    }
    

    
    PreparedStatement preparedStatement;
    Connection connection;
    ObservableList<tournoi> listT=FXCollections.observableArrayList();
    //ObservableList<tournoi> dataList;
    ObservableList<equipe> listE=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        showTournoi();
        //searchtournoi();
   
    }   
    
    
    
        public void showTournoi() {
        listT.clear();
        try {
            listT=FXCollections.observableArrayList(sto.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLapkpidevController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colidtournoi.setCellValueFactory(new PropertyValueFactory<tournoi,Integer>("id_tournoi"));
        colnomtournoi.setCellValueFactory(new PropertyValueFactory<tournoi,String>("nom_tournoi"));
        colnbrequipes.setCellValueFactory(new PropertyValueFactory<tournoi,Integer>("nbr_equipes"));
        coldebuttournoi.setCellValueFactory(new PropertyValueFactory<tournoi,String>("date_debut_tournoi"));
        colfintournoi.setCellValueFactory(new PropertyValueFactory<tournoi,String>("date_fin_tournoi"));
        colheuretournoi.setCellValueFactory(new PropertyValueFactory<tournoi, Integer>("heure_match_tournoi"));
        colnbrgroupes.setCellValueFactory(new PropertyValueFactory<tournoi, Integer>("nbr_poules"));
      //  TableView.getItems().stream().filter(item -> item.getCin()==1).findAny().ifPresent(item -> {TableView.getSelectionModel().select(item);
      //  TableView.scrollTo(item);});
        tbtournoi.setItems(listT);
        }
        
        public void showEquipe() {
        listT.clear();
        try {
            listE=FXCollections.observableArrayList(se.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLapkpidevController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colidequipe.setCellValueFactory(new PropertyValueFactory<equipe,Integer>("id_equipe"));
        colnomequipe.setCellValueFactory(new PropertyValueFactory<equipe,String>("nom_equipe"));
        colabbrequipe.setCellValueFactory(new PropertyValueFactory<equipe,String>("abbreviation_equipe"));
        colnbreffectif.setCellValueFactory(new PropertyValueFactory<equipe,Integer>("nbr_effectif"));
        colnbrstaff.setCellValueFactory(new PropertyValueFactory<equipe,Integer>("nbr_staff"));
        colnompres.setCellValueFactory(new PropertyValueFactory<equipe,String>("nom_president_equipe"));
        colnomentr.setCellValueFactory(new PropertyValueFactory<equipe,String>("nom_entraineur_equipe"));
        colnomcapit.setCellValueFactory(new PropertyValueFactory<equipe,String>("nom_capitaine_equipe"));
       

      //  TableView.getItems().stream().filter(item -> item.getCin()==1).findAny().ifPresent(item -> {TableView.getSelectionModel().select(item);
      //  TableView.scrollTo(item);});
        tableequipe.setItems(listE);
        }


    @FXML
    private void savetournoi(ActionEvent event) {
        tournoi t = new tournoi();
        t.setId_tournoi(Integer.parseInt(ftidtournoi.getText()));
        t.setNom_tournoi(ftnomtournoi.getText());
        t.setNbr_equipes(Integer.parseInt(ftnbrequipes.getText()));
        t.setDate_debut_tournoi(ftdebuttournoi.getText());
        t.setDate_fin_tournoi(ftfintournoi.getText());
        t.setHeure_match_tournoi(Integer.parseInt(ftheurematch.getText()));
        t.setNbr_poules(Integer.parseInt(ftnbrgroupes.getText()));
        sto.ajouter(t);
        showTournoi();
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data(t.getNom_tournoi(),t.getNbr_equipes()));
        statnbreqtourn.getData().addAll(set1);
    }
    @FXML
    private void modifiertournoi(ActionEvent event) {
            tournoi x = new tournoi();
            x.setNom_tournoi(ftnomtournoi.getText());
            x.setNbr_equipes(Integer.parseInt(ftnbrequipes.getText()));
            x.setDate_debut_tournoi(ftdebuttournoi.getText());
            x.setDate_fin_tournoi(ftfintournoi.getText());
            x.setHeure_match_tournoi(Integer.parseInt(ftheurematch.getText()));
            x.setNbr_poules(Integer.parseInt(ftnbrgroupes.getText()));
            sto.modifier(Integer.parseInt(ftidtournoi.getText()), x);
            showTournoi();
            XYChart.Series set1 = new XYChart.Series<>();
            set1.getData().add(new XYChart.Data(x.getNom_tournoi(),x.getNbr_equipes()));
            statnbreqtourn.getData().addAll(set1);


    }

    @FXML
    private void supprimertournoi(ActionEvent event) {
            
            sto.supprimer(Integer.parseInt(ftidtournoi.getText()));
            showTournoi();
    }
    
        public void executeQuery(String query) {

        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void saveequipe(ActionEvent event) {
        equipe e = new equipe();
        e.setId_equipe(Integer.parseInt(ftidequipe.getText()));
        e.setNom_equipe(ftnomequipe.getText());
        e.setAbbreviation_equipe(ftabbrequipe.getText());
        e.setNbr_effectif(Integer.parseInt(ftnbreffectif.getText()));
        e.setNbr_staff(Integer.parseInt(ftnbrstaff.getText()));
        e.setNom_president_equipe(ftnompresident.getText());
        e.setNom_entraineur_equipe(ftnomentraineur.getText());
        e.setNom_capitaine_equipe(ftnomcapitaine.getText());
        se.ajouter(e);
        showEquipe();
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data(e.getNom_equipe(),e.getNbr_effectif()));
        statequipe.getData().addAll(set1);
    }

    @FXML
    private void modifierequipe(ActionEvent event) {
        equipe s = new equipe();
        s.setNom_equipe(ftnomequipe.getText());
        s.setAbbreviation_equipe(ftabbrequipe.getText());
        s.setNbr_effectif(Integer.parseInt(ftnbreffectif.getText()));
        s.setNbr_staff(Integer.parseInt(ftnbrstaff.getText()));
        s.setNom_president_equipe(ftnompresident.getText());
        s.setNom_entraineur_equipe(ftnomentraineur.getText());
        s.setNom_capitaine_equipe(ftnomcapitaine.getText());
        se.modifier(Integer.parseInt(ftidequipe.getText()), s);
        showEquipe();
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data(s.getNom_equipe(),s.getNbr_effectif()));
        statequipe.getData().addAll(set1);
    }

    @FXML
    private void supprimerequipe(ActionEvent event) {
        se.supprimer(Integer.parseInt(ftidequipe.getText()));
        showEquipe();    
    }
}