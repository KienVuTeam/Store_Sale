/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.res.StringValue;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class HomeController  implements Initializable{
    private Stage stage;
    private Scene scene;
    //
    @FXML
    private Button btn_temp;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
        btn_temp.addEventHandler(ActionEvent.ACTION, eh->{
            try {
                Stage stage = (Stage) ((Node) eh.getSource()).getScene().getWindow();
                FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
                Parent p =load.load();
                scene = new Scene(p,1000, 700);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    //
    @FXML
    void atc_manager_storeHouse(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
        Parent p =load.load();
        scene = new Scene(p,1100, 700);
        stage.setScene(scene);
        stage.show();
        
    }
    
    
}
