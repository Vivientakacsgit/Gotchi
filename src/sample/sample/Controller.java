package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import sample.character.Pet;
import sample.game.Game;


public class Controller {
    private Game game;

    @FXML
    public AnchorPane mainPane;
    public Button startButton;
    public AnchorPane gamePane;
    public AnchorPane menuPane;

    @FXML
    public void startGame(ActionEvent actionEvent){
        game = new Game(new Pet("Medve"));
        game.start();
        menuPane.setVisible(false);
        gamePane.setVisible(true);

    }




    @FXML
    public void eat(){
        game.getPet().eat();
        System.out.println("eat");
    }
    @FXML
    public void sleep(){
        game.getPet().sleep();
        System.out.println("sleep");
    }
    @FXML
    public void learn(){
        game.getPet().learn();

        System.out.println("learn");
    }
    @FXML
    public void play(){
        game.getPet().play();
        System.out.println("play");
    }






}
