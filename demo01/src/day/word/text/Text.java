package day.word.text;

import java.util.Random;

public class Text {
    public static void main(String[] args) {
        int[] sum = new int[18];
        for (int i = 0; i < 18; i++) {
            Random a = new Random();
            int num = a.nextInt(100);
            sum[i] = num;
        }
        for (int i = 0; i < 18; i++) {
            System.out.print(sum[i] + "  ");
        }
        System.out.println();
        String[] sum1 = new String[9];
        for (int i = 1; i < 10; i++) {
            int a = i*2-1;;
            for (int j = i-1; j < 9; j++) {
                if (j == 0){
                    sum1[j] = "[" + sum[a] + "," + sum[a-1] + "]";
                    break;
                } else if (j%2 != 0) {
                    sum1[j] = "[" + sum[a] + "]";
                    continue;
                } else if (j%2 ==0 ) {
                    sum1[j] = "[" + sum[a-3] + "," + sum[a-1] + "," + sum[a] + "]";
                    continue;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(sum1[i]);
        }
    }
   
}
