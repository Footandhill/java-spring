package day.Bean_ShortcureKey;

/**
 * 快捷键：
 * alt + insert   或   alt + fn + insert
 *
 *插件：PTG ：1秒生成标准JavaBean
 * 右键选择FTG to JavaBean
 *
 */
public class User {
    //属性
    private String username;
    private String pwd;
    private int age;
    private String e_mail;
    private String gander;

    public User() {
    }

    public User(String username, String pwd, int age, String e_mail, String gander) {
        this.username = username;
        this.pwd = pwd;
        this.age = age;
        this.e_mail = e_mail;
        this.gander = gander;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return e_mail
     */
    public String getE_mail() {
        return e_mail;
    }

    /**
     * 设置
     * @param e_mail
     */
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    /**
     * 获取
     * @return gander
     */
    public String getGander() {
        return gander;
    }

    /**
     * 设置
     * @param gander
     */
    public void setGander(String gander) {
        this.gander = gander;
    }

    public String toString() {
        return "User{username = " + username + ", pwd = " + pwd + ", age = " + age + ", e_mail = " + e_mail + ", gander = " + gander + "}";
    }
/*
    public User() {
    }

    public User(String username, String pwd, int age, String e_mail, String gander) {
        this.username = username;
        this.pwd = pwd;
        this.age = age;
        this.e_mail = e_mail;
        this.gander = gander;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }
    */


}
