package com.ss.ch.service.impl;

import com.ss.ch.domain.User;
import com.ss.ch.domain.UserRole;
import com.ss.ch.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Micro on 4/24/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring-config.xml")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;


    User user;
    User user1;

    @Before
    public void init() throws Exception {
        user = new User();
        user1 = new User();

        user.setLogin("Test Login");
        user.setPassword("Test Password");
        user.seteMail("Test eMail");
        user.setName("Test Name");
        user.setSurname("Test  Surname");
        user.setUrlPicture("Test UrlPicture");
        user.setUserRole(UserRole.USER);

        user1.setLogin("Test Login");
        user1.setPassword("Test Password");
        user1.seteMail("Test eMail");
        user1.setName("Test Name");
        user1.setSurname("Test  Surname");
        user1.setUrlPicture("Test UrlPicture");
        user1.setUserRole(UserRole.ADMIN);
    }


    @Test
    public void crud() throws Exception {
        userService.save(user);
        userService.save(user1);
        user.setName("Test Name update");
        userService.update(user);
        userService.delete(user1);
        System.out.println(userService.getById(1));
    }



    @Test
    public void save() throws Exception {
        userService.save(user);
        userService.save(user1);
    }

    @Test
    public void update() throws Exception {
        user.setName("Test Name update");
        userService.update(user);
    }

    @Test
    public void delete() throws Exception {
        userService.delete(user1);
    }

    @Test
    public void getById() throws Exception {
        System.out.println(userService.getById(1));
    }

}