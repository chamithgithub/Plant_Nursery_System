package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class AdminDashBoardController {


    public Label lblDate;


    public void initialize() {

        loadDate();

    }
    private void loadDate() {
        /*set Date*/
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        /*set Time*/
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();

        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void productsAction(ActionEvent actionEvent) throws IOException {
        setUi("productDashBoardForm");
    }

    public void customerAction(ActionEvent actionEvent) throws IOException {
        setUi("customerDashBoardForm");
    }

    public void plantsAction(ActionEvent actionEvent) throws IOException {
        setUi("plantDashBoardForm");
    }


    public void vehicleAction(ActionEvent actionEvent) throws IOException {
        setUi("VehicleDashBoardForm");
    }

    public void driverAction(ActionEvent actionEvent) throws IOException {
        setUi("DriverDashBoardForm");
    }
    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }

    public AnchorPane adminDashContext;
    public AnchorPane mainContex;
    public void backHomeOnAction(ActionEvent actionEvent) throws IOException {
        adminDashContext.getScene().getWindow().hide();
        setUi("mainLoginForm");
    }
}
