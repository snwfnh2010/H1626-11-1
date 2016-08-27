package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class InterFaceDemo {
    public static void main(String[] args) {
        Person1 p=new Person1();
        Child child=new Child();
        Dog1 dog1=new Dog1();
        p.feed(child);
        p.feed(dog1);

    }
}
interface IBility{
    public abstract void eat();
}
class Person1{
    /*public void feed(Test.Child child){
        child.eat();
    }
    public void feed(Test.Dog1 dog1){
        dog1.eat();
    }*/
     public void feed(IBility ibility){
         ibility.eat();
     }
}
class Child implements IBility{
    public void eat(){
        System.out.println("吃米饭");
    }
}
class Dog1 implements IBility{
    public void eat(){
        System.out.println("啃骨头");
    }
}
