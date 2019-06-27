package com.example.demo.Entity;


import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class User {

  @Id
  @GeneratedValue
  private long id;
  @Column
  private String username;
  @Column
  private String password;

  @Column(unique = true)
  private Long phone;
  /*u_id
   * 0:封禁 1：普通用户 -1：未激活 2：管理员
   */
  @Column
  private int status = -1;
  private static final long serialVersionUID = 1L;

  public User(){

  }
  public User(String username, String password, Long phone, int status) {
    this.username = username;
    this.password = password;
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

  public Long getPhone() {
    return phone;
  }

  public void setPhone(Long phone) {
    this.phone = phone;
  }


}
