package com.model.daoImpl;

import com.model.DBHelp;
import com.model.Student;
import com.model.dao.IStudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by snwfnh on 2016/8/23.
 */
public class IStudentDaoImpl implements IStudentDao {
    Connection mConnection;
    PreparedStatement mPreparedStatement;
    ResultSet mResultSet;
    List<Student> stuList;
    Student stu;
    int resultCode;


    public IStudentDaoImpl() {
        mConnection = DBHelp.getInstance().getConnection();
        stu = new Student();
        stuList=new ArrayList<>();

    }

    @Override
    public boolean addStudent(Student stu) {
        if (stu == null)
            return false;

        String sql = "insert into student(age,name,phoneNumber)values(?,?,?)";
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(Integer.valueOf(1), stu.getAge());
            mPreparedStatement.setString(Integer.valueOf(2), stu.getName());
            mPreparedStatement.setString(Integer.valueOf(3), stu.getPhoneNumber());
            resultCode = mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultCode > 0;
    }

    @Override
    public boolean addStudent(List<Student> stuList) {
        return false;
    }

    @Override
    public int deleteStudent(int stuId) {
        if (stuId != stu.getId())
            resultCode = 0;
        String sql = "delete from student where id=?";
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);

            resultCode = mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCode;
    }

    @Override
    public boolean modifyStudent(String mdSql) {

        try {
            mPreparedStatement = mConnection.prepareStatement(mdSql);

            resultCode = mPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultCode > 0;
    }

    @Override
    public List<Student> getAll() {
        String sql="select id,name,age,phoneNumber from student";
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet=mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(stuList==null)
            return null;
        try {
            while (mResultSet.next()){
                Student stu=new Student();
                stu.setId(mResultSet.getInt("id"));
                stu.setName(mResultSet.getString("name"));
                stu.setAge(mResultSet.getInt("age"));
                stu.setPhoneNumber(mResultSet.getString("phoneNumber"));
                stuList.add(stu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stuList;
    }


}
