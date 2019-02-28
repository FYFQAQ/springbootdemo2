package com.demo.springbootdemo2;

import com.demo.Springbootdemo2Application;
import com.demo.domain.User;
import com.demo.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest(classes = Springbootdemo2Application.class)
public class SpringBootTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void JpaTest() {
        User user = repository.findOne (1L);
        System.out.println (user);
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void RedisTest() throws JsonProcessingException {
        //从缓存中获取指定的数据
        String userListData = redisTemplate.boundValueOps ("user.findAll").get ();
        //如果redia中没有数据的话
        if (null == userListData) {
            System.out.println ("===========从数据库中获取数据==========");
            //查询数据库获得数据
            List<User> list = repository.findAll ();
            //转换成json格式字符串
            ObjectMapper mapper = new ObjectMapper ();
            userListData = mapper.writeValueAsString (list);
            //将数据存储到redis中,下次再查询直接从redis中获取
            redisTemplate.boundValueOps ("user.findAll").set (userListData);
        } else {
            System.out.println ("===========从redis缓存中获取数据==========");
        }
        System.out.println (userListData);
    }
}
