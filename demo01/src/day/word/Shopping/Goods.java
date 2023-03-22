package day.word.Shopping;

public class Goods {
    //商品属性
    private int id;
    private String name;
    private double price;
    private int count;

    //无参构造
    public Goods() {
        super();
    }

    //有参构造
    public Goods(int id, String name, double price, int count) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }
}
