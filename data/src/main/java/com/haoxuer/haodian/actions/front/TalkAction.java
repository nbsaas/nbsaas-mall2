package com.haoxuer.haodian.actions.front;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haoxuer.haodian.data.entity.Talk;
import com.haoxuer.haodian.data.entity.TalkCategory;
import com.haoxuer.haodian.data.entity.TalkReply;
import com.haoxuer.haodian.data.service.TalkCategoryService;
import com.haoxuer.haodian.data.service.TalkReplyService;
import com.haoxuer.haodian.data.service.TalkService;
import com.haoxuer.haodian.shiro.utils.UserUtil;
import com.haoxuer.haodian.web.utils.FrontUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.common.action.BaseAction;
import com.haoxuer.discover.data.core.Pagination;

@Controller
public class TalkAction extends BaseAction {

	@Autowired
  TalkService talkService;

	@Autowired
  TalkCategoryService talkCategoryService;
	
	
	@RequiresUser
	@RequestMapping(value = "talk/new_topic", method = RequestMethod.GET)
	public String events(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		List<TalkCategory> as=	talkCategoryService.findByPid(1);
		List<TalkCategory> a1 = new ArrayList<TalkCategory>();
		List<TalkCategory> a2 = new ArrayList<TalkCategory>();
		if (as != null && as.size() > 0) {
			for (int i = 0; i < as.size(); i++) {
				if (i > 0) {

					if (i % 2 == 0) {
						a1.add(as.get(i));
					}
					if (i % 2 == 1) {
						a2.add(as.get(i));
					}

				} else if (i == 0) {
					a1.add(as.get(i));
				}
			}

		}
		model.addAttribute("categorys1", a1);
		model.addAttribute("categorys2", a2);
		
		return getView("talk/new_topic");
	}

	@RequestMapping(value = "talk", method = RequestMethod.GET)
	public String talk(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "category", required = true, defaultValue = "-1") int category,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = talkService.findByCity(UserUtil.getCurrentCity()
				.getId(), category, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("category", category);
		model.addAttribute("pagesize", pagesize);
		
		
		model.addAttribute("siteindex", 6);

		return getView("talk");
	}

	@RequiresUser
	@RequestMapping(value = "mytalk", method = RequestMethod.GET)
	public String mytalk(
			@RequestParam(value = "id", required = true, defaultValue = "100") int id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "category", required = true, defaultValue = "-2") int category,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = talkService.findByCity(UserUtil.getCurrentCity()
				.getId(), category, UserUtil.getCurrentUser().getId(), curpage,
				pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("category", category);

		model.addAttribute("id", id);
		model.addAttribute("pagesize", pagesize);
		return getView("mytalk");
	}

	@RequiresUser
	@RequestMapping(value = "talk/talk", method = RequestMethod.POST)
	public String talk(HttpServletRequest request, Talk talk, int category,
                     String location, HttpServletResponse response, Model model) {
		// UserUtil
		talk.setAdddate(new Date());
		talk.setUser(UserUtil.getCurrentUser());
		talk = talkService.add(talk, category, location);
		if (talk.getId() > 0) {
			return FrontUtils.redirect("topic.htm?id=" + talk.getId());

		} else {
			model.addAttribute("msg", "请选择城市");
			return getView("talk/new_topic");

		}
	}

	@Autowired
  TalkReplyService talkReplyService;

	@RequiresUser
	@RequestMapping(value = "talk/create_reply", method = RequestMethod.POST)
	public String create_reply(HttpServletRequest request, TalkReply talkReply,
			int category, String location, HttpServletResponse response,
			Model model) {
		// UserUtil
		talkReply.setAdddate(new Date());
		talkReply.setUser(UserUtil.getCurrentUser());
		talkReply = talkReplyService.save(talkReply);
		if (talkReply.getId() > 0) {
			return FrontUtils.redirect("topic.htm?id="
					+ talkReply.getTalk().getId());
		} else {
			model.addAttribute("msg", "请选择城市");
			return getView("talk/new_topic");

		}
	}

	@RequestMapping(value = "talk/topic", method = RequestMethod.GET)
	public String topic(
			HttpServletRequest request,
			Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			@RequestParam(value = "category", required = true, defaultValue = "-1") int category,
			HttpServletResponse response, Model model) {
		Talk talk = talkService.findById(id);
		model.addAttribute("item", talk);
		model.addAttribute("category", category);
		Pagination rs = talkReplyService.pageByTalk(id, curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("category", category);

		model.addAttribute("id", id);
		model.addAttribute("pagesize", pagesize);
		return getView("talk/topic");
	}
	@RequestMapping(value = "talk/flag", method = RequestMethod.GET)
	public String flag(
			HttpServletRequest request,
			Integer id,Integer state,
			HttpServletResponse response, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("state", state);

		return getView("talk/flag");
	}
	@RequestMapping(value = "talk/flagsubmit", method = {RequestMethod.GET,RequestMethod.POST})
	public String flagsumbit(
			HttpServletRequest request,
			Integer id,Integer state,String messages,String type,
			HttpServletResponse response, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("state", state);
       if(state==1){
   		return redirect("/talk/topic.htm?id="+id);

       }else{
   		return redirect("/talk/topic.htm?id="+id);

       }
	}

}
