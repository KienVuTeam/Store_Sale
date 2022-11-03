/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao;

import com.appvn.store_sale.model.GioHang;
import com.appvn.store_sale.model.NhomSanPham;
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
public class NhomSanPhamDAO {
       public ObservableList<NhomSanPham> selectAll1() {
        int soluong = 1;
        ObservableList<NhomSanPham> oblist = FXCollections.observableArrayList();
        String sql = "select * from testGroup  ";

        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new NhomSanPham(rs.getInt("id"),rs.getString("name"),rs.getString("loai"),rs.getInt("dongia"),rs.getInt("tonkho"),rs.getInt("idsanpham")));
                System.out.println("Instt: " + rs.getInt("id"));
            }
            System.out.println("cau lenh ban dang dung: " + sql);
            System.out.println("so dong thay doi: " + soluong);
            //
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return oblist;

    }
}
