package Games;

import java.io.FileNotFoundException;

public class Hero {
    Helper helper = new Helper();
    public Hero(){ // конструктор
        ability = helper.getAbility();
        try {
            name = Helper.getName();
        } catch (FileNotFoundException e) {
            name = "Боб";
        }
    }
    public Hero(String ability){
        this.ability = helper.getAbility(ability);
        try {
            name = Helper.getName();
        } catch (FileNotFoundException e) {
            name = "Боб";
        }
    }
    public Hero(String ability, String name){
        this.ability = helper.getAbility(ability);
        this.name=name;
    }
    String name;
    Ability ability;
    int lucky = Helper.random(0, 100);
    int strength;
    int health = 100;
    int protection;

    public void getDamage() {

    }

    public void damage(Hero x) {

    }

}
