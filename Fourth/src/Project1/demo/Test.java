package Project1.demo;

import Project1.bizImpl.LibSystem;


import java.sql.SQLException;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class Test {
    public static void main(String[] args)  {
        LibSystem mLibSystem=new LibSystem();
        try {
            mLibSystem.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
