package com.example.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveStringCommands.BitFieldCommand;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands.BitOperation;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

/**
 * RedisDemoService
 *
 * @author: niko
 * @date: 2022/7/21 17:39
 */
@Service
public class RedisDemoService {
    private static final Logger logger = LoggerFactory.getLogger(RedisDemoService.class);
    @Autowired
    private RedisTemplate redisTemplate;

    //增加点赞数 每次加1
    public void saveRank(String user){
        String key ="user:like";
//        if(redisTemplate.opsForZSet().)
        redisTemplate.opsForZSet().incrementScore(key,user,1);


    }

    /**
     * 点赞 排行榜 前三名
     */

    public Set likeRank(){

        Set<TypedTuple> set = redisTemplate.opsForZSet().reverseRangeWithScores("user:like", 0, 2);
        for(TypedTuple typedTuple:set) {
            logger.info("点赞排行前三名：{}-{}", typedTuple.getValue(),typedTuple.getScore());
        }

        return set;

    }

    /**
     * 某个人签到功能
     * 一个字节=8bit 可以存储8天
     * 一年365天需要46个字节 46byte *1000(万人) = 46000*10000byte = 460M
     * key 格式可以按 user:sign:YY 如 lili:sign:2022
     */
    public void sign(String key,int offset){
        redisTemplate.opsForValue().setBit(key,offset,true);
    }

    /**
     * 统计签到次数
     * start end 表示是字节 不是位，-1表示最后一个字节开始 -2倒数第二个
     */
    public long signTimes(String key,int start,int end){
        //redistemplate 没有bitcount方法 用exec来处理
        long count = (long)redisTemplate
            .execute((RedisCallback<Long>) conn -> conn.bitCount(key.getBytes(), start, end));
        logger.info("{}签到次数:{}",key,count);
//        BitFieldCommand bitFieldCommand = new BitFieldCommand();
        Object execute = redisTemplate
            .execute((RedisCallback<Long>) conn -> conn.bitOp(BitOperation.OR,"XOR".getBytes(), "haha".getBytes(), key.getBytes()));
        Object execute1 = redisTemplate.opsForValue().getBit("XOR",1);
//            .execute((RedisCallback<?>) conn -> conn.get("XOR".getBytes()));
        logger.info("XOR ->{}",execute1);
        return count;
    }

    /**
     * 模拟购物车
     */
    public void lineCar(){
//        redisTemplate.opsForList().

    }
}
