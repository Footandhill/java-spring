package day.word;

import java.util.Scanner;

public class Prime_factors {
    /*
    将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
     */

    public static void main(String[] args){
        //输入数值
        Scanner num = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int sum = num.nextInt();
        System.out.println("该数的质因数是：");
        int temp = sum/2;
        //循环遍历
        for (int i = 1; i <= temp; i++) {
            //找出整数的质因数，并提取出来
            if (sum%i==0) {
                sum = sum/i;
                System.out.print(i+"   ");
                i=1;
                continue;
            }
        }
    }
}
