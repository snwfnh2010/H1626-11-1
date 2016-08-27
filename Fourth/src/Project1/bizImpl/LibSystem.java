package Project1.bizImpl;

import Project1.model.Book;
import Project1.model.User;
import Project1.model.dao.VisitorDao;
import Project1.model.daoImpl.IAdminDaoImpl;
import Project1.model.daoImpl.VisitorDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
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
    int bookId;


    public LibSystem() {
         mVisitorDao = new VisitorDaoImpl();
        mScanner=new Scanner(System.in);
        mUser=new User();
        mIAdminDaoImpl=new IAdminDaoImpl();
        mBook=new Book();


    }

    public void init() throws SQLException {
        mVisitorDao.showBooks();
        System.out.println("欢迎使用图书馆系统，请选择：1--查看图书馆书，2--登录系统");
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
                System.out.println("用户名：");
                String name=mScanner.next();
                System.out.println("密码：");
                String password=mScanner.next();
                mUser=mVisitorDao.login(name,password);
                if(mUser.getLevel()==1)
                    manage();

                break;
            default:
                System.out.println("请重新输入");
                init();
                break;
        }






    }


    public void manage(){
        System.out.println("管理员，你有如下功能可以使用，请选择：1-");
        System.out.println("*1* 添加新图书");
        System.out.println("*2* 删除图书");
        System.out.println("*3* 修改图书信息");
        System.out.println("*4* 查看图书信息");
        System.out.println("*5* 注册新用户");
        System.out.println("*6* 删除用户");
        System.out.println("*7* 修改用户信息");
        System.out.println("*8* 查看用户信息");
        System.out.println("*9* 退出系统");

        int choose=mScanner.nextInt();
        switch (choose){
            case 1:
                mIAdminDaoImpl.addBook(mBook);
                break;
            case 2:
                mIAdminDaoImpl.deleteBook(bookId);
                break;
            case 3:
                String sql=" ";
                mIAdminDaoImpl.updateBook(sql);
                break;
            case 4:
                mVisitorDao.showBooks();
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("输入的指令有误，请重新输入");
                manage();
                break;
        }
    }

}
