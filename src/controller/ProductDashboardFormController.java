package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductDashboardFormController {

    public void loadAllProductOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoadAllProductForm");
    }

    public void searchProductOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SearchProductForm");
    }

    public void deleteProductOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DeleteProductForm");
    }

    public void updateProductOnAction(ActionEvent actionEvent) throws IOException {
        setUi("UpdateProductForm");
    }

    public void saveProductOnAction(ActionEvent actionEvent) throws IOException {
        setUi("NewProductForm");
    }

    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }

}
