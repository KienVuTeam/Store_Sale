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
public class ThuTheoCongNo1 {
    private int macongno,sotien;
    private String namekhachhang;
    Date ngaybatdau,ngayketthuc;
    String loai;

    public ThuTheoCongNo1() {
    }

    public ThuTheoCongNo1(int macongno, int sotien, String namekhachhang, Date ngaybatdau, Date ngayketthuc, String loai) {
        this.macongno = macongno;
        this.sotien = sotien;
        this.namekhachhang = namekhachhang;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.loai = loai;
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

    public String getNamekhachhang() {
        return namekhachhang;
    }

    public void setNamekhachhang(String namekhachhang) {
        this.namekhachhang = namekhachhang;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
}
