package com.example.demo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "User")
public class User {

    @Id
    private String u_id;

    private String username;
    private String password;
    private String email;
    private String phone;
    /*u_id
     * 0:封禁 1：普通用户 -1：未激活 2：管理员
     */
    private int status = -1;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
