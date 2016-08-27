package Project1.model.dao;

import Project1.model.Book;
import Project1.model.User;

import java.util.List;

/**
 * Created by snwfnh on 2016/8/25.
 */
public interface IAdminDao  {
    public boolean addBook(Book book);
    public boolean updateBook(String sql);
    public boolean deleteBook(int bookId);
    public boolean addUser(String sql);
    public boolean updateUser(String sql);
    public boolean deleteUser(int userId);
    public List<User> showUser();
    public boolean frozeUser(User user);


}
