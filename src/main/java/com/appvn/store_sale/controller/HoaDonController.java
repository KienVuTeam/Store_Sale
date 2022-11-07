/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;
import com.appvn.store_sale.dao_storeHouse.HoaDon_DAO;
import com.appvn.store_sale.model.HoaDon;
import com.appvn.store_sale.res.StringValue;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vippr
 */
public class HoaDonController implements Initializable {

    private Scene scene;
    @FXML
    private TableColumn<HoaDon, Integer> mahd_column;

    @FXML
    private TableColumn<HoaDon, String> namenv_col;
    @FXML
    private TableColumn<HoaDon, String> makh_col;

    @FXML
    private TableColumn<HoaDon, String> namkh_col;

    @FXML
    private TableColumn<HoaDon, String> ngaytao;

    @FXML
    private TableView<HoaDon> tbl_hoadoncho;
    @FXML
    private TableView<HoaDon> tbl_bill;
    @FXML
    private TableColumn<HoaDon, Integer> col_giasp;

    @FXML
    private TableColumn<HoaDon, String> col_masp;

    @FXML
    private TableColumn<HoaDon, String> col_tensp;

    @FXML
    private TableColumn<HoaDon, Integer> col_tonkho;
    @FXML
    private TableView<HoaDon> tbl_sanpham;

    @FXML
    private Label lb_mahd;
    @FXML
    private Label lb_makh;
    @FXML
    private Label lb_soluong;

    @FXML
    private Label lb_namekh;
    @FXML
    private TextField soluong_text;
    @FXML
    private TableColumn<?, ?> col_soluong;
    @FXML
    private TableColumn<?, ?> col_gia;

    @FXML
    private TableColumn<?, ?> col_sp;
    @FXML
    private TableColumn<?, ?> col_tongtien;
    @FXML
    private TextField txtpay;
    @FXML
    private TextField txtthua;
    @FXML
    private Button btn_taohoadon;

    @FXML
    private Label lbloipay;
    NumberFormat formatter = new DecimalFormat("#,###");
    SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

    @FXML
    private Label lbloithua;
    Vector vec, vecsp;

    @FXML
    private Label lbtongtien;
    int price;
    String a, sp;
    String b;
    Integer c, gb, sl;
    ResultSet rs;
    Connection conn;
    PreparedStatement ps;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            // TODO
            HoaDon_DAO jp = new HoaDon_DAO();
            ObservableList<HoaDon> ls = (ObservableList<HoaDon>) jp.finall_hoadoncho();
            mahd_column.setCellValueFactory(new PropertyValueFactory<>("idhd"));
            namkh_col.setCellValueFactory(new PropertyValueFactory<>("nameKH"));
            namenv_col.setCellValueFactory(new PropertyValueFactory<>("nameNV"));
            ngaytao.setCellValueFactory(new PropertyValueFactory<>("ngaytao"));
            makh_col.setCellValueFactory(new PropertyValueFactory<>("idKH"));
            tbl_hoadoncho.setItems(ls);
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
        }
        try {
            // TODO
            HoaDon_DAO jp = new HoaDon_DAO();
            ObservableList<HoaDon> ls = (ObservableList<HoaDon>) jp.finall_sanpham();
            col_masp.setCellValueFactory(new PropertyValueFactory<>("idSP"));
            col_tensp.setCellValueFactory(new PropertyValueFactory<>("tensp"));
            col_giasp.setCellValueFactory(new PropertyValueFactory<>("giaban"));
            col_tonkho.setCellValueFactory(new PropertyValueFactory<>("tonkho"));
            tbl_sanpham.setItems(ls);
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
//ex.printStackTrace();
        }
        try {
            // TODO
            HoaDon_DAO jp = new HoaDon_DAO();
            ObservableList<HoaDon> ls = (ObservableList<HoaDon>) jp.finall_bill();
            col_sp.setCellValueFactory(new PropertyValueFactory<>("tensp"));
            col_gia.setCellValueFactory(new PropertyValueFactory<>("giaban"));
            col_soluong.setCellValueFactory(new PropertyValueFactory<>("soluong"));
            col_tongtien.setCellValueFactory(new PropertyValueFactory<>("tongtien"));
            tbl_bill.setItems(ls);

            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("select sum(toltal) as thanhtien from bill");
            rs = ps.executeQuery();
            while (rs.next()) {
                vec = new Vector();
                price = Integer.parseInt(rs.getString("thanhtien"));
            }
            lbtongtien.setText(String.valueOf(price));
        } catch (Exception ex) {
//            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
            ex.printStackTrace();
        }
    }

    public void delete_all(ActionEvent e) {
        try {
            HoaDon selected = tbl_bill.getSelectionModel().getSelectedItem();
            HoaDon deleteItem = new HoaDon();
            HoaDon_DAO mrc = new HoaDon_DAO();
            ObservableList<HoaDon> ls = mrc.finall_bill();
            deleteItem.setIdhd(Integer.parseInt(lb_mahd.getText()));
            HoaDon_DAO jp = new HoaDon_DAO();
            ls.remove(selected);
            boolean status = jp.Delete(deleteItem);
            if (status = true) {
                try {
                    showAlertWithHeaderText("xoa san pham", "xoa san pham thanh cong");
                    ObservableList<HoaDon> ls1 = (ObservableList<HoaDon>) jp.finall_bill();
                    col_sp.setCellValueFactory(new PropertyValueFactory<>("tensp"));
                    col_gia.setCellValueFactory(new PropertyValueFactory<>("giaban"));
                    col_soluong.setCellValueFactory(new PropertyValueFactory<>("soluong"));
                    col_tongtien.setCellValueFactory(new PropertyValueFactory<>("tongtien"));
                    tbl_bill.setItems(ls1);
                } catch (Exception ex) {
                    Logger.getLogger(MgrCustomerController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MgrCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // TODO
            HoaDon_DAO jp = new HoaDon_DAO();
            ObservableList<HoaDon> ls = (ObservableList<HoaDon>) jp.finall_sanpham();
            col_masp.setCellValueFactory(new PropertyValueFactory<>("idSP"));
            col_tensp.setCellValueFactory(new PropertyValueFactory<>("tensp"));
            col_giasp.setCellValueFactory(new PropertyValueFactory<>("giaban"));
            col_tonkho.setCellValueFactory(new PropertyValueFactory<>("tonkho"));
            tbl_sanpham.setItems(ls);
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
//ex.printStackTrace();
        }
    }

    public void page_taohoadon(ActionEvent event) throws Exception {
        this.conn = Connect_SQLSRV_StoreSale.getConection();
        ps = conn.prepareStatement("Insert into HoaDon(maKH,maNV,ngay_tao,trangthai) values('KH01',2,GETDATE(),N'Hóa Đơn Chờ')");
        ps.executeUpdate();

        HoaDon_DAO jp = new HoaDon_DAO();
        ObservableList<HoaDon> ls = (ObservableList<HoaDon>) jp.finall_hoadoncho();
        mahd_column.setCellValueFactory(new PropertyValueFactory<>("idhd"));
        namkh_col.setCellValueFactory(new PropertyValueFactory<>("nameKH"));
        namenv_col.setCellValueFactory(new PropertyValueFactory<>("nameNV"));
        ngaytao.setCellValueFactory(new PropertyValueFactory<>("ngaytao"));
        tbl_hoadoncho.setItems(ls);
        btn_taohoadon.setDisable(true);

    }

    public void clicked1(MouseEvent e) {
        HoaDon hd = tbl_hoadoncho.getItems().get(tbl_hoadoncho.getSelectionModel().getSelectedIndex());
        lb_mahd.setText(String.valueOf(hd.getIdhd()));
        lb_namekh.setText(hd.getNameKH());
        lb_makh.setText(hd.getIdKH());
    }

    public void laydulieu(MouseEvent e) {
        HoaDon pro = tbl_sanpham.getItems().get(tbl_sanpham.getSelectionModel().getSelectedIndex());
        a = pro.getIdSP();
        b = pro.getTensp();
        c = pro.getGiaban();
    }

    public void add_sp(ActionEvent e) {
        while (true) {
            if (soluong_text.getText().trim().equals("")) {
                lb_soluong.setText("mời bạn nhập số lượng");
                soluong_text.setVisible(true);
                soluong_text.setText("");
                return;
            } else if (!soluong_text.getText().trim().matches("\\d+")) {
                lb_soluong.setText("số lượng dạng số");
                soluong_text.setVisible(true);
                soluong_text.setText("");
                return;
            } else {
                lbloipay.setText("");
                break;
            }
        }
        HoaDon newItem = new HoaDon();
        newItem.setIdhd(Integer.parseInt(lb_mahd.getText()));
        newItem.setIdSP(a);
        newItem.setGiaban(c);
        newItem.setSoluong(Integer.parseInt(soluong_text.getText()));
        HoaDon_DAO jp = new HoaDon_DAO();
        boolean status = jp.Create(newItem);
        if (status = true) {
            try {
                showAlertWithHeaderText("Thêm San pham", "thêm san pham thành công");
//                          HoaDon_DAO jp = new HoaDon_DAO();
                ObservableList<HoaDon> ls = (ObservableList<HoaDon>) jp.finall_bill();
                col_sp.setCellValueFactory(new PropertyValueFactory<>("tensp"));
                col_gia.setCellValueFactory(new PropertyValueFactory<>("giaban"));
                col_soluong.setCellValueFactory(new PropertyValueFactory<>("soluong"));
                col_tongtien.setCellValueFactory(new PropertyValueFactory<>("tongtien"));
                tbl_bill.setItems(ls);

////tổng tiền               
                this.conn = Connect_SQLSRV_StoreSale.getConection();
                ps = conn.prepareStatement("select sum(toltal) as thanhtien from bill");
                rs = ps.executeQuery();
                while (rs.next()) {
                    vec = new Vector();
                    price = Integer.parseInt(rs.getString("thanhtien"));
                }
                lbtongtien.setText(String.valueOf(price));
            } catch (Exception ex) {
                Logger.getLogger(MgrCustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        soluong_text.setText("");
        lb_soluong.setText("");
        soluong_text.setVisible(false);
        lb_soluong.setVisible(false);
        try {
            // TODO
            HoaDon_DAO jp1 = new HoaDon_DAO();
            ObservableList<HoaDon> ls = (ObservableList<HoaDon>) jp1.finall_sanpham();
            col_masp.setCellValueFactory(new PropertyValueFactory<>("idSP"));
            col_tensp.setCellValueFactory(new PropertyValueFactory<>("tensp"));
            col_giasp.setCellValueFactory(new PropertyValueFactory<>("giaban"));
            col_tonkho.setCellValueFactory(new PropertyValueFactory<>("tonkho"));
            tbl_sanpham.setItems(ls);
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
//ex.printStackTrace();
        }
    }

    public void thanhtoan(ActionEvent e) throws Exception {
        int Repay;
        while (true) {
            if (txtpay.getText().trim().equals("")) {
                lbloipay.setText("Khách hàng chưa đưa tiền.");
                txtpay.setText("0");
                return;
            } else if (!txtpay.getText().trim().matches("\\d+")) {
                lbloipay.setText("Tiền có dạng số.");
                txtpay.setText("0");
                return;
            } else {
                lbloipay.setText("");
                break;
            }
        }
        String total = lbtongtien.getText().replaceAll(",", "");
        Repay = Integer.parseInt(txtpay.getText()) - Integer.parseInt(total);
        txtthua.setText(formatter.format(Repay));
        if (Repay < 0) {
            lbloipay.setText("Khách hàng chưa đưa đủ tiền.");
            txtpay.setText("0");
            return;
        } else if (Integer.parseInt(txtpay.getText()) == 0) {
            txtthua.setText("0");
            return;
        } else {
            lbloipay.setText("");
        }
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("update HoaDon set tongtien=? , trangthai=N'Đã Thanh Toán' where ID_HD=?");
            ps.setString(1, lbtongtien.getText());
            ps.setString(2, lb_mahd.getText());
            ps.executeUpdate();
            showAlertWithHeaderText("thanh toán", "thanh toán thành công");
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
        }
        try {
            // TODO
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("select * from bill");
            rs = ps.executeQuery();
            while (rs.next()) {
                vecsp = new Vector();
                sp = (rs.getString("tensanpham"));
                gb = (Integer.parseInt(rs.getString("giaban")));
                sl = (Integer.parseInt(rs.getString("soluong")));
                vec.addAll(vecsp);
//                for (int i = 0; i < vecsp.size(); i++) {
//                    System.out.println(vecsp.get(i));
//                }
            }
        } catch (Exception ex) {
//            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
            ex.printStackTrace();
        }
        //xóa file txt
        File file = new File("phieuthu.txt");
        file.delete();
        //Viết vào file txt
        try {
            Writer b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("phieuthu.txt"), "UTF8"));
            String a;
            Date now = new Date();
            Object[] arr = new Object[vec.size()];
            vec.toArray(arr);
            System.out.println();
            b.write("\r\n\rCÔNG TY TNHH SẢN XUẤT VÀ THƯƠNG MẠI MẶT HÀNG TIÊU DÙNG\r\n\r\n");
            b.write("Địa chỉ: 590 CMT8, P.11, Q.3, TPHCM\r\n");
            b.write("SĐT: 08888686868\r\n");
            b.write("Thời gian: " + ft.format(now) + "\r\n\r\n");
            b.write("\t\t\t Hóa Đơn Bán Hàng\r\n\n\n");
            b.write("\tTên Khách Hàng      :" + lb_namekh.getText().trim() + "\r\n\n");
            b.write("\tTên Sản Phẩm        :" + sp + "\r\n\n");
            b.write("\tGiá bán             :" + gb + "\r\n\n");
            b.write("\tSố lượng            :" + sl + "\r\n\n");
//            for(Object o:arr){
//                b.write("\t\t\t"+String.valueOf(o));
//                b.flush();
//                b.write("\n\n");
//            }
//            for (int i = 0; i < vec.size(); i++) {
//            b.write("\t"+ vec.get(i) + "\n");           
//                }          
            b.write("\tTổng tiền          :" + lbtongtien.getText().trim() + "VND\r\n\n");
            b.write("\tTiền Khách đua     :" + txtpay.getText().trim() + "VND\r\n\n");
            b.write("\tTiền Thừa trả khách:" + txtthua.getText().trim() + "VND\r\n\n");
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

    public void reset(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.HOADON));
        Parent nhanvien_parent = l.load();
        scene = new Scene(nhanvien_parent, 1245, 759);
        stage.setScene(scene);
        stage.show();
    }

    public void chuathanhtoan(ActionEvent e) {
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("update HoaDon set tongtien=? , trangthai=N'Chưa Thanh Toán' where ID_HD=?");
            ps.setString(1, lbtongtien.getText());
            ps.setString(2, lb_mahd.getText());
            ps.executeUpdate();
            showAlertWithHeaderText("lập hóa đơn", "hóa đơn đã thêm vào công nợ cho khách hàng");
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
        }
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("Insert into CongNo(maKH,CongNo) values(?,?)");
            ps.setString(1, lb_makh.getText());
            ps.setString(2, lbtongtien.getText());
            ps.executeUpdate();
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
        }
    }

    public void huy(ActionEvent e) {
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("update HoaDon set  trangthai=N'Đã Hủy' where ID_HD=?");
            ps.setString(1, lb_mahd.getText());
            ps.executeUpdate();
            showAlertWithHeaderText("hủy hóa đơn", "hóa đơn đã hủy");
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
        }
    }

    public void page_khachhang(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.TAOHOADON));
        Parent p = l.load();
        scene = new Scene(p, 760, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void load_hoadoncho(ActionEvent event) throws IOException {
        try {
            // TODO
            HoaDon_DAO jp = new HoaDon_DAO();
            ObservableList<HoaDon> ls = (ObservableList<HoaDon>) jp.finall_hoadoncho();
            mahd_column.setCellValueFactory(new PropertyValueFactory<>("idhd"));
            namkh_col.setCellValueFactory(new PropertyValueFactory<>("nameKH"));
            namenv_col.setCellValueFactory(new PropertyValueFactory<>("nameNV"));
            ngaytao.setCellValueFactory(new PropertyValueFactory<>("ngaytao"));
            makh_col.setCellValueFactory(new PropertyValueFactory<>("idKH"));
            tbl_hoadoncho.setItems(ls);
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
