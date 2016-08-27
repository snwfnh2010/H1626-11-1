package Project1.bizImpl;

import Project1.biz.UserBiz;
import Project1.model.Book;
import Project1.model.dao.IUserDao;
import Project1.model.daoImpl.IUserDaoImpl;

import java.util.List;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class UserBizImpl implements UserBiz {
    IUserDao mIUserDao;

    public UserBizImpl() {

    }

    @Override
    public List<Book> showBooks() {
        return null;
    }
}

