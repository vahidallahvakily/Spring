package test.springdata.test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.springdata.test.dto.OperationResult;
import test.springdata.test.exception.ObjectNotFoundException;
import test.springdata.test.model.User;
import test.springdata.test.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping()
    @RequestMapping("/{id}")
    public User findById(@PathVariable Integer id){
        Optional<User> user= userService.findById(id);
        if(user.isPresent())
            return user.get();
        else
            throw new ObjectNotFoundException();

    }

    @PostMapping
    public OperationResult saveUser(User user){
        return userService.saveUser(user);
    }


}
