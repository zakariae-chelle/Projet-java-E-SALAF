package com.exemple.model;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProduitDAO extends  BaseDAO<Produit> {
    public ProduitDAO() throws SQLException {

        super();
    }

    /**
     * @param object
     * @throws SQLException
     */


    // mapping objet --> relation
    @Override
    public void save(Produit object) throws SQLException {

        String req = "insert into produit (ProductName , Price,Qte) values (? , ?,?) ;";

        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setString(1 , object.getProductName());
        this.preparedStatement.setInt(2 , object.getPrice());
        this.preparedStatement.setInt(3, Math.toIntExact(object.getQte()));
        this.preparedStatement.execute();

    }

    @Override
    public void update(Produit object) throws SQLException {

        String req = "UPDATE produit SET ProductName = ?, Price = ?,Qte = ? WHERE  id = ?";
        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setString(1 , object.getProductName());
        this.preparedStatement.setInt(2 , object.getPrice());
        this.preparedStatement.setInt(3,object.getQte());
        this.preparedStatement.setInt(4,object.getId());
        this.preparedStatement.execute();
    }

    /**
     * @param object
     * @throws SQLException
     */
    @Override
    public void delete(Produit object) throws SQLException {}





    public void delete(int id) throws SQLException {
        String req = "Delete from produit where id = ?";
        try {
            this.preparedStatement = this.connection.prepareStatement(req);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
}

    }

    @Override
    public Produit getOne(Long id) throws SQLException {
        return null;
    }


    // mapping relation --> objet
    @Override
    public List<Produit> getAll() throws SQLException{

        List<Produit> mylist = new ArrayList<Produit>();
        String req = " select * from produit" ;


        this.statement = this.connection.createStatement();

       this.resultSet =  this.statement.executeQuery(req);

       while (this.resultSet.next()){

           mylist.add( new Produit(this.resultSet.getInt(1) , this.resultSet.getString(2),
                   this.resultSet.getInt(3),this.resultSet.getInt(4)));


       }

        return mylist;
    }

    /**
     * @param url
     * @param resourceBundle
     */



}
