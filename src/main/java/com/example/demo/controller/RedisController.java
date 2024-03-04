package com.example.demo.controller;

import com.example.demo.annotation.AccessLimit;
import com.example.demo.service.RedisDemoService;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/redis")
public class RedisController {
    private static final Logger logger= LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisDemoService redisDemoService;

    @RequestMapping("1")
    @ResponseBody
    @AccessLimit(seconds = 5,maxCount = 3)
    public String hello(String user ){
        redisDemoService.saveRank(user);
        Set set = redisDemoService.likeRank();
        //签到
//        LocalDateTime localDateTime = LocalDateTime.of(2022,1,1,0,0,0);
        LocalDateTime localDateTime = LocalDateTime.now();
        int day = localDateTime.getDayOfYear();
        int year = localDateTime.getYear();
        redisDemoService.sign("user:sign:"+year+":"+user,day-1);
        //签到的次数
        redisDemoService.signTimes("user:sign:"+year+":"+user,0,-1);
        return "hello";
    }

    @RequestMapping("2")
    public String index(ModelMap modelMap, HttpServletRequest request){
        modelMap.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
        logger.info("我是控制器日志..");
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        Boolean beibei = redisTemplate.hasKey("beibei");
        logger.info("是否有beibei{}",beibei);
//        redisTemplate.delete("beibei");
//        redisTemplate.opsForValue().set("beibei","abcdefg",1,TimeUnit.DAYS);
//        String beibei1 = (String)redisTemplate.opsForValue().getAndSet("beibei","hahaha1");
//        redisTemplate.expire("biebei",1, TimeUnit.MINUTES);
//        logger.info("beibei1{}",beibei1);
//        redisTemplate.opsForList().rightPush("zb:user-1","1");
//        redisTemplate.opsForList().rightPush("zb:user-1","adf");
//        redisTemplate.opsForList().rightPush("zb:user-1","哈哈");
//        List range = redisTemplate.opsForList().range("zb:user-1", 0, 1);
//        logger.info("list:"+range.toString());
//        logger.info("zb:user-1 的类型为："+ redisTemplate.type("zb:user-1"));
////        logger.info("zb:user 的重命名："+ redisTemplate.renameIfAbsent("zb:user","zb:user-1"));
//        logger.info("zb:user 是否存在："+ redisTemplate.hasKey("zb:user"));
//        logger.info("zb:user-1 是否存在："+ redisTemplate.hasKey("zb:user-1"));
//        redisTemplate.expire("zb:user-1",10,TimeUnit.MINUTES);
//        logger.info("从数据库中随机取一个key："+ redisTemplate.randomKey());
//        logger.info("zb:user-1 的过期时间为：{}"+ redisTemplate.getExpire("zb:user-1"));
//        logger.info("beibei 的过期时间为：{}"+ redisTemplate.getExpire("beibei"));
//        redisTemplate.persist("zb:user-1");
//        logger.info("zb:user-1 的过期时间为：{}"+ redisTemplate.getExpire("zb:user-1"));
//        logger.info("将beibei移到数据1中"+ redisTemplate.move("beibei",1));

        logger.info("获取beibei的的值串中的指定位置的字串{}",redisTemplate.opsForValue().get("beibei",2, 3));
//        logger.info("在beibei后面追加字符串{},{}",redisTemplate.opsForValue().append("beibei","hijk"),redisTemplate.opsForValue().get("beibei"));
//
//        redisTemplate.opsForValue().set("zengb:score","100",1,TimeUnit.DAYS);
//        logger.info("自增操作{}",redisTemplate.opsForValue().increment("zengb:score"));
//        logger.info("zengb:score 自增后的分数为{}",redisTemplate.opsForValue().get("zengb:score"));
//        logger.info("自增操作{}",redisTemplate.opsForValue().increment("zengb:score",10));
//        logger.info("zengb:score 自增后的分数为{}",redisTemplate.opsForValue().get("zengb:score"));

        Map map = new HashMap();
        map.put("xiaobei","35");//字符串 储存的二进制是ascii码
        map.put("lilei","98");
        map.put("meimei","76");
        //批量操作
        redisTemplate.opsForValue().multiSet(map);
        //bit 运算
//        redisTemplate.opsForValue().setBit("xiaobei",2,true);
        logger.info("xiaobei的分数为{}",redisTemplate.opsForValue().increment("xiaobei"));
        logger.info("xiaobei的分数为{}",redisTemplate.opsForValue().get("xiaobei"));

        //map hash数据类型
        redisTemplate.opsForHash().put("user:score","xiaobei",35);
        redisTemplate.opsForHash().put("user:score","lilei",98);
        redisTemplate.opsForHash().put("user:score","meimei",76);
        redisTemplate.opsForHash().putAll("user:score",map);

//        Map entries = redisTemplate.opsForHash().entries("user:score");
//        logger.info("user:score -->entries:{}",entries);
//        logger.info("user:score -->has beibei:{}",redisTemplate.opsForHash().hasKey("user:score","beibei"));
//        logger.info("user:score -->has lilei:{}",redisTemplate.opsForHash().hasKey("user:score","lilei"));
//        logger.info("user:score -->get lilei:{}",redisTemplate.opsForHash().get("user:score","lilei"));
//        logger.info("user:score -->get beibei:{}",redisTemplate.opsForHash().get("user:score","beibei"));
//
        logger.info("user:score -->keys:{}",redisTemplate.opsForHash().keys("user:score"));
        logger.info("user:score -->values:{}",redisTemplate.opsForHash().values("user:score"));
        logger.info("user:score -->size:{}",redisTemplate.opsForHash().size("user:score"));
        logger.info("meimei的分数为{}",redisTemplate.opsForHash().get("user:score","meimei"));
        //对list 操作 类型
//        logger.info("zb:user-1 -->rightPop:{}",redisTemplate.opsForList().rightPop("zb:user-1"));
//        logger.info("zb:user-1 -->rightPop:{}",redisTemplate.opsForList().rightPop("zb:user-1"));
//        logger.info("zb:user-1 -->rightPop:{}",redisTemplate.opsForList().rightPopAndLeftPush("zb:user-1","zb:user-1"));
//        redisTemplate.opsForList().set("zb:user-1",1,"xxxx");
//        logger.info("zb:user-1 -->删除值为adf的元素：{}",redisTemplate.opsForList().remove("zb:user-1",0,"adf"));//index 等于0 删除所有的
//        redisTemplate.opsForList().rightPush("zb:user-1","a");
//        redisTemplate.opsForList().rightPush("zb:user-1","b");
//        redisTemplate.opsForList().rightPush("zb:user-1","c");
//        redisTemplate.opsForList().rightPush("zb:user-1","a");
//        redisTemplate.opsForList().rightPush("zb:user-1","f");
//        redisTemplate.opsForList().rightPush("zb:user-1","g");
//        logger.info("zb:user-1 -->删除值为a的元素：{}",redisTemplate.opsForList().remove("zb:user-1",1,"a"));//index大于0从头部开始删除

        //操作set  无序 不重复
//        redisTemplate.opsForSet().add("zb:cars","bmw");
//        redisTemplate.opsForSet().add("zb:cars","benz");
//        redisTemplate.opsForSet().add("zb:cars","audi");
//        redisTemplate.opsForSet().add("zb:cars","fold");
//        logger.info("set操作 zb:cars-->members:{}",redisTemplate.opsForSet().members("zb:cars"));
//        logger.info("set操作 zb:cars-->remove benz:{}",redisTemplate.opsForSet().remove("zb:cars","benz"));
////        logger.info("set操作 zb:cars-->pop:{}",redisTemplate.opsForSet().pop("zb:cars"));
//        logger.info("set操作 zb:cars-->benz isMember:{}",redisTemplate.opsForSet().isMember("zb:cars","benz"));
//        logger.info("set操作 zb:cars-->audi isMember:{}",redisTemplate.opsForSet().isMember("zb:cars","audi"));
//        redisTemplate.opsForSet().add("xx:cars","audi","fold","bmw","wei","wei");
//        redisTemplate.opsForSet().add("zb:cars","benz","fold","bmw","tesla");
//        logger.info("set操作 zb:cards/xx:cards 交集-->{}",redisTemplate.opsForSet().intersect("zb:cars","xx:cars"));
//        logger.info("set操作 zb:cards/xx:cards 交集-->{}",redisTemplate.opsForSet().intersectAndStore("xx:cars","zb:cars","intersect:cars"));
//        logger.info("set操作 intersect:cars members-->{}",redisTemplate.opsForSet().members("intersect:cars"));
//        logger.info("set操作 zb:cards/xx:cards 并集-->{}",redisTemplate.opsForSet().union("zb:cars","xx:cars"));
//        logger.info("set操作 zb:cards/xx:cards 并集-->{}",redisTemplate.opsForSet().unionAndStore("zb:cars","xx:cars","union:cars"));
//        logger.info("set操作 union:cards members-->{}",redisTemplate.opsForSet().members("union:cars"));
//        logger.info("set操作 zb:cards/xx:cards 差集-->{}",redisTemplate.opsForSet().difference("xx:cars","zb:cars"));
//        logger.info("set操作 zb:cards/xx:cards 差集-->{}",redisTemplate.opsForSet().differenceAndStore("xx:cars","zb:cars","difference:cars"));
//        logger.info("set操作 difference:cards members-->{}",redisTemplate.opsForSet().members("difference:cars"));
//        logger.info("set操作 xx:cars pop-->{}",redisTemplate.opsForSet().pop("xx:cars"));
//        logger.info("set操作 xx:cars randomMembers-->{}",redisTemplate.opsForSet().randomMembers("xx:cars",3));
//        logger.info("set操作 xx:cars members-->{}",redisTemplate.opsForSet().members("xx:cars"));
//        logger.info("set操作 xx:cars distinctRandomMembers-->{}",redisTemplate.opsForSet().distinctRandomMembers("xx:cars",3));
//        redisTemplate.opsForSet().move("xx:cars","wei","wei1");
//        logger.info("set操作 xx:cars members-->{}",redisTemplate.opsForSet().members("xx:cars"));
//        logger.info("set操作wei1 members-->{}",redisTemplate.opsForSet().members("wei1"));

        //zset 操作 有序集合
        redisTemplate.opsForZSet().add("zb:zset","goods1",100);
        redisTemplate.opsForZSet().add("zb:zset","goods2",100);
        redisTemplate.opsForZSet().add("zb:zset","goods3",45);
        redisTemplate.opsForZSet().add("zb:zset","goods4",3);
        redisTemplate.opsForZSet().add("zb:zset","goods5",67);
        redisTemplate.opsForZSet().add("zb:zset","goods6",4.5);
        logger.info("zset操作 rangeByScore-->{}",redisTemplate.opsForZSet().remove("zb:zset","goods1","goods0"));

        logger.info("zset操作 rangeByScore-->{}",redisTemplate.opsForZSet().rangeByScore("zb:zset",0,100));
        logger.info("zset操作 取出当前元素的排名 从0开始 rank-->{}",redisTemplate.opsForZSet().rank("zb:zset","goods4"));
        logger.info("zset操作 取出当前元素的排名 从0开始 倒序 reverseRank-->{}",redisTemplate.opsForZSet().reverseRank("zb:zset","goods4"));
        logger.info("zset操作 按分数范围输出名称 rangeByScore-->{}",redisTemplate.opsForZSet().rangeByScore("zb:zset",0,50));
        logger.info("zset操作 按分数范围输出名称倒序 rangeByScore-->{}",redisTemplate.opsForZSet().reverseRangeByScore("zb:zset",0,50));
        // key min max  offset count
        logger.info("zset操作 按分数范围输出名称倒序 限制个数 rangeByScore-->{}",redisTemplate.opsForZSet().reverseRangeByScore("zb:zset",0,50,2,1));
        logger.info("zset操作 按分数范围统计数量 count-->{}",redisTemplate.opsForZSet().count("zb:zset",0,50));
        logger.info("zset操作 集合大小-->{}",redisTemplate.opsForZSet().zCard("zb:zset"));
        //遍历集合
//        Cursor<TypedTuple<Object>> scan = redisTemplate.opsForZSet().scan("zb:zset", ScanOptions.NONE);
//        while(scan.hasNext()){
//            ZSetOperations.TypedTuple<Object> next = scan.next();
//            logger.info("zb:zet -->{}:{}",next.getValue(),next.getScore());
//        }
//        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate.opsForZSet().rangeByScoreWithScores("zb:zset", 50, 100);
//        for(TypedTuple typedTuple:set ){
//
//            logger.info("zb:zet -->{}:{}",typedTuple.getValue(),typedTuple.getScore());
//        }
        redisTemplate.opsForZSet().incrementScore("zb:zset","goods1",1);

        //redis temaplate 没有bitcount 方法 用execute 来执行bitcout
        long count = (long)redisTemplate
            .execute((RedisCallback<Long>) con -> con.bitCount("xiaobei".getBytes()));
        logger.info("bitcout:"+count);
        return "index";
    }
}
