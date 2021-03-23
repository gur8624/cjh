package com.example.cjh.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class userDto {
    private Long id;
    private String email;
    private String password;

}
