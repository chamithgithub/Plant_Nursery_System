package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Item;
import util.CrudUtil;

import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemCrudController {

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
