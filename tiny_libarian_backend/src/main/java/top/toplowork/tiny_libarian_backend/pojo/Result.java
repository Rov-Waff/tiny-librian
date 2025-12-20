package top.toplowork.tiny_libarian_backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>{
    Integer code;
    String message;
    T data;
    public Result<T> success(String message,T data){
        return new Result<>(0,message,data);
    }
    public Result<T> success(String message){
        return new Result<>(0,message,null);
    }
    public Result<T> fail(String message){
        return new Result<>(1,message,null);
    }
}
