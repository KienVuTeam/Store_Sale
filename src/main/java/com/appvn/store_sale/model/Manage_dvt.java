/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author HP
 */
public class Manage_dvt {
    private String id_unit, unit_name;

    public Manage_dvt(String id_unit, String unit_name) {
        this.id_unit = id_unit;
        this.unit_name = unit_name;
    }

    public Manage_dvt() {
        
    }

    public String getId_unit() {
        return id_unit;
    }

    public void setId_unit(String id_unit) {
        this.id_unit = id_unit;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }
    //page2
    private String unitname_exchange2, unit_namep2;
    private Float unit_value2;

    //constructor 1 tham so

    /**
     *
     * @param id_unit
     */

    public Manage_dvt(String id_unit) {
        this.id_unit = id_unit;
    }
    
//   temp2
    private String nameunit_temp;
    
//    public Manage_dvt(String nameunit_temp){
//        this.nameunit_temp = nameunit_temp;
//    }
    
    
    
    
    public Manage_dvt(String unitname_exchange2, String unit_namep2, Float unit_value2) {
        this.unitname_exchange2 = unitname_exchange2;
        this.unit_namep2 = unit_namep2;
        this.unit_value2 = unit_value2;
    }

    public String getUnitname_exchange2() {
        return unitname_exchange2;
    }

    public void setUnitname_exchange2(String unitname_exchange2) {
        this.unitname_exchange2 = unitname_exchange2;
    }

    public String getUnit_namep2() {
        return unit_namep2;
    }

    public void setUnit_namep2(String unit_namep2) {
        this.unit_namep2 = unit_namep2;
    }

    public Float getUnit_value2() {
        return unit_value2;
    }

    public void setUnit_value2(Float unit_value2) {
        this.unit_value2 = unit_value2;
    }
    
    
    
    
    
}
