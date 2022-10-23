/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.res.StringValue;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Manager_storeHouseController implements Initializable {
    private Stage stage;
    private Scene scene;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    // mac 
    public void indinhnit(){
        
    }
    //nha kho
     @FXML
    void atc_switch_store_house(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader load= new FXMLLoader(getClass().getResource(StringValue.SWITCH_STORE_HOUSE));
        Parent p= load.load();
        scene = new Scene(p, 1000, 700);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void atc_back(ActionEvent e) throws IOException{
        Stage stage =(Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader load= new FXMLLoader(getClass().getResource(StringValue.HOME_PAGE));
        Parent p=load.load();
        scene= new Scene(p, 650, 600);
        stage.setScene(scene);
        stage.show();
        
    }
    // 
    @FXML
    void oat_manage_dvt(ActionEvent event) throws IOException {
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.SWITCH_DVT));
        Parent layout_dvt=load.load();
        scene =new Scene(layout_dvt, 900, 550);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void oat_group_product(ActionEvent e) throws IOException{
        Stage stage =(Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.SWITCH_GROUP_PRODUCT));
        Parent layout=load.load();
        scene = new Scene(layout, 1100, 600);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void oat_manage_product(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.SWITCH_MANAGE_PRODUCT));
        Parent layout=load.load();
        scene = new Scene(layout, 1100, 600);
        stage.setScene(scene);
        stage.show();
    }
    @FXML 
    void oat_manage_sale_productPrice(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.SWICTH_MANAGR_SALE_PRODUCT_PRICE));
        Parent layout = load.load();
        scene = new Scene(layout,1200, 700);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void oat_manage_XNT_storeHouse(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.SWITCH_MANAGE_XNT_STOREHOUSE));
        Parent layout = load.load();
        scene = new Scene(layout,1200, 700);
        stage.setScene(scene);
        stage.show();
    }
}
