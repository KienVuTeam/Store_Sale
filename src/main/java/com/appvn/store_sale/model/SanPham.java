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
    private Float giabansi,giabanle,chietsuat;
    private int tonkho;
    private String donvi;

    public SanPham() {
    }

    public SanPham(int id, String name, Float giabansi, Float giabanle, Float chietsuat, int tonkho, String donvi) {
        this.id = id;
        this.name = name;
        this.giabansi = giabansi;
        this.giabanle = giabanle;
        this.chietsuat = chietsuat;
        this.tonkho = tonkho;
        this.donvi = donvi;
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

    public Float getGiabansi() {
        return giabansi;
    }

    public void setGiabansi(Float giabansi) {
        this.giabansi = giabansi;
    }

    public Float getGiabanle() {
        return giabanle;
    }

    public void setGiabanle(Float giabanle) {
        this.giabanle = giabanle;
    }

    public Float getChietsuat() {
        return chietsuat;
    }

    public void setChietsuat(Float chietsuat) {
        this.chietsuat = chietsuat;
    }

    public int getTonkho() {
        return tonkho;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }


}
