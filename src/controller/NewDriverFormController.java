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
import model.Driver;
import util.CrudUtil;
import util.ValidationUtil;
import views.tm.CustomerTM;
import views.tm.DriverTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class NewDriverFormController implements Initializable {
    public TextField txtDrId;
    public TextField txtDrName;
    public TextField txtDrLicence;
    public TextField txtDrContract;
    public TableView<DriverTM> tblDriver;
    public TableColumn colCusId;
    public TableColumn colCusName;
    public TableColumn colCusAddress;
    public TableColumn colCusContract;
    public TableColumn colCusBtn;
    public JFXButton btnSaveDriver;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initializing table columns with TableTM Properties
        tblDriver.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("driverId"));
        tblDriver.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("driverName"));
        tblDriver.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("driverLicenceId"));
        tblDriver.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("driverContract"));

        //set edit and delete button from images to the table
        tblDriver.getColumns().get(4).setCellValueFactory((param) -> {
            ImageView edit = new ImageView("/assert/icons/draw.png");
            ImageView delete = new ImageView("/assert/icons/trash.png");
            return new ReadOnlyObjectWrapper(new HBox(10, edit, delete));
        });


        //set click event for the Save Comment
        btnSaveDriver.setOnMouseClicked(event -> {
            //Gather information from inputs
            saveDriver();
        });

        btnSaveDriver.setDisable(true);

        //add pattern and text to the map
        //Create a pattern and compile it to use
        Pattern idPattern = Pattern.compile("^(Dr0-)[0-9]{3,5}$");
        Pattern namePattern = Pattern.compile("^[A-z ]{3,15}$");
        Pattern addressPattern = Pattern.compile("^[A-z0-9 ,/]{4,20}$");
        Pattern contractPattern = Pattern.compile("^07(1|2|5|7|8)-[0-9]{7}");

        map.put(txtDrId,idPattern);
        map.put(txtDrName,namePattern);
        map.put(txtDrLicence,addressPattern);
        map.put(txtDrContract,contractPattern);

    }

    private void saveDriver() {
        String driverId = txtDrId.getText();
        String driverName = txtDrName.getText();
        String driverLicenceId = txtDrLicence.getText();
        String driverContract = txtDrContract.getText();


        // Add to the Table
        Button btn = new Button("Delete");

        DriverTM driverTM = new DriverTM(driverId,driverName,driverLicenceId,driverContract,btn);
        tblDriver.getItems().add(driverTM);

        Driver driver =new Driver(
                txtDrId.getText(), txtDrName.getText(), txtDrLicence.getText(), txtDrContract.getText()
        );
        try {
            if (CrudUtil.execute("INSERT INTO Driver VALUES (?,?,?,?)", driver.getDriverId(), driver.getDriverName(), driver.getDriverLicenceId(), driver.getDriverContract())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }


        clearAllTexts();
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        ValidationUtil.validate(map,btnSaveDriver);
//        TextField = error
//        boolean // validation ok

        //if the enter key pressed
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response =  ValidationUtil.validate(map,btnSaveDriver);;
            //if the response is a text field
            //that means there is a error
            if (response instanceof TextField) {
                TextField textField = (TextField) response;
                textField.requestFocus();// if there is a error just focus it
            } else if (response instanceof Boolean) {
                System.out.println("Work");
                saveDriver();
            }
        }
    }

    public void clearAllTexts() {
        txtDrId.clear();
        txtDrName.clear();
        txtDrLicence.clear();
        txtDrContract.clear();
        txtDrId.requestFocus();
        setBorders(txtDrId,txtDrName,txtDrLicence,txtDrContract);
    }

    //reset border colors to default color
    public void setBorders(TextField... textFields){
        for (TextField textField : textFields) {
            textField.getParent().setStyle("-fx-border-color: rgba(76, 73, 73, 0.83)");
        }
    }


}
