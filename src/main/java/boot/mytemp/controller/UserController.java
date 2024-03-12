package boot.mytemp.controller;

import boot.mytemp.redis.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @PostMapping("/redis/post")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();

        String id = user.getId();
        String name = user.getName();
        int age = user.getAge();
        String major = user.getMajor();

        vop.set(id,name+","+age+","+major);


        log.info("[insert info] key : "+ id + "{"+name+", "+age+", "+major+"}");
        return new ResponseEntity<>(HttpStatus.CREATED);    }


    @GetMapping("/redis/getUser/{key}")
    public ResponseEntity<?> getUser(@PathVariable String key) {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        String value = vop.get(key);
        log.info("value of ["+ key +"] : "+value);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }
}
