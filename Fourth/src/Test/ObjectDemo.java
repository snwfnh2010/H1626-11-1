package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class ObjectDemo {
    public static void main(String[] args) {
        Student1 stu=new Student1("jack",15);
        System.out.println(stu.toString());
        Student1 stu2=new Student1("jack",15);
        System.out.println(stu.equals(stu2));

    }
}

class Student1{
    private String name;
    private  int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age=" + age;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student1 student1 = (Student1) o;

        if (age != student1.age) return false;
        return name != null ? name.equals(student1.name) : student1.name == null;

    }


}
