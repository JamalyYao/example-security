//package example.security.service;
//
//import example.security.dao.entity.BrowserUser;
//import example.security.dao.specificdao.BrowserUserDao;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserTest {
//
//    @Autowired
//    private BrowserUserDao browserUserDao;
//
//    @Test
//    public void userSave(){
//        BrowserUser browserUser = new BrowserUser();
//        browserUser.setAccount("wangww@163.com");
//        browserUser.setCreateBy("wangww");
//        browserUser.setEmail("wangww@163.com");
//        browserUser.setLastLoginIp("127.0.0.1");
//        browserUser.setMobileNo("15251005148");
//        browserUser.setPassword("123456");
//        browserUser.setPhoto("http://www.photo.com");
//        browserUser.setSex("0");
//        browserUser.setUserName("阿凡达");
//        browserUser.setUserNickname("盖世英雄");
//        browserUser.setUpdateBy("wangww");
//        browserUserDao.saveSelective(browserUser);
//    }
//}
