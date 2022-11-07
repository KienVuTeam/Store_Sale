/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author vippr
 */
public class CongNo {
    private String nameKh;
    private String phone;
    private String email;
    private int Congno;
    private String maKH;

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public CongNo(String maKH) {
        this.maKH = maKH;
    }

    public CongNo() {
    }

    public CongNo(String nameKh, String phone, String email, int Congno) {
        this.nameKh = nameKh;
        this.phone = phone;
        this.email = email;
        this.Congno = Congno;
    }

    public String getNameKh() {
        return nameKh;
    }

    public void setNameKh(String nameKh) {
        this.nameKh = nameKh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCongno() {
        return Congno;
    }

    public void setCongno(int Congno) {
        this.Congno = Congno;
    }
    
}
