package day.word.Animal_Feeding;

public class Feeddemo {
    public static void main(String[] args) {
        Person p1 = new Person("老王",23);
        Dog d = new Dog(2,"绿色");
        p1.keepPet("骨头",d);

        Person p2 =new Person("老白",18);
        Cat c = new Cat(3,"黄色");
        p2.keepPet("鱼",c);
    }
}
