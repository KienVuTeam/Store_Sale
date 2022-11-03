/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao.GioHangDAO;
import com.appvn.store_sale.dao.LapHoaDonDAO;
import com.appvn.store_sale.dao.NhomSanPhamDAO;
import com.appvn.store_sale.dao.TaoHoaDonDAO;
import com.appvn.store_sale.model.GioHang;
import com.appvn.store_sale.model.LapHoaDon;

import com.appvn.store_sale.model.NhomSanPham;

import com.appvn.store_sale.model.TaoHoaDon;
import com.appvn.store_sale.res.StringValue;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class HoaDonController implements Initializable {

    Integer TongTien = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        refresh();
//        thanhtoan();
        act_show();
        list_product();
        hoadon();
        giohangList();
        

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

    public void add1(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.KHACH_HANG));
        Parent nhanvien_parent = l.load();
        scene = new Scene(nhanvien_parent, 650, 500);
        stage.setScene(scene);
        stage.show();
    }
    private ObservableList<GioHang> giohangList;

    public void giohangList() {
        giohangList = FXCollections.observableArrayList();
        idhdColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<GioHang, String>("name"));
        dongiaColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Float>("dongia"));
        soluongColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Integer>("soluong"));
        thanhtienColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Float>("thanhtien"));
        bang3.setItems(giohangList);

    }
   
    //Test Id Of Customer
    @FXML
    private TableView<GioHang> bang3;
//Gio Hang

//List products
    @FXML
    private TableView<NhomSanPham> bang2;

    @FXML
    private TableColumn<NhomSanPham, Integer> idnspColumn1;
    @FXML
    private TableColumn<NhomSanPham, String> nameColumn1;
    @FXML
    private TableColumn<NhomSanPham, String> loaiColumn;
    @FXML
    private TableColumn<NhomSanPham, Integer> giabanColumn;
    @FXML
    private TableColumn<NhomSanPham, Integer> tonkhoColumn;
    @FXML
    private TableColumn<NhomSanPham, Integer> idspColumn1;
    @FXML
    private TableColumn<GioHang, Integer> idhdColumn;
    @FXML
    private TableColumn<GioHang, String> nameColumn;
    @FXML
    private TableColumn<GioHang, Float> dongiaColumn;
    @FXML
    private TableColumn<GioHang, Integer> soluongColumn;
    @FXML
    private TableColumn<GioHang, Float> thanhtienColumn;

    @FXML
    private TableColumn<TaoHoaDon, Integer> col_a;
    @FXML
    private TableColumn<TaoHoaDon, Date> col_b;
    @FXML
    private TableColumn<TaoHoaDon, String> col_c;
    @FXML
    private TableColumn<TaoHoaDon, Integer> col_d;

    @FXML
    private Label lbnameKhachhang;
    @FXML
    private Label lbthanhtien, lbNgayTao,lbnhanvienid;
    @FXML
    private Label lbIdhoadon,lbhoahong;
    @FXML
    private Label lbidKhachhang;

    @FXML
    private Label lbTongTien;

    @FXML
    private TableView<TaoHoaDon> table_temp;
    @FXML
    private TextField tfnameproduct, tfgiaban;

    @FXML
    private TextField tfnumber;
     @FXML
    private TextArea tfghichu;

    public void TestLabel() {

    }

    @FXML
    void showOnClick(MouseEvent e) {

        TaoHoaDon thd = (TaoHoaDon) table_temp.getSelectionModel().getSelectedItem();

        lbNgayTao.setText(String.valueOf(thd.getDay()));
        lbIdhoadon.setText(String.valueOf(thd.getId1()));
        lbnameKhachhang.setText(String.valueOf(thd.getKh()));
        lbnhanvienid.setText(String.valueOf(thd.getNv()));
//        lbidKhachhang.setText(String.valueOf(thd.getId()));
        System.out.println("in test sang nay trong controller: " + thd.getId1());
        System.out.println("in test sang nay trong controller: " + thd.getKh());
    }

    @FXML
    void showOnClick1(MouseEvent e) {

        NhomSanPham nsp = (NhomSanPham) bang2.getSelectionModel().getSelectedItem();
//       tfidsanpham.setText(Integer.toString(nsp.getId()));
        tfnameproduct.setText(String.valueOf(nsp.getName()));
//       tfloai.setText(String.valueOf(nsp.getLoai()));
        tfgiaban.setText(Integer.toString(nsp.getDongiaban()));
//       tftonkho.setText(Integer.toString(nsp.));
//       san sp = (SanPham) bang2.getSelectionModel().getSelectedItem();
//        tfidsanpham.setText(Integer.toString(sp.getId()));
//        tfnameproduct.setText(String.valueOf(sp.getName()));
//        tfprice.setText(String.valueOf(sp.getGiabanle()));
    }

    public void hoadon() {
        TaoHoaDonDAO dao = new TaoHoaDonDAO();

        col_a.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Integer>("id1"));
        col_b.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Date>("day"));
        col_c.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, String>("nv"));
        col_d.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Integer>("kh"));

        ObservableList<TaoHoaDon> oblist = dao.selectAll();
        System.out.println("in trong controller " + oblist);
        table_temp.setItems(oblist);

    }

   @FXML
   void Refresh(ActionEvent event){
     TaoHoaDonDAO dao = new TaoHoaDonDAO();

        col_a.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Integer>("id1"));
        col_b.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Date>("day"));
        col_c.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, String>("nv"));
        col_d.setCellValueFactory(new PropertyValueFactory<TaoHoaDon, Integer>("kh"));

        ObservableList<TaoHoaDon> oblist = dao.selectAll();
   }
   

    

    public void list_product() {
        NhomSanPhamDAO dao = new NhomSanPhamDAO();
//        SanPham sp = new SanPham();
        idnspColumn1.setCellValueFactory(new PropertyValueFactory<NhomSanPham, Integer>("id"));
        nameColumn1.setCellValueFactory(new PropertyValueFactory<NhomSanPham, String>("name"));
        loaiColumn.setCellValueFactory(new PropertyValueFactory<NhomSanPham, String>("loai"));
        giabanColumn.setCellValueFactory(new PropertyValueFactory<NhomSanPham, Integer>("dongiaban"));
        tonkhoColumn.setCellValueFactory(new PropertyValueFactory<NhomSanPham, Integer>("tonkho"));
        idspColumn1.setCellValueFactory(new PropertyValueFactory<NhomSanPham, Integer>("idSp"));
        ObservableList<NhomSanPham> oblist = dao.selectAll1();
        System.out.println("in bảng: " + oblist);
        bang2.setItems(oblist);
    }

    @FXML
    void add_sanpham(ActionEvent event) {

        GioHang gh = new GioHang();

        gh.setName(tfnameproduct.getText());
        gh.setDongia(Float.valueOf(tfgiaban.getText()));
        gh.setSoluong(Integer.parseInt(tfnumber.getText()));
        gh.setThanhtien(Float.valueOf(lbthanhtien.getText()));
        GioHangDAO dao = new GioHangDAO();
        dao.add(gh);

        act_show();
        giohangList.add(gh);
        tfnameproduct.clear();
        tfgiaban.clear();
        tfnumber.clear();
        

    }

    public void act_show() {
        GioHangDAO dao = new GioHangDAO();

        idhdColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<GioHang, String>("name"));
        dongiaColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Float>("dongia"));
        soluongColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Integer>("soluong"));
        thanhtienColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Float>("thanhtien"));
        ObservableList<GioHang> oblist = dao.refresh();
//        bang3.setItems(oblist);*
        System.out.println("in show: " + oblist);

    }

    public void refresh() {
//        GioHangDAO dao = new GioHangDAO();
//        idhdColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Integer>("id"));
//        nameColumn.setCellValueFactory(new PropertyValueFactory<GioHang, String>("name"));
//        dongiaColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Float>("dongia"));
//        soluongColumn.setCellValueFactory(new PropertyValueFactory<GioHang, Integer>("soluong"));
//
//        ObservableList<GioHang> oblist = dao.selectAll();
//        bang3.setItems(oblist);
    }

    @FXML
    public void thanhtoan(ActionEvent event) {
        try {
            System.out.println("com.appvn.store_sale.controller.HoaDonController.thanhtoan()");
            GioHang gh = new GioHang();
            gh.setDongia(Float.valueOf(tfgiaban.getText()));
            gh.setSoluong(Integer.valueOf(tfnumber.getText()));
            float num1;
            int num2, tong = 0, hoahong=0;
            num1 = gh.getDongia();
            num2 = gh.getSoluong();

            tong = (int) (num1 * num2);
            lbthanhtien.setText(String.valueOf(tong));
            TongTien += Integer.parseInt(lbthanhtien.getText());
            lbTongTien.setText(String.valueOf(TongTien));
            hoahong = (int) (TongTien * 0.08);
            lbhoahong.setText(String.valueOf(hoahong));
            System.out.println("In tổng ra màn hình: " + gh.getDongia());
            System.out.println("In tổng ra màn hình: " + gh.getSoluong());
            System.out.println("In tổng ra màn hình: " + tong);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    public void thanhtoan1(ActionEvent event){
        LapHoaDon lhd = new LapHoaDon();
        
        lhd.setNgaytao(Date.valueOf(lbNgayTao.getText()));
        lhd.setIdnhanvien(Integer.valueOf(lbnhanvienid.getText()));
        lhd.setNamekhachhang(lbnameKhachhang.getText());
        lhd.setTongtien(Integer.valueOf(lbTongTien.getText()));
        lhd.setGhichu(String.valueOf(tfghichu.getText()));
        lhd.setIdhoadon(Integer.valueOf(lbIdhoadon.getText()));
        lhd.setHoahong(Integer.valueOf(lbhoahong.getText()));
        
        LapHoaDonDAO dao = new LapHoaDonDAO();
        dao.add(lhd);
        
    }

    @FXML
    void act_search(ActionEvent event) {
//        SanPham sp = new SanPham();
//        sp.setName(tfsearch.getText());
//        DanhSachSanPhamDAO dao = new DanhSachSanPhamDAO();
//        dao.research();

    }

    @FXML
    void act_delete(ActionEvent event) throws Exception {
        String name;
        Connection conn = Connect_SQLSRV_StoreSale.getConection();
        try {
            GioHang gh = (GioHang) bang3.getSelectionModel().getSelectedItem();
            String sql = "DELETE from GioHang where name = ?;";
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1, gh.getName());
            name = gh.getName();
            System.out.println("cau lenh ban dang dung: " + sql);

            pt.executeUpdate();
            pt.close();

        } catch (Exception e) {
            System.out.println("com.appvn.store_sale.controller.HoaDonController.act_delete()");
        }

    }

}
