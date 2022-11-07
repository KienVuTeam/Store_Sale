/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.ThuTheoCongNo;

import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hoang
 */
public class ThuTheoCongNoDAO {
     public ObservableList<ThuTheoCongNo> selectAll() {

        ObservableList<ThuTheoCongNo> oblist = FXCollections.observableArrayList();
        String sql = "SELECT * from CongNo ";
        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            System.out.println("Cai loi ngu nay co chayj trong DAO ko?");
            while (rs.next()) {
                  oblist.add(new ThuTheoCongNo(rs.getInt("IDCongNo") ,rs.getInt("CongNo"),rs.getString("maKH")));
//                System.out.println("in max hoa don "+ rs.getInt("ID_HD"));
//                System.out.println("In id: "+rs.getInt("id")+ "in ngay:" + rs.getDate("ngaytao") +rs.getInt("nhanvien")+ rs.getString("khachhang"));
            }
            pt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return oblist;
    }
}
