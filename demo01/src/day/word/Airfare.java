package day.word;

import java.util.Scanner;

public class Airfare {
    /*
    根据原价、舱位以及季节计算飞机票票价
     */
    public static void main(String[] args){
        //输入票价
        System.out.println("请输入票价:");
        Scanner c = new Scanner(System.in);
        double price = c.nextInt();
        //选择月份
        System.out.println("选择你所处的月份");
        Scanner a = new Scanner(System.in);
        int num1 = a.nextInt();
        //选择舱型
        System.out.println("请输入头等舱与经济舱相对于的数字：1：头等舱     2：经济舱");
        Scanner b = new Scanner(System.in);
        int num2 = b.nextInt();

        double ticket = 0;
        //根据月份判断淡旺季
        if (num1>=5&&num1<=10) {
            //旺季
            ticket = getTicket(price, num2, 0.9, 0.85);
        }else if((num1>=1&&num1<=4)||(num1>=11&&num1<=12)){
            //淡季
            ticket = getTicket(price, num2, 0.7, 0.65);
        }else{
            System.out.println("没有这个月份！！");
        }
        System.out.println(ticket);
    }

    private static double getTicket(double price, int num2, double v, double v1) {
        if (num2 == 1) {
            //头等舱
            price = price * v;
        }else if(num2 == 2){
            //经济舱
            price = price * v1;
        }else{
            System.out.println("没有此舱位！");
        }
        return price;
    }
}
