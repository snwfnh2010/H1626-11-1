package Test;

/**
 * Created by snwfnh on 2016/7/30.
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Personn personn=new Personn();
       /* Test.Animal1 dog=new Dogg();
        personn.feed(dog);*/
        new Animal1() {
            @Override
            public void eat() {
                System.out.println("啃骨头");
            }
            public void show(){
                System.out.println("自己的方法");
            }
        }.show();

        personn.feed(new Animal1() {
            @Override
            public void eat() {
                System.out.println("吃鱼肉");
            }
        });


    }
}

abstract class Animal1{
    public abstract void eat();
}

/*class Dogg extends Test.Animal1{
    public void eat(){
        System.out.println("啃骨头");
    }

}*/

class Personn{
    public void feed(Animal1 animal1){
        animal1.eat();

    }
}
