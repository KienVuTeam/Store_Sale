/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.appvn.store_sale.controller;

import com.appvn.store_sale.dao_storeHouse.Product_DAO;
import com.appvn.store_sale.model.Manage_dvt;
import com.appvn.store_sale.model.Product;
import com.appvn.store_sale.res.StringValue;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Manage_productController implements Initializable {

    private Stage stage;
    private Scene scene;
    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox<String> cbx_unit;

    @FXML
    private ComboBox<String> cbx_unit_ex;

    @FXML
    private TextField iptf_le_price;

    @FXML
    private TextField iptf_nameP;

    @FXML
    private TextField iptf_profit;

    @FXML
    private TextField iptf_si_price;

    @FXML
    private TextField iptf_ton_quantity;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getUnit();
        getUnit2();
    }

//    @FXML
//    void oat_back(ActionEvent e) throws IOException {
//        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        FXMLLoader load = new FXMLLoader(getClass().getResource(StringValue.MANAGER_STORE_HOUSE));
//        Parent layout = load.load();
//        scene = new Scene(layout, 1000, 700);
//        stage.setScene(scene);
//        stage.show();
//    }

    @FXML
    public void oat_add(ActionEvent e) {
        Product p = new Product();
        p.setNameP(iptf_nameP.getText());
        p.setWholesale_price(Float.valueOf(iptf_si_price.getText()));
        p.setRetail_price(Float.valueOf(iptf_le_price.getText()));
        p.setProfit(Float.valueOf(iptf_profit.getText()));
        p.setInventory_quantity(Float.valueOf(iptf_ton_quantity.getText()));
        p.setUnit(cbx_unit.getValue());
        System.out.println("trong controller: " + p.getRetail_price());
        Product_DAO dao = new Product_DAO();
        dao.add(p);

    }

    public void getUnit() {
        //query2
        ObservableList list_unit = FXCollections.observableArrayList();
//        String query_unit = "select  u.unit_name, ux.unitname_exchange from unit as u left join unit_exchange as ux on u.id_unit = ux.id_unit";
//        String query_unit = "select u.unit_name, ux.unitname_exchange from unit as u, unit_exchange as ux";
        String query1 = "select unit_name from unit";
        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst_unit = conn.prepareStatement(query1);
            ResultSet rs = pst_unit.executeQuery();
            while (rs.next()) {
                list_unit.add(rs.getString("unit_name"));
            }
            cbx_unit.setItems(list_unit);

        } catch (Exception ex) {
            Logger.getLogger(Product_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getUnit2() {
        //query2
        ObservableList list_unit = FXCollections.observableArrayList();
//        String query1 = "select unit_name from unit";
        String query2 = "select unitname_exchange from unit_exchange";
        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst_unit2 = conn.prepareStatement(query2);

            ResultSet rs = pst_unit2.executeQuery();
            while (rs.next()) {               
                if (rs.getString("unitname_exchange") == null) {
                } else {
                    list_unit.add(rs.getString("unitname_exchange"));
                }
            }
            cbx_unit_ex.setItems(list_unit);

        } catch (Exception ex) {
            Logger.getLogger(Product_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
