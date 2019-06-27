package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.UserInfoRepository;
import com.alibaba.fastjson.JSONObject;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * UserManage Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 22, 2019</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserManageTest {

  @Autowired
  private TestRestTemplate restTemplate;
  private static List<User> normals = new ArrayList<>();
  @Autowired
  private UserInfoRepository userInfoRepository;
  private User user1 = null;
  private User user2 = null;
  private User user3 = null;
  private final String userListUrl = "/api/admin/UserList";
  private final String getTotalUrl = "/api/admin/GetTotal";
  private final String viewDetailUrl = "/api/admin/ViewDetail";
  private final String manageUrl = "/api/admin/Manage";
  private final String updateUrl = "/api/admin/Update";

  @Before
  public void before() throws Exception {
    User user1 = new User("username1", "password1", "email", "13011111111", 1);
    User user2 = new User("username2", "password2", "email", "13122222222", 0);
    User user3 = new User("username3", "password3", "email", "13233333333", 1);
    userInfoRepository.save(user1);
    userInfoRepository.save(user2);
    userInfoRepository.save(user3);
    normals.add(user1);
    normals.add(user2);
    normals.add(user3);
  }

  @After
  public void after() throws Exception {
    userInfoRepository.deleteByPhone("13011111111");
    userInfoRepository.deleteByPhone("13122222222");
    userInfoRepository.deleteByPhone("13233333333");
    normals.clear();
  }

  /**
   * Method: findAllUser()
   */
  @Test
  public void testFindAllUser() throws Exception {
    ResponseEntity<JSONObject> response =
        restTemplate.getForEntity(userListUrl, JSONObject.class);
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(response.getBody().get("users"), equalTo(normals));
  }

  /**
   * Method: getTotal()
   */
  @Test
  public void testGetTotal() throws Exception {
    ResponseEntity<JSONObject> response =
        restTemplate.getForEntity(getTotalUrl, JSONObject.class);
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(response.getBody().getInteger("totalNum"), equalTo(3));
  }

  /**
   * Method: showDetail(@RequestBody JSONObject param)
   */
  @Test
  public void testShowDetail() throws Exception {
    JSONObject user = new JSONObject();
    user.put("phone", "13011111111");
    ResponseEntity<JSONObject> response =
        restTemplate.postForEntity(viewDetailUrl, user, JSONObject.class);
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(response.getBody().getObject("user", User.class), is(user1));
  }

  /**
   * Method: changeStatus(@RequestParam JSONObject param)
   */
  @Test
  public void testChangeStatus() throws Exception {
    JSONObject user = new JSONObject();
    user.put("phone", "13122222222");
    ResponseEntity<JSONObject> response =
        restTemplate.postForEntity(manageUrl, user, JSONObject.class);
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(response.getBody().getInteger("status"), is(1));
  }

  /**
   * Method: update(@RequestBody JSONObject param)
   */
  @Test
  public void testUpdate() throws Exception {
    JSONObject user = new JSONObject();
    user.put("username", "foofoo");
    user.put("password", "foofoopie");
    user.put("email", "cometomummy");
    user.put("status", 1);
    user.put("phone", "13233333333");
    ResponseEntity<JSONObject> response =
        restTemplate.postForEntity(updateUrl, user, JSONObject.class);
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(response.getBody().getObject("user", User.class).getUsername(), equalTo("foofoo"));
  }


}

