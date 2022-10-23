/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao;

import com.appvn.store_sale.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author hoang
 */
public class NhanVienDAO  {
    public int add(NhanVien nv){
        int result = 0;
        String sql = "INSERT INTO NhanVien1(name,GioiTinh,NgaySinh,ChucVu,NgayVaoLam,SDT,DiaChi) values(?,?,?,?,?,?,?)";
      
        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement
              
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1, nv.getNameNV());
            pt.setString(2,nv.getGioiTinh());
            pt.setString(3, String.valueOf(nv.getNgaySinh()));
            pt.setString(4,nv.getChucVu());
            pt.setString(5, String.valueOf(nv.getNgayVaoLam()));
            pt.setInt(6, nv.getSDT());
            pt.setString(7, nv.getDiaChi());

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
//    NhanVien nv2 = new NhanVien(0, nameNV, GioiTinh, LocalDate.MAX, ChucVu, LocalDate.MIN, 0, DiaChi);
    public ObservableList<NhanVien> selectAll() {
        int result = 0;
        ObservableList<NhanVien> oblist = FXCollections.observableArrayList();
        String sql = "Select id,name,NgaySinh,GioiTinh,NgayVaoLam,ChucVu,SDT,DiaChi from NhanVien1";
       try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new NhanVien(rs.getInt("id"), rs.getString("name"), rs.getString("GioiTinh"), rs.getDate("NgayVaoLam"),
                        rs.getString("ChucVu"),rs.getDate("NgaySinh"), rs.getInt("SDT"), rs.getString("DiaChi"))) ;
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
    public ObservableList<NhanVien> delete(NhanVien nv ){
        int result = 0;
    ObservableList<NhanVien> oblist = FXCollections.observableArrayList();

        String sql = "DELETE from NhanVien1 where id = ?";

        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();

            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
               oblist.add(new NhanVien(rs.getInt("id"), rs.getString("name"), rs.getString("GioiTinh"), rs.getDate("NgayVaoLam"),
                        rs.getString("ChucVu"),rs.getDate("NgaySinh"), rs.getInt("SDT"), rs.getString("DiaChi"))) ;
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
    
     public ObservableList<NhanVien> refresh() {
        int result = 0;
        ObservableList<NhanVien> oblist = FXCollections.observableArrayList();
        String sql = "Select * from NhanVien1";
       try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new NhanVien(rs.getInt("id"), rs.getString("name"), rs.getString("GioiTinh"), rs.getDate("NgayVaoLam"),
                        rs.getString("ChucVu"),rs.getDate("NgaySinh"), rs.getInt("SDT"), rs.getString("DiaChi"))) ;
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