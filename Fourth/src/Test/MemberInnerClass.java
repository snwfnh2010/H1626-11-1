package Test;

/**
 * Created by snwfnh on 2016/7/30.
 */
public class MemberInnerClass {
    public static void main(String[] args) {
        Outer1 outer1=new Outer1();
       // Test.Outer1.Inner1 inner1=outer1.new Inner1();
        //inner1.inner1Show();
        outer1.outer1Show();

    }
}

class Outer1{
    private String name="zhangsan";
    private int number=10;
    public void outer1Show(){
        System.out.println(name);
        System.out.println(number);
        Inner1 inner1=new Inner1();
        inner1.inner1Show();
    }

    class Inner1{
        private String name="lisi";
        private int number2=20;
        public void inner1Show(){
            System.out.println(Outer1.this.name);
            System.out.println(number);
            System.out.println(name);
            System.out.println(number2);
            //outer1Show();
        }
    }
}