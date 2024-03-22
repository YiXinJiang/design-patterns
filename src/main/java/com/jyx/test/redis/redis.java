package com.jyx.test.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @ClassName: redis
 * @Description: redis测试
 * @Author: jyx
 * @Date: 2023-11-27 17:13
 * @Version: 1.0
 **/
public class redis {

    public static void main(String[] args) {
        System.out.println("redis使用pipeline耗时测试");
        // 连接到Redis服务器
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 不使用管道的操作示例
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            jedis.set("key" + startTime + i, "value" + i);
            jedis.get("key" + startTime + i);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTimeWithoutPipeline = endTime - startTime;

        System.out.println("==================");

        // 使用管道的操作示例
        startTime = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 1000000; i++) {
            pipeline.set("key" + startTime + i, "value" + i);
            pipeline.get("key" + startTime + i);
        }
        pipeline.sync();
        endTime = System.currentTimeMillis();
        long elapsedTimeWithPipeline = endTime - startTime;

        // 打印执行耗时情况
        System.out.println("不使用管道的执行耗时：" + elapsedTimeWithoutPipeline + " 豪秒");
        System.out.println("使用管道的执行耗时：" + elapsedTimeWithPipeline + " 豪秒");

        // 关闭Redis连接
        jedis.close();
    }

}
