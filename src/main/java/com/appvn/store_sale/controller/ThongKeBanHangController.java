/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.model.ThongKeBanHang;
import com.appvn.store_sale.model.ThongKeKhachHang;
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
public class ThongKeBanHangController implements Initializable {
 private Stage stage;
    private Scene scene;
      @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private DatePicker finishdate;

    @FXML
    private TableColumn<?, ?> maColumn;

    @FXML
    private DatePicker startdate;

    @FXML
    private TableColumn<?, ?> tongColumn;
     @FXML
    private TableView<ThongKeBanHang> table;
    @FXML
    void back1(ActionEvent event) throws IOException {
//Stage stage = new Stage();
//        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.THONG_KE));
//        Parent nhanvien_parent = l.load();
//        scene = new Scene(nhanvien_parent, 774, 561);
//        stage.setScene(scene);
//        stage.show();
    
    }
    @FXML
    void timkiem(ActionEvent event) {
        show();
    }
   ObservableList<ThongKeBanHang> KienKhon;
    public ObservableList<ThongKeBanHang> selectAll() {

        ObservableList<ThongKeBanHang>oblist = FXCollections.observableArrayList();
        String sql = "select maNV,ngay_tao,sum(tongtien) as Doanhthu from HoaDon   where ngay_tao between ? and ? and trangthai like N'Đã thanh toán'  group by maNV,ngay_tao order by Doanhthu desc ";
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
                  oblist.add(new ThongKeBanHang(rs.getInt("maNV") ,rs.getDate("ngay_tao"),rs.getInt("doanhthu")));
//                System.out.println("in max hoa don "+ rs.getString("maNV")+""+rs.getDate("ngay_tao")+rs.getInt("tonghoadondamua"));
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
        System.out.println("com.appvn.store_sale.controller.ThongKeKhachHangController.show()" + String.valueOf(startdate.getValue() + " " + String.valueOf(finishdate.getValue())));
        maColumn.setCellValueFactory(new PropertyValueFactory<>("maNV"));
         dateColumn.setCellValueFactory(new PropertyValueFactory<>("ngaytao"));
          tongColumn.setCellValueFactory(new PropertyValueFactory<>("doanhthu"));
        
    table.setItems(KienKhon);
    }
    
    
}
