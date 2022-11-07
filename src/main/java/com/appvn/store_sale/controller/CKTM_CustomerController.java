/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;


import com.appvn.store_sale.dao_storeHouse.CKTM_DAO;
import com.appvn.store_sale.model.CKTM;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author vippr
 */
public class CKTM_CustomerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableColumn<CKTM, Integer> chietkhuau_column;

    @FXML
    private TableColumn<CKTM, String> endDay_column;

    @FXML
    private TableColumn<CKTM, String> mota_column;

    @FXML
    private TableColumn<CKTM, String> name_CKTM_column;

    @FXML
    private TableColumn<CKTM, String> startDay_column;

    @FXML
    private TableView<CKTM> tbl_CKTM;
    @FXML
    private TextField name_CKTM_text;

    @FXML
    private DatePicker ngayBD_text;

    @FXML
    private DatePicker ngayKT_text;
    @FXML
    private TextArea mota_text;

    @FXML
    private TextField chietkhuau_text;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            CKTM_DAO jp = new CKTM_DAO();
            ObservableList<CKTM> ls = (ObservableList<CKTM>) jp.finall();
            name_CKTM_column.setCellValueFactory(new PropertyValueFactory<>("name_CKTM"));
            chietkhuau_column.setCellValueFactory(new PropertyValueFactory<>("discount"));
            startDay_column.setCellValueFactory(new PropertyValueFactory<>("start_CKTM"));
            endDay_column.setCellValueFactory(new PropertyValueFactory<>("end_CKTM"));
            mota_column.setCellValueFactory(new PropertyValueFactory<>("Description"));
            tbl_CKTM.setItems(ls);
        } catch (Exception ex) {
            showAlertWithHeaderText("lỗi", "không thể kết nối với máy chủ.");
        }
    }

    public void Add_CKTM(ActionEvent e) {
        LocalDate start = ngayBD_text.getValue();
        String my_start = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate end = ngayKT_text.getValue();
        String my_end = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        while (true) {
            if (name_CKTM_text.getText().trim().equals("")) {
                showAlertWithHeaderText("abc", "Tên chương trình không được bỏ trống.");
                return;
            } else if (name_CKTM_text.getText().length() > 50) {
                showAlertWithHeaderText(null, "Độ dài tối đa của tên chương trình là 50 ký tự.");
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (chietkhuau_text.getText().trim().equals("")) {
                showAlertWithHeaderText(null, "Chiết khấu không được bỏ trống.");
                return;
            } else if (!chietkhuau_text.getText().trim().matches("[0-9]+") || Integer.parseInt(chietkhuau_text.getText().trim()) > 100) {
                showAlertWithHeaderText(null, "Chiết khấu phải là số nguyên dương và <= 100.");
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (start.compareTo(end) >= 0) {
                showAlertWithHeaderText(null, "Thời gian bắt đầu phải nhỏ hơn thời gian kết thúc.");
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (mota_text.getText().trim().equals("")) {
                showAlertWithHeaderText(null, "Mô tả chương trình không được bỏ trống.");
                return;
            } else {
                break;
            }
        }
        
        CKTM newItem = new CKTM();
        newItem.setName_CKTM(name_CKTM_text.getText());
        newItem.setDiscount(Integer.parseInt(chietkhuau_text.getText()));
        newItem.setStart_CKTM(my_start);
        newItem.setEnd_CKTM(my_end);
        newItem.setDescription(mota_text.getText());
        CKTM_DAO jp = new CKTM_DAO();
        boolean status = jp.Create(newItem);
        if (status = true) {
            try {
                showAlertWithHeaderText("Create New Class", "Create successfully");
                ObservableList<CKTM> ls = (ObservableList<CKTM>) jp.finall();
                name_CKTM_column.setCellValueFactory(new PropertyValueFactory<>("name_CKTM"));
                chietkhuau_column.setCellValueFactory(new PropertyValueFactory<>("discount"));
                startDay_column.setCellValueFactory(new PropertyValueFactory<>("start_CKTM"));
                endDay_column.setCellValueFactory(new PropertyValueFactory<>("end_CKTM"));
                mota_column.setCellValueFactory(new PropertyValueFactory<>("Description"));
                tbl_CKTM.setItems(ls);
            } catch (Exception ex) {
                Logger.getLogger(CKTM_CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public void Delete_CKTM(ActionEvent e) {
        try {
            CKTM selected = tbl_CKTM.getSelectionModel().getSelectedItem();
             CKTM deleteItem = new  CKTM();
             CKTM_DAO mrc = new  CKTM_DAO();
            ObservableList< CKTM> ls = mrc.finall();
            deleteItem.setName_CKTM(selected.getName_CKTM());
            CKTM_DAO jp = new CKTM_DAO();
            ls.remove(selected);
            boolean status = jp.Delete(deleteItem);
            if (status = true) {
                try {
                    showAlertWithHeaderText("Delete Class", "Delete successfully");
                    ObservableList<CKTM> ls1 = (ObservableList<CKTM>) jp.finall();
                   name_CKTM_column.setCellValueFactory(new PropertyValueFactory<>("name_CKTM"));
                chietkhuau_column.setCellValueFactory(new PropertyValueFactory<>("discount"));
                startDay_column.setCellValueFactory(new PropertyValueFactory<>("start_CKTM"));
                endDay_column.setCellValueFactory(new PropertyValueFactory<>("end_CKTM"));
                mota_column.setCellValueFactory(new PropertyValueFactory<>("Description"));
                tbl_CKTM.setItems(ls1);
                } catch (Exception ex) {
                    Logger.getLogger(MgrCustomerController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MgrCustomerController.class.getName()).log(Level.SEVERE, null, ex);
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
