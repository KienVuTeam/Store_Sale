/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.appvn.store_sale.util.Connect_SQLSRV_StoreSale;
import java.sql.Connection;
/**
 *
 * @author HP
 */
public class Test_Connection {
    public static void main(String[] args) throws Exception {
        Connection conn = Connect_SQLSRV_StoreSale.getConection();
        System.out.println(conn);
        Connect_SQLSRV_StoreSale.printInfor(conn);
        conn.close();
    }
    
}
