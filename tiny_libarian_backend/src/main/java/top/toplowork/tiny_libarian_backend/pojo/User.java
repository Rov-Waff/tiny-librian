package top.toplowork.tiny_libarian_backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer id;
    String username;
    String password;
    String email;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
