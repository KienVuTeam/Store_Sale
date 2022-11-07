/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;


import com.appvn.store_sale.dao_storeHouse.ThuTheoCongNoDAO;
import com.appvn.store_sale.dao_storeHouse.ThuTheoHoaDonDAO;
import com.appvn.store_sale.model.ThuTheoCongNo;
import com.appvn.store_sale.model.ThuTheoCongNo1;
import com.appvn.store_sale.model.ThuTheoHoaDon;
import com.appvn.store_sale.model.ThuTheoHoaDon1;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;



import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
//import java.util.Date;

/**
 * FXML Controller class
 *
 * @author hoang
 */
public class PhieuThu3Controller implements Initializable {

    @FXML
    private TableColumn<ThuTheoCongNo, String> khColumn1;
    @FXML
    private TableColumn<ThuTheoCongNo, Integer> congnoColumn;

    @FXML
    private TableColumn<ThuTheoCongNo, Integer> sotienColumn1;
    @FXML
    private TableView<ThuTheoCongNo> table1;

    @FXML
    private TextField tfidhd;
    @FXML
    private TextField tfsotien1;
    @FXML
    private TextField tfidcongno1;
    @FXML
    private DatePicker tfngayketthuc,tfngaybatdau11,tfngayketthuc22;
    @FXML
    private TextField tfnamekhachhang1;
     @FXML
    private Label tfngaytao,tfnamekhachhang0,tfsotien;
    @FXML
    private ComboBox<String> tfidkh;

    @FXML
    private TextField tfidkh1;
    @FXML
    private Label lbidhoadon,lbname,lbname1;
    @FXML
    private Label lbnamekhachhang0;
    @FXML
    private TableView<ThuTheoHoaDon> table;
    @FXML
    private ComboBox<String> tfidkhachhang1;
    @FXML
    private TableColumn<ThuTheoHoaDon, Integer> tienColumn;
    @FXML
    private TableColumn<ThuTheoHoaDon, Integer> idColumn;
   
    @FXML
    private TableColumn<ThuTheoHoaDon, String> khColumn;
    @FXML
    private TableColumn<ThuTheoHoaDon, String> ttColumn;
    @FXML
    private TableColumn<ThuTheoHoaDon, Date> ngaytaoColumn;

    SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

    @FXML
    public void mouse(MouseEvent e) {
        ThuTheoHoaDon hd = (ThuTheoHoaDon) table.getSelectionModel().getSelectedItem();
        lbidhoadon.setText(Integer.toString(hd.getMahoadon()));
        tfidkh.setValue(String.valueOf(hd.getIdkhachhang()));
        tfsotien.setText(Integer.toString(hd.getSotien()));
        tfngaytao.setText(String.valueOf(hd.getNgaytao()));
        lbname.setText("Thu theo hoá đơn");
    }
    @FXML
    public void mouse1(MouseEvent e) {
        ThuTheoCongNo hd = (ThuTheoCongNo) table1.getSelectionModel().getSelectedItem();
        tfidcongno1.setText(Integer.toString(hd.getMacongno()));
        tfidkhachhang1.setValue(String.valueOf(hd.getIdkhachhang()));
        tfsotien1.setText(Integer.toString(hd.getSotien()));
//        tfngaybatdau11.setText(String.valueOf(hd.));
        lbname1.setText("Thu theo công nợ");

    }
    @FXML
    public ObservableList showname(ActionEvent event) {
        ObservableList oblist = FXCollections.observableArrayList();
//        String tmp = (String) tfidkh.getSelectionModel().getSelectedItem();
        String sql = "select nameKH from Customer";

        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String add = rs.getString("nameKH");
                tfnamekhachhang0.setText(add);
            }
//            tfidkh.setItems(oblist);
            rs.close();
            ps.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return oblist;
    }
     @FXML
    public ObservableList showname1(ActionEvent event) {
        ObservableList oblist = FXCollections.observableArrayList();
//        String tmp = (String) tfidkh.getSelectionModel().getSelectedItem();
        String sql = "select nameKH from Customer";

        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String add = rs.getString("nameKH");
                tfnamekhachhang1.setText(add);
            }
//            tfidkh.setItems(oblist);
            rs.close();
            ps.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return oblist;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
        show1();
        show3();

    }

    public void show() {
        ThuTheoHoaDonDAO dao = new ThuTheoHoaDonDAO();
       idColumn.setCellValueFactory(new PropertyValueFactory<ThuTheoHoaDon, Integer>("mahoadon"));
        khColumn.setCellValueFactory(new PropertyValueFactory<ThuTheoHoaDon, String>("idkhachhang"));
        ttColumn.setCellValueFactory(new PropertyValueFactory<ThuTheoHoaDon, String>("trangthai"));
        tienColumn.setCellValueFactory(new PropertyValueFactory<ThuTheoHoaDon, Integer>("sotien"));
        ngaytaoColumn.setCellValueFactory(new PropertyValueFactory<ThuTheoHoaDon, Date>("ngaytao"));
        ObservableList<ThuTheoHoaDon> oblist = dao.selectAll();
        table.setItems(oblist);
    }

    @FXML
    void hoantat(ActionEvent event) {
        //xóa file txt

        File file = new File("phieuthu.txt");
        file.delete();
        //Viết vào file txt
        try {
            Writer b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("phieuthu.txt"), "UTF8"));
            String a;
//            Date now = new Date();
            b.write("\r\n\rCÔNG TY TNHH SẢN XUẤT VÀ THƯƠNG MẠI MẶT HÀNG TIÊU DÙNG\r\n\r\n");
            b.write("Địa chỉ: 590 CMT8, P.11, Q.3, TPHCM\r\n");
            b.write("SĐT: 01212692802\r\n");
//            b.write("Thời gian: " + ft.format(now) + "\r\n\r\n");
            b.write("\t\t\t Phiếu Thu\r\n\n\n");
            b.write("\tTên Khách Hàng     :" + tfnamekhachhang0.getText().trim() + "\r\n\n");
            b.write("\tTổng tiền          :" + tfsotien.getText().trim() + "VND\r\n\n");
//            b.write("\tTiền Khách đua     :" + txtpay.getText().trim() + "VND\r\n\n");
//            b.write("\tTiền Thừa trả khách:" + txtthua.getText().trim() + "VND\r\n\n");
            b.write("--------------------------------------------------------\r\n");
            b.write("hóa đon đã thanh toán\r\n\n");
            b.write("Người lập (Ký và ghi rõ họ tên)");
            b.close();
        } catch (IOException eh) {
        }
        //Mở file txt
        Runtime run = Runtime.getRuntime();
        try {
            run.exec("notepad phieuthu.txt");
        } catch (IOException eh) {
        }

    }
    
    
    

    public void show1() {
        ThuTheoCongNoDAO dao = new  ThuTheoCongNoDAO();
        congnoColumn.setCellValueFactory(new PropertyValueFactory<ThuTheoCongNo, Integer>("macongno"));
        khColumn1.setCellValueFactory(new PropertyValueFactory<ThuTheoCongNo, String>("idkhachhang"));
        sotienColumn1.setCellValueFactory(new PropertyValueFactory<ThuTheoCongNo, Integer>("sotien"));
        ObservableList<ThuTheoCongNo> oblist = dao.selectAll();
        table1.setItems(oblist);
    }
    public void hoantat1(ActionEvent event){
    ThuTheoHoaDon1 hd = new ThuTheoHoaDon1();
    hd.setMahoadon(Integer.valueOf(lbidhoadon.getText()));
    hd.setNamekhachhang(tfnamekhachhang0.getText());
    hd.setSotien(Integer.valueOf(tfsotien.getText()));
    hd.setNgaytao(Date.valueOf(tfngaytao.getText()));
    hd.setNgayketthuc(Date.valueOf(tfngayketthuc.getValue()));
//    hd.setNgayketthuc(Date.valueOf);
    hd.setLoai(lbname.getText());
    ThuTheoHoaDonDAO dao = new ThuTheoHoaDonDAO();
    dao.add(hd);
    }
      @FXML
    private TableColumn<?, ?> loaiColumn;

    @FXML
    private TableColumn<?, ?> maColumn;

    @FXML
    private TableColumn<?, ?> starColumn;

    @FXML
    private TableColumn<?, ?> tienColumn1;

     @FXML
    private TableColumn<?, ?> finishColumn;
      @FXML
    private TableColumn<?, ?> tenColumn;
 @FXML
    private TableView<ThuTheoHoaDon1> table3;
 
  public void show3(){
  ThuTheoHoaDonDAO dao = new ThuTheoHoaDonDAO();
  maColumn.setCellValueFactory(new PropertyValueFactory<>("mahoadon"));
  tenColumn.setCellValueFactory(new PropertyValueFactory<>("namekhachhang"));
  tienColumn1.setCellValueFactory(new PropertyValueFactory<>("sotien"));
  starColumn.setCellValueFactory(new PropertyValueFactory<>("ngaytao"));
  finishColumn.setCellValueFactory(new PropertyValueFactory<>("ngayketthuc"));
  loaiColumn.setCellValueFactory(new PropertyValueFactory<>("loai"));
    ObservableList<ThuTheoHoaDon1> oblist = dao.selectAll2();
    table3.setItems(oblist);
  }

 
  public void hoantat2(ActionEvent event){
    ThuTheoCongNo1 hd = new ThuTheoCongNo1();
    hd.setMacongno(Integer.valueOf(tfidcongno1.getText()));
    hd.setNamekhachhang(tfnamekhachhang1.getText());
    hd.setSotien(Integer.valueOf(tfsotien1.getText()));
    hd.setNgaybatdau(Date.valueOf(tfngaybatdau11.getValue()));
    hd.setNgayketthuc(Date.valueOf(tfngayketthuc22.getValue()));
    hd.setLoai(lbname1.getText());

    
    ThuTheoHoaDonDAO dao = new ThuTheoHoaDonDAO();
 dao.add1(hd);
    }
  
  
}
