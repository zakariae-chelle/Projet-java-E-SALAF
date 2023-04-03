package com.exemple.model;


// java beans (Entity)
public class Client {

        private Long id_client ;

        private String nom ;
    private String telepehone ;

    public Client(Long id_client, String nom, String telepehone) {
        this.id_client = id_client;
        this.nom = nom;
        this.telepehone = telepehone;
    }




    public long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelepehone() {
        return telepehone;
    }



    public void setTelepehone(String telepehone) {
        this.telepehone = telepehone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", nom='" + nom + '\'' +
                ", telepehone='" + telepehone + '\'' +
                '}';
    }
}
