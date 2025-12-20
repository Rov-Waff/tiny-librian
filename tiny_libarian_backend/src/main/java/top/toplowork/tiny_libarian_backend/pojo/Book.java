package top.toplowork.tiny_libarian_backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    Integer id;
    String title;
    Boolean status;
    Integer owner;
    Integer borrower;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
