package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Plant;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadAllPlantFormController {
    public TableView<Plant> tblPlant;
    public TableColumn colplantId;
    public TableColumn colplantDescription;
    public TableColumn colplantName;
    public TableColumn colplantType;
    public TableColumn colplantUnitPrice;
    public TableColumn colplantQtyOnHand;

    public void initialize(){
        colplantId.setCellValueFactory(new PropertyValueFactory<>("plantId"));
        colplantName.setCellValueFactory(new PropertyValueFactory<>("plantName"));
        colplantDescription.setCellValueFactory(new PropertyValueFactory<>("plantDescription"));
        colplantType.setCellValueFactory(new PropertyValueFactory<>("plantType"));
        colplantUnitPrice.setCellValueFactory(new PropertyValueFactory<>("plantUnitPrice"));
        colplantQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("plantQtyOnHand"));

        try {
            loadAllPlants();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    private void loadAllPlants() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM plant");
        ObservableList<Plant> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                   new Plant(
                           result.getString(1),
                           result.getString(2),
                           result.getString(3),
                           result.getString(4),
                           result.getString(5),
                           result.getString(6)
                   )
            );
        }
        tblPlant.setItems(obList);

    }

}
