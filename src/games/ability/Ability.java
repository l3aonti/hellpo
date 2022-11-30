package games.ability;

import games.creature.Hero;

public abstract class Ability{
    public abstract String toString();

    public abstract void atack(Hero x, int lucky);
    public abstract double def(double damage, int lucky);
    public abstract void superA(Hero x);



}
