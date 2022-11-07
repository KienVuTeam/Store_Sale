/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author hoang
 */
public class HoaHong {

    private int maNV;
    private int ID_HD;
    private int tongtien;
    

    public HoaHong() {
    }

    public HoaHong(int maNV, int ID_HD, int tongtien) {
        this.maNV = maNV;
        this.ID_HD = ID_HD;
        this.tongtien = tongtien;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getID_HD() {
        return ID_HD;
    }

    public void setID_HD(int ID_HD) {
        this.ID_HD = ID_HD;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    
   
}
