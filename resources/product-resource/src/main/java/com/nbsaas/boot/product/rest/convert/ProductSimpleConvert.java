package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.Product;
import com.nbsaas.boot.product.api.domain.simple.ProductSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ProductSimpleConvert implements Converter<ProductSimple, Product> {




@Override
public ProductSimple convert(Product source) {
    ProductSimple result = new ProductSimple();

                result.setSummary(source.getSummary());
                result.setThumbnail(source.getThumbnail());
                result.setShop(source.getShop());
                result.setStockDate(source.getStockDate());
                result.setDiscount(source.getDiscount());
                result.setMealFee(source.getMealFee());
                result.setAddDate(source.getAddDate());
                result.setSkuEnable(source.getSkuEnable());
                result.setBarCode(source.getBarCode());
                result.setPrice(source.getPrice());
                result.setMinPrice(source.getMinPrice());
                result.setName(source.getName());
                result.setStockNum(source.getStockNum());
                result.setRealStock(source.getRealStock());
                result.setLogo(source.getLogo());
                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                result.setMaxPrice(source.getMaxPrice());
                result.setId(source.getId());
                result.setLastDate(source.getLastDate());


    return result;
}

}