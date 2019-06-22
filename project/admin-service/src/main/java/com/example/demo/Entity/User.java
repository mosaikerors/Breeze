package com.example.demo.Entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Document(collection = "User")
@Data
public class User {

  @Id
  @GeneratedValue
  private String u_id;
  private String username;
  private String password;
  private String email;
  @Column(unique = true)
  private String phone;
  /*u_id
   * 0:封禁 1：普通用户 -1：未激活 2：管理员
   */
  private int status = -1;

  public User(String username, String password, String email, String phone, int status) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.phone = phone;
    this.status = status;
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

  public String getUsername() { return username; }

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
