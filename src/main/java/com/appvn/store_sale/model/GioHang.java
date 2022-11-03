/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author hoang
 */
public class GioHang {
    private int id;
       private String name;
    private Float dongia;
    private int soluong;
    private Float thanhtien;

    public GioHang() {
    }

    public GioHang(int id, String name, Float dongia, int soluong, Float thanhtien) {
        this.id = id;
        this.name = name;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
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

    public Float getDongia() {
        return dongia;
    }

    public void setDongia(Float dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(Float thanhtien) {
        this.thanhtien = thanhtien;
    }

    
    

    

   

   

    
   
    
}
