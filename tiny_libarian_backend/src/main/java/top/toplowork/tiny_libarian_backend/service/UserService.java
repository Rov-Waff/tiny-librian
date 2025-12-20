package top.toplowork.tiny_libarian_backend.service;

import org.springframework.stereotype.Service;
import top.toplowork.tiny_libarian_backend.pojo.User;

import java.util.List;

@Service
public interface UserService {
    void addUser(User user);
    void deleteUserById(Integer id);
    void updateUserById(User user);
    List<User> findUserByName(String name);
    User findUserById(Integer id);
}
