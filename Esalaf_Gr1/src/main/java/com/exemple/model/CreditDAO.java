package com.exemple.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditDAO extends  BaseDAO<Credit>  {


    public CreditDAO() throws SQLException {
        super();
    }

    /**
     * @param object
     * @throws SQLException
     */
    @Override
    public void save(Credit object) throws SQLException {
        String req = "insert into credit (credit_am , id_client) values (?,?) ;";

        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setInt(2 , object.getCredit_am());
        this.preparedStatement.setInt(3, object.getId_client());
        this.preparedStatement.execute();
    }

    /**
     * @param object
     * @throws SQLException
     */
    @Override
    public void update(Credit object) throws SQLException {

    }

    /**
     * @param object
     * @throws SQLException
     */
    @Override
    public void delete(Credit object) throws SQLException {

    }



    /**
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Credit getOne(Long id) throws SQLException {
        return null;
    }

    public List<Credit> getAll() throws SQLException {

        List<Credit> mylist = new ArrayList<Credit>();
        String req = " select * from crediit" ;


        this.statement = this.connection.createStatement();

        this.resultSet =  this.statement.executeQuery(req);

        while (this.resultSet.next()){

            int id_credit;
            mylist.add( new Credit(this.resultSet.getInt(1), this.resultSet.getInt(2),this.resultSet.getInt(3)));


        }

        return mylist;
    }

    /**
     * @param url
     * @param resourceBundle
     */

}
