/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.HoaHong;
import com.appvn.store_sale.model.TongTienHoaHong;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hoang
 */
public class HoaHongDAO {
    public ObservableList<HoaHong> selectAll1() {
//        int result = 0;
        ObservableList<HoaHong> oblist = FXCollections.observableArrayList();
        String sql = "insert into  HoaHong(idnhanvien,sotien,idlaphoadon )\n" +
"select distinct idnhanvien,hoahong,id from LapHoaDon \n" +
"select distinct idlaphoadon,idnhanvien,sotien from HoaHong" 
 ;
       try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                oblist.add(new HoaHong( rs.getInt("idnhanvien"),rs.getInt("sotien"),rs.getInt("idlaphoadon"))) ;
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
     public ObservableList<TongTienHoaHong> selectAll() {
//        int result = 0;
        ObservableList<TongTienHoaHong> oblist = FXCollections.observableArrayList();
        
       try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
           Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select maNV, sum(distinct hoahong) as TienHoaHong from HoaHong group by maNV");

            while (rs.next()) {
                oblist.add(new TongTienHoaHong( rs.getInt("maNV"),rs.getInt("TienHoaHong"))) ;
            }
//            System.out.println("cau lenh ban dang dung: " + sql);
            System.out.println("so dong thay doi: " +oblist);
            //
            rs.close();
            conn.close();
        } catch (Exception e) {
//            System.out.println("moa may chu loi gi???: " + e.getMessage());
            e.printStackTrace();
        }
        return oblist;

    }
}
