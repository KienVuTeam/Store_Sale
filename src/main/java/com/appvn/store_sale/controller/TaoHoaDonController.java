/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao.TaoHoaDonDAO;
import com.appvn.store_sale.model.TaoHoaDon;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class TaoHoaDonController implements Initializable {

    @FXML
    private ComboBox<TaoHoaDon> cbKhachhang;

    @FXML
    private ComboBox<Integer> cbNhanvientao;

    @FXML
    private DatePicker dpNgaytao;
//    @FXML
//    private TableColumn<TaoHoaDon, String> khachhangColumn;

//    @FXML
//    private TableColumn<TaoHoaDon, Date> ngaytaoColumn;

//    @FXML
//    private TableColumn<TaoHoaDon, Integer> nhanvienColumn;

    @FXML
    void ngu(ActionEvent event) {
        System.out.println("o trong new windown run");
    }

    public int ComboBox() {
        ObservableList oblist = FXCollections.observableArrayList();
        String sql = "select id from NhanVien";

        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                oblist.add(rs.getInt("id"));
            }
            cbNhanvientao.setItems(oblist);
            rs.close();
            ps.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    public int ComboBox1() {
        ObservableList oblist = FXCollections.observableArrayList();
        String sql = "select nameKh from Customer";

        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                oblist.add(rs.getString("nameKh"));
            }
            cbKhachhang.setItems(oblist);
            rs.close();
            ps.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
    @FXML
    private TableView<TaoHoaDon> table_temp;

    @FXML
    void add(ActionEvent event) {
        TaoHoaDon thd = new TaoHoaDon();
        thd.setNgayTao(Date.valueOf(dpNgaytao.getValue()));
        thd.setNhanVienTao(cbNhanvientao.getValue());
        thd.setKhachHang(String.valueOf(cbKhachhang.getValue()));
        TaoHoaDonDAO dao = new TaoHoaDonDAO();
//        System.out.println("trong controller get value 3: "+thd.getNgayTao()+thd.getKhachHang()+thd.getNgayTao());
        dao.add(thd);
        cailoingu();
//        System.out.println("co chay trong controller ko");
    }

    @FXML 
    private TableColumn<TaoHoaDon,Date> col1;
    private TableColumn<TaoHoaDon,Integer> col2;
    private TableColumn<TaoHoaDon, String> col3;
    public void cailoingu() {
        TaoHoaDonDAO dao = new TaoHoaDonDAO();
        ObservableList<TaoHoaDon> list = dao.selectAll();
        System.out.println("in trong model controller: "+list);
        col1.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Date>("NgayTao"));
        col2.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Integer>("NhanVienTao"));
        col3.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, String>("KhachHang"));

        table_temp.setItems(list);
    }

    public void refresh(ActionEvent event) {
//        TaoHoaDonDAO dao = new TaoHoaDonDAO();
//        ngaytaoColumn.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Date>("NgayTao"));
//        nhanvienColumn.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Integer>("NhanVienTao"));
//        khachhangColumn.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, String>("KhachHang"));
//        ObservableList<TaoHoaDon> oblist = dao.refresh();
//        table.setItems(oblist);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComboBox();
        ComboBox1();
       cailoingu();
    }

}
