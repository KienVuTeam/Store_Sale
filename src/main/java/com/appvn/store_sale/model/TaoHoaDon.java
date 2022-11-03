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
public class TaoHoaDon {
    private int id;
    private  Date NgayTao;
    private int NhanVienTao;
    private String KhachHang;
    private Date day;
    private int nv;
    private String kh;
    private int id1; 
    
    
    public TaoHoaDon() {
    }

    public TaoHoaDon(Date day, int nv, String kh, int id1) {
        this.day = day;
        this.nv = nv;
        this.kh = kh;
        this.id1 = id1;
    }

    

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getNv() {
        return nv;
    }

    public void setNv(int nv) {
        this.nv = nv;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    
    
    

//    public TaoHoaDon(Date NgayTao, int NhanVienTao, String KhachHang) {
//        this.NgayTao = NgayTao;
//        this.NhanVienTao = NhanVienTao;
//        this.KhachHang = KhachHang;
//    }
    
    public TaoHoaDon(int id, Date NgayTao, int NhanVienTao, String KhachHang) {
        this.id = id;
        this.NgayTao = NgayTao;
        this.NhanVienTao = NhanVienTao;
        this.KhachHang = KhachHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public int getNhanVienTao() {
        return NhanVienTao;
    }

    public void setNhanVienTao(int NhanVienTao) {
        this.NhanVienTao = NhanVienTao;
    }

    public String getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(String KhachHang) {
        this.KhachHang = KhachHang;
    }

    
    
}
