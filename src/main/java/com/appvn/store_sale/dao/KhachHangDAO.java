/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao;

import com.appvn.store_sale.model.KhachHang;
import com.appvn.store_sale.model.SanPham;
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
public class KhachHangDAO {

    public int add(KhachHang kh) {
        int result = 0;
        String sql = "INSERT INTO test(name,sdt,diachi) values(?,?,?)";

        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement

            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1, kh.getNameKH());
            pt.setInt(2, kh.getSDT());
            pt.setString(3, kh.getDiaChi());

//          //b3: thu thi cau lenh SQL
            result = pt.executeUpdate();
            //
            System.out.println("cau lenh ban dang dung: " + sql);
            System.out.println("so dong thay doi: " + result);
            conn.close();
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    public ObservableList<KhachHang> selectAll1() {
//        int result = 0;
        ObservableList<KhachHang> oblist = FXCollections.observableArrayList();
        String sql = "Select *from test";
       try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new KhachHang(rs.getInt("id"),rs.getString("name"), rs.getInt("sdt"),rs.getString("DiaChi"))) ;
            }
            System.out.println("cau lenh ban dang dung: " + sql);
            System.out.println("so dong thay doi: " +oblist);
            //
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return oblist;

    }
//   

}
