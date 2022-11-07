/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;


import com.appvn.store_sale.dao_storeHouse.HoaHongDAO;
import com.appvn.store_sale.model.HoaHong;
import com.appvn.store_sale.model.TongTienHoaHong;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class HoaHongController implements Initializable {

      @FXML
    private TableColumn<HoaHong, Integer> idColumn;

    @FXML
    private TableColumn<HoaHong, Integer> idnvColumn;
     @FXML
    private TableColumn<HoaHong, Integer> idhdColounm;


    @FXML
    private TableView<HoaHong> table;

    @FXML
    private TableColumn<HoaHong, Integer> tienColumn;
     @FXML
    private TableView<TongTienHoaHong> table1;
    @FXML
    private TableColumn<TongTienHoaHong, Integer> idnvColumn1;
    @FXML
    private TableColumn<TongTienHoaHong, Integer> idColumn1;

    @FXML
    private TableColumn<TongTienHoaHong, Integer> tongColumn1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tongket();
        tongket1();
    }    
    public void tongket(){
    HoaHongDAO dao = new HoaHongDAO();
//    idColumn.setCellValueFactory(new PropertyValueFactory<HoaHong, Integer>("id"));
    idnvColumn.setCellValueFactory(new PropertyValueFactory<HoaHong, Integer>("maNV"));
    tienColumn.setCellValueFactory(new PropertyValueFactory<HoaHong, Integer>("tongtien"));
    idhdColounm.setCellValueFactory(new PropertyValueFactory<HoaHong, Integer>("ID_HD"));
           ObservableList<HoaHong> oblish = dao.selectAll1();
           table.setItems(oblish);
    }
    public void tongket1(){
        HoaHongDAO dao = new HoaHongDAO();
//    idColumn1.setCellValueFactory(new PropertyValueFactory<TongTienHoaHong, Integer>("id"));
    idnvColumn1.setCellValueFactory(new PropertyValueFactory<TongTienHoaHong, Integer>("idnhanvien"));
    tongColumn1.setCellValueFactory(new PropertyValueFactory<TongTienHoaHong, Integer>("tongtienhoahong"));
    ObservableList<TongTienHoaHong> oblish = dao.selectAll();
        table1.setItems(oblish);
    }
}
