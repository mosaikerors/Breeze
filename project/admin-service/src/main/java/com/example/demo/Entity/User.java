package com.example.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public User(String u_id, String username, String password, String email, String phone) {
        this.u_id = u_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getU_id() {return u_id;}

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

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
