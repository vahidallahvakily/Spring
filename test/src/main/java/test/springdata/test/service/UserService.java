package test.springdata.test.service;

import test.springdata.test.dto.OperationResult;
import test.springdata.test.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> findAll();

    Optional<User> findById(Integer id);

    OperationResult saveUser(User user);

}
