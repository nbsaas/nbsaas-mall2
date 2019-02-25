package com.haoxuer.haodian.actions.admin;

import com.haoxuer.haodian.data.entity.EventInfoCategory;
import com.haoxuer.haodian.data.entity.EventInfoComment;
import com.haoxuer.haodian.data.service.EventInfoCategoryService;
import com.haoxuer.haodian.data.service.EventInfoCommentService;
import com.haoxuer.discover.data.core.Pagination;
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

@Controller("EventInfoCommentAdminAction")
@RequestMapping(value = "admin")
public class EventInfoCommentAction implements Serializable {


    @Autowired
    EventInfoCommentService commentService;


    @Autowired
    EventInfoCategoryService eventInfoCatalogService;

    @RequestMapping(value = "eventcomment/list", method = RequestMethod.GET)
    public String list(
            @RequestParam(value = "id", required = true, defaultValue = "1") int id,
            @RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
            @RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
            HttpServletRequest request, HttpServletResponse response,
            Model model) {

        Pagination rs = commentService.getPage(curpage, pagesize);

        model.addAttribute("list", rs.getList());
        model.addAttribute("id", id);
        model.addAttribute("page", rs);
        model.addAttribute("curpage", curpage);
        model.addAttribute("pagesize", pagesize);

        return "admin/eventcomment/list";
    }

    @RequestMapping(value = "eventcomment/model_add", method = RequestMethod.POST)
    public String model_add(EventInfoComment eventinfo, HttpServletRequest request,
                            HttpServletResponse response, Model model) {
        try {
            commentService.save(eventinfo);
            return "redirect:/admin/eventcomment/list.htm";
        } catch (Exception e) {
            e.printStackTrace();
            return "/admin/eventcomment/eventcomment/view_add";
        }

    }

    @RequestMapping(value = "eventcomment/model_update", method = RequestMethod.POST)
    public String model_update(EventInfoComment eventinfo, HttpServletRequest request,
                               HttpServletResponse response, Model model) {
        try {
            commentService.update(eventinfo);
            return "redirect:/admin/eventcomment/list.htm";
        } catch (Exception e) {
            e.printStackTrace();
            return "/admin/eventcomment/eventcomment/view_add";
        }

    }

    @RequestMapping(value = "eventcomment/model_delete", method = RequestMethod.GET)
    public String model_delete(
            long id,
            @RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
            HttpServletRequest request, HttpServletResponse response,
            Model model) {

        commentService.deleteById(id);

        return "redirect:/admin/eventcomment/list.htm?curpage="+curpage;
    }

    @RequestMapping(value = "eventcomment/view_add", method = RequestMethod.GET)
    public String view_add(HttpServletRequest request,
                           HttpServletResponse response, Model model) {

        List<EventInfoCategory> cs=	eventInfoCatalogService.findByPid(1);
        model.addAttribute("list", cs);
        return "/admin/eventcomment/eventcomment/view_add";
    }
    @RequestMapping(value = "eventcomment/view_view", method = RequestMethod.GET)
    public String view_view(HttpServletRequest request,
                           HttpServletResponse response, Model model) {

        List<EventInfoCategory> cs=	eventInfoCatalogService.findByPid(1);
        model.addAttribute("list", cs);
        return "/admin/eventcomment/eventcomment/view_view";
    }

    @RequestMapping(value = "eventcomment/view_update", method = RequestMethod.GET)
    public String view_update(long id,HttpServletRequest request,
                              HttpServletResponse response, Model model) {
        List<EventInfoCategory> cs=	eventInfoCatalogService.findByPid(1);
        model.addAttribute("list", cs);
        EventInfoComment eventinfo= commentService.findById(id);
        model.addAttribute("info", eventinfo);


        return "/admin/eventcomment/eventcomment/view_update";
    }

}
