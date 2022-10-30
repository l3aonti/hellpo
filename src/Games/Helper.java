package Games;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Helper {
    public Ability getAbility(){
        int x = Helper.random(1,4);
        return switch (x) {
            case (1) -> new Air();
            case (2) -> new Fire();
            case (3) -> new Earth();
            case (4) -> new Water();
            default -> null;
        };
    }

    public Ability getAbility(String ability) {
        return switch (ability) {
            case "вода" -> new Water();
            case "огонь" -> new Fire();
            case "земля" -> new Earth();
            default -> new Air();
        };
    }

    public static int random(int min, int max){

        return (int)(min+(Math.random()*(max-min)));
    }
    public static String getName() throws FileNotFoundException {
        String aboba = "Bob";
        File file = new File("src/Resorces/MyName.txt");
        Scanner sc = new Scanner(file);
        for(int i = 0; i < Helper.random(1, 9); i++){
            aboba = sc.nextLine();
        }
        return aboba;
    }
}