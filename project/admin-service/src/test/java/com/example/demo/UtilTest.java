package com.example.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Util Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 22, 2019</pre>
 */
@RunWith(Parameterized.class)
public class UtilTest {

  private static Util util;
  private List<Integer> src;
  private List<List<Integer>> dst;
  int n;

  public UtilTest(List<Integer> source, int n, List<List<Integer>> dest) {
    this.src = source;
    this.n = n;
    this.dst = dest;
  }

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  @Parameters
  public static Collection usernameData() {
    return Arrays.asList(new Object[][]{{Arrays.asList("1", "2", "3", "4"), 2,
        Arrays.asList(Arrays.asList("1", "2"), Arrays.asList("3", "4"), new ArrayList<>())},
        {Arrays.asList("1", "2", "3", "4"), 4, Arrays.asList(Arrays.asList("1", "2", "3", "4"),new ArrayList<>())},
        {Arrays.asList("1", "2", "3", "4"), 3,
            Arrays.asList(Arrays.asList("1", "2", "3"), Arrays.asList("4"))}});

  }

  /**
   * Method: fixedGrouping(List<T> source, int n)
   */
  @Test
  public void testFixedGrouping() throws Exception {
    assertThat(util.fixedGrouping(src, n), is(equalTo(dst)));

  }


}
