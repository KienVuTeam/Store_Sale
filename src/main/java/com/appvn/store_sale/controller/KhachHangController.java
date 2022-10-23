/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.model.KhachHang;
import com.appvn.store_sale.dao.KhachHangDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class KhachHangController implements Initializable {

    
    @FXML
    private TableColumn<KhachHang, String> diachiColumn;

    @FXML
    private TableColumn<KhachHang, Integer> idColumn;

    @FXML
    private TableColumn<KhachHang, String> nameColumn;

    @FXML
    private TableColumn<KhachHang,Integer > sdtColumn;

    @FXML
    private TextField tfdiachi;

    @FXML
    private TextField tfname;

    @FXML
    private TextField tfsdt;
     private ObservableList<KhachHang> khachhangList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void add(ActionEvent e){
    KhachHang kh = new KhachHang();
    kh.setNameKH(tfname.getText());
    kh.setSDT(Integer.parseInt(tfsdt.getText()));
    kh.setDiaChi(tfdiachi.getText());
    
    
    KhachHangDAO dao = new KhachHangDAO();
    dao.add(kh);
    
    }
}
