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
public class ThuTheoHoaDon1 {
    private int mahoadon,sotien;
    private String namekhachhang;
    private Date ngaytao,ngayketthuc;
    private String loai;

    public ThuTheoHoaDon1() {
    }

    public ThuTheoHoaDon1(int mahoadon, int sotien, String namekhachhang, Date ngaytao, Date ngayketthuc, String loai) {
        this.mahoadon = mahoadon;
        this.sotien = sotien;
        this.namekhachhang = namekhachhang;
        this.ngaytao = ngaytao;
        this.ngayketthuc = ngayketthuc;
        this.loai = loai;
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

    public String getNamekhachhang() {
        return namekhachhang;
    }

    public void setNamekhachhang(String namekhachhang) {
        this.namekhachhang = namekhachhang;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
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
