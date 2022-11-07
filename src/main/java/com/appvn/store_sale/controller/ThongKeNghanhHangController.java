/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.model.ThongKeNghanhHang;
import com.appvn.store_sale.res.StringValue;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class ThongKeNghanhHangController implements Initializable {

     @FXML
    private TableColumn<?, ?> ngaycolumn;

    @FXML
    private DatePicker finishdate;

    @FXML
    private TableColumn<?, ?> macolumn;

    @FXML
    private DatePicker startdate;

    @FXML
    private TableColumn<?, ?> tongcolunm;
     @FXML
    private TableView<ThongKeNghanhHang> table;
     @FXML
    void timkiem(ActionEvent event) {
        show();
    }
   ObservableList<ThongKeNghanhHang> KienKhon;
   ObservableList<ThongKeNghanhHang> selectAll() {

        ObservableList<ThongKeNghanhHang>oblist = FXCollections.observableArrayList();
        String sql = "select tensanpham,ngay_tao,sum(soluong) as TongSanPham from HoaDon hd join ChiTietHD ct on hd.ID_HD=ct.ID_HD join SanPham sp on sp.id_sanpham=ct.id_sanpham where ngay_tao between ? and ? and trangthai like N'Đã thanh toán'  group by tensanpham,ngay_tao ";
        try {
             System.out.println("com.appvn.store_sale.controller.ThongKeKhachHangController.show()" + String.valueOf(startdate.getValue() + " " + String.valueOf(finishdate.getValue())));
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1, String.valueOf( startdate.getValue()));
            pt.setString(2, String.valueOf( finishdate.getValue()));
            ResultSet rs = pt.executeQuery();
//            if(rs != null){
//                System.out.println("ko chay cau sql");
//            }
            
//            System.out.println(" gk" + sql);
            while (rs.next()) {
                System.out.println("co chay rs");
                  oblist.add(new ThongKeNghanhHang(rs.getString("tensanpham") ,rs.getDate("ngay_tao"),rs.getInt("TongSanPham")));
//                System.out.println("in max hoa don "+ rs.getString("maKh")+""+rs.getDate("ngay_tao")+rs.getInt("tonghoadondamua"));
//               //System.out.println("In id: "+rs.getInt("id")+ "in ngay:" + rs.getDate("ngaytao") +rs.getInt("nhanvien")+ rs.getString("khachhang"));
            }
            
            
            pt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return KienKhon=oblist;
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        show();
    }    
    public void show(){
        selectAll();
//System.out.println("com.appvn.store_sale.controller.ThongKeKhachHangController.show()" + startdate.getValue());
//        System.out.println("com.appvn.store_sale.controller.ThongKeKhachHangController.show()" + String.valueOf(startdate.getValue() + " " + String.valueOf(finishdate.getValue())));
        macolumn.setCellValueFactory(new PropertyValueFactory<>("tensanpham"));
         ngaycolumn.setCellValueFactory(new PropertyValueFactory<>("ngay"));
          tongcolunm.setCellValueFactory(new PropertyValueFactory<>("tongsanpham"));
        
    table.setItems(KienKhon);
    }
}
