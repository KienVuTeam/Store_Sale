/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;


import com.appvn.store_sale.dao_storeHouse.CustomerDAO;
import com.appvn.store_sale.model.Customer;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author vippr
 */
public class TaoHoaDonController implements Initializable {

    /**
     * Initializes the controller class.
     *
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
    private TextField emailkh_text;
    @FXML
    private TextField address_text;
    @FXML
    private TextField phone_text;
    @FXML
    private TextField namkh_text;

    String a;
    ResultSet rs;
    Connection conn;
    PreparedStatement ps;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }

    public void tbl_Customer_mouseClicked(MouseEvent e) {
        Customer pro = tblCustomer.getItems().get(tblCustomer.getSelectionModel().getSelectedIndex());
        a = pro.getIdKH();
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

    public void chonkhachhang(ActionEvent e) {
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            ps = conn.prepareStatement("update hoadon set makh=? where trangthai=N'Hóa Đơn Chờ'");
            ps.setString(1, a);
            ps.executeUpdate();
            showAlertWithHeaderText("hệ thống bán hàng", "chọn thành công");
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
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
