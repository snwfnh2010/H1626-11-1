package com.biz;

import com.model.Student;

import java.util.List;

/**
 * Created by snwfnh on 2016/8/23.
 */
public interface StudentBiz {
    public boolean addStudent(Student stu);
    public int deleteStudent(int stuId);
    public boolean modifyStudent(String mdSql);
    public List<Student> getAll();
}
