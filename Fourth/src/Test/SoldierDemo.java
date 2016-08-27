package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class SoldierDemo {
    public static void main(String[] args) {
        Officer officer=new Officer("陈豪");
        officer.callToAttack();
        System.out.println("*********************");
        officer.callToAttack(officer.getSoldiers()[0]);
        officer.callToAttack(officer);


    }
}

abstract class Soldier{
    private String name;

    public Soldier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void start(){
        System.out.println("准备攻击...");
    }
    public void end(){
        System.out.println("攻击完成...");
    }
    public abstract void attack();
    public void action(){
        start();
        attack();
        end();


    }

}

class LandSoldier extends Soldier{
    public LandSoldier(String name) {
        super(name);
    }
    public void attack(){
        System.out.println(getName()+"使用步枪射击");
    }
}

class OceanSoldier extends Soldier{
    public OceanSoldier(String name) {
        super(name);
    }
    public void attack(){
        System.out.println(getName()+"使用鱼雷攻击");
    }
}

class Officer extends Soldier{
    private Soldier[] soldiers=new Soldier[2];

    public Soldier[] getSoldiers() {
        return soldiers;
    }

    public Officer(String name) {
        super(name);
        soldiers[0]=new LandSoldier("张三");
        soldiers[1]=new OceanSoldier("李四");
    }

    public void attack(){
        System.out.println(getName()+"使用手枪攻击");
    }
    public void callToAttack(){
        for(int i=0;i<soldiers.length;i++){
            soldiers[i].action();
        }
        this.action();

    }
    public void callToAttack(Soldier soldier){
        soldier.action();
    }
}

