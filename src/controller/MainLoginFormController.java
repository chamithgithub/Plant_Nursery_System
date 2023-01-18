package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class MainLoginFormController {
    public Label lblDate;
    public AnchorPane mainContex;


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

    public void adminLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("adminLoginForm");
    }

    public void customerRegOnAction(ActionEvent actionEvent) throws IOException {
      //setUi("SaveCustomerForm");
        setUi("NewCustomerForm");
    }


    public void plantOnAction(ActionEvent actionEvent) throws IOException {
       // setUi("plantsViewForm");
        setUi("loadAllPlantForm");
    }

    public void productOnAction(ActionEvent actionEvent) throws IOException {
       // setUi("productViewForm");
        setUi("loadAllProductForm");
    }

    public void placeOrderOnAction(ActionEvent actionEvent) throws IOException {
        setUi("placeOrderForm");
    }
    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }

    public void customerRegValidOnAction(ActionEvent actionEvent) throws IOException {
        setUi("NewCustomerForm");
    }
}
