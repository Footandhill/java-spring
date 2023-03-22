package day.word;

public class Cubic {
    /*
    打印出所有的”水仙花数”，所谓”水仙花数”是指一个三位数，其各位数字立方和等于该数本身。
    例如：153是一个”水仙花数”，因为153=1的三次方＋5的三次方＋3的三次方
     */

    public static void main(String[] args){
        //循环遍历
        for (int i = 100; i < 999; i++) {
            if (cb(i)) {
                System.out.println("水仙花数："+i);
            }
        }
    }

    private static boolean cb(int a) {
        // TODO Auto-generated method stub
        int num1 = a/100;
        int num2 = (a-num1*100)/10;
        int num3 = a-num1*100-num2*10;
        if (Math.pow(num1,3)+Math.pow(num2,3)+Math.pow(num3,3)==a) {
            return true;
        }
        return false;
    }
}
