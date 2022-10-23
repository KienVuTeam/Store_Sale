/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class PhieuThuController implements Initializable {

    @FXML
    private TableColumn<?, ?> diachiColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> idKHColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> sotienColumn;

    @FXML
    private TextField tfDiaChi;

    @FXML
    private TextField tfKH;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSoTien;

    @FXML
    void add(ActionEvent event) {

    }
    public void khachhangid(){
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
