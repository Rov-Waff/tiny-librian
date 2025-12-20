package top.toplowork.tiny_libarian_backend;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.toplowork.tiny_libarian_backend.mapper.UserMapper;
import top.toplowork.tiny_libarian_backend.pojo.User;

import java.util.List;

@Slf4j
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void findAllTest(){
        List<User> users =  userMapper.selectList(null);
        users.forEach((p)->{log.info(p.toString());});
    }
}
