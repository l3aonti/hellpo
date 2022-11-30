package games.Test;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import games.Color;
import games.Games;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Game game = new Game(3,5,1,1,3,9,9);
        boolean bool = true;
        while(bool){
            game.stream();
            System.out.println("Куда направится ваш герой?: ");
            int num = input.nextInt();
            boolean toTry = game.go(num);
            boolean xxx = true;
            while (xxx) {
                if (toTry) {
                    System.out.println("Поздравляю! У вас получилось передвинуться. Текущая карта:");
                    break;

                } else {
                    System.out.println("Упс! Вы не смогли переметиться. Введите еще раз направление героя: ");
                    num = input.nextInt();
                    toTry = game.go(num);
                }
            }
        }

    }

}
class Game{
    class Nested{
        String isColor(int x1, int y1){
            String num;
            if((((y1-1)*xn)+x1) < 10 ){
                num = (((y1-1)*xn)+x1)+" ";
            }
            else{
                num = (((y1-1)*xn)+x1) + "";
            }
            if(x1 == hero[0] && y1 == hero[1]){
                return ( Color.BLACK + Color.GREEN_BACKGROUND   + "HERO" + Color.WHITE);
            } else if (x1 == enemy[0]&& y1 == enemy[1]) {
                return ( Color.BLACK + Color.YELLOW_BACKGROUND   + "FOE " + Color.WHITE);
            } else{
                if((hero[0] - range <= x1 && hero[0] + range >= x1) &&
                        (hero[1] - range <= y1 && hero[1] + range >= y1)  ){
                    if((hero[0] == x1 || hero[1] == y1) ||
                            ((y1-hero[1])+(x1-hero[0]) <= range ) && ((y1-hero[1])-(x1-hero[0]) <= range) &&
                                    (-(y1-hero[1])-(x1-hero[0]) <= range) && (-(y1-hero[1])+(x1-hero[0]) <= range)){
                        list.add((((y1-1)*xn)+x1));
                        return ( Color.BLACK + Color.GREEN_BACKGROUND + " "  + num + " " + Color.WHITE);
                    }
                }
            }
            return (Color.BLACK + Color.RED_BACKGROUND + " "  + num + " " + Color.WHITE);
        }
    }
    int[] hero = new int[2];
    int[] enemy =new int[2];
    int range;
    final int yn;
    final int xn;
    private List<Integer> list = new ArrayList<>();

    public Game(int x, int y, int x1, int y1, int range,int yn, int xn){
        this.hero[0] = x;
        this.hero[1] = y;
        this.enemy[0] = x1;
        this.enemy[1] = y1;
        this.range = range;
        this.yn = yn;
        this.xn = xn;
    }
    boolean go(int c){
        int a = 0;
        while(a < yn){
            if( c < xn*a){
                a--;
                break;
            }
            a++;
        }
        System.out.println(a);
        if((c % ((a)*yn) == 0) || c == 72 ){
            if(list.contains(c)){
                System.out.println(a);
                hero[0] = c / (c / xn);
                hero[1] = c / yn;
                list.clear();
                System.out.println(hero[0] + " " + hero[1]);
                return true;
             }
        }
        if(list.contains(c)){
            hero[0] = c - (a * yn);
            hero[1] = a+1;
            list.clear();
            return true;
        }
        return false;
    }
    void atack(){}
    void stream(){
        System.out.print(Color.BLACK_BACKGROUND);
        Nested color = new Nested();
        int v = 1;
        for(int i = 0; i < 5*xn; i++){
            if(i % 5 == 0 ){
                System.out.print("=="+v);
                v++;
                i=i+2;
                continue;
            }
            System.out.print("=");
        }
        System.out.println();
        int y1 = 1;
        while (y1<yn+1){
            System.out.print(Color.BLACK_BACKGROUND + "|");
            for(int x1 = 1; x1 < xn+1; x1++){
                System.out.print(color.isColor(x1,y1) + Color.BLACK_BACKGROUND + "|");
            }
            System.out.print( " " + Color.WHITE_BACKGROUND_BRIGHT + Color.BLACK_BOLD + y1 +
                    Color.RESET + Color.BLACK_BACKGROUND + "\n");
            System.out.print(Color.BLACK_BACKGROUND);
            for(int i = 0; i < 5*xn; i++){
                System.out.print("=");
            }
            System.out.print(Color.BLACK_BACKGROUND + "|" );
            System.out.println();
            y1++;
        }
    }
    void field(){

    }


}
