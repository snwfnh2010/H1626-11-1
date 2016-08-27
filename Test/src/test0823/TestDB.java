package test0823;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by snwfnh on 2016/8/23.
 */
public class TestDB {
    public static void main(String[] args) {
        try {
            runTest();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runTest() throws SQLException, IOException {
        Connection conn=getConnection();
        try {
            Statement stat=conn.createStatement();
            stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
            stat.executeUpdate("INSERT INTO Greeatings VALUES ('Hello,World!')");
            ResultSet result=stat.executeQuery("SELECT * FROM Greetings");
            if(result.next())
                System.out.println(result.getString(1));
            result.close();
            stat.executeUpdate("DROP TABLE Greetings");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }

    }

    public static Connection getConnection() throws IOException, SQLException {
        Properties props=new Properties();

            FileInputStream in=new FileInputStream("database.properties");
            props.load(in);
            in.close();
            String drivers=props.getProperty("jdbc.drivers");
            if(drivers!=null)
                System.setProperty("jdbc.drives",drivers);
            String url=props.getProperty("jdbc.url");
            String username=props.getProperty("jdbc.username");
            String password=props.getProperty("jdbc.password");





        return DriverManager.getConnection(url,username,password);
    }
}
