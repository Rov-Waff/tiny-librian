package top.toplowork.tiny_libarian_backend;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.toplowork.tiny_libarian_backend.pojo.User;
import top.toplowork.tiny_libarian_backend.service.UserService;

@Slf4j
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void addUserTest(){
        User user=new User();
        user.setUsername("Andy");
        user.setPassword("114514");
        user.setEmail("10086");
        userService.addUser(user);
    }
    @Test
    public void deleteUserTest(){
        userService.deleteUserById(userService.findUserByName("Andy").getFirst().getId());
    }
    @Test
    public void updateUserTest(){
        User user=new User();
        user.setUsername("Andy");
        user.setPassword("114513");
        user.setEmail("10086");
//        userService.addUser(user);
        user.setEmail("123456");
        userService.updateUserById(user);
    }
    @Test
    public void findUserByIdTest(){
        log.info(userService.findUserById(12).toString());
    }
    @Test
    public void findUserByNameTest(){
        log.info(userService.findUserByName("Andy").toString());
    }
}
