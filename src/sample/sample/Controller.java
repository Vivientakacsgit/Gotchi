package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import java.util.concurrent.atomic.AtomicInteger;


public class Controller {
    public AnchorPane messageBox;
    public AnchorPane sideBar;
    public AnchorPane petArea;
    public AnchorPane statusArea;
    public Label textBox;
    public ImageView characterImage;
    public TextField nameInput;
    public Label levelLabel;
    private Game game;
    public AnchorPane mainPane;
    public Button startButton;
    public AnchorPane gamePane;
    public AnchorPane menuPane;

    @FXML
    private ImageView medve;







    /*@FXML
    FileInputStream input = new FileInputStream("resources/images/gotchiAdult.png");
    Image image = new Image(input);
    ImageView imageView = new ImageView(image);*/



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
        levelLabel.setText(game.getPet().getName() + " is lvl " + game.getPet().getLevel() + "   XP: " + game.getPet().getXp());
        if(game.getPet().getAction().equals("   ")){
            setTextBox("");
        }else{
            setTextBox(" I`m " + game.getPet().getAction());

        }
        if(game.getPet().getAction().equals("bored")) {
            characterImage.setImage(new Image("resources/images/gotchiAdult.png"));
        }
        if(game.getPet().getAction().equals("learning")){
            characterImage.setImage(new Image("resources/images/gotchiLearn.png"));
        }


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
