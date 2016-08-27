package Project1.model.dao;

import Project1.model.Book;
import Project1.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by snwfnh on 2016/8/26.
 */
public interface VisitorDao {
    public  List<Book> showBooks();
    public User login(String name, String password) throws SQLException;
    public void logout();
}
