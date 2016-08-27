package Project1.model.dao;

import Project1.model.Book;

import java.util.List;

/**
 * Created by snwfnh on 2016/8/25.
 */
public interface IUserDao {

    public boolean lendBook(String sql);
    public boolean returnBook(String sql);
    public boolean ordBook(String sql);
    public boolean evaluate(String sql);

}
