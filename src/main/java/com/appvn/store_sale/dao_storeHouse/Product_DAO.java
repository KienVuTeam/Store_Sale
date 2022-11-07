/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.Manage_dvt;
import com.appvn.store_sale.model.Product;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author HP
 */
public class Product_DAO implements StoreHouse_Interface<Product> {

  

    @Override
    public void add(Product t) {
        int result = 0;
        String sql = "INSERT INTO product (name_product, wholesale_price, retail_price, profit, inventory_quantity, inventory_unit) values(?,?,?,?,?,?)";
        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getNameP());
            pst.setString(2, String.valueOf(t.getWholesale_price()));
            pst.setString(3, String.valueOf(t.getRetail_price()));
            pst.setString(4, String.valueOf(t.getProfit()));
            pst.setString(5, String.valueOf(t.getInventory_quantity()));
            pst.setString(6, String.valueOf(t.getUnit()));

            System.out.println("in trong DAO: " + t.getRetail_price());
            result = pst.executeUpdate();
            if (result != 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Query status");
                alert.setHeaderText(sql);
                alert.setContentText("Thành công");
                alert.show();
            }
            pst.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);
        } catch (Exception ex) {
            Logger.getLogger(Product_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String temp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Product t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<Product> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
