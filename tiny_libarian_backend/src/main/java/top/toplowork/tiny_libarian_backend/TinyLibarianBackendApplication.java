package top.toplowork.tiny_libarian_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.toplowork.tiny_libarian_backend.mapper")
public class TinyLibarianBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyLibarianBackendApplication.class, args);
    }

}
