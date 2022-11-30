package games;

import games.creature.Hero;

import java.util.Scanner;

public class Games {
    Scanner sc = new Scanner(System.in);
    Hero hero = new Hero();

    Hero enemy = new Hero();
    public void setUp(){
        System.out.println("Введите ваше имя: ");
        String name = sc.nextLine();
        hero.setName(name);
        System.out.println("Ваша способность: ");
        String ability = sc.nextLine();
        hero.setAbility(ability);
        System.out.println("Ваша раса: ");
        hero.setRace(sc.nextLine());
        System.out.println("Ваш персонаж: ");
        hero.person();
        sc.nextLine();
        System.out.println("Ваш враг:");
        enemy.person();


    }
    public void game(){
        while(hero.getHealth()>0 && enemy.getHealth() >0){
            sc.nextLine();
            System.out.print(enemy.getName() + " создал ");
            hero.damage(enemy);
            System.out.print(hero.getName() + " создал ");
            enemy.damage(hero);
            System.out.println("\tИтоги атаки\n\n" +
                    enemy.getName() + " " + enemy.getHealth() + " хп\n" +
                    hero.getName() + " " + hero.getHealth() + " хп\n");
        }
    }
    public void finish(){
        System.out.println("==============================================\n\n" +
                "В битве " + enemy.getName() + " и " + hero.getName() + "\n"+
                "П\tО\tБ\tЕ\tД\tИ\tЛ ............");
        if(enemy.getHealth()>0){
            System.out.println(enemy.getName());
        }
        else{
            System.out.println(hero.getName());
        }
    }
}
