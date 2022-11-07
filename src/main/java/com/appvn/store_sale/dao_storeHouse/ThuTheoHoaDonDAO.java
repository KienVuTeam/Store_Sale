/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.ThuTheoCongNo1;
import com.appvn.store_sale.model.ThuTheoHoaDon;
import com.appvn.store_sale.model.ThuTheoHoaDon1;
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
public class ThuTheoHoaDonDAO {
    
    public ObservableList<ThuTheoHoaDon> selectAll() {

        ObservableList<ThuTheoHoaDon> oblist = FXCollections.observableArrayList();
        String sql = "SELECT ID_HD,tongtien,maKH,trangthai,ngay_tao from HoaDon where trangthai=N'Chưa Thanh Toán'  ";
        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            System.out.println("Cai loi ngu nay co chayj trong DAO ko?");
            while (rs.next()) {
                  oblist.add(new ThuTheoHoaDon(rs.getInt("ID_HD") ,rs.getInt("tongtien") ,rs.getString("maKH"),rs.getString("trangthai"),rs.getDate("ngay_tao")));
                System.out.println("in max hoa don "+ rs.getInt("ID_HD"));
//                System.out.println("In id: "+rs.getInt("id")+ "in ngay:" + rs.getDate("ngaytao") +rs.getInt("nhanvien")+ rs.getString("khachhang"));
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
     public int add(ThuTheoHoaDon1 lhd){
        int result = 0;
        String sql = "Insert into DanhSachPhieuThu(ID,sotien,name,ngaybatdau,ngayketthuc,loai) values (?,?,?,?,?,?)";
      
        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement
              
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setInt(1, lhd.getMahoadon());
            pt.setInt(2, lhd.getSotien());
            pt.setString(3, lhd.getNamekhachhang());
            pt.setString(4,String.valueOf(lhd.getNgaytao()));
            pt.setString(5, String.valueOf(lhd.getNgayketthuc()));
            pt.setString(6, lhd.getLoai());


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
      public ObservableList<ThuTheoHoaDon1> selectAll1() {

        ObservableList<ThuTheoHoaDon1> oblist = FXCollections.observableArrayList();
        String sql = "SELECT ID_HD,sotien,name,ngaytao,ngayketthuc,loai  ";
        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            System.out.println("Cai loi ngu nay co chayj trong DAO ko?");
            while (rs.next()) {
                  oblist.add(new ThuTheoHoaDon1(rs.getInt("ID_HD") ,rs.getInt("sotien") ,rs.getString("name"),rs.getDate("ngaytao"),rs.getDate("ngayketthuc"),rs.getString("loai")));
                System.out.println("in max hoa don "+ rs.getInt("ID_HD"));
//                System.out.println("In id: "+rs.getInt("id")+ "in ngay:" + rs.getDate("ngaytao") +rs.getInt("nhanvien")+ rs.getString("khachhang"));
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
      public int add1(ThuTheoCongNo1 lhd){
        int result = 0;
        String sql = "Insert into DanhSachPhieuThu(ID,sotien,name,ngaybatdau,ngayketthuc,loai) values (?,?,?,?,?,?)";
      
        try {
            //b1r
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //b2 tao ra doi t;uong preparedStatement
              
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setInt(1, lhd.getMacongno());
            pt.setInt(2, lhd.getSotien());
            pt.setString(3, lhd.getNamekhachhang());
            pt.setString(4,String.valueOf(lhd.getNgaybatdau()));
            pt.setString(5, String.valueOf(lhd.getNgayketthuc()));
            pt.setString(6, lhd.getLoai());


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
      public ObservableList<ThuTheoHoaDon1> selectAll2() {

        ObservableList<ThuTheoHoaDon1> oblist = FXCollections.observableArrayList();
        String sql = "SELECT * from DanhSachPhieuThu ";
        try {
            //b1
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            //
            PreparedStatement pt = conn.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            System.out.println("Cai loi ngu nay co chayj trong DAO ko?");
            while (rs.next()) {
                  oblist.add(new ThuTheoHoaDon1(rs.getInt("ID") ,rs.getInt("sotien") ,rs.getString("name"),rs.getDate("ngaybatdau"),rs.getDate("ngayketthuc"),rs.getString("loai")));
//                System.out.println("in max hoa don "+ rs.getInt("ID_HD"));
//                System.out.println("In id: "+rs.getInt("id")+ "in ngay:" + rs.getDate("ngaytao") +rs.getInt("nhanvien")+ rs.getString("khachhang"));
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
      }
