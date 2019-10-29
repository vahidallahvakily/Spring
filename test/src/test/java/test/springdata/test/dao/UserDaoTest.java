package test.springdata.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import test.springdata.test.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application-test.properties")
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void saveUser(){
        User user=new User();
        user.setFirstName("vahid");
        user.setLastName("vakily");
        user.setUsername("vahid");
        User userResult= userDao.saveAndFlush(user);
        Assert.assertTrue(userResult.getId()>0);
    }
}
