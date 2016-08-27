package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class EmployeeDemo {
    public static void main(String[] args) {
        JavaTeacher teacher=new JavaTeacher(1,"zhangsan",2000);
        teacher.work();
        Leader leader=new Leader(2,"lisi",3000,10000);
        leader.work();

    }
}
abstract class Employee{
    private int number;
    private String name;
    private double salary;

    public Employee(int number, String name, double salary) {
        this.number = number;
        this.name = name;
        this.salary = salary;
    }

    public abstract void work();
}
//一旦一个类继承了抽象类，那么这个类要么实现抽象类中的抽象方法，要么继续抽象下去。
class JavaTeacher extends Employee{
    public JavaTeacher(int number, String name, double salary) {
        super(number, name, salary);
    }
    public  void work(){
        System.out.println("上java课");
    }
}
class Leader extends Employee{
    private double allowance;

    public Leader(int number, String name, double salary, double allowance) {
        super(number, name, salary);
        this.allowance = allowance;
    }
    public  void work(){
        System.out.println("培训新员工");
        System.out.println("设计课程体系");
    }
}
