package day.word.Shopping;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args){
        //建立一个商品数组
        Goods[] shops = new Goods[3];

        //将值赋值到数组当中
        Goods a =new Goods(1, "sda", 321, 2134);
        Goods b =new Goods(2, "sd", 412, 5435);
        shops[0] = a;
        shops[1] = b;

        //输入商品id进行查询
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询商品的id：");
        int deleteId = input.nextInt();
        //id查询
        int num1 = getIdex(shops, deleteId);
        //判断是否进行删除操作
        if (num1 >= 0) {
            //id存在
            Scanner sc = new Scanner(System.in);
            System.out.println("是否进行删除操作？1:删除  2：不删除");
            int r = sc.nextInt();
            if(r == 1){
                shops[num1] = null;
                printArr(shops);
            }
        }else if(num1<0){
            //id不存在
            System.out.println("id不存在");
        }

        System.out.println("——————————————————————————————————");

        Scanner sc = new Scanner(System.in);
        System.out.println("请问需不需要添加新的商品：1：yes  2：no");
        int num =sc.nextInt();
        //判断是否需要添加商品
        if (num == 1) {
            Goods good = addGood(shops);
            //判断id是否存在
            boolean flag = sole(shops, good.getId());
            if (flag) {
                System.out.println("当前id已存在！");
            } else {
                int count = getcount(shops);
                //判断数组是否满,如果未满直接添加并输出;如果以满，则创造一个新的数组并将旧数组复制到新的数组再添加商品
                if (count == shops.length) {
                    //创造一个新的数组并将旧数组复制到新的数组
                    Goods[] newshops = createNewArr(shops);
                    //添加商品
                    newshops[count] = good;
                    //输出
                    printArr(newshops);
                }else {
                    shops[count] = good;
                    //输出
                    printArr(shops);
                }
            }
        }
    }

    //遍历输出
    public static void printArr(Goods[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Goods sum = arr[i];
            if (sum!= null) {
                System.out.println(sum.getId() + " " + sum.getName() + " " + sum.getPrice() + " " + sum.getCount());
            }
        }
    }

    //创建新数组并将旧数组遍历在新数组中
    public static Goods[] createNewArr(Goods[] arr) {
        Goods[] newarr = new Goods[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }

    //判断数组是否存满
    public static int getcount(Goods[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                num++;
            }
        }

        return num;
    }

    //判断id的唯一性
    public static boolean sole(Goods[] arr,int id) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            Goods num = arr[i];
            int gid = num.getId();
            if (gid != id) {
                return flag;
            }
            if(gid == id){
                return true;
            }
        }
        return true;

    }

    //查询id在数组中的索引
    public static int getIdex(Goods[] arr,int num) {
        int sum = -1;
        for (int i = 0; i < arr.length; i++) {
            //查询id
            Goods str = arr[i];
            if (str != null) {
                int a = arr[i].getId();
                if (a == num) {
                    sum = i;
                }
            }

        }
        return sum;
    }

    //手动输入，添加商品
    public static Goods addGood(Goods[] arr){
        //新建一个商品对象
        Goods shop = new Goods();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id：");
        int id =sc.nextInt();
        shop.setId(id);

        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入名字：");
        String name =sc1.next();
        shop.setName(name);

        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入价格：");
        double price =sc2.nextDouble();
        shop.setPrice(price);

        Scanner sc3 = new Scanner(System.in);
        System.out.println("请输入货存：");
        int count =sc3.nextInt();
        shop.setCount(count);
        return shop;
    }

}
