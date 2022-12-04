package games.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import games.Color;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Game game = new Game(10,9);
        System.out.println("Создание ВАШЕГО песронажа");
        System.out.println("Его положение по y и x, а так же дальности его ходьбы: ");
        game.createHero(input);
        System.out.println("\n Создание ВАШЕГО врага");
        System.out.println("Его положение по y и x, и кол-во хп: ");
        game.createEnemy(input);
        game.field();
        input.nextLine();
        boolean bool = game.getHp();
        while(bool){
            System.out.println("Что вы хотите сделать?" + "\n 1. Атаковать" + " \n 2. Идти");
            int vote = input.nextInt();
            if(vote == 1){
                game.stream();
                System.out.println("Выберите позицию что хотите атаковать: ");
                boolean x = game.atack(input.nextInt());
                while(!x){
                    System.out.println("""
                            Похоже вы промахунулись\s
                             Что вы хотите сделать?:\s
                             1. Вернуться к выбору действия\s
                             2. Попробывать еще раз""");
                    int vote1 = input.nextInt();
                    if(vote1 == 1){
                        break;
                    } else if (vote1 == 2) {
                        game.stream();
                        System.out.println("Выберите позицию что хотите атаковать: ");
                        x = game.atack(input.nextInt());
                    }
                    else {
                        System.out.println("Похоже вы ввели что то не то, попробуйте заново");
                    }
                }
                while (x){
                    System.out.println("""
                            Поздравляю, вы попали\s
                             Что вы хотите сделать?:\s
                             1. Вернуться к выбору дейтвия\s
                             2. Попробывать еще раз""");
                    bool = game.getHp();
                    if(!bool){
                        break;
                    }
                    int vote1 = input.nextInt();
                    if(vote1 == 1){
                        break;
                    } else if (vote1 == 2) {
                        game.stream();
                        System.out.println("Выберите позицию что хотите атаковать: ");
                        x = game.atack(input.nextInt());
                    }
                    else {
                        System.out.println("Похоже вы ввели что то не то, попробуйте заново");
                    }
                }
            } else if (vote == 2) {
                game.stream();
                System.out.println("Куда вы хотите попасть?:");
                boolean x = game.go(input.nextInt());
                while(!x){
                    System.out.println("""
                            Похоже вы промахунулись\s
                             Что вы хотите сделать?:\s
                             1. Вернуться к выбору действия\s
                             2. Попробывать еще раз""");
                    int vote1 = input.nextInt();
                    if(vote1 == 1){
                        break;
                    } else if (vote1 == 2) {
                        game.stream();
                        System.out.println("Куда вы хотите попасть?: ");
                        x = game.go(input.nextInt());
                    }
                    else {
                        System.out.println("Похоже вы ввели что то не то, попробуйте заново");
                        break;
                    }
                }
                while (x){
                    game.field();
                    System.out.println("""
                            Поздравляю, вы смогли пройти\s
                             Что вы хотите сделать?:\s
                             1. Вернуться к выбору дейтвия\s
                             2. Попробывать еще раз""");
                    int vote1 = input.nextInt();
                    if(vote1 == 1){
                        break;
                    } else if (vote1 == 2) {
                        game.stream();
                        System.out.println("Куда вы хотите попасть?:");
                        x = game.go(input.nextInt());
                    }
                    else {
                        System.out.println("Похоже вы ввели что то не то, попробуйте заново");
                        break;
                    }
                }
            } else{
                System.out.println("Похоже вы ввели что-то не то, попробуйте еще раз");
            }
        }
        System.out.println("Поздравляю, вы протестили бета игру моего движка");

    }

}
class Game {
    void createHero(Scanner sc) {
        hero = new Creature(1,sc);
    }

    void createEnemy(Scanner sc) {
        enemy = new Creature(2, sc);
    }
    class Window{

        void window(){

        }
    }
    class Creature{
        class Enemy{
            public Enemy(Scanner sc){
                System.out.println("Положение врага по x: ");
                x = sc.nextInt();
                System.out.println("Положение врага по y: ");
                y = sc.nextInt();
                System.out.println("Здоровье врага: ");
                hp = sc.nextInt();
            }
        }
        class Hero{
            public Hero(Scanner sc){
                System.out.println("Положение героя по x: ");
                x = sc.nextInt();
                System.out.println("Положение героя по y: ");
                y = sc.nextInt();
                System.out.println("Дальность действий героя: ");
                range = sc.nextInt();
            }
        }
        public Creature(int key, Scanner sc){
            if(key == 1){
                new Hero(sc);
            } else if (key == 2) {
                new Enemy(sc);
            }
        }
        private String name;
        private int hp;
        private int range;
        private int x;
        private int y;
        private List<Integer> list = new ArrayList<>();
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        public int getRange(){
            return range;
        }
        public List<Integer> getList() {
            return list;
        }

        public void setList(int x) {
            list.add(x);
        }
        void moving(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    class Cell {
        String isNum(int x1, int y1) {
            String num;
            if ((((y1 - 1) * xn) + x1) < 10) {
                num = (((y1 - 1) * xn) + x1) + " ";
            } else {
                num = (((y1 - 1) * xn) + x1) + "";
            }
            if (x1 == hero.getX() && y1 == hero.getY()) {
                return (Color.BLACK + Color.GREEN_BACKGROUND + "HERO" + Color.WHITE);
            } else if (x1 == enemy.getX() && y1 == enemy.getY()) {
                if ((hero.getX() == x1 || hero.getY() == y1) ||
                        ((y1 - hero.getY()) + (x1 - hero.getX()) <= hero.getRange() &&
                                ((y1 - hero.getY()) - (x1 - hero.getX()) <= hero.getRange()) &&
                                    (-(y1 - hero.getY()) - (x1 - hero.getX()) <= hero.getRange()) &&
                                        (-(y1 - hero.getY()) + (x1 - hero.getX()) <= hero.getRange()))) {
                }
                return (Color.BLACK + Color.YELLOW_BACKGROUND + "FOE " + Color.WHITE);

            } else {
                if ((hero.getX() - hero.getRange() <= x1 && hero.getX() + hero.getRange() >= x1) &&
                        (hero.getY() - hero.getRange() <= y1 && hero.getY() + hero.getRange() >= y1)) {
                    if ((hero.getX() == x1 || hero.getY() == y1) ||
                            ((y1 - hero.getY()) + (x1 - hero.getX()) <= hero.getRange() &&
                                    ((y1 - hero.getY()) - (x1 - hero.getX()) <= hero.getRange()) &&
                                        (-(y1 - hero.getY()) - (x1 - hero.getX()) <= hero.getRange()) &&
                                            (-(y1 - hero.getY()) + (x1 - hero.getX()) <= hero.getRange()))) {
                        return (" " + num + " ");
                    }
                }
            }
            return (" " + num + " ");
        }

        String isColor(int x1, int y1) {
            String num;
            if ((((y1 - 1) * xn) + x1) < 10) {
                num = (((y1 - 1) * xn) + x1) + " ";
            } else {
                num = (((y1 - 1) * xn) + x1) + "";
            }
            if (x1 == hero.getX() && y1 == hero.getY()) {
                return (Color.BLACK + Color.GREEN_BACKGROUND + "HERO" + Color.WHITE);
            } else if (x1 == enemy.getX() && y1 == enemy.getY()) {
                if ((hero.getX() - hero.getRange() <= x1 && hero.getX() + hero.getRange() >= x1) &&
                        (hero.getY() - hero.getRange() <= y1 && hero.getY() + hero.getRange() >= y1)) {
                    if ((hero.getX() == x1 || hero.getY() == y1) ||
                            ((y1 - hero.getY()) + (x1 - hero.getX()) <= hero.getRange())
                                    && ((y1 - hero.getY()) - (x1 - hero.getX()) <= hero.getRange()) &&
                                    (-(y1 - hero.getY()) - (x1 - hero.getX()) <= hero.getRange()) &&
                                    (-(y1 - hero.getY()) + (x1 - hero.getX()) <= hero.getRange())) {
                        enemy.setList((((y1 - 1) * xn) + x1));
                    }
                }
                return (Color.BLACK + Color.YELLOW_BACKGROUND + "FOE " + Color.WHITE);
            } else {
                if ((hero.getX() - hero.getRange() <= x1 && hero.getX() + hero.getRange() >= x1) &&
                        (hero.getY() - hero.getRange() <= y1 && hero.getY() + hero.getRange() >= y1)) {
                    if ((hero.getX() == x1 || hero.getY() == y1) ||
                            ((y1 - hero.getY()) + (x1 - hero.getX()) <= hero.getRange())
                                    && ((y1 - hero.getY()) - (x1 - hero.getX()) <= hero.getRange()) &&
                                        (-(y1 - hero.getY()) - (x1 - hero.getX()) <= hero.getRange()) &&
                                            (-(y1 - hero.getY()) + (x1 - hero.getX()) <= hero.getRange())) {
                        hero.setList((((y1 - 1) * xn) + x1));
                        return (Color.BLACK + Color.GREEN_BACKGROUND + " " + num + " " + Color.WHITE);
                    }
                }
            }
            return (Color.BLACK + Color.RED_BACKGROUND + " " + num + " " + Color.WHITE);
        }
    }
    Creature enemy;
    Creature hero;
    int yn;
    int xn;
    public Game(int yn, int xn) {
        this.yn = yn;
        this.xn = xn;
    }

    public Game() {
    }
    boolean go(int c) {
        int a = 1;
        while (a <= yn) {
            if (c <= (a * xn)) {
                a--;
                break;
            }
            a++;
        }
        if (hero.getList().contains(c)) {
            hero.moving(c - (xn * a), ++a);
            hero.getList().clear();
            System.out.println(hero.getX());
            System.out.println(hero.getY());
            return true;
        } else {
            return false;
        }
    }

    boolean atack(int c) {
        int a = 1;
        while (a <= yn) {
            if (c <= (a * xn)) {
                a--;
                break;
            }
            a++;
        }
        if (enemy.getList().contains(c)) {
            enemy.hp -=1;
            return true;
        } else {
            return false;
        }
    }
    boolean getHp(){
        return enemy.hp > 0;
    }

    void stream() {
        System.out.print(Color.BLACK_BACKGROUND);
        Cell color = new Cell();
        int v = 1;
        for (int i = 0; i < 5 * xn; i++) {
            if (i % 5 == 0) {
                System.out.print("==" + v);
                v++;
                i = i + 2;
                continue;
            }
            System.out.print("=");
        }
        System.out.println();
        int y1 = 1;
        while (y1 < yn + 1) {
            System.out.print(Color.BLACK_BACKGROUND + "|");
            for (int x1 = 1; x1 < xn + 1; x1++) {
                System.out.print(color.isColor(x1, y1)+  "%5s |" + Color.BLACK_BACKGROUND + "|");
            }
            System.out.print(" " + Color.WHITE_BACKGROUND_BRIGHT + Color.BLACK_BOLD + y1 +
                    Color.RESET + Color.BLACK_BACKGROUND + "\n");
            System.out.print(Color.BLACK_BACKGROUND);
            for (int i = 0; i < 5 * xn; i++) {
                System.out.print("=");
            }
            System.out.print(Color.BLACK_BACKGROUND + "|");
            System.out.println();
            y1++;
        }
    }

    void field() {
        System.out.print(Color.BLACK_BACKGROUND);
        Cell color = new Cell();
        int v = 1;
        for (int i = 0; i < 5 * xn; i++) {
            if (i % 5 == 0) {
                System.out.print("==" + v);
                v++;
                i = i + 2;
                continue;
            }
            System.out.print("=");
        }
        System.out.println();
        int y1 = 1;
        while (y1 < yn + 1) {
            System.out.print(Color.BLACK_BACKGROUND + "|");
            for (int x1 = 1; x1 < xn + 1; x1++) {
                System.out.print(color.isNum(x1, y1) + Color.BLACK_BACKGROUND + "|");
            }
            System.out.print(" " + Color.WHITE_BACKGROUND_BRIGHT + Color.BLACK_BOLD + y1 +
                    Color.RESET + Color.BLACK_BACKGROUND + "\n");
            System.out.print(Color.BLACK_BACKGROUND);
            for (int i = 0; i < 5 * xn; i++) {
                System.out.print("=");
            }
            System.out.print(Color.BLACK_BACKGROUND + "|");
            System.out.println();
            y1++;

        }
    }
}
