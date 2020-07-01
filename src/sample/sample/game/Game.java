package sample.game;

import sample.Controller;
import sample.Main;
import sample.character.Pet;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private Pet pet;

    public Game(Pet pet) {
        this.pet = pet;
    }

    public void start() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("step");
                pet.doSomething();

            }
        };
        timer.schedule(timerTask,0,5000
        );
    }


    public Pet getPet() {
        return pet;
    }
}
