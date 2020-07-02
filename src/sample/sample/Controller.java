package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.character.Pet;
import sample.game.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;


public class Controller {
    public AnchorPane messageBox;
    public AnchorPane sideBar;
    public AnchorPane petArea;
    public AnchorPane statusArea;
    public Label textBox;
    public ImageView characterImage;
    public TextField nameInput;
    public Label levelLabel;
    public Label levelUpBox;
    private Game game;
    public AnchorPane mainPane;
    public Button startButton;
    public AnchorPane gamePane;
    public AnchorPane menuPane;

    @FXML
    private ImageView medve;

    private boolean scene = false;


    public Controller() throws FileNotFoundException {
    }


    @FXML
    public void startGame() {

        menuPane.setVisible(false);
        gamePane.setVisible(true);
        medve.setVisible(true);
        game = new Game(new Pet(nameInput.getText()));
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                game.step();
            }
        };
        timer.schedule(timerTask, 0, 3000);
        animation();

    }


    @FXML
    public void refreshScreen() {
        if (scene) {
            scene = false;
        } else {
            scene = true;
        }

        levelLabel.setText(game.getPet().getName() + " is lvl " + game.getPet().getLevel() + "   XP: " + game.getPet().getXp());
        if (game.getPet().isLvlUp()){
            levelUpBox.setVisible(true);
        } else {
            levelUpBox.setVisible(false);
        }

        if (game.getPet().getAction().equals("   ")) {
            setTextBox("");
        } else {
            setTextBox(" I`m " + game.getPet().getAction());
        }
        Image img = null;
        switch (game.getPet().getAction()) {
            case "bored":
                if (scene) {
                    img = new Image("resources/images/gotchiLeft.png");
                } else {
                    img = new Image("resources/images/gotchiRight.png");
                }
                break;

            case "tired":
                if (scene) {
                    img = new Image("resources/images/gotchiAdult.png");
                } else {
                    img = new Image("resources/images/gotchiTired (1).png");
                }
                break;

            case "hungry":
                if (scene) {
                    img = new Image("resources/images/gotchiHappy.png");
                } else {
                    img = new Image("resources/images/gotchiHappy2.png");
                }
                break;

            case "sleeping":
                img = new Image("resources/images/gotchiSleep.png");
                break;

            case "learning":
                img = new Image("resources/images/gotchiLearn.png");
                break;

            case "playing":
                img = new Image("resources/images/gotchiPlay.png");
                break;

            case "eating":
                img = new Image("resources/images/gotchiFeed2.png");
                break;
        }

        characterImage.setImage(img);



    }

    private void animation() {
        Timer animationTimer = new Timer();
        TimerTask animationTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    refreshScreen();
                });
            }
        };
        animationTimer.schedule(animationTask, 0, 1000);

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
