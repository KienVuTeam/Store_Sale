/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author hoang
 */
public class SanPham {

    private int id;
    private String name;
    private String LoaiSanPham;
    private int GiaNhap;
    private int GiaBan;
    private String HangSanXuat;
    private int TonKho;

    public SanPham(int id, String name, String LoaiSanPham, int GiaNhap, int GiaBan, String HangSanXuat, int TonKho) {
        this.id = id;
        this.name = name;
        this.LoaiSanPham = LoaiSanPham;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.HangSanXuat = HangSanXuat;
        this.TonKho = TonKho;
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

    public String getLoaiSanPham() {
        return LoaiSanPham;
    }

    public void setLoaiSanPham(String LoaiSanPham) {
        this.LoaiSanPham = LoaiSanPham;
    }

    public int getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(int GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getHangSanXuat() {
        return HangSanXuat;
    }

    public void setHangSanXuat(String HangSanXuat) {
        this.HangSanXuat = HangSanXuat;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }
    

}
