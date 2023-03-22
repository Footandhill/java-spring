package day.word.Puzzle_Game.JFramgames;

import javax.swing.*;

public class RegisterJFram extends JFrame {
    //表注册界面，所有注册相关代码写到这里
    public RegisterJFram(){
        this.setSize(500,450);

        //设置界面标题
        this.setTitle("拼图注册");

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
