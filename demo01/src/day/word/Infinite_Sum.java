package day.word;

import java.util.Scanner;

public class Infinite_Sum {
    /*求s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字。
      例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。输出结果的形式如：2+22+222=246
     */
    public static void main(String[] args) {
       //打印输出需求
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入次数：");
        int sub = sc.nextInt();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数字：");
        int num = input.nextInt();
        System.out.println(sum(sub, num));

    }

    //求a+aa+aaa+aaaa+aa…a的值，其中a是一个数字
    public static int sum(int a,int b) {
        int result = 0;
        int sum = 0;
        int num1 = 0;
        int sum1 = 0;
        for (int i = 0; i < a; i++) {
            result = (int)((Math.pow(10, i)*b)+sum);
            if (i==0) {
                result = sum = b;
            }
            sum1 = result;
            result = num1 + result;
            num1 = result;
            sum = sum1;
        }

        return result;

    }

}
