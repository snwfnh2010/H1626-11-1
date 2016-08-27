package Test;

/**
 * Created by snwfnh on 2016/7/31.
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer3 outer3=new Outer3();
        outer3.showOuter();

    }
}

class Outer3{
    private String name="zhangsan";
    private int number1=10;
    private static int number2=20;
    public void showOuter(){
        final int number3=30;
        class Inner3{
            private int number4=40;
            private int number5=50;
           public void showInner(){
               System.out.println(number4);
               System.out.println(number5);
               System.out.println(number3);
               System.out.println(Outer3.number2);
               System.out.println(Outer3.this.number1);


           }

        }
        Inner3 inner3=new Inner3();
        inner3.showInner();
    }

}
