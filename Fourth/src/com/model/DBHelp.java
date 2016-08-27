package com.model;

import java.sql.*;

/**
 * Created by snwfnh on 2016/8/23.
 */
public class DBHelp {
    private static DBHelp ourInstance = new DBHelp();

    public static DBHelp getInstance() {
        return ourInstance;
    }

    private DBHelp() {
    }

    Connection mConnection;

    public static final String USER="root";
    public static final String PWD="1451snwfnh";
    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String URL="jdbc:mysql://localhost:3306/ht1626";
    public Connection getConnection(){

        try {
            Class.forName(DRIVER);
            mConnection = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mConnection;
    }

    public void closeAll(Connection conn, PreparedStatement statement, ResultSet rSet) throws SQLException {
        if(rSet==null)
            return;
        rSet.close();
        rSet=null;
        if (statement != null) {
            statement.close();
            statement = null;
        }

        if (conn != null) {
            conn.close();
            conn = null;
        }
    }
}
