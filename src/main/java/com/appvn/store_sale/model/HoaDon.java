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
public class HoaDon {

    private int id;
    private String name;
    private String tensanpham;
    private int SoLuong;
    private int DonGia;
    private int ThanhTien;
    private int ChietSuat;
    private int TongSoLuongHang;
    private int Total;
    private int idNV;
    private int idKH;

    public HoaDon() {
    }
    public void HoaDon1(){
        
    }

    
    public HoaDon(int id, String name, String tensanpham, int SoLuong, int DonGia, int ThanhTien, int ChietSuat, int TongSoLuongHang, int Total, int idNV, int idKH) {
        this.id = id;
        this.name = name;
        this.tensanpham = tensanpham;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
        this.ChietSuat = ChietSuat;
        this.TongSoLuongHang = TongSoLuongHang;
        this.Total = Total;
        this.idNV = idNV;
        this.idKH = idKH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public int getChietSuat() {
        return ChietSuat;
    }

    public void setChietSuat(int ChietSuat) {
        this.ChietSuat = ChietSuat;
    }

    public int getTongSoLuongHang() {
        return TongSoLuongHang;
    }

    public void setTongSoLuongHang(int TongSoLuongHang) {
        this.TongSoLuongHang = TongSoLuongHang;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

   

    
    
}
