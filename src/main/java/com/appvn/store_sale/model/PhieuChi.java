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
public class PhieuChi {
    private int id;
    private String name;
    private int khachhangid;
    private String diachi;
    private int SoTien;

    public PhieuChi(int id, String name, int khachhangid, String diachi, int SoTien) {
        this.id = id;
        this.name = name;
        this.khachhangid = khachhangid;
        this.diachi = diachi;
        this.SoTien = SoTien;
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

    public int getKhachhangid() {
        return khachhangid;
    }

    public void setKhachhangid(int khachhangid) {
        this.khachhangid = khachhangid;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getSoTien() {
        return SoTien;
    }

    public void setSoTien(int SoTien) {
        this.SoTien = SoTien;
    }
    
}
