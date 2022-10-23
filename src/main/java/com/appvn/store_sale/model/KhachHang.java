/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author hoang
 */
public class KhachHang {
    private int idKH;
    private String nameKH;
    private int SDT;
    private String DiaChi;

    public KhachHang() {
    }
    

    public KhachHang(int idKH, String nameKH, int SDT, String DiaChi) {
        this.idKH = idKH;
        this.nameKH = nameKH;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getNameKH() {
        return nameKH;
    }

    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
}
