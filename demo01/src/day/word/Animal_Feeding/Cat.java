package day.word.Animal_Feeding;

public class Cat extends Animal {

    public Cat() {
    }

    public Cat(int age, String color) {
        super(age, color);
    }

    //定义猫的特有方法
    public void catMouse(){
        System.out.println("猫在捉老鼠");
    }
}
