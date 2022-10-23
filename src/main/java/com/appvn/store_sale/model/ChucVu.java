/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author hoang
 */
public class ChucVu {
    private int id;
    private int nhanvienid;
    private String name;
    private String GhiChu;

    public ChucVu(int id, int nhanvienid, String name, String GhiChu) {
        this.id = id;
        this.nhanvienid = nhanvienid;
        this.name = name;
        this.GhiChu = GhiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNhanvienid() {
        return nhanvienid;
    }

    public void setNhanvienid(int nhanvienid) {
        this.nhanvienid = nhanvienid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    
    
}
