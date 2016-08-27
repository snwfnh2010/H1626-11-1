package Project1.model.daoImpl;

import Project1.bizImpl.GetTime;
import Project1.model.Book;
import Project1.model.DBHelp;
import Project1.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class IUserDaoImpl  {
    Connection mConnection;
    PreparedStatement mPreparedStatement;
    ResultSet mResultSet;
    List<Book> bookList;
    Book mbook;
    int resultCode;
    User mUser;

    public IUserDaoImpl() {
        mConnection= DBHelp.getInstance().getConnection();
        mbook=new Book();
        mUser=new User();
        bookList=new ArrayList<>();

    }





    public boolean lendBook(String sql) {
        String string="insert into lendrecord (uid,biid,lendTime,returnTime) values (?,?,"+
                GetTime.getInstance().getCurrTime()+","+
                GetTime.getInstance().getAfterTime()+")";

        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1,mUser.getId());
            mPreparedStatement.setInt(2,mbook.getId());
           resultCode= mPreparedStatement.executeUpdate(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCode>0;
    }


    public boolean returnBook(String sql) {




        return false;
    }


    public boolean ordBook(String string) {
        String sql="insert into ordbook (uid,bid,ordTime) values (?,?,"+
                GetTime.getInstance().getCurrTime()+")";

        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1,mUser.getId());
            mPreparedStatement.setInt(2,mbook.getId());
            resultCode= mPreparedStatement.executeUpdate(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCode>0;

    }


    public boolean evaluate(String string) {
        String sql="insert into evaluaterecord (uid,content,conTime) values (?,?,"+
                GetTime.getInstance().getCurrTime()+")";
        String content;

        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1,mUser.getId());
            mPreparedStatement.setInt(2,mbook.getId());
            resultCode= mPreparedStatement.executeUpdate(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCode>0;

    }


}
