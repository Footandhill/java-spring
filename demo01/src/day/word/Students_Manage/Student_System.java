package day.word.Students_Manage;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_System {
    public static void main(String[] args) {
        ArrayList<Students> student = new ArrayList<>();
        Loop: for (; ; ) {
            Students stu_Message = new Students();
            Start();
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose){
                case "1":
                    System.out.println("添加学生");
                    addStudent(stu_Message , student);
                    break;
                case "2":
                    System.out.println("删除学生");
                    deleteStudent(student);
                    break;
                case "3":
                    System.out.println("修改学生");
                    amentStudent(student);
                    break;
                case "4":
                    System.out.println("查询学生");
                    inquiryStudent(student);
                    break;
                case "5":
                    System.out.println("退出系统");
                    break Loop;
                default:
                    System.out.println("没有此选项！");
            }
        }
        System.out.println(student);

    }


    //开始
    public static void Start() {
        System.out.println("--------------欢迎您进入学生管理系统--------------");
        System.out.println("1：添加学生");
        System.out.println("2：删除学生");
        System.out.println("3：修改学生");
        System.out.println("4：查询学生");
        System.out.println("5：退出管理");
        System.out.println("请输入您的选择：");
    }

    //通过id查询学生
    public static void  inquiryStudent(ArrayList<Students> student){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询的学生id：");
        int id = sc.nextInt();
        int s = inquiryId(student,id);
        if (s<0){
            System.out.println("查询id不存在！");
        }else {
            Students a = student.get(s);
            System.out.println(a.getId() + "," + a.getName() + "," + a.getGander() + "," + a.getAddress());
        }
    }

    //通过学生id修改学生信息
    public static void amentStudent(ArrayList<Students> student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的学生id：");
        int amentid = sc.nextInt();
        //创建Students对象
        Students message = new Students();
        int s = inquiryId(student,amentid);
        //判断学生id是否存在，如存在则进行修改操作
        if (s<0){
            System.out.println("id不存在！");
        }else {

            System.out.println("请输入需要添加的学生信息：");

            System.out.println("学生id：");
            int id = sc.nextInt();

            System.out.println("学生姓名：");
            String name = sc.next();

            System.out.println("学生性别");
            char gander = sc.next().charAt(0);

            System.out.println("学生地址：");
            String address = sc.next();

            //将学生信息录入一个对象里
            message.setId(id);
            message.setName(name);
            message.setGander(gander);
            message.setAddress(address);

            //将学生信息进行修改
            Students oldmessage =student.set(amentid, message);
            System.out.println("已将" + oldmessage.getId() + "成功修改为" + message.getId());
            System.out.println("修改成功");
        }
    }

    //通过学生id删除学生信息
    public static void deleteStudent(ArrayList<Students> student){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的学生id：");
        int id = sc.nextInt();
        int s = inquiryId(student,id);
        //判断学生id是否存在，如存在则进行删除操作
        if (s<0){
            System.out.println("id不存在！");
        }else {
            Students stu = student.remove(s);
            System.out.println(stu.getId() + "," + stu.getName() + "," +
                    stu.getGander() + "," + stu.getAddress() + "已删除");
        }
    }

    //添加学生信息，如果id存在则添加失败
    public static void addStudent(Students stu,ArrayList<Students> student){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要添加的学生信息：");

        System.out.println("学生id：");
        int id = sc.nextInt();

        System.out.println("学生姓名：");
        String name = sc.next();

        System.out.println("学生性别");
        char gander = sc.next().charAt(0);

        System.out.println("学生地址：");
        String address = sc.next();

        //判断学生id是否存在，如存在则结束
        boolean flag = inquiryId(student , id) < 0 ? true : false;
        if (flag) {
            stu.setId(id);
            stu.setName(name);
            stu.setGander(gander);
            stu.setAddress(address);

            student.add(stu);

            //Students a = student.get(0);
            //System.out.println(a.getId() + "," + a.getName() + "," + a.getGander() + "," + a.getAddress());
        }else {
            System.out.println("当前id已存在！");
        }

    }

    //查询集合中id是否存在
    public  static int inquiryId(ArrayList<Students> list , int a) {
        int sid ;
        for (int i = 0; i < list.size(); i++) {
            sid = list.get(i).getId();
            if (sid == a ) {
                return i;
            }
        }
        return -1;
    }
}
