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
    private int id;
    int idnhanvien;
    private int laphoadonid;
    private int tiennhanduoc;

    public HoaHong() {
    }

    public HoaHong(int id, int idnhanvien, int laphoadonid, int tiennhanduoc) {
        this.id = id;
        this.idnhanvien = idnhanvien;
        this.laphoadonid = laphoadonid;
        this.tiennhanduoc = tiennhanduoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public int getLaphoadonid() {
        return laphoadonid;
    }

    public void setLaphoadonid(int laphoadonid) {
        this.laphoadonid = laphoadonid;
    }

    public int getTiennhanduoc() {
        return tiennhanduoc;
    }

    public void setTiennhanduoc(int tiennhanduoc) {
        this.tiennhanduoc = tiennhanduoc;
    }

    

   
}
