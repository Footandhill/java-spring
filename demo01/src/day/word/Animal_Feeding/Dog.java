package day.word.Animal_Feeding;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(int age, String color) {
        super(age, color);
    }

    //定义狗狗特有方法
    protected void lookHome() {
        System.out.println("狗狗在看家");
    }
}
