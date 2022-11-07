/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;
import com.appvn.store_sale.dao_storeHouse.CongNo_DAO;
import com.appvn.store_sale.dao_storeHouse.CustomerDAO;
import com.appvn.store_sale.model.CongNo;
import com.appvn.store_sale.model.Customer;
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
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
public class MgrCustomerController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @FXML
    private TableColumn<Customer, String> diachi_column;
    @FXML
    private TableColumn<Customer, String> email_column;
    @FXML
    private TableColumn<Customer, Integer> id_column;
    @FXML
    private TableColumn<Customer, String> nameKh_column;
    @FXML
    private TableColumn<Customer, Integer> phone_column;
    @FXML
    private TableView<Customer> tblCustomer;
    @FXML
    private TextField address_text;
    @FXML
    private TextField emailkh_text;
    @FXML
    private TextField namkh_text;
    @FXML
    private TextField phone_text;
    @FXML
    private TextField id_text;
    @FXML
    private Label lbLoi;

    @FXML
    private Label loi_address;

    @FXML
    private Label loi_email;

    @FXML
    private Label loi_phone;
    @FXML
    private TableView<CongNo> tbl_CongNo;
    @FXML
    private TableColumn<CongNo, String> column_email;

    @FXML
    private TableColumn<CongNo, String> column_phone;

    @FXML
    private TableColumn<CongNo, Integer> congno_column;

    @FXML
    private TableColumn<CongNo, String> name_column;
    @FXML
    private TableView<CongNo> tbl_tongtien;
    @FXML
    private TableColumn<CongNo, String> col_email;

    @FXML
    private TableColumn<CongNo, String> col_makh;

    @FXML
    private TableColumn<CongNo, Integer> col_tongtien;

    @FXML
    private TableColumn<CongNo, String> col_name;
    @FXML
    private Button btn_phieuthu;
    SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    NumberFormat formatter = new DecimalFormat("#,###");
    String a, f, c;
    Integer d;
    ResultSet rs;
    Connection conn;
    PreparedStatement ps;
    private Scene scene;
    @FXML
    private TextField text_seach;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            CustomerDAO jp = new CustomerDAO();
            ObservableList<Customer> ls = (ObservableList<Customer>) jp.finall();
            id_column.setCellValueFactory(new PropertyValueFactory<>("idKH"));
            nameKh_column.setCellValueFactory(new PropertyValueFactory<>("nameKH"));
            phone_column.setCellValueFactory(new PropertyValueFactory<>("SDT"));
            diachi_column.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
            email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
            tblCustomer.setItems(ls);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            // TODO
            CongNo_DAO jp = new CongNo_DAO();
            ObservableList<CongNo> ls1 = (ObservableList<CongNo>) jp.finall();
            name_column.setCellValueFactory(new PropertyValueFactory<>("nameKh"));
            column_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            column_email.setCellValueFactory(new PropertyValueFactory<>("maKH"));
            congno_column.setCellValueFactory(new PropertyValueFactory<>("Congno"));
            tbl_CongNo.setItems(ls1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            // TODO
            CongNo_DAO jp = new CongNo_DAO();
            ObservableList<CongNo> ls1 = (ObservableList<CongNo>) jp.finalltongtien();
            col_name.setCellValueFactory(new PropertyValueFactory<>("nameKh"));
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_makh.setCellValueFactory(new PropertyValueFactory<>("phone"));
            col_tongtien.setCellValueFactory(new PropertyValueFactory<>("Congno"));
            tbl_tongtien.setItems(ls1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Add_Customer(ActionEvent e) {
        String Name = namkh_text.getText().replaceAll("\\s+", " ");
        while (true) {
            if (namkh_text.getText().trim().equals("")) {
                lbLoi.setText("tên khách hàng không được bỏ trống.");
                return;
            } else if (Name.length() > 30) {
                lbLoi.setText("Họ và tên chứa tối đa 30 kí tự.");
                return;
            } else {
                lbLoi.setText("");
                break;
            }
        }
        while (true) {
            if (phone_text.getText().trim().equals("")) {
                loi_phone.setText("SĐT không được bỏ trống.");
                return;
            } else if (phone_text.getText().trim().length() > 11 || phone_text.getText().trim().length() < 10) {
                loi_phone.setText("SĐT chứa từ 10-11 số.");
                return;
            } else if (!phone_text.getText().trim().matches("0[1-9]{1}\\d{8,9}")) {
                loi_phone.setText("SĐT chưa đúng định dạng.");
                return;
            } else {
                loi_phone.setText("");
                break;
            }
        }
        while (true) {
            if (emailkh_text.getText().trim().equals("")) {
                loi_email.setText("Email không được bỏ trống.");

                return;
            } else if (!emailkh_text.getText().trim().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                loi_email.setText("Email chưa đúng định dạng.");
                return;
            } else {
                loi_email.setText("");
                break;
            }
        }
        while (true) {
            if (address_text.getText().trim().equals("")) {
                loi_address.setText("Email không được bỏ trống.");
                return;
            } else {
                loi_address.setText("");
                break;
            }
        }
        Customer newItem = new Customer();
        newItem.setIdKH(id_text.getText());
        newItem.setNameKH(namkh_text.getText());
        newItem.setSDT(phone_text.getText());
        newItem.setEmail(emailkh_text.getText());
        newItem.setDiaChi(address_text.getText());
        CustomerDAO jp = new CustomerDAO();
        boolean status = jp.Create(newItem);
        if (status = true) {
            try {
                showAlertWithHeaderText("Thêm Khách Hàng", "thêm khách hàng thành công");
                ObservableList<Customer> ls = (ObservableList<Customer>) jp.finall();
                id_column.setCellValueFactory(new PropertyValueFactory<>("idKH"));
                nameKh_column.setCellValueFactory(new PropertyValueFactory<>("nameKH"));
                phone_column.setCellValueFactory(new PropertyValueFactory<>("SDT"));
                diachi_column.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
                email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
                tblCustomer.setItems(ls);
            } catch (Exception ex) {
                Logger.getLogger(MgrCustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Delete_Customer(ActionEvent e) throws Exception {
        try {
            Customer selected = tblCustomer.getSelectionModel().getSelectedItem();
            Customer deleteItem = new Customer();
            CustomerDAO mrc = new CustomerDAO();
            ObservableList<Customer> ls = mrc.finall();
            deleteItem.setNameKH(selected.getNameKH());
            CustomerDAO jp = new CustomerDAO();
            ls.remove(selected);
            boolean status = jp.Delete(deleteItem);
            if (status = true) {
                try {
                    showAlertWithHeaderText("xóa khách hàng", "xóa khách hàng thành công");
                    ObservableList<Customer> ls1 = (ObservableList<Customer>) jp.finall();
                    id_column.setCellValueFactory(new PropertyValueFactory<>("idKH"));
                    nameKh_column.setCellValueFactory(new PropertyValueFactory<>("nameKH"));
                    phone_column.setCellValueFactory(new PropertyValueFactory<>("SDT"));
                    diachi_column.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
                    email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
                    tblCustomer.setItems(ls1);
                } catch (Exception ex) {
                    showAlertWithHeaderText("xóa khách hàng không thành công", "khách hàng còn đang nợ");
                }
            }
        } catch (SQLException se) {
            showAlertWithHeaderText("xóa khách hàng không thành công", "khách hàng còn đang nợ");
        } finally {
            showAlertWithHeaderText("xóa khách hàng không thành công", "khách hàng còn đang nợ");
        }
    }

    public void Update_Customer(ActionEvent e) {
        String Name = namkh_text.getText().replaceAll("\\s+", " ");
        while (true) {
            if (namkh_text.getText().trim().equals("")) {
                lbLoi.setText("tên khách hàng không được bỏ trống.");
                return;
            } else if (Name.length() > 30) {
                lbLoi.setText("Họ và tên chứa tối đa 30 kí tự.");
                return;
            } else {
                lbLoi.setText("");
                break;
            }
        }
        while (true) {
            if (phone_text.getText().trim().equals("")) {
                loi_phone.setText("SĐT không được bỏ trống.");
                return;
            } else if (phone_text.getText().trim().length() > 11 || phone_text.getText().trim().length() < 10) {
                loi_phone.setText("SĐT chứa từ 10-11 số.");
                return;
            } else if (!phone_text.getText().trim().matches("0[1-9]{1}\\d{8,9}")) {
                loi_phone.setText("SĐT chưa đúng định dạng.");
                return;
            } else {
                loi_phone.setText("");
                break;
            }
        }
        while (true) {
            if (emailkh_text.getText().trim().equals("")) {
                loi_email.setText("Email không được bỏ trống.");

                return;
            } else if (!emailkh_text.getText().trim().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                loi_email.setText("Email chưa đúng định dạng.");
                return;
            } else {
                loi_email.setText("");
                break;
            }
        }
        Customer newItem1 = new Customer();
        newItem1.setNameKH(namkh_text.getText());
        newItem1.setSDT(phone_text.getText());
        newItem1.setEmail(emailkh_text.getText());
        newItem1.setDiaChi(address_text.getText());
        newItem1.setIdKH(id_text.getText());
        CustomerDAO jp = new CustomerDAO();
        boolean status = jp.Update(newItem1);
        if (status = true) {
            try {
                showAlertWithHeaderText("Sửa Khách Hàng", "sửa khách hàng thành công");
                ObservableList<Customer> ls = (ObservableList<Customer>) jp.finall();
                id_column.setCellValueFactory(new PropertyValueFactory<>("idKH"));
                nameKh_column.setCellValueFactory(new PropertyValueFactory<>("nameKH"));
                phone_column.setCellValueFactory(new PropertyValueFactory<>("SDT"));
                diachi_column.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
                email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
                tblCustomer.setItems(ls);
            } catch (Exception ex) {
                Logger.getLogger(MgrCustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void tbl_Customer_mouseClicked(MouseEvent e) {
        Customer pro = tblCustomer.getItems().get(tblCustomer.getSelectionModel().getSelectedIndex());
        id_text.setText(pro.getIdKH());
        namkh_text.setText(pro.getNameKH());
        phone_text.setText(String.valueOf(pro.getSDT()));
        emailkh_text.setText(pro.getEmail());
        address_text.setText(pro.getDiaChi());
    }

    public void CongNo_mouseClicked(MouseEvent e) {
        CongNo cn = tbl_CongNo.getItems().get(tbl_CongNo.getSelectionModel().getSelectedIndex());
        a = cn.getMaKH();
        f = cn.getNameKh();
        c = cn.getPhone();
        d = cn.getCongno();
        btn_phieuthu.setDisable(false);
    }

    public void phieuthu(ActionEvent e) {
        File file = new File("phieuthu.txt");
        file.delete();
        //Viết vào file txt
        try {
            Writer b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("phieuthu.txt"), "UTF8"));
            Date now = new Date();

            b.write("\r\n\rCÔNG TY TNHH SẢN XUẤT VÀ THƯƠNG MẠI MẶT HÀNG TIÊU DÙNG\r\n\r\n");
            b.write("Địa chỉ: 590 CMT8, P.11, Q.3, TPHCM\r\n");
            b.write("SĐT: 08888686868\r\n");
            b.write("Thời gian: " + ft.format(now) + "\r\n\r\n");
            b.write("\t\t\t Phiếu Thu\r\n\n\n");
            b.write("\tTên Khách Hàng       :" + f + "\r\n\n");
            b.write("\tSố điện thoại        :" + c + "\r\n\n");
            b.write("\tlý do nộp            :trả tiền nợ hàng\r\n\n");
            b.write("\tTổng tiền nợ         :" + formatter.format(d) + "VND\r\n\n");
            b.write("--------------------------------------------------------\r\n");
            b.write("Đã nhận đủ tiền\r\n\n");
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
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("delete CongNo where makh=?");
            ps.setString(1, a);
            ps.executeUpdate();
            showAlertWithHeaderText("hệ thống bán hàng", "Đã thu công nợ");
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
        }
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("update hoadon set trangthai=N'Đã Thanh Toán' where makh=? and trangthai= N'Chưa Thanh Toán'");
            ps.setString(1, a);
            ps.executeUpdate();
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
        }
    }

    public void Mgr_Customer(ActionEvent e) throws IOException {
//        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        FXMLLoader l = new FXMLLoader(getClass().getResource(StringValue.CUSTOMER));
//        Parent nhanvien_parent = l.load();
//        scene = new Scene(nhanvien_parent, 800, 505);
//        stage.setScene(scene);
//        stage.show();
    }

    public void timkiem(ActionEvent e) {
        try {
            ObservableList<Customer> ls = FXCollections.observableArrayList();
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("select * from Customer where makh like ? or phone like ?");
            ps.setString(1, "%" + (String) text_seach.getText().trim());
            ps.setString(2, "%" + (String) text_seach.getText().trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer item = new Customer();
                item.setIdKH(rs.getString("MaKH"));
                item.setNameKH(rs.getString("nameKh"));
                item.setSDT(rs.getString("phone"));
                item.setEmail(rs.getString("email"));
                item.setDiaChi(rs.getString("addres"));
                ls.add(item);
            }
            id_column.setCellValueFactory(new PropertyValueFactory<>("idKH"));
            nameKh_column.setCellValueFactory(new PropertyValueFactory<>("nameKH"));
            phone_column.setCellValueFactory(new PropertyValueFactory<>("SDT"));
            diachi_column.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
            email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
            tblCustomer.setItems(ls);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showAlertWithHeaderText(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("Results:");
        alert.setContentText(content);
        alert.showAndWait();
    }
}
