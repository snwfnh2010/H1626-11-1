package Project1.model.daoImpl;

import Project1.bizImpl.GetTime;
import Project1.model.Book;
import Project1.model.DBHelp;
import Project1.model.User;
import Project1.model.dao.IAdminDao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by snwfnh on 2016/8/26.
 */
public class IAdminDaoImpl implements IAdminDao {
    Connection mConnection;
    PreparedStatement mPreparedStatement;
    ResultSet mResultSet;
    List<Book> bookList;
    List<User> userList;
    Book mBook;
    User mUser;
    int resultCode;

    public IAdminDaoImpl() {
        mConnection = DBHelp.getInstance().getConnection();
        mBook=new Book();
        mUser=new User();
        bookList=new ArrayList<>();
        userList=new ArrayList<>();


    }

    @Override
    public boolean addBook(Book book) {
        if(book==null)
            return false;
        String sql="insert into book(name,count,type,author)values(?,?,?,?)";
        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            mPreparedStatement.setString(Integer.valueOf(1),book.getName());
            mPreparedStatement.setInt(Integer.valueOf(2),book.getCount());
            mPreparedStatement.setString(Integer.valueOf(3),book.getType());
            mPreparedStatement.setString(Integer.valueOf(4),book.getAuthor());
            resultCode=mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCode>0;
    }

    @Override
    public boolean updateBook(String sql) {
        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            resultCode=mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCode>0;
    }

    @Override
    public boolean deleteBook(int bookId) {
        if(bookId!=mBook.getId())
            resultCode=0;
        String sql="delete from book where id=?";
        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1,bookId);
            resultCode=mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultCode>0;
    }

    @Override
    public boolean addUser(String sql) {
        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            resultCode=mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultCode>0;
    }

    @Override
    public boolean updateUser(String sql) {

        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            resultCode=mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCode>0;
    }

    @Override
    public boolean deleteUser(int userId) {
        if(userId!=mUser.getId())
            resultCode=0;
        String sql="delete from user where id=?";
        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1,userId);
            resultCode=mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCode>0;
    }

    @Override
    public List<User> showUser() {
        String sql="select id,name,point,level from user";
        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            mResultSet=mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(mResultSet==null)
            return null;
        try {
            while (mResultSet.next()){
                mUser.setId(mResultSet.getInt("id"));
                mUser.setName(mResultSet.getString("name"));
                mUser.setPoint(mResultSet.getInt("point"));
                mUser.setLevel(mResultSet.getInt("level"));
                userList.add(mUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    @Override
    public boolean frozeUser(User user) {
        if(user==null)
            return false;
        String sql = "insert into frozenrecord (uid,frozenTime,unfrozenTime)values(?,"+
                GetTime.getInstance().getCurrTime()+","+
                GetTime.getInstance().getAfterTime()+")";
        try {
            mPreparedStatement=mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1,user.getId());
            resultCode=mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCode>0;


    }
}
