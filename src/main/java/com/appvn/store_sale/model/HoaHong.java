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
    private int nhómpid;
    int chietkhauthuongmaiid;

    public HoaHong(int id, int idnhanvien, int nhómpid, int chietkhauthuongmaiid) {
        this.id = id;
        this.idnhanvien = idnhanvien;
        this.nhómpid = nhómpid;
        this.chietkhauthuongmaiid = chietkhauthuongmaiid;
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

    public int getNhómpid() {
        return nhómpid;
    }

    public void setNhómpid(int nhómpid) {
        this.nhómpid = nhómpid;
    }

    public int getChietkhauthuongmaiid() {
        return chietkhauthuongmaiid;
    }

    public void setChietkhauthuongmaiid(int chietkhauthuongmaiid) {
        this.chietkhauthuongmaiid = chietkhauthuongmaiid;
    }
    
}
