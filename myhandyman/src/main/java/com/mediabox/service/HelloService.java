package com.mediabox.service;

import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mediabox.dao.UserDao;
import com.mediabox.model.User;

@Service("helloService")
@Repository
public class HelloService implements IHelloService {
	private static final Log log = LogFactory.getLog(HelloService.class);
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(String userName) throws Exception {
        log.info("----------------addUser---------------");
        User userInfo = new User();
        userInfo.setUserName(userName);
        userDao.getSession().save(userInfo);
        return 1;
    }
}
