/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appvn.store_sale.model;

/**
 *
 * @author vippr
 */
public class HoaDon {
    private int idhd;
    private int idNV;
    private String idKH;
    private String idSP;
    private String nameKH;
    private String nameNV;
    private String tensp;
    private int giaban;
    private int soluong;
    private int tongtien;
    private String ngaytao;
    private int tonkho;
    private String trangthai;

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getTonkho() {
        return tonkho;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    public HoaDon(int tonkho) {
        this.tonkho = tonkho;
    }

    public String getNameNV() {
        return nameNV;
    }

    public void setNameNV(String nameNV) {
        this.nameNV = nameNV;
    }

    public HoaDon(String nameNV) {
        this.nameNV = nameNV;
    }

    public HoaDon() {
    }

    public HoaDon(int idhd, int idNV, String idKH, String idSP, String nameKH, String tensp, int giaban, int soluong, int tongtien, String ngaytao) {
        this.idhd = idhd;
        this.idNV = idNV;
        this.idKH = idKH;
        this.idSP = idSP;
        this.nameKH = nameKH;
        this.tensp = tensp;
        this.giaban = giaban;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.ngaytao = ngaytao;
    }

    public int getIdhd() {
        return idhd;
    }

    public void setIdhd(int idhd) {
        this.idhd = idhd;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getNameKH() {
        return nameKH;
    }

    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }
    
}
