/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.Manage_StoreHouse;
import com.appvn.store_sale.model.Manage_dvt;
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
public class Manage_dvt_DAO implements StoreHouse_Interface<Manage_dvt> {

    @Override
    public void add(Manage_dvt t) {
        String sql = "INSERT INTO unit (id_unit, unit_name) VALUES(?,?)";
        int result = 0;
        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getId_unit());
            pst.setString(2, t.getUnit_name());
            result = pst.executeUpdate();
            if (result != 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Query status");
                alert.setHeaderText("Câu lệnh sql bạn đang dùng: " + sql);
                alert.setContentText("Thành công");
                alert.show();
            }
            Connect_SQLSRV_StoreSale.closeConection(conn);
            pst.close();

        } catch (Exception ex) {
            Logger.getLogger(Manage_dvt_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void add_page2(Manage_dvt t) {
        String query_id_unit = "SELECT DISTINCT id_unit FROM unit WHERE unit_name =? ";
        int result = 0;
        String temp1 = null, temp2 = null;
        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst_query = conn.prepareStatement(query_id_unit);
            pst_query.setString(1, t.getUnit_namep2());
            ResultSet rs_temp = pst_query.executeQuery();
            while (rs_temp.next()) {
//                Manage_dvt mu = new Manage_dvt();
//                mu.setId_unit(rs_temp.getString("id_unit"));
//                temp1 = mu.getId_unit();
//                System.out.println("in trong dao: "+mu.getId_unit());
                temp1 = rs_temp.getString("id_unit");
            }
//            temp2 = temp1;
//            System.out.println("in trong dao temp2: " + temp1);
            pst_query.close();
            rs_temp.close();
//            Connect_SQLSRV_StoreSale.closeConection(conn);
            //
            String sql = "INSERT INTO unit_exchange (unitname_exchange, value_exchange, id_unit) VALUES(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getUnitname_exchange2());
            pst.setString(2, String.valueOf(t.getUnit_value2()));
            pst.setString(3, temp1);
            result = pst.executeUpdate();
            if (result != 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Query status");
                alert.setHeaderText("Câu lệnh sql bạn đang dùng: " + sql);
                alert.setContentText("Thành công");
                alert.show();
            }
            pst.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);
            

        } catch (Exception ex) {
            Logger.getLogger(Manage_dvt_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String temp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Manage_dvt t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<Manage_dvt> selectAll() {
        ObservableList<Manage_dvt> oblist = FXCollections.observableArrayList();
        try {
            int result = 0;
            String sql = "SELECT * FROM unit";

            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new Manage_dvt(rs.getString("id_unit"), rs.getString("unit_name")));
                System.out.println("in trong dao: " + oblist);
            }
            rs.close();
            pst.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);

        } catch (Exception ex) {
            Logger.getLogger(Manage_dvt_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oblist;
    }
    //
    public ObservableList<Manage_dvt> select_dvtAll() {
        ObservableList<Manage_dvt> oblist = FXCollections.observableArrayList();
        try {
            int result = 0;
            String sql = "SELECT * FROM unit";

            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new Manage_dvt(rs.getString("id_unit"), rs.getString("unit_name")));
                System.out.println("in trong dao: " + oblist);
            }
            rs.close();
            pst.close();
            Connect_SQLSRV_StoreSale.closeConection(conn);

        } catch (Exception ex) {
            Logger.getLogger(Manage_dvt_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oblist;
    }


}
