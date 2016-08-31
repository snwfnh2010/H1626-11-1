package Project1.model.daoImpl;

import Project1.bizImpl.GetTime;
import Project1.model.*;
import Project1.model.dao.IAdminDao;


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
public class IAdminDaoImpl implements IAdminDao {
    Connection mConnection;
    PreparedStatement mPreparedStatement;
    ResultSet mResultSet;
    List<Book> bookList;
    List<User> userList;
    List<LendRecord> lendList;
    List<FrozeRecord> frozeList;
    List<OrdBook> ordList;
    Book mBook;
    User mUser;
    LendRecord mLendRecord;
    FrozeRecord mFrozeRecord;
    OrdBook mOrdBook;
    Scanner mScanner;
    IUserDaoImpl mIUserDaoImpl;
    String sql;

    int resultCode;

    public IAdminDaoImpl() {
        mConnection = DBHelp.getInstance().getConnection();
        mIUserDaoImpl = new IUserDaoImpl();
        mScanner = new Scanner(System.in);
        mBook = new Book();
        mUser = new User();
        mFrozeRecord = new FrozeRecord();
        mLendRecord = new LendRecord();
        mOrdBook = new OrdBook();
        bookList = new ArrayList<>();
        userList = new ArrayList<>();
        frozeList = new ArrayList<>();
        lendList = new ArrayList<>();
        ordList = new ArrayList<>();


    }

    @Override
    public void addBook() {
        mBook = inputBook();
        if (mBook != null) {

            String sql = "insert into book(name,count,type,author)values(?,?,?,?)";
            try {
                mPreparedStatement = mConnection.prepareStatement(sql);
                mPreparedStatement.setString(1, mBook.getName());
                mPreparedStatement.setInt(2, mBook.getCount());
                mPreparedStatement.setString(3, mBook.getType());
                mPreparedStatement.setString(4, mBook.getAuthor());


                resultCode = mPreparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultCode > 0)
            System.out.println("添加成功");
        else
            System.out.println("添加失败");
    }

    public Book inputBook() {

        System.out.println("请输入图书id");
        mBook.setId(mScanner.nextInt());
        System.out.println("请输入图书name");
        mBook.setName(mScanner.next());
        System.out.println("请输入图书count");
        mBook.setCount(mScanner.nextInt());
        System.out.println("请输入图书type");
        mBook.setType(mScanner.next());
        System.out.println("请输入图书author");
        mBook.setAuthor(mScanner.next());
        System.out.println("请输入图书discount");
        mBook.setDiscount(mScanner.nextInt());
        System.out.println("请输入图书haslended");
        mBook.setHasLended(mScanner.nextInt());

        return mBook;
    }

    public User inputUser() {
        System.out.println("请输入用户id");
        mUser.setId(mScanner.nextInt());
        System.out.println("请输入用户name");
        mUser.setName(mScanner.next());
        System.out.println("请输入用户password");
        mUser.setPassword(mScanner.next());
        System.out.println("请输入用户point");
        mUser.setPoint(mScanner.nextInt());
        System.out.println("请输入用户level");
        mUser.setLevel(mScanner.nextInt());

        return mUser;

    }


    @Override
    public void updateBook() {
        mBook = inputBook();
        try {
            if (mIUserDaoImpl.checkid(mBook.getId(), "id", "book")) {

                sql = "update book set name=?, count=?, type=?, author=?,discount=?,haslended=? where id=?";

                mPreparedStatement = mConnection.prepareStatement(sql);
                mPreparedStatement.setString(1, mBook.getName());
                mPreparedStatement.setInt(2, mBook.getCount());
                mPreparedStatement.setString(3, mBook.getType());
                mPreparedStatement.setString(4, mBook.getAuthor());
                mPreparedStatement.setInt(5, mBook.getDiscount());
                mPreparedStatement.setInt(6, mBook.getHasLended());
                mPreparedStatement.setInt(7, mBook.getId());

                resultCode = mPreparedStatement.executeUpdate();


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultCode > 0)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");
    }

    @Override
    public void deleteBook() {
        System.out.println("请输入要删除图书的id");
        int biid = mScanner.nextInt();

        String sql = "delete from bookinfo where id=?";
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, biid);
            resultCode = mPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultCode > 0)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");

    }

    @Override
    public void addUser() {
        mUser = inputUser();
        try {
            if (!mIUserDaoImpl.checkid(mUser.getId(), "id", "user")) {
                sql = "insert into user (id, name, password, point, level) values (?,?,?,?,?)";

                mPreparedStatement = mConnection.prepareStatement(sql);
                mPreparedStatement.setInt(1, mUser.getId());
                mPreparedStatement.setString(2, mUser.getName());
                mPreparedStatement.setString(3, mUser.getPassword());
                mPreparedStatement.setInt(4, mUser.getPoint());
                mPreparedStatement.setInt(5, mUser.getLevel());

                resultCode = mPreparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultCode > 0)
            System.out.println("注册成功");
        else
            System.out.println("注册失败");
    }

    @Override
    public void updateUser() {
        mUser = inputUser();
        try {
            if (mIUserDaoImpl.checkid(mUser.getId(), "id", "user")) {
                sql = "update user set name=?, password=?, point=?, level=? where id=?";
                mPreparedStatement = mConnection.prepareStatement(sql);
                mPreparedStatement.setString(1, mUser.getName());
                mPreparedStatement.setString(2, mUser.getPassword());
                mPreparedStatement.setInt(3, mUser.getPoint());
                mPreparedStatement.setInt(4, mUser.getLevel());
                mPreparedStatement.setInt(5, mUser.getId());
                resultCode = mPreparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultCode > 0)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");


    }

    @Override
    public void deleteUser() {
        System.out.println("请输入要删除用户的id");
        int userId = mScanner.nextInt();
        try {
            if (mIUserDaoImpl.checkid(userId, "id", "user")) {
                String sql = "delete from user where id=?";
                mPreparedStatement = mConnection.prepareStatement(sql);
                mPreparedStatement.setInt(1, userId);
                resultCode = mPreparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultCode > 0)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");


    }

    @Override
    public void showUseInfo() {
        System.out.println("请输入指令查看各种记录");
        System.out.println("*1* 查看用户借还书记录");
        System.out.println("*2* 查看用户预约记录");
        System.out.println("*3* 查看用户冻结记录");
        System.out.println("*4* 查看用户帐户");
        System.out.println("*5* 返回主界面");
        int choose = mScanner.nextInt();
        switch (choose) {
            case 1:
                sql = "select id, uid, biid,bid, lendTime, returnTime from lendrecord ";
                showLend(sql);
                showUseInfo();
                break;
            case 2:
                sql = "select id, uid, bid, ordTime from ordbook ";
                showOrd(sql);
                showUseInfo();
                break;
            case 3:
                sql = "select id, uid, frozenTime, unfrozenTime from frozenrecord";
                showfrozen(sql);
                showUseInfo();
                break;
            case 4:
                sql = "select id, name, point, level from user ";
                showUser(sql);
                showUseInfo();
                break;
            case 5:
                break;
            default:
                System.out.println("指令输入错误，请重新输入");
                showUseInfo();
                break;
        }


    }

    public void showfrozen(String sql) {

        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (mResultSet == null)
            System.out.println("没有记录");
        try {
            while (mResultSet.next()) {
                FrozeRecord froze = new FrozeRecord();
                List<FrozeRecord> frozeList =new ArrayList<>();
                froze.setId(mResultSet.getInt("id"));
                froze.setUid(mResultSet.getInt("uid"));
                froze.setFrozenTime(mResultSet.getString("frozenTime"));
                froze.setUnfrozenTime(mResultSet.getString("unfrozenTime"));
                frozeList.add(froze);
                for (FrozeRecord frozen : frozeList)
                    System.out.println(frozen);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }


    public void showOrd(String sql) {

        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (mResultSet == null)
            System.out.println("没有记录");
        try {
            while (mResultSet.next()) {
                OrdBook ord = new OrdBook();
                List<OrdBook> ordList=new ArrayList<>();
                ord.setId(mResultSet.getInt("id"));
                ord.setBid(mResultSet.getInt("bid"));
                ord.setUid(mResultSet.getInt("uid"));
                ord.setOrdTime(mResultSet.getString("ordTime"));
                ordList.add(ord);
                for (OrdBook ord1 : ordList)
                    System.out.println(ord1);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }


    public void showLend(String sql) {

        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (mResultSet == null)
            System.out.println("没有记录");
        try {
            while (mResultSet.next()) {
                LendRecord lend = new LendRecord();
                List<LendRecord> lendList =new ArrayList<>();
                lend.setId(mResultSet.getInt("id"));
                lend.setUid(mResultSet.getInt("uid"));
                lend.setBiid(mResultSet.getInt("biid"));
                lend.setBiid(mResultSet.getInt("bid"));
                lend.setLendTime(mResultSet.getString("lendTime"));
                lend.setReturnTime(mResultSet.getString("returnTime"));
                lendList.add(lend);
                for (LendRecord lend1 : lendList)
                    System.out.println(lend1);

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }


    public void showUser(String sql) {

        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (mResultSet == null)
            System.out.println("没有记录");
        try {
            while (mResultSet.next()) {
                User user = new User();
                List<User> userList=new ArrayList<>();
                user.setId(mResultSet.getInt("id"));
                user.setName(mResultSet.getString("name"));
                user.setPoint(mResultSet.getInt("point"));
                user.setLevel(mResultSet.getInt("level"));
                userList.add(user);
                for (User user1 : userList)
                    System.out.println(user1);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }


    @Override
    public void frozeUser() {
        System.out.println("请输入要冻结的用户id");
        int id = mScanner.nextInt();
        try {
            if (mIUserDaoImpl.checkid(id, "id", "user")) {
                sql = "insert into frozenrecord (uid,frozenTime,unfrozenTime)values(?,?,?)";
                mPreparedStatement = mConnection.prepareStatement(sql);
                mPreparedStatement.setInt(1, id);
                mPreparedStatement.setString(2, GetTime.getInstance().getCurrTime());
                mPreparedStatement.setString(3, GetTime.getInstance().getAfterTime());
                resultCode = mPreparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultCode > 0)
            System.out.println("冻结成功");
        else
            System.out.println("冻结失败");


    }
}
