package com.ada.iyelp.apps;

import com.openyelp.lbs.v3.domain.Poi;
import com.openyelp.lbs.v3.domain.State;
import com.openyelp.lbs.v3.service.PoiService;
import com.openyelp.lbs.webservice.domain.BackPoi;
import com.openyelp.lbs.webservice.domain.Backs;
import com.openyelp.lbs.webservice.v2.PlaceService;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cng19 on 2016/11/15.
 */
public class PoiApps {

    public PoiApps() {
    }

    public static void main(String[] args) {
        PoiService service = new PoiService();
        PlaceService p = new PlaceService();
        p.setRegion("陕西");
        Backs b = p.searchByKey("酒店", 20, 1);
        if(b != null) {
            List pois = b.getResults();
            Iterator var5 = pois.iterator();

            while(var5.hasNext()) {
                BackPoi backPoi = (BackPoi)var5.next();
                System.out.println(backPoi);
//                Poi poi = toPoi(backPoi);
//                poi.setCoord_type(3);
//                State s = service.add(poi);
//                System.out.println(s);
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
