package games;

import games.ability.*;
import games.item.Item;
import games.races.RaceEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Helper {
    public AbilityEnum getAbility(){
        int x = Helper.random(1,5);
        return switch (x) {
            case (1) -> AbilityEnum.AIR;
            case (2) -> AbilityEnum.EARTH;
            case (3) -> AbilityEnum.WATER;
            default -> AbilityEnum.FIRE;
        };
    }

    public AbilityEnum getAbility(String ability) {
        return switch (ability) {
            case "вода" -> AbilityEnum.WATER;
            case "огонь" -> AbilityEnum.FIRE;
            case "земля" -> AbilityEnum.EARTH;
            default -> AbilityEnum.AIR;
        };
    }

    public static int random(int min, int max){
        return (int)(min+(Math.random()*(max-min)));
    }
    private static int valueOfLines(File file) throws FileNotFoundException {
        Scanner scanner =  new Scanner(file);
        int i = 0;
        while(scanner.hasNextLine()){
            i++;
            scanner.nextLine();
        }
        scanner.close();
        return i;
    }
    public String getName() throws FileNotFoundException {
        String aboba = "Bob";
        File file = new File("src/Resorces/MyName");
        Scanner sc = new Scanner(file);
        int x = valueOfLines(file) ;
        for(int i = 0; i < Helper.random(1, x); i++){
            aboba = sc.nextLine();
        }
        sc.close();
        return aboba;
    }
    public static String[] getNameAtack() throws FileNotFoundException {
        String[] args = new String[2];
        File file = new File("src/Resorces/NameAtack");
        Scanner sc = new Scanner(file);
        int x = valueOfLines(file);
        for(int i = 0; i < Helper.random(1,x); i++){
            String line = sc.nextLine();
            args = line.split(" ");
        }
        sc.close();
        return args;
    }
    public RaceEnum randomRace(){
        RaceEnum[] random = RaceEnum.values();
        int x = Helper.random(1, random.length);
        return random[x];
    }
    public RaceEnum setRace(String str){
        return switch (str){
            case "огр" -> RaceEnum.OGRE;
            case "гном" -> RaceEnum.GNOME;
            case "дварф" -> RaceEnum.DWARF;
            case "эльф" -> RaceEnum.ELF;
            case "человек" -> RaceEnum.HUMAN;
            default -> randomRace();
        };
    }
    public Item randomItem(){
        Item[] random = Item.values();
        int x = Helper.random(1, random.length);
        return random[x];
    }
}