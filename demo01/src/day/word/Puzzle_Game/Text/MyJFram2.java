package day.word.Puzzle_Game.Text;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFram2 extends JFrame implements KeyListener {


    public MyJFram2() {
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


        //给整个窗体添加键盘监听
        this.addKeyListener(this);

        //让整个界面显示出来
        this.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开键盘");
        int code = e.getKeyCode();
        System.out.println(code);
    }
}
