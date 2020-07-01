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

    public void step() {
                System.out.println("step");
                pet.handleInactive();
                pet.handleXP();
                pet.status();
                pet.doSomething();

    }



    public Pet getPet() {
        return pet;
    }
}
