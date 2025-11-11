package com.dcrtv.dcrtvbackend.model.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    public String username;
    public String number;
    public String password;
}
