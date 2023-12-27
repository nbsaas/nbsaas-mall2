package com.nbsaas.boot.resources;

import com.nbsaas.boot.security.api.AuthorizationApi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationResource implements AuthorizationApi {


    @Transactional
    @Override
    public List<String> loadRoles() {
        List<String> result = new ArrayList<>();



        return result;
    }

    @Transactional
    @Override
    public List<String> loadPermissions() {
        List<String> result = new ArrayList<>();


        return result;
    }
}
