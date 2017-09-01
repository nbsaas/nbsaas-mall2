package com.openyelp.data.service.impl;

import com.ada.user.api.SendCodeApi;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by ada on 2017/7/21.
 */
@Service
public class SendCodeImpl implements SendCodeApi {


    private static HashMap<String, String> templates = new HashMap<String, String>();

    static {
        templates.put("register", "SMS_78910255");
        templates.put("login", "SMS_78910257");
        templates.put("binding", "SMS_78910259");
        templates.put("init", "SMS_74990022");
        templates.put("reset", "SMS_78910254");
        templates.put("changePhone", "SMS_75715139");
    }

    public static String template(String catalog) {
        return templates.get(catalog);
    }


    @Override
    public boolean sendCode(String code, String product, String signName, String template, String phone) {
        return true;
    }

}
