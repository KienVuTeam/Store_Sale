/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.appvn.store_sale.dao_storeHouse;

import javafx.collections.ObservableList;

/**
 *
 * @author HP
 */
public interface StoreHouse_Interface<T> {
    public void add(T t);
    public void delete(String temp);
    public void update(T t);
    public ObservableList<T> selectAll();
}
