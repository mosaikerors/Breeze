package com.example.demo.Service;
import com.example.demo.UserInfoRepository;
import com.example.demo.Entity.User;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * UserInfoServiceImple Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 22, 2019</pre>
 */
public class UserInfoServiceImpleTest {

  @Mock
  private UserInfoRepository userInfoRepository;
  private UserInfoService userInfoServiceImple;
  @Captor
  private ArgumentCaptor<List<User>> listCaptor;

  @Before
  public void before() throws Exception {
    MockitoAnnotations.initMocks(this);
    // 用模拟对象创建被测类对象
    userInfoServiceImple = new UserInfoServiceImple();
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: queryByPhone(String phone)
   */
  @Test
  public void testQueryByPhone() throws Exception {
    User user = new User( "username", "password", "email", "17037041703",1);
    // 设置模拟对象的返回预期值
    doReturn(user).when(userInfoRepository.findByPhone("17037041703"));
    // 执行测试
    User result = userInfoServiceImple.queryByPhone("17037041703");
    // 验证模拟对象的fetchPerson(1)方法是否被调用了一次
    verify(userInfoRepository).findByPhone("17037041703");

    assertEquals(user, result);
    // 检查模拟对象上是否还有未验证的交互
    verifyNoMoreInteractions(userInfoRepository);
  }

  /**
   * Method: batchSave(List<User> userList)
   */
  @Test
  public void testBatchSave() throws Exception {
    User user1 = new User("username", "password", "email", "17037041703",1);
    User user2 = new User("username", "password", "email", "17037031703",1);
    List<User> userlist = Arrays.asList(user1, user2);
    doNothing().when(userInfoRepository).insert(listCaptor.capture());
    userInfoServiceImple.batchSave(userlist);
    verify(userInfoRepository).insert(userlist);
    assertThat(userlist, is(equalTo(listCaptor.getValue())));
  }

  /**
   * Method: queryById(String id)
   */
  @Test
  public void testQueryById() throws Exception {
    User user = new User( "username", "password", "email", "17037041703",1);
    // 设置模拟对象的返回预期值
    doReturn(user).when(userInfoRepository.findById("1"));
    // 执行测试
    User result = userInfoServiceImple.queryById("17037041703");
    // 验证模拟对象的fetchPerson(1)方法是否被调用了一次
    verify(userInfoRepository).findById("17037041703");

    assertEquals(user, result);
    // 检查模拟对象上是否还有未验证的交互
    verifyNoMoreInteractions(userInfoRepository);
  }

  /**
   * Method: queryByUsernameLike(String name)
   */
  @Test
  public void testQueryByUsernameLike() throws Exception {
    User user1 = new User("username", "password", "email", "17037041703",1);
    User user2 = new User( "username", "password", "email", "17037031703",1);
    List<User> userlist = Arrays.asList(user1, user2);
    // 设置模拟对象的返回预期值
    doReturn(userlist).when(userInfoRepository.findByUsername("username"));
    // 执行测试
    List<User> userResult = userInfoServiceImple.queryByUsernameLike("username");
    // 验证模拟对象的fetchPerson(1)方法是否被调用了一次
    verify(userInfoRepository).findByUsername("username");

    assertEquals(userlist, userResult);
    // 检查模拟对象上是否还有未验证的交互
    verifyNoMoreInteractions(userInfoRepository);
  }

  /**
   * Method: queryByPhoneLike(String phone)
   */
  @Test
  public void testQueryByPhoneLike() throws Exception {
    User user1 = new User("username", "password", "email", "17037041703",1);
    User user2 = new User("username", "password", "email", "17037031703",1);
    List<User> userlist = Arrays.asList(user1, user2);
    // 设置模拟对象的返回预期值
    doReturn(userlist).when(userInfoRepository.findByPhoneLike("170370"));
    // 执行测试
    List<User> userResult = userInfoServiceImple.queryByPhoneLike("170370");
    // 验证模拟对象的fetchPerson(1)方法是否被调用了一次
    verify(userInfoRepository).findByPhoneLike("170370");

    assertEquals(userlist, userResult);
    // 检查模拟对象上是否还有未验证的交互
    verifyNoMoreInteractions(userInfoRepository);
  }

  /**
   * Method: findAll(Pageable pageable)
   */
  @Test
  public void testFindAll() throws Exception {
    User user1 = new User("username", "password", "email", "17037041703",1);
    User user2 = new User("username", "password", "email", "17037031703",1);
    List<User> userlist = Arrays.asList(user1, user2);
    // 设置模拟对象的返回预期值
   doReturn(userlist).when(userInfoRepository.findAll());
    // 执行测试
    List<User> userResult = userInfoServiceImple.findAll();
    // 验证模拟对象的fetchPerson(1)方法是否被调用了一次
    verify(userInfoRepository).findAll();

    assertEquals(userlist, userResult);
    // 检查模拟对象上是否还有未验证的交互
    verifyNoMoreInteractions(userInfoRepository);
  }

  /**
   * Method: update(User user)
   */
  @Test
  public void testUpdate() throws Exception {
    User user = new User( "username", "password", "email", "phone",1);
    ArgumentCaptor<User> valueCapture =ArgumentCaptor.forClass(User.class);
    doNothing().when(userInfoRepository).save(valueCapture.capture());
    userInfoServiceImple.update(user);
    assertThat(user, is(equalTo(valueCapture.getValue())));
  }

  /**
   * Method: findByUsername(String username)
   */
  @Test
  public void testFindByUsername() throws Exception {
    User user1 = new User("username", "password", "email", "17037041703",1);
    User user2 = new User("username", "password", "email", "17037031703",1);
    List<User> userlist = Arrays.asList(user1, user2);
    // 设置模拟对象的返回预期值
    when(userInfoRepository.findByUsername("username")).thenReturn(userlist);
    // 执行测试
    List<User> userResult = userInfoServiceImple.findByUsername("username");
    // 验证模拟对象的fetchPerson(1)方法是否被调用了一次
    verify(userInfoRepository).findByUsername("username");

    assertEquals(userlist, userResult);
    // 检查模拟对象上是否还有未验证的交互
    verifyNoMoreInteractions(userInfoRepository);
  }


}
