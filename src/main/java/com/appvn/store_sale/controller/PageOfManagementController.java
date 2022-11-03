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
    void page_banhang(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.HoaDon));
        Parent nhanvien = l.load();
        scene = new Scene(nhanvien, 1273, 783);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void page_nhanvien(ActionEvent event) throws IOException {
Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.NHAN_VIEN));
        Parent nhanvien_parent = l.load();
        scene = new Scene(nhanvien_parent, 962, 558);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void page_phieuchi(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.PHIEU_CHI));
        Parent nhanvien_parent = l.load();
        scene = new Scene(nhanvien_parent, 650, 500);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void page_phieuthu(ActionEvent event) {

    }

    @FXML
    void page_thongke(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.THONG_KE));
        Parent nhanvien_parent = l.load();
        scene = new Scene(nhanvien_parent, 774, 561);
        stage.setScene(scene);
        stage.show();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
