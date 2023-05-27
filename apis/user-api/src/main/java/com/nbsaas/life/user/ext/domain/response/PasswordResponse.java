package com.nbsaas.life.user.ext.domain.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordResponse {

    private String password;

    private String salt;
}
