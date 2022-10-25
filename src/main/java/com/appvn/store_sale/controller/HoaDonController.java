/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao.NhanVienDAO;
import com.appvn.store_sale.dao.TaoHoaDonDAO;
import com.appvn.store_sale.model.NhanVien;
import com.appvn.store_sale.model.TaoHoaDon;
import com.appvn.store_sale.res.StringValue;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class HoaDonController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ngu_trym();
    }
    private Stage stage;
    private Scene scene;

    @FXML
    public void taohoadon(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.TAO_HOA_DON));
        Parent nhanvien_parent = l.load();
        scene = new Scene(nhanvien_parent, 650, 500);
        stage.setScene(scene);
        stage.show();

    }

//    @FXML
//    private TableColumn<TaoHoaDon, String> khachhangColumn;
//    @FXML
//    private TableColumn<TaoHoaDon, DatePicker> ngaytaoColumn;
//    @FXML
//    private TableColumn<TaoHoaDon, Integer> nhanvienColumn;
    @FXML
    private TableView<TaoHoaDon> table_temp;

   

    @FXML
    private TableColumn<TaoHoaDon, Date> col_a;

    @FXML
    private TableColumn<TaoHoaDon, Integer> col_b;

    @FXML
    private TableColumn<TaoHoaDon, String> col_c;
    @FXML
    private TableView<TaoHoaDon> bang1;

    public void ngu_trym() {
        TaoHoaDonDAO dao = new TaoHoaDonDAO();

//        col1.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Date>("day"));
//        col2.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Integer>("nv"));
//        col3.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, String>("kh"));
//
        col_a.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Date>("day"));
        col_b.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Integer>("nv"));
        col_c.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, String>("kh"));
        ObservableList<TaoHoaDon> oblist = dao.selectAll();
        System.out.println("in trong controller " + oblist);
        bang1.setItems(oblist);

    }

}
