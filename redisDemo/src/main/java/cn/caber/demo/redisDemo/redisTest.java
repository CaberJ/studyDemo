package cn.caber.demo.redisDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.*;

public class redisTest {
    public static void main(String[] args) throws JsonProcessingException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-redis.xml"});
        context.start();
        RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");

        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);


        /*redisTemplate.opsForValue().set("AAA:BBB/:cc","a");

        System.out.println(redisTemplate.opsForValue().get("AAA:BBB/:cc"));

        System.out.println("****************");*/


        long now = System.currentTimeMillis();
        String  uuid = UUID.randomUUID().toString();
        redisTemplate.opsForZSet().add("FOP:IP:127.1.1.1/Port:1111/Application:zhai/Interface:kai/Group:bo",uuid,now);
        redisTemplate.opsForZSet().add("countFOP:IP:127.1.1.1/Port:1111/Application:zhai/Interface:kai/Group:bo",uuid+"0",now);
        redisTemplate.opsForZSet().add("countFOP:IP:127.1.1.1/Port:1111/Application:zhai/Interface:kai/Group:bo",uuid+"1",now);
        redisTemplate.opsForZSet().add("countFOP:IP:127.1.1.1/Port:1111/Application:zhai/Interface:kai/Group:bo",uuid+"2",now);
        redisTemplate.opsForZSet().add("countFOP:IP:127.1.1.1/Port:1111/Application:zhai/Interface:kai/Group:bo",uuid+"3",now);
        redisTemplate.opsForZSet().add("failedFOP:IP:127.1.1.1/Port:1111/Application:zhai/Interface:kai/Group:bo",uuid,now);
        redisTemplate.opsForZSet().add("successFOP:IP:127.1.1.1/Port:1111/Application:zhai/Interface:kai/Group:bo",uuid,now);






       /* Set keys = redisTemplate.keys("A" + "*" + "/:"+"*");
        Iterator iterator = keys.iterator();
        System.out.println(iterator.hasNext());
        while (iterator.hasNext()){
            System.out.println(redisTemplate.opsForValue().get(iterator.next()));
        }*/
        /*redisTemplate.opsForValue().set("aa","zhaikaibo");*/

       /* HashMap<String, String> map = new HashMap<>();
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

        System.out.println(redisTemplate.opsForHash().get("aaa", "a"));*/


        /*Set keys = redisTemplate.keys("*" + "a");
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        /*ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        String s = objectMapper.writeValueAsString(a);
        System.out.println(s);*/

       /* redisTemplate.opsForValue().set("FOP:Application:service-customer/Interface:cn.dubbo.service.CaberService/Group:hello","aa");
        String o = (String) redisTemplate.opsForValue().get("FOP:Application:service-customer/Interface:cn.dubbo.service.CaberService/Group:hello");
        System.out.println(o);*/
      /* redisTemplate.boundValueOps("FOP:Application:aaaa").set("123");
        String  o = (String) redisTemplate.boundValueOps("FOP:Application:aaaa").get();
        System.out.println(o);
        Set keys = redisTemplate.keys("FOP:Application:"+"*" );
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

    }
}
