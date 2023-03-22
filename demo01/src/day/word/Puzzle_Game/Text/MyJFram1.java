package day.word.Puzzle_Game.Text;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFram1 extends JFrame implements MouseListener {
    //创建一个按钮对象
    JButton jtb1 = new JButton("点我呀");

    public MyJFram1() {
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
        //按钮绑定鼠标事件
        jtb1.addMouseListener(this);

        //把按钮添加到界面
        this.getContentPane().add(jtb1);

        //让整个界面显示出来
        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
