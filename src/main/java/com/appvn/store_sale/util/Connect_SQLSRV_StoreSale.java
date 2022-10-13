/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Connect_SQLSRV_StoreSale {
     public static Connection getConection() throws Exception{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //115.73.212.222,8888
        String URL = "jdbc:sqlserver://115.73.212.222:8888;databaseName=thecoffee2;encrypt=true;trustServerCertificate=true;";
        String username = "coffee2";
        String password = "123";
        Connection conn = DriverManager.getConnection(URL, username, password);

        return conn;
        } catch (Exception e) {
            e.printStackTrace();
            String err=e.getMessage();
            System.out.println(err);
        }
        return null;
    }
    //
    public static void closeConection(Connection conn){
        try {
            if (conn !=null){
                conn.close();
            }
        } catch (Exception e) {
        }
    }
    //
    public static void printInfor(Connection c) {
        if (c != null) {
            try {
//                System.out.println(c.getMetaData().toString());
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());

            } catch (SQLException ex) {
                Logger.getLogger(Connect_SQLSRV_StoreSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
