/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

import java.sql.Date;

/**
 *
 * @author hoang
 */
public class ThuTheoCongNo {
    private int macongno,sotien;
    private String idkhachhang;
    

    public ThuTheoCongNo() {
    }

    public ThuTheoCongNo(int macongno, int sotien, String idkhachhang) {
        this.macongno = macongno;
        this.sotien = sotien;
        this.idkhachhang = idkhachhang;
    }

    public int getMacongno() {
        return macongno;
    }

    public void setMacongno(int macongno) {
        this.macongno = macongno;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public String getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(String idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    
   

}
