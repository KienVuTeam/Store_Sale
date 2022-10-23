/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

import java.sql.Time;

/**
 *
 * @author hoang
 */
public class ChietKhauThuongMai {
    private int id;
    private String name;
    private int GiaTriChietKhau;
    private Time ThoiGianBatDau;
    private Time ThoiGianKetThuc;

    public ChietKhauThuongMai(int id, String name, int GiaTriChietKhau, Time ThoiGianBatDau, Time ThoiGianKetThuc) {
        this.id = id;
        this.name = name;
        this.GiaTriChietKhau = GiaTriChietKhau;
        this.ThoiGianBatDau = ThoiGianBatDau;
        this.ThoiGianKetThuc = ThoiGianKetThuc;
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

    public int getGiaTriChietKhau() {
        return GiaTriChietKhau;
    }

    public void setGiaTriChietKhau(int GiaTriChietKhau) {
        this.GiaTriChietKhau = GiaTriChietKhau;
    }

    public Time getThoiGianBatDau() {
        return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(Time ThoiGianBatDau) {
        this.ThoiGianBatDau = ThoiGianBatDau;
    }

    public Time getThoiGianKetThuc() {
        return ThoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Time ThoiGianKetThuc) {
        this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

   
    
}
