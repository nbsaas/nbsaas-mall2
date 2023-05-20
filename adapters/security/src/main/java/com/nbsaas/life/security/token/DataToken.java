package com.nbsaas.life.security.token;

import lombok.Data;
import org.apache.shiro.authc.UsernamePasswordToken;

@Data
public class DataToken<T> extends UsernamePasswordToken {

    private T data;

    public DataToken() {
        super("ada", "ada".toCharArray());
    }
}
