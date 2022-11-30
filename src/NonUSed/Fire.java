package NonUSed;

import games.Helper;
import games.ability.Ability;
import games.creature.Hero;

import java.io.FileNotFoundException;

public class Fire extends Ability {

    @Override
    public String toString() {
        return "Огонь";
    }

    @Override
    public void atack(Hero x, int lucky) {
        String[] args;
        try {
            args  = Helper.getNameAtack();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Огненный "+ args[0]);
        int i = Integer.parseInt(args[1]);
        int damage = i + 5;
        x.getDamage(damage);
    }

    @Override
    public double def(double damage, int lucky) {
        return damage - 2;
    }

    @Override
    public void superA(Hero x) {

    }

}
