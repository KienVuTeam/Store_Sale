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
public class ThongKeNghanhHang {
    private String tensanpham;
    Date ngay;
    private int tongsanpham;

    public ThongKeNghanhHang() {
    }

    public ThongKeNghanhHang(String tensanpham, Date ngay, int tongsanpham) {
        this.tensanpham = tensanpham;
        this.ngay = ngay;
        this.tongsanpham = tongsanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getTongsanpham() {
        return tongsanpham;
    }

    public void setTongsanpham(int tongsanpham) {
        this.tongsanpham = tongsanpham;
    }
    
    
}
