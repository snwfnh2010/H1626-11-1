package Project1.model.daoImpl;

import Project1.model.Book;
import Project1.model.DBHelp;
import Project1.model.User;
import Project1.model.dao.VisitorDao;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by snwfnh on 2016/8/26.
 */
public class VisitorDaoImpl implements VisitorDao {
    Connection mConnection;
    PreparedStatement mPreparedStatement;
    ResultSet mResultSet;
    List<Book> bookList;
    Book mbook;
    int resultCode;
    User mUser;
    Scanner mScanner;
    int count = 1;

    public VisitorDaoImpl() {
        mConnection = DBHelp.getInstance().getConnection();
        mbook = new Book();

        bookList = new ArrayList<>();
        mScanner = new Scanner(System.in);
    }

    @Override
    public List<Book> showBooks() {

        String sql = "select id,name,count,type,author,discount,haslended from book";
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (mResultSet == null)
            return null;
        try {
            while (mResultSet.next()) {
                Book book = new Book();
                book.setId(mResultSet.getInt("id"));
                book.setName(mResultSet.getString("name"));
                book.setCount(mResultSet.getInt("count"));
                book.setType(mResultSet.getString("type"));
                book.setAuthor(mResultSet.getString("author"));
                book.setDiscount(mResultSet.getInt("discount"));
                book.setHasLended(mResultSet.getInt("haslended"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;

    }

    @Override
    public User login(String name, String password) throws SQLException, MySQLSyntaxErrorException {
        String sql = "select * from user where name=? and password=?";
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setString(Integer.valueOf(1), name);
            mPreparedStatement.setString(Integer.valueOf(2), password);
            mResultSet = mPreparedStatement.executeQuery();
            if (mResultSet.next()) {
                mUser = new User(mResultSet.getInt(1), mResultSet.getString(2),
                        mResultSet.getString(3), mResultSet.getInt(4), mResultSet.getInt(5));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (mUser != null) {
            System.out.println("欢迎回来" + mUser.getName());

        } else {
            System.out.println("用户名或者密码输入错误，请重新输入");


        }




        return mUser;
    }

    @Override
    public void logout() {

    }
}
