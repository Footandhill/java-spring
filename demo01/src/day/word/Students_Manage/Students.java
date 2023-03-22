package day.word.Students_Manage;

public class Students {
    //定义学生属性
    private int id;
    private String name;
    private char gander;
    private String address;

    //无参构造
    public Students() {
    }

    //有参构造
    public Students(int id, String name, char gander, String address) {
        this.id = id;
        this.name = name;
        this.gander = gander;
        this.address = address;
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

    public char getGander() {
        return gander;
    }

    public void setGander(char gander) {
        this.gander = gander;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
