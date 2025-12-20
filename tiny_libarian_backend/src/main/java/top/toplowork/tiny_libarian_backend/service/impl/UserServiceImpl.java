package top.toplowork.tiny_libarian_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.toplowork.tiny_libarian_backend.mapper.UserMapper;
import top.toplowork.tiny_libarian_backend.pojo.User;
import top.toplowork.tiny_libarian_backend.service.UserService;

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
    public IPage<User> findUserByName(String name,Integer pageNum,Integer pageSize) {
        Page<User> page = new Page<>(pageNum,pageSize);
        return userMapper.selectPage(page,new QueryWrapper<User>().eq("username",name));
    }

    @Override
    public IPage<User> findUserById(Integer id,Integer pageNum,Integer pageSize) {
        Page<User> page = new Page<>(pageNum,pageSize);
        return userMapper.selectPage(page,new QueryWrapper<User>().eq("id",id));
    }

    @Override
    public IPage<User> list(Integer pageNum, Integer pageSize){
        Page<User> page=new Page<>(pageNum,pageSize);
        return userMapper.selectPage(page,null);
    }
}
