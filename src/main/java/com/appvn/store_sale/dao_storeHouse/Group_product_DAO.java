/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.Group_product;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author HP
 */
public class Group_product_DAO implements StoreHouse_Interface<Group_product>{

    @Override
    public void add(Group_product t) {
        String sql ="INSERT INTO group_product(name_gproduct, describe) values(?,?) ";
        int result =0;
        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getName_groupProduct());
            pst.setString(2, t.getDescribe());
            result = pst.executeUpdate();
            if (result != 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Query status");
                alert.setHeaderText(sql);
                alert.setContentText("Thành công");
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(Group_product_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(String temp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group_product t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<Group_product> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
