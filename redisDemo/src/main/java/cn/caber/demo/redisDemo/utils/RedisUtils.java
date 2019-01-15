package cn.caber.demo.redisDemo.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

@Component
public class RedisUtils implements InitializingBean {

    //最大连接数
    private  String redis_max_active = "100";

    //最大空闲连接数
    private  String redis_max_idle = "10";

    //获取连接时最大等待毫秒数,如果该值小于0,则阻塞不确定的时长,默认值-1
    private  String redis_max_wait = "1500";

    //超时
    private  String redis_timeout = "2000";
    /**
     * 集群名称
     */

    private  String redis_clustername = "mymaster";
    /**
     * sentinels 哨兵地址信息
     */

    private String redis_addr = "127.0.0.1:2679";
    /**
     * 是否哨兵
     */
    private String redis_sentinel = "true";
    /**
     * 单机连接池
     */
    private static JedisPool jedisPool = null;
    /**
     * 哨兵连接池
     */
    private static JedisSentinelPool redisSentinelJedisPool = null;

    private static Set<String> getRedisSentinels(String redis_addr2) {

        Set<String> sentinelSet = new HashSet<String>();
        for (String sentinel : redis_addr2.split("\\|")) {
            sentinelSet.add(sentinel);
        }
        return sentinelSet;
    }

    @Override
    public void afterPropertiesSet()  {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(Integer.parseInt(redis_max_active));
            config.setMaxIdle(Integer.parseInt(redis_max_idle));
            config.setMaxWaitMillis(Integer.parseInt(redis_max_wait));
            // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
            config.setTestOnBorrow(true);
            // 哨兵模式
            if ("true".equalsIgnoreCase(redis_sentinel)) {
                Set<String> sentinels = getRedisSentinels(redis_addr);
                redisSentinelJedisPool = new JedisSentinelPool(
                        redis_clustername, sentinels, config);

            } else {
                String address = redis_addr.split(":")[0];
                String port = redis_addr.split(":")[1];
                jedisPool = new JedisPool(config, address,
                        Integer.parseInt(port),
                        Integer.parseInt(redis_timeout));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取操作对象
     * @return
     */
    public  static Jedis getJedis(){
        Jedis resource = null;
        if (jedisPool != null) {
            try {
                resource = jedisPool.getResource();
            } catch (Throwable t) {
                if (resource != null) {
                    resource.close();
                    resource = null;
                }
            }
        } else if (redisSentinelJedisPool != null) {
            try {
                resource = redisSentinelJedisPool.getResource();
            } catch (Throwable t) {
                if (resource != null) {
                    resource.close();
                    resource = null;
                }
            }
        }
        return resource;
    }

}
