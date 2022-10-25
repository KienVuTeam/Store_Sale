/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao;

import com.appvn.store_sale.model.NhanVien;
import com.appvn.store_sale.model.TaoHoaDon;
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
public class TaoHoaDonDAO {

    public int add(TaoHoaDon thd) {
        int result = 0;
        String sql = "INSERT INTO TaoHoaDon(ngaytao,nhanvien,khachhang) values(?,?,?)";

        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement

            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1, String.valueOf(thd.getNgayTao()));
            pt.setString(2, String.valueOf(thd.getNhanVienTao()));
            pt.setString(3, thd.getKhachHang());
            result = pt.executeUpdate();
            //
            System.out.println("cau lenh ban dang dung: " + sql);
            System.out.println("so dong thay doi: " + result);
            conn.close();
            System.out.println("in trong dao tao ");
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    public ObservableList<TaoHoaDon> selectAll() {

        ObservableList<TaoHoaDon> oblist = FXCollections.observableArrayList();
        String sql = "Select * from TaoHoaDon";
        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            System.out.println("Cai loi ngu nay co chayj trong DAO ko?");
            while (rs.next()) {
                oblist.add(new TaoHoaDon(rs.getDate("ngaytao"), rs.getInt("nhanvien"), rs.getString("khachhang")));
                System.out.println("In id: "+rs.getInt("id")+ "in ngay:" + rs.getDate("ngaytao") +rs.getInt("nhanvien")+ rs.getString("khachhang"));
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

    public ObservableList<TaoHoaDon> refresh() {
        int result = 0;
        ObservableList<TaoHoaDon> oblist = FXCollections.observableArrayList();
        String sql = "Select * from TaoHoaDon";
        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new TaoHoaDon(rs.getInt("id"), rs.getDate("ngaytao"), rs.getInt("nhanvien"), rs.getString("khachhang")));
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
}
