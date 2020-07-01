package sample.character;

import sample.game.Util;

public class Pet {
    private String name;
    private int id;
    private int level = 0;
    private int xp = 0;
    private final int levelUpLimit = 100;
    private Util util = new Util();
    private boolean inAction = false;
    private String action;

    public Pet(String name) {
        this.name = name;
        this.id = 1;
    }

    public void doSomething() {

        if(inAction){
            System.out.println("Im already in action");
            System.out.println(action);
        }else{
            if(util.doItOrDont(50)){
                inAction = true;
                action = util.choseAction();
                System.out.println("I choose someting to do");
            }else{
                System.out.println("I dont do anything");
            }
        }
    }




    public void play(){
        if(action.equals("bored")){
            inAction = false;
            action = "";
        }
        else{
            System.out.println("wrong");
        }
    }

    public void learn(){
        if(action.equals("bored")){
            inAction = false;
        action = "";
        }else{
            System.out.println("wrong");
        }
    }
    public void eat(){
        if(action.equals("hungry")) {
            inAction = false;
            action = "";
        }
        else{
            System.out.println("wrong");
        }
    }

    public void sleep(){
        if(action.equals("tired")) {
            inAction = false;
            action = "";
        }
        else{
            System.out.println("wrong");
        }
    }



}
