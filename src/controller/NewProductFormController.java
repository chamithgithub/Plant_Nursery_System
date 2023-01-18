package controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import model.Product;
import util.CrudUtil;
import util.ValidationUtil;
import views.tm.ProductTM;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class NewProductFormController implements Initializable {
    public TextField txtPrId;
    public TextField txtPrName;
    public TextField txtPrType;
    public TextField txtPrDescription;
    public TextField txtPrUnitPrice;
    public TextField txtPrOtyOnHand;
    public TableView<ProductTM> tblProduct;
    public TableColumn colPrId;
    public TableColumn colPrName;
    public TableColumn colPrType;
    public TableColumn colPrDesc;
    public TableColumn colPrUnitPrice;
    public TableColumn colQtyOnHand;
    public TableColumn colPrBtn;
    public JFXButton btnAddProduct;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initializing table columns with TableTM Properties
        tblProduct.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("productId"));
        tblProduct.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("productName"));
        tblProduct.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("productType"));
        tblProduct.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("productDescription"));
        tblProduct.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("productUnitPrice"));
        tblProduct.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("productQtyOnHand"));

        //set edit and delete button from images to the table
        tblProduct.getColumns().get(6).setCellValueFactory((param) -> {
            ImageView edit = new ImageView("/assert/icons/draw.png");
            ImageView delete = new ImageView("/assert/icons/trash.png");
            return new ReadOnlyObjectWrapper(new HBox(10, edit, delete));
        });

        //set click event for the Save Comment
        btnAddProduct.setOnMouseClicked(event -> {
            //Gather information from inputs
            savePlant();
        });

        btnAddProduct.setDisable(true);

        //add pattern and text to the map
        //Create a pattern and compile it to use

        Pattern idPattern = Pattern.compile("^(Pr0-)[0-9]{3,5}$");
        Pattern namePattern = Pattern.compile("^[A-z ]{3,15}$");
        Pattern typePattern = Pattern.compile("^[A-z0-9 ,/]{4,20}$");
        Pattern descPattern = Pattern.compile("^[A-z0-9 ,/]{4,20}$");
        Pattern pricePattern = Pattern.compile("^[1-9][0-9]*(.[0-9]{2})?$");
        Pattern qtyOnPattern = Pattern.compile("^[0-9]{1,6}");

        map.put(txtPrId,idPattern);
        map.put(txtPrName,namePattern);
        map.put(txtPrType,typePattern);
        map.put(txtPrDescription,descPattern);
        map.put(txtPrUnitPrice,pricePattern);
        map.put(txtPrOtyOnHand,qtyOnPattern);

    }
    private void savePlant() {
        String productId = txtPrId.getText();
        String productName = txtPrName.getText();
        String productType = txtPrType.getText();
        String productDescription = txtPrDescription.getText();
        String productUnitPrice = txtPrUnitPrice.getText();
        String productQtyOnHand = txtPrOtyOnHand.getText();

        // Add to the Table
        Button btn = new Button("Delete");

        ProductTM productTM = new ProductTM(productId,productName,productType,productDescription,productUnitPrice,productQtyOnHand,btn);
        tblProduct.getItems().add(productTM);

        Product product = new Product(
                txtPrId.getText(),txtPrName.getText(),txtPrType.getText(),txtPrDescription.getText(),txtPrUnitPrice.getText(),txtPrOtyOnHand.getText()
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

        clearAllTexts();

    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        ValidationUtil.validate(map,btnAddProduct);
//        TextField = error
//        boolean // validation ok

        //if the enter key pressed
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response =  ValidationUtil.validate(map,btnAddProduct);;
            //if the response is a text field
            //that means there is a error
            if (response instanceof TextField) {
                TextField textField = (TextField) response;
                textField.requestFocus();// if there is a error just focus it
            } else if (response instanceof Boolean) {
                System.out.println("Work");
                savePlant();
            }
        }
    }

    public void clearAllTexts() {
        txtPrId.clear();
        txtPrName.clear();
        txtPrType.clear();
        txtPrDescription.clear();
        txtPrUnitPrice.clear();
        txtPrOtyOnHand.clear();
        txtPrId.requestFocus();
        setBorders(txtPrId,txtPrName,txtPrType,txtPrDescription,txtPrUnitPrice,txtPrOtyOnHand);
    }

    //reset border colors to default color
    public void setBorders(TextField... textFields){
        for (TextField textField : textFields) {
            textField.getParent().setStyle("-fx-border-color: rgba(76, 73, 73, 0.83)");
        }
    }

}
