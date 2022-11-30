package games.creature.IDEAS.enemy;

import games.creature.IDEAS.enemy.Creature;
import games.creature.IDEAS.enemy.Warrior;

public class HeroNew extends Creature implements Warrior {
    private int[] position = new int[2];

    @Override
    public int[] getPos() {
        return position;
    }

    @Override
    public void setPos(int length, int width) {
        position[0] = length;
        position[1] = width;
    }

    @Override
    public void atack() {

    }

    @Override
    public void defence() {

    }

    @Override
    public void getAtack() {

    }
}
