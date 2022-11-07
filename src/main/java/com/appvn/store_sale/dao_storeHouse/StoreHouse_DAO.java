/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.Manage_StoreHouse;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 *
 * @author HP
 */
public class StoreHouse_DAO implements StoreHouse_Interface<Manage_StoreHouse> {

    @Override
    public void add(Manage_StoreHouse t) {
        try {
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//            LocalDateTime now = LocalDateTime.now();
//            System.out.println(dtf.format(now));
            int result = 0;
            String sql = "INSERT INTO storehouse (id_storehouse, name_store, storehouse_address, type, create_at) VALUES(?,?,?,?,?)";
            //
            Long datetime = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(datetime);
//            System.out.println("Current Time Stamp: " + timestamp);
            //
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getCode_storeHouse());
            pst.setString(2, t.getName_store());
            pst.setString(3, t.getStoreHouse_address());
            pst.setString(4, t.getType());
            pst.setString(5, String.valueOf(timestamp));
//            System.out.println("in trong dao: "+t.getDate());
            result = pst.executeUpdate();
            if (result != 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Query status");
                alert.setHeaderText(sql);
                alert.setContentText("Thanh cong");

                alert.show();
            } else {
                Alert alter = new Alert(Alert.AlertType.INFORMATION);
                alter.setTitle("Query status");
                alter.setHeaderText(sql);
                alter.setContentText("That bai");
                alter.show();
            }
            pst.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);
        } catch (Exception ex) {
            Logger.getLogger(StoreHouse_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ObservableList<Manage_StoreHouse> selectAll() {
        ObservableList<Manage_StoreHouse> oblist = FXCollections.observableArrayList();
        try {
            int result = 0;
            String sql = "SELECT * FROM storehouse";

            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
//                System.out.println("lay day trong rs next "+rs.getTimestamp("create_at"));
                oblist.add(new Manage_StoreHouse(rs.getString("id_storehouse"), rs.getString("name_store"), rs.getString("storehouse_address"), rs.getString("type"), rs.getTimestamp("create_at")));
            }

            rs.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);
        } catch (Exception ex) {
            Logger.getLogger(StoreHouse_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oblist;
    }

    public void delete(String temp) {
        String sql = "DELETE FROM storehouse WHERE storehouse_address = ?";
        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, temp);
            pst.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StoreHouse_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Manage_StoreHouse t) {
        int result = 0;
        String sql = "UPDATE storehouse"
                + " SET type =?"
                + " WHERE storehouse_address=?";

        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(2, t.getStoreHouse_address());
            pst.setString(1, t.getType());
            System.out.println("in " + t.getStoreHouse_address() + " in 2 " + t.getType());

            result = pst.executeUpdate();
            if (result != 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Query status");
                alert.setHeaderText(sql);
                alert.setContentText("Thanh cong");

                alert.show();
            } else {
                Alert alter = new Alert(Alert.AlertType.INFORMATION);
                alter.setTitle("Query status");
                alter.setHeaderText(sql);
                alter.setContentText("That bai");
                alter.show();
            }
            pst.close();
            Connect_SQLSRV_StoreSale.getConection();
        } catch (Exception ex) {
            Logger.getLogger(StoreHouse_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
