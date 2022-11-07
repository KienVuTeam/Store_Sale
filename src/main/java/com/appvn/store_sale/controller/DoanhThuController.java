/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;


import com.appvn.store_sale.dao_storeHouse.DoanhThuDAO;
import com.appvn.store_sale.dao_storeHouse.HoaHongDAO;
import com.appvn.store_sale.dao_storeHouse.TienHoaHongDAO;
import com.appvn.store_sale.model.HoaHong;
import com.appvn.store_sale.model.TienHoaHong;
import com.appvn.store_sale.model.TongTienHoaHong;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class DoanhThuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableColumn<HoaHong, Integer> maColumn;

    @FXML
    private TableColumn<HoaHong, Integer> maColumn1;

    @FXML
    private TableView<HoaHong> table;

    @FXML
    private TableColumn<HoaHong, Integer> tienColumn1;
    @FXML
    private TableColumn<TienHoaHong, Integer> maColumn2;

    @FXML
    private TableColumn<TienHoaHong, Integer> maColumn3;

    @FXML
    private TableView<TienHoaHong> table1;
     @FXML
    private TableColumn<TongTienHoaHong,Integer> maColumn5;
      @FXML
    private TableColumn<TongTienHoaHong,Integer> tienColumn5;
      @FXML
    private TableView<TongTienHoaHong> table2;

    @FXML
    private TableColumn<TienHoaHong, Integer> tienColumn2;
    @FXML
    private Label lbhoadon;

    @FXML
    private Label lbnhanvien;

    @FXML
    private Label lbtien;

    
    
    @FXML
    void mouse1(MouseEvent event) {
        HoaHong hh = (HoaHong) table.getSelectionModel().getSelectedItem();
      lbhoadon.setText(String.valueOf(hh.getID_HD()));
      lbnhanvien.setText(String.valueOf(hh.getMaNV()));
      int num1,tong;
      num1= hh.getTongtien();
      tong = (int) (num1 * 0.02);
      lbtien.setText(String.valueOf(tong));
    }
 @FXML
    void add(ActionEvent event) {
            TienHoaHong hh = new TienHoaHong();
            hh.setID_HD(Integer.valueOf(lbhoadon.getText()));
            hh.setMaNV(Integer.valueOf(lbnhanvien.getText()));
            hh.setHoahong(Integer.valueOf(lbtien.getText()));
            TienHoaHongDAO dao = new TienHoaHongDAO();
            dao.add(hh);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        show();
        show1();
        tongket1();
    }

    public void show() {
        DoanhThuDAO dao = new DoanhThuDAO();

        maColumn.setCellValueFactory(new PropertyValueFactory<HoaHong, Integer>("ID_HD"));
        maColumn1.setCellValueFactory(new PropertyValueFactory<HoaHong, Integer>("maNV"));
        tienColumn1.setCellValueFactory(new PropertyValueFactory<HoaHong, Integer>("tongtien"));
        ObservableList<HoaHong> oblist = dao.selectAll();
        table.setItems(oblist);
    }
    public void show1(){
        DoanhThuDAO dao = new DoanhThuDAO();
    maColumn2.setCellValueFactory(new PropertyValueFactory<>("ID_HD"));
        maColumn3.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        tienColumn2.setCellValueFactory(new PropertyValueFactory<>("hoahong"));
        ObservableList<TienHoaHong> oblist = dao.selectAll1();
                table1.setItems(oblist);
    }
    public void tongket1(){
        HoaHongDAO dao = new HoaHongDAO();
//    idColumn1.setCellValueFactory(new PropertyValueFactory<TongTienHoaHong, Integer>("id"));
    maColumn5.setCellValueFactory(new PropertyValueFactory<TongTienHoaHong, Integer>("idnhanvien"));
    tienColumn5.setCellValueFactory(new PropertyValueFactory<TongTienHoaHong, Integer>("tongtienhoahong"));
    ObservableList<TongTienHoaHong> oblish = dao.selectAll();
        table2.setItems(oblish);
    }
}
