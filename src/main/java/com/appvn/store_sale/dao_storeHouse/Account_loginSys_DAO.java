/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import com.appvn.store_sale.model.Account_loginSystem;
import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.ObservableList;

/**
 *
 * @author HP
 */
public class Account_loginSys_DAO implements StoreHouse_Interface<Account_loginSystem> {

    public Account_loginSystem checkLogin(String user, String password) throws Exception {
        String sql = "SELECT username, password, roles FROM user_account "
                + "WHERE username =? and password =? ";
        System.out.println("bien dau vao: " + user + " " + password);

        try {
            Connection conn = Connect_SQLSRV_StoreSale.getConection();
            PreparedStatement pst = conn.prepareStatement(sql);
            //
            pst.setString(1, user);
            pst.setString(2, password);
            try {
                ResultSet rs = pst.executeQuery();
                System.out.println("bien rs la gi? :"+rs);
                if (rs.next()) {
                    Account_loginSystem taikhoan = new Account_loginSystem();
                    taikhoan.setUsername(rs.getString("username"));
                    taikhoan.setPassword(rs.getString("password"));
                    System.out.println("in trong DAO: " + taikhoan.getUsername() + " | " + taikhoan.getPassword());
                    return taikhoan;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(Account_loginSystem t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String temp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account_loginSystem t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<Account_loginSystem> selectAll() {
//        ObservableList data = FXCollections.observableArrayList();
//        String query ="select * from ";
//        try {
//            Connection conn = Connect_SQLSRV_StoreSale.getConection();
//            PreparedStatement pst = conn.prepareStatement(query);
//            ResultSet rs =pst.executeQuery();
//            while(rs.next()){
//                data.add(new Account_loginSystem(rs.getString("username"), rs.getString("password"), rs.getString("roles")));
//            }
//            rs.close();
//            pst.close();
//            Connect_SQLSRV_StoreSale.closeConection(conn);
//        } catch (Exception ex) {
//            Logger.getLogger(Account_loginSys_DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;

    }

}
