package games.creature.IDEAS.enemy;

import games.Helper;
import games.ability.AbilityEnum;
import games.item.Item;
import games.races.RaceEnum;

import java.io.FileNotFoundException;

public abstract class Creature {
    Helper helper = new Helper();
    private Item[] inventory;
    private Item weapon;

    private AbilityEnum ability;
    private String name;
    private RaceEnum race;
    public Creature(){
        ability = helper.getAbility();
        try {
            name = helper.getName();
        } catch (FileNotFoundException e) {
            name = "Боб";
        }
        race = helper.randomRace();
        weapon = helper.randomItem();
    }
    void go() {
    }
}