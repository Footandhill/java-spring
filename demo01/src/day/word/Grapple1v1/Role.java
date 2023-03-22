package day.word.Grapple1v1;

import java.util.Random;

public class Role {
    //定义角色属性
    private String username;
    private int boold;
    private char gender;
    private String face;

    //定义长相
    String[] boyface = {"沉鱼落雁","闭月羞花","倾国倾城","相貌平平"};
    String[] girlface = {"阳光帅气","相貌英俊","气宇轩昂","相貌平平"};



    //无参构造
    public Role() {
    }
    //有参构造
    public Role(String username, int boold, char gender) {
        this.username = username;
        this.boold = boold;
        this.gender = gender;
        setFace(gender);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public int getBoold() {
        return boold;
    }

    public void setBoold(int boold) {
        this.boold = boold;
    }

    /**
     * 获取gender
     * @return gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * 设置gender
     * @param gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * 获取face
     * @return face
     */
    public String getFace() {
        return face;
    }

    /**
     * 设置face
     * @param gender
     */
    public void setFace(char gender) {
        Random r = new Random();
        if (gender == '男') {
            int y = r.nextInt(boyface.length);
            this.face = boyface[y];
        } else if (gender == '女') {
            int x = r.nextInt(girlface.length);
            this.face = girlface[x];
        }else {
            this.face = "难以形容";
        }

    }

    public void attack(Role role) {
        //在10点伤害的基础上随机发生造成额外暴击的伤害值
        Random r = new Random();
        int attack =(int) (10 + (Math.random()*(10)));
        //剩余的血量
        int remainboold = (int) (role.getBoold() - attack);
        //当血量小于0时得到剩余血量值为0
        remainboold = remainboold < 0 ? 0 : remainboold;
        //输入剩余血量值
        role.setBoold(remainboold);
        //输出打斗的过程
        System.out.println(this.getUsername()+"举起大刀砍了" + role.getUsername() + "一下，造成了"
                +attack+ "点伤害，"+ role.getUsername()+"剩余" + remainboold + "点血");
    }

    public void showRoleInfo(){
        System.out.println("姓名：" + getUsername());
        System.out.println("血量：" + getBoold());
        System.out.println("性别：" + getGender());
        System.out.println("长相：" + getFace());
    }


}
