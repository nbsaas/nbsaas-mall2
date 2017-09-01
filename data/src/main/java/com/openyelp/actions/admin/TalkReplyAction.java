package com.openyelp.actions.admin;



import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.openyelp.data.entity.TalkReply;
import com.openyelp.data.service.TalkReplyService;
@Controller
public class TalkReplyAction {
	private static final Logger log = LoggerFactory.getLogger(TalkReplyAction.class);

	@RequestMapping("/admin/talkreply/view_list")
	public String list(Pageable pageable, HttpServletRequest request, ModelMap model) {
	
		if (pageable==null) {
			pageable=new Pageable();
		}
		if (pageable.getOrders()==null||pageable.getOrders().size()==0) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Page<TalkReply> pagination = manager.findPage(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return "admin/talkreply/list";
	}

	@RequestMapping("/admin/talkreply/view_add")
	public String add(ModelMap model) {
		return "admin/talkreply/add";
	}

	@RequestMapping("/admin/talkreply/view_edit")
	public String edit(Pageable pageable,Integer id, Integer pageNo, HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("page", pageable);
		return "admin/talkreply/edit";
	}

	@RequestMapping("/admin/talkreply/model_save")
	public String save(TalkReply bean, HttpServletRequest request, ModelMap model) {
		bean = manager.save(bean);
		log.info("save Teacher id={}", bean.getId());
		return "redirect:view_list.htm";
	}

	@RequestMapping("/admin/talkreply/model_update")
	public String update(Pageable pageable, TalkReply bean,HttpServletRequest request, ModelMap model) {
		bean = manager.update(bean);
		log.info("update Teacher id={}.", bean.getId());
		return "redirect:/admin/talkreply/view_list.htm?pageNumber="+pageable.getPageNumber();
	}

	@RequestMapping("/admin/talkreply/model_delete")
	public String delete(Pageable pageable, Integer id, HttpServletRequest request, ModelMap model) {
			 
				manager.deleteById(id);
			 
		return "redirect:/admin/talkreply/view_list.htm?pageNumber="+pageable.getPageNumber();
	}
	@RequestMapping("/admin/talkreply/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids, HttpServletRequest request, ModelMap model) {
			 
				manager.deleteByIds(ids);
			 
		return "redirect:/admin/talkreply/view_list.htm?pageNumber="+pageable.getPageNumber();
	}
	@Autowired
	private TalkReplyService manager;
}