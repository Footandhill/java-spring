package day.word;

public class Prime_sum {
    /*
    求范围内的素数数量
     */

    public static void main(String[] args){
        int a = 101;
        int b = 200;
        int sum = 0;
        System.out.println("素数：");
        //遍历
        for (int i = a; i < b; i++) {
            if (Addsum(i)) {
                System.out.print(i+"  ");
                sum += 1;
            }
        }
        System.out.println();
        System.out.println("素数的个数为："+sum);
    }

    private static boolean Addsum(int i) {
        boolean flag = true;
        for (int j = 2; j < i / 2; j++) {
            if (i % j == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
