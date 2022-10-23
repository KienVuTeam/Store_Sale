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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class PageOfManagementController implements Initializable {
    private Stage stage;
    private Scene scene;
@FXML
    public void phieuthu(ActionEvent event) throws IOException {
         Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.PHIEU_THU));
        Parent nhanvien_parent = l.load();
        scene = new Scene(nhanvien_parent, 650, 500);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void phieuchi(ActionEvent event) throws IOException {
         Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.PHIEU_CHI));
        Parent nhanvien_parent = l.load();
        scene = new Scene(nhanvien_parent, 650, 500);
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
