package com.demo.springbootdemo2;

import com.demo.Springbootdemo2Application;
import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springbootdemo2Application.class)
public class Springbootdemo2ApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {
		List<User> users = userMapper.queryUserList ();
		System.out.println (users);
	}

}
