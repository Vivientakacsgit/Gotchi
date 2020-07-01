package sample.game;

import java.util.Random;

public class Util {
    private Random random = new Random();

    public boolean doItOrDont(int chance){
        int num = random.nextInt(100);
        if(num > chance+1){
            return true;
        }
        return false;
    }


    public String choseAction(){
        int num = random.nextInt(100);
        if(num < 33){
            return "hungry";
        }else if(num > 33 && num < 66){
            return "tired";
        }else{
            return "bored";
        }
    }
}
