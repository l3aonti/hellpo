package NonUSed;

import games.Helper;
import games.ability.Ability;
import games.creature.Hero;

import java.io.FileNotFoundException;

public class Earth extends Ability {

    @Override
    public String toString() {
        return "Земля";
    }

    @Override
    public void atack(Hero x, int lucky) {
        String[] args;
        try {
            args  = Helper.getNameAtack();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Земляной "+ args[0]);
        int i = Integer.parseInt(args[1]);
        int damage = i + 3;
        x.getDamage(damage);
    }

    @Override
    public double def(double damage, int lucky) {
        return damage - 5;
    }

    @Override
    public void superA(Hero x) {
        System.out.println(" Г Р Я З Е В А Я Л О В У Ш К А");

    }

}
