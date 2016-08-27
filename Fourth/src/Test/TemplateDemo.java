package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class TemplateDemo {
    public static void main(String[] args) {
        Teacher t1=new DBTeacher();
        t1.work();
        System.out.println("********************");
        Teacher t2=new CTeacher();
        t2.work();

    }
}
abstract class Teacher{
    public void end() {
        System.out.println("关闭投影仪");
        System.out.println("锁好教室");
    }

    public abstract void teaching() ;

    public void prepared() {
        System.out.println("准备好白板笔");
        System.out.println("打开投影仪");
    }
    public void work(){
        prepared();
        teaching();
        end();
    }
}
class DBTeacher extends Teacher{
    public void teaching(){
        System.out.println("打开Oracle");
        System.out.println("书写pl-sql指令");
        System.out.println("优化sql指令");
    }
}
class CTeacher extends Teacher{
    public void teaching(){
        System.out.println("打开VM");
        System.out.println("书写c指令");
        System.out.println("调试c程序");
    }
}

