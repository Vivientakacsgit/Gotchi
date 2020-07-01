package sample.game;

import sample.character.Pet;

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
