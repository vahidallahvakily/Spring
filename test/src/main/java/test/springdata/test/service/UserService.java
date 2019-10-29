package test.springdata.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springdata.test.dao.UserDao;
import test.springdata.test.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

}
