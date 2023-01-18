package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Plant;
import model.Product;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadAllProductFormController {
    public TableView<Product> tblProduct;
    public TableColumn colproductId;
    public TableColumn colproductName;
    public TableColumn colproductDescription;
    public TableColumn colproductType;
    public TableColumn colproductUnitPrice;
    public TableColumn colproductQtyOnHand;

    public void initialize(){
        colproductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colproductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colproductDescription.setCellValueFactory(new PropertyValueFactory<>("productDescription"));
        colproductType.setCellValueFactory(new PropertyValueFactory<>("productType"));
        colproductUnitPrice.setCellValueFactory(new PropertyValueFactory<>("productUnitPrice"));
        colproductQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("productQtyOnHand"));

        try {
            loadAllProduct();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    private void loadAllProduct() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM product");
        ObservableList<Product> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new Product(
                            result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getString(5),
                            result.getString(6)
                    )
            );
        }
        tblProduct.setItems(obList);

    }

}
