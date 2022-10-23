/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author hoang
 */
public class CongNo {
    private int id;
    private String name;
    private String nameKH;
    private int SDT;
    private String Address;

    public CongNo(int id, String name, String nameKH, int SDT, String Address) {
        this.id = id;
        this.name = name;
        this.nameKH = nameKH;
        this.SDT = SDT;
        this.Address = Address;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    
}
