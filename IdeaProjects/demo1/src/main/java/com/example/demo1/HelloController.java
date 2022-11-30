package com.example.demo1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.print.PageLayout;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label champTxt;
    @FXML
    private Label mdp;

    @FXML
    protected Button effacer;
    @FXML
    protected Button fermer;



    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!")
        ;
    }

    @FXML
    protected void onFermerButtonClick(){
        Platform.exit();
    }

    @FXML
    protected void onEffacerButtonClick(){
        champTxt.setText("");
        mdp.setText("");
    }
}