package com.mosaiker.manage_hean.Controller;

import com.alibaba.fastjson.JSON;
import static org.junit.Assert.*;
import com.alibaba.fastjson.JSONArray;
import com.mosaiker.manage_hean.Entity.Hean;
import com.mosaiker.manage_hean.Repository.HeanRepository;
import org.junit.Test;
import com.alibaba.fastjson.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HeanControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private HeanRepository heanRepository;

    @Test
    public void searchByTime() {
        Date time1 = new Date();
        Date time2 = new Date();
        Date time3 = new Date();
        Hean hean = new Hean(0, "welcome", "hello, my hean 1", "SJTU",
                time2, 0, null);
        heanRepository.save(hean);
        ResponseEntity<JSONArray> response =
                restTemplate.postForEntity("/manageHean/searchByTime", createTimeRequest(time1,time3), JSONArray.class);
        JSONArray jsonArray = JSON.parseArray(response.getBody().toString());
        for(Object obj : jsonArray){
            JSONObject jsonObj = JSON.parseObject(obj.toString());
            assertTrue(hean.getUserId()==jsonObj.getInteger("userId"));
            assertEquals(hean.getTitle(), jsonObj.get("title"));
            assertEquals(hean.getContent(), jsonObj.get("content"));
            assertEquals(hean.getPosition(), jsonObj.get("position"));
            assertTrue(hean.getSecurity()==jsonObj.getInteger("security"));
        }
        heanRepository.deleteByUserIdAndTime(0,time2);
    }

    @Test
    public void searchByUser() {
        Date time = new Date();
        Hean hean = new Hean(0, "welcome", "hello, my hean", "SJTU",
                time, 0, null);
        heanRepository.save(hean);
        ResponseEntity<JSONArray> response =
                restTemplate.postForEntity("/manageHean/searchByUser", createUserRequest(0), JSONArray.class);
        JSONArray jsonArray = JSON.parseArray(response.getBody().toString());
        for(Object obj : jsonArray){
            JSONObject jsonObj = JSON.parseObject(obj.toString());
            assertTrue(hean.getUserId()==jsonObj.getInteger("userId"));
            assertEquals(hean.getTitle(), jsonObj.get("title"));
            assertEquals(hean.getContent(), jsonObj.get("content"));
            assertEquals(hean.getPosition(), jsonObj.get("position"));
            assertTrue(hean.getSecurity()==jsonObj.getInteger("security"));
        }
        heanRepository.deleteByUserIdAndTime(0,time);
    }
    @Test
    public void searchByPosition() {
        Date time = new Date();
        Hean hean = new Hean(0, "welcome", "hello, my hean", "SJTU",
                time, 0, null);
        heanRepository.save(hean);
        ResponseEntity<JSONArray> response =
                restTemplate.postForEntity("/manageHean/searchByPosition", createPositionRequest("SJTU", 0), JSONArray.class);
        JSONArray jsonArray = JSON.parseArray(response.getBody().toString());
        for(Object obj : jsonArray){
            JSONObject jsonObj = JSON.parseObject(obj.toString());
            assertTrue(hean.getUserId()==jsonObj.getInteger("userId"));
            assertEquals(hean.getTitle(), jsonObj.get("title"));
            assertEquals(hean.getContent(), jsonObj.get("content"));
            assertEquals(hean.getPosition(), jsonObj.get("position"));
            assertTrue(hean.getSecurity()==jsonObj.getInteger("security"));
        }
        heanRepository.deleteByUserIdAndTime(0,time);
    }

    private JSONObject createTimeRequest(Date beginTime,Date endTime) {
        JSONObject time = new JSONObject();
        time.put("beginTime", beginTime);
        time.put("endTime", endTime);
        return time;
    }

    private JSONObject createUserRequest(Integer userId) {
        JSONObject user = new JSONObject();
        user.put("userId", userId);
        return user;
    }

    private JSONObject createPositionRequest(String position, float range) {
        JSONObject positionRequest = new JSONObject();
        positionRequest.put("position", position);
        positionRequest.put("range",range);
        return positionRequest;
    }
}