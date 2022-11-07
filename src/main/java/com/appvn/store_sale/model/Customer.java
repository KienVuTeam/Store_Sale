/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author vippr
 */
public class Customer {
    private String idKH;
    private String nameKH;
    private String SDT;
    private String email;
    private String DiaChi;

    public Customer() {
    }

    public Customer(String  idKH, String nameKH, String SDT, String email, String DiaChi) {
        this.idKH = idKH;
        this.nameKH = nameKH;
        this.SDT = SDT;
        this.email = email;
        this.DiaChi = DiaChi;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String  idKH) {
        this.idKH = idKH;
    }

    public String getNameKH() {
        return nameKH;
    }

    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
}
