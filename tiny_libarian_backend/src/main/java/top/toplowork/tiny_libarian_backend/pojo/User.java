package top.toplowork.tiny_libarian_backend.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("`users`")
public class User {
    @TableId(type= IdType.AUTO)
    Integer id;
    String username;
    String password;
    String email;
    @TableField(fill= FieldFill.INSERT)
    LocalDateTime createAt;
    @TableField(fill=FieldFill.INSERT_UPDATE)
    LocalDateTime updateAt;
}
