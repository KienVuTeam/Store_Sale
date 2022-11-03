/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author hoang
 */
public class NhomSanPham {

    private int id;
    private String name;
    private String loai;
    private int dongiaban;
    private int tonkho;        
    private int idSp;

    public NhomSanPham() {
    }

    public NhomSanPham(int id, String name, String loai, int dongiaban, int tonkho, int idSp) {
        this.id = id;
        this.name = name;
        this.loai = loai;
        this.dongiaban = dongiaban;
        this.tonkho = tonkho;
        this.idSp = idSp;
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getDongiaban() {
        return dongiaban;
    }

    public void setDongiaban(int dongiaban) {
        this.dongiaban = dongiaban;
    }

    public int getTonkho() {
        return tonkho;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    public int getIdSp() {
        return idSp;
    }

    public void setIdSp(int idSp) {
        this.idSp = idSp;
    }

    

    
}



