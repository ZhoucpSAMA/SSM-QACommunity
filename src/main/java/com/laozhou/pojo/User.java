package com.laozhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer role;
    private String status;
    private String email;
}
