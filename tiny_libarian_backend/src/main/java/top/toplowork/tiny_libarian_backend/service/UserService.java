package top.toplowork.tiny_libarian_backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import top.toplowork.tiny_libarian_backend.pojo.User;

@Service
public interface UserService {
    void addUser(User user);
    void deleteUserById(Integer id);
    void updateUserById(User user);
    IPage<User> findUserByName(String name,Integer pageNum,Integer pageSize);
    IPage<User> findUserById(Integer id,Integer pageNum,Integer pageSize);
    IPage<User> list(Integer pageNum, Integer pageSize);
}
