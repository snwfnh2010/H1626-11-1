package Project1.demo;

import Project1.biz.UserBiz;
import Project1.bizImpl.LibSystem;
import Project1.bizImpl.UserBizImpl;
import Project1.model.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class Test {
    public static void main(String[] args) {
        LibSystem mLibSystem=new LibSystem();
        try {
            mLibSystem.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
