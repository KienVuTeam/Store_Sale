/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author hoang
 */
public class TienHoaHong {
    private int ID_HD,maNV,hoahong;

    public TienHoaHong() {
    }

    public TienHoaHong(int ID_HD, int maNV, int hoahong) {
        this.ID_HD = ID_HD;
        this.maNV = maNV;
        this.hoahong = hoahong;
    }

    public int getID_HD() {
        return ID_HD;
    }

    public void setID_HD(int ID_HD) {
        this.ID_HD = ID_HD;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getHoahong() {
        return hoahong;
    }

    public void setHoahong(int hoahong) {
        this.hoahong = hoahong;
    }
    
}
