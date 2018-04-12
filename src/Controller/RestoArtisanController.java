/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Restaurant;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import services.RestaurantService;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class RestoArtisanController implements Initializable {
    @FXML
    private Button Home;
    @FXML
    private Button Produits;
    @FXML
    private Button Annonces;
    @FXML
    private Button Evénements;
    @FXML
    private Button Restaurants;
    @FXML
    private Button SAV;
    @FXML
    private TableView<Restaurant> listAnnonce;
    @FXML
    private TableColumn<Restaurant, String> nomR;
    @FXML
    private TableColumn<Restaurant, String> adresse;
    @FXML
    private TableColumn<Restaurant, String> cat;
    @FXML
    private TableColumn<Restaurant, Integer> numtel;
    @FXML
    private TextField seach;
    @FXML
    private Button ajoutBtn;
    @FXML
    private Button modifBtn;
    @FXML
    private Button suppBtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RestaurantService Ann=new RestaurantService();
        ArrayList A= (ArrayList) Ann.AfficherRestaurant2();
        ObservableList ob=FXCollections.observableArrayList(A);
        listAnnonce.setItems(ob);
        nomR.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cat.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        numtel.setCellValueFactory(new PropertyValueFactory<>("numtel"));
        listAnnonce.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        FilteredList<Restaurant> fil= new FilteredList<>(ob,e->true);
        seach.setOnKeyReleased((KeyEvent e) -> {
            seach.textProperty().addListener((ObservableValue<? extends String> observableValue, String oldValue, String newValue) -> {
                fil.setPredicate((Predicate <? super Restaurant>) Annonce->{
                    if(newValue==null||newValue.isEmpty()){return true;}
                    String lower=newValue.toLowerCase();
                    if(Annonce.getNom().toLowerCase().contains(lower)){return true;}
                    else if(Annonce.getCategorie().toLowerCase().contains(lower)){return true;}
                     else if(Annonce.getAdresse().toLowerCase().contains(lower)){return true;}
                    return false;
                });
            });
            SortedList<Restaurant> k = new SortedList<>(fil);
            k.comparatorProperty().bind(listAnnonce.comparatorProperty());
            listAnnonce.setItems(k);
        });
    }    


     @FXML
    private void Home(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Home!");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    @FXML
    private void Produits(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ProduitArtisan.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Produits!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Annonces(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AnnoncesArtisan.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Annonces!");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    @FXML
    private void Event(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("affich.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Evenements!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Resto(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RestoArtisan.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Restaurants!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Sav(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SavArtisan.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Service Aprés Vente!");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
        Stage primary = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root2 = FXMLLoader.load(getClass().getResource("RestoArtisan.fxml"));
        Scene scene2 = new Scene(root2); 
        primary.setTitle("Restaurants!");
        primary.setScene(scene2);
        primary.show();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AjoutResto.fxml"));
        Scene scene = new Scene(root);        
        primaryStage.setTitle("Restaurants!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
        ObservableList<Restaurant> r,fo;
        fo=listAnnonce.getItems();
        r=listAnnonce.getSelectionModel().getSelectedItems();
        if(r.size()>0){
        Stage primary = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root2 = FXMLLoader.load(getClass().getResource("RestoArtisan.fxml"));
        Scene scene2 = new Scene(root2); 
        primary.setTitle("Restaurants!");
        primary.setScene(scene2);
        primary.show();
        Stage primaryStage=new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifierResto.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        r.stream().forEach((A) -> {
            ModifierRestoController controllerModifA = loader.getController();
            controllerModifA.DATA(A);
        });
        primaryStage.setTitle("Modifier Resto!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) throws IOException {
        ObservableList<Restaurant> r,fo;
        RestaurantService rs=new RestaurantService();
        fo=listAnnonce.getItems();
        r=listAnnonce.getSelectionModel().getSelectedItems();
        if(r!=null){
            r.stream().forEach((A) -> {
                rs.SupprimerRestaurant(A.getId());
            });
        }
        Stage primary = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root2 = FXMLLoader.load(getClass().getResource("RestoArtisan.fxml"));
        Scene scene2 = new Scene(root2); 
        primary.setTitle("Restaurants!");
        primary.setScene(scene2);
        primary.show();
    }
    
}
