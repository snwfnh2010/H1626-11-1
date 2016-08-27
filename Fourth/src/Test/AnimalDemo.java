package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class AnimalDemo {
    public static void main(String[] args) {
        Animal animal1=new Dog("旺财");
        Animal animal2=new Cat("招财猫");
        animal1.eat();
        animal2.eat();
        if(animal2 instanceof Cat){
            System.out.println("aa");
            Cat cat=(Cat)animal2;
            cat.sleep();
        }else {
            System.out.println("向下转型是不安全的");
        }

    }
}
class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    public void eat(){

    }
}
class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }
    public void eat(){
        System.out.println("啃骨头。");

    }
}
class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    public void eat(){
        System.out.println("吃鱼肉。");

    }
    public void sleep(){
        System.out.println("睡觉。");

    }
}
