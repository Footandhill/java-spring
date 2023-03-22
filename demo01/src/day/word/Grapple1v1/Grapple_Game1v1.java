package day.word.Grapple1v1;

public class Grapple_Game1v1 {
    public static void main(String[] args){
        //定义两个新角色
        Role r1 = new Role("a",120,'男');
        Role r2 = new Role("a",100,'女');

        r1.showRoleInfo();
        r2.showRoleInfo();
        //循环进攻，每人打一次
        while(true){
            //攻击
            r1.attack(r2);
            if(r2.getBoold() == 0){
                System.out.println(r1.getUsername() + "win");
                break;
            }
            r2.attack(r1);
            if (r1.getBoold() == 0) {
                System.out.println(r2.getUsername() + "win");
                break;
            }
        }
    }
}
