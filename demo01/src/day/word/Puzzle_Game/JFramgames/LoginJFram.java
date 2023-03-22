package day.word.Puzzle_Game.JFramgames;

import javax.swing.*;

public class LoginJFram extends JFrame {
    //表登录界面，所有登录相关代码写到这里
    public LoginJFram(){
        this.setSize(450,400);
        //设置界面标题
        this.setTitle("拼图登录");

        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(3);

        //显示界面
        this.setVisible(true);
    }

}
