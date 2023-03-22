package day.word;

import java.util.Random;

public class Two_Dimensional_Arrays {
    public static void main(String[] args) {
        //定义一个一维数组
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        //随机打乱arr数组
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        //将打乱的数组遍历输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

        //定义一个二维数组
        int[][] data = new int[4][4];

        //将一维数组里的数遍历到二维数组中
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = arr[sum];
                sum ++;
            }
        }

        //遍历输出二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "  ");
            }
        }
    }
}
