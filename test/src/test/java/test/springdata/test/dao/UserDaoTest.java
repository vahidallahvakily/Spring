package test.springdata.test.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import test.springdata.test.model.User;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserDaoTest {
    private static final Logger logger = LogManager.getLogger(UserDaoTest.class);

    @Autowired
    UserDao userDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void saveUser(){
        logger.info("save User");
        entityManager.setFlushMode(FlushModeType.AUTO);
        User userTest= userDao.findByUsername("vahid3");
        Assert.assertNull(userTest);
        //---Test Insert
        User user=new User();
        user.setFirstName("vahid3");
        user.setLastName("vakily3");
        user.setUsername("vahid3");
        User userResult= userDao.saveAndFlush(user);
        Assert.assertTrue(userResult.getId()>0);
        //---Test find by Username
        User user2= userDao.findByUsername("vahid3");
        Assert.assertTrue(user2.getUsername().equals("vahid3"));
        //--- Test Delete
        //userDao.deleteById(user2.getId());

    }

    @Test
    public void testFindByUsername(){

    }


}
