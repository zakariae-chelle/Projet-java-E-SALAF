package com.example.esalaf;

import com.exemple.model.*;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProductView implements Initializable {
    private Stage stage;
    private  Scene scene;
    private  Parent root;
    @FXML
    private TextField nom_prod;
    @FXML
    private TextField price_pod;
    @FXML
    private TextField qte_prd;
    @FXML
    private TextField tfid;
    @FXML
    private TableView<Produit> mytab;

    @FXML
    private TableColumn<Produit, Integer> col_id;

    @FXML
    private TableColumn<Produit, String > col_nom;

    @FXML
    private TableColumn<Produit, Integer> Col_prix;
    @FXML
    private TableColumn<Produit, Integer> Col_qte;
    @FXML
    protected void onSaveButtonClick(){
       int price = Integer.parseInt(price_pod.getText());
       int qte = Integer.parseInt(qte_prd.getText());
        Produit prod = new Produit(0 , nom_prod.getText() ,price ,qte);
        try {
            ProduitDAO prodDAO= new ProduitDAO();
            prodDAO.save(prod);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        price_pod.setText("");
        qte_prd.setText("");
        nom_prod.setText("");
        UpdateTable();
    }
    @FXML
    protected void onUpdatebtnclick(){
        int price = Integer.parseInt(price_pod.getText());
        int qte = Integer.parseInt(qte_prd.getText());
        int id_prod = Integer.parseInt(tfid.getText());
        Produit prod = new Produit(id_prod , nom_prod.getText() ,price ,qte);
        try {
            ProduitDAO prodDAO= new ProduitDAO();
            prodDAO.update(prod);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        price_pod.setText("");
        qte_prd.setText("");
        nom_prod.setText("");
        tfid.setText("");
        UpdateTable();
    }
    @FXML
    void deletprod(MouseEvent event) throws SQLException {
        ProduitDAO prod=new ProduitDAO();
        Produit li =mytab.getSelectionModel().getSelectedItem();
        int id_prod = Integer.parseInt(tfid.getText());
        prod.delete(id_prod);
        tfid.setText("");
        price_pod.setText("");
        qte_prd.setText("");
        nom_prod.setText("");
        tfid.setText("");
        UpdateTable();
    }
    @FXML
    void getData(MouseEvent event) {
        Produit product = mytab.getSelectionModel().getSelectedItem();
        tfid.setText(String.valueOf(product.getId()));
        nom_prod.setText(product.getProductName());
        qte_prd.setText(String.valueOf(product.getQte()));
        price_pod.setText(String.valueOf(product.getPrice()));


    }






    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Produit,String>("ProductName"));
        Col_prix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("Price"));
        Col_qte.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("Qte"));
        mytab.setItems((ObservableList<Produit>) getDataProduct());

    }

    private Object getDataProduct() {
        ProduitDAO prodDAo = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            prodDAo = new ProduitDAO();
            for(Produit ettemp : prodDAo.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }

    public void todash(Event event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UpdateTable();
    }
}
