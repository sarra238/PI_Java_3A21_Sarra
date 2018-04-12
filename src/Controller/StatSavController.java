/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Win10
 */
public class StatSavController implements Initializable {
    @FXML
    private PieChart pie;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int i,j,k,r,f;
         ReclamationService a = new ReclamationService();
        i= a.Count("Produit Périmé");
        j=a.Count("Produit non livrer");
        k= a.Count("Reclamation Restaurant");
        r= a.Count("Evenement debile");
        f=a.Count("Autre ...");
        ObservableList<PieChart.Data> pieE=
             FXCollections.observableArrayList(
             new PieChart.Data("Produit Périmé", i),
             new PieChart.Data("Produit non livrer", j),
             new PieChart.Data("Reclamation Restaurant", k),
             new PieChart.Data("Evenement debile", r),
             new PieChart.Data("Autre ...", f)
        );
        pie.setData(pieE);  
    }    
    
}
