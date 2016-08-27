package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class PersonDemo {
    public static void main(String[] args) {
        Students stu = new Students("Jack", 20, 85);
        stu.eat();
        stu.walk();
        stu.goSchool();
        stu.exam();
        System.out.println(stu);


    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("I'm eating");
    }

    public void walk() {
        System.out.println("I'm walking");
    }

    @Override
    public String toString() {
        return
                "name=" + name +
                        ", age=" + age;
    }
}

class Students extends Person {
    private int score;

    public Students(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public void goSchool() {
        System.out.println("I'm going school");
    }

    public void exam() {
        System.out.println("I'm taking exam");
    }

    @Override
    public String toString() {
        return super.toString() + ", score=" + score;

    }
}
