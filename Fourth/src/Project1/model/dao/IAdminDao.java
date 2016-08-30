package Project1.model.dao;

import Project1.model.Book;
import Project1.model.User;

import java.util.List;

/**
 * Created by snwfnh on 2016/8/25.
 */
public interface IAdminDao  {
    public void addBook();
    public void updateBook();
    public void deleteBook ();
    public void addUser();
    public void updateUser();
    public void deleteUser();
    public void showUseInfo();
    public void frozeUser();


}
