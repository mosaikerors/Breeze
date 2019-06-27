package com.mosaiker.sign.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.sign.entity.User;
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
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepository userRepository;

    private final String username = "test5648259647852359";
    private final String password = "test";
    private final long phone = 152018467852L;
    private final String loginUrl = "/api/user/login";

    @Test
    public void login() {
        JSONObject job = new JSONObject();
        job.put("phone", phone);
        job.put("password", password);
        User userForLogin = new User(username, password, phone, 1);
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

}