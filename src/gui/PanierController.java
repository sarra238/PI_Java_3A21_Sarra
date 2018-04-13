/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Entities.Produit;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.scene.media.MediaView;
import services.Csv;
import services.ServiceProduitm;
import static utils.util.somme;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class PanierController implements Initializable {

    @FXML
    private AnchorPane label1;
    @FXML
    private AnchorPane label3;
    @FXML
    private Button supprimer;
    @FXML
    private TableView<Produit> affichageproduitcommande;
    @FXML
    private TableColumn<?, ?> NomProduit;
    @FXML
    private TableColumn<?, ?> Region;
    @FXML
    private TableColumn<?, ?> Categorie;
    @FXML
    private TableColumn<?, ?> Prix;
    @FXML
    private Button retour;
    @FXML
    private Button commander;
    @FXML
    private Button map;
    @FXML
    private Button rechercher;
    @FXML
    private Label label4;
    @FXML
    private TextField text1;
    private Label label;
    @FXML
    private Button Excel;
    @FXML
    private Text titre;
        ObservableList<Produit> listProduitcommande = FXCollections.observableArrayList();
         private JFXListView<Produit> liste;
    @FXML
    private Button stopBtn;
    @FXML
    private Button playBtn;
    @FXML
    private Button pauseBtn;
    
    MediaPlayer mediaplayer; 
    
    @FXML
    private MediaView mediaV;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
        {   
        NomProduit.setCellValueFactory(new PropertyValueFactory<>("NomProduit"));
        Region.setCellValueFactory(new PropertyValueFactory<>("Region"));
        Categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        Prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
       
       ServiceProduitm sp= new ServiceProduitm();
   try{
       listProduitcommande = sp.afficherCommande();
  
    affichageproduitcommande.setItems(listProduitcommande);
    }catch (SQLException ex) {
            Logger.getLogger(ServiceProduitm.class.getName()).log(Level.SEVERE, null, ex);
       }
   

        String VRul= "file:/C:/Users/Win10/Desktop/video/cc.mp4";
        Media media = new Media (VRul);
        mediaplayer = new MediaPlayer(media);
        mediaV.setMediaPlayer(mediaplayer);  
         if (mediaplayer.getStatus()==PLAYING)
        {
             mediaplayer.pause();
        }
    }
        
    

    @FXML
    private void supprimerproduit_commande(ActionEvent event) {
           affichageproduitcommande.setEditable(true);
        int selectedIndex = affichageproduitcommande.getSelectionModel().getSelectedIndex();

         Produit p = (Produit) affichageproduitcommande.getSelectionModel().getSelectedItem();
       //int x=p.getId();
          ServiceProduitm sp = new ServiceProduitm();

        if (selectedIndex >= 0) {
          affichageproduitcommande.getItems().remove(selectedIndex);
          // System.out.println(x);
       System.out.println(p.getPrix());
         sp.approuverdelate2(p.getPrix());
           somme -=p.getPrix();
        
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Pas de Selection un produit");
            alert.setHeaderText("vous n'avez pas sélectionner un produit !");
            alert.setContentText("veuillez sélectionner un produit dans la table");
            alert.showAndWait();

        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException 
    {
         if (mediaplayer.getStatus()==PLAYING)
        {
             mediaplayer.pause();
        }
    Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    appStage.close();
    }

    @FXML
    private void commander1(ActionEvent event) throws IOException 
    {
         if (mediaplayer.getStatus()==PLAYING)
        {
             mediaplayer.pause();
        }
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root=FXMLLoader.load(getClass().getResource("/pi/gui/panier.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("roduits!");
        primaryStage.setScene(scene);
        primaryStage.show();
        Stage Stage=new Stage();
        Parent root2=FXMLLoader.load(getClass().getResource("/pi/gui/ajoutcommande.fxml"));
        Scene scene2 = new Scene(root2);
        Stage.setTitle("Commande!");
        Stage.setScene(scene2);
        Stage.show();
    }


    @FXML
    private void map(ActionEvent event) throws IOException {
        if (mediaplayer.getStatus()==PLAYING)
        {
             mediaplayer.pause();
        }
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/pi/gui/panie.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("roduits!");
        primaryStage.setScene(scene);
        primaryStage.show();
        Stage Stage=new Stage();
        Parent root2=FXMLLoader.load(getClass().getResource("/pi/gui/Gmaps.fxml"));
        Scene scene2 = new Scene(root2);
        Stage.setTitle("Map!");
        Stage.setScene(scene2);
        Stage.show();
    }

    @FXML
    private void rechercher(ActionEvent event) {
         ServiceProduitm sp = new ServiceProduitm();
        int x;
            affichageproduitcommande.setEditable(true);

         NomProduit.setCellValueFactory(new PropertyValueFactory<>("NomProduit"));
       Region.setCellValueFactory(new PropertyValueFactory<>("Region"));
        Categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
     
        Prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
       
            listProduitcommande = sp.search_nom(text1.getText());
        affichageproduitcommande.setItems(listProduitcommande);
      

        // x=Integer.parseInt(rechercher.getText())  ;             
        if (text1.getText().equals("")) {
            label4.setText("veuillez donner le nom du produit");
        } else {
            String a=text1.getText();
            listProduitcommande = sp.search_nom(a);
            System.out.println(a);
            affichageproduitcommande.setItems(listProduitcommande);
            label4.setText("");
        }
    }


   
    
     @FXML
    private void Excel(ActionEvent event) throws SQLException
    {
        ServiceProduitm mservice= new ServiceProduitm();
         Csv csv=new Csv(mservice.afficher());
    }

    @FXML
    private void stop(ActionEvent event) {
        mediaplayer.stop();    
    }

    @FXML
    private void play(ActionEvent event) {
        MediaPlayer.Status status = mediaplayer.getStatus();
        if (status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED) {
            return;
        }
        if (status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.STOPPED || status == MediaPlayer.Status.READY) {
            mediaplayer.play();
        }
    }

    @FXML
    private void pause(ActionEvent event) {
        if (mediaplayer.getStatus()==PLAYING)
        {
             mediaplayer.pause();
        }
        else {
             mediaplayer.play(); 
        } 
    }
    
    
}
