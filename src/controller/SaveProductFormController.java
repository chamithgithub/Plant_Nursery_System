package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Product;
import util.CrudUtil;
import java.sql.SQLException;

public class SaveProductFormController {

    public TextField txtName;
    public TextField txtId;
    public TextField txtType;
    public TextField txtDesc;
    public TextField txtUnitPrice;
    public TextField txtQty;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Product product = new Product(
                txtId.getText(), txtName.getText(), txtType.getText(), txtDesc.getText(),txtUnitPrice.getText(), txtQty.getText()
        );


        try {
            if (CrudUtil.execute("INSERT INTO Product VALUES (?,?,?,?,?,?)",
                    product.getProductId(), product.getProductName(), product.getProductType(), product.getProductDescription() ,
                    product.getProductUnitPrice() , product.getProductQtyOnHand()))
            {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }
    }
}
