package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;
import util.CrudUtil;

import java.io.IOException;
import java.sql.*;

public class LoadAllCustomersFormController {

    public TableView tblCustomers;

    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContract;

    public void initialize(){

        colId.setCellValueFactory(new PropertyValueFactory("customerId"));
        colName.setCellValueFactory(new PropertyValueFactory("customerName"));
        colAddress.setCellValueFactory(new PropertyValueFactory("customerAddress"));
        colContract.setCellValueFactory(new PropertyValueFactory("customerContract"));

        try {
            loadAllCustomers();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadAllCustomers() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM customer");
        ObservableList<Customer> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new Customer(
                            result.getString("id"),
                            result.getString("name"),
                            result.getString("address"),
                            result.getString("contract")
                    )
            );
        }
        tblCustomers.setItems(obList);

    }




    public void customerRegOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SaveCustomerForm");
    }


    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }
}
