/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.Customer;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author vippr
 */
public class CustomerDAO {

    Connection conn;

    public ObservableList<Customer> finall() throws Exception {
        ObservableList<Customer> ls = FXCollections.observableArrayList();
        this.conn = Connect_SQLSRV_StoreSale.getConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Customer");
        while (rs.next()) {
            Customer item = new Customer();
            item.setIdKH(rs.getString("MaKH"));
            item.setNameKH(rs.getString("nameKh"));
            item.setSDT(rs.getString("phone"));
            item.setEmail(rs.getString("email"));
            item.setDiaChi(rs.getString("addres"));
            ls.add(item);
        }
        conn.close();
        return ls;
    }

    public boolean Create(Customer newItem) {
        //item insert with id auto increment  
        boolean statusExecute = false;
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement ps = conn.prepareStatement("insert into Customer(MaKH,nameKh,phone,email,addres) values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, newItem.getIdKH());
            ps.setString(2, newItem.getNameKH());
            ps.setString(3, (newItem.getSDT()));
            ps.setString(4, newItem.getEmail());
            ps.setString(5, newItem.getDiaChi());
            statusExecute = ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusExecute;

    }

    public boolean Delete(Customer deleteItem) {
        boolean statusExecute = false;
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement ps = conn.prepareStatement("delete from Customer where nameKh = ?");
            ps.setString(1, deleteItem.getNameKH());
            int a = ps.executeUpdate();
            if (a == 1) {
                statusExecute = false;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusExecute;
    }

    public boolean Update(Customer newItem) {
        //item insert with id auto increment  
        boolean statusExecute = false;
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement ps = conn.prepareStatement("update Customer set nameKh=?,phone=?,email=?,addres=?  where maKH=?", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, newItem.getNameKH());
            ps.setString(2, (newItem.getSDT()));
            ps.setString(3, newItem.getEmail());
            ps.setString(4, newItem.getDiaChi());
            ps.setString(5, newItem.getIdKH());
            statusExecute = ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusExecute;

    }

}
