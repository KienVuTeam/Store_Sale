/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.HoaDon;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author vippr
 */
public class HoaDon_DAO {

    Connection conn;

    public ObservableList<HoaDon> finall_hoadoncho() throws Exception {
        ObservableList<HoaDon> ls = FXCollections.observableArrayList();
        this.conn = Connect_SQLSRV_StoreSale.getConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select ID_HD,cs.maKH,nameKH,nv.name,ngay_tao from HoaDon hd join Customer cs on hd.maKH=cs.maKH \n"
                + "left join NhanVien nv on nv.id=hd.maNV  where  trangthai=N'Hóa Đơn Chờ'");
        while (rs.next()) {
            HoaDon item = new HoaDon();
            item.setIdhd(rs.getInt("ID_HD"));
            item.setIdKH(rs.getString("maKH"));
            item.setNameKH(rs.getString("nameKH"));
            item.setNameNV(rs.getString("name"));
            item.setNgaytao(rs.getString("ngay_tao"));
            ls.add(item);
        }
        conn.close();
        return ls;
    }

    public ObservableList<HoaDon> finall_sanpham() throws Exception {
        ObservableList<HoaDon> ls = FXCollections.observableArrayList();
        this.conn = Connect_SQLSRV_StoreSale.getConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select sp.id_sanpham,tensanpham,giabanle, tonkho-sum(soluong) as tonkho from ChiTietHD ct join sanpham sp on ct.id_sanpham=sp.id_sanpham \n"
                + "group by tonkho, sp.id_sanpham,tensanpham,giabanle");
        while (rs.next()) {
            HoaDon item = new HoaDon();
            item.setIdSP(rs.getString("id_sanpham"));
            item.setTensp(rs.getString("tensanpham"));
            item.setGiaban(rs.getInt("giabanle"));
            item.setTonkho(rs.getInt("tonkho"));
            ls.add(item);
        }
        conn.close();
        return ls;
    }

    public ObservableList<HoaDon> finall_bill() throws Exception {
        ObservableList<HoaDon> ls = FXCollections.observableArrayList();
        this.conn = Connect_SQLSRV_StoreSale.getConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from bill");
        while (rs.next()) {
            HoaDon item = new HoaDon();
            item.setTensp(rs.getString("tensanpham"));
            item.setGiaban(rs.getInt("giaban"));
            item.setSoluong(rs.getInt("soluong"));
            item.setTongtien(rs.getInt("toltal"));
            ls.add(item);
        }
        conn.close();
        return ls;
    }

    public ObservableList<HoaDon> finall_hoadon() throws Exception {
        ObservableList<HoaDon> ls = FXCollections.observableArrayList();
        this.conn = Connect_SQLSRV_StoreSale.getConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select hd.ID_HD,cs.maKH,nameKH,nv.name,ngay_tao,trangthai,tongtien from HoaDon hd join Customer cs on hd.maKH=cs.maKH \n"
                + "left join NhanVien nv on nv.id=hd.maNV");
        while (rs.next()) {
            HoaDon item = new HoaDon();
            item.setIdhd(rs.getInt("ID_HD"));
            item.setIdKH(rs.getString("maKH"));
            item.setNameKH(rs.getString("nameKH"));
            item.setNameNV(rs.getString("name"));
            item.setNgaytao(rs.getString("ngay_tao"));
            item.setTrangthai(rs.getString("trangthai"));
            item.setTongtien(rs.getInt("tongtien"));
            ls.add(item);
        }
        conn.close();
        return ls;
    }

    public boolean Create(HoaDon newItem) {
        //item insert with id auto increment  
        boolean statusExecute = false;
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement ps = conn.prepareStatement("insert into ChiTietHD(ID_HD,id_sanpham,giaban,soluong) values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, newItem.getIdhd());
            ps.setString(2, newItem.getIdSP());
            ps.setInt(3, (newItem.getGiaban()));
            ps.setInt(4, newItem.getSoluong());
            statusExecute = ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusExecute;
    }

    public boolean Delete(HoaDon deleteItem) {
        boolean statusExecute = false;
        try {
            this.conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement ps = conn.prepareStatement("delete from ChiTietHD where ID_HD=?");
            ps.setInt(1, deleteItem.getIdhd());
            int a = ps.executeUpdate();
            if (a == 1) {
                statusExecute = false;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusExecute;
    }
}
