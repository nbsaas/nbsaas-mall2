package com.nbsaas.life.security.token;

import lombok.Data;
import org.apache.shiro.authc.UsernamePasswordToken;

import java.util.List;

@Data
public class DataToken<T> extends UsernamePasswordToken {

    private T data;

    private List<String> permissions;

    private List<String> roles;

    public DataToken() {
        super("ada", "ada".toCharArray());
    }
}
