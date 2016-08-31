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
import java.util.InputMismatchException;
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


    public VisitorDaoImpl() {
        mConnection = DBHelp.getInstance().getConnection();
        mbook = new Book();

        bookList = new ArrayList<>();
        mScanner = new Scanner(System.in);
    }

    @Override
    public void showBooks()  {
        String sql=null;
        String string=null;
        System.out.println("请选择查看全部书或者根据书名来查找");
        System.out.println("*1* 查看全部书");
        System.out.println("*2* 根据书名来查找");
        System.out.println("*3* 根据类型来查找");
        int choose=mScanner.nextInt();
        switch (choose){
            case 1:
                sql = "select id,name,count,type,author,discount,haslended from book";
                break;
            case 2:
                sql="select id,name,count,type,author,discount,haslended from book where name like '%#%'";
                System.out.println("请输入要查找的书名");
                string=mScanner.next();
                sql=sql.replace("#",string);
                break;
            case 3:
                sql="select id,name,count,type,author,discount,haslended from book where type like '%#%'";
                System.out.println("请输入要查找的类型");
                string=mScanner.next();
                sql=sql.replace("#",string);
                break;
            default:
                System.out.println("输入的指令有误，请重新输入");
                showBooks();
                break;
        }
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (mResultSet == null)
            System.out.println("查不到结果");
        try {
           while (mResultSet.next()) {
               List<Book> bookList1=new ArrayList<>();
                Book mBook=new Book(mResultSet.getInt(1),mResultSet.getString(2),
                        mResultSet.getInt(3),mResultSet.getString(4),mResultSet.getString(5),
                        mResultSet.getInt(6),mResultSet.getInt(7));
                bookList1.add(mBook);
               for(Book book:bookList1)
                   System.out.println(book);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


    @Override
    public User login() {
        for(int i=1;i<=3;i++){
            System.out.println("用户名：");
            String name=mScanner.next();
            System.out.println("密码：");
            String password=mScanner.next();
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
                break;

            } else if(i<3){
                System.out.println("用户名或者密码输入错误，请重新输入");
            }else if(i==3){
                System.out.println("请下次输入或者联系管理员");
                System.out.println("请在90秒后重试");
                try {
                    Thread.sleep(90000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return mUser;
    }



}
