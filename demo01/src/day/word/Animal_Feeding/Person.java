package day.word.Animal_Feeding;

public class Person {
    //定义饲养员的属性
    private String name;
    private int age;

    //无参构造
    public Person() {
    }

    //有参构造
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //定义饲养方法
    public void keepPet(String something,Animal a){
        if (a instanceof Dog){
            System.out.println("年龄为" + age + "岁的" + name + "养了一只" + a.getAge() + a.getColor() + "的狗狗,两只前脚死死抱住" + something + "猛吃");
            ((Dog) a).lookHome();
        } else if (a instanceof Cat) {
            System.out.println("年龄为" + age + "岁的" + name + "养了一只" + a.getAge() + a.getColor() + "的猫,眯着眼睛侧头吃" + something);
            ((Cat) a).catMouse();
        }
    }
}
