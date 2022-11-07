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
public class ThongKeKhachHang {
    private String nameKH;
    Date ngaymuahang;
    private int tonghoadonmuahang;

    public ThongKeKhachHang() {
    }

    public ThongKeKhachHang(String nameKH, Date ngaymuahang, int tonghoadonmuahang) {
        this.nameKH = nameKH;
        this.ngaymuahang = ngaymuahang;
        this.tonghoadonmuahang = tonghoadonmuahang;
    }

    public String getNameKH() {
        return nameKH;
    }

    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }

    public Date getNgaymuahang() {
        return ngaymuahang;
    }

    public void setNgaymuahang(Date ngaymuahang) {
        this.ngaymuahang = ngaymuahang;
    }

    public int getTonghoadonmuahang() {
        return tonghoadonmuahang;
    }

    public void setTonghoadonmuahang(int tonghoadonmuahang) {
        this.tonghoadonmuahang = tonghoadonmuahang;
    }

   


  
    
}
