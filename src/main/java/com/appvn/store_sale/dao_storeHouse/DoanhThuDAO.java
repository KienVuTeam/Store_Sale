/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.HoaHong;
import com.appvn.store_sale.model.TienHoaHong;

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
public class DoanhThuDAO {
    public ObservableList<HoaHong> selectAll() {
        int result = 0;
        ObservableList<HoaHong> oblist = FXCollections.observableArrayList();
        String sql = "SELECT  TOP 1 * FROM HoaDon where trangthai=N'Đã thanh toán' ORDER BY ID_HD DESC  ";
       try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new HoaHong(rs.getInt("maNV"), rs.getInt("ID_HD"),rs.getInt("tongtien")));
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
    
     public ObservableList<TienHoaHong> selectAll1() {
        int result = 0;
        ObservableList<TienHoaHong> oblist = FXCollections.observableArrayList();
        String sql = "Select * from HoaHong";
       try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new TienHoaHong(rs.getInt("maNV"), rs.getInt("ID_HD"),rs.getInt("hoahong")));
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
