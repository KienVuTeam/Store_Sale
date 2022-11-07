/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author vippr
 */
public class CKTM {
    private String name_CKTM;
    private int discount;
    private String start_CKTM;
    private String end_CKTM;
    private String Description;

    public CKTM() {
    }

    public CKTM(String name_CKTM, int discount, String start_CKTM, String end_CKTM, String Description) {
        this.name_CKTM = name_CKTM;
        this.discount = discount;
        this.start_CKTM = start_CKTM;
        this.end_CKTM = end_CKTM;
        this.Description = Description;
    }

    public String getName_CKTM() {
        return name_CKTM;
    }

    public void setName_CKTM(String name_CKTM) {
        this.name_CKTM = name_CKTM;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getStart_CKTM() {
        return start_CKTM;
    }

    public void setStart_CKTM(String start_CKTM) {
        this.start_CKTM = start_CKTM;
    }

    public String getEnd_CKTM() {
        return end_CKTM;
    }

    public void setEnd_CKTM(String end_CKTM) {
        this.end_CKTM = end_CKTM;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
