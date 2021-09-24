package com.felixin.test.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtRequestModel implements Serializable {
    private String user_id;
    private String password;
}