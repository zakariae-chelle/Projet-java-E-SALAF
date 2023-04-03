package com.exemple.model;

public class Produit {
    private int id;
    private String ProductName;
    private int Price;


    public Produit(int id, String productName, int price, int qte) {
        this.id = id;
        ProductName = productName;
        Price = price;
        Qte = qte;
    }

    public int getPrice() {
        return Price;
    }

    public int getQte() {
        return Qte;
    }
    public void setQte(int qte) {
        Qte = qte;
    }

    private int Qte;
    public void setPrice(int price) {
        Price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }




}
