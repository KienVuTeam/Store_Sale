/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.model.Manage_sale_product;
import com.appvn.store_sale.res.StringValue;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Manage_sale_productPriceController implements Initializable {

    private Stage stage;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    @FXML
    private ComboBox<String> cbx_productName;

    @FXML
    private ComboBox<String> cbx_product_quydoi;

    @FXML
    private DatePicker ipdp_dayEnd;

    @FXML
    private DatePicker ipdp_dayStart;

    @FXML
    private RadioButton iprb_on;

    @FXML
    private TextField iptf_quantityMua;

    @FXML
    private TextField iptf_quydoi;

    @FXML
    private TextField iptf_moneyGiam;
//
//    @FXML
//    void oat_back(ActionEvent e) throws IOException {
//        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
//        Parent layout = load.load();
//        scene = new Scene(layout, 1000, 700);
//        stage.setScene(scene);
//        stage.show();
//
//    }

    @FXML
    void oat_add(ActionEvent event) {
        iptf_moneyGiam.getText();
        Manage_sale_product sp = new Manage_sale_product();
        sp.setMoney(iptf_moneyGiam.getText());
        //

        System.out.println("hiển thị ra: " + fun1(Double.valueOf(sp.getMoney())));
        //
//        Locale locale = new Locale("vi", "VN");
//        DecimalFormat fomart = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
//        fomart.setMinimumFractionDigits(2);
//        fomart.setMaximumFractionDigits(5);
//        fomart.setRoundingMode(RoundingMode.HALF_EVEN);
//        DecimalFormatSymbols fs = new DecimalFormatSymbols();
//        fs.setCurrencySymbol("vnd");
//        fomart.setDecimalFormatSymbols(fs);
////        fomart.set
//        System.out.println("dữ liệu nguyên bản: " + sp.getMoney());
//        System.out.println("tien doi từ String sang số: " + fomart.format(Double.valueOf(sp.getMoney())));
    }

    public String fun1(double val) {
        Locale locale = new Locale("vi", "VN");
        DecimalFormat f = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        f.setMinimumFractionDigits(2);
        f.setMaximumFractionDigits(5);
        f.setRoundingMode(RoundingMode.HALF_EVEN);
        //
        DecimalFormatSymbols fs = new DecimalFormatSymbols();
        fs.setCurrencySymbol("vnd");
        f.setDecimalFormatSymbols(fs);
        return f.format(val);
    }

    @FXML
    void event_formatMoney(InputMethodEvent e) {
        
    }

}
