/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author HP
 */
public class Product {
    private String nameP, unit;
    private float wholesale_price, retail_price, profit, inventory_quantity;

    public Product() {
    }

    public Product(String nameP, String unit, float wholesale_price, float retail_price, float profit, float inventory_quantity) {
        this.nameP = nameP;
        this.unit = unit;
        this.wholesale_price = wholesale_price;
        this.retail_price = retail_price;
        this.profit = profit;
        this.inventory_quantity = inventory_quantity;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getWholesale_price() {
        return wholesale_price;
    }

    public void setWholesale_price(float wholesale_price) {
        this.wholesale_price = wholesale_price;
    }

    public float getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(float retail_price) {
        this.retail_price = retail_price;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public float getInventory_quantity() {
        return inventory_quantity;
    }

    public void setInventory_quantity(float inventory_quantity) {
        this.inventory_quantity = inventory_quantity;
    }
    
    
}
