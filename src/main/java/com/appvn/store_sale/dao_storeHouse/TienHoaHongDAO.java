/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.TienHoaHong;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author hoang
 */
public class TienHoaHongDAO {
     public int add(TienHoaHong kh) {
        int result = 0;
        String sql = "INSERT INTO HoaHong(ID_HD,maNV,hoahong) values(?,?,?)";

        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement

            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setInt(1, kh.getID_HD());
            pt.setInt(2, kh.getMaNV());
            pt.setInt(3, kh.getHoahong());

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
