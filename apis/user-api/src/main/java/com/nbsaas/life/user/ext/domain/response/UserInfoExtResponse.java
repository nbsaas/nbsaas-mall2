package com.nbsaas.life.user.ext.domain.response;

import com.nbsaas.life.user.api.domain.response.UserInfoResponse;
import lombok.Data;


@Data
public class UserInfoExtResponse extends UserInfoResponse {

    private String sessionId;
}
