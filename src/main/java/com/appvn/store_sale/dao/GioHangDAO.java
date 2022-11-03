/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao;

import com.appvn.store_sale.model.GioHang;
import com.appvn.store_sale.model.NhomSanPham;

//import com.appvn.store_sale.model.NhanVien;
//import com.appvn.store_sale.model.SanPham;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import java.sql.ResultSet;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;

/**
 *
 * @author hoang
 */
public class GioHangDAO {

    public int add(GioHang gh) {
        int result = 0;
        String sql = "INSERT GioHang(name,dongia,soluong,thanhtien) values(?,?,?,?)";

        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement

            PreparedStatement pt = conn.prepareStatement(sql);
//            pt.setString(1, String.valueOf(gh.getIdsanpham())); 
            pt.setString(1, gh.getName());
            pt.setString(2, String.valueOf(gh.getDongia()));
            pt.setString(3, String.valueOf(gh.getSoluong()));
            pt.setString(4, String.valueOf(gh.getThanhtien()));

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

    public ObservableList<GioHang> selectAll() {
        int result = 0;
        ObservableList<GioHang> oblist = FXCollections.observableArrayList();
        String sql = "select * from GioHang  ";

        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new GioHang(rs.getInt("id"), rs.getString("name"), rs.getFloat("dongia"), rs.getInt("soluong"), rs.getFloat("thanhtien")));
            }
            System.out.println("cau lenh ban dang dung: " + sql);
            System.out.println("so dong thay doi: " + result);
            //
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("chay cau lenh trong DAo show");

        return oblist;

    }

    public ObservableList<GioHang> deleteRow() {
        int result = 0;

        ObservableList<GioHang> oblist = FXCollections.observableArrayList();

        String sql = "DELETE from GioHang ";

        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();

            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new GioHang(rs.getInt("id"), rs.getString("name"), rs.getFloat("dongia"), rs.getInt("soluong"), rs.getFloat("thanhtien")));
            }
            System.out.println("cau lenh ban dang dung: " + sql);
            System.out.println("so dong thay doi: " + result);
            //
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return oblist;
    }

    public ObservableList<GioHang> refresh() {
        int soluong = 0;
        ObservableList<GioHang> oblist = FXCollections.observableArrayList();
        String sql = "SELECT TOP 1 * FROM GioHang ORDER BY id DESC ";

        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new GioHang(rs.getInt("id"), rs.getString("name"), rs.getFloat("dongia"), rs.getInt("soluong"), rs.getFloat("thanhtien")));
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
