/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao;

import com.appvn.store_sale.model.LapHoaDon;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author hoang
 */
public class LapHoaDonDAO {
     public int add(LapHoaDon lhd){
        int result = 0;
        String sql = "Insert into LapHoaDon(ngaytao,idnhanvien,namekhachhang,tongtien,ghichu,idhoadon,hoahong) values (?,?,?,?,?,?,?)";
      
        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement
              
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1, String.valueOf(lhd.getNgaytao()));
            pt.setInt(2, lhd.getIdnhanvien());
            pt.setString(3, lhd.getNamekhachhang());
            pt.setInt(4, lhd.getTongtien());
            pt.setString(5, lhd.getGhichu());
            pt.setInt(6, lhd.getIdhoadon());
            pt.setInt(7, lhd.getHoahong());


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
}
