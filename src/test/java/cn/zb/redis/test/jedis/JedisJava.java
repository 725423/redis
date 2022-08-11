package cn.zb.redis.test.jedis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class JedisJava {

    private Jedis jedis;

    @Test
    void testString(){
        jedis = new Jedis("192.168.182.131");
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    void getkeys(){
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    void hash(){
        jedis = new Jedis("192.168.182.131");
        Map<String, String> map = new HashMap<>();
        map.put("name", "程敏2");
        map.put("age", "19");
        jedis.hset("cm2", map);
        System.out.println("添加成功：" + jedis.hmget("cm2", "name", "age"));
    }
}
