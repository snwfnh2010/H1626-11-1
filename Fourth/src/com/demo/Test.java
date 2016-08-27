package com.demo;

import com.biz.StudentBiz;
import com.bizImpl.StudentBizImpl;
import com.model.Student;

import java.util.List;

/**
 * Created by snwfnh on 2016/8/23.
 */
public class Test {
    public static void main(String[] args) {
        StudentBiz sb=new StudentBizImpl();
        Student stu=new Student();
        List<Student> stuList = sb.getAll();
        if (stuList == null)
            System.out.println("没有数据");

        for (Student student : stuList) {
            System.out.println(student.toString());
        }
       /* stu.setAge(17);
        stu.setName("孙二");
        stu.setPhoneNumber("13419559756");
        if(sb.addStudent(stu))
            System.out.println("添加成功");
        else
            System.out.println("添加失败");*/


       /* String mdsql="update student set name='lisi',age=34,phoneNumber=15067447456 where id=2";
        if(sb.modifyStudent(mdsql))
            System.out.println("修改成功");
        else
            System.out.println("修改失败");*/

    }
}
