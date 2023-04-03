package com.example.esalaf;

import com.exemple.model.Client;
import com.exemple.model.ClientDAO;

import com.exemple.model.Command;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField nom;

    @FXML
    private TextField tele;
    @FXML
    private TextField tfid;
    private Stage stage;
    private  Scene scene;
    private  Parent root;



    @FXML
    private TableView<Client> mytab;

    @FXML
    private TableColumn<Client, Long> col_id;

    @FXML
    private TableColumn<Client, String> col_nom;

    @FXML
    private TableColumn<Client, String> col_tele;

    @FXML
    protected void onSaveButtonClick(){
        Client cli = new Client(0l , nom.getText() , tele.getText());
        try {
            ClientDAO clidao = new ClientDAO();
            clidao.save(cli);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        nom.setText("");
        tele.setText("");
        tfid.setText("");
        UpdateTable();
    }





    @FXML
    void supprimerClient(MouseEvent event) throws SQLException {
        ClientDAO liv=new ClientDAO();
        Client li =mytab.getSelectionModel().getSelectedItem();
        int id_client = Integer.parseInt(tfid.getText());
        liv.delete(id_client);
        tfid.setText("");
        nom.setText("");
        tele.setText("");
        tfid.setText("");
        UpdateTable();
    }
     @FXML
    protected void onUpdatebtnclick(){
        long id_client = Integer.parseInt(tfid.getText());
        Client cli = new Client( id_client , nom.getText() , tele.getText());
        try {
            ClientDAO clidao = new ClientDAO();
            clidao.update(cli);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        nom.setText("");
        tele.setText("");
        tfid.setText("");
        UpdateTable();
    }
    @FXML
    void getData(MouseEvent event) {
        Client product = mytab.getSelectionModel().getSelectedItem();
        tfid.setText(String.valueOf(product.getId_client()));
        nom.setText(product.getNom());
        tele.setText(product.getTelepehone());


    }

    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Client,Long>("id_client"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
        col_tele.setCellValueFactory(new PropertyValueFactory<Client,String>("telepehone"));
        mytab.setItems(getDataClients());

    }

    public static ObservableList<Client> getDataClients(){

        ClientDAO clidao = null;

        ObservableList<Client> listfx = FXCollections.observableArrayList();

        try {
            clidao = new ClientDAO();
            for(Client ettemp : clidao.getAll())
                listfx.add(ettemp);

       } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }
    public void credit(Event mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("credit-view.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void todash(Event mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();
    }


}














