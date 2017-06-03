package com.quhaodian.actions.admin;

import com.quhaodian.actions.shop.TimeVo;
import com.quhaodian.data.entity.Shop;
import com.quhaodian.data.entity.ShopTime;
import com.quhaodian.data.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 年高 on 2015/12/6.
 */
@Controller
@RequestMapping(value = "admin")
public class ShopTimeAction {

    @Autowired
    ShopService shopService;

    @RequestMapping(value = "shop/time_update")
    public String view_update(Integer[] weeks, Integer[] maxindex, Integer[] minindex, HttpServletRequest request, Long id, HttpServletResponse response, Model model) {

        Shop shop = shopService.findById(id);
        model.addAttribute("shop", shop);
        model.addAttribute("maxtimes", TimeVo.times(1, 62));
        model.addAttribute("mintimes", TimeVo.times(0, 48));
        model.addAttribute("index", 2);

        List<ShopTime> times = new ArrayList<ShopTime>();
        if (weeks != null) {
            for (int i = 0; i < weeks.length; i++) {
                ShopTime time = new ShopTime();
                time.setWeek(weeks[i]);
                time.setMinhour(minindex[i]);
                time.setMaxhour(maxindex[i]);
                shop.getTimes().put(weeks[i], time);
            }
            shopService.update(shop);
        }

        return "redirect:/admin/shop/view_update.htm?id="+id;
    }

}
