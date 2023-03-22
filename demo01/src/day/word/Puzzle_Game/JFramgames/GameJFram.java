package day.word.Puzzle_Game.JFramgames;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFram extends JFrame implements KeyListener {
    //表游戏界面，所有游戏相关代码写到这里


    //创建一个图片数据的二维数组
    int[][] data = new int[3][3];

    //记录空白方块在二维数组的位置
    int x = 0;
    int y = 0;

    public GameJFram(){
        //初始化界面
        initJFram();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱）
        initData();

        //初始化图片
        initImage();

        //显示界面
        this.setVisible(true);
    }



    private void initData() {
        //定义一个一维数组
        int[] arr = {0,1,2,3,4,5,6,7,8};

        Random r = new Random();
        //随机打乱arr数组
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        //将一维数组里的数遍历到二维数组中
        /*int sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = arr[sum];
                sum ++;
            }
        }
        */
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                x = i/3;
                y = i%3;
            }
            data[i/3][i%3] = arr[i];
        }

    }

    private void initImage() {

        //清除已经出现的所有图片
        this.getContentPane().removeAll();

        //int num = 0;
        //外循环，把内循环循环3次
        for (int i = 0; i < 3; i++) {
            //内循环，把一行添加3张图片
            for (int j = 0; j < 3; j++) {
                //获取当前要加载图片的序号
                int num = data[i][j];

                //创建一个图片ImageIcon对象
                ImageIcon icon = new ImageIcon("C:\\Users\\郭英杰\\Pictures\\Camera Roll\\拼图\\"+ num +".png");

                //创建一个JLable的对象（容器管理）
                JLabel jlabel = new JLabel(icon);

                //指定图片位置
                jlabel.setBounds(40*i + 83,71*j + 134,40,71);

                //给图片添加边框
                jlabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                //把管理容器添加到界面中
                this.getContentPane().add(jlabel);

                //num++;
            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\郭英杰\\Pictures\\Camera Roll\\拼图\\R-C.png"));
        background.setBounds(40,40,508,380);
        //添加到界面
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();

    }


    private void initJMenuBar() {
        //创建整个菜单对象
        JMenuBar jmenubar = new JMenuBar();

        //创建菜单上的两个选项
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建选项下的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reloginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        //将每一个选项下的条目放在每个功能下
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里面的选项添加在菜单里
        jmenubar.add(functionJMenu);
        jmenubar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jmenubar);
    }

    private void initJFram() {
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

        //给整个界面添加键盘监听事件
        this.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == 65) {

            //把界面所有图片删除
            this.getContentPane().removeAll();
            //加载第一张完整图片
            JLabel all = new JLabel(new ImageIcon("C:\\Users\\郭英杰\\Pictures\\Camera Roll\\拼图\\all.png"));
            all.setBounds(83,134,40,71);
            this.getContentPane().add(all);

            //添加背景图片
            JLabel background = new JLabel(new ImageIcon("C:\\Users\\郭英杰\\Pictures\\Camera Roll\\拼图\\R-C.png"));
            background.setBounds(40,40,508,380);
            //添加到界面
            this.getContentPane().add(background);
            //刷新
            this.getContentPane().repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //对上、下、左、右进行判断
        //上下左右：37、38、39、40
        int code = e.getKeyCode();
        if (code == 37) {
            System.out.println("左");
            //表示空白已经到最左方了，不能移动
            if (y == 2) {
                return;
            }
            //把空白方块右方的数字赋值给空白方块
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            //调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 38) {
            System.out.println("上");
            //表示空白已经到最上方了，不能移动
            if (x == 2) {
                return;
            }
            //把空白方块下方的数字赋值给空白方块
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            //调用方法按照最新的数字加载图片
            initImage();

        } else if (code == 39) {
            System.out.println("右");
            //表示空白已经到最右方了，不能移动
            if (y == 0) {
                return;
            }
            //把空白方块左方的数字赋值给空白方块
            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
            //调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 40) {
            System.out.println("下");
            //表示空白已经到最下方了，不能移动
            if (x == 0) {
                return;
            }
            //把空白方块上方的数字赋值给空白方块
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            //调用方法按照最新的数字加载图片
            initImage();
        }
        if (code == 65) {
            initImage();
        }
    }
}
