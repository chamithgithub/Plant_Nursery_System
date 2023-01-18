package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LoginFormController {

    public AnchorPane loginFormContext;
    public TextField txtName;
    public TextField pwdPassword;
    public Button LoginBtn;
    public Button cancelBtn;
    int attemptsLogAdmin = 0;
    public AnchorPane adminDashContext;
    public AnchorPane mainContex;



    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        //setUi("adminDashBordForm");
       // CloseWindow("mainLoginForm");

        Stage window = (Stage) loginFormContext.getScene().getWindow();
        window.close();

        attemptsLogAdmin++;
        if (attemptsLogAdmin < 5) {

            if (txtName.getText().equals("") & pwdPassword.getText().equals("")) {


                try{
                    setUi("adminDashBordForm");

                  //  mainContex.getScene().getWindow().hide();

                }catch (Exception e){
                    System.out.println(e);
                    System.out.println("Exception e");
                }



          //      mainContex.getScene().getWindow().hide();


            } else {

                new Alert(Alert.AlertType.WARNING, "Wrong Password !!! Try Again...").showAndWait();


                setUi("mainLoginForm");
            }
        } else {

            txtName.setVisible(false);
            pwdPassword.setVisible(false);

        }
        //mainContex.getScene().getWindow().hide();
      //  mainContex.setVisible(false);
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure Cancel?", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)) {
            CloseBtn(cancelBtn);
        }

    }

    private void CloseBtn(Button cancelBtn) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();

    }


    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }
    private void CloseWindow(String URI) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.close();
    }

}
