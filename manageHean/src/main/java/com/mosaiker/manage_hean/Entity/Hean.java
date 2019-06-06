package com.mosaiker.manage_hean.Entity;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Time;

@Document(collection="notus")
public class Hean {
    private long userId;
    private String title;
    private String content;
    private String position;
    private Time time;
    private int security;
    private String appendix;

    public Hean(){

    }

    public Hean(long userId, String title, String content, String position,Time time,int security,String appendix){
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.position = position;
        this.time = time;
        this.security = security;
        this.appendix = appendix;
    }

    public void setUserId(long userId){
        this.userId = userId;
    }

    public long getUserId(){
        return this.userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostion() {
        return position;
    }

    public void setPostion(String position) {
        this.position = position;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getSecurity() {
        return security;
    }

    public void setSecurity(int security) {
        this.security = security;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

}
