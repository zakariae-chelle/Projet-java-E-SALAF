package com.exemple.model;

public class Credit {
    private int id_credit ;

    private int credit_am ;
    private  int id_client;

    public int getCredit_am() {
        return credit_am;
    }

    public void setCredit_am(int credit_am) {
        this.credit_am = credit_am;
    }

    public Credit(int id_credit,int credit_am, int id_client) {
       this.credit_am = credit_am;
       this.id_client = id_client ;
       this.id_credit = id_credit;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_credit() {
        return id_credit;
    }

    public void setId_credit(int id_credit) {
        this.id_credit = id_credit;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id_credit=" + id_credit +
                ", credit_am=" + credit_am +
                '}';
    }
}
