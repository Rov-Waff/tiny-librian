package top.toplowork.tiny_libarian_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.toplowork.tiny_libarian_backend.pojo.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
