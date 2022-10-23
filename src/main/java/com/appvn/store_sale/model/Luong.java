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
public class Luong {

    private int idL;
    private int idNV;
    Date thang;
    private int LuongCuoiThang;

    public Luong(int idL, int idNV, Date thang, int LuongCuoiThang) {
        this.idL = idL;
        this.idNV = idNV;
        this.thang = thang;
        this.LuongCuoiThang = LuongCuoiThang;
    }

    public int getIdL() {
        return idL;
    }

    public void setIdL(int idL) {
        this.idL = idL;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public Date getThang() {
        return thang;
    }

    public void setThang(Date thang) {
        this.thang = thang;
    }

    public int getLuongCuoiThang() {
        return LuongCuoiThang;
    }

    public void setLuongCuoiThang(int LuongCuoiThang) {
        this.LuongCuoiThang = LuongCuoiThang;
    }
    
}
