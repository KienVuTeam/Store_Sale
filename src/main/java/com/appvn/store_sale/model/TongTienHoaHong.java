/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author hoang
 */
public class TongTienHoaHong {
    private int idnhanvien,tongtienhoahong;

    public TongTienHoaHong() {
    }

    public TongTienHoaHong(int idnhanvien, int tongtienhoahong) {
        this.idnhanvien = idnhanvien;
        this.tongtienhoahong = tongtienhoahong;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public int getTongtienhoahong() {
        return tongtienhoahong;
    }

    public void setTongtienhoahong(int tongtienhoahong) {
        this.tongtienhoahong = tongtienhoahong;
    }

   
}
