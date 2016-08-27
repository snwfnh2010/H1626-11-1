package Test;

import java.util.Arrays;

public class Student{
    private int id;
    private String name;
    private  int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student() {
    }

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Test.Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
    public static void printStu(Student[] stuArry){
        for(Student stu:stuArry){
            System.out.println(stu);
        }

    }

    public static void sortStu(Student[] stu){
        Student temp=new Student();
        for(int i=0;i<stu.length-1;i++){
            for (int j=0;j<stu.length-i-1;j++){
                if(stu[j].getId()<stu[j+1].getId()){
                    temp=stu[j+1];
                    stu[j+1]=stu[j];
                    stu[j]=temp;
                }


            }


        }
        printStu(stu);

    }
    public static void sortStu1(Student[] stu){
        Student temp=new Student();
        for(int i=0;i<stu.length-1;i++){
            for (int j=0;j<stu.length-i-1;j++){
                if(stu[j].getScore()>stu[j+1].getScore()){
                    temp=stu[j];
                    stu[j]=stu[j+1];
                    stu[j+1]=temp;
                }


            }


        }printStu(stu);
    }
    public static void addSort(Student[] stuArray,Student stu){
        Student[] setStu= Arrays.copyOf(stuArray,stuArray.length+1);
        setStu[setStu.length-1]=stu;
        sortStu(setStu);
        /*Arrays.sort(setStu, new Comparator<Test.Student>() {
            @Override
            public int compare(Test.Student o1, Test.Student o2) {
                if(o1.getId()==o2.getId())
                return 0;
                else if(o1.getId()>o2.getId())
                    return -1;
                else
                    return 1;
            }
        });
        for (Test.Student stu1:setStu){
            System.out.println(stu1);;
        }*/
    }

    public static void main(String[] args) {
        Student[] stuArray=new Student[3];
        stuArray[0]=new Student(1,"小明",80);
        stuArray[1]=new Student(2,"李雷",75);
        stuArray[2]=new Student(3,"韩梅梅",90);
        Student student1=new Student(4,"张三",80);
        Student student2=new Student(5,"lisi",60);
       // printStu(stuArray);
        sortStu(stuArray);
        sortStu1(stuArray);
        addSort(stuArray,student1);
        addSort(stuArray,student2);


    }
}