package com.ada.iyelp.apps;

import com.ada.area.data.entity.Area;
import com.openyelp.data.entity.Shop;
import com.openyelp.data.entity.ShopCategory;
import com.openyelp.data.service.ShopService;
import com.openyelp.lbs.v3.domain.Poi;
import com.openyelp.lbs.v3.domain.State;
import com.openyelp.lbs.v3.service.PoiService;
import com.openyelp.lbs.webservice.domain.BackPoi;
import com.openyelp.lbs.webservice.domain.Backs;
import com.openyelp.lbs.webservice.v2.PlaceService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by cng19 on 2016/11/15.
 */
public class PoiApps {

    public PoiApps() {
    }

    public static void main(String[] args) {

        ShopService userService = ObjectFactory.get()
                .getBean(ShopService.class);

        PoiService service = new PoiService();
        PlaceService p = new PlaceService();
        p.setRegion("西安");
        Backs b = p.searchByKey("饭店", 20, 1);
        if(b != null) {
            List<BackPoi> pois = b.getResults();
            for (BackPoi backPoi : pois) {
                System.out.println(backPoi);

                Shop shop=new Shop();
                shop.setName(backPoi.getName());
                shop.setAddress(backPoi.getAddress());
                if ( backPoi.getLocation()!=null){
                    shop.setLatitude((double) backPoi.getLocation().getLat());
                    shop.setLongitude((double) backPoi.getLocation().getLng());
                }
                Area area=new Area();
                area.setId(113);
                shop.setArea(area);
                Set<ShopCategory> catalogs=new HashSet<ShopCategory>();
                ShopCategory category=new ShopCategory();
                category.setId(809);
                catalogs.add(category);
                shop.setCategorys(catalogs);
                userService.save(shop);
            }
        }

    }

    public static Poi toPoi(BackPoi p) {
        Poi result = new Poi();
        result.setAddress(p.getAddress());
        result.setTitle(p.getName());
        if(p.getDetail_info() != null) {
            result.setTags(p.getDetail_info().getTag());
        }

        if(p.getLocation() != null) {
            result.setLatitude((double)p.getLocation().getLat());
            result.setLongitude((double)p.getLocation().getLng());
        }

        return result;
    }
}
