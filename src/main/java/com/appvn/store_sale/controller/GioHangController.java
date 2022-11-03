/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao.GioHangDAO;
import com.appvn.store_sale.model.GioHang;
import com.appvn.store_sale.model.SanPham;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class GioHangController implements Initializable {

    @FXML
    private TextField tfdongiasanpham;

    @FXML
    private TextField tfnamesanpham;

    @FXML
    private TextField tfsoluongsanpham;

    @FXML
    void add_sanpham(ActionEvent event) {
//        GioHang sp = new GioHang();
//        sp.setName(String.valueOf(tfnamesanpham.getText()));
//        sp.setGiabanle(Float.valueOf(tfdongiasanpham.getText()));
//        GioHangDAO dao = new GioHangDAO();
//        dao.add();
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
