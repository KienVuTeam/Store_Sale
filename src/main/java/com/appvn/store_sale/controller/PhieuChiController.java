/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class PhieuChiController implements Initializable {

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> maColumn;

    @FXML
    private TableView<?> table;

    @FXML
    private Label tfma;

    @FXML
    private Label tfngay;

    @FXML
    private Label tftien;

    @FXML
    private TableColumn<?, ?> tienColumn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
