package test.springdata.test.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.springdata.test.model.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    @Query("select u from User u where LOWER(u.firstName) like  %:firstName%")
    List<User> findByFirstName(@Param("firstName") String firstName);
}
