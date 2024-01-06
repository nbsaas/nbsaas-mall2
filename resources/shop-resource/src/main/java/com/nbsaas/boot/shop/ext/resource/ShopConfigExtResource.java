package com.nbsaas.boot.shop.ext.resource;

import com.google.gson.Gson;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.shop.data.entity.Shop;
import com.nbsaas.boot.shop.data.entity.ShopConfig;
import com.nbsaas.boot.shop.data.repository.ShopConfigRepository;
import com.nbsaas.boot.shop.ext.apis.ShopConfigExtApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ShopConfigExtResource implements ShopConfigExtApi {

    @Resource
    private ShopConfigRepository shopConfigRepository;



    @Override
    public <T> T config(Long shop, Class<T> classKey) {
        ShopConfig data = shopConfigRepository.findByClassNameAndShopId(classKey.getSimpleName(),shop);
        if (data == null) {
            T configData;
            try {
                configData = classKey.getConstructor().newInstance();
            } catch (Exception ignored) {
                return null;
            }
            data = new ShopConfig();
            data.setClassName(classKey.getSimpleName());
            data.setConfigData(new Gson().toJson(configData));
            data.setAddDate(new Date());
            data.setLastDate(new Date());
            data.setShop(Shop.fromId(shop));
            shopConfigRepository.save(data);
            return configData;
        }
        String jsonData = data.getConfigData();
        if (jsonData == null) {
            jsonData = "{}";
        }

        return new Gson().fromJson(jsonData, classKey);
    }

    @Override
    public <T> ResponseObject<T> info(Long shop, Class<T> classKey) {
        ResponseObject<T> result = new ResponseObject<T>();
        result.setData(config(shop,classKey));
        return result;
    }

    @Override
    public <T> ResponseObject<T> configData(Long shop, T data) {
        ResponseObject<T> result = new ResponseObject<T>();

        if (data == null) {
            result.setCode(501);
            result.setMsg("空数据");
            return result;
        }
        result.setData(data(shop,data));
        return result;
    }

    @Override
    public <T> T data(Long shop, T data) {
        if (data == null) {
            return null;
        }
        ShopConfig temp = shopConfigRepository.findByClassNameAndShopId(data.getClass().getSimpleName(),shop);

        if (temp == null) {
            temp = new ShopConfig();
            temp.setClassName(data.getClass().getSimpleName());
            temp.setConfigData(new Gson().toJson(data));
            temp.setShop(Shop.fromId(shop));
            shopConfigRepository.save(temp);
            return data;
        }
        temp.setConfigData(new Gson().toJson(data));
        temp.setLastDate(new Date());
        return data;
    }
}
