package Project1.bizImpl;

import Project1.model.Book;
import Project1.model.User;
import Project1.model.dao.VisitorDao;
import Project1.model.daoImpl.IAdminDaoImpl;
import Project1.model.daoImpl.IUserDaoImpl;
import Project1.model.daoImpl.VisitorDaoImpl;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by snwfnh on 2016/8/26.
 */
public class LibSystem {
    VisitorDao mVisitorDao;
    Scanner mScanner;
    List<Book> bookList;
    User mUser;
    IAdminDaoImpl mIAdminDaoImpl;
    Book mBook;
    IUserDaoImpl mIUserDaoImpl;


    public LibSystem() {
         mVisitorDao = new VisitorDaoImpl();
        mScanner=new Scanner(System.in);
        mUser=new User();
        mIAdminDaoImpl=new IAdminDaoImpl();
        mBook=new Book();
        mIUserDaoImpl=new IUserDaoImpl();


    }

    public void init() throws SQLException,InputMismatchException {

        System.out.println("欢迎使用图书馆系统，请选择：");
        System.out.println("*1* 查看图书馆书");
        System.out.println("*2* 登录系统");
        System.out.println("*3* 退出系统");
        try {
            int choose=mScanner.nextInt();

        switch (choose){
            case 1:
                bookList=mVisitorDao.showBooks();
                if(bookList==null)
                    System.out.println("没有图书");
                for(Book book:bookList)
                    System.out.println(book);
                init();
                break;
            case 2:

                mUser=mVisitorDao.login();
                if(mUser.getLevel()==1)
                    manage();
                if(mUser.getLevel()==0)
                    user();
                else
                    init();
                break;
            case 3:
                break;
            default:
                System.out.println("请重新输入");
                init();
                break;
        }  }catch (InputMismatchException i){
            i.printStackTrace();
        }






    }

    public void user() throws SQLException {
        System.out.println(" "+mUser.getName()+"学生，你有如下功能可以使用，请选择：");
        System.out.println("*1* 查看图书信息");
        System.out.println("*2* 借书");
        System.out.println("*3* 还书");
        System.out.println("*4* 预约图书");
        System.out.println("*5* 查看和修改个人信息");
        System.out.println("*6* 评价图书");
        System.out.println("*7* 退出登录");
        int choose=mScanner.nextInt();
        switch (choose){
            case 1:
                bookList=mVisitorDao.showBooks();
                if(bookList==null)
                    System.out.println("没有图书");
                for(Book book:bookList)
                    System.out.println(book);
                user();
                break;
            case 2:
                 mIUserDaoImpl.lendBook(mUser.getId());
                user();
                break;
            case 3:
                mIUserDaoImpl.returnBook();
                user();
                break;
            case 4:
                mIUserDaoImpl.ordBook(mUser.getId());
                user();
                break;
            case 5:
                mIUserDaoImpl.showInfo(mUser.getId());
                user();
                break;
            case 6:
                mIUserDaoImpl.evaluate(mUser.getId());
                user();
                break;
            case 7:
                init();
                break;
            default:
                System.out.println("指令输入错误，请重新输入");
                user();
                break;
        }
    }


    public void manage() throws SQLException {
        System.out.println("管理员，你有如下功能可以使用，请选择：");
        System.out.println("*1* 添加新图书");
        System.out.println("*2* 删除图书");
        System.out.println("*3* 修改图书信息");
        System.out.println("*4* 查看图书信息");
        System.out.println("*5* 注册新用户");
        System.out.println("*6* 删除用户");
        System.out.println("*7* 修改用户信息");
        System.out.println("*8* 查看用户信息");
        System.out.println("*9* 冻结用户帐户");
        System.out.println("*10* 退出登录");

        try {
            int choose=mScanner.nextInt();

        switch (choose){
            case 1:
                mIAdminDaoImpl.addBook();
                manage();
                break;
            case 2:
                mIAdminDaoImpl.deleteBook();
                manage();
                break;
            case 3:
                mIAdminDaoImpl.updateBook();
                manage();
                break;
            case 4:
                mVisitorDao.showBooks();
                manage();
                break;
            case 5:
                mIAdminDaoImpl.addUser();
                manage();
                break;
            case 6:
                mIAdminDaoImpl.deleteUser();
                manage();
                break;
            case 7:
                mIAdminDaoImpl.updateUser();
                manage();
                break;
            case 8:
                mIAdminDaoImpl.showUseInfo();
                manage();
                break;
            case 9:
                mIAdminDaoImpl.frozeUser();
                manage();
                break;
            case 10:
                init();
                break;
            default:
                System.out.println("输入的指令有误，请重新输入");
                manage();
                break;
        }}catch (InputMismatchException e){
            e.printStackTrace();

        }
    }

}
