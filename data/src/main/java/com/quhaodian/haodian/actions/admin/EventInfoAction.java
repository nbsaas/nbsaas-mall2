package com.quhaodian.haodian.actions.admin;

import com.quhaodian.haodian.data.entity.EventInfoCategory;
import com.quhaodian.haodian.data.service.EventInfoCategoryService;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.EventInfo;
import com.quhaodian.haodian.data.service.EventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 年高 on 2015/11/15.
 */

@Controller("EventInfoAdminAction")
@RequestMapping(value = "admin")
public class EventInfoAction implements Serializable {


    @Autowired
    EventInfoService eventInfoService;


    @Autowired
    EventInfoCategoryService eventInfoCatalogService;

    @RequestMapping(value = "eventinfo/list", method = RequestMethod.GET)
    public String list(
            @RequestParam(value = "id", required = true, defaultValue = "1") int id,
            @RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
            @RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
            HttpServletRequest request, HttpServletResponse response,
            Model model) {

        Pagination rs = eventInfoService.getPage(curpage, pagesize);

        model.addAttribute("list", rs.getList());
        model.addAttribute("id", id);
        model.addAttribute("page", rs);
        model.addAttribute("curpage", curpage);
        model.addAttribute("pagesize", pagesize);

        return "admin/eventinfo/list";
    }

    @RequestMapping(value = "eventinfo/model_add", method = RequestMethod.POST)
    public String model_add(EventInfo eventinfo, HttpServletRequest request,
                            HttpServletResponse response, Model model) {
        try {
            eventInfoService.save(eventinfo);
            return "redirect:/admin/eventinfo/list.htm";
        } catch (Exception e) {
            e.printStackTrace();
            return "/admin/eventinfo/eventinfo/view_add";
        }

    }

    @RequestMapping(value = "eventinfo/model_update", method = RequestMethod.POST)
    public String model_update(EventInfo eventinfo, HttpServletRequest request,
                               HttpServletResponse response, Model model) {
        try {
            eventInfoService.update(eventinfo);
            return "redirect:/admin/eventinfo/list.htm";
        } catch (Exception e) {
            e.printStackTrace();
            return "/admin/eventinfo/eventinfo/view_add";
        }

    }

    @RequestMapping(value = "eventinfo/model_delete", method = RequestMethod.GET)
    public String model_delete(
            long id,
            @RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
            HttpServletRequest request, HttpServletResponse response,
            Model model) {

        eventInfoService.deleteById(id);

        return "redirect:/admin/eventinfo/list.htm?curpage="+curpage;
    }

    @RequestMapping(value = "eventinfo/view_add", method = RequestMethod.GET)
    public String view_add(HttpServletRequest request,
                           HttpServletResponse response, Model model) {

        List<EventInfoCategory> cs=	eventInfoCatalogService.findByPid(1);
        model.addAttribute("list", cs);
        return "/admin/eventinfo/eventinfo/view_add";
    }

    @RequestMapping(value = "eventinfo/view_view", method = RequestMethod.GET)
    public String view_view(Long id,HttpServletRequest request,
                           HttpServletResponse response, Model model) {

        model.addAttribute("eventinfo", eventInfoService.findById(id));
        return "/admin/eventinfo/view_view";
    }


    @RequestMapping(value = "eventinfo/view_update", method = RequestMethod.GET)
    public String view_update(long id,HttpServletRequest request,
                              HttpServletResponse response, Model model) {
        List<EventInfoCategory> cs=	eventInfoCatalogService.findByPid(1);
        model.addAttribute("list", cs);
        EventInfo eventinfo= eventInfoService.findById(id);
        model.addAttribute("info", eventinfo);


        return "/admin/eventinfo/eventinfo/view_update";
    }

}
