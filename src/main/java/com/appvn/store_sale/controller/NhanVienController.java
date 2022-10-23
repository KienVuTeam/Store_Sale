/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao.NhanVienDAO;
import com.appvn.store_sale.model.NhanVien;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;


/**
 *
 * @author hoang
 */
public class NhanVienController implements Initializable {

//    private Stage stage;
//    private Scene scene;
    @FXML
    private TableView<NhanVien> table;

    @FXML
    private TextField tfChucvu;

    @FXML
    private TextField tfDiachi;

    @FXML
    private TextField tfName;

    @FXML
    private DatePicker tfNgaysinh;

    @FXML
    private DatePicker tfNgayvaolam;

    @FXML
    private TextField tfSdt;

    @FXML
    private TableColumn<NhanVien, DatePicker> birthColumn;

    @FXML
    private TableColumn<NhanVien, String> chucvuColumn;

    @FXML
    private TableColumn<NhanVien, String> diachiColumn;

    @FXML
    private TableColumn<NhanVien, Integer> idColumn;

    @FXML
    private TableColumn<NhanVien, String> nameColumn;

    @FXML
    private TableColumn<NhanVien, DatePicker> ngayvaolamColumn;

    @FXML
    private RadioButton rdNu;

    @FXML
    private RadioButton rdnam;

    @FXML
    private TableColumn<NhanVien, Integer> sdtColumn;

    @FXML
    private TableColumn<NhanVien, String> sexCloumn;

    private ObservableList<NhanVien> nhanvienList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void add(ActionEvent e) {
        NhanVien nv = new NhanVien();
//        nv.setIdNV(Integer.parseInt(tfId.getText()));
        nv.setNameNV(tfName.getText());
        nv.setNgaySinh(Date.valueOf(tfNgaysinh.getValue()));
         nv.setGioiTinh(rdnam.isSelected()?"Nam":"Nữ");
        
        nv.setNgayVaoLam(Date.valueOf(tfNgayvaolam.getValue()));
        nv.setChucVu(tfChucvu.getText());
        nv.setSDT(Integer.parseInt(tfSdt.getText()));
        nv.setDiaChi(tfDiachi.getText());
        //
        Alert thongbao = new Alert(Alert.AlertType.CONFIRMATION);
        thongbao.setTitle("Khoa thui xuat hien");
        thongbao.setHeaderText("hay chon co trym cua ban: ");
        thongbao.setContentText("To hay nho ?????");
        thongbao.showAndWait();
        System.out.println("Khoaa thui trong controller: " + nv.getNgaySinh() + "Khoa ngoc: " + nv.getNgayVaoLam());
        NhanVienDAO dao = new NhanVienDAO();
        dao.add(nv);

        tfName.clear();
        tfChucvu.clear();
        
        tfSdt.clear();
        tfDiachi.clear();
    }

    public void act_show(ActionEvent event) {
        NhanVienDAO dao = new NhanVienDAO();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idNV"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nameNV"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("NgaySinh"));
        sexCloumn.setCellValueFactory(new PropertyValueFactory<>("GioiTinh"));
        ngayvaolamColumn.setCellValueFactory(new PropertyValueFactory<>("NgayVaoLam"));
        chucvuColumn.setCellValueFactory(new PropertyValueFactory<>("ChucVu"));
        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("SDT"));
        diachiColumn.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
        //
        ObservableList<NhanVien> oblist = dao.selectAll();
        table.setItems(oblist);
    }
    
    public void MouseClick(){
    NhanVien nv = (NhanVien) table.getSelectionModel().getSelectedItem();
    tfName.setText(nv.getNameNV());
    tfChucvu.setText(nv.getChucVu());
//    tfNgaysinh.setT
    tfDiachi.setText(nv.getDiaChi());
    rdNu.setText(nv.getGioiTinh());
    rdnam.setText(nv.getGioiTinh());
    tfSdt.setText(Integer.toString(nv.getSDT()));
    }
    public void refresh(ActionEvent event) {
        NhanVienDAO dao = new NhanVienDAO();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idNV"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nameNV"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("NgaySinh"));
        sexCloumn.setCellValueFactory(new PropertyValueFactory<>("GioiTinh"));
        ngayvaolamColumn.setCellValueFactory(new PropertyValueFactory<>("NgayVaoLam"));
        chucvuColumn.setCellValueFactory(new PropertyValueFactory<>("ChucVu"));
        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("SDT"));
        diachiColumn.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
        //
        ObservableList<NhanVien> oblist = dao.refresh();
        table.setItems(oblist);
    }
    
    @FXML
    void delete(ActionEvent event) throws Exception {
        Integer id;
        Connection conn = Connect_SQLSRV_StoreSale.getConection();
        try {
            NhanVien nv = (NhanVien) table.getSelectionModel().getSelectedItem();
            String sql = "DELETE from NhanVien where id = ?;";
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setInt(1, nv.getIdNV());
            id = nv.getIdNV();
            pt.executeUpdate();
            pt.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
