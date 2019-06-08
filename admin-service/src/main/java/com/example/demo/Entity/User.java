package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String phone;
    /*u_id
     * 0:封禁 1：普通用户 -1：未激活 2：管理员
     */
    private Integer status = -1;



}
