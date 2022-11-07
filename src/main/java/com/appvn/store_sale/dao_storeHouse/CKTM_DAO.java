/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.CKTM;
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
public class CKTM_DAO {
     Connection conn;
    
     public ObservableList<CKTM> finall() throws Exception   {
        ObservableList<CKTM> ls =FXCollections.observableArrayList();
        this.conn = Connect_SQLSRV_StoreSale.getConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from ChietKhuauTM");
        while (rs.next()) {
            CKTM item =new CKTM();
            item.setName_CKTM(rs.getString("Name_CKTM"));
            item.setDiscount(rs.getInt("chietkhuau"));
            item.setStart_CKTM(rs.getString("NgayBD"));
            item.setEnd_CKTM(rs.getString("NgayKT"));
            item.setDescription(rs.getString("MoTa"));
            ls.add(item);
        }
        conn.close();
        return ls;   
}    
public boolean Create(CKTM newItem) { 
        //item insert with id auto increment  
        boolean statusExecute=false; 
        try { 
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement ps=conn.prepareStatement("insert into ChietKhuauTM(Name_CKTM,chietkhuau,NgayBD,NgayKT,MoTa) values(?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS); 
            ps.setString(1,newItem.getName_CKTM());
            ps.setInt(2,newItem.getDiscount());
            ps.setString(3,(newItem.getStart_CKTM()));
            ps.setString(4,newItem.getEnd_CKTM());
             ps.setString(5,newItem.getDescription()); 
            statusExecute= ps.execute(); 
            ResultSet rs= ps.getGeneratedKeys(); 
            rs.close();
            ps.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return statusExecute; 

    }
   public boolean Delete(CKTM deleteItem) {
        boolean statusExecute = false;
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement ps = conn.prepareStatement("delete from ChietKhuauTM where Name_CKTM = ?");
            ps.setString(1, deleteItem.getName_CKTM());
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
}
