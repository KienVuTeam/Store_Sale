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
public class Account_loginSystem {

    private String code_account, username, password, roles, fullname, address, email, cccd, phone_number, image_user;
    private Date Birthday;
    private Boolean gender;

    public Account_loginSystem() {
    }

    public Account_loginSystem(String code_account, String username, String password, String roles, String fullname, String address, String email, String cccd, String phone_number, String image_user, Date Birthday, Boolean gender) {
        this.code_account = code_account;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.cccd = cccd;
        this.phone_number = phone_number;
        this.image_user = image_user;
        this.Birthday = Birthday;
        this.gender = gender;
    }

    public String getCode_account() {
        return code_account;
    }

    public void setCode_account(String code_account) {
        this.code_account = code_account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getImage_user() {
        return image_user;
    }

    public void setImage_user(String image_user) {
        this.image_user = image_user;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
//    //constructor 

    public Account_loginSystem(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    
     
    
}
