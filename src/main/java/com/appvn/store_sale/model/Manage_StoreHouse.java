/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

import java.sql.Timestamp;
import javafx.scene.control.Button;

/**
 *
 * @author HP
 */
public class Manage_StoreHouse {

    private String code_storeHouse, name_store, storeHouse_address, type;
    private Timestamp create_at;
    private Button Delete;

    public Manage_StoreHouse() {

    }

    public Manage_StoreHouse(String code_storeHouse, String name_store, String storeHouse_address, String type) {
        this.code_storeHouse = code_storeHouse;
        this.name_store = name_store;
        this.storeHouse_address = storeHouse_address;
        this.type = type;
    }
//

    public Manage_StoreHouse(String code_storeHouse, String name_store, String storeHouse_address, String type, Timestamp create_at) {
        this.code_storeHouse = code_storeHouse;
        this.name_store = name_store;
        this.storeHouse_address = storeHouse_address;
        this.type = type;
        this.create_at = create_at;
    }

    public String getCode_storeHouse() {
        return code_storeHouse;
    }

    public void setCode_storeHouse(String code_storeHouse) {
        this.code_storeHouse = code_storeHouse;
    }

    public String getName_store() {
        return name_store;
    }

    public void setName_store(String name_store) {
        this.name_store = name_store;
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

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }
    //constructor co button

    public Manage_StoreHouse(Button Delete) {
        this.Delete = Delete;
    }
    

    public Button getDelete() {
        return Delete;
    }

    public void setDelete(Button Delete) {
        this.Delete = new Button("Xoa");
    }

    
    

}
