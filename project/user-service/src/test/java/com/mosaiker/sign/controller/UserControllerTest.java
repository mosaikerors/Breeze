package com.mosaiker.sign.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.sign.entity.User;
import com.mosaiker.sign.repository.PlayerRepository;
import com.mosaiker.sign.repository.UserRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepository userRepository;

    private final String username = "test5648259647852359";
    private final String password = "test";
    private final long phone = 152018467852L;
    private final long phone2 = 152018467853L;
    private final long phone3 = 1332372004L;
    private final String loginUrl = "/api/user/login";
    private final String code = "123456123456";
    private final String signupUrl = "/api/user/signup";
    private final String activateUrl = "/api/user/activate";
    private final String authenticateUrl = "/api/user/authenticate";

    @Test
    public void login() {
        JSONObject job = new JSONObject();
        job.put("phone", phone);
        job.put("password", password);
        User userForLogin = new User(username, password, phone, "4561234561", 1);
        userRepository.save(userForLogin);
        try {
            ResponseEntity<JSONObject> responseEntity = testRestTemplate.postForEntity(loginUrl, job, JSONObject.class);
            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            JSONObject body = responseEntity.getBody();
            if (body != null) {
                System.out.println(body);
                assertThat(body.getString("username"), equalTo(username));
                assertThat(body.getIntValue("role"), is(1));
            }
        }
        finally {
            userRepository.deleteUserByPhone(phone);
        }

    }

    @Test
    public void signup() {
        JSONObject job = new JSONObject();
        job.put("phone", phone3);
        job.put("username", username);
        job.put("password", password);
        try {
            ResponseEntity<JSONObject> responseEntity = testRestTemplate.postForEntity(signupUrl, job, JSONObject.class);
            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getString("message"), equalTo("ok"));
        }finally {
            userRepository.deleteUserByPhone(phone3);
        }
    }

    @Test
    public void activate() {
        User userForActivate = new User(username, password, phone2, code, 0);
        userRepository.save(userForActivate);
        ResponseEntity<JSONObject> responseEntity = testRestTemplate.getForEntity(activateUrl+"?code="+code, JSONObject.class);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        JSONObject body = responseEntity.getBody();
        if (body != null) {
            assertThat(body.getString("message"), equalTo("ok"));
        }
        System.out.println(userForActivate.getuId());
        playerRepository.deletePlayerByPhone(phone2);
        userRepository.deleteUserByPhone(phone2);
    }

    @Test
    public void authenticate() {

    }
}