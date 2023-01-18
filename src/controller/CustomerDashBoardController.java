package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerDashBoardController {

    public void loadAllCustomersOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoadAllCustomersForm");
    }

    public void searchCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SearchCustomerForm");
    }

    public void deleteCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DeleteCustomerForm");
    }

    public void updateCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("UpdateCustomerForm");
    }

    public void saveCustomerOnAction(ActionEvent actionEvent) throws IOException {

        setUi("NewCustomerForm");
    }

    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }

}
