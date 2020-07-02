package sample.character;

import sample.game.Util;

public class Pet {
    private String name;
    private int id;
    private int level = 0;
    private int xp = 0;
    private int levelUpLimit = 100;
    private boolean inAction = false;
    private String action = "...";
    private int inactiveStep = 0;


    public Pet(String name) {
        this.name = name;
        this.id = 1;
    }

    public void doSomething() {
        if (inAction) {
            System.out.println("Im already in action");
            inactiveStep++;
        } else {
            if (Util.doItOrDont(1)) {
                System.out.println("I choose someting to do");
                inAction = true;
                action = Util.chooseAction();
            } else {
                System.out.println("I dont do anything");
            }
        }
    }


    public void play() {
        if (action.equals("bored")) {
            clearAction();
            raiseXp(30);

        } else {
            System.out.println("wrong");
        }
    }

    public void learn() {
        if (action.equals("bored")) {
            clearAction();
            raiseXp(50);
        } else {
            System.out.println("wrong");
        }
    }

    public void eat() {
        if (action.equals("hungry")) {
            clearAction();
            raiseXp(10);
        } else {
            System.out.println("wrong");
        }
    }

    public String getAction() {
        return action;
    }

    public void sleep() {
        if (action.equals("tired")) {
            clearAction();
            raiseXp(15);

        } else {
            System.out.println("wrong");
            wrongButtonPressed();
        }
    }

    private void wrongButtonPressed() {
        xp -= 5;
    }


    public void status() {
        System.out.println("Pet{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", level=" + level +
                ", xp=" + xp +
                ", action='" + action + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", level=" + level +
                ", xp=" + xp +
                ", action='" + action + '\'' +
                '}';
    }


    private void clearAction() {
        inAction = false;
        action = "...";
        inactiveStep = 0;
    }


    private void raiseXp(int num) {
        xp += num;
    }


    public int getLevelUpLimit() {
        return levelUpLimit;
    }

    public void handleXP() {
        if (xp > levelUpLimit) {
            level++;
            xp = xp - levelUpLimit;
            levelUpLimit = levelUpLimit * 2;
        }
    }


    public void handleInactive() {
        if (inAction) {
            inactiveStep++;
            System.out.println(inactiveStep);
            if (inactiveStep > 2) {
                xp -= 10;
            }
        }


    }
}
