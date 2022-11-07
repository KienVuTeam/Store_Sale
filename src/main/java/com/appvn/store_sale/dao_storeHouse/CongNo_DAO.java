/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;
import com.appvn.store_sale.model.CongNo;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author vippr
 */
public class CongNo_DAO {

    Connection conn;

    public ObservableList<CongNo> finall() throws Exception {
        ObservableList<CongNo> ls = FXCollections.observableArrayList();
        this.conn = Connect_SQLSRV_StoreSale.getConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select *from congnokhachhang1 where tongtien >0 ");
        while (rs.next()) {
            CongNo item = new CongNo();
            item.setNameKh(rs.getString("nameKH"));
            item.setPhone(rs.getString("phone"));
            item.setMaKH(rs.getString("maKH"));
            item.setCongno(rs.getInt("tongtien"));
            ls.add(item);
        }
        conn.close();
        return ls;
    }
    public ObservableList<CongNo> finalltongtien() throws Exception {
        ObservableList<CongNo> ls = FXCollections.observableArrayList();
        this.conn = Connect_SQLSRV_StoreSale.getConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select namekh,phone,email,sum(tongtien) as tongtien  from Customer cs join HoaDon hd on cs.maKH=hd.maKH\n"
                + "group by namekh,phone,email ");
        while (rs.next()) {
            CongNo item = new CongNo();
            item.setNameKh(rs.getString("nameKH"));
            item.setEmail(rs.getString("email"));
            item.setPhone(rs.getString("phone"));
            item.setCongno(rs.getInt("tongtien"));
            ls.add(item);
        }
        conn.close();
        return ls;
    }
}
