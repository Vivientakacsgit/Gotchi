package sample.game;

import sample.Controller;
import sample.Main;

import java.util.Timer;
import java.util.TimerTask;

public class Game {


    public void start() {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("step");
            }
        };
        timer.schedule(timerTask,0,3000
        );
    }



}
