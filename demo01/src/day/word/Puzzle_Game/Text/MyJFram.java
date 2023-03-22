package day.word.Puzzle_Game.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFram extends JFrame implements ActionListener {

    //创建一个按钮对象
    JButton jtb1 = new JButton("点我呀");
    //创建一个按钮对象
    JButton jtb2 = new JButton("来点我呀");

    public MyJFram() {
        //设置界面宽高
        this.setSize(650,700);
        //设置界面标题
        this.setTitle("拼图游戏");

        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认居中放置的位置，只有取消了才能按照x，y轴的形式添加主件
        this.setLayout(null);




        //设置按钮宽高
        jtb1.setBounds(0,0,100,50);
       //按钮添加事件
        jtb1.addActionListener(this);

        //设置按钮宽高
        jtb2.setBounds(100,0,100,50);
        //按钮添加事件
        jtb2.addActionListener(this);

        //把按钮添加到界面
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        //让整个界面显示出来
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被操作的按钮事件
        Object source = e.getSource();
        if (source == jtb1) {
            jtb1.setSize(20,20);
        }else if (source == jtb2) {
            Random r = new Random();
            jtb2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }
}
