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
import model.Customer;
import util.CrudUtil;
import util.ValidationUtil;
import views.tm.CustomerTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class NewCustomerFormController implements Initializable {
    public TextField txtCusID;
    public TextField txtCusName;
    public TextField txtCusAddress;
    public TextField txtCusSalary;
    public TableView<CustomerTM> tblCustomer;
    public JFXButton btnSaveCustomer;
    public TextField txtCusContract;
    public TableColumn colCusId;
    public TableColumn colCusName;
    public TableColumn colCusAddress;
    public TableColumn colCusContract;
    public TableColumn colCusBtn;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initializing table columns with TableTM Properties
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contract"));

        //set edit and delete button from images to the table
        tblCustomer.getColumns().get(4).setCellValueFactory((param) -> {
            ImageView edit = new ImageView("/assert/icons/draw.png");
            ImageView delete = new ImageView("/assert/icons/trash.png");
            return new ReadOnlyObjectWrapper(new HBox(10, edit, delete));
        });


        //set click event for the Save Comment
        btnSaveCustomer.setOnMouseClicked(event -> {
            //Gather information from inputs
            saveCustomer();
        });

        btnSaveCustomer.setDisable(true);

        //add pattern and text to the map
        //Create a pattern and compile it to use
        Pattern idPattern = Pattern.compile("^(C00-)[0-9]{3,5}$");
        Pattern namePattern = Pattern.compile("^[A-z ]{3,15}$");
        Pattern addressPattern = Pattern.compile("^[A-z0-9 ,/]{4,20}$");
        Pattern contractPattern = Pattern.compile("^07(1|2|5|7|8)-[0-9]{7}");

        map.put(txtCusID,idPattern);
        map.put(txtCusName,namePattern);
        map.put(txtCusAddress,addressPattern);
        map.put(txtCusContract,contractPattern);

    }

    private void saveCustomer() {
        String customerID = txtCusID.getText();
        String customerName = txtCusName.getText();
        String customerAddress = txtCusAddress.getText();
        String customerContract = txtCusContract.getText();


        // Add to the Table
        Button btn = new Button("Delete");

        CustomerTM customerTM = new CustomerTM(customerID,customerName,customerAddress,customerContract,btn);
        tblCustomer.getItems().add(customerTM);

        Customer c = new Customer(
                txtCusID.getText(), txtCusName.getText(), txtCusAddress.getText(), txtCusContract.getText()
        );
        try {
            if (CrudUtil.execute("INSERT INTO Customer VALUES (?,?,?,?)", c.getCustomerId(), c.getCustomerName(), c.getCustomerAddress(), c.getCustomerContract())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }


        clearAllTexts();
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        ValidationUtil.validate(map,btnSaveCustomer);
//        TextField = error
//        boolean // validation ok

        //if the enter key pressed
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response =  ValidationUtil.validate(map,btnSaveCustomer);;
            //if the response is a text field
            //that means there is a error
            if (response instanceof TextField) {
                TextField textField = (TextField) response;
                textField.requestFocus();// if there is a error just focus it
            } else if (response instanceof Boolean) {
                System.out.println("Work");
                saveCustomer();
            }
        }
    }

    public void clearAllTexts() {
        txtCusID.clear();
        txtCusName.clear();
        txtCusAddress.clear();
        txtCusContract.clear();
        txtCusID.requestFocus();
        setBorders(txtCusID,txtCusName,txtCusAddress,txtCusContract);
    }

    //reset border colors to default color
    public void setBorders(TextField... textFields){
        for (TextField textField : textFields) {
            textField.getParent().setStyle("-fx-border-color: rgba(76, 73, 73, 0.83)");
        }
    }


}
