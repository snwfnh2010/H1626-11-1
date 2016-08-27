package com.bizImpl;

import com.biz.StudentBiz;
import com.model.Student;
import com.model.dao.IStudentDao;
import com.model.daoImpl.IStudentDaoImpl;

import java.util.List;

/**
 * Created by snwfnh on 2016/8/23.
 */
public class StudentBizImpl implements StudentBiz {
    IStudentDao mIStudentDao;

    public StudentBizImpl() {
        mIStudentDao=new IStudentDaoImpl();
    }

    @Override
    public boolean addStudent(Student stu) {
        return mIStudentDao.addStudent(stu);
    }

    @Override
    public int deleteStudent(int stuId) {
        return mIStudentDao.deleteStudent(stuId);
    }
    public boolean modifyStudent(String mdSql){
        return mIStudentDao.modifyStudent(mdSql);
    }

    @Override
    public List<Student> getAll() {
        return mIStudentDao.getAll();
    }
}
