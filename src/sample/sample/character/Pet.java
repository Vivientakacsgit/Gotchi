package sample.character;

import sample.game.Util;

public class Pet {
    private String name;
    private int id;
    private int level = 0;
    private int xp = 0;
    private int levelUpLimit = 100;
    private boolean inAction = false;
    private boolean inMood = false;

    private String action = "   ";
    private int inactiveStep = 0;
    private int energy = 10;
    private int endOfActivity = 0;


    public Pet(String name) {
        this.name = name;
        this.id = 1;
    }

    public int getXp() {
        return xp;
    }

    public void doSomething() {
        if (inMood || inAction) {
            System.out.println("Im already in action or mood");
            if(inMood){
                inactiveStep++;
            }
        } else {
            if (Util.doItOrDont(1)) {
                System.out.println("I choose something to do");
                inMood = true;
                action = Util.chooseAction();
            } else {
                System.out.println("I dont do anything");
            }
        }
    }


    public void play() {
        if (action.equals("bored")) {
            raiseXp(30);
            changeAction("playing");
            startActivity();

        } else {
            System.out.println("wrong");
        }
    }

    public void learn() {
        if (action.equals("bored")) {
            raiseXp(50);
            changeAction("learning");
            startActivity();



        } else {
            System.out.println("wrong");
        }
    }


    public void eat() {
        if (action.equals("hungry")) {
            raiseXp(10);
            changeAction("eating");
            startActivity();



        } else {
            System.out.println("wrong");
        }
    }


    public void sleep() {
        if (action.equals("tired")) {
            raiseXp(15);
            changeAction("sleeping");
            startActivity();


        } else {
            System.out.println("wrong");
            wrongButtonPressed();
        }
    }


    private void wrongButtonPressed() {
        if (xp < 5) {
            xp = 0;
        } else {
            xp -= 5;
        }
    }

    public void setEndOfActivity() {
        this.endOfActivity = 2;
    }

    public void handleActivity() {
        if (endOfActivity > 0) {
            inAction = false;
            endOfActivity = 2;
        } else {
            endOfActivity--;
        }
    }


    public void startActivity(){
        inactiveStep = 0;
        inMood = false;
        inAction = true;
        endOfActivity = 3;

    }

    public String getName() {
        return name;
    }

    public String getAction() {
        return action;
    }

    public int getLevel() {
        return level;
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


    private void changeAction(String action) {
        this.action = action;
    }




    private void raiseXp(int num) {
        xp += num;
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
                if (xp < 10) {
                    xp = 0;
                } else {
                    xp -= 10;
                }
            }
        }


    }
}
