package Test;

/**
 * Created by snwfnh on 2016/7/30.
 */
public class Demo1 {
    public static void main(String[] args) {
        Son son=new Son();
        son.show();
        son.showInner2();

    }
}

abstract class Parent{
    public abstract void show();
}

interface IShow{
    void show();
}

class Son extends Parent{
    public void show(){
        System.out.println("抽象类中的show方法");

    }

    private class Inner2 implements IShow{
        public void show(){
            System.out.println("接口中的show方法");
        }

    }

    public void showInner2(){
        new Inner2().show();
    }

}