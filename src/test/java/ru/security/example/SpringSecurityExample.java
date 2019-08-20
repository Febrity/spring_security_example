package ru.security.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.security.example.controller.ExampleController;
import ru.security.example.entity.User;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("localH2")
public class SpringSecurityExample {

    @Autowired
    ExampleController userController;

    User user = new User("testUser", "testPassword", "testPasswordEncode", "testRole");

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void givenUnauthenticated_whenCallOnController_thenThrowsException() {
        userController.createUser(user);
    }

    @Test()
    @WithMockUser(username="business_admin", roles = {"BUSINESS_ADMIN"})
    @Transactional
    public void givenAuthenticated_whenCallController() {
        User createUsers = userController.createUser(user);
        assertEquals("testUser",createUsers.getUserName());
        assertEquals("testPassword",createUsers.getPassword());
        assertEquals("testRole",createUsers.getRole());
    }

    @Test()
    @WithMockUser(username="admin", roles = {"ADMIN"})
    @Transactional
    public void givenAuthenticated_whenCallController_users_admin() {
        User createUsers = userController.createUser(user);
        assertEquals("testUser",createUsers.getUserName());
        assertEquals("testPassword",createUsers.getPassword());
        assertEquals("testRole",createUsers.getRole());
    }

    @Test(expected = AccessDeniedException.class)
    @WithMockUser(username="business_user", roles = {"BUSINESS_USER"})
    public void givenUnauthenticated_whenCallOnController_thenThrowsException_r() {
        userController.createUser(user);
    }
}
