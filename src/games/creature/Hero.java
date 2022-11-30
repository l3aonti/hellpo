package games.creature;

import games.Color;
import games.Helper;

import java.io.FileNotFoundException;

import games.ability.AbilityEnum;
import games.races.RaceEnum;

public class Hero {
    //универсльный класс помощник
    Helper helper = new Helper();
    /**
    Конструктор который утанавливает случайное имя, способность, защита, увороты и силу.
     */

    public Hero(){
        ability = helper.getAbility();
        try {
            name = helper.getName();
        } catch (FileNotFoundException e) {
            name = "Боб";
        }
        race = helper.randomRace();

    }

    /**
     * Устанвливает пользавательскую расу (принимает String, с маленькой буквы)
     */
    public void setRace(String x){
        race = helper.setRace(x);
    }

    /**
     * Устанваливает пользавательское имя
     */
    public void setName(String name){
        this.name = name;
    }
    /**
    Устанавливает способность введенную в консоль.
    Принимает имя способности (String, обязатаельно с маленькой буквы)
     */
    public void setAbility(String ability){
        this.ability = helper.getAbility(ability);
    }

    /**
     * Метод добавляет к характеристикам бонус от расы
     */
    public void setBonus(){
        strength += race.getBonusStrength();
        agility += race.getBonusAgility();
        protection += race.getBonusProtection();
    }
    /*
   Объявление переменных, которые отвечавют за характеристики персонажа
    */
        private String name;
        private AbilityEnum ability;
        private final int lucky = Helper.random(1, 10);
        private int strength = Helper.random(1,5);
        private int agility = Helper.random(1,5);
        private double health = 100.0;
        private int protection = Helper.random(1, 5);
        private int xp;
        private RaceEnum race;
     /*
    Метод, который показывает описание персонажа
    */
    public void person(){
        System.out.println(Color.BLACK_BACKGROUND+ Color.RED_BOLD_BRIGHT +"======================================\n");
        System.out.println("Имя персонажа: " + name  +  "\n" +
                "\n" +
                "Раса персонажа: " + race.getRaceName() + "\n" +
                "\n" +
                "Количество здоровья " + health + "\n" +
                "\n" +
                "Стихия " + ability.getName());
        System.out.println("\n======================================");
    }
    /*
    Метод,  отвечающий за снятие здоровья персонажа и пасивную защиту
     */
    public void getDamage(double damage) {
        health -= damage;
    }
    /*
    Метод, считающий урон, который нанесет персонаж. Внутри вызывает метод getDamage()
     */
    public void damage(Hero x) {
        String[] args;
        try {
            args  = Helper.getNameAtack();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ability.getAtackName() + " " + args[0]);
        double damage = strength*(lucky/2)*ability.getPower() ;
        getDamage(damage);
    }
    /*
    Метод, отвечающий за активную защиту персонажа
     */
    public void defence(Hero x){

    }

    public double getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void test(){
        System.out.println(ability.toString());
    }
}
