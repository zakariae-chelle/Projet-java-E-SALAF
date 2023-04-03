package com.exemple.model;

import java.sql.Date;

public class Command {
    private int id_command;
    private int Qte;
    private  String Nom_client;
    private  String Nom_prod;
    private Date Date_command;



    private  int prix;

    public Command(int id_command, String Nom_client, String Nom_prod, int Qte , int prix, Date Date_command) {
        this.id_command = id_command;
        this.Qte = Qte;
        this.Nom_client = Nom_client;
        this.Nom_prod = Nom_prod;
        this.prix = prix;
        this.Date_command = Date_command;

    }
    public Date getDate_command() {
        return Date_command;
    }

    public void setDate_command(Date Date_command) {
        Date_command = Date_command;
    }


    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getId_command() {
        return id_command;
    }

    public void setId_command(int id_command) {
        this.id_command = id_command;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int qte) {
        Qte = Qte;
    }

    public String getNom_client() {
        return Nom_client;
    }

    public void setNom_client(String nom_client) {
        Nom_client = Nom_client;
    }

    public String getNom_prod() {
        return Nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        Nom_prod = Nom_prod;
    }
}
