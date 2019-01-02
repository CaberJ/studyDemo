package cn.caber.demo.redisDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class redisTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-redis.xml"});
        context.start();
        RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
        /*redisTemplate.opsForValue().set("aa","zhaikaibo");*/

        HashMap<String, String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        map.put("c",null);
        map.put("d","d");

        Set<String> set = map.keySet();

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(map.get(next)==null||map.get(next)==""){
                map.remove(next);
                set = map.keySet();
                iterator = set.iterator();

            }
        }


        redisTemplate.opsForValue().set("bb","zhaikai");
        redisTemplate.opsForHash().putAll("aaa",map);

        System.out.println(redisTemplate.opsForHash().get("aaa", "a"));


    }
}
