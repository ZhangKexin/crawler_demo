//package com.aladdin.crawler_demo.login.service;
//
//import com.aladdin.demo.login.domain.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by zkx on 2017/3/21.
// */
//@RunWith(SpringJUnit4ClassRunner.class)//基于junit4的Spring测试框架
////@RunWith 指定测试运行器
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//启动Spring容器
////@ContextConfiguration 指定Spring的配置文件
//public class UserServiceTest {
//    //注入Spring容器中的Bean
//    @Autowired
//    private UserService userService;
//
//    //标注测试方法
//    @Test
//    public void hasMatchUser() throws Exception {
//        boolean b1 = userService.hasMatchUser("admin", "123456");
//        boolean b2 = userService.hasMatchUser("admin", "1111");
//        assertTrue(b1);
//        assertFalse(b2);
//    }
//
//    @Test
//    public void findUserByUserName() throws Exception {
//        User user = userService.findUserByUserName("admin");
//        assertEquals(user.getUserName(), "admin");
//    }
//
//    @Test
//    public void loginSuccess() throws Exception {
//
//    }
//
//}
