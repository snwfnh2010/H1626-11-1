package com.model.dao;

import com.model.Student;

import java.util.List;

/**
 * Created by snwfnh on 2016/8/23.
 */
public interface IStudentDao {
    public boolean addStudent(Student stu);
    public boolean addStudent(List<Student> stuList);
    public int deleteStudent(int stuId);
    public boolean modifyStudent(String mdSql);
    public List<Student> getAll();
}
