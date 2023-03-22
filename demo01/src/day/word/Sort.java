package day.word;

/**
 * 冒泡排序，从小到大
 */
public class Sort {
    public static void main(String[] args){
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            int number = 1+(int)(Math.random()*(100));
            a[i] = number;
        }
        int b;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if (a[j]>a[j+1]) {
                    b=a[j];
                    a[j]=a[j+1];
                    a[j+1]=b;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"   ");
        }
    }
}
