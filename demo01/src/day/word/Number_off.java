package day.word;


import java.util.Random;
import java.util.Scanner;

public class Number_off {
    /*
    报数游戏
     */
    public static void main(String[] args){
        Random a = new Random();
        int num = a.nextInt(10);
        System.out.println("逢数："+num);
        Scanner sc = new Scanner(System.in);
        System.out.println("随便报一个数：");
        int call_num = sc.nextInt();
        for (int i = call_num; i < 100; i++) {
            if(i%num==0){
                continue;
            }
            System.out.print(i+"  ");
        }
    }
}
