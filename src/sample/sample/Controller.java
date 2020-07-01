package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.game.Game;

import javax.swing.text.html.HTML;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {


    @FXML
    public AnchorPane mainPane;
    public Button startButton;
    public AnchorPane gamePane;
    public AnchorPane menuPane;

    @FXML
    public void startGame(ActionEvent actionEvent){
        Game game = new Game();
        game.start();
        menuPane.setVisible(false);
        gamePane.setVisible(true);

    }




    @FXML
    public void eat(){
        System.out.println("eat");
    }
    @FXML
    public void sleep(){
        System.out.println("sleep");
    }
    @FXML
    public void learn(){
        System.out.println("learn");
    }
    @FXML
    public void play(){
        System.out.println("play");
    }






}
