package com.haoxuer.haodian.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haoxuer.haodian.data.service.ShopService;
import com.haoxuer.haodian.actions.front.TimeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.Shop;

@Controller
@RequestMapping(value = "admin")
public class ShopManagerAction {

    @Autowired
    ShopService shopService;

    Logger logger = LoggerFactory.getLogger("log");
    int aid = 0;

    @RequestMapping(value = "shop/list", method = RequestMethod.GET)
    public String list(
            @RequestParam(value = "id", required = true, defaultValue = "1") int id,
            @RequestParam(value = "sorttype", required = true, defaultValue = "1") int sorttype,
            @RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
            @RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
            HttpServletRequest request, HttpServletResponse response,
            Model model) {

        Pagination rs = shopService.page(curpage, pagesize);

        model.addAttribute("list", rs.getList());
        model.addAttribute("page", rs);
        model.addAttribute("curpage", rs.getPageNo());
        model.addAttribute("pagesize", rs.getPageSize());

        return "admin/shop/list";
    }

    @RequestMapping(value = "shop/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request,
                        HttpServletResponse response, Model model) {
        return "admin/shop/index";
    }

    @RequestMapping(value = "shop/view_add", method = RequestMethod.GET)
    public String view_add(HttpServletRequest request, Long pid,
                           HttpServletResponse response, Model model) {
        Shop item = shopService.findById(pid);
        model.addAttribute("item", item);
        return "admin/shop/view_add";
    }

    @RequestMapping(value = "shop/model_add", method = RequestMethod.POST)
    public String model_add(Shop menu, HttpServletRequest request,
                            HttpServletResponse response, Model model) {

        shopService.save(menu);

        return "redirect:/admin/shop/list.htm";
    }

    @RequestMapping(value = "shop/view_update", method = RequestMethod.GET)
    public String view_update(HttpServletRequest request,Long id, HttpServletResponse response, Model model) {

        model.addAttribute("shop",shopService.findById(id));
        model.addAttribute("maxtimes", TimeVo.times(1, 62));
        model.addAttribute("mintimes", TimeVo.times(0, 48));


        return "admin/shop/view_update";
    }

    @RequestMapping(value = "shop/model_update", method = RequestMethod.POST)
    public String model_update(Shop shop,
                               HttpServletRequest request, HttpServletResponse response,
                               Model model) {
        shop.setTimes(null);
        shop.setTags(null);
        shop.setCategorys(null);
        model.addAttribute("shop", shopService.update(shop));
        model.addAttribute("msg","更新成功");
        return "redirect:/admin/shop/view_update.htm?id="+shop.getId();
    }

    @RequestMapping(value = "shop/model_delete", method = RequestMethod.GET)
    public String model_delete(Long typeid, int curpage, HttpServletRequest request,
                               HttpServletResponse response, Model model) {
        try {
            shopService.deleteById(typeid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/admin/shop/list.htm?curpage=" + curpage;
    }

    private HttpSession getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            logger.info("会话不存在");
            session = request.getSession(true);
        }
        return session;
    }

}
