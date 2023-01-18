package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Driver;
import model.Plant;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadAllDriverFormController {
    public TableView<Driver> tblDriver;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colLicence;
    public TableColumn colContract;
    public TableColumn colDriverName;
    public TableColumn colDriverId;
    public TableColumn colDriverLicence;
    public TableColumn colDriverContract;

    public void initialize(){
        colDriverId.setCellValueFactory(new PropertyValueFactory<>("driverId"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colDriverLicence.setCellValueFactory(new PropertyValueFactory<>("driverLicenceId"));
        colDriverContract.setCellValueFactory(new PropertyValueFactory<>("driverContract"));


        try {
            loadAllDriver();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    private void loadAllDriver() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM driver");
        ObservableList<Driver> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new Driver(
                            result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4)

                    )
            );
        }
        tblDriver.setItems(obList);

    }
}
