package com.example.demo.Service;
import com.example.demo.Dao.UserInfoRepository;
import com.example.demo.Entity.User;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Optional;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
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
  @InjectMocks
  private UserInfoServiceImple userInfoServiceImple;
  @Captor
  private ArgumentCaptor<List<User>> listCaptor;

  @Before
  public void before() throws Exception {
    MockitoAnnotations.initMocks(this);
    // 用模拟对象创建被测类对象
    //userInfoServiceImple = new UserInfoServiceImple();
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: findAll(Pageable pageable)
   */
  @Test
  public void testFindAll() throws Exception {
    User user1 = new User("username", "password",  17037041703L,1);
    User user2 = new User("username", "password",  17037031703L,1);
    List<User> userlist = Arrays.asList(user1, user2);
    // 设置模拟对象的返回预期值
    when(userInfoRepository.findAll()).thenReturn(userlist);
    // 执行测试
    List<User> userResult = userInfoServiceImple.findAll();
    // 验证模拟对象的fetchPerson(1)方法是否被调用了一次
    verify(userInfoRepository).findAll();

    assertEquals(userlist, userResult);
    // 检查模拟对象上是否还有未验证的交互
    verifyNoMoreInteractions(userInfoRepository);
  }

}
