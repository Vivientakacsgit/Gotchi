package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.character.Pet;
import sample.game.Game;

import java.util.Timer;
import java.util.TimerTask;


public class Controller {
    public AnchorPane messageBox;
    public AnchorPane sideBar;
    public AnchorPane petArea;
    public AnchorPane statusArea;
    public Label textBox;
    public ImageView characterImage;
    private Game game;
    public AnchorPane mainPane;
    public Button startButton;
    public AnchorPane gamePane;
    public AnchorPane menuPane;
    @FXML
    private ImageView medve;


    @FXML
    public void startGame() {
        menuPane.setVisible(false);
        gamePane.setVisible(true);
        medve.setVisible(true);
        game = new Game(new Pet("Medve"));
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                game.step();
                Platform.runLater(() -> {
                    refreshScreen();
                });
            }
        };
        timer.schedule(timerTask, 0, 5000);
    }


    @FXML
    public void refreshScreen() {
        setTextBox(game.getPet().getAction());
    }


    public void setTextBox(String text) {
        textBox.setText(text);
    }


    @FXML
    public void eat() {
        game.getPet().eat();
        System.out.println("eat");
        setTextBox("...");
    }

    @FXML
    public void sleep() {
        game.getPet().sleep();
        System.out.println("sleep");
        setTextBox("...");

    }

    @FXML
    public void learn() {
        game.getPet().learn();
        System.out.println("learn");
        setTextBox("...");

    }

    @FXML
    public void play() {
        game.getPet().play();
        System.out.println("play");
        setTextBox("...");

    }


}
