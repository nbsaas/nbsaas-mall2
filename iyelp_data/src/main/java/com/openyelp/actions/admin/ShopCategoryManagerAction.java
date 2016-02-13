package com.openyelp.actions.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openyelp.data.entity.EventInfoCategory;
import com.openyelp.data.entity.ShopCategory;
import com.openyelp.data.service.ShopCategoryService;

@Controller
@RequestMapping(value = "admin")
public class ShopCategoryManagerAction {

    @Autowired
    ShopCategoryService menuService;

    Logger logger = LoggerFactory.getLogger("log");
    int aid = 0;

    @RequestMapping(value = "shopcategory/list", method = RequestMethod.GET)
    public String list(
            @RequestParam(value = "id", required = true, defaultValue = "1") int id,
            HttpServletRequest request, HttpServletResponse response,
            Model model) {

        List<ShopCategory> rs = menuService.findByPid(id);

        model.addAttribute("list", rs);
        model.addAttribute("id", id);
        model.addAttribute("courseitem", menuService.findById(id));
        model.addAttribute("menus", menuService.findByPid(1));

        return "admin/shopcategory/list";
    }

    @RequestMapping(value = "shopcategory/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request,
                        HttpServletResponse response, Model model) {
        return "admin/shopcategory/index";
    }

    @RequestMapping(value = "shopcategory/view_add", method = RequestMethod.GET)
    public String view_add(HttpServletRequest request, int pid,
                           HttpServletResponse response, Model model) {
        ShopCategory item = menuService.findById(pid);
        model.addAttribute("item", item);
        return "admin/shopcategory/view_add";
    }

    @RequestMapping(value = "shopcategory/model_add", method = RequestMethod.POST)
    public String model_add(ShopCategory menu, HttpServletRequest request,
                            HttpServletResponse response, Model model) {

        menuService.save(menu);

        return "redirect:/admin/shopcategory/list.htm?id=" + menu.getParentId();
    }

    @RequestMapping(value = "shopcategory/view_update", method = RequestMethod.GET)
    public String view_update(HttpServletRequest request, Integer id,
                              HttpServletResponse response, Model model) {
        ShopCategory item = menuService.findById(id);
        model.addAttribute("item", item);
        return "admin/shopcategory/view_update";
    }

    @RequestMapping(value = "shopcategory/model_update", method = RequestMethod.POST)
    public String model_update(ShopCategory menu,
                               HttpServletRequest request, HttpServletResponse response,
                               Model model) {

        menuService.update(menu);
        menu = menuService.findById(menu.getId());
        return "redirect:/admin/shopcategory/list.htm?id=" + menu.getParentId();
    }

    @RequestMapping(value = "shopcategory/model_delete", method = RequestMethod.GET)
    public String model_delete(int typeid, HttpServletRequest request,
                               HttpServletResponse response, Model model) {

        ShopCategory m = menuService.findById(typeid);
        Integer id = m.getParentId();
        try {
            menuService.deleteById(typeid);
        } catch (Exception e) {
            model.addAttribute("msg", "删除失败，请先删除他的子节点！");
        }
        return list(id, request, response, model);
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
