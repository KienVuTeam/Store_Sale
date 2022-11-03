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
public class LapHoaDon {
    private int id,idkhachhang,idnhanvien,idhoadon,tongtien,hoahong;
    private Date ngaytao;
    private String  namekhachhang,ghichu;

    public LapHoaDon() {
    }

    public LapHoaDon(int id, int idkhachhang, int idnhanvien, int idhoadon, int tongtien, int hoahong, Date ngaytao, String namekhachhang, String ghichu) {
        this.id = id;
        this.idkhachhang = idkhachhang;
        this.idnhanvien = idnhanvien;
        this.idhoadon = idhoadon;
        this.tongtien = tongtien;
        this.hoahong = hoahong;
        this.ngaytao = ngaytao;
        this.namekhachhang = namekhachhang;
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(int idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public int getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(int idhoadon) {
        this.idhoadon = idhoadon;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getHoahong() {
        return hoahong;
    }

    public void setHoahong(int hoahong) {
        this.hoahong = hoahong;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNamekhachhang() {
        return namekhachhang;
    }

    public void setNamekhachhang(String namekhachhang) {
        this.namekhachhang = namekhachhang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

   
    

   

    
}
