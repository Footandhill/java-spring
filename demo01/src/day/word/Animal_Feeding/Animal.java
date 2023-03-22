package day.word.Animal_Feeding;

public class Animal {
    //定义动物的属性
    private int age;
    private  String color;

    //无参构造
    public Animal() {
    }

    //有参构造
    public Animal(int age, String color) {
        this.age = age;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //定义动物共同的吃方法
    protected void eat(String something) {
        System.out.println("");
    }
}
