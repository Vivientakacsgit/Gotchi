package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.game.Game;

import javax.swing.text.html.HTML;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {


    @FXML
    public Label mainPane;


    @FXML
    public void startGame(ActionEvent actionEvent){
        Game game = new Game();
        game.start();
        mainPane.setVisible(false);
    }






}
