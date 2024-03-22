package com.jyx.test.tree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MyService
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-20 16:13
 **/
@Service
public class TreeService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public TreeService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addToCache(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void saveTree(String key, TreeData treeData) {
        redisTemplate.opsForValue().set(key, treeData);
    }

    public TreeData getTree(String key) {
        return (TreeData) redisTemplate.opsForValue().get(key);
    }

}
