import games.Games;
import games.creature.Hero;

import java.io.FileNotFoundException;
import java.lang.reflect.GenericArrayType;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Games game = new Games();
        game.setUp();
        game.game();
        game.finish();
    }
}