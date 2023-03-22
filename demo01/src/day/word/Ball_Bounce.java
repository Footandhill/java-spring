package day.word;

import java.util.Scanner;

public class Ball_Bounce {
    /**
     * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；n次落地经过路线总长度和下次反弹的高度
     * @param args
     */
    public static void main(String[] args) {
        double hight = 100;
        Scanner sc = new Scanner(System.in);
        System.out.println("小球落地次数：");
        int s = sc.nextInt();
        sumLength(hight, s);
    }

    public static void sumLength(double a,int b) {
        double sumLength = 0;
        for (int i = 0; i < b; i++) {
            if (i == 0) {
                sumLength = a;
            }else {
                sumLength = sumLength +a*2;
            }
            a = a/2;
        }
        System.out.println("小球距地距离：" + a);
        System.out.println("小球经过总长度：" + sumLength);
    }
}
