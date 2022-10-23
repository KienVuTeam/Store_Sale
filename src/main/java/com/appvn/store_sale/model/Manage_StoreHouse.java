/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Manage_StoreHouse {
    private String storeHouse_address;
    private String type;
    private Date date;

    public Manage_StoreHouse() {
        
    }

    public Manage_StoreHouse(String storeHouse_address, String type, Date date) {
        this.storeHouse_address = storeHouse_address;
        this.type = type;
        this.date = date;
    }

    public String getStoreHouse_address() {
        return storeHouse_address;
    }

    public void setStoreHouse_address(String storeHouse_address) {
        this.storeHouse_address = storeHouse_address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

}