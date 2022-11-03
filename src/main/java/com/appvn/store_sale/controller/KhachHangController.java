/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.model.KhachHang;
import com.appvn.store_sale.dao.KhachHangDAO;
import com.appvn.store_sale.model.TaoHoaDon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TableColumn<KhachHang, String> nameColumn2;

    @FXML
    private TableColumn<KhachHang, Integer> sdtColumn;
    @FXML
    private TableView< KhachHang> bang3;

    @FXML
    private TextField tfdiachi1;

    @FXML
    private TextField tfname1;

    @FXML
    private TextField tfsdt;
    private ObservableList<KhachHang> khachhangList;
     @FXML
    private Label lbidKhachhang;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        test();
//        showOnClick();
    }

    public void add(ActionEvent e) {
        KhachHang kh = new KhachHang();
        kh.setNameKH(tfname1.getText());
        kh.setSDT(Integer.parseInt(tfsdt.getText()));
        kh.setDiaChi(tfdiachi1.getText());

        KhachHangDAO dao = new KhachHangDAO();
        dao.add(kh);

    }

    public void test() {
        KhachHangDAO dao = new KhachHangDAO();
        idColumn.setCellValueFactory(new PropertyValueFactory<KhachHang, Integer>("idKH"));
        nameColumn2.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("nameKH"));
        sdtColumn.setCellValueFactory(new PropertyValueFactory<KhachHang, Integer>("SDT"));
        diachiColumn.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("DiaChi"));
        ObservableList<KhachHang> oblist = dao.selectAll1();
        System.out.println("in trong controller " + oblist);
        bang3.setItems(oblist);
    }
    
    
}
