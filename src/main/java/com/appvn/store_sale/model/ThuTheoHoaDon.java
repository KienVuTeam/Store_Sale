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
public class ThuTheoHoaDon {
    private int mahoadon,sotien;
    private String idkhachhang,trangthai;
    private Date ngaytao;
    
    public ThuTheoHoaDon() {
    }

    public ThuTheoHoaDon(int mahoadon, int sotien, String idkhachhang, String trangthai, Date ngaytao) {
        this.mahoadon = mahoadon;
        this.sotien = sotien;
        this.idkhachhang = idkhachhang;
        this.trangthai = trangthai;
        this.ngaytao = ngaytao;
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
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

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

  

        


   

    

  
}
