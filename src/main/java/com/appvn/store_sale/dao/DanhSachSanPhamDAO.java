/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao;

import com.appvn.store_sale.model.NhanVien;
import com.appvn.store_sale.model.SanPham;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hoang
 */
public class DanhSachSanPhamDAO {

    public ObservableList<SanPham> selectAll1() {
//        int result = 0;
        ObservableList<SanPham> oblist = FXCollections.observableArrayList();
        String sql = "Select *from test1";
        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
//            SanPham sp = new SanPham();
//          pt.setString(1, sp.getName());
//          pt.setFloat(2, sp.getGiabansi());
//           pt.setFloat(3, sp.getGiabanle());
//            pt.setFloat(4, sp.getChietsuat());
//             pt.setFloat(5, sp.getTonkho());
//             pt.setString(6, sp.getDonvi());
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new SanPham(rs.getInt("id"),rs.getString("tensanpham"), rs.getFloat("giabansi"), rs.getFloat("giabanle"), rs.getFloat("chietsuat"), rs.getInt("tonkho"), rs.getString("donvi")));
            }
            System.out.println("cau lenh ban dang dung: " + sql);
            System.out.println("so dong thay doi: " + oblist);
            //
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return oblist;

    }
    public ObservableList<SanPham> research(){
        int result = 0;
        ObservableList<SanPham> oblist = FXCollections.observableArrayList();
        String sql = "Select id,name,NgaySinh,GioiTinh,NgayVaoLam,ChucVu,SDT,DiaChi from NhanVien where name=?";
       try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            
            PreparedStatement pt = conn.prepareStatement(sql);
            SanPham sp = new SanPham();
          pt.setString(1, sp.getName());
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                 oblist.add(new SanPham(rs.getInt("id"),rs.getString("tensanpham"), rs.getFloat("giabansi"), rs.getFloat("giabanle"), rs.getFloat("chietsuat"), rs.getInt("tonkho"), rs.getString("donvi")));
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
