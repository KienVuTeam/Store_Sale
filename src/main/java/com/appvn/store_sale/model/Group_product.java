/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author HP
 */
public class Group_product {
    private String name_groupProduct, describe;

    public Group_product() {
    }

    public Group_product(String name_groupProduct, String describe) {
        this.name_groupProduct = name_groupProduct;
        this.describe = describe;
    }

    public String getName_groupProduct() {
        return name_groupProduct;
    }

    public void setName_groupProduct(String name_groupProduct) {
        this.name_groupProduct = name_groupProduct;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    
    
}
