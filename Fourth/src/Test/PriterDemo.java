package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class PriterDemo {
    public static void main(String[] args) {
        ColorPrinter cp = new ColorPrinter("Hp");
        BlackPrinter bp=new BlackPrinter("dell");
        School school = new School();
        Teacher1 t=new Teacher1("zhansan",30);
        school.print(t);


    }

}
interface IInfor{

     String detail();
}
 class Teacher1 implements IInfor{
    private String name;
    private int age;

    public Teacher1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String detail(){
        return "你好，我的名字叫"+name+",今年："+age+"岁";

    }
}

class Printer {
    private String brand;

    public Printer(String brand) {
        this.brand = brand;
    }

    public void print(String content) {
    }

    public String getBrand() {
        return brand;
    }
}


 class School implements IInfor{
    private Printer p=null;

    public void setPrinter(Printer p) {
        this.p = p;
    }

    public void print(IInfor infor) {
        p.print(infor.detail());
    }
    public String detail(){
        return "Hello,我是海同科技有限公司";

    }
}

class ColorPrinter extends Printer {
    public ColorPrinter(String brand) {
        super(brand);
    }

    public void print(String content) {
        System.out.println(getBrand() + "彩色打印：" + content);

    }
}

class BlackPrinter extends Printer {
    public BlackPrinter(String brand) {
        super(brand);
    }

    public void print(String content) {
        System.out.println(getBrand() + "黑白打印：" + content);

    }
}

