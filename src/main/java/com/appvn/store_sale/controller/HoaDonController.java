/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.model.HoaDon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class HoaDonController implements Initializable {

    @FXML
    private TextField tfchietsuat;

    @FXML
    private TextField tfdongia;

    @FXML
    private TextField tfkhachhangid;

    @FXML
    private TextField tfnamehd;

    @FXML
    private TextField tfnamesp;

    @FXML
    private TextField tfnhanvienid;

    @FXML
    private TextField tfsoluong;

    @FXML
    private TextField tfthanhtien;

    @FXML
    private TextField tftongcong;

    @FXML
    private TextField tftongsoluong;
    @FXML
    private TableColumn<HoaDon, Integer> chietsuatColumn;

    @FXML
    private TableColumn<HoaDon, Integer> dongiaColumn;

    @FXML
    private TableColumn<HoaDon, Integer> hdColumn;

    @FXML
    private TableColumn<HoaDon, Integer> khachhangidColumn;
 @FXML
    private Label tfthanhtien1;
    @FXML
    private TableColumn<HoaDon, String> namehdColumn;

    @FXML
    private TableColumn<HoaDon, String> namespColumn;

    @FXML
    private TableColumn<HoaDon, Integer> nhanvienidColumn;

    @FXML
    private TableColumn<HoaDon, Integer> soluongColumn;
    @FXML
    private TableColumn<HoaDon, Integer> thanhtienColumn;

    @FXML
    private TableColumn<HoaDon, Integer> tongcongColumn;

    @FXML
    private TableColumn<HoaDon, Integer> tongsoluongColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void tinhtien(ActionEvent event) {
        HoaDon hd = new HoaDon();
        
        hd.setSoLuong(Integer.valueOf(tfsoluong.getText()));
        hd.setDonGia(Integer.valueOf(tfdongia.getText()));
//        hd.setThanhTien(Integer.valueOf(tfthanhtien.getText()));
        
        
        int num1, num2, tong =0;
        num1 =hd.getSoLuong();
        num2 = hd.getDonGia();
        tong= num1 * num2;
//        hd.setThanhTien(tong);
        System.out.println("khoa ngoc: "+hd.getThanhTien());
        tfthanhtien1.setText(String.valueOf(tong));

        System.out.println("in tong ra man hinh: "+tong);
        System.out.println("Số lượng" + hd.getSoLuong()+"Đơn giá"+ hd.getDonGia());
        
    }

}
