package top.toplowork.tiny_libarian_backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.toplowork.tiny_libarian_backend.pojo.Result;
import top.toplowork.tiny_libarian_backend.pojo.User;
import top.toplowork.tiny_libarian_backend.service.UserService;

import java.util.Objects;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "user")
class UserController {
    private final UserService userService;
    @GetMapping
    public IPage<User> list(Integer pageNum,Integer pageSize) {
        if (pageSize == null && pageNum == null){
            return userService.list(1, 10);
        } else if(pageNum==null){
            return userService.list(1,pageSize);
        } else return userService.list(pageNum, Objects.requireNonNullElse(pageSize, 10));
    }
    @GetMapping("/{id}")
    public IPage<User> listUserById(@PathVariable Integer id){
        return userService.findUserById(id,1,10);
    }
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return new Result().success("OJBK!");
    }
    @PatchMapping
    public Result updateUser(@RequestBody User user){
        userService.updateUserById(user);
        return new Result().success("OJBK!");
    }
    @PostMapping
    public Result addUser(@RequestBody User user){
        userService.addUser(user);
        return new Result().success("OJBK!");
    }
    @GetMapping("/name")
    public IPage<User> listUserByName(String name,Integer pageNum,Integer pageSize){
        if (name==null) {
            return null;
        }
        if (pageSize == null && pageNum == null){
            return userService.findUserByName(name,1, 10);
        } else return userService.findUserByName(name, Objects.requireNonNullElse(pageNum, 1), pageSize);

    }
}
