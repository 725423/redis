package cn.zb.redis.clients;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class RedisJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.182.131");
        System.out.println("连接成功");
        System.out.println("服务器正在运行：" + jedis.ping());

        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
