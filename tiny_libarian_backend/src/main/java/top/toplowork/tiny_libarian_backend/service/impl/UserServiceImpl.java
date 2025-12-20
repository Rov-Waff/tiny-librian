package top.toplowork.tiny_libarian_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.toplowork.tiny_libarian_backend.mapper.UserMapper;
import top.toplowork.tiny_libarian_backend.pojo.User;
import top.toplowork.tiny_libarian_backend.service.UserService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userMapper.selectList(new QueryWrapper<User>().eq("username",name));
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectById(id);
    }
}
