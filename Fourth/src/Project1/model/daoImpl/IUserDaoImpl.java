package Project1.model.daoImpl;

import Project1.bizImpl.GetTime;
import Project1.model.*;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class IUserDaoImpl {
    Connection mConnection;
    PreparedStatement mPreparedStatement;
    ResultSet mResultSet;
    List<BookInfo> bookInfoList;
    List<User> userList;
    List<LendRecord> lendRecordList;
    List<Book> bookList;
    List<EvaluateRecord> evaluateRecordList;
    List<OrdBook> ordBookList;
    List<FrozeRecord> frozeRecordList;
    Book mbook;
    BookInfo mBookInfo;
    int resultCode;
    User mUser;
    EvaluateRecord mEvaluateRecord;
    LendRecord mLendRecord;
    OrdBook mOrdBook;
    FrozeRecord mFrozeRecord;
    Scanner mScanner;
    int biid;
    int bid;
    String sql;
    String title;
    String title_id;

    public IUserDaoImpl() {
        mConnection = DBHelp.getInstance().getConnection();
        mbook = new Book();
        mBookInfo = new BookInfo();
        mUser = new User();
        mEvaluateRecord = new EvaluateRecord();
        mLendRecord = new LendRecord();
        mOrdBook = new OrdBook();
        mFrozeRecord = new FrozeRecord();
        frozeRecordList = new ArrayList<>();
        bookList = new ArrayList<>();
        bookInfoList = new ArrayList<>();
        userList = new ArrayList<>();
        evaluateRecordList = new ArrayList<>();
        lendRecordList = new ArrayList<>();
        ordBookList = new ArrayList<>();
        mScanner = new Scanner(System.in);

    }

    public boolean checkFrozen(int uid) {
        sql = "select id, uid, frozenTime, unfrozenTime from frozenrecord where uid=?";
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, uid);
            mResultSet = mPreparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (mResultSet.next())
                resultCode = 1;
            else
                resultCode = 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultCode > 0;
    }

    public void lendBook(int uid) throws SQLException {

        System.out.println("请输入要借的图书书本id");
        biid = mScanner.nextInt();
        mBookInfo.setId(biid);
        title = "bookinfo";
        title_id = "id";
        if(!checkFrozen(uid)){
        if (checkid(biid, title_id, title)) {

            sql = "insert into lendrecord (uid,biid,lendTime,returnTime) values (?,?,?,?)";

            try {
                mPreparedStatement = mConnection.prepareStatement(sql);
                mPreparedStatement.setInt(1, uid);
                mPreparedStatement.setInt(2, mBookInfo.getId());
                mPreparedStatement.setString(3, GetTime.getInstance().getCurrTime());
                mPreparedStatement.setString(4, GetTime.getInstance().getAfterTime());
                resultCode = mPreparedStatement.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        } if (resultCode > 0)
            System.out.println("借书成功");
        else
            System.out.println("借书失败");
        }else
            System.out.println("帐号被冻结，不能借书");
    }


    public void returnBook() throws SQLException {
        System.out.println("请输入所还书书本的id号：");
        biid = mScanner.nextInt();
        title = "lendrecord";
        title_id = "biid";
        if (checkid(bid, title_id, title)) {
            sql = "update lendrecord set returnTime=? where biid=?";
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setString(1, GetTime.getInstance().getCurrTime());
            mPreparedStatement.setInt(2, biid);
            resultCode = mPreparedStatement.executeUpdate();
            if (resultCode > 0)
                System.out.println("还书成功");
        } else
            System.out.println("还书失败");
    }


    public void ordBook(int uid) throws SQLException {
        System.out.println("请输入要预约的图书表id");
        bid = mScanner.nextInt();
        title = "book";
        title_id = "id";
        if (checkid(bid, title_id, title)) {
            sql = "insert into ordbook (uid,bid,ordTime) values (?,?,?)";
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, uid);
            mPreparedStatement.setInt(2, bid);
            mPreparedStatement.setString(3, GetTime.getInstance().getCurrTime());
            resultCode = mPreparedStatement.executeUpdate();
            if (resultCode > 0)
                System.out.println("预约成功");

        } else
            System.out.println("预约失败，图书馆没有此书 ");


    }


    public void evaluate(int uid) throws SQLException {
        System.out.println("请输入要评价的图书书表id");
        bid = mScanner.nextInt();
        title = "book";
        title_id = "id";
        if (checkid(bid, title_id, title)) {

            sql = "insert into evaluaterecord (uid,bid,content,conTime) values (?,?,?,?)";
            System.out.println("请输入评价的内容");
            String content;
            content = mScanner.next();


            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, uid);
            mPreparedStatement.setInt(2, bid);
            mPreparedStatement.setString(3, content);
            mPreparedStatement.setString(4, GetTime.getInstance().getCurrTime());
            resultCode = mPreparedStatement.executeUpdate();

            if (resultCode > 0)
                System.out.println("评价成功");
            ;
        } else
            System.out.println("查不到你所输入的图书书表信息");
    }

    public boolean checkid(int bid, String str1, String str2) throws SQLException {
        sql = "select id from book where id=?";
        sql = sql.replace("id", str1);
        sql = sql.replace("book", str2);
        mPreparedStatement = mConnection.prepareStatement(sql);
        mPreparedStatement.setInt(1, bid);
        mResultSet = mPreparedStatement.executeQuery();
        if (mResultSet.next())
            resultCode = 1;
        else
            resultCode = 0;
        return resultCode > 0;
    }

    public void showInfo(int useId) {
        System.out.println("请输入指令查看或修改个人信息");
        System.out.println("*1* 查看个人信息");
        System.out.println("*2* 查看个人借还书记录");
        System.out.println("*3* 查看书本评价信息");
        System.out.println("*4* 修改登录密码");

        int choose = mScanner.nextInt();
        switch (choose) {
            case 1:
                sql = "select id,name,level from user where id=?";
                sql = sql.replace("?", "" + useId);
                showUser(sql);
                break;
            case 2:
                sql = "select id, uid, biid, lendTime, returnTime from lendrecord where id=?";
                sql = sql.replace("?", "" + useId);
                showLendRecord(sql);
                break;
            case 3:
                sql = "select id, uid, bid, content, conTime from evaluaterecord";
                showEvaluate(sql);
                break;
            case 4:
                updatePwd(useId);
                break;
            default:
                break;
        }


    }


    public void showUser(String sql) {
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(mResultSet==null)
            System.out.println("没有记录");
        try {
            while (mResultSet.next()) {


                mUser.setId(mResultSet.getInt("id"));
                mUser.setName(mResultSet.getString("name"));
                mUser.setLevel(mResultSet.getInt("level"));
                userList.add(mUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (User user : userList) {
            System.out.println(user);
        }
    }


    public void showLendRecord(String sql) {
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(mResultSet==null)
            System.out.println("没有记录");
        try {
           if (mResultSet.next()) {
                mLendRecord.setId(mResultSet.getInt("id"));
                mLendRecord.setUid(mResultSet.getInt("uid"));
                mLendRecord.setBiid(mResultSet.getInt("biid"));
                mLendRecord.setLendTime(mResultSet.getString("lendTime"));
                mLendRecord.setReturnTime(mResultSet.getString("returnTime"));
                lendRecordList.add(mLendRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (LendRecord lendRecord : lendRecordList)
            System.out.println(lendRecord);
    }

    public void showEvaluate(String sql) {
        try {
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(mResultSet==null)
            System.out.println("没有此记录");
        try {
            while (mResultSet.next()) {
                EvaluateRecord evaluate=new EvaluateRecord();
                evaluate.setId(mResultSet.getInt("id"));
                evaluate.setUid(mResultSet.getInt("uid"));
                evaluate.setBid(mResultSet.getInt("bid"));
                evaluate.setContent(mResultSet.getString("content"));
                evaluate.setConTime(mResultSet.getString("conTime"));
                evaluateRecordList.add(evaluate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (EvaluateRecord evaluateRecord : evaluateRecordList)
            System.out.println(evaluateRecord);
    }

    public void updatePwd(int useId) {
        System.out.println("请输入新密码");
        String st1 = mScanner.next();
        String st2 = mScanner.next();
        if (!st1.equals(st2)) {
            System.out.println("两次输入的密码不相同，请重新输入");
            updatePwd(useId);
        } else {
            sql = "update user set password=? where id=?";

            try {
                mPreparedStatement = mConnection.prepareStatement(sql);
                mPreparedStatement.setString(1, st1);
                mPreparedStatement.setInt(2, useId);
                resultCode = mPreparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (resultCode > 0)
            System.out.println("密码修改成功");
        else
            System.out.println("密码修改失败");

    }
}
