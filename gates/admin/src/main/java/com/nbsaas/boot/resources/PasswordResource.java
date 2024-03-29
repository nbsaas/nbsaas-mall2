package com.nbsaas.boot.resources;

import com.nbsaas.boot.user.ext.apis.PasswordApi;
import com.nbsaas.boot.user.ext.domain.request.PasswordRequest;
import com.nbsaas.boot.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.boot.user.ext.domain.response.PasswordResponse;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

@Service
public class PasswordResource implements PasswordApi {

    @Override
    public PasswordResponse password(PasswordRequest request) {
        RandomNumberGenerator generator = new SecureRandomNumberGenerator();
        ByteSource salt = generator.nextBytes(32);
        Sha256Hash sha256Hash = new Sha256Hash(request.getPassword(), salt, 2048);
        return PasswordResponse.builder().password(sha256Hash.toBase64()).salt(salt.toBase64()).build();
    }

    @Override
    public PasswordResponse passwordBySalt(PasswordRequest request) {
        ByteSource salt = ByteSource.Util.bytes(Base64.decode(request.getSalt()));
        Sha256Hash sha256Hash = new Sha256Hash(request.getPassword(), salt, 2048);
        return PasswordResponse.builder().password(sha256Hash.toBase64()).salt(salt.toBase64()).build();
    }
}
