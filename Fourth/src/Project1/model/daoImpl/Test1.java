package Project1.model.daoImpl;

import Project1.model.EvaluateRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by snwfnh on 2016/8/30.
 */
public class Test1 {
    public static void main(String[] args) {
        IUserDaoImpl mi=new IUserDaoImpl();
        System.out.println(mi.checkFrozen(2009100112));

    }
}
