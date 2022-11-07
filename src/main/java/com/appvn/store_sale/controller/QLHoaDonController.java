/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;


import com.appvn.store_sale.dao_storeHouse.HoaDon_DAO;
import com.appvn.store_sale.model.HoaDon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author vippr
 */
public class QLHoaDonController implements Initializable {
        @FXML
    private TableColumn<HoaDon, Integer> mahd_col;

    @FXML
    private TableColumn<HoaDon, String> makh_col;

    @FXML
    private TableColumn<HoaDon, String> namekh_col;

    @FXML
    private TableColumn<HoaDon, String> namenv_col;

    @FXML
    private TableColumn<HoaDon, String> ngaytao_col;

    @FXML
    private TableView<HoaDon> tbl_hoadon;

    @FXML
    private TableColumn<HoaDon, Integer> tongtien_col;

    @FXML
    private TableColumn<HoaDon, String> trangthai_col;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            try {
            // TODO
            HoaDon_DAO jp = new HoaDon_DAO();
            ObservableList<HoaDon> ls = (ObservableList<HoaDon>) jp.finall_hoadon();
            mahd_col.setCellValueFactory(new PropertyValueFactory<>("idhd"));
            namekh_col.setCellValueFactory(new PropertyValueFactory<>("nameKH"));
            namenv_col.setCellValueFactory(new PropertyValueFactory<>("nameNV"));
            ngaytao_col.setCellValueFactory(new PropertyValueFactory<>("ngaytao"));
            makh_col.setCellValueFactory(new PropertyValueFactory<>("idKH"));
            trangthai_col.setCellValueFactory(new PropertyValueFactory<>("trangthai"));
            tongtien_col.setCellValueFactory(new PropertyValueFactory<>("tongtien"));
            tbl_hoadon.setItems(ls);
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
        }
    }
 public void showAlertWithHeaderText(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("Results:");
        alert.setContentText(content);
        alert.showAndWait();
    }    
    
}
