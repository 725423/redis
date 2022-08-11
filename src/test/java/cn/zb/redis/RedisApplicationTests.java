package cn.zb.redis;

import cn.zb.redis.entity.User;
import cn.zb.redis.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RedisApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private RedisUtil redisUtil;

    @Test
        void testString() {
        boolean result = redisUtil.set("cm", "程敏");
        System.out.println(result);
    }

    @Test
    void testUser(){
        User user = new User();
        Map cm = new HashMap<>();
        user.setName("程敏");
        user.setAge(18);
        cm.put("name", user.getName());
        cm.put("age", user.getAge());

        boolean result = redisUtil.hmset("cm", cm);
        System.out.println(result);
    }
}
